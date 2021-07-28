package com.gulsah.armutsu.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Home(
    @SerializedName("all_services")
    @Expose
    var allServices: List<Services>,
    @SerializedName("posts")
    @Expose
    var posts: List<Posts>
) {
}