package com.example.rv.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rv.R;


public class CoinViewHolder extends RecyclerView.ViewHolder {
    TextView rvSymbol;
    TextView tvName;
    TextView tvMarketCap;
    TextView tvPrice;
    ImageView coinIcon;

    public CoinViewHolder(@NonNull View itemView) {
        super(itemView);
        tvMarketCap = itemView.findViewById(R.id.marketCap);
        rvSymbol = itemView.findViewById(R.id.rvSymbol1);
        tvName = itemView.findViewById(R.id.rvName);
        tvPrice = itemView.findViewById(R.id.price);
        coinIcon = itemView.findViewById(R.id.rvImg);
    }
}
