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
import com.shamniestate.shamniestate.models.UtilModel;

import java.io.Serializable;
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


        UtilModel model = new UtilModel();

        model.setAccountType(selectedAccountType);
        model.setAssociateAddress(binding.userAddressEdit.getText().toString());
        model.setAssociateCity(binding.userCityEdit.getText().toString());
        model.setAssociateCityZip( binding.userZipEdit.getText().toString());
        model.setAssociateMobile( binding.userMobileEdit.getText().toString());
        model.setAssociateState( binding.userStateEdit.getText().toString());
        model.setAssociateGender(selectedGender);
        model.setAssociateDob(binding.userDobEdit.getText().toString());
        model.setAssociateName(binding.userNameEdit.getText().toString());

        Intent intent = new Intent(activity, SignupDocumentsActivity.class);
        intent.putExtra("model",(Serializable) model);
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
        } else if (binding.userNameEdit.getText().toString().equalsIgnoreCase("")) {
            binding.userNameEdit.setError("Enter Name..!");
            binding.userNameEdit.requestFocus();
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