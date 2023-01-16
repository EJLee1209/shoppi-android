package com.dldmswo1209.shoppi_android.repository

import com.dldmswo1209.shoppi_android.model.Category
import com.dldmswo1209.shoppi_android.network.ApiClient

class CategoryRemoteDataSource(private val apiClient: ApiClient): CategoryDataSource {
    override suspend fun getCategories(): List<Category> {
        return apiClient.getCategories()
    }
}