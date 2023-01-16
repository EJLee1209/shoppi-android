package com.dldmswo1209.shoppi_android.repository

import com.dldmswo1209.shoppi_android.model.HomeData

interface HomeDataSource {
    fun getHomeData(): HomeData?
}