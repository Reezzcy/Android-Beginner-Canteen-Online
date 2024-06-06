package com.example.fp_kantinonline.data.remote

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.ByteArrayOutputStream

@Parcelize
data class DataFoodImageRandom(
    val bitmapImageByteArray: ByteArray?
) : Parcelable {

    // Fungsi untuk mengonversi ByteArray kembali ke Bitmap
    fun getBitmap(): Bitmap? {
        return bitmapImageByteArray?.let { BitmapFactory.decodeByteArray(it, 0, it.size) }
    }

    companion object {
        // Fungsi untuk mengonversi Bitmap ke ByteArray
        fun fromBitmap(bitmap: Bitmap): DataFoodImageRandom {
            val stream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
            return DataFoodImageRandom(stream.toByteArray())
        }
    }
}
