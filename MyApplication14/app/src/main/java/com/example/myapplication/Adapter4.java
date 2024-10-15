package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter4 extends RecyclerView.Adapter<Adapter4.ViewHolder> { // Extending RecyclerView.Adapter
    private List<BuyCarModel> carList;
    private Context context;

    public Adapter4(List<BuyCarModel> carList, Context context) {
        this.carList = carList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.buycar_model, parent, false);
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

        holder.whiteheart.setOnClickListener(v -> holder.whiteheart.setImageResource(R.drawable.redheart));

        holder.whiteheart.setOnLongClickListener(view -> {
            holder.whiteheart.setImageResource(R.drawable.whiteheart_);
            return true;
        });
holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(context,SellCarDetails.class);
      intent.putExtra("head",car.getTxt1());
        context.startActivity(intent);
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
