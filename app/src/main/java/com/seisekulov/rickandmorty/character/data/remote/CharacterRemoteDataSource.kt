package com.seisekulov.rickandmorty.character.data.remote

import androidx.lifecycle.LiveData
import com.seisekulov.rickandmorty.character.model.Character
import com.seisekulov.rickandmorty.model.CharacterStatus
import com.seisekulov.rickandmorty.model.Gender

interface CharacterRemoteDataSource {
    val charactersCount: LiveData<Int>
    suspend fun getCharacters(
        page: Int? = null,
        name: String? = null,
        status: CharacterStatus? = null,
        gender: Gender? = null
    ): List<Character>
}