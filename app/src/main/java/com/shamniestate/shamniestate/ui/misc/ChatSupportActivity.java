package com.shamniestate.shamniestate.ui.misc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import com.shamniestate.shamniestate.databinding.ActivityChatSupportBinding;

public class ChatSupportActivity extends AppCompatActivity {
    private Activity activity;
    private ActivityChatSupportBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatSupportBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = this;

        binding.icBack.setOnClickListener(v-> onBackPressed());
    }
}