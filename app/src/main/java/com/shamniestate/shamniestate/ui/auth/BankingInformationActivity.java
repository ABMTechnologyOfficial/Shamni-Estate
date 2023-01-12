package com.shamniestate.shamniestate.ui.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.shamniestate.shamniestate.databinding.ActivityBankingInformationBinding;

public class BankingInformationActivity extends AppCompatActivity {
    private Activity activity;
    private ActivityBankingInformationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBankingInformationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.textContinue.setOnClickListener(view -> startActivity(new Intent(activity, SignupAuthenticationActivity.class)));

    }
}