package com.shamniestate.shamniestate.visitors;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.shamniestate.shamniestate.databinding.ActivityAddVisitorInfoBinding;
import com.shamniestate.shamniestate.models.VisitorUtilModel;

import java.io.Serializable;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddVisitorInfoActivity extends AppCompatActivity {

   private ActivityAddVisitorInfoBinding binding ;
   private AddVisitorInfoActivity activity ;
   private VisitorUtilModel model = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddVisitorInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        binding.textContinue.setOnClickListener(view -> {

            if(validate()){
               model = new VisitorUtilModel();
               model.setVisitorDob(binding.visitorDobEdit.getText().toString());
               model.setVisitorDov(binding.visitorDateOfVisit.getText().toString());
               model.setVisitorName(binding.visitorNameEdit.getText().toString());
               model.setVisitorEmail(binding.visitorEmailEdit.getText().toString());
               model.setVisitorMob(binding.visitorMobileEdit.getText().toString());
               model.setVisitorProffession(binding.visitorProfessionEdit.getText().toString());

               startActivity(new Intent(activity, VisitorAddressActivity.class)
                       .putExtra("visitor_data", (Serializable) model)
               );
            }

        });

        binding.visitorDateOfVisit.setOnClickListener(view -> selectDate(binding.visitorDateOfVisit));
        binding.visitorDobEdit.setOnClickListener(view -> selectDate(binding.visitorDobEdit));



    }


    private boolean validate() {
        if (binding.visitorEmailEdit.getText().toString().equalsIgnoreCase("")) {
            binding.visitorEmailEdit.setError("Enter Visitor Email..!");
            binding.visitorEmailEdit.requestFocus();
            return false;
        }else if (!emailValidator(binding.visitorEmailEdit.getText().toString())) {
            binding.visitorEmailEdit.setError("Invalid  Email..!");
            binding.visitorEmailEdit.requestFocus();
            return false;
        } else if (binding.visitorMobileEdit.getText().toString().equalsIgnoreCase("")) {
            binding.visitorMobileEdit.setError("Enter Mobile..!");
            binding.visitorMobileEdit.requestFocus();
            return false;
        } else if (binding.visitorProfessionEdit.getText().toString().equalsIgnoreCase("")) {
            binding.visitorProfessionEdit.setError("Enter Profession..!");
            binding.visitorProfessionEdit.requestFocus();
            return false;
        } else if (binding.visitorNameEdit.getText().toString().equalsIgnoreCase("")) {
            binding.visitorNameEdit.setError("Enter Visitor Name..!");
            binding.visitorNameEdit.requestFocus();
            return false;
        } else if (binding.visitorDobEdit.getText().toString().equalsIgnoreCase("dd/yy/mm")) {
            Toast.makeText(activity, "Select Date of Birth", Toast.LENGTH_SHORT).show();
            return false;
        }else if (binding.visitorDateOfVisit.getText().toString().equalsIgnoreCase("dd/yy/mm")) {
            Toast.makeText(activity, "Select Date of Visit", Toast.LENGTH_SHORT).show();
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