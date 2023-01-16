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
import java.text.DecimalFormat
import kotlin.math.roundToInt

class HomeBannerAdapter: ListAdapter<Banner, HomeBannerAdapter.HomeBannerViewHolder>(
    BannerDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeBannerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_banner, parent, false)
        return HomeBannerViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeBannerViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    class HomeBannerViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val bannerImageView = view.findViewById<ImageView>(R.id.iv_banner_image)
        private val bannerBadge = view.findViewById<TextView>(R.id.tv_banner_badge)
        private val bannerTitle = view.findViewById<TextView>(R.id.tv_banner_title)
        private val bannerDetailThumbnailImageView = view.findViewById<ImageView>(R.id.iv_banner_detail_thumbnail)
        private val bannerDetailBrandLabel = view.findViewById<TextView>(R.id.tv_banner_detail_brand_label)
        private val bannerDetailProductLabel = view.findViewById<TextView>(R.id.tv_banner_detail_product_label)
        private val bannerDetailProductDiscountRate = view.findViewById<TextView>(R.id.tv_banner_detail_product_discount_rate)
        private val bannerDetailProductDiscountPrice = view.findViewById<TextView>(R.id.tv_banner_detail_product_discount_price)
        private val bannerDetailProductPrice = view.findViewById<TextView>(R.id.tv_banner_detail_product_price)

        fun bind(banner: Banner){
            loadImage(banner.backgroundImageUrl, bannerImageView)
            loadImage(banner.productDetail.thumbnailImageUrl, bannerDetailThumbnailImageView)
            bannerBadge.text = banner.badge.label
            bannerBadge.background = ColorDrawable(Color.parseColor(banner.badge.backgroundColor))
            bannerTitle.text = banner.label
            bannerDetailBrandLabel.text = banner.productDetail.brandName
            bannerDetailProductLabel.text = banner.productDetail.label
            bannerDetailProductDiscountRate.text = "${banner.productDetail.discountRate}%"
            calculateDiscountAmount(bannerDetailProductDiscountPrice ,banner.productDetail.discountRate, banner.productDetail.price)
            applyPriceFormat(bannerDetailProductPrice, banner.productDetail.price)
        }

        private fun calculateDiscountAmount(view: TextView,discountRate: Int, price: Int) {
            val discountPrice = (((100 - discountRate) / 100.0) * price).roundToInt()
            applyPriceFormat(view, discountPrice)
        }

        private fun applyPriceFormat(view: TextView, price: Int){
            val decimalFormat = DecimalFormat("#,###")
            view.text = decimalFormat.format(price) + "원"
        }

        private fun loadImage(urlString: String, imageView: ImageView){
            Glide.with(itemView)
                .load(urlString)
                .into(imageView)
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