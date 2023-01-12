package com.seisekulov.rickandmorty.character.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.seisekulov.rickandmorty.databinding.ItemCharacterBinding
import com.seisekulov.rickandmorty.model.CharacterItem

class CharacterAdapter : PagingDataAdapter<CharacterItem, CharacterViewHolder>(CharacterDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
}
