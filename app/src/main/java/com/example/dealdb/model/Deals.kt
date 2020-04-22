package com.example.dealdb.model


import com.google.gson.annotations.SerializedName

data class Deals(
    @SerializedName("offers")
    val offers: List<Offer>,
    @SerializedName("result")
    val result: Boolean
)