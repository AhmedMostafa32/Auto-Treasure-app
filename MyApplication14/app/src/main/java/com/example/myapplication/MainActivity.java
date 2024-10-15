package com.example.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Get the width of the screen
        View rootView = findViewById(android.R.id.content);
        rootView.post(new Runnable() {
            @Override
            public void run() {
                int screenWidth = rootView.getWidth();

                // Animate the car image to the left
                ObjectAnimator carAnimator = ObjectAnimator.ofFloat(binding.logo, "translationX", 0, -screenWidth);
                carAnimator.setDuration(2000); // Duration in milliseconds
                carAnimator.start();

                // Animate the text to the right after the car image
                ObjectAnimator textAnimator = ObjectAnimator.ofFloat(binding.txt, "translationX", 0, screenWidth);
                textAnimator.setDuration(2000); // Duration in milliseconds
                textAnimator.setStartDelay(500); // Start after a delay
                textAnimator.start();

                textAnimator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        });
    }
}
