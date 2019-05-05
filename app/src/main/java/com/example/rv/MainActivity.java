package com.example.rv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rv.adapter.CoinAdapter;
import com.example.rv.rest.ApiCoinGecko;
import com.example.rv.rest.NetworkService;
import com.example.rv.rest.entities.GekoCoins;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
        private RecyclerView recyclerView;
        private CoinAdapter coinAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
        coinAdapter = new CoinAdapter();
        recyclerView.setAdapter(coinAdapter);
        loadData();
    }

    public void loadData(){
        NetworkService networkService = NetworkService.getInstance();
        ApiCoinGecko apiCoinGecko = networkService.getApiCoinGecko();
        Log.i("myTag", "loadData");

        Call<List<GekoCoins>> call = apiCoinGecko.getCoinGeckoList("usd", 100, "market_cap_desc");
        call.enqueue(new Callback<List<GekoCoins>>() {
            @Override
            public void onResponse(Call<List<GekoCoins>> call, Response<List<GekoCoins>> response) {
                List<GekoCoins> list = response.body();
                Log.i("myTag", "OnResponse" + list.get(0).getSymbol());
                coinAdapter.setCoinsList(list);
            }

            @Override
            public void onFailure(Call<List<GekoCoins>> call, Throwable t) {
                Log.i("mytag", "OnFailure");
                Toast.makeText(recyclerView.getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
