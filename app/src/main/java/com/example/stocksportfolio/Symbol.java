package com.example.stocksportfolio;

import com.google.gson.annotations.SerializedName;

public class Symbol {
    @SerializedName("symbol")
    private String symbol;
    public String getSymbol() {
        return symbol;
    }

}

