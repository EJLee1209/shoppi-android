package com.dldmswo1209.shoppi_android.repository

import com.dldmswo1209.shoppi_android.model.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CategoryRepository(
    private val remoteDataSource: CategoryRemoteDataSource
) {
    suspend fun getCategories(): List<Category>{
        return remoteDataSource.getCategories()
    }
}