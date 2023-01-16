package com.dldmswo1209.shoppi_android.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.dldmswo1209.shoppi_android.R
import com.dldmswo1209.shoppi_android.ui.common.ViewModelFactory
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment: Fragment() {
    private val viewModel: HomeViewModel by viewModels { ViewModelFactory(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbarTitle = view.findViewById<TextView>(R.id.toolbar_home_title)
        val toolbarIcon = view.findViewById<ImageView>(R.id.toolbar_home_icon)
        val viewPager = view.findViewById<ViewPager2>(R.id.viewpager_home_banner)
        val viewPagerIndicator = view.findViewById<TabLayout>(R.id.viewpager_home_banner_indicator)

        viewModel.title.observe(viewLifecycleOwner){ title->
            toolbarTitle.text = title.text
            Glide.with(this)
                .load(title.iconUrl)
                .into(toolbarIcon)
        }

        viewPager.adapter = HomeBannerAdapter().apply {
            viewModel.topBanners.observe(viewLifecycleOwner){
                submitList(it)
            }
        }

        val pageWidth = resources.getDimension(R.dimen.viewpager_item_width)
        val pageMargin = resources.getDimension(R.dimen.viewpager_item_margin)
        val screenWidth = resources.displayMetrics.widthPixels
        val offset = screenWidth - pageWidth - pageMargin

        viewPager.offscreenPageLimit = 3
        viewPager.setPageTransformer { page, position ->
            page.translationX = position * -offset
        }
        TabLayoutMediator(viewPagerIndicator, viewPager) { tab, position ->

        }.attach()

    }
}