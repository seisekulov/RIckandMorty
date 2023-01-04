package com.seisekulov.rickandmorty.character.data.remote

import com.seisekulov.rickandmorty.character.data.remote.model.CharacterResponse
import com.seisekulov.rickandmorty.character.model.Character

object CharacterMapper {
    fun fromNetwork(responses: List<CharacterResponse>): List<Character> {
        return responses.map { response ->
            Character(
                id = response.id,
                name = response.name,
                status = response.status,
                species = response.species,
                type = response.type,
                gender = response.gender,
                origin = Character.Location(
                    name = response.origin.name,
                    url = response.origin.url
                ),
                location = Character.Location(
                    name = response.location.name,
                    url = response.location.url
                ),
                imageUrl = response.image,
                episode = response.episode,
                url = response.url,
                createdDate = response.created
            )
        }
    }
}