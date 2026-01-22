package com.example.stocksportfolio;

import com.google.gson.annotations.SerializedName;

public class Stocks {
    @SerializedName("name")
    private static Name name;
    @SerializedName("symbol")
    private static Symbol symbol;
    @SerializedName("close")
    private static String price;
    public static String getname(){
        return name.getName();
    }
    public static String getsymbol(){
        return symbol.getSymbol();
    }
    public static String getprice(){
        return price;
    }
}
