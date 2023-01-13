package com.shamniestate.shamniestate.ui.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.databinding.ActivitySignupUserInfoBinding;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupUserInfoActivity extends AppCompatActivity {
    private Activity activity;
    private ActivitySignupUserInfoBinding binding;
    private String selectedAccountType = "0", selectedGender = "Male";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupUserInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = SignupUserInfoActivity.this;

        String[] gender = new String[]{"Male", "Female"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(activity, R.layout.spinner_item, gender);
        binding.genderSpinner.setAdapter(adapter);

        binding.genderSpinner.setOnItemSelectedListener((view, position, id, item) -> selectedGender = gender[position]);

        binding.textContinue.setOnClickListener(v -> {
            if (validate()) addData();
        });
        binding.icBack.setOnClickListener(view -> onBackPressed());

        binding.radioBtnChannelPartner.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked)
                selectedAccountType = "1";
        });

        binding.userDobEdit.setOnClickListener(v -> selectDate(binding.userDobEdit));

        binding.radioBtnAssociatePrime.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked)
                selectedAccountType = "0";
        });

        binding.radioBtnIndividual.setOnCheckedChangeListener((buttonView, isChecked) -> selectedAccountType = "0");


    }

    private void addData() {

        Intent intent = new Intent(activity, SignupDocumentsActivity.class);
        intent.putExtra("account_type", selectedAccountType);
        intent.putExtra("city", binding.userCityEdit.getText().toString());
        intent.putExtra("state", binding.userStateEdit.getText().toString());
        intent.putExtra("name", binding.userNameEdit.getText().toString());
        intent.putExtra("email", binding.userStateEdit.getText().toString());
        intent.putExtra("dob", binding.userDobEdit.getText().toString());
        intent.putExtra("gender", selectedGender);
        intent.putExtra("mobile", binding.userMobileEdit.getText().toString());
        intent.putExtra("address", binding.userAddressEdit.getText().toString());
        intent.putExtra("zip", binding.userZipEdit.getText().toString());
        startActivity(intent);


    }

    private boolean validate() {
        if (binding.userCityEdit.getText().toString().equalsIgnoreCase("")) {
            binding.userCityEdit.setError("Enter City..!");
            binding.userCityEdit.requestFocus();
            return false;
        } else if (binding.userAddressEdit.getText().toString().equalsIgnoreCase("")) {
            binding.userAddressEdit.setError("Enter Address..!");
            binding.userAddressEdit.requestFocus();
            return false;
        } else if (binding.userEmailEdit.getText().toString().equalsIgnoreCase("")) {
            binding.userEmailEdit.setError("Enter Address..!");
            binding.userEmailEdit.requestFocus();
            return false;
        } else if (binding.userNameEdit.getText().toString().equalsIgnoreCase("")) {
            binding.userNameEdit.setError("Enter Name..!");
            binding.userNameEdit.requestFocus();
            return false;
        } else if (!emailValidator(binding.userEmailEdit.getText().toString())) {
            binding.userEmailEdit.setError("Invalid Email..!");
            binding.userEmailEdit.requestFocus();
            return false;
        } else if (binding.userMobileEdit.getText().toString().equalsIgnoreCase("")) {
            binding.userMobileEdit.setError("Enter Mobile..!");
            binding.userMobileEdit.requestFocus();
            return false;
        } else if (binding.userStateEdit.getText().toString().equalsIgnoreCase("")) {
            binding.userStateEdit.setError("Enter State..!");
            binding.userStateEdit.requestFocus();
            return false;
        } else if (binding.userZipEdit.getText().toString().equalsIgnoreCase("")) {
            binding.userZipEdit.setError("Enter Zip Code..!");
            binding.userZipEdit.requestFocus();
            return false;
        } else if (binding.userDobEdit.getText().toString().equalsIgnoreCase("dd/yy/mm")) {
            Toast.makeText(activity, "Select Date of Birth", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }

    }

    public boolean emailValidator(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private void selectDate(TextView DateBtn) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (datePicker, year1, month1, day1) -> {
            String date = year1 + "-" + (month1 + 1) + "-" + day1;
            //    datePicker.setBackgroundResource(R.drawable.edit_background);
            DateBtn.setText(date);
        }, year, month, day);

        datePickerDialog.show();
    }
}