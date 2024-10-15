package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.myapplication.databinding.ActivitySellCarDetailsBinding;
import java.util.ArrayList;
import java.util.List;

public class SellCarDetails extends AppCompatActivity {

    private ActivitySellCarDetailsBinding binding;
    private Adapter5 adapter5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySellCarDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize your list of options
        List<Option_model> optionList = new ArrayList<>();
        optionList.add(new Option_model("2023"));
        optionList.add(new Option_model("2022"));
        optionList.add(new Option_model("2021"));
        optionList.add(new Option_model("2020"));
        optionList.add(new Option_model("2019"));
        optionList.add(new Option_model("2018"));
        optionList.add(new Option_model("2017"));

        // Set up the RecyclerView and Adapter5
        adapter5 = new Adapter5(optionList, this);
        binding.recycler6.setLayoutManager(new LinearLayoutManager(this));
        binding.recycler6.setAdapter(adapter5);
        String head= getIntent().getStringExtra("head");
        binding.header.setText(head);

        binding.tabyear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tabmake.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.white)));
                binding.tabyear.setBackgroundColor(getResources().getColor(R.color.babyred));
                binding.tabfuel.setBackgroundColor(getResources().getColor(R.color.white));
                binding.tabyear.setTextColor(getResources().getColor(R.color.white));
                binding.tabfuel.setTextColor(getResources().getColor(R.color.black));
                binding.tabmake.setTextColor(getResources().getColor(R.color.black));
            }
        });
        binding.tabmake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tabmake.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.babyred)));
                binding.tabyear.setTextColor(getResources().getColor(R.color.black));
                binding.tabfuel.setTextColor(getResources().getColor(R.color.black));
                binding.tabyear.setBackgroundColor(getResources().getColor(R.color.white));
                binding.tabfuel.setBackgroundColor(getResources().getColor(R.color.white));
                binding.tabmake.setTextColor(getResources().getColor(R.color.white));
            }
        });
        binding.tabfuel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tabmake.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.white)));
                binding.tabyear.setBackgroundColor(getResources().getColor(R.color.white));
                binding.tabfuel.setBackgroundColor(getResources().getColor(R.color.babyred));
                binding.tabyear.setTextColor(getResources().getColor(R.color.black));
                binding.tabfuel.setTextColor(getResources().getColor(R.color.white));
                binding.tabmake.setTextColor(getResources().getColor(R.color.black));
            }
        });

        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellCarDetails.this, PaymentActivity.class);
                startActivity(intent);
            }
        });
    }
}
