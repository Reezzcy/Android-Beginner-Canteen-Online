package com.example.fp_kantinonline.data.remote

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataHistory(
    val foodName: String,
    val foodRestaurant: String,
    val foodCount: Int,
    val foodImage: String,
): Parcelable
