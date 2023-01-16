package com.dldmswo1209.shoppi_android

import com.google.gson.annotations.SerializedName

data class Title(
    val text: String,
    @SerializedName("icon_url") val iconUrl: String
)
