package com.seisekulov.rickandmorty.character.data.remote

import com.seisekulov.rickandmorty.character.data.remote.model.CharactersResponse
import retrofit2.http.GET

interface CharacterApi {
    @GET("character")
    suspend fun getCharacters(): CharactersResponse
}