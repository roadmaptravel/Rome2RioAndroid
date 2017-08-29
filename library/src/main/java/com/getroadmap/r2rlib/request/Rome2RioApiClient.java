package com.getroadmap.r2rlib.request;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;

import com.getroadmap.r2rlib.models.AirSegment;
import com.getroadmap.r2rlib.models.DayFlags;
import com.getroadmap.r2rlib.models.Segment;
import com.getroadmap.r2rlib.models.SurfaceLineCode;
import com.getroadmap.r2rlib.models.SurfaceLineName;
import com.getroadmap.r2rlib.models.SurfaceSegment;
import com.getroadmap.r2rlib.parser.BooleanParser;
import com.getroadmap.r2rlib.parser.DayFlagsParser;
import com.getroadmap.r2rlib.parser.RuntimeTypeAdapterFactory;
import com.getroadmap.r2rlib.parser.SurfaceLineCodeParser;
import com.getroadmap.r2rlib.parser.SurfaceLineNameParser;
import com.getroadmap.r2rlib.utils.ConnectionUtils;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Rome2RioApiClient {

    public static final String API_URL = "http://free.rome2rio.com/api/1.4/json/";

    private Rome2RioService rome2RioService;
    private Context context;

    public Rome2RioApiClient(Context context, String key) {
        this.context = context;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(getGsonConverterFactory())
                .client(getClient(key))
                .build();

        // Create an instance of our API interface.
        rome2RioService = retrofit.create(Rome2RioService.class);
    }


    public Rome2RioService getService() {
        return rome2RioService;
    }

    private OkHttpClient getClient(final String key) {
        OkHttpClient client = new OkHttpClient
                .Builder()
                .cache(new Cache(context.getCacheDir(), 10 * 1024 * 1024)) // 10 MB
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();
                        HttpUrl httpUrl = original.url().newBuilder()
                                .addQueryParameter("key", key)
                                .build();

                        // Request customization: add request headers
                        Request.Builder requestBuilder = original.newBuilder()
                                .url(httpUrl);

                        Request request = requestBuilder.build();

                        Response originalResponse = chain.proceed(request);

                        if (ConnectionUtils.isNetworkConnected(context)) {
                            int maxAge = 30; // read from cache for 30 seconds
                            return originalResponse.newBuilder()
                                    .header("Cache-Control", "public, max-age=" + maxAge)
                                    .build();
                        } else {
                            int maxStale = 60 * 60; // tolerate 1 hour stale
                            return originalResponse.newBuilder()
                                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                                    .build();
                        }
                    }
                })
                .build();

        return client;
    }


    /**
     * get gson converter factory
     * register type adapters here
     *
     * @return GsonConverterFactory
     */
    public GsonConverterFactory getGsonConverterFactory() {


        //polymorphism for segment model
        RuntimeTypeAdapterFactory<Segment> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory
                .of(Segment.class, "segmentKind")
                .registerSubtype(AirSegment.class, "air")
                .registerSubtype(SurfaceSegment.class, "surface");

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Boolean.class, new BooleanParser())
                .registerTypeAdapter(DayFlags.class, new DayFlagsParser())
                .registerTypeAdapter(SurfaceLineCode.class, new SurfaceLineCodeParser())
                .registerTypeAdapter(SurfaceLineName.class, new SurfaceLineNameParser())
                .registerTypeAdapterFactory(runtimeTypeAdapterFactory)
                .create();

        GsonConverterFactory factory = GsonConverterFactory.create(gson);

        return factory;
    }


}