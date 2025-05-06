package com.example.ebdiandroid.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.ebdiandroid.databinding.ProfileCardItemBinding

class ProfileCardItem : ConstraintLayout {

    private val binding: ProfileCardItemBinding =
        ProfileCardItemBinding.inflate(LayoutInflater.from(context), this, true)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

}