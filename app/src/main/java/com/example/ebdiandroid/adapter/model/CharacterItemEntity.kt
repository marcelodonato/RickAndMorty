package com.example.ebdiandroid.adapter.model

import com.example.ebdiandroid.adapter.AdaptableItem
import com.example.ebdiandroid.adapter.RickAndMortyGenericAdapter.Companion.EVENT_ITEM
import java.io.Serializable

data class CharacterItemEntity(
    val image: String? = null,
    val name: String? = null,
    val status: String? = null,
    val species: String? = null
) : Serializable, AdaptableItem {
    override fun itemType() = EVENT_ITEM
}


