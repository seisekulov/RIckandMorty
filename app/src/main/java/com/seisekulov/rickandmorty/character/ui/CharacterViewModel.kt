package com.seisekulov.rickandmorty.character.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seisekulov.rickandmorty.character.data.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {
    init {
        viewModelScope.launch {
            try {
                val characters = characterRepository.getCharacters()
                Timber.d("Characters=$characters")
            } catch (throwable: Throwable) {
                Timber.e(throwable)
            }
        }
    }
}