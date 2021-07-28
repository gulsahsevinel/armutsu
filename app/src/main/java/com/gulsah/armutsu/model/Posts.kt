package com.gulsah.armutsu.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Posts(
    @SerializedName("title")
    @Expose
    var title: String,
    @SerializedName("category")
    @Expose
    var category: String,
    @SerializedName("image_url")
    @Expose
    var imageUrlPosts: String,
    @SerializedName("link")
    @Expose
    var link: String
) {
}