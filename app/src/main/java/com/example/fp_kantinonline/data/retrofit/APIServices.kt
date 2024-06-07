package com.example.fp_kantinonline.data.retrofit

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APIServices {
    @GET("images/{food}")
    fun getFoodImageRandom(@Path ("food") food: String): Call<ResponseBody>
}