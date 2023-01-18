package com.shamniestate.shamniestate.ui.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.RetrofitApis.ApiInterface;
import com.shamniestate.shamniestate.RetrofitApis.RetrofitClient;
import com.shamniestate.shamniestate.adapters.MyAssociateAdapter;
import com.shamniestate.shamniestate.databinding.ActivityMyAssociatesBinding;
import com.shamniestate.shamniestate.databinding.MyAssociateLayoutBinding;
import com.shamniestate.shamniestate.models.LoginModel;
import com.shamniestate.shamniestate.models.MyAssociateModel;
import com.shamniestate.shamniestate.utils.Session;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyAssociatesActivity extends AppCompatActivity {


    private ActivityMyAssociatesBinding binding;
    private MyAssociatesActivity activity;
    private Session session ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyAssociatesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        session = new Session(activity);
        binding.icBack.setOnClickListener(v -> onBackPressed());

        getMyAssociatesList();
    }

    private  void getMyAssociatesList(){

        ApiInterface apiInterface = RetrofitClient.getClient(activity);

        apiInterface.getMyAssociates(
                session.getAccessToken(),
                session.getUserId()
        ).enqueue(new Callback<MyAssociateModel>() {
            @Override
            public void onResponse(@NonNull Call<MyAssociateModel> call, @NonNull Response<MyAssociateModel> response) {
                binding.myAssocProgress.setVisibility(View.GONE);
                try {
                    if(response.code() == 200)
                        if(response.body() != null ){
                            if(response.body().getCode() == 200){
                                binding.myAssocRecycler.setLayoutManager(new LinearLayoutManager(activity));
                                binding.myAssocRecycler.setAdapter(new MyAssociateAdapter(activity,response.body().getData()));
                            }else {
                                Toast.makeText(activity, "No Associates Found", Toast.LENGTH_SHORT).show();
                            }
                        }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(@NonNull Call<MyAssociateModel> call, @NonNull Throwable t) {
                binding.myAssocProgress.setVisibility(View.GONE);
                Log.e("TAG", "onFailure() called with: call = [" + call + "], t = [" + t + "]");
            }
        });

    }
}