package com.getroadmap.r2rlib.parser;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import com.getroadmap.r2rlib.models.SurfaceLineName;

/**
 * Created by jan on 28/08/2017.
 */

public class SurfaceLineNameParser implements JsonDeserializer<SurfaceLineName> {
    @Override
    public SurfaceLineName deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        String name = json.getAsString();
        SurfaceLineName surfaceLineName = new SurfaceLineName();
        surfaceLineName.setName(name);

        return surfaceLineName;
    }
}
