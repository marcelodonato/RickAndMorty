package com.example.ebdiandroid.adapter.model

import androidx.annotation.DrawableRes
import com.example.ebdiandroid.adapter.AdaptableItem
import com.example.ebdiandroid.adapter.RickAndMortyGenericAdapter.Companion.CAROUSEL_BANNER

data class CarouselEntity(
    @DrawableRes val image: Int
) : AdaptableItem {
    override fun itemType() = CAROUSEL_BANNER
}