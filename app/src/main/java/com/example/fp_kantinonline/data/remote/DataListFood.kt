package com.example.fp_kantinonline.data.remote

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataListFood(
    val foodName: String,
    val foodImage: DataFoodImageRandom
): Parcelable