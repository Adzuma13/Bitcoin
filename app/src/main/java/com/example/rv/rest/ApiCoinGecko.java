package com.example.rv.rest;

import com.example.rv.rest.entities.GekoCoins;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiCoinGecko {
    @GET(Config.PATH_FOR_DATA + "coins/markets")
    Call<List<GekoCoins>> getCoinGeckoList(
            @Query("vs_currency") String currency,
            @Query("per_page") int page,
            @Query("order") String order);

}