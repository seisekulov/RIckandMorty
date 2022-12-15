package com.seisekulov.rickandmorty.character.data

import com.seisekulov.rickandmorty.character.model.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
}