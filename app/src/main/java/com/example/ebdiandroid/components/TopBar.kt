package com.example.ebdiandroid.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.ebdiandroid.databinding.TopBarBinding

class TopBar : ConstraintLayout {

    private val binding: TopBarBinding =
        TopBarBinding.inflate(LayoutInflater.from(context), this, true)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    fun setupView(title: String) {
        binding.tvTitle.text = title
    }
}