package com.getroadmap.r2rlib.parser

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException

import java.lang.reflect.Type

import com.getroadmap.r2rlib.models.SurfaceLineCode

/**
 * Created by jan on 28/08/2017.
 */

class SurfaceLineCodeParser : JsonDeserializer<SurfaceLineCode> {
    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): SurfaceLineCode {

        val code = json.asString

        val surfaceLineCode = SurfaceLineCode()
        surfaceLineCode.code = code

        return surfaceLineCode
    }
}
