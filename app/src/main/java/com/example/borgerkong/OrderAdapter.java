package com.example.borgerkong;

//sourcecode adapted from tutorials and youtube guides

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.borgerkong.Order.costTotal;
import static com.example.borgerkong.Order.orderList;
import static com.example.borgerkong.Order.orderPrices;


//Inflating order_card to get all the orders
public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    private ArrayList<Food> ordersToAdapt;

    public void setData(ArrayList<Food> ordersToAdapt) {
        this.ordersToAdapt = ordersToAdapt;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.order_card,parent,false);
        OrderViewHolder orderViewHolder = new OrderViewHolder(view);
        return orderViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, final int position) {
        final Food foodAtPosition = ordersToAdapt.get(position);

        holder.name.setText(foodAtPosition.getName());
        holder.price.setText("$" + String.format("%,.2f", foodAtPosition.getPrice()));
        holder.itemImageView.setImageResource(foodAtPosition.getImageDrawableId());


        //Logic for total cost
        double sum = 0;
        for (double i : orderPrices)
            sum = sum + i;
        String sums = String.format("%,.2f", sum);
        costTotal.setText("$" + String.valueOf(sums));

        //Logic for deleting an order
        holder.deleteImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderList.remove(foodAtPosition);
                notifyItemRemoved(position);
                orderPrices.remove(foodAtPosition.getPrice());

                int items = orderList.size();

                double sum = 0;
                for (double i : orderPrices)
                    sum = sum + i;
                String sums = String.format("%,.2f", sum);
                costTotal.setText("$" + String.valueOf(sums));

            }
        });

        holder.itemImageView.setImageResource(foodAtPosition.getImageDrawableId());
    }
//creating a viewholder
    @Override
    public int getItemCount() {
        return ordersToAdapt.size();
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView name;
        public TextView description;
        public TextView price;
        public ImageView itemImageView;
        public ImageView deleteImageView;

        public OrderViewHolder(View v) {
            super(v);
            view = v;
            name = v.findViewById(R.id.foodText);
            description = v.findViewById(R.id.blurb);
            price = v.findViewById(R.id.price);
            itemImageView = v.findViewById(R.id.imageView);
            deleteImageView = v.findViewById(R.id.delete);
        }
    }
}