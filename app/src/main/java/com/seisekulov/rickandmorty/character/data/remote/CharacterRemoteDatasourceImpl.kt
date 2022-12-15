package com.seisekulov.rickandmorty.character.data.remote

import com.seisekulov.rickandmorty.character.model.Character
import javax.inject.Inject

class CharacterRemoteDatasourceImpl @Inject constructor() : CharacterRemoteDatasource {
    override suspend fun getCharacters(): List<Character> {
        return emptyList()
    }
}