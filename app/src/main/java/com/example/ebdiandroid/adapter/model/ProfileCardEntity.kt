package com.example.ebdiandroid.adapter.model

import com.example.ebdiandroid.adapter.AdaptableItem
import com.example.ebdiandroid.adapter.RickAndMortyGenericAdapter.Companion.USERS_CARD

data class ProfileCardEntity(
    val profileImage: String?, val profileName: String
) : AdaptableItem {
    override fun itemType() = USERS_CARD
}