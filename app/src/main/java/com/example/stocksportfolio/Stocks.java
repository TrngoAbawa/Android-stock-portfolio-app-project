package com.example.stocksportfolio;

import com.google.gson.annotations.SerializedName;

public class Stocks {
    @SerializedName("name")
    private Name name;
    @SerializedName("symbol")
    private Symbol symbol;
    @SerializedName("close")
    private String price;
    public String getname(){
        return name.getName();
    }
    public String getsymbol(){
        return symbol.getSymbol();
    }
    public String getprice(){
        return price;
    }
}
