package com.shamniestate.shamniestate.visitors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.databinding.ActivityLoginSuccessBinding;
import com.shamniestate.shamniestate.databinding.ActivityVisitorDocumentsBinding;

public class VisitorDocumentsActivity extends AppCompatActivity {

    ActivityVisitorDocumentsBinding binding ;
    VisitorDocumentsActivity activity ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVisitorDocumentsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = this;

//        binding.textContinue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(activity, LoginSuccessActivity.class));
//            }
//        });

    }
}