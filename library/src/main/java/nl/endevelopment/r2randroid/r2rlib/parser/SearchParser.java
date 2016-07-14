package nl.endevelopment.r2randroid.r2rlib.parser;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import org.json.JSONException;

import nl.endevelopment.r2randroid.r2rlib.request.SearchResponse;

public class SearchParser {

    private static final String TAG = "SearchParser";

    public SearchParser(){


    }

    public SearchResponse parse(String response) throws JSONException{

        GsonBuilder gsonBuilder = new GsonBuilder();

        /*
         * Because Rome2Rio uses 0 and 1 integers instead of true or false
         * we need a custom boolean parser.
         */
        gsonBuilder.registerTypeAdapter(Boolean.class, new BooleanParser());
        Gson gson = gsonBuilder.create();

        SearchResponse searchResponse = null;
        try {
            searchResponse = gson.fromJson(response, SearchResponse.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            throw new JSONException("Unable to parse response: " + response);
        }

        return null;
    }

}