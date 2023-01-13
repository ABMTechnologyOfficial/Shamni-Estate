package com.shamniestate.shamniestate.ui.misc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import com.shamniestate.shamniestate.databinding.ActivityAboutUsBinding;

public class AboutUsActivity extends AppCompatActivity {
    private Activity activity;
    private ActivityAboutUsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAboutUsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = this;

        binding.icBack.setOnClickListener(v -> onBackPressed());
    }
}