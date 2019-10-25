package com.example.borgerkong;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FoodActivity extends AppCompatActivity {

    public TextView name;
    public TextView blurb;
    public TextView cost;
    public ImageView image;
    public Button increase;
    public Button decrease;
    public TextView quantity;
    public Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        getSupportActionBar().hide();

        //Attaching id to elements
        name = findViewById(R.id.name);
        blurb = findViewById(R.id.blurb);
        cost = findViewById(R.id.cost);
        image = findViewById(R.id.foodImage);
        increase = findViewById(R.id.increase);
        decrease = findViewById(R.id.decrease);
        confirm = findViewById(R.id.confirm);
        quantity = findViewById(R.id.foodQuantity);


        int foodPosition = getIntent().getIntExtra("foodID", -1);
        final Food currentFood = Db.getFoodById(foodPosition);


        //Onclick logic section
        image.setImageResource(currentFood.getImageDrawableId());
        name.setText(currentFood.getName());
        blurb.setText(currentFood.getDescription());

        //Logic for increase button
        increase.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int currentQuantity = Integer.parseInt((String) quantity.getText());
                currentQuantity += 1;

                cost.setText(String.format("%.2f", (double) (currentFood.getPrice() * currentQuantity)));
                quantity.setText(String.valueOf(currentQuantity));
            }
        });

        //Logic for decrease button
        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int currentQuantity = Integer.parseInt((String) quantity.getText());

                if (currentQuantity > 0) {
                    currentQuantity -= 1;

                    cost.setText(String.format("%.2f", (double) (currentFood.getPrice() * currentQuantity)));
                    quantity.setText(String.valueOf(currentQuantity));
                }
            }
        });

        //Adding quantity, totaling price for confirmation button at bottom
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int currentQuantity = Integer.parseInt((String)quantity.getText());
                for (int i = 0; i < currentQuantity; i++) {
                    Order.orderPrices.add(currentFood.getPrice());
                    Order.orderList.add(currentFood);
                    finish();
                }
                    Context context = v.getContext();

                    Intent intent = new Intent(context, MainActivity.class);
                    context.startActivity(intent);

            }
        }
        )
        ;
            }
        ;
    }

