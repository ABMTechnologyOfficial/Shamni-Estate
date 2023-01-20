package com.shamniestate.shamniestate.ui.misc;

import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.AUTHORIZATION;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.shamniestate.shamniestate.RetrofitApis.ApiInterface;
import com.shamniestate.shamniestate.RetrofitApis.RetrofitClient;
import com.shamniestate.shamniestate.adapters.PopularPropertyAdapter;
import com.shamniestate.shamniestate.adapters.PropertyAdapter;
import com.shamniestate.shamniestate.databinding.ActivitySearchResultBinding;
import com.shamniestate.shamniestate.models.PropertyModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchResultActivity extends AppCompatActivity {
    private Activity activity;
    private ActivitySearchResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = this;

      ///  getPropertyList();
    }


 /*
    private void getPropertyList() {
        ApiInterface apiInterface = RetrofitClient.getClient(activity);
        apiInterface.getAllProperty(AUTHORIZATION,"").enqueue(new Callback<PropertyModel>() {
            @Override
            public void onResponse(@NonNull Call<PropertyModel> call, @NonNull Response<PropertyModel> response) {
                binding.progress.setVisibility(View.GONE);
                try {
                    if (response.code() == 200)
                        if (response.isSuccessful() && response.body() != null) {
                            binding.recyclerView.setLayoutManager(new LinearLayoutManager(activity));
                            binding.recyclerView.setAdapter(new PropertyAdapter(activity, response.body().getData()));

                        }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(@NonNull Call<PropertyModel> call, @NonNull Throwable t) {
                binding.progress.setVisibility(View.GONE);
                Log.e("TAG", "onFailure() called with: call = [" + call + "], t = [" + t.getLocalizedMessage() + "]");
            }
        });
    }

  */

}