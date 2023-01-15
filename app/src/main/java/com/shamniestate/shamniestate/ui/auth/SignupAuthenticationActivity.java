package com.shamniestate.shamniestate.ui.auth;

import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.AUTHORIZATION;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.shamniestate.shamniestate.RetrofitApis.ApiInterface;
import com.shamniestate.shamniestate.RetrofitApis.RetrofitClient;
import com.shamniestate.shamniestate.databinding.ActivitySignupAuthenticationBinding;
import com.shamniestate.shamniestate.models.SignupModel;
import com.shamniestate.shamniestate.models.UtilModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupAuthenticationActivity extends AppCompatActivity {
    private Activity activity;
    private ActivitySignupAuthenticationBinding binding;
    private UtilModel model = new UtilModel();
    private  String selectedShamniType = "";
    private boolean isChecked = false ;

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

                    String trms = "0";
                    if (isChecked) trms = "1";

                    ApiInterface apiInterface = RetrofitClient.getClient(activity);
                    apiInterface.signup(
                            AUTHORIZATION,
                            model.getAccountType(),
                            model.getAssociateName(),
                            model.getAssociateDob(),
                            model.getAssociateGender(),
                            model.getAssociateMobile(),
                            model.getAssociateAddress(),
                            model.getAssociateCity(),
                            model.getAssociateState(),
                            model.getAssociateCityZip(),
                            model.getAssociateAadharCardNo(),
                            model.getAssociatePanNo(),
                            model.getAssociateBankName(),
                            model.getAssociateBnkAccName(),
                            model.getAssociateBnkIfscNo(),
                            model.getAssociateBnkAccName(),
                            binding.userEmail.getText().toString(),
                            binding.userPassword.getText().toString(),
                            binding.userCPassword.getText().toString(),
                            binding.userReferrralCode.getText().toString(),
                            trms,
                            model.getAssociateReraRegNo()
                    ).enqueue(new Callback<SignupModel>() {
                        @Override
                        public void onResponse(@NonNull Call<SignupModel> call, @NonNull Response<SignupModel> response) {

                        }

                        @Override
                        public void onFailure(@NonNull Call<SignupModel> call, @NonNull Throwable t) {
                            Log.e("TAG", "onFailure() called with: call = [" + call + "], t = [" + t + "]");
                        }
                    });

                }
            }
        });

        binding.radioGroup.setOnCheckedChangeListener((radioGroup, i) -> {
            if(i == 0 ){
                selectedShamniType = "yes";
            }else {
                selectedShamniType = "no";
            }
        });

        binding.userShamniCheck.setOnCheckedChangeListener((compoundButton, b) -> {
            isChecked = b;
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
        }else if(!isChecked){
            Toast.makeText(activity, "Please Check Terms And Conditions...!", Toast.LENGTH_SHORT).show();
            return  false ;
        }else if(!emailValidator(binding.userEmail.getText().toString())){
            binding.userEmail.setError("Invalid Email.!");
            binding.userEmail.requestFocus();
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