package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.databinding.ActivityLoginBinding;
import com.example.myapplication.databinding.ActivityMainBinding;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        binding.google.setOnClickListener(view -> showProgress());

        binding.apple.setOnClickListener(view -> showProgress());

        binding.facebook.setOnClickListener(view -> showProgress());

        binding.getotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.phone.getText().toString().length() == 11) {
                    Call<ResponseBody> call =postApi.postPhoneNumber(String.valueOf(binding.phone));
                    call.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            if(response.isSuccessful()){
                                showProgress();
                            }
                            else {
                                binding.phone.setError("Error Occurred");
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            binding.phone.setError("Check your InterNet Connection");
                        }
                    });
                } else if (binding.phone.getText().toString().isEmpty()) {
                    binding.phone.setError("Phone Number is Required");
                } else {
                    binding.phone.setError("Invalid Phone Number");
                }
            }
        });
    }


    private void showProgress() {
        // Show the ProgressBar
        binding.progressBar.setVisibility(View.VISIBLE);

        // Hide the ProgressBar and start the new activity after 3 seconds
        new Handler().postDelayed(() -> {
            // Hide the ProgressBar
            binding.progressBar.setVisibility(View.GONE);

            // Start the new activity
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);

            // Optionally, finish the current activity if you don't want the user to come back to it
        }, 5000); // 3 seconds delay
    }
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://reqres.in/")  // Replace with your API base URL
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    PostApi postApi = retrofit.create(PostApi.class);
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}