package com.dldmswo1209.shoppi_android.repository

import com.dldmswo1209.shoppi_android.model.Category

interface CategoryDataSource {
    suspend fun getCategories(): List<Category>
}