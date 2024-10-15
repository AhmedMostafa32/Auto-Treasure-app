package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class Adapter2 extends RecyclerView.Adapter<Adapter2.ViewHolder> {

    private List<CardModel> cardList;
    private Context context;

    public Adapter2(Context context, List<CardModel> cardList) {
        this.context = context;
        this.cardList = cardList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_model, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CardModel card = cardList.get(position);
        holder.text1.setText(card.getTxt1());
        holder.text2.setText(card.getTxt2());
        holder.image.setImageResource(card.getImg());
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text1;
        public TextView text2;
        public ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.text1);
            text2 = itemView.findViewById(R.id.text2);
            image = itemView.findViewById(R.id.img);
        }
    }
}
