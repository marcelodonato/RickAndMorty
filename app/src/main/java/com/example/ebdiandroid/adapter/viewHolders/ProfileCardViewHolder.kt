package com.example.ebdiandroid.adapter.viewHolders

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.ebdiandroid.adapter.model.ProfileCardEntity
import com.example.ebdiandroid.databinding.ProfileCardItemBinding

class ProfileCardViewHolder(itemView: View) : ViewHolder(itemView) {
    private var binding = ProfileCardItemBinding.bind(itemView)

    val context: Context = itemView.context

    fun bindWith(item: ProfileCardEntity) {
        with(binding) {
            tvProfileName.text = item.profileName
            Glide.with(ivProfileCard.context).load(item.profileImage.orEmpty()).into(ivProfileCard)
        }
    }

}