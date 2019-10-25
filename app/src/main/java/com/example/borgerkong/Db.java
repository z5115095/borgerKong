package com.example.borgerkong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Db {


    public static Food getFoodById(int foodID) {
        return foods.get(foodID);
    }

//arraylist of all foods
    public static ArrayList<Food> getAllFoods() {
        return new ArrayList<Food>((List) Arrays.asList(foods.values().toArray()));
    }

    private static final HashMap<Integer, Food> foods = new HashMap<>();

    //populate database with foods, foodid, name, description, price
    static {
        foods.put(1, new Food(
                1, "Whopper", "It’s not rocket science why the Whopper®, our largest burger, has been an Aussie favourite for over 40 years. It’s just 100% Aussie beef, flame-grilled to perfection. Every time.", 4.5, R.drawable.whopper));

        foods.put(2, new Food(
                2, "Whopper Jr.",
                "It's just like the legendary Whopper®, only smaller. Same great flame-grilled Australian beef with no added hormones, ripe hand-cut tomato, fresh lettuce, onion, pickles, mayo and tomato sauce on a toasted sesame seed bun.",
                3.5,
                R.drawable.whopperjr));

        foods.put(3, new Food(
                3, "Bacon King",
                "Our Bacon King features a ¼ lb* of savory fire-grilled beef, topped with thick-cut smoked bacon, melted American cheese, freshly cut iceberg lettuce, creamy mayo, ripe tomatoes, ketchup, onions, crunchy pickles, and layers of a sweet and smoky bbq sauce, all on a warm, toasted, sesame seed bun", 4.5,
                R.drawable.baconking));

        foods.put(4, new Food(
                4, "Cheeseburger",
                "You can’t go wrong with our cheeseburger, a signature flame-grilled. beef patty topped with a simple layer of melted American cheese, crinkle cut pickles, yellow mustard, and ketchup on a toasted sesame seed bun.", 3.5,
                R.drawable.cheeseburger));

        foods.put(5, new Food(
                5, "Hamburger",
                "Try our Hamburger, a signature flame-grilled. beef patty topped with a simple layer of crinkle cut pickles, yellow mustard, and ketchup on a toasted sesame seed bun.", 3,
                R.drawable.hamburger));

        foods.put(6, new Food(
                6, "Impossible Whopper",
                "Our Impossible™ WHOPPER® Sandwich features a savory flame-grilled patty made from plants topped with juicy tomatoes, fresh lettuce, creamy mayonnaise, ketchup, crunchy pickles, and sliced white onions on a soft sesame seed bun. 100% WHOPPER®, 0% Beef.", 5.5,
                R.drawable.impossiblewhopper));

        foods.put(7, new Food(
                7, "Taco",
                "Introducing the Crispy Taco featuring a crispy, crunchy tortilla, filled with delicious, seasoned beef, shredded cheddar cheese and lettuce, all topped with just the right amount of our savory taco sauce.", 3.5,
                R.drawable.taco));

        foods.put(8, new Food(
                8, "Big Fish",
                "Our premium Big Fish Sandwich is 100% White Alaskan Pollock, breaded with crispy panko breading and topped with sweet tartar sauce, tangy pickles, all on top of a toasted brioche-style bun.", 4.5,
                R.drawable.fishburger));

        foods.put(9, new Food(
                9, "Big Breakfast",
                "Our Big Breakfast has all your signature favorites, including a mingling of warm scrambled eggs, crunchy Hash Browns, savory sausage, a warm baked biscuit, and three fluffy pancakes drizzled in sweet syrup.", 10.5,
                R.drawable.breakfast));

        foods.put(10, new Food(
                10, "Fries",
                "More delicious than ever, our signature piping hot, thick cut Salted French Fries are golden on the outside and fluffy on the inside.",3.5,
                R.drawable.fries));

        foods.put(11, new Food(
                11, "Chicken Nuggets",
                "Made with white meat, our bite-sized Chicken Nuggets are tender and juicy on the inside and crispy on the outside. Coated in a homestyle seasoned breading, they are perfect for dipping in any of our delicious dipping sauces.",5,
                R.drawable.chickennuggets));

        foods.put(12, new Food(
                12, "Chicken Fries",
                "Made with white meat chicken, our Chicken Fries are coated in a light crispy breading seasoned with savory spices and herbs. Chicken Fries are shaped like fries and are perfect to dip in any of our delicious dipping sauces. Choose from BBQ, Honey Mustard, Ranch, Zesty, Buffalo and Sweet & Sour.",4.5,
                R.drawable.chickenfries));

        foods.put(13, new Food(
                13, "Bubble Tea",
                "A good drink!", 5.5,
                R.drawable.milktea));

        foods.put(14, new Food(
                14, "Garden Salad",
                "Our Garden Side Salad is a blend of premium lettuces garnished with juicy tomatoes, home-style croutons, a three-cheese medley, and your choice of KEN’S® salad dressing. Nutrition Information does not reflect home-style croutons or KEN’S salad dressing.", 3,
                R.drawable.gardensalad));

        foods.put(15, new Food(
                15, "Frozen Coke",
                "Cool down with a Frozen Coke® any time of the year.", 1,
                R.drawable.frozencoke));

        foods.put(16, new Food(
                16, "Soft Serve",
                "We didn’t invent soft serve, but with one taste of our cool, creamy, and velvety Vanilla Soft Serve, you’ll think we perfected it. Your choice of classic cone or cup.",1,
                R.drawable.softserve));

        foods.put(17, new Food(
                17, "Water",
                "Nestlé® Pure Life® Purified Water, the exclusive bottled water of BURGER KING®, is a cool and refreshing way to wash down your signature favorites.", 3,
                R.drawable.water));
    }



}

