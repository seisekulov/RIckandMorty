package com.seisekulov.rickandmorty.network.adapter

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.seisekulov.rickandmorty.model.CharacterStatus
import java.lang.reflect.Type

class CharacterStatusTypeAdapter : JsonDeserializer<CharacterStatus> {

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): CharacterStatus {
        return CharacterStatus.toCharacterStatus(json?.asString?.lowercase().orEmpty())
    }
}