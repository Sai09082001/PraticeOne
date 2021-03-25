package com.example.practiceone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.practiceone.Food;
import com.example.practiceone.R;

import java.util.List;

public class FoodAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Food> foodList;
    public FoodAdapter(Context context, int layout, List<Food> foodList){
        this.context=context;
        this.layout=layout;
        this.foodList=foodList;
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(layout,null);
        TextView tvTen=(TextView) view.findViewById(R.id.tv_ten);
        TextView tvMota=(TextView) view.findViewById(R.id.tv_mota);
        ImageView imageViewHinh=(ImageView) view.findViewById(R.id.imageViewFood);
        Food food=foodList.get(i);
        tvTen.setText(food.getTen());
        tvMota.setText(food.getMoTa());
        imageViewHinh.setImageResource(food.getHinh());
        return view;
    }
}
