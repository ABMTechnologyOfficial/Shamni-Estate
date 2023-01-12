package com.shamniestate.shamniestate.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.databinding.ActivitySignupUserInfoBinding;

public class SignupUserInfoActivity extends AppCompatActivity {
    private Activity activity;
    private ActivitySignupUserInfoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupUserInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = SignupUserInfoActivity.this;

        String[] gender = new String[]{"Male", "Female"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(activity, R.layout.spinner_item, gender);
        binding.genderSpinner.setAdapter(adapter);

        binding.textContinue.setOnClickListener(view -> startActivity(new Intent(activity, SignupDocumentsActivity.class)));
    }
}