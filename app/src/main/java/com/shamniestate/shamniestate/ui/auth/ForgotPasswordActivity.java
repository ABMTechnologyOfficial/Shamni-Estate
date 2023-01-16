package com.shamniestate.shamniestate.ui.auth;

import static com.shamniestate.shamniestate.utils.CommonMethods.isValidEmail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.shamniestate.shamniestate.RetrofitApis.ApiInterface;
import com.shamniestate.shamniestate.RetrofitApis.RetrofitClient;
import com.shamniestate.shamniestate.databinding.ActivityForgotPasswordBinding;
import com.shamniestate.shamniestate.models.SignupModel;
import com.shamniestate.shamniestate.utils.ProgressDialog;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPasswordActivity extends AppCompatActivity {

    ActivityForgotPasswordBinding binding;
    ForgotPasswordActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForgotPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        binding.textLogin.setOnClickListener(view -> {
            if (binding.edtEmail.getText().toString().equalsIgnoreCase("")) {
                binding.edtEmail.setError("Enter Your Email Address...!");
                binding.edtEmail.requestFocus();
            } else if (!isValidEmail(binding.edtEmail.getText().toString())) {
                binding.edtEmail.setError("Invalid Email...!");
                binding.edtEmail.requestFocus();
            } else {
                forgotPassword(binding.edtEmail.getText().toString());
            }
        });


    }


    private void forgotPassword(String s) {
        ProgressDialog progressDialog = new ProgressDialog(activity);
        progressDialog.show();

        ApiInterface apiInterface = RetrofitClient.getClient(activity);
        apiInterface.forgotPassword(s).enqueue(new Callback<SignupModel>() {
            @Override
            public void onResponse(@NonNull Call<SignupModel> call, @NonNull Response<SignupModel> response) {
               progressDialog.dismiss();
                if (response.code() == 200)
                    if (response.body() != null) {
                        if (response.body().getCode() == 200) {
                            Toast.makeText(activity, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
            }

            @Override
            public void onFailure(@NonNull Call<SignupModel> call, @NonNull Throwable t) {
                progressDialog.dismiss();
                Log.e("TAG", "onFailure() called with: call = [" + call + "], t = [" + t.getLocalizedMessage() + "]");
            }
        });

    }
}