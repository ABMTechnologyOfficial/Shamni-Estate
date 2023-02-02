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
import com.shamniestate.shamniestate.adapters.BookedPropertyAdapter;
import com.shamniestate.shamniestate.databinding.ActivityMyBookedPropertyBinding;
import com.shamniestate.shamniestate.models.BookedPropertyModel;
import com.shamniestate.shamniestate.utils.Session;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyBookedPropertyActivity extends AppCompatActivity {

    private Session session ;
    private ActivityMyBookedPropertyBinding binding ;
    private  MyBookedPropertyActivity activity ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyBookedPropertyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = this ;
        session = new Session(activity);

        getMyBookedProperty();

    }

    private  void getMyBookedProperty(){

        ApiInterface apiInterface = RetrofitClient.getClient(activity);
        apiInterface.getMyBookedProperty(
                session.getAccessToken(),
                session.getUserId()
        ).enqueue(new Callback<BookedPropertyModel>() {
            @Override
            public void onResponse(@NonNull Call<BookedPropertyModel> call, @NonNull Response<BookedPropertyModel> response) {
                if(response.code() == 200)
                    if(response.body() != null)
                        if(response.body().getCode() == 200){

                            binding.bookedRecycelr.setLayoutManager(new LinearLayoutManager(activity));
                            binding.bookedRecycelr.setAdapter(new BookedPropertyAdapter(activity,response.body().getData()));
                            binding.progressBooked.setVisibility(View.GONE);
                            binding.noDataTv.setVisibility(View.GONE);
                        }else {
                            Toast.makeText(activity, "No Booked Property Found...!", Toast.LENGTH_SHORT).show();
                            binding.progressBooked.setVisibility(View.GONE);
                            binding.noDataTv.setVisibility(View.VISIBLE);
                        }

            }

            @Override
            public void onFailure(@NonNull Call<BookedPropertyModel> call, @NonNull Throwable t) {
                binding.progressBooked.setVisibility(View.GONE);
                binding.noDataTv.setVisibility(View.VISIBLE);
                Toast.makeText(activity, "Server not responding...!", Toast.LENGTH_SHORT).show();
                Log.e("TAG", "onFailure() called with: call = [" + call + "], t = [" + t.getLocalizedMessage() + "]");
            }
        });



    }
}