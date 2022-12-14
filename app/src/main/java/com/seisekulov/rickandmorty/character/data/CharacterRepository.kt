package com.seisekulov.rickandmorty.character.data

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.seisekulov.rickandmorty.character.model.Character
import com.seisekulov.rickandmorty.model.CharacterStatus
import com.seisekulov.rickandmorty.model.Gender

interface CharacterRepository {
    val charactersCount: LiveData<Int>

    fun getAsPagingData(
        name: String? = null,
        status: CharacterStatus? = null,
        gender: Gender? = null,
    ): LiveData<PagingData<Character>>

    suspend fun getCharacters(): List<Character>
}