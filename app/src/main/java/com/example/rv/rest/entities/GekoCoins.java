package com.example.rv.rest.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GekoCoins {
    @Expose
    @SerializedName("id")
    String id;

    @Expose
    @SerializedName("symbol")
    String symbol;

    @Expose
    @SerializedName("name")
    String name;

    @Expose
    @SerializedName("image")
    String imageURL;

    @Expose
    @SerializedName("current_price")
    private double current_price;

    @Expose
    @SerializedName("market_cap")
    private double market_cap;

    @Expose
    @SerializedName("market_cap_rank")
    private int market_cap_rank;

    public GekoCoins(String id, String symbol, String name, String imageURL, double current_price, double market_cap, int market_cap_rank) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.imageURL = imageURL;
        this.current_price = current_price;
        this.market_cap = market_cap;
        this.market_cap_rank = market_cap_rank;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public double getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(double current_price) {
        this.current_price = current_price;
    }

    public double getMarket_cap() {
        return market_cap;
    }

    public void setMarket_cap(double market_cap) {
        this.market_cap = market_cap;
    }

    public int getMarket_cap_rank() {
        return market_cap_rank;
    }

    public void setMarket_cap_rank(int market_cap_rank) {
        this.market_cap_rank = market_cap_rank;
    }
}
