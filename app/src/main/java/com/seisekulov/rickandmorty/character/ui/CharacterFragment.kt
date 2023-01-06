package com.seisekulov.rickandmorty.character.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.seisekulov.rickandmorty.R
import com.seisekulov.rickandmorty.character.ui.adapter.CharacterAdapter
import com.seisekulov.rickandmorty.character.ui.adapter.SpacingItemDecorator
import com.seisekulov.rickandmorty.databinding.FragmentCharacterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterFragment : Fragment(R.layout.fragment_character) {

    private val viewModel by viewModels<CharacterViewModel>()
    private val viewBinding by viewBinding(FragmentCharacterBinding::bind)
    private val adapter: CharacterAdapter by lazy { CharacterAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val itemDecorator = SpacingItemDecorator(SPACE_VALUE)
        viewBinding.rvCharacters.addItemDecoration(itemDecorator)
        viewBinding.rvCharacters.adapter = adapter

        viewModel.characters.observe(viewLifecycleOwner) {
            adapter.setItems(it)
        }
    }

    companion object {
        private const val SPACE_VALUE = 30
    }
}