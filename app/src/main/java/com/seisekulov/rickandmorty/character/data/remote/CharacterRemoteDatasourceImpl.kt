package com.seisekulov.rickandmorty.character.data.remote

import com.seisekulov.rickandmorty.character.model.Character
import javax.inject.Inject

class CharacterRemoteDatasourceImpl @Inject constructor(
    private val characterApi: CharacterApi
) : CharacterRemoteDatasource {
    override suspend fun getCharacters(): List<Character> {
        return CharacterMapper.fromNetwork(characterApi.getCharacters().results)
    }
}