package com.dldmswo1209.shoppi_android.ui.home

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dldmswo1209.shoppi_android.model.Banner
import com.dldmswo1209.shoppi_android.R
import com.dldmswo1209.shoppi_android.databinding.ItemHomeBannerBinding
import com.dldmswo1209.shoppi_android.ui.common.loadImage
import java.text.DecimalFormat
import kotlin.math.roundToInt

class HomeBannerAdapter: ListAdapter<Banner, HomeBannerAdapter.HomeBannerViewHolder>(
    BannerDiffCallback()
) {
    private lateinit var binding: ItemHomeBannerBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeBannerViewHolder {
        binding = ItemHomeBannerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HomeBannerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeBannerViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    class HomeBannerViewHolder(private val binding: ItemHomeBannerBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(banner: Banner){
            binding.banner = banner
            binding.executePendingBindings()
        }

    }
}

class BannerDiffCallback: DiffUtil.ItemCallback<Banner>(){
    override fun areItemsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem.productDetail.productId == newItem.productDetail.productId
    }

    override fun areContentsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem == newItem
    }

}