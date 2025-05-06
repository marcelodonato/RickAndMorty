package com.example.ebdiandroid.presentation.fragments

import android.annotation.SuppressLint
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ebdiandroid.adapter.RickAndMortyGenericAdapter
import com.example.ebdiandroid.adapter.model.CharacterItemEntity
import com.example.ebdiandroid.adapter.model.CharacterFilterEntity
import com.example.ebdiandroid.bases.BaseFragment
import com.example.ebdiandroid.bases.BaseViewModel
import com.example.ebdiandroid.databinding.FragmentCharacterBinding
import com.example.ebdiandroid.extensions.argument
import com.example.ebdiandroid.extensions.viewBinding
import com.example.ebdiandroid.extensions.withArgs
import java.io.Serializable

class CharacterFragment : BaseFragment<BaseViewModel>() {
    override val binding by viewBinding(FragmentCharacterBinding::inflate)

    private val characterData by argument<List<CharacterItemEntity>>("characterList")

    override fun initView() = with(binding) {
        topBar.setupView("Personagens")
        setupRecycler(filtersMock())
        setupRvEvent(characterData)
    }


    @SuppressLint("NotifyDataSetChanged")
    private fun setupRecycler(filters: List<CharacterFilterEntity>) {
        val filterAdapter = RickAndMortyGenericAdapter()
        binding.rvFilters.adapter = filterAdapter
        filterAdapter.items = filters

        filterAdapter.clickListener = { selectedFilter ->
            val current = selectedFilter as CharacterFilterEntity
            val wasSelected = current.isSelected

            val updatedFilters = filterAdapter.items.map {
                it as CharacterFilterEntity
                it.copy(isSelected = if (it == current) !wasSelected else false)
            }
            filterAdapter.items = updatedFilters
            filterAdapter.notifyDataSetChanged()

            if (!wasSelected) {
                val filteredList = characterData.filter {
                    it.species == current.title || it.status == current.title
                }
                setupRvEvent(filteredList)
            } else {
                setupRvEvent(characterData)
            }
        }
    }


    private fun setupRvEvent(events: List<CharacterItemEntity>) {
        binding.rvEvents.apply {
            layoutManager = GridLayoutManager(context, 2)
            val adapter = RickAndMortyGenericAdapter()
            adapter.items = events
            this.adapter = adapter
        }
    }

    private fun filtersMock(): List<CharacterFilterEntity> {
        return listOf(
            CharacterFilterEntity("Alive"),
            CharacterFilterEntity("Dead"),
            CharacterFilterEntity("unknown"),
            CharacterFilterEntity("Human"),
            CharacterFilterEntity("Alien"),
        )
    }

    companion object {
        fun newInstance(characterList: List<CharacterItemEntity>) = CharacterFragment().withArgs {
            putSerializable("characterList", characterList as Serializable)
        }
    }
}