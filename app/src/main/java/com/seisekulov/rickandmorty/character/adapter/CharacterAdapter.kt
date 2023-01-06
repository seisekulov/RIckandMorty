package com.seisekulov.rickandmorty.character.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.seisekulov.rickandmorty.databinding.ItemCharacterBinding
import com.seisekulov.rickandmorty.model.CharacterItem

class CharacterAdapter : RecyclerView.Adapter<CharacterViewHolder>() {

    private val data = mutableListOf<CharacterItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characterItem = data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(characters: List<CharacterItem>) {
        data.clear()
        data.addAll(characters)
        notifyDataSetChanged()
    }
}
