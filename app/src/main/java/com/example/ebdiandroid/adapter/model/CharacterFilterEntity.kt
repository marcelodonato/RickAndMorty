package com.example.ebdiandroid.adapter.model

import com.example.ebdiandroid.adapter.AdaptableItem
import com.example.ebdiandroid.adapter.RickAndMortyGenericAdapter.Companion.EVENT_FILTER

data class CharacterFilterEntity(
    val title: String? = null,
    var isSelected: Boolean = false
) : AdaptableItem {
    override fun itemType() = EVENT_FILTER
}