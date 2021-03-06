package com.getroadmap.r2randroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.getroadmap.r2rlib.request.Rome2RioApiClient;
import com.getroadmap.r2rlib.request.Rome2RioService;
import com.getroadmap.r2rlib.request.SearchRequest;
import com.getroadmap.r2rlib.request.SearchResponse;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.text);

        String key = getString(R.string.apikey);
        Rome2RioService service = new Rome2RioApiClient(this, key).getService();

        SearchRequest searchRequest = new SearchRequest.SearchRequestBuilder()
                .oName("Delft")
                .dName("London")
                .noBus()
                .noCar()
                .build();

        service.getSearchResponseRx(searchRequest.toUrl())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<SearchResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(SearchResponse searchResponse) {
                        textView.setText(searchResponse.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError() called with: e = [" + e + "]");
                    }
                });


    }
}
