package com.shamniestate.shamniestate.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import com.shamniestate.shamniestate.databinding.ActivitySignupDocumentsBinding;

public class SignupDocumentsActivity extends AppCompatActivity {
    private Activity activity;
    private ActivitySignupDocumentsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupDocumentsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}