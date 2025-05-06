package com.example.ebdiandroid.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.ebdiandroid.databinding.EbdiFooterBarBinding

class RickAndMortyFooterBar : ConstraintLayout {

    private val binding: EbdiFooterBarBinding =
        EbdiFooterBarBinding.inflate(LayoutInflater.from(context), this, true)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    fun setupView(
        home: () -> Unit,
        events: () -> Unit,
        favorites: () -> Unit,
        profile: () -> Unit
    ) {
        binding.homeButton.setOnClickListener {
            home.invoke()
        }
        binding.eventsButton.setOnClickListener {
            events.invoke()
        }
        binding.favoritesButton.setOnClickListener {
            favorites.invoke()
        }
        binding.profileButton.setOnClickListener {
            profile.invoke()
        }
    }


}