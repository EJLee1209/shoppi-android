package com.dldmswo1209.shoppi_android.repository

import com.dldmswo1209.shoppi_android.AssetLoader
import com.dldmswo1209.shoppi_android.model.HomeData
import com.google.gson.Gson

class HomeAssetDataSource(private val assetLoader: AssetLoader): HomeDataSource {
    private val gson = Gson()

    override fun getHomeData(): HomeData? {
        return assetLoader.getJsonString("home.json")?.let { homeJsonString->
            gson.fromJson(homeJsonString, HomeData::class.java)
        }
    }
}