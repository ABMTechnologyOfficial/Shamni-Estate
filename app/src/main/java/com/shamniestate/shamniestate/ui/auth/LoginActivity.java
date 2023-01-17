package com.shamniestate.shamniestate.ui.auth;

import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.AUTHORIZATION;
import static com.shamniestate.shamniestate.utils.CommonMethods.isValidEmail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.shamniestate.shamniestate.RetrofitApis.ApiInterface;
import com.shamniestate.shamniestate.RetrofitApis.BaseUrls;
import com.shamniestate.shamniestate.RetrofitApis.RetrofitClient;
import com.shamniestate.shamniestate.databinding.ActivityLoginBinding;
import com.shamniestate.shamniestate.models.LoginModel;
import com.shamniestate.shamniestate.ui.home.UserHomeActivity;
import com.shamniestate.shamniestate.utils.ProgressDialog;
import com.shamniestate.shamniestate.utils.Session;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private Activity activity;
    private ActivityLoginBinding binding;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = LoginActivity.this;

        session = new Session(activity);

        binding.textSignup.setOnClickListener(view -> startActivity(new Intent(activity, SignupUserInfoActivity.class)));
        binding.textForgotPassword.setOnClickListener(view -> startActivity(new Intent(activity, ForgotPasswordActivity.class)));

        binding.textLogin.setOnClickListener(view -> validateLogin());
    }

    private void validateLogin() {
        if (binding.edtEmail.getText().toString().trim().equalsIgnoreCase("")) {
            binding.edtEmail.setError("Enter Email Address!");
            binding.edtEmail.requestFocus();
        } else if (!isValidEmail(binding.edtEmail.getText().toString().trim())) {
            binding.edtEmail.setError("Email Invalid");
            binding.edtEmail.requestFocus();
        } else if (binding.edtPassword.getText().toString().equalsIgnoreCase("")) {
            binding.edtPassword.setError("Enter Password ");
            binding.edtPassword.requestFocus();
        } else if (binding.edtPassword.getText().toString().length() < 3) {
            binding.edtPassword.setError("Password  Must Be Greater Then 3 digits");
            binding.edtPassword.requestFocus();
        } else {
            login(binding.edtEmail.getText().toString().trim(), binding.edtPassword.getText().toString().trim());
        }
    }


    private void login(String email, String password) {
        ProgressDialog pd = new ProgressDialog(activity);
        pd.show();

        ApiInterface apiInterface = RetrofitClient.getClient(activity);
        apiInterface.login(email, password, AUTHORIZATION).enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(@NonNull Call<LoginModel> call, @NonNull Response<LoginModel> response) {
                pd.dismiss();
                try {
                    if (response.code() == 200)
                        if (response.body() != null)
                            if (response.body().getCode() == 200) {
                                LoginModel.Datum data = response.body().getData().get(0);
                                session.setLogin(true);
                                session.setUserId(data.getAssociateId());
                                session.setAccessToken(data.getAccessToken());

                                startActivity(new Intent(activity, LoginSuccessActivity.class));
                                finish();

                            } else {
                                pd.dismiss();
                                Toast.makeText(activity, "Login Failed", Toast.LENGTH_SHORT).show();
                                Log.e(BaseUrls.TAG, "onResponse() called with: call = [" + call + "], response = [" + response + "]");
                            }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(@NonNull Call<LoginModel> call, @NonNull Throwable t) {
                pd.dismiss();
                Log.e(BaseUrls.TAG, "login onFailure() called with: call = [" + call + "], t = [" + t.getLocalizedMessage() + "]");
            }
        });
    }
}