package com.getroadmap.r2rlib.parser;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import com.getroadmap.r2rlib.models.SurfaceLineCode;

/**
 * Created by jan on 28/08/2017.
 */

public class SurfaceLineCodeParser implements JsonDeserializer<SurfaceLineCode> {
    @Override
    public SurfaceLineCode deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        String code = json.getAsString();

        return new SurfaceLineCode(code);
    }
}
