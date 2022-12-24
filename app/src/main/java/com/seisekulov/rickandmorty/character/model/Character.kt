package com.seisekulov.rickandmorty.character.model

import com.seisekulov.rickandmorty.model.CharacterStatus
import com.seisekulov.rickandmorty.model.Gender
import java.util.*


data class Character(
    val id: Int,
    val name: String,
    val status: CharacterStatus,
    val species: String,
    val type: String,
    val gender: Gender,
    val origin: Location,
    val location: Location,
    val imageUrl: String,
    val episode: List<String>,
    val url: String,
    val createdDate: Date
) {

    data class Location(
        val name: String,
        val url: String
    )
}