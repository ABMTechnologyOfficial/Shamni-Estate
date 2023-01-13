package com.shamniestate.shamniestate.ui.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.shamniestate.shamniestate.RetrofitApis.ApiInterface;
import com.shamniestate.shamniestate.RetrofitApis.BaseUrls;
import com.shamniestate.shamniestate.RetrofitApis.RetrofitClient;
import com.shamniestate.shamniestate.databinding.ActivityBankingInformationBinding;
import com.shamniestate.shamniestate.models.BankListModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BankingInformationActivity extends AppCompatActivity {
    private Activity activity;
    private ActivityBankingInformationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBankingInformationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = BankingInformationActivity.this;

        binding.textContinue.setOnClickListener(view -> startActivity(new Intent(activity, SignupAuthenticationActivity.class)));
        binding.icBack.setOnClickListener(view -> onBackPressed());

        getBankList();
    }

    private void getBankList() {
        ApiInterface apiInterface = RetrofitClient.getClient(activity);
        apiInterface.getBankList().enqueue(new Callback<BankListModel>() {
            @Override
            public void onResponse(@NonNull Call<BankListModel> call, @NonNull Response<BankListModel> response) {
                try {
                    if (response.code() == 200)
                        if (response.body() != null)
                            if (response.body().getCode() == 200) {
                                List<BankListModel.Datum> data = response.body().getData();

                                ArrayList<String> bankListNames = new ArrayList<>();

                                for (int i = 0; i < data.size(); i++) {
                                    bankListNames.add(data.get(i).getBankName());
                                }

                                ArrayAdapter<String> adapter = new ArrayAdapter<>(activity, android.R.layout.simple_spinner_item, bankListNames);
                                binding.bankSpinner.setAdapter(adapter);

                            } else {
                                Log.e(BaseUrls.TAG, "onResponse() called with: call = [" + call + "], response = [" + response + "]");
                            }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(@NonNull Call<BankListModel> call, @NonNull Throwable t) {
                Log.e(BaseUrls.TAG, "login onFailure() called with: call = [" + call + "], t = [" + t.getLocalizedMessage() + "]");
            }
        });
    }
}