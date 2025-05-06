package com.example.ebdiandroid.bases

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.ebdiandroid.presentation.activities.MainActivity.Companion.HOME_BACK_STACK
import com.example.ebdiandroid.R
import com.example.ebdiandroid.adapter.model.CharacterItemEntity
import com.example.ebdiandroid.databinding.ActBaseContainerBinding
import com.example.ebdiandroid.extensions.addFragment
import com.example.ebdiandroid.extensions.clearBackStack
import com.example.ebdiandroid.extensions.clearTop
import com.example.ebdiandroid.extensions.commitSafe
import com.example.ebdiandroid.extensions.getAppFragments
import com.example.ebdiandroid.extensions.replaceFragment
import com.example.ebdiandroid.extensions.viewBinding
import com.example.ebdiandroid.presentation.fragments.CharacterFragment
import com.example.ebdiandroid.presentation.fragments.FavoritesFragment
import com.example.ebdiandroid.presentation.fragments.HomeFragment
import com.example.ebdiandroid.presentation.fragments.ProfileFragment


abstract class BaseContainerActivity<V : BaseViewModel> : BaseActivity<V>() {
    override val binding by viewBinding(ActBaseContainerBinding::inflate)

    var listOfCharacter:List<CharacterItemEntity> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initFragmentChangedListener()
        hideFragmentOnBackStack()

        binding.footerBar.setupView(
            home = { navigateHome() },
            events = { navigateEvents(listOfCharacter) },
            favorites = { navigateFavorites() },
            profile = { navigateProfile() })
    }

    private fun navigateHome() {
        navigateTo(
            HomeFragment.newInstance(),
            backStack = HOME_BACK_STACK
        )
    }

    private fun navigateEvents(list: List<CharacterItemEntity>) {
        navigateTo(
            CharacterFragment.newInstance(list),
            backStack = "events_back_stack"
        )
    }

    private fun navigateFavorites() {
        navigateTo(
            FavoritesFragment.newInstance(),
            backStack = "favorites_back_stack"
        )
    }

    private fun navigateProfile() {
        navigateTo(
            ProfileFragment.newInstance(),
            backStack = "profile_back_stack"
        )
    }

    fun navigateTo(
        fragment: Fragment,
        backStack: String?,
        replace: Boolean = false,
        enterAnimation: Int = R.anim.slide_in_right,
        exitAnimation: Int = R.anim.slide_out_right,
        clearStack: Boolean = true,
        clearTop: Boolean = false
    ) {
        if (clearStack) clearBackStack(backStack) else if (clearTop) clearTop(fragment)
        if (replace)
            replaceFragment(R.id.flContainer, fragment, enterAnimation, exitAnimation)
        else
            addFragment(R.id.flContainer, fragment, enterAnimation, exitAnimation, backStack)

    }

    open fun onFragmentChange(fragment: Fragment) {
        (fragment as? BaseFragment<*>)?.run {
            onTitleChanged().observe(this@BaseContainerActivity) {
                this@BaseContainerActivity
            }
        }
    }

    private fun initFragmentChangedListener() {
        supportFragmentManager.run {
            addOnBackStackChangedListener {
                findFragmentById(R.id.flContainer)?.let {
                    onFragmentChange(it)
                }
            }
        }
    }

    private fun hideFragmentOnBackStack() {
        supportFragmentManager.run {
            addOnBackStackChangedListener {
                beginTransaction().apply {
                    getAppFragments().let { fragments ->
                        fragments.forEachIndexed { index, fragment ->
                            if (index < fragments.size - 1) hide(fragment) else show(fragment)
                        }
                    }
                    commitSafe(supportFragmentManager)
                }
            }
        }
    }
}