package com.example.fp_kantinonline.data.remote

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataIconDashboard(
    val foodName: String,
    val foodImage: String
): Parcelable
