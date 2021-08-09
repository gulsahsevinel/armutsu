package com.gulsah.armutsu.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.gulsah.armutsu.model.Home
import com.gulsah.armutsu.model.Posts
import com.gulsah.armutsu.model.Services
import com.gulsah.armutsu.retrofit.ApiUtils
import com.gulsah.armutsu.retrofit.HomeDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeRepo {

    private val hdaoi: HomeDaoInterface
    private val allServicesList: MutableLiveData<List<Services>>
    private val popularServiceslist: MutableLiveData<List<Services>>
    private val postsList: MutableLiveData<List<Posts>>

    init {
        allServicesList = MutableLiveData()
        popularServiceslist = MutableLiveData()
        postsList = MutableLiveData()
        hdaoi = ApiUtils.getHome()
    }

    fun getAllServicesList(): MutableLiveData<List<Services>> {
        return allServicesList
    }

    fun getPopularist(): MutableLiveData<List<Services>> {
        return popularServiceslist
    }
    fun getPostsList(): MutableLiveData<List<Posts>> {
        return postsList
    }

    fun getAllServices() {
        hdaoi.home().enqueue(object : Callback<Home> {
            override fun onResponse(call: Call<Home>, response: Response<Home>) {
                val listServices = response.body()!!.allServicesList
                for (k: Services in listServices) {
                    Log.e("services", k.toString())
                }
                allServicesList.value = response.body()!!.allServicesList
            }

            override fun onFailure(call: Call<Home>, t: Throwable) {
                Log.e("onFailure", "fail")
            }

        })

    }

    fun getPopularServices() {
        hdaoi.home().enqueue(object : Callback<Home> {
            override fun onResponse(call: Call<Home>, response: Response<Home>) {
                popularServiceslist.value = response.body()!!.popularList
            }
            override fun onFailure(call: Call<Home>, t: Throwable) {
                Log.e("onFailure", "fail")
            }

        })

    }

    fun getPosts() {
        hdaoi.home().enqueue(object : Callback<Home> {
            override fun onResponse(call: Call<Home>, response: Response<Home>) {
                postsList.value = response.body()!!.postsList
            }

            override fun onFailure(call: Call<Home>, t: Throwable) {
                Log.e("onFailure", "fail")
            }

        })

    }
}