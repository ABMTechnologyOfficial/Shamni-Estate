package com.shamniestate.shamniestate.visitors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.databinding.ActivityVisitorAddressBinding;
import com.shamniestate.shamniestate.models.VisitorUtilModel;

import java.io.Serializable;

public class VisitorAddressActivity extends AppCompatActivity {

    private VisitorAddressActivity activity;
    private ActivityVisitorAddressBinding binding;
    private VisitorUtilModel model = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVisitorAddressBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = this;

        model = (VisitorUtilModel) getIntent().getSerializableExtra("visitor_data");

        binding.textContinue.setOnClickListener(view -> {
            if (validate()) {
                model.setVisitorAddress(binding.visitorAddressEdit.getText().toString());
                model.setVisitorState(binding.visitorState.getText().toString());
                model.setVisitorCityCode(binding.visitorPinEdit.getText().toString());
                model.setVisitorCity(binding.visitorCity.getText().toString());

                startActivity(new Intent(activity, VisitorDocumentsActivity.class)
                        .putExtra("visitor_data", (Serializable) model));

            }
        });
    }

    private boolean validate() {
        if (binding.visitorCity.getText().toString().equalsIgnoreCase("")) {
            binding.visitorCity.setError("Enter Visitor City..!");
            binding.visitorCity.requestFocus();
            return false;
        } else if (binding.visitorAddressEdit.getText().toString().equalsIgnoreCase("")) {
            binding.visitorAddressEdit.setError("Enter Visitor Address..!");
            binding.visitorAddressEdit.requestFocus();
            return false;
        } else if (binding.visitorState.getText().toString().equalsIgnoreCase("")) {
            binding.visitorState.setError("Enter Visitor State..!");
            binding.visitorState.requestFocus();
            return false;
        } else if (binding.visitorPinEdit.getText().toString().equalsIgnoreCase("")) {
            binding.visitorPinEdit.setError("Enter Visitor Pin Code..!");
            binding.visitorPinEdit.requestFocus();
            return false;
        } else {
            return true;
        }

    }
}