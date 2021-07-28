package com.gulsah.armutsu.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Home(
    @SerializedName("all_services")
    @Expose
    var allServicesList: List<Services>,
    @SerializedName("popular")
    @Expose
    var popularList: List<Services>,
    @SerializedName("posts")
    @Expose
    var postsList: List<Posts>
) {
}