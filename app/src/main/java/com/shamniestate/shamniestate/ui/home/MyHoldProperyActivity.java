package com.shamniestate.shamniestate.ui.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.shamniestate.shamniestate.RetrofitApis.ApiInterface;
import com.shamniestate.shamniestate.RetrofitApis.RetrofitClient;
import com.shamniestate.shamniestate.adapters.HoldPropertyAdapter;
import com.shamniestate.shamniestate.databinding.ActivityMyHoldProperyBinding;
import com.shamniestate.shamniestate.models.HoldPropertyModel;
import com.shamniestate.shamniestate.utils.Session;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyHoldProperyActivity extends AppCompatActivity {

    ActivityMyHoldProperyBinding binding ;
    MyHoldProperyActivity activity ;
    Session session ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyHoldProperyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity  = this ;
        session = new Session(activity);

        binding.icBack.setOnClickListener(view -> onBackPressed());

    }

    @Override
    protected void onResume() {
        super.onResume();
        getHoldProperty();
    }

    private  void getHoldProperty(){

        ApiInterface apiInterface = RetrofitClient.getClient(activity);
        apiInterface.getMyHoldProperty(session.getAccessToken(),session.getUserId()).enqueue(new Callback<HoldPropertyModel>() {
            @Override
            public void onResponse(@NonNull Call<HoldPropertyModel> call, @NonNull Response<HoldPropertyModel> response) {
                if(response.code() == 200)
                    if(response.body() != null)
                        if(response.body().getCode() == 200){

                            binding.bookedRecycelr.setLayoutManager(new LinearLayoutManager(activity));
                            binding.bookedRecycelr.setAdapter(new HoldPropertyAdapter(activity,response.body().getData()));
                            binding.progressBooked.setVisibility(View.GONE);
                            binding.noDataTv.setVisibility(View.GONE);
                        }else {
                            Toast.makeText(activity, "No Booked Property Found...!", Toast.LENGTH_SHORT).show();
                            binding.progressBooked.setVisibility(View.GONE);
                            binding.noDataTv.setVisibility(View.VISIBLE);
                        }
            }

            @Override
            public void onFailure(@NonNull Call<HoldPropertyModel> call, @NonNull Throwable t) {
                binding.progressBooked.setVisibility(View.GONE);
                binding.noDataTv.setVisibility(View.VISIBLE);
                Toast.makeText(activity, "Server not responding...!", Toast.LENGTH_SHORT).show();
            }
        });




    }
}