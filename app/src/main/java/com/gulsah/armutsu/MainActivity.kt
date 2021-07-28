package com.gulsah.armutsu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.gulsah.armutsu.model.Home
import com.gulsah.armutsu.model.Services
import com.gulsah.armutsu.retrofit.ApiUtils
import com.gulsah.armutsu.retrofit.HomeDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var hdaoi: HomeDaoInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hdaoi = ApiUtils.getHome()
        getHome()

    }

    fun getHome() {
        hdaoi.home().enqueue(object : Callback<Home> {
            override fun onResponse(call: Call<Home>, response: Response<Home>) {
                var listServices = response.body()!!.allServices
                for (k: Services in listServices) {
                    Log.e("services", k.toString())
                }
            }

            override fun onFailure(call: Call<Home>, t: Throwable) {
                Log.e("onFailure", "fail")
            }

        })

    }
}