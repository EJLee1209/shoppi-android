package com.dldmswo1209.shoppi_android.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dldmswo1209.shoppi_android.AssetLoader
import com.dldmswo1209.shoppi_android.ui.home.HomeViewModel
import com.dldmswo1209.shoppi_android.repository.HomeAssetDataSource
import com.dldmswo1209.shoppi_android.repository.HomeRepository

class ViewModelFactory(private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeViewModel::class.java)){
            val repository = HomeRepository(HomeAssetDataSource(AssetLoader(context)))
            return HomeViewModel(repository) as T
        }else{
            throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
        }
    }
}