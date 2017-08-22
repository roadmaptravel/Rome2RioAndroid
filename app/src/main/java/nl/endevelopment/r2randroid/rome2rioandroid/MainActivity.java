package nl.endevelopment.r2randroid.rome2rioandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import nl.endevelopment.r2randroid.r2rlib.request.Rome2RioApiClient;
import nl.endevelopment.r2randroid.r2rlib.request.Rome2RioService;
import nl.endevelopment.r2randroid.r2rlib.request.SearchRequest;
import nl.endevelopment.r2randroid.r2rlib.request.SearchResponse;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String key = getString(R.string.apikey);
        Rome2RioService service = new Rome2RioApiClient(this, key).getService();

        SearchRequest searchRequest = new SearchRequest.SearchRequestBuilder()
                .oName("Delft")
                .dName("Rotterdam")
                .noBus(true)
                .build();

        service.getSearchResponseRx(searchRequest.toQueryMap())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SearchResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SearchResponse searchResponse) {
                        Log.d(TAG, "onNext() called with: searchResponse = [" + searchResponse + "]");

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError() called with: e = [" + e + "]");

                    }

                    @Override
                    public void onComplete() {

                    }
                });



    }
}
