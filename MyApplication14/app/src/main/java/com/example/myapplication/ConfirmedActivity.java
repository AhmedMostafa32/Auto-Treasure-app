package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityConfirmedBinding;

public class ConfirmedActivity extends AppCompatActivity {
    private ActivityConfirmedBinding binding;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConfirmedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
binding.back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        onBackPressed();
    }
});
        // Retrieve data from Intent
        if (getIntent().getExtras() != null) {
            String text1 = getIntent().getStringExtra("txt1");
            String text2 = getIntent().getStringExtra("txt2");
            int image1 = getIntent().getIntExtra("img1", 0);
            String text3 = getIntent().getStringExtra("txt3");
            String text4 = getIntent().getStringExtra("txt4");
            String text5 = getIntent().getStringExtra("txt5");
            String text6 = getIntent().getStringExtra("txt6");

            // Set data to views using binding
            binding.carModel.setText(text1);
            binding.carPrice.setText(text2);
            binding.img.setImageResource(image1);
            binding.date.setText("Date - "+text3);
            binding.date.setText("Date - "+text4);
            binding.date.setText("Date - "+text5);
            binding.date.setText("Date - "+text6);
        }
        binding.btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog progressDialog = new ProgressDialog(ConfirmedActivity.this);
                progressDialog.setMessage("We receive your request and will contact you soon.");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.setTitle("Loading...");
                progressDialog.setCancelable(false);
                progressDialog.show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.dismiss();
                        Intent intent = new Intent(ConfirmedActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }
                }, 3000);
            }
        });
        binding.btnRequestReschedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               onBackPressed();
            }
        });
    }

}
