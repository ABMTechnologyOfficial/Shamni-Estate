package com.shamniestate.shamniestate.ui.misc;

import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.AUTHORIZATION;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.shamniestate.shamniestate.RetrofitApis.ApiInterface;
import com.shamniestate.shamniestate.RetrofitApis.RetrofitClient;
import com.shamniestate.shamniestate.adapters.SearchResultAdapter;
import com.shamniestate.shamniestate.databinding.ActivitySearchResultBinding;
import com.shamniestate.shamniestate.models.AmenitiesListModel;
import com.shamniestate.shamniestate.models.PropertyModel;
import com.shamniestate.shamniestate.utils.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchResultActivity extends AppCompatActivity {
    private final ArrayList<PropertyModel.PropertyData> data = new ArrayList<>();
    private Activity activity;
    private ActivitySearchResultBinding binding;
    private Session session;
    private List<AmenitiesListModel.AmenitiesData> amenitiesList;
    private String cityId = "";
    private String propertyAmenityId = "";
    private String propertyPlanId = "";
    private String propertyTypeId = "";
    private String maxBudget = "";
    private String minBudget = "";
    private ArrayList<PropertyModel.PropertyData> filteredList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = this;
        session = new Session(activity);

        cityId = getIntent().getStringExtra("cityId");
        propertyAmenityId = getIntent().getStringExtra("propertyAmenityId");
        propertyPlanId = getIntent().getStringExtra("propertyPlanId");
        propertyTypeId = getIntent().getStringExtra("propertyTypeId");
        maxBudget = getIntent().getStringExtra("maxBudget");
        minBudget = getIntent().getStringExtra("minBudget");

        binding.icBack.setOnClickListener(view -> finish());
        binding.textFilter.setOnClickListener(view -> finish());

        binding.edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filterTextSearch(editable.toString());
            }
        });

        getPropertyAmenities();
    }

    private void filterTextSearch(String text) {
        filteredList.clear();

        text = text.toLowerCase(Locale.ROOT);

        for (int i = 0; i < data.size(); i++) {
            PropertyModel.PropertyData current = data.get(i);

            boolean flag = current.getPropertyTitle().contains(text);

            if (current.getPropertyBuilder().toLowerCase(Locale.ROOT).contains(text))
                flag = true;
            if (current.getLocalityName().toLowerCase(Locale.ROOT).contains(text))
                flag = true;
            if (current.getPropertyAddress().toLowerCase(Locale.ROOT).contains(text))
                flag = true;

            if (flag)
                filteredList.add(current);
        }

        setAdapter();
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
                            data.clear();
                            filteredList.clear();

                            for (int i = 0; i < response.body().getData().size(); i++) {
                                boolean cityIdFlag = false;
                                boolean propertyAmenityIdFlag = false;
                                boolean propertyPlanIdFlag = false;
                                boolean propertyTypeIdFlag = false;
                                boolean maxBudgetFlag = false;
                                boolean minBudgetFlag = false;

                                PropertyModel.PropertyData current = response.body().getData().get(i);

                                if (cityId.isEmpty()) cityIdFlag = true;
                                else {
                                    if (cityId.contains(current.getPropertyCityId()))
                                        cityIdFlag = true;
                                }
                                if (propertyAmenityId.isEmpty()) propertyAmenityIdFlag = true;
                                else {
                                    String[] amenityArray = current.getAmenitiesId().split(",");
                                    for (String currentAmenityId : amenityArray) {
                                        if (propertyAmenityId.contains(currentAmenityId)) {
                                            propertyAmenityIdFlag = true;
                                            break;
                                        }
                                    }
                                }
                                if (propertyPlanId.isEmpty()) propertyPlanIdFlag = true;
                                else {
                                    if (propertyPlanId.contains(current.getPropertyPlanType()))
                                        propertyPlanIdFlag = true;
                                }
                                if (propertyTypeId.isEmpty()) propertyTypeIdFlag = true;
                                else {
                                    if (propertyPlanId.contains(current.getPropertyPlanType()))
                                        propertyTypeIdFlag = true;
                                }
                                if (maxBudget.isEmpty()) maxBudgetFlag = true;
                                else {
                                    if (Long.parseLong(current.getPropertyPricePerUnit()) < Long.parseLong(maxBudget))
                                        maxBudgetFlag = true;
                                }
                                if (minBudget.isEmpty()) minBudgetFlag = true;
                                else {
                                    if (Long.parseLong(current.getPropertyPricePerUnit()) > Long.parseLong(minBudget))
                                        minBudgetFlag = true;
                                }

                                Log.e("TAG", "cityIdFlag " + cityIdFlag);
                                Log.e("TAG", "propertyAmenityIdFlag " + propertyAmenityIdFlag);
                                Log.e("TAG", "propertyPlanIdFlag " + propertyPlanIdFlag);
                                Log.e("TAG", "propertyTypeIdFlag " + propertyTypeIdFlag);
                                Log.e("TAG", "maxBudgetFlag " + maxBudgetFlag);
                                Log.e("TAG", "minBudgetFlag " + minBudgetFlag);

                                if (cityIdFlag && propertyAmenityIdFlag && propertyPlanIdFlag &&
                                        propertyTypeIdFlag && maxBudgetFlag && minBudgetFlag) {
                                    String[] amenityArray = current.getAmenitiesId().split(",");

                                    for (String currentAmenityId : amenityArray) {
                                        for (int x = 0; x < amenitiesList.size(); x++) {
                                            if (currentAmenityId.equalsIgnoreCase(amenitiesList.get(x).getAmenitiesId())) {
                                                if (current.getAmenitiesDataArrayList() == null)
                                                    current.setAmenitiesDataArrayList(new ArrayList<>());
                                                current.getAmenitiesDataArrayList().add(amenitiesList.get(x));
                                                break;
                                            }
                                        }
                                    }

                                    data.add(current);
                                }
                            }

                            filteredList = new ArrayList<>(data);

                            setAdapter();
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

    private void setAdapter() {
        Log.e("TAG", "filteredList.size(): " + filteredList.size());

        if (filteredList.size() == 0) binding.textEmptyList.setVisibility(View.VISIBLE);
        else binding.textEmptyList.setVisibility(View.GONE);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        binding.recyclerView.setAdapter(new SearchResultAdapter(activity, filteredList));
    }

}