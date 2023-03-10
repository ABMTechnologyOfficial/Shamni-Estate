package com.shamniestate.shamniestate.ui.misc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.shamniestate.shamniestate.models.FilterInterface;
import com.shamniestate.shamniestate.models.PropertyPlanModel;
import com.shamniestate.shamniestate.models.PropertyTypeModel;
import com.shamniestate.shamniestate.utils.Session;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilterActivity extends AppCompatActivity implements FilterInterface {

    private FilterActivity activity;
    private Session session;
    private ActivityFilterBinding binding;
    private final ArrayList<String> cityIdList = new ArrayList<>();
    private final ArrayList<String> propertyAmenityIdList = new ArrayList<>();
    private final ArrayList<String> propertyPlanIdList = new ArrayList<>();
    private final ArrayList<String> propertyTypeIdList = new ArrayList<>();

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

        binding.textApply.setOnClickListener(view -> startSearch());
    }

    private void startSearch() {
        String cityId = cityIdList.toString().replaceAll("\\[", "").replaceAll("]", "").replaceAll(" ", "").trim();
        String propertyAmenityId = propertyAmenityIdList.toString().replaceAll("\\[", "").replaceAll("]", "").replaceAll(" ", "").trim();
        String propertyPlanId = propertyPlanIdList.toString().replaceAll("\\[", "").replaceAll("]", "").replaceAll(" ", "").trim();
        String propertyTypeId = propertyTypeIdList.toString().replaceAll("\\[", "").replaceAll("]", "").replaceAll(" ", "").trim();
        String maxBudget = "";
        String minBudget = "";

        startActivity(new Intent(activity, SearchResultActivity.class)
                .putExtra("cityId", cityId)
                .putExtra("propertyAmenityId", propertyAmenityId)
                .putExtra("propertyPlanId", propertyPlanId)
                .putExtra("propertyTypeId", propertyTypeId)
                .putExtra("maxBudget", maxBudget)
                .putExtra("minBudget", minBudget)
        );
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
                            binding.typePropertyRecy.setAdapter(new PropertyTypeAdapter(activity, response.body().getData(), FilterActivity.this));
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
                            binding.planPropertyRecy.setAdapter(new PropertyPlanAdapter(activity, response.body().getData(), FilterActivity.this));
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
                            binding.amenitiesPropertyRecy.setAdapter(new PropertyAmenitiesAdapter(activity, response.body().getData(), FilterActivity.this));
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
                            binding.cityPropertyRecy.setAdapter(new CityAdapter(activity, response.body().getData(), FilterActivity.this));
                        }
            }

            @Override
            public void onFailure(@NonNull Call<CityListModel> call, @NonNull Throwable t) {
                Log.e("TAG", "onFailure() called with: call = [" + call + "], t = [" + t.getLocalizedMessage() + "]");
            }
        });
    }

    @Override
    public void addItem(String id, int mode) {
        if (mode == 0) {
            cityIdList.add(id);
        } else if (mode == 1) {
            propertyAmenityIdList.add(id);
        } else if (mode == 2) {
            propertyPlanIdList.add(id);
        } else if (mode == 3) {
            propertyTypeIdList.add(id);
        }
    }

    @Override
    public void deleteItem(String id, int mode) {
        if (mode == 0) {
            cityIdList.remove(id);
        } else if (mode == 1) {
            propertyAmenityIdList.remove(id);
        } else if (mode == 2) {
            propertyPlanIdList.remove(id);
        } else if (mode == 3) {
            propertyTypeIdList.remove(id);
        }
    }
}