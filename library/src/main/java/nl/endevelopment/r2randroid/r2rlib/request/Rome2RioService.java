package nl.endevelopment.r2randroid.r2rlib.request;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * Created by jan on 14/07/16.
 *
 * http://<server>/api/1.4/json/Search?key=<key>&oName=Bern&dName=Zurich&noRideshare
 */

public interface Rome2RioService {
    @GET("Search?oName={oName}&dName={dName}&oPos={oPosLat},{oPosLng}&dPost={dPosLat},{dPosLng}")
    Call<String> getSearchResponse(
            @Path("key") String key,
            @Path("oName") String oName, @Path("dName") String dName,
            @Path("oPosLat") double oPosLat, @Path("oPosLng") double oPosLng,
            @Path("dPosLat") double dPosLat, @Path("dPosLng") double dPosLng);

    @GET
    Observable<SearchResponse> getSearchResponseRx(@Url String url);
}
