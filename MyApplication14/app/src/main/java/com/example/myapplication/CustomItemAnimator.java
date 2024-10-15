package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;

public class CustomItemAnimator extends DefaultItemAnimator {

    @Override
    public boolean animateChange(@NonNull RecyclerView.ViewHolder oldHolder, @NonNull RecyclerView.ViewHolder newHolder, @NonNull ItemHolderInfo preInfo, @NonNull ItemHolderInfo postInfo) {
        // Customize change animation
        // Example: Fade in/out animation
        // Implement your animation logic here
        return super.animateChange(oldHolder, newHolder, preInfo, postInfo);
    }

    @Override
    public boolean animateMove(@NonNull RecyclerView.ViewHolder holder, int fromX, int fromY, int toX, int toY) {
        // Customize move animation
        // Example: Slide animation
        // Implement your animation logic here
        return super.animateMove(holder, fromX, fromY, toX, toY);
    }

    // Override other methods as needed
}
