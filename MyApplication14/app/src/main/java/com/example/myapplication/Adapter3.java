package com.example.myapplication;

import android.app.Activity;  // استبدال Context بـ Activity
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter3 extends RecyclerView.Adapter<Adapter3.ViewHolder> {
    private List<BuyCarModel> carList;
    private Activity activity;  // استبدال Context بـ Activity

    // تمرير الـ Activity بدل Context
    public Adapter3(List<BuyCarModel> carList, Activity activity) {
        this.carList = carList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.buycar_model, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BuyCarModel car = carList.get(position);
        holder.txt1.setText(car.getTxt1());
        holder.txt2.setText(car.getTxt2());
        holder.img1.setImageResource(car.getImg1());
        holder.rate.setText(car.getRate());
        holder.whiteheart.setImageResource(car.getImg2());

        holder.whiteheart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.whiteheart.setImageResource(R.drawable.redheart);
            }
        });

        holder.whiteheart.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                holder.whiteheart.setImageResource(R.drawable.whiteheart_);
                return true;
            }
        });

        // استخدام الـ Activity لفتح الـ Intent
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, CardDetailsActivity.class);
                intent.putExtra("txt1", car.getTxt1());
                intent.putExtra("txt2", car.getTxt2());
                intent.putExtra("img1", car.getImg1());
                activity.startActivity(intent);  // استخدام الـ Activity لفتح الـ Intent
            }
        });

    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt1;
        TextView txt2;
        ImageView img1;
        TextView rate;
        ImageView whiteheart;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt1 = itemView.findViewById(R.id.txt1);
            txt2 = itemView.findViewById(R.id.txt2);
            img1 = itemView.findViewById(R.id.img1);
            rate = itemView.findViewById(R.id.rate);
            whiteheart = itemView.findViewById(R.id.whiteheart);
        }
    }
}
