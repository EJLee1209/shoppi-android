package com.dldmswo1209.shoppi_android.ui.common

import android.content.Context
import android.icu.util.ULocale.Category
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dldmswo1209.shoppi_android.AssetLoader
import com.dldmswo1209.shoppi_android.network.ApiClient
import com.dldmswo1209.shoppi_android.repository.*
import com.dldmswo1209.shoppi_android.ui.home.HomeViewModel
import com.dldmswo1209.shoppi_android.ui.category.CategoryViewModel

class ViewModelFactory(private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                val repository = HomeRepository(HomeAssetDataSource(AssetLoader(context)))
                HomeViewModel(repository) as T
            }
            modelClass.isAssignableFrom(CategoryViewModel::class.java) -> {
                val repository = CategoryRepository(CategoryRemoteDataSource(ApiClient.create()))
                CategoryViewModel(repository) as T
            }
            else -> {
                throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
            }
        }
    }
}