package com.seisekulov.rickandmorty.network.adapter

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.seisekulov.rickandmorty.model.Gender
import java.lang.reflect.Type

class GenderTypeAdapter : JsonDeserializer<Gender> {

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Gender {
        return Gender.toGender(json?.asString?.lowercase().orEmpty())
    }
}