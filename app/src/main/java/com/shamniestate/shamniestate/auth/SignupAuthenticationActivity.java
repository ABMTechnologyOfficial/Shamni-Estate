package com.shamniestate.shamniestate.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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
    }
}