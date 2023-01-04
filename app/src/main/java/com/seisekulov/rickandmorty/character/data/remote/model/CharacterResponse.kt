package com.seisekulov.rickandmorty.character.data.remote.model

import com.google.gson.annotations.SerializedName
import com.seisekulov.rickandmorty.model.CharacterStatus
import com.seisekulov.rickandmorty.model.Gender
import java.util.*

data class CharacterResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: CharacterStatus,
    @SerializedName("species")
    val species: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("gender")
    val gender: Gender,
    @SerializedName("origin")
    val origin: LocationResponse,
    @SerializedName("location")
    val location: LocationResponse,
    @SerializedName("image")
    val image: String,
    @SerializedName("episode")
    val episode: List<String>,
    @SerializedName("url")
    val url: String,
    @SerializedName("created")
    val created: Date
) {
    data class LocationResponse(
        @SerializedName("name")
        val name: String,
        @SerializedName("url")
        val url: String
    )
}