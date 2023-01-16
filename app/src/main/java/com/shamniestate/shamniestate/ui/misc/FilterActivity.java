package com.shamniestate.shamniestate.ui.misc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.shamniestate.shamniestate.RetrofitApis.ApiInterface;
import com.shamniestate.shamniestate.RetrofitApis.RetrofitClient;
import com.shamniestate.shamniestate.adapters.CityAdapter;
import com.shamniestate.shamniestate.adapters.PropertyAmenitiesAdapter;
import com.shamniestate.shamniestate.adapters.PropertyPlanAdapter;
import com.shamniestate.shamniestate.adapters.PropertyTypeAdapter;
import com.shamniestate.shamniestate.databinding.ActivityFilterBinding;
import com.shamniestate.shamniestate.models.AmenitiesListModel;
import com.shamniestate.shamniestate.models.CityListModel;
import com.shamniestate.shamniestate.models.PropertyPlanModel;
import com.shamniestate.shamniestate.models.PropertyTypeModel;
import com.shamniestate.shamniestate.utils.Session;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilterActivity extends AppCompatActivity {

    private FilterActivity activity;
    private Session session;
    private ActivityFilterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFilterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = this;
        session = new Session(activity);

        getPropertyType();
        getPropertyPlan();
        getPropertyAmenities();
        getCities();
    }

    private void getPropertyType() {

        ApiInterface apiInterface = RetrofitClient.getClient(activity);
        apiInterface.getPropertyType(session.getAccessToken()).enqueue(new Callback<PropertyTypeModel>() {
            @Override
            public void onResponse(@NonNull Call<PropertyTypeModel> call, @NonNull Response<PropertyTypeModel> response) {
                if (response.code() == 200)
                    if (response.body() != null && response.body().getCode() == 200)
                        if (response.body().getData().size() != 0) {
                            FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(activity);
                            layoutManager.setFlexDirection(FlexDirection.ROW);
                            layoutManager.setJustifyContent(JustifyContent.FLEX_START);
                            binding.typePropertyRecy.setLayoutManager(layoutManager);
                            binding.typePropertyRecy.setAdapter(new PropertyTypeAdapter(activity,response.body().getData()));
                        }
            }

            @Override
            public void onFailure(@NonNull Call<PropertyTypeModel> call, @NonNull Throwable t) {
                Log.e("TAG", "onFailure() called with: call = [" + call + "], t = [" + t.getLocalizedMessage() + "]");
            }
        });

    }


    private void getPropertyPlan() {

        ApiInterface apiInterface = RetrofitClient.getClient(activity);
        apiInterface.getPropertyPlan(session.getAccessToken()).enqueue(new Callback<PropertyPlanModel>() {
            @Override
            public void onResponse(@NonNull Call<PropertyPlanModel> call, @NonNull Response<PropertyPlanModel> response) {
                if (response.code() == 200)
                    if (response.body() != null && response.body().getCode() == 200)
                        if (response.body().getData().size() != 0) {
                            FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(activity);
                            layoutManager.setFlexDirection(FlexDirection.ROW);
                            layoutManager.setJustifyContent(JustifyContent.FLEX_START);
                            binding.planPropertyRecy.setLayoutManager(layoutManager);
                            binding.planPropertyRecy.setAdapter(new PropertyPlanAdapter(activity,response.body().getData()));
                        }
            }

            @Override
            public void onFailure(@NonNull Call<PropertyPlanModel> call, @NonNull Throwable t) {
                Log.e("TAG", "onFailure() called with: call = [" + call + "], t = [" + t.getLocalizedMessage() + "]");
            }
        });

    }

    private void getPropertyAmenities() {

        ApiInterface apiInterface = RetrofitClient.getClient(activity);
        apiInterface.getPropertyAmenities(session.getAccessToken()).enqueue(new Callback<AmenitiesListModel>() {
            @Override
            public void onResponse(@NonNull Call<AmenitiesListModel> call, @NonNull Response<AmenitiesListModel> response) {
                if (response.code() == 200)
                    if (response.body() != null && response.body().getCode() == 200)
                        if (response.body().getData().size() != 0) {
                            FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(activity);
                            layoutManager.setFlexDirection(FlexDirection.ROW);
                            layoutManager.setJustifyContent(JustifyContent.FLEX_START);
                            binding.amenitiesPropertyRecy.setLayoutManager(layoutManager);
                            binding.amenitiesPropertyRecy.setAdapter(new PropertyAmenitiesAdapter(activity,response.body().getData()));
                        }
            }

            @Override
            public void onFailure(@NonNull Call<AmenitiesListModel> call, @NonNull Throwable t) {
                Log.e("TAG", "onFailure() called with: call = [" + call + "], t = [" + t.getLocalizedMessage() + "]");
            }
        });

    }

    private void getCities() {

        ApiInterface apiInterface = RetrofitClient.getClient(activity);
        apiInterface.getCityList(session.getAccessToken()).enqueue(new Callback<CityListModel>() {
            @Override
            public void onResponse(@NonNull Call<CityListModel> call, @NonNull Response<CityListModel> response) {
                if (response.code() == 200)
                    if (response.body() != null && response.body().getCode() == 200)
                        if (response.body().getData().size() != 0) {
                            FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(activity);
                            layoutManager.setFlexDirection(FlexDirection.ROW);
                            layoutManager.setJustifyContent(JustifyContent.FLEX_START);
                            binding.cityPropertyRecy.setLayoutManager(layoutManager);
                            binding.cityPropertyRecy.setAdapter(new CityAdapter(activity,response.body().getData()));
                        }
            }

            @Override
            public void onFailure(@NonNull Call<CityListModel> call, @NonNull Throwable t) {
                Log.e("TAG", "onFailure() called with: call = [" + call + "], t = [" + t.getLocalizedMessage() + "]");
            }
        });

    }

}