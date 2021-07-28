package com.gulsah.armutsu.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Services(
    @SerializedName("id")
    @Expose
    var id: Int,
    @SerializedName("service_id")
    @Expose
    var serviceId: Int,
    @SerializedName("name")
    @Expose
    var name: String,
    @SerializedName("long_name")
    @Expose
    var longName: String,
    @SerializedName("image_url")
    @Expose
    var imageUrlServices: String,
    @SerializedName("pro_count")
    @Expose
    var proCount: Int,
    @SerializedName("average_rating")
    @Expose
    var avgRate: Float,
    @SerializedName("completed_jobs_on_last_month")
    @Expose
    var compJobsLastMonth: Int
) {
}