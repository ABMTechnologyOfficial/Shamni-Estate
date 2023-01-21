package com.shamniestate.shamniestate.ui.misc;

import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.AUTHORIZATION;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.shamniestate.shamniestate.RetrofitApis.ApiInterface;
import com.shamniestate.shamniestate.RetrofitApis.RetrofitClient;
import com.shamniestate.shamniestate.adapters.PropertyAmenitiesAdapter;
import com.shamniestate.shamniestate.adapters.SearchResultAdapter;
import com.shamniestate.shamniestate.databinding.ActivitySearchResultBinding;
import com.shamniestate.shamniestate.models.AmenitiesListModel;
import com.shamniestate.shamniestate.models.PropertyModel;
import com.shamniestate.shamniestate.utils.Session;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchResultActivity extends AppCompatActivity {
    private Activity activity;
    private ActivitySearchResultBinding binding;
    private Session session;
    private List<AmenitiesListModel.AmenitiesData> amenitiesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = this;
        session = new Session(activity);

        binding.textFilter.setOnClickListener(view -> finish());

        getPropertyAmenities();
    }

    private void getPropertyAmenities() {
        ApiInterface apiInterface = RetrofitClient.getClient(activity);
        apiInterface.getPropertyAmenities(session.getAccessToken()).enqueue(new Callback<AmenitiesListModel>() {
            @Override
            public void onResponse(@NonNull Call<AmenitiesListModel> call, @NonNull Response<AmenitiesListModel> response) {
                if (response.code() == 200)
                    if (response.body() != null && response.body().getCode() == 200)
                        if (response.body().getData().size() != 0) {
                            amenitiesList = response.body().getData();
                            getPropertyList();
                        }
            }

            @Override
            public void onFailure(@NonNull Call<AmenitiesListModel> call, @NonNull Throwable t) {
                Log.e("TAG", "onFailure() called with: call = [" + call + "], t = [" + t.getLocalizedMessage() + "]");
            }
        });
    }


    private void getPropertyList() {
        ApiInterface apiInterface = RetrofitClient.getClient(activity);
        apiInterface.getAllProperty(AUTHORIZATION, "").enqueue(new Callback<PropertyModel>() {
            @Override
            public void onResponse(@NonNull Call<PropertyModel> call, @NonNull Response<PropertyModel> response) {
                binding.progress.setVisibility(View.GONE);
                try {
                    if (response.code() == 200)
                        if (response.isSuccessful() && response.body() != null) {

                            ArrayList<PropertyModel.PropertyData> data = new ArrayList<>();

                            for (int i = 0; i < response.body().getData().size(); i++) {
                                PropertyModel.PropertyData current = response.body().getData().get(i);
                                String[] amenityArray = current.getAmenitiesId().split(",");

                                for (String currentAmenityId : amenityArray) {
                                    for (int x = 0; x < amenitiesList.size(); x++) {
                                        if (currentAmenityId.equalsIgnoreCase(amenitiesList.get(x).getAmenitiesId())) {
                                            current.getAmenitiesDataArrayList().add(amenitiesList.get(x));
                                            break;
                                        }
                                    }
                                }

                                data.add(current);
                            }

                            binding.recyclerView.setLayoutManager(new LinearLayoutManager(activity));
                            binding.recyclerView.setAdapter(new SearchResultAdapter(activity, data));
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

}