package com.gulsah.armutsu.retrofit

import com.gulsah.armutsu.model.Home
import retrofit2.Call
import retrofit2.http.GET

interface HomeDaoInterface {
    @GET("home")
    fun home(): Call<Home>
}