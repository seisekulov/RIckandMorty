package com.seisekulov.rickandmorty.network.adapter

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type
import java.text.SimpleDateFormat
import java.util.*

class DateTypeAdapter : JsonDeserializer<Date?> {

    private val simpleDateFormat = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Date? {
        return runCatching { simpleDateFormat.parse(json?.asString.orEmpty()) }.getOrNull()
    }

    companion object {
        private const val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    }
}