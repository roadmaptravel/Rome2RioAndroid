package nl.endevelopment.r2randroid.rome2rioandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import nl.endevelopment.r2randroid.r2rlib.request.Rome2RioApiClient;
import nl.endevelopment.r2randroid.r2rlib.request.Rome2RioService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String key = "";
        Rome2RioService service = new Rome2RioApiClient(this, key).getService();



    }
}
