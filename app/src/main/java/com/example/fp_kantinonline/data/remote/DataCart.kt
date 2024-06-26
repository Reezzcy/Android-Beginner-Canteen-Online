package com.example.fp_kantinonline.data.remote

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataCart(
    val foodName: String,
    val restaurant: String,
    val foodCount: Int,
    val foodImage: String
) : Parcelable
