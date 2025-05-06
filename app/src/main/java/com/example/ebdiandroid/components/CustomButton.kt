package com.example.ebdiandroid.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.ebdiandroid.R
import com.example.ebdiandroid.databinding.CustomButtonBinding

class CustomButton : ConstraintLayout {

    private val binding: CustomButtonBinding =
        CustomButtonBinding.inflate(LayoutInflater.from(context), this, true)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )


    fun setupView(buttonTitle: String, color: Int = R.color.black, onClick: () -> Unit) =
        with(binding) {
            tvLabel.text = buttonTitle
            tvLabel.setTextColor(ContextCompat.getColor(root.context, color))
            buttonIcon.setColorFilter(ContextCompat.getColor(root.context, color))
            binding.root.setOnClickListener {
                onClick.invoke()
            }
        }

}