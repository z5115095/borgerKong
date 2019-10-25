package com.example.borgerkong;

//sourcecode adapted from tutorials and youtube guides

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//create a class for food adapter
public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {


    private ArrayList<Food> foodsAdapt;

    public void setData(ArrayList<Food> foodsToAdapt) {
        this.foodsAdapt = foodsToAdapt;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_card, parent, false);

        FoodViewHolder foodViewHolder = new FoodViewHolder(view);
        return foodViewHolder;
    }

    //Create logic for on click listener and setting name, blurb, cost and image
    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        final Food foodPosition = foodsAdapt.get(position);

        holder.name.setText(foodPosition.getName());
        holder.blurb.setText(foodPosition.getDescription());
        holder.cost.setText("$"+ String.format("%,.2f", foodPosition.getPrice()));
        holder.itemImageView.setImageResource(foodPosition.getImageDrawableId());


        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();

                Intent intent = new Intent(context, FoodActivity.class);
                intent.putExtra("foodID", foodPosition.getFoodID());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodsAdapt.size();
    }

//create viewholder
    public static class FoodViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView name;
        public TextView blurb;
        public TextView cost;
        public ImageView itemImageView;

        public FoodViewHolder(View v) {
            super(v);
            view = v;
            name = v.findViewById(R.id.foodText);
            blurb = v.findViewById(R.id.blurb);
            cost = v.findViewById(R.id.cost);
            itemImageView = v.findViewById(R.id.imageView);
        }
    }
}