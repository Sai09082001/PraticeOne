package com.example.practiceone;


import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class M002_Main_Act extends BaseAct {
    private ListView lvFood;
    private ArrayList<Food> foodArrayList;
    private FoodAdapter foodAdapter;


    protected void initViews() {
        lvFood = findViewById(R.id.lv_food);
        foodArrayList = new ArrayList<>();
        foodArrayList.add(new Food("Bánh tráng trộn", "Đồ ăn vặt", R.drawable.ic_banhtrangtron));
        foodArrayList.add(new Food("Khoai tây chiên", "Đồ ăn vặt", R.drawable.ic_khoaitaychien));
        foodArrayList.add(new Food("Phô mai que", "Đồ ăn vặt", R.drawable.ic_phomaique));
        foodArrayList.add(new Food("Pizza", "Đồ ăn vặt", R.drawable.ic_piza));
        foodArrayList.add(new Food("Tokboki", "Đồ ăn vặt", R.drawable.ic_tokboki));
        foodAdapter = new FoodAdapter(this, R.layout.food_listview, foodArrayList);
        lvFood.setAdapter(foodAdapter);
        foodAdapter = new FoodAdapter(this, R.layout.food_listview, foodArrayList);
        lvFood.setAdapter(foodAdapter);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.listview_act;
    }

}
