package com.seisekulov.rickandmorty.character.data

import com.seisekulov.rickandmorty.character.data.remote.CharacterRemoteDatasource
import com.seisekulov.rickandmorty.character.model.Character
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepositoryImpl @Inject constructor(
    private val characterRemoteDatasource: CharacterRemoteDatasource
) : CharacterRepository {
    override suspend fun getCharacters(): List<Character> {
        return characterRemoteDatasource.getCharacters()
    }
}