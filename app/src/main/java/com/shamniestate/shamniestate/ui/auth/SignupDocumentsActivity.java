package com.shamniestate.shamniestate.ui.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
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

        binding.textContinue.setOnClickListener(view -> startActivity(new Intent(activity, BankingInformationActivity.class)));
    }
}