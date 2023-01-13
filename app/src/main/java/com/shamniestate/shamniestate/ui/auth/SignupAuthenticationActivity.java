package com.shamniestate.shamniestate.ui.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.shamniestate.shamniestate.databinding.ActivitySignupAuthenticationBinding;
import com.shamniestate.shamniestate.models.UtilModel;

public class SignupAuthenticationActivity extends AppCompatActivity {
    private Activity activity;
    private ActivitySignupAuthenticationBinding binding;
    private UtilModel model = new UtilModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupAuthenticationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = SignupAuthenticationActivity.this;

        model = (UtilModel) getIntent().getSerializableExtra("model");

        binding.textContinue.setOnClickListener(view -> startActivity(new Intent(activity, SignupDocumentsActivity.class)));
        binding.icBack.setOnClickListener(view -> onBackPressed());
    }
}