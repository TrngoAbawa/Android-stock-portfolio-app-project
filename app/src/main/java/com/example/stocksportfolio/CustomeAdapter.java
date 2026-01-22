package com.example.stocksportfolio;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomeAdapter extends RecyclerView.Adapter<CustomeAdapter.MyViewHolder> {

    private List<DataModel> dataset;



    public CustomeAdapter(List<Stocks> stocksList) {
        this.dataset = dataset;
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewSymbol;
        TextView textViewPrice;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.StockName);
            textViewSymbol = itemView.findViewById(R.id.StockSymbol);
            textViewPrice = itemView.findViewById(R.id.StockPrice);
        }
    }

    @NonNull
    @Override
    public CustomeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stockview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomeAdapter.MyViewHolder holder, int position) {
        holder.textViewName.setText(dataset.get(position).getName());
        holder.textViewSymbol.setText(dataset.get(position).getSymbol());
        holder.textViewPrice.setText(dataset.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
