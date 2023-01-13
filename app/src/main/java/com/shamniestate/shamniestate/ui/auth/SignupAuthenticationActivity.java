package com.shamniestate.shamniestate.ui.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.shamniestate.shamniestate.databinding.ActivitySignupAuthenticationBinding;
import com.shamniestate.shamniestate.models.UtilModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        binding.textContinue.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    model.setAssociateEmail(binding.userEmail.getText().toString());
                    Log.e("TAG", "onClick() called with: v = [" + model.toString() + "]");
                }
            }
        });

    }

    public boolean emailValidator(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }


    private  boolean validate(){

        if(binding.userEmail.getText().toString().equalsIgnoreCase("")){
            binding.userEmail.setError("Enter Account  Number");
            binding.userEmail.requestFocus();
            return  false ;
        }else   if(binding.userPassword.getText().toString().equalsIgnoreCase("")){
            binding.userPassword.setError("Enter  Bank Holder Name");
            binding.userPassword.requestFocus();
            return  false ;
        }else if(binding.userCPassword.getText().toString().equalsIgnoreCase("")){
            binding.userCPassword.setError("Enter IFSC Code ");
            binding.userCPassword.requestFocus();
            return  false ;
        }else if(!binding.userCPassword.getText().toString().equalsIgnoreCase((binding.userCPassword.getText().toString()))){
            Toast.makeText(activity, "Password Not Match.!", Toast.LENGTH_SHORT).show();
            return  false ;
        }else if(!emailValidator(binding.userEmail.getText().toString())){
            binding.userEmail.setError("Invalid Email.!");
            binding.userEmail.requestFocus();
            return  false ;
        }
        else {
            return  true ;
        }

    }
}