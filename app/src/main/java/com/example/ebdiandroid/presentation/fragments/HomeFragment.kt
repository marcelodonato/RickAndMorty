package com.example.ebdiandroid.presentation.fragments

import com.example.ebdiandroid.adapter.RickAndMortyGenericAdapter
import com.example.ebdiandroid.adapter.model.CarouselEntity
import com.example.ebdiandroid.adapter.model.CharacterItemEntity
import com.example.ebdiandroid.adapter.model.HomeListEntity
import com.example.ebdiandroid.adapter.model.ProfileCardEntity
import com.example.ebdiandroid.bases.BaseFragment
import com.example.ebdiandroid.data.model.CharacterEntity
import com.example.ebdiandroid.databinding.FragmentHomeBinding
import com.example.ebdiandroid.extensions.viewBinding
import com.example.ebdiandroid.presentation.viewModel.HomeViewModel

class HomeFragment : BaseFragment<HomeViewModel>() {
    override val binding by viewBinding(FragmentHomeBinding::inflate)

    private var homeItemList: MutableList<HomeListEntity> = mutableListOf()

    override fun initView() {
        viewModel.getCharacters()
        setupCarousel(viewModel.mockBanners())
        onObservable()
        homeItemList.add(HomeListEntity(viewModel.mockProfileCardItems(), "Ultimos adicionados"))
        setupHomeItems(homeItemList.toList().reversed())
    }

    private fun onObservable() {
        viewModel.onCharacterList.observe(viewLifecycleOwner, ::getCharacters)
    }

    private fun getCharacters(result: List<CharacterEntity?>) {
        result.let { characterList ->
            val profileList = characterList.map { character ->
                ProfileCardEntity(
                    profileImage = character?.image.orEmpty(),
                    profileName = character?.name.orEmpty()
                )
            }
            setupRecyclerView(profileList)
            val list = characterList.take(4)
            val newList = list.map {
                CharacterItemEntity(
                    image = it?.image,
                    name = it?.name,
                    status = it?.species,
                    species = it?.status
                )
            }
            listOfCharacter = characterList.map {
                CharacterItemEntity(
                    image = it?.image,
                    name = it?.name,
                    it?.species,
                    it?.status
                )
            }

            homeItemList.add(HomeListEntity(newList, "Personagens Principais"))
            setupHomeItems(homeItemList.toList().reversed())
        }

    }

    private fun setupRecyclerView(item: List<ProfileCardEntity>) {
        binding.rvProfileCard.let {
            val profilesAdapter = RickAndMortyGenericAdapter()
            profilesAdapter.items = item
            binding.rvProfileCard.adapter = profilesAdapter
        }
    }

    private fun setupCarousel(item: List<CarouselEntity>) {
        binding.crBanners.apply {
            val bannersAdapter = RickAndMortyGenericAdapter()
            bannersAdapter.items = item
            binding.crBanners.adapter = bannersAdapter
        }
    }

    private fun setupHomeItems(item: List<HomeListEntity>) {
        binding.rcHomeItem.let {
            val homeAdapter = RickAndMortyGenericAdapter()
            homeAdapter.items = item
            binding.rcHomeItem.adapter = homeAdapter
        }
    }


    companion object {
        fun newInstance() = HomeFragment()
    }
}