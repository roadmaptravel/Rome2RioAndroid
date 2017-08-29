package com.getroadmap.r2rlib.parser;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by jan on 14/07/16.
 */

public class BooleanParser implements JsonDeserializer<Boolean> {
    @Override
    public Boolean deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        //Expected input should be only a 0 or 1 integer
        int boolInt = json.getAsInt();
        Boolean bool;
        if (boolInt == 0) {
            bool = Boolean.FALSE;
        } else if (boolInt == 1) {
            bool = Boolean.TRUE;
        } else {
            bool = null;
        }

        return bool;
    }
}
