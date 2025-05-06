package com.example.ebdiandroid.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.ebdiandroid.adapter.AdaptableItem
import com.example.ebdiandroid.adapter.RickAndMortyGenericAdapter
import com.example.ebdiandroid.databinding.HomeItemListBinding

class HomeItemList : ConstraintLayout {

    private val binding: HomeItemListBinding =
        HomeItemListBinding.inflate(LayoutInflater.from(context), this, true)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

     fun setupView(label: String, listItem: List<AdaptableItem>) = with(binding) {
        tvLabel.text = label

        rvItem.apply {
            val adapterItem  = RickAndMortyGenericAdapter()
            adapterItem.items = listItem
            adapter = adapterItem
        }
    }
}