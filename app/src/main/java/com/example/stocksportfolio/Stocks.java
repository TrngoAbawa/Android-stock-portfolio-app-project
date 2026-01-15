package com.example.stocksportfolio;

import com.google.gson.annotations.SerializedName;

public class Stocks {
    @SerializedName("name")
    private String name;
    @SerializedName("symbol")
    private String symbol;
    @SerializedName("close")
    private String price;
}
