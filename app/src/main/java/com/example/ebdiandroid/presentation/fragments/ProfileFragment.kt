package com.example.ebdiandroid.presentation.fragments

import android.widget.Toast
import com.example.ebdiandroid.R
import com.example.ebdiandroid.bases.BaseFragment
import com.example.ebdiandroid.bases.BaseViewModel
import com.example.ebdiandroid.databinding.FragmentProfileBinding
import com.example.ebdiandroid.extensions.viewBinding

class ProfileFragment : BaseFragment<BaseViewModel>() {
    override val binding by viewBinding(FragmentProfileBinding::inflate)

    override fun initView() {

        binding.btnEditProfile.setupView(getString(R.string.edit_profile), R.color.black) {
            navigateTo(HomeFragment.newInstance(), "home_back_stack")
        }
        binding.btnFavorites.setupView(getString(R.string.favorites), R.color.black) {
            navigateTo(FavoritesFragment.newInstance(), "home_back_stack")
        }
        binding.btnPolicy.setupView(getString(R.string.policy), R.color.black) {
            navigateTo(CharacterFragment.newInstance(listOfCharacter), "home_back_stack")
        }
        binding.btnDeleteAccount.setupView(getString(R.string.delete_account), R.color.red) {
            Toast.makeText(context, "Ja estou na pagina", Toast.LENGTH_SHORT).show()
        }

    }


    companion object {
        fun newInstance() = ProfileFragment()
    }
}