package com.getroadmap.r2rlib.request;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by jan on 14/07/16.
 * <p>
 * http://<server>/api/1.4/json/Search?key=<key>&oName=Bern&dName=Zurich&noRideshare
 */

public interface Rome2RioService {
    @GET
    Single<SearchResponse> getSearchResponseRx(@Url String url);
}
