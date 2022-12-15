package com.seisekulov.rickandmorty.character.ui

import androidx.lifecycle.ViewModel
import com.seisekulov.rickandmorty.character.data.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {
}