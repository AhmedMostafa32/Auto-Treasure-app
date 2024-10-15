package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.databinding.ActivityCardDetailsBinding;

public class CardDetailsActivity extends AppCompatActivity {
private ActivityCardDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCardDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnDate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnDate1.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.black));
            }
        });
        binding.btnDate1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                binding.btnDate1.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.grey));

                return true;
            }
        });
        binding.btnDate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnDate2.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.black));

            }
        });
        binding.btnDate2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                binding.btnDate2.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.grey));

                return true;
            }
        });
        binding.btnDate3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnDate3.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.black));

            }
        });
        binding.btnDate3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                binding.btnDate3.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.grey));
                return true;
            }
        });
        binding.btnDate4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnDate4.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.black));
            }
        });
        binding.btnDate4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                binding.btnDate4.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.grey));
                return true;
            }
        });
        //-------------------------------------------------------------------------------------------------------------------------------
        binding.btnTime1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnTime1.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.black));


            }
        });

        binding.btnTime1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnTime1.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.black));
            }
        });
        binding.btnTime1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                binding.btnTime1.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.grey));
                return true;
            }
        });
        binding.btnTime2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnTime2.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.black));
            }
        });
        binding.btnTime2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                binding.btnTime2.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.grey));
                return true;
            }
        });
        binding.btnTime3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnTime3.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.black));
            }
        });
        binding.btnTime3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                binding.btnTime3.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.grey));
                return true;
            }
        });
        binding.btnTime4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnTime4.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.black));
            }
        });
        binding.btnTime4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                binding.btnTime4.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.grey));
                return true;
            }
        });
        binding.btnAtOurHub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnAtOurHub.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.black));
            }
        });
        binding.btnAtOurHub.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                binding.btnAtOurHub.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.babyred));
                return true;
            }
        });
        binding.btnYourHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnYourHome.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.black));
            }
        });
        binding.btnYourHome.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                binding.btnYourHome.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.babyred));
                return true;
            }
        });

        //-------------------------------------------------------------------------------------------------------------------------------
        if (getIntent().getExtras() != null) {
            String text1 = getIntent().getStringExtra("txt1");
            String text2 = getIntent().getStringExtra("txt2");
            int image1 = getIntent().getIntExtra("img1", 0);

            // Set data to views using binding
            binding.carModel.setText(text1);
            binding.carPrice.setText(text2);
            binding.img.setImageResource(image1);
        }
        binding.btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardDetailsActivity.this, ConfirmedActivity.class);
                intent.putExtra("txt3",binding.btnDate1.getText().toString());
                intent.putExtra("txt4",binding.btnDate2.getText().toString());
                intent.putExtra("txt5",binding.btnDate3.getText().toString());
                intent.putExtra("txt6",binding.btnDate4.getText().toString());
                intent.putExtra("txt1", binding.carModel.getText().toString());
                intent.putExtra("txt2", binding.carPrice.getText().toString());
                intent.putExtra("img1", getIntent().getIntExtra("img1", 0));
                startActivity(intent);

            }
        });
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(CardDetailsActivity.this,BuyingActivity.class);
        startActivity(intent);
    }
}