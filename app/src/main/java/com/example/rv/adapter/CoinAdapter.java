package com.example.rv.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.rv.R;
import com.example.rv.rest.entities.GekoCoins;

import java.util.ArrayList;
import java.util.List;

public class CoinAdapter extends RecyclerView.Adapter<CoinViewHolder> {
    List<GekoCoins> coinsList;
    private View view;

    public CoinAdapter() {
        this.coinsList = new ArrayList<>();
    }

    public void setCoinsList(List<GekoCoins> coinsList) {
        this.coinsList.clear();
        this.coinsList.addAll(coinsList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CoinViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_item, viewGroup, false);
        return new CoinViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoinViewHolder coinViewHolder, int position) {
        GekoCoins coin = coinsList.get(position);

        String textPrice = view.getResources().getString(R.string.price);
        String textMarketCap = view.getResources().getString(R.string.market_cap_s);

        coinViewHolder.tvName.setText(coinsList.get(position).getName());
        Log.i("myTag", "Symbol" + coinsList.get(position).getSymbol());
        coinViewHolder.rvSymbol.setText(coinsList.get(position).getSymbol());
        coinViewHolder.tvPrice.setText(String.format(textPrice, String.valueOf(coin.getCurrent_price())));
        coinViewHolder.tvMarketCap.setText(String.format(textMarketCap,String.valueOf(coin.getMarket_cap())));

        Glide.with(view)
                .load(coin.getImageURL())
                .into(coinViewHolder.coinIcon);
    }

    @Override
    public int getItemCount() {
        return coinsList.size();
    }
}
