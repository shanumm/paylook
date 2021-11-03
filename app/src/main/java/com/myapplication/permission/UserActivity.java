package com.myapplication.permission;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

//import com.myapplication.permission.ActivityMainBinding;

import com.myapplication.permission.databinding.ActivityMainBinding;

public class UserActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();

        if (intent != null){

            String name = intent.getStringExtra("name");
            String phone = intent.getStringExtra("phone");
            String country = intent.getStringExtra("country");
//            int imageid = intent.getIntExtra("imageid",R.drawable.a);

//            binding.;
//            binding.phoneProfile.setText(phone);
//            binding.countryProfile.setText(country);

        }

    }
}