package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.ActivityBuyingBinding;

import java.util.ArrayList;
import java.util.List;


public class BuyingActivity extends AppCompatActivity {

    private ActivityBuyingBinding binding;
    private Adapter2 adapter2;
    private Adapter3 adapter;
    private List<CardModel> cardList;
    private List<BuyCarModel>buyCarModels;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBuyingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Spinner spinnerPreference = binding.car1;
        Spinner spinnerPreference2 = binding.card2;
        Spinner spinnerPreference3 = binding.card3;
        spinnerPreference.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selected = parentView.getItemAtPosition(position).toString();
                if (selected.equals("New")) {  // تأكد أن options هي القيمة المطلوبة
                    buyCarModels = new ArrayList<>();
                    buyCarModels.add(new BuyCarModel("Audi Q3", "25000$ - 30000$", R.drawable.car1, "4.4", R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("Dodge Charger", "75000$ - 80000$", R.drawable.car3, "5.1", R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("Aston Martin V8 Vantage", "100000$ - 110000$", R.drawable.c4, "5.0", R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("Lamborghini Aventador", "250000$ - 270000$", R.drawable.c6, "8.0", R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("Mercedes-AMG GTR", "180000$ - 200000$", R.drawable.c7, "7.9", R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("Mercedes-IStock", "300000$ - 450000$", R.drawable.m7, "7.9", R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("Dodge Hellcat", "300000$ - 320000$", R.drawable.hellcat, "8.5", R.drawable.whiteheart_));
                    // استخدام السياق الصحيح هنا
                    adapter = new Adapter3(buyCarModels, BuyingActivity.this);
                    layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
                    binding.recycler4.setLayoutManager(layoutManager);
                    binding.recycler4.setAdapter(adapter);
                } else if (selected.equals("Option")) {
                    setupRecycler4();
                }else if (selected.equals("Modified")) {
                   setupRecycler5();
                } else if (selected.equals("Old")) {
                    buyCarModels = new ArrayList<>();
                    buyCarModels.add(new BuyCarModel("volkswagen 2005", "25000$ - 30000$", R.drawable.v1, "4.4", R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("volkswagen 1965", "7500$ - 8000$", R.drawable.v4, "5.1", R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("volkswagen 1980", "10000$ - 11000$", R.drawable.v5, "5.0", R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("volkswagen Bus 1960", "2500$ - 2700$", R.drawable.v6, "8.0", R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("volkswagen 1950", "3000$ - 3100$", R.drawable.v7, "7.9", R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("Renault Megane", "5600$ - 8000$", R.drawable.r4, "7.9", R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("Nissan Sunny", "10000$ - 12000$", R.drawable.n7, "8.5", R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("Nissan 1990 GT-R", "250000$ - 270000$", R.drawable.n2, "8.5", R.drawable.whiteheart_));
                    // استخدام السياق الصحيح هنا
                    adapter = new Adapter3(buyCarModels, BuyingActivity.this);
                    layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
                    binding.recycler4.setLayoutManager(layoutManager);
                    binding.recycler4.setAdapter(adapter);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // لو مفيش اختيار
                setupRecycler4();
            }
        });

        spinnerPreference2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selected = adapterView.getItemAtPosition(i).toString();

                if (selected.equals("Low To High")) {  // تأكد أن options هي القيمة المطلوبة
                    buyCarModels.clear(); // نفضي القائمة عشان نضيف العناصر الجديدة
                    buyCarModels.add(new BuyCarModel("Audi Q3", "25000$ - 30000$", R.drawable.car1,"4.4",R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("BMW X5", "30000$ - 35000$", R.drawable.car2,"4.6",R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("Dodge Super Bee", "35000$ - 38000$", R.drawable.c5,"7.1",R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("Dodge Charger", "75000$ - 80000$", R.drawable.car3,"5.1",R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("Aston Martin V8 Vantage", "100000$ - 110000$", R.drawable.c4,"5.0",R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("Honda NSX", "120000$ - 130000$", R.drawable.c10,"7.4",R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("Mercedes-AMG GTR", "180000$ - 200000$", R.drawable.c7,"7.9",R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("Nissan GT-R", "200000$ - 220000$", R.drawable.c8,"9.0",R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("Lamborghini Aventador", "250000$ - 270000$", R.drawable.c6,"8.0",R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("Black Demon Lamborghini", "250000$ - 270000$", R.drawable.c9,"8.5",R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("Nissan Skyline", "280000$ - 300000$", R.drawable.skyline,"9.9",R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("Dodge Hellcat", "300000$ - 320000$", R.drawable.hellcat,"8.5",R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("Toyota Supra", "320000$ - 340000$", R.drawable.supraa,"10.0",R.drawable.whiteheart_));

                    adapter = new Adapter3(buyCarModels, BuyingActivity.this);
                    layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
                    binding.recycler4.setLayoutManager(layoutManager);
                    binding.recycler4.setAdapter(adapter);

                } else if (selected.equals("Price")) {
                    setupRecycler4();
                } else if (selected.equals("High To Low")) {
                    buyCarModels.clear(); // نفضي القائمة عشان نضيف العناصر الجديدة
                    buyCarModels.add(new BuyCarModel("Toyota Supra", "320000$ - 340000$", R.drawable.supraa,"10.0",R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("Dodge Hellcat", "300000$ - 320000$", R.drawable.hellcat,"8.5",R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("Nissan Skyline", "280000$ - 300000$", R.drawable.skyline,"9.9",R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("Nissan GT-R", "200000$ - 220000$", R.drawable.c8,"9.0",R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("Black Demon Lamborghini", "250000$ - 270000$", R.drawable.c9,"8.5",R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("Lamborghini Aventador", "250000$ - 270000$", R.drawable.c6,"8.0",R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("Mercedes-AMG GTR", "180000$ - 200000$", R.drawable.c7,"7.9",R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("Honda NSX", "120000$ - 130000$", R.drawable.c10,"7.4",R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("Dodge Super Bee", "35000$ - 38000$", R.drawable.c5,"7.1",R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("Dodge Charger", "75000$ - 80000$", R.drawable.car3,"5.1",R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("Aston Martin V8 Vantage", "100000$ - 110000$", R.drawable.c4,"5.0",R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("BMW X5", "30000$ - 35000$", R.drawable.car2,"4.6",R.drawable.whiteheart_));
                    buyCarModels.add(new BuyCarModel("Audi Q3", "25000$ - 30000$", R.drawable.car1,"4.4",R.drawable.whiteheart_));

                    adapter = new Adapter3(buyCarModels, BuyingActivity.this);
                    layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
                    binding.recycler4.setLayoutManager(layoutManager);
                    binding.recycler4.setAdapter(adapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // لو مافيش اختيار
                setupRecycler4();
            }
        });

        setupRecycler3(); // Setting up RecyclerView for card items
        setupRecycler4(); // Setting up RecyclerView for buy car items
        binding.sellingbuying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.sellingbuying.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.babyred));
                binding.sell.setTextColor(getResources().getColor(R.color.white));
                binding.card4.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.grey));
                binding.by.setTextColor(getResources().getColor(R.color.black));
                Intent intent=new Intent(BuyingActivity.this,SellingActivity.class);
                startActivity(intent);
            }
        });

    }



    private void setupRecycler3() {
        // Prepare data for RecyclerView
        cardList = new ArrayList<>();
        cardList.add(new CardModel("Buy Directly", "from Sellers", R.drawable.image1));

        // Setup adapter for RecyclerView
        adapter2 = new Adapter2(this, cardList);
        layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        binding.recycler3.setLayoutManager(layoutManager);
        binding.recycler3.setAdapter(adapter2);
    }
    private void setupRecycler4() {
        // Prepare data for RecyclerView
        buyCarModels=new ArrayList<>();
        buyCarModels.add(new BuyCarModel("Audi Q3", "25000$ - 30000$", R.drawable.car1,"4.4",R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("BMW X5", "30000$ - 35000$", R.drawable.car2,"4.6",R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Dodge Charger", "75000$ - 80000$", R.drawable.car3,"5.1",R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Aston Martin V8 Vantage", "100000$ - 110000$", R.drawable.c4,"5.0",R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel(" Dodge Super Bee", "35000$ - 38000$", R.drawable.c5,"7.1",R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Lamborghini Aventador", "250000$ - 270000$", R.drawable.c6,"8.0",R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Mercedes-AMG GTR", "180000$ - 200000$", R.drawable.c7,"7.9",R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Nissan GT-R", "200000$ - 220000$", R.drawable.c8,"9.0",R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Black Demon Lamborghini", "250000$ - 270000$", R.drawable.c9,"8.5",R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Honda NSX", "120000$ - 130000$", R.drawable.c10,"7.4",R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Dodge Hellcat", "300000$ - 320000$", R.drawable.hellcat,"8.5",R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Toyota Supra", "320000$ - 340000$", R.drawable.supraa,"10.0",R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Nissan Skyline", "280000$ - 300000$", R.drawable.skyline,"9.9",R.drawable.whiteheart_));
        adapter = new Adapter3(buyCarModels, this);
        layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        binding.recycler4.setLayoutManager(layoutManager);
        binding.recycler4.setAdapter(adapter);

    }
    private void setupRecycler5() {
        // Prepare data for RecyclerView
        buyCarModels=new ArrayList<>();
        buyCarModels.add(new BuyCarModel("Nissan GT-R", "200000$ - 220000$", R.drawable.c8,"9.0",R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Toyota Supra", "320000$ - 340000$", R.drawable.supraa,"10.0",R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Nissan Skyline", "280000$ - 300000$", R.drawable.skyline,"9.9",R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Evo", "150000$ - 180000$", R.drawable.md1,"10.0",R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Nissan S13", "120000$ - 140000$", R.drawable.md2,"9.9",R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Monalisa", "200000$ - 210000$", R.drawable.md3,"10.0",R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Eclipse", "280000$ - 290000$", R.drawable.md4,"9.9",R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Mazda Rx-7", "320000$ - 360000$", R.drawable.md5,"10.0",R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel(" Black Mamba", "280000$ - 380000$", R.drawable.md6,"9.9",R.drawable.whiteheart_));
        adapter = new Adapter3(buyCarModels, BuyingActivity.this);
        layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        binding.recycler4.setLayoutManager(layoutManager);
        binding.recycler4.setAdapter(adapter);

    }
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(BuyingActivity.this,HomeActivity.class);
        startActivity(intent);
    }
}