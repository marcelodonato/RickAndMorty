package com.example.ebdiandroid.adapter.viewHolders

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.ebdiandroid.adapter.model.CarouselEntity
import com.example.ebdiandroid.databinding.CarouselBannerItemBinding

class CarouselViewHolder(itemView : View) : ViewHolder(itemView) {

    private var binding = CarouselBannerItemBinding.bind(itemView)

    val context: Context = itemView.context

    fun bindWith(item: CarouselEntity ) {
        with(binding) {
           ivBanner.setImageResource(item.image)

        }
    }
}