package com.example.ebdiandroid.presentation.activities

import android.os.Bundle
import com.example.ebdiandroid.bases.BaseContainerActivity
import com.example.ebdiandroid.bases.BaseViewModel
import com.example.ebdiandroid.presentation.fragments.HomeFragment

class MainActivity : BaseContainerActivity<BaseViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigateTo(
            HomeFragment.newInstance(),
            backStack = HOME_BACK_STACK
        )
    }

    companion object {
        const val HOME_BACK_STACK = "home_back_stack"
    }
}