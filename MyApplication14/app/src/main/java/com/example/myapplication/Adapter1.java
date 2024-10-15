package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class Adapter1 extends RecyclerView.Adapter<Adapter1.CarViewHolder> {

    private List<CarsModel> carsList;
    private Context context;

    public Adapter1(Context context, List<CarsModel> carsList) {
        this.context = context;
        this.carsList = carsList;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cars_model, parent, false);
        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        CarsModel car = carsList.get(position);
        holder.carImage.setImageResource(car.getImg());
    }

    @Override
    public int getItemCount() {
        return carsList.size();
    }

    public static class CarViewHolder extends RecyclerView.ViewHolder {
        ImageView carImage;

        public CarViewHolder(@NonNull View itemView) {
            super(itemView);
            carImage = itemView.findViewById(R.id.car12);
        }
    }
}
