package nl.endevelopment.r2randroid.r2rlib.request;

import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by jan on 14/07/16.
 */

public class Rome2RioRequest {

    public static Call<String> get(SearchRequest searchRequest){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://free.rome2rio.com")
                .build();

        Rome2RioService service = retrofit.create(Rome2RioService.class);
        Call<String> call = service.getSearchResponse("{key}",
                searchRequest.getoName(), searchRequest.getdName(),
                searchRequest.getoPos().getLatitude(), searchRequest.getoPos().getLongitude(),
                searchRequest.getdPos().getLatitude(), searchRequest.getdPos().getLongitude());

        return call;
    }
}
