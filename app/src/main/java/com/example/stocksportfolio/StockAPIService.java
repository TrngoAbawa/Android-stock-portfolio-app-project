package com.example.stocksportfolio;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StockAPIService {
    @GET("finance/stocks/most-popular")
    Call<List<Stocks>> GetAllStocks();
    @GET("finance/stocks/historical?ticker=AAPL&period=1d")
    Call<List<Stocks>> GetAAPL();
    @GET("finance/stocks/historical?ticker=MSFT&period=1d")
    Call<List<Stocks>> GetMSFT();
    @GET("finance/stocks/historical?ticker=AMZN&period=1d")
    Call<List<Stocks>> GetAMZN();
    @GET("finance/stocks/historical?ticker=GOOGL&period=1d")
    Call<List<Stocks>> GetGOOGL();
    @GET("finance/stocks/historical?ticker=TSLA&period=1d")
    Call<List<Stocks>> GetTSLA();
    @GET("finance/stocks/historical?ticker=BABA&period=1d")
    Call<List<Stocks>> GetBABA();
    @GET("finance/stocks/historical?ticker=V&period=1d")
    Call<List<Stocks>> GetV();
    @GET("finance/stocks/historical?ticker=JNJ&period=1d")
    Call<List<Stocks>> GetJNJ();
    @GET("finance/stocks/historical?ticker=WMT&period=1d")
    Call<List<Stocks>> GetWMT();
}
