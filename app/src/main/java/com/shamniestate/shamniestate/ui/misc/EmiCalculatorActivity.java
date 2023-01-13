package com.shamniestate.shamniestate.ui.misc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import com.shamniestate.shamniestate.databinding.ActivityEmiCalculatorBinding;

public class EmiCalculatorActivity extends AppCompatActivity {
    private Activity activity;
    private ActivityEmiCalculatorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmiCalculatorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = this;

        binding.icBack.setOnClickListener(view -> onBackPressed());

    }
}