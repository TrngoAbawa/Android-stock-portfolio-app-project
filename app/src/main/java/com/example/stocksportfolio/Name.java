package com.example.stocksportfolio;

import com.google.gson.annotations.SerializedName;

public class Name {
    @SerializedName("name")
    private String name;
    public String getName(){
        return name;
    }
}
