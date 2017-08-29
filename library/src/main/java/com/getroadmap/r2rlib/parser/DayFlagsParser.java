package com.getroadmap.r2rlib.parser;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import com.getroadmap.r2rlib.models.DayFlags;

/**
 * Created by jan on 28/08/2017.
 */

public class DayFlagsParser implements JsonDeserializer<DayFlags> {
    @Override
    public DayFlags deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        //Expected input should be a int in the [0-127] range (7 bytes)
        int intFlag = json.getAsInt();

        if (intFlag < 0 || intFlag > 127) {
            return new DayFlags(0);
        }

        return new DayFlags(intFlag);
    }
}
