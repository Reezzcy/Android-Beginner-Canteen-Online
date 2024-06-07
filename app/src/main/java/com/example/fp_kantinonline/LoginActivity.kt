package com.example.fp_kantinonline

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.fp_kantinonline.databinding.ActivityLoginBinding
import com.example.fp_kantinonline.ui.home.HomeActivity
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with (binding) {
            buttonMain.setOnClickListener {
                val username = etUsername.text.toString()
                val password = etPassword.text.toString()

                if (username.isEmpty() || password.isEmpty()) {
                    Snackbar.make(
                        binding.root,
                        "Username dan Password harus diisi!",
                        Snackbar.LENGTH_SHORT
                    ).show()
                } else {
                    val moveHome = Intent(this@LoginActivity, HomeActivity::class.java)
                    moveHome.putExtra("name", username)
                    startActivity(moveHome)
                }
            }
        }
    }
}