package com.example.myapplication;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.core.content.ContextCompat;

import java.util.List;

public class Adapter5 extends RecyclerView.Adapter<Adapter5.ViewHolder> {
    private List<Option_model> optionList;
    private Context context;
    private int selectedPosition = -1; // To keep track of selected item

    public Adapter5(List<Option_model> optionList, Context context) {
        this.optionList = optionList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.options_model, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Option_model option = optionList.get(position);
        holder.optionText.setText(option.getOption());

        // Set default colors
        holder.optionCard.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(context, R.color.babygrey)));
       holder.optionText.setTextColor(context.getResources().getColor(R.color.black));

        // Change background and text color if selected
        if (selectedPosition == position) {
            holder.optionCard.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(context, R.color.babyred)));
            holder.optionText.setTextColor(context.getResources().getColor(R.color.white));
        } else {
            holder.optionCard.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(context, R.color.babygrey)));
            holder.optionText.setTextColor(context.getResources().getColor(R.color.black));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Update selected position and notify adapter
                selectedPosition = holder.getAdapterPosition();
                notifyDataSetChanged(); // Refresh the RecyclerView to update the UI

                // If you have a listener for option clicks, you can trigger it here
                if (onOptionClickListener != null) {
                    onOptionClickListener.onOptionClick(option);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return optionList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView optionText;
        CardView optionCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            optionText = itemView.findViewById(R.id.year);
            optionCard = itemView.findViewById(R.id.option1);
        }
    }

    // Listener for option clicks
    private OnOptionClickListener onOptionClickListener;

    public void setOnOptionClickListener(OnOptionClickListener listener) {
        this.onOptionClickListener = listener;
    }

    public interface OnOptionClickListener {
        void onOptionClick(Option_model option);
    }
}
