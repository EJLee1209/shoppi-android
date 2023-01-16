package com.dldmswo1209.shoppi_android.repository

import com.dldmswo1209.shoppi_android.model.HomeData

class HomeRepository(
    private val assetDataSource: HomeAssetDataSource
) {

    fun getHomeData(): HomeData? {
        return assetDataSource.getHomeData()
    }

}