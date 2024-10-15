package com.example.myapplication;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.ActivitySellingBinding;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;
import java.util.List;

public class SellingActivity extends AppCompatActivity {

    private Adapter4 adapter4;
    private List<BuyCarModel> buyCarModels;
    private LinearLayoutManager layoutManager;
    private ActivitySellingBinding binding;
    private FusedLocationProviderClient fusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySellingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize FusedLocationProviderClient
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        // Set up the RecyclerView and car models
        binding.btnAudi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showProgress2();
                setUpCarList();
            }
        });
        //-----------------------------------------------------------------
        binding.btnSkoda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showProgress2();
                setUpCarList2();
            }
        });
        //*****************************************************************
        binding.nissanbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showProgress2();
                setUpCarList3();

            }
        });
        //------------------------------------------------------------------------------------------
        binding.btnmercedes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showProgress2();
                setUpCarList4();
            }
        });
//************************************************************************************************
        binding.renowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showProgress2();
                setUpCarList5();
            }
        });
        // Handle "Sell My Car" button click
        binding.btnSellMyCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String carRegistration = binding.etCarRegistration.getText().toString().trim();
                String StoreLocation ="CarStore";
                if (carRegistration.isEmpty()) {
                  binding.etCarRegistration.setError("Please enter car registration");
                } else {
                    showProgress();
                    // Open Google Maps with the car registration as a search query
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + StoreLocation);
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

                    if (mapIntent.resolveActivity(getPackageManager()) != null) {
                        startActivity(mapIntent);
                    } else {
                        Toast.makeText(getApplicationContext(), "No app available to handle map request", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // Handle "Get Location" button click
        binding.tvLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showProgress(); // Show progress while checking permissions and getting location

                // Check if location permission is already granted
                if (ContextCompat.checkSelfPermission(SellingActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED) {
                    // Permission is granted, proceed to get the last known location
                    getLocation();
                } else {
                    // Permission is not granted, request it
                    ActivityCompat.requestPermissions(SellingActivity.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                }
            }
        });

        // Handle card click to switch to BuyingActivity
        binding.card4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                binding.card4.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.babyred));
                binding.buy.setTextColor(getResources().getColor(R.color.white));
                binding.sellingbuying.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.grey));
                binding.sell.setTextColor(getResources().getColor(R.color.black));

                Intent intent = new Intent(SellingActivity.this, BuyingActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showProgress() {
        binding.progressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(() -> {
            binding.progressBar.setVisibility(View.GONE);
        }, 5000);
    }
    private void showProgress2() {
        binding.progressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(() -> {
            binding.progressBar.setVisibility(View.GONE);
        }, 2000);
    }

    @SuppressLint("MissingPermission")
    private void getLocation() {
        fusedLocationClient.getLastLocation().addOnSuccessListener(SellingActivity.this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    // Use the latitude and longitude to open Google Maps
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();

                    Uri gmmIntentUri = Uri.parse("geo:" + latitude + "," + longitude);
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    mapIntent.setPackage("com.google.android.apps.maps");

                    if (mapIntent.resolveActivity(getPackageManager()) != null) {
                        startActivity(mapIntent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Google Maps not available", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Unable to get location", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setUpCarList() {
        buyCarModels = new ArrayList<>();
        buyCarModels.add(new BuyCarModel("Volkswagen Golf", "23000$ - 27000$", R.drawable.v1, "4.4", R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Volkswagen Passat", "25000$ - 30000$", R.drawable.v2, "4.5", R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Volkswagen Tiguan", "35000$ - 40000$", R.drawable.v3, "4.6", R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Volkswagen Touareg", "50000$ - 55000$", R.drawable.v4, "4.7", R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Volkswagen Arteon", "45000$ - 50000$", R.drawable.v5, "4.8", R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Volkswagen Polo", "18000$ - 22000$", R.drawable.v6, "4.2", R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Volkswagen ID.4", "40000$ - 45000$", R.drawable.v7, "4.9", R.drawable.whiteheart_));


        // Set up RecyclerView
        adapter4 = new Adapter4(buyCarModels, this);
        layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        binding.recycler5.setLayoutManager(layoutManager);
        binding.recycler5.setAdapter(adapter4);
    }
    private void setUpCarList2() {
        buyCarModels = new ArrayList<>();
        buyCarModels.add(new BuyCarModel("Skoda Octavia", "25000$ - 30000$", R.drawable.s1, "4.3", R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Skoda Superb", "35000$ - 40000$", R.drawable.s2, "4.6", R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Skoda Kodiaq", "45000$ - 50000$", R.drawable.s4, "4.7", R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Skoda Kamiq", "22000$ - 27000$", R.drawable.s5, "4.4", R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Skoda Scala", "21000$ - 25000$", R.drawable.s6, "4.2", R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Skoda Fabia", "18000$ - 22000$", R.drawable.s7, "4.5", R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Skoda Enyaq", "55000$ - 60000$", R.drawable.s8, "4.9", R.drawable.whiteheart_));


        // Set up RecyclerView
        adapter4 = new Adapter4(buyCarModels, this);
        layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        binding.recycler5.setLayoutManager(layoutManager);
        binding.recycler5.setAdapter(adapter4);
    }
    private void setUpCarList3() {
        buyCarModels = new ArrayList<>();
        buyCarModels.add(new BuyCarModel("Nissan Altima", "25000$ - 30000$", R.drawable.n1, "4.3", R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Nissan Maxima", "35000$ - 40000$", R.drawable.n2, "4.5", R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Nissan GT-R", "115000$ - 120000$", R.drawable.n3, "5.0", R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Nissan Rogue", "27000$ - 32000$", R.drawable.n4, "4.6", R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Nissan Murano", "34000$ - 38000$", R.drawable.n5, "4.4", R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Nissan Frontier", "28000$ - 33000$", R.drawable.n6, "4.7", R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Nissan Pathfinder", "35000$ - 40000$", R.drawable.n7, "4.8", R.drawable.whiteheart_));


        // Set up RecyclerView
        adapter4 = new Adapter4(buyCarModels, this);
        layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        binding.recycler5.setLayoutManager(layoutManager);
        binding.recycler5.setAdapter(adapter4);
    }
    private void setUpCarList4() {
        buyCarModels = new ArrayList<>();
        buyCarModels.add(new BuyCarModel("Mercedes-Benz A-Class", "35000$ - 40000$", R.drawable.m1, "4.2", R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Mercedes-Benz C-Class", "40000$ - 45000$", R.drawable.m2, "4.5", R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Mercedes-Benz E-Class", "50000$ - 55000$", R.drawable.m3, "4.8", R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Mercedes-Benz S-Class", "90000$ - 95000$", R.drawable.m4, "5.0", R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Mercedes-Benz GLA", "35000$ - 40000$", R.drawable.m5, "4.4", R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Mercedes-Benz GLE", "60000$ - 65000$", R.drawable.m6, "4.7", R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Mercedes-AMG G 63", "160000$ - 170000$", R.drawable.m7, "4.9", R.drawable.whiteheart_));


        // Set up RecyclerView
        adapter4 = new Adapter4(buyCarModels, this);
        layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        binding.recycler5.setLayoutManager(layoutManager);
        binding.recycler5.setAdapter(adapter4);
    }
    private void setUpCarList5() {
        buyCarModels = new ArrayList<>();
        buyCarModels.add(new BuyCarModel("Renault Clio", "17000$ - 22000$", R.drawable.r1, "4.1", R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Renault Megane", "25000$ - 30000$", R.drawable.r2, "4.3", R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Renault Kadjar", "30000$ - 35000$", R.drawable.r3, "4.5", R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Renault Captur", "23000$ - 27000$", R.drawable.r4, "4.2", R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Renault Koleos", "40000$ - 45000$", R.drawable.r5, "4.6", R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Renault Talisman", "35000$ - 40000$", R.drawable.r6, "4.7", R.drawable.whiteheart_));
        buyCarModels.add(new BuyCarModel("Renault Zoe", "30000$ - 32000$", R.drawable.r7, "4.8", R.drawable.whiteheart_));



        // Set up RecyclerView
        adapter4 = new Adapter4(buyCarModels, this);
        layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        binding.recycler5.setLayoutManager(layoutManager);
        binding.recycler5.setAdapter(adapter4);
    }
    // Handle location permission result
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Location permission granted", Toast.LENGTH_SHORT).show();
                // Get location if permission is granted
                getLocation();
            } else {
                Toast.makeText(this, "Location permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(SellingActivity.this,HomeActivity.class);
        startActivity(intent);
    }
}
