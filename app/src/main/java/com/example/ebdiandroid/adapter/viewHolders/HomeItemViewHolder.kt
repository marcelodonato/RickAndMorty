package com.example.ebdiandroid.adapter.viewHolders

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.ebdiandroid.adapter.RickAndMortyGenericAdapter
import com.example.ebdiandroid.adapter.model.HomeListEntity
import com.example.ebdiandroid.databinding.HomeItemListBinding

class HomeItemViewHolder(itemView: View) : ViewHolder(itemView) {
    val binding = HomeItemListBinding.bind(itemView)

    val context: Context = itemView.context

     fun bindWith(item: HomeListEntity){
         binding.rvItem.apply {
             val adapterItem  = RickAndMortyGenericAdapter()
             adapterItem.items = item.itemList
             adapter = adapterItem
         }
         binding.tvLabel.text = item.title
     }
}