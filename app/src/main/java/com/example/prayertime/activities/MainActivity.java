package com.example.prayertime.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.prayertime.R;
import com.example.prayertime.model.Datum;
import com.example.prayertime.model.PrayerTimeResponse;
import com.example.prayertime.model.Timings;
import com.example.prayertime.network.ApiInterface;
import com.example.prayertime.network.RetrofitApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.get);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiInterface apiInterface = RetrofitApiClient.getClient().create(ApiInterface.class);

                Call<PrayerTimeResponse> listCall = apiInterface.getPrayerTime(23.8103, 90.4125, 1, 12, 19);

                listCall.enqueue(new Callback<PrayerTimeResponse>() {
                    @Override
                    public void onResponse(Call<PrayerTimeResponse> call, Response<PrayerTimeResponse> response) {

                        PrayerTimeResponse prayerTimeResponseList = response.body();
                        if(response.code() == 200 && prayerTimeResponseList != null){
                            Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                            Log.d(TAG, "onResponse: "+response.code());

                            List<Datum> datumList = prayerTimeResponseList.getData();
                            String timings = datumList.get(1).getTimings().getIsha();

                            Log.d(TAG, "onResponse: Result: "+timings);


                        }
                    }

                    @Override
                    public void onFailure(Call<PrayerTimeResponse> call, Throwable t) {
                        Log.d(TAG, "onFailure: "+t.getMessage());
                    }
                });
            }
        });
    }
}
