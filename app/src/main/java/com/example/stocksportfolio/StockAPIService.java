package com.example.stocksportfolio;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StockAPIService {
    @GET("finance/stocks/most-popular")
    Call<List<Stocks>> GetAllStocks();
}
