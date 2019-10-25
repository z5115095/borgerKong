package com.example.borgerkong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;


import java.util.ArrayList;

public class Order extends AppCompatActivity{

    //declare recyclerview, layoutmanager and total cost
    private RecyclerView RecyclerView;
    private RecyclerView.LayoutManager LayoutManager;
    public static TextView costTotal;

//Create arraylists for both total price of orders and list of orders
    public static ArrayList<Double> orderPrices = new ArrayList<>();
    public static ArrayList<Food> orderList = new ArrayList<>();

//Create an instance of list featuring orders
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        getSupportActionBar().hide();

        costTotal = findViewById(R.id.totalCost);

            RecyclerView = findViewById(R.id.rV2);
            LayoutManager = new LinearLayoutManager(this);
            RecyclerView.setLayoutManager(LayoutManager);
            OrderAdapter orderAdapter = new OrderAdapter();
            orderAdapter.setData(orderList);
            RecyclerView.setAdapter(orderAdapter);

    }
}
