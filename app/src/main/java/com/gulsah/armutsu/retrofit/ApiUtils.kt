package com.gulsah.armutsu.retrofit

class ApiUtils {
    companion object {
        val BASE_URL = "https://my-json-server.typicode.com/engincancan/case/"
        fun getHome(): HomeDaoInterface {
            return RetrofitClient.getClient(BASE_URL).create(HomeDaoInterface::class.java)
        }
    }
}