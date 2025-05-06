package com.example.ebdiandroid.presentation.fragments

import com.example.ebdiandroid.bases.BaseFragment
import com.example.ebdiandroid.bases.BaseViewModel
import com.example.ebdiandroid.databinding.FragmentFavoritesBinding
import com.example.ebdiandroid.extensions.viewBinding

class FavoritesFragment : BaseFragment<BaseViewModel>() {

    override val binding by viewBinding(FragmentFavoritesBinding::inflate)

    override fun initView() = with(binding) {
        topBar.setupView("Favoritos")
    }

    companion object {
        fun newInstance() = FavoritesFragment()
    }
}