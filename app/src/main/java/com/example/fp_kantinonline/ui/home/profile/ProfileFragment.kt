package com.example.fp_kantinonline.ui.home.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fp_kantinonline.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
//    private val args: ProfileFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        val bundle = arguments
        val message = bundle!!.getString("name")
        binding.tvName.text = message

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val nameUser.args = arguments?.getString("nama")

//        val nameUser = args.name
//        Log.d("ProfileFragment", "Name: $nameUser")

        with (binding) {
//            tvName.text = nameUser ?: "Username not found"
            buttonLogout.setOnClickListener{
                activity?.finishAffinity()
            }
        }
    }
}