package com.rupesh.testingjunit.data.remote.responses
import com.google.gson.annotations.SerializedName
data class ImageResult(
    @SerializedName("user_id")
    val userId: Int,
    val comments:Int,
    val downLoads: Int,
)