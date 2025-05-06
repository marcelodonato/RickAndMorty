package com.example.ebdiandroid.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.ebdiandroid.R
import com.example.ebdiandroid.adapter.model.CarouselEntity
import com.example.ebdiandroid.adapter.model.CharacterItemEntity
import com.example.ebdiandroid.adapter.model.CharacterFilterEntity
import com.example.ebdiandroid.adapter.model.HomeListEntity
import com.example.ebdiandroid.adapter.model.ProfileCardEntity
import com.example.ebdiandroid.adapter.viewHolders.CarouselViewHolder
import com.example.ebdiandroid.adapter.viewHolders.CharacterFilterViewHolder
import com.example.ebdiandroid.adapter.viewHolders.CharacterItemViewHolder
import com.example.ebdiandroid.adapter.viewHolders.HomeItemViewHolder
import com.example.ebdiandroid.adapter.viewHolders.ProfileCardViewHolder
import com.example.ebdiandroid.components.CarouselBannerItem
import com.example.ebdiandroid.components.CharacterItem
import com.example.ebdiandroid.components.HomeItemList
import com.example.ebdiandroid.components.ProfileCardItem

class RickAndMortyGenericAdapter(var clickListener: (AdaptableItem) -> Unit = {}) :
    Adapter<ViewHolder>() {

    var items: List<AdaptableItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            USERS_CARD -> ProfileCardViewHolder(ProfileCardItem(inflater.context))
            CAROUSEL_BANNER -> CarouselViewHolder(CarouselBannerItem(inflater.context))
            EVENT_ITEM -> CharacterItemViewHolder(CharacterItem(inflater.context))
            EVENT_FILTER -> CharacterFilterViewHolder(
                inflater.inflate(
                    R.layout.events_filter_item,
                    parent,
                    false
                )
            )
            HOME_ITEM -> HomeItemViewHolder(HomeItemList(inflater.context))


            else -> throw NullPointerException("Should not create adapter without a determined viewType")
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        when (holder) {
            is ProfileCardViewHolder -> holder.bindWith(item as ProfileCardEntity)
            is CarouselViewHolder -> holder.bindWith(item as CarouselEntity)
            is CharacterItemViewHolder -> holder.bindWith(item as CharacterItemEntity)
            is CharacterFilterViewHolder -> holder.bindWith(item as CharacterFilterEntity, clickListener)
            is HomeItemViewHolder -> holder.bindWith(item as HomeListEntity)

            else -> throw NullPointerException("Error")
        }

    }

    override fun getItemViewType(position: Int) = items[position].itemType()

    override fun getItemCount() = items.size


    override fun onViewAttachedToWindow(holder: ViewHolder) {
        if (holder is ParentMatcher) holder.matchParent()
        super.onViewAttachedToWindow(holder)
    }


    companion object {
        const val USERS_CARD = 0
        const val CAROUSEL_BANNER = 1
        const val EVENT_ITEM = 2
        const val EVENT_FILTER = 3
        const val HOME_ITEM = 4

        interface ParentMatcher {
            fun matchParent()
        }
    }
}