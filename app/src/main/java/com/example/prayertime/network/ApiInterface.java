package com.example.prayertime.network;

import com.example.prayertime.model.PrayerTimeResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/calendar")
    Call<PrayerTimeResponse> getPrayerTime(
            @Query("latitude") double lat,
            @Query("longitude") double log,
            @Query("method") int method,
            @Query("month") int month,
            @Query("year") int year
    );
}