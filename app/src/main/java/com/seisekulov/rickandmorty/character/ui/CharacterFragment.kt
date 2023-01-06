package com.seisekulov.rickandmorty.character.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.seisekulov.rickandmorty.R
import com.seisekulov.rickandmorty.character.SpacingItemDecorator
import com.seisekulov.rickandmorty.character.adapter.CharacterAdapter
import com.seisekulov.rickandmorty.databinding.FragmentCharacterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterFragment : Fragment(R.layout.fragment_character) {

    private val viewModel by viewModels<CharacterViewModel>()
    private val viewBinding by viewBinding(FragmentCharacterBinding::bind)
    private val adapter: CharacterAdapter by lazy { CharacterAdapter() }
    private val spaceValue=30

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.rvCharacters.adapter = adapter

        val itemDecorator= SpacingItemDecorator(spaceValue)
        viewBinding.rvCharacters.addItemDecoration(itemDecorator)

        viewModel.characters.observe(viewLifecycleOwner) {
            adapter.setItems(it)
        }
    }
}