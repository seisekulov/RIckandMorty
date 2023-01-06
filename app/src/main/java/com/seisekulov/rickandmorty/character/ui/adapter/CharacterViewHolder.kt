package com.seisekulov.rickandmorty.character.ui.adapter

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.seisekulov.rickandmorty.R
import com.seisekulov.rickandmorty.databinding.ItemCharacterBinding
import com.seisekulov.rickandmorty.model.CharacterItem

class CharacterViewHolder(
    private val binding: ItemCharacterBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(characterItem: CharacterItem) {
        Glide.with(binding.root)
            .load(characterItem.imageUrl)
            .circleCrop()
            .into(binding.ivAvatar)
        binding.tvStatus.setText(characterItem.statusNameResId)
        binding.tvStatus.setTextColor(
            ContextCompat.getColor(itemView.context, characterItem.statusColorResId)
        )

        binding.tvName.text = characterItem.name
        binding.tvName.setTextColor(
            ContextCompat.getColor(itemView.context, R.color.white)
        )

        binding.tvSpecies.text = characterItem.species
        binding.tvSpecies.setTextColor(
            ContextCompat.getColor(itemView.context, R.color.species_gray)
        )
    }
}


