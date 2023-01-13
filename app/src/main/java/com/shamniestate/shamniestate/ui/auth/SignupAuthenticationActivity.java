package com.shamniestate.shamniestate.ui.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.shamniestate.shamniestate.databinding.ActivitySignupAuthenticationBinding;

public class SignupAuthenticationActivity extends AppCompatActivity {
    private Activity activity;
    private ActivitySignupAuthenticationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupAuthenticationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = SignupAuthenticationActivity.this;

        binding.textContinue.setOnClickListener(view -> startActivity(new Intent(activity, SignupDocumentsActivity.class)));
        binding.icBack.setOnClickListener(view -> onBackPressed());
    }
}