package com.example.ebdiandroid.adapter.viewHolders

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.ebdiandroid.R
import com.example.ebdiandroid.adapter.model.CharacterItemEntity
import com.example.ebdiandroid.databinding.EventItemBinding

class CharacterItemViewHolder(itemView: View) : ViewHolder(itemView) {
    private var binding = EventItemBinding.bind(itemView)

    fun bindWith(item: CharacterItemEntity) {
        with(binding) {
            Glide.with(ivEventCard.context).load(item.image.orEmpty()).into(ivEventCard)
            when(item.species) {
                "Alive" ->{
                    icStatus.setColorFilter(ContextCompat.getColor(root.context, R.color.green))
                }
                "Dead" -> {
                    icStatus.setColorFilter(ContextCompat.getColor(root.context, R.color.red))
                }
                else -> {
                    icStatus.setColorFilter(ContextCompat.getColor(root.context, R.color.black))
                }
            }
            tvEventName.text = item.name
            tvStatus.text = item.species
            tvType.text = item.status

        }
    }
}