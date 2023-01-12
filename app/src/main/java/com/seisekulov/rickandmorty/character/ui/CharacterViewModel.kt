package com.seisekulov.rickandmorty.character.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.paging.PagingData
import androidx.paging.map
import com.seisekulov.rickandmorty.R
import com.seisekulov.rickandmorty.character.data.CharacterRepository
import com.seisekulov.rickandmorty.model.CharacterItem
import com.seisekulov.rickandmorty.model.CharacterStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {

    val characters: LiveData<PagingData<CharacterItem>> = characterRepository.getAsPagingData()
        .map { pagingData ->
            pagingData.map { character ->
                CharacterItem(
                    name = character.name,
                    imageUrl = character.imageUrl,
                    statusNameResId = when (character.status) {
                        CharacterStatus.ALIVE -> R.string.alive
                        CharacterStatus.DEAD -> R.string.dead
                        else -> R.string.unknown
                    },
                    statusColorResId = when (character.status) {
                        CharacterStatus.ALIVE -> R.color.light_green
                        CharacterStatus.DEAD -> R.color.red
                        else -> R.color.red
                    },
                    species = character.species,
                    onItemClickListener = {
                        Timber.d("Name:${character.name}")
                    }
                )
            }
        }
}