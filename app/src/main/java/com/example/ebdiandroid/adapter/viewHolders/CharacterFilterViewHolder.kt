package com.example.ebdiandroid.adapter.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.ebdiandroid.R
import com.example.ebdiandroid.adapter.AdaptableItem
import com.example.ebdiandroid.adapter.model.CharacterFilterEntity
import com.example.ebdiandroid.databinding.EventsFilterItemBinding

class CharacterFilterViewHolder(itemView: View) : ViewHolder(itemView) {

    private var binding = EventsFilterItemBinding.bind(itemView)

    fun bindWith(item: CharacterFilterEntity, clickListener: (AdaptableItem) -> Unit) {
        with(binding) {
            tvFilter.text = item.title.orEmpty()

            val context = root.context
            val backgroundColor =
                context.getColor(if (item.isSelected) R.color.black else R.color.white)
            val textColor = context.getColor(if (item.isSelected) R.color.white else R.color.black)

            containerFilter.setCardBackgroundColor(backgroundColor)
            tvFilter.setTextColor(textColor)

            containerFilter.setOnClickListener {
                clickListener.invoke(item)
            }
        }
    }
}
