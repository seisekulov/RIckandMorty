package com.seisekulov.rickandmorty.character.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.seisekulov.rickandmorty.character.data.CharacterMapper
import com.seisekulov.rickandmorty.character.model.Character
import com.seisekulov.rickandmorty.model.CharacterStatus
import com.seisekulov.rickandmorty.model.Gender
import javax.inject.Inject

class CharacterRemoteDataSourceImpl @Inject constructor(
    private val characterApi: CharacterApi
) : CharacterRemoteDataSource {
    private val _charactersCount = MutableLiveData(INITIAL_COUNT)
    override val charactersCount: LiveData<Int> = _charactersCount

    override suspend fun getCharacters(
        page: Int?,
        name: String?,
        status: CharacterStatus?,
        gender: Gender?
    ): List<Character> {
        val response = characterApi.getCharacters(
            page = page,
            name = name,
            status = status,
            gender = gender
        )
        val characters = CharacterMapper.fromNetwork(response)
        _charactersCount.value = characters.info.count
        return characters.results
    }

    companion object {

        private const val INITIAL_COUNT = 0
    }
}