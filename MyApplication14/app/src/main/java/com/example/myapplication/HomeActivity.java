package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.myapplication.databinding.ActivityHomeBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity {

    private Adapter1 carsAdapter;
    private List<CarsModel> carsList;

    private Timer autoScrollTimer;
    private LinearLayoutManager layoutManager;


    private ActivityHomeBinding binding; // Binding object for ViewBinding

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupRecycler1();
        setupRecycler2();

        binding.card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:01141391448"));
                startActivity(intent);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
        binding.card5.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                    String phoneNumberWithCountryCode = "+201141391448"; // Your phone number with the Egyptian country code
                    String message = "Hello, I have a query"; // Customize the message you want to send
                    // Create an intent to open WhatsApp with the specific package name
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://wa.me/" + phoneNumberWithCountryCode + "?text=" + Uri.encode(message)));
                    intent.setPackage("com.whatsapp");

                    try {
                        startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        Toast.makeText(getApplicationContext(), "WhatsApp is not installed", Toast.LENGTH_SHORT).show();
                    }
            }
        });
        binding.card7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to send an email
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:AutoTreasure@gmail.com")); // Email address
                intent.putExtra(Intent.EXTRA_SUBJECT, "Your Subject Here"); // Optional: Add a subject
                intent.putExtra(Intent.EXTRA_TEXT, "Your message here"); // Optional: Add body text
                try {
                    startActivity(Intent.createChooser(intent, "Send email via..."));
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "No email clients installed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // Setup Bottom Navigation
        binding.card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String facebookUrl = "https://web.facebook.com/groups/511534591671202"; // Replace with the actual Facebook URL

                // Create an intent to open the Facebook app
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(facebookUrl));

                // Add a try-catch block to handle the case if the browser is not available
                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    // Fallback to opening the link in a web browser
                    Intent fallbackIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(facebookUrl));
                    startActivity(fallbackIntent);
                }
            }
        });
        binding.card2.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, SellingActivity.class);
            startActivity(intent);
        });
        binding.card1.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, BuyingActivity.class);
            startActivity(intent);
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        startAutoScroll();
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopAutoScroll();
    }

    private void setupRecycler1() {
        // RecyclerView 1 Setup
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.recycler1.setLayoutManager(layoutManager);

        // Prepare data for RecyclerView 1
        carsList = new ArrayList<>();
        carsList.add(new CarsModel(R.drawable.supraa));
        carsList.add(new CarsModel(R.drawable.suprra));
        carsList.add(new CarsModel(R.drawable.porschejpg));
        carsList.add(new CarsModel(R.drawable.c7));
        carsList.add(new CarsModel(R.drawable.car3));
        carsList.add(new CarsModel(R.drawable.c5));

        // Setup adapter for RecyclerView 1
        carsAdapter = new Adapter1(this, carsList);
        binding.recycler1.setAdapter(carsAdapter);

        // Setup item animator for RecyclerView 1
        DefaultItemAnimator animator1 = new DefaultItemAnimator();
        binding.recycler1.setItemAnimator(animator1);
        animator1.setAddDuration(1000);
        animator1.setRemoveDuration(1000);
    }

    private void setupRecycler2() {
        // RecyclerView 2 Setup
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.recycler2.setLayoutManager(layoutManager2);

        // Prepare data for RecyclerView 2
        List<CarsModel> carsList2 = new ArrayList<>();
        carsList2.add(new CarsModel(R.drawable.work3));
        carsList2.add(new CarsModel(R.drawable.work1jpg));
        carsList2.add(new CarsModel(R.drawable.work2));
        carsList2.add(new CarsModel(R.drawable.work3));
        carsList2.add(new CarsModel(R.drawable.work));
        carsList2.add(new CarsModel(R.drawable.work1jpg));

        // Setup adapter for RecyclerView 2
        Adapter1 carsAdapter2 = new Adapter1(this, carsList2);
        binding.recycler2.setAdapter(carsAdapter2);
    }

    private void startAutoScroll() {
        autoScrollTimer = new Timer();
        autoScrollTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                int firstVisibleItemPosition = layoutManager.findFirstCompletelyVisibleItemPosition();
                int lastItemPosition = carsAdapter.getItemCount() - 1;

                if (firstVisibleItemPosition < lastItemPosition) {
                    scrollToNextItem(firstVisibleItemPosition + 1);
                } else {
                    scrollToNextItem(0); // Wrap around to the beginning
                }
            }
        }, 1000, 3000); // Delay 1 second before the first scroll, then every 3 seconds
    }

    private void stopAutoScroll() {
        if (autoScrollTimer != null) {
            autoScrollTimer.cancel();
            autoScrollTimer.purge();
        }
    }

    private void scrollToNextItem(final int position) {
        runOnUiThread(new Runnable() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void run() {
                binding.recycler1.smoothScrollToPosition(position);
                binding.recycler2.smoothScrollToPosition(position);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(HomeActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}
