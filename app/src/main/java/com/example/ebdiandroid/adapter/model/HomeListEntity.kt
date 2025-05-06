package com.example.ebdiandroid.adapter.model

import com.example.ebdiandroid.adapter.AdaptableItem
import com.example.ebdiandroid.adapter.RickAndMortyGenericAdapter.Companion.HOME_ITEM

data class HomeListEntity(
    val itemList: List<AdaptableItem>, val title: String
) : AdaptableItem {
    override fun itemType() = HOME_ITEM

}