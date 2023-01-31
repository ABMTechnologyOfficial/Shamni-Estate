package com.shamniestate.shamniestate.ui.misc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.shamniestate.shamniestate.databinding.ActivityEmiCalculatorBinding;

public class EmiCalculatorActivity extends AppCompatActivity {
    private Activity activity;
    private ActivityEmiCalculatorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmiCalculatorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = this;

        binding.icBack.setOnClickListener(view -> onBackPressed());

        binding.textLogin.setOnClickListener(view -> {

            if (binding.edtInterestRate.getText().toString().equalsIgnoreCase("")) {
                binding.edtInterestRate.setError("Enter Interest Rate..!");
                binding.edtInterestRate.requestFocus();
            } else if (binding.edtTenure.getText().toString().equalsIgnoreCase("")) {
                binding.edtTenure.setError("Enter Tenure...!");
                binding.edtTenure.requestFocus();
            } else if (binding.edtLoanAmount.getText().toString().equalsIgnoreCase("")) {
                binding.edtLoanAmount.setError("Enter Loan Amount..!");
                binding.edtLoanAmount.requestFocus();
            } else {
                binding.calculatedEmi.setText(String.valueOf(emi_calculator(
                        Float.parseFloat(binding.edtLoanAmount.getText().toString()),
                        Float.parseFloat(binding.edtInterestRate.getText().toString()),
                        Float.parseFloat(binding.edtTenure.getText().toString()))) + " /Per Month");
            }
        });
    }

    public float emi_calculator(float p, float r, float t) {
        float emi;

        r = r / (12 * 100); // one month interest
        /// t = t * 12; // one month period
        emi = (p * r * (float) Math.pow(1 + r, t))
                / (float) (Math.pow(1 + r, t) - 1);
        return (Math.round(emi));
    }

}