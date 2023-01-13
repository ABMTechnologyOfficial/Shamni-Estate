package com.shamniestate.shamniestate.ui.misc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import com.shamniestate.shamniestate.databinding.ActivityHomeLoanEnquiryBinding;

public class HomeLoanEnquiryActivity extends AppCompatActivity {
    private Activity activity;
    private ActivityHomeLoanEnquiryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeLoanEnquiryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = this;

        binding.icBack.setOnClickListener(view -> onBackPressed());

    }
}