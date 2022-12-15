package com.seisekulov.rickandmorty.character.data.remote

import com.seisekulov.rickandmorty.character.model.Character

interface CharacterRemoteDatasource {
    suspend fun getCharacters(): List<Character>
}