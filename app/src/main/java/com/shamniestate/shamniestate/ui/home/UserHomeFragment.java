package com.shamniestate.shamniestate.ui.home;

import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.AUTHORIZATION;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shamniestate.shamniestate.RetrofitApis.ApiInterface;
import com.shamniestate.shamniestate.RetrofitApis.RetrofitClient;
import com.shamniestate.shamniestate.adapters.HomePageSlider;
import com.shamniestate.shamniestate.adapters.HomePlanAdapter;
import com.shamniestate.shamniestate.adapters.MyAssociateAdapter;
import com.shamniestate.shamniestate.adapters.PopularPropertyAdapter;
import com.shamniestate.shamniestate.adapters.PropertyAdapter;
import com.shamniestate.shamniestate.databinding.FragmentUserHomeBinding;
import com.shamniestate.shamniestate.models.AmenitiesListModel;
import com.shamniestate.shamniestate.models.HomeDataModel;
import com.shamniestate.shamniestate.models.HomeSliderModel;
import com.shamniestate.shamniestate.models.MyAssociateModel;
import com.shamniestate.shamniestate.models.PropertyModel;
import com.shamniestate.shamniestate.models.PropertyPlanModel;
import com.shamniestate.shamniestate.ui.auth.LoginActivity;
import com.shamniestate.shamniestate.ui.misc.FilterActivity;
import com.shamniestate.shamniestate.utils.Session;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserHomeFragment extends Fragment {
    private Activity activity;
    private FragmentUserHomeBinding binding;
    private final List<HomeSliderModel.HomeSliderData> models = new ArrayList<>();
    private Session session;
    private List<AmenitiesListModel.AmenitiesData> amenitiesList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentUserHomeBinding.inflate(inflater, container, false);
        activity = getActivity();

        session = new Session(activity);

        getPropertyAmenities();
        getPropertyList();
        //getPropertyPlan();
        getMyAssociatesList();
        getHomeData();


        binding.homeBanerSliderNew.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        binding.homeBanerSliderNew.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        binding.homeBanerSliderNew.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        binding.homeBanerSliderNew.setScrollTimeInSec(2); //set scroll delay in seconds :
        binding.homeBanerSliderNew.startAutoCycle();

        binding.searchView.setOnClickListener(view -> startActivity(new Intent(getContext(), FilterActivity.class)));
        binding.userEmail.setOnClickListener(view -> startActivity(new Intent(getContext(), FilterActivity.class)));


        return binding.getRoot();

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

                            binding.homeRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
                            binding.homeRecycler.setAdapter(new PropertyAdapter(getContext(), response.body().getData()));

                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
                            linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
                            binding.popularPropertyRecycelr.setLayoutManager(linearLayoutManager);
                            binding.popularPropertyRecycelr.setAdapter(new PopularPropertyAdapter(activity, response.body().getData()));
                            binding.propertyProgress.setVisibility(View.GONE);
                            binding.categoryProgress.setVisibility(View.GONE);
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

    private void getPropertyAmenities() {
        ApiInterface apiInterface = RetrofitClient.getClient(activity);
        apiInterface.getPropertyAmenities(session.getAccessToken()).enqueue(new Callback<AmenitiesListModel>() {
            @Override
            public void onResponse(@NonNull Call<AmenitiesListModel> call, @NonNull Response<AmenitiesListModel> response) {
                if (response.code() == 200)
                    if (response.body() != null && response.body().getCode() == 200)
                        if (response.body().getData().size() != 0) {
                            amenitiesList = response.body().getData();
                        }
            }

            @Override
            public void onFailure(@NonNull Call<AmenitiesListModel> call, @NonNull Throwable t) {
                Log.e("TAG", "onFailure() called with: call = [" + call + "], t = [" + t.getLocalizedMessage() + "]");
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        getHomeData();
        getMyAssociatesList();
    }

    /* private void getPropertyPlan() {
            ApiInterface apiInterface = RetrofitClient.getClient(activity);
            apiInterface.getPropertyPlan(session.getAccessToken()).enqueue(new Callback<PropertyPlanModel>() {
                @Override
                public void onResponse(@NonNull Call<PropertyPlanModel> call, @NonNull Response<PropertyPlanModel> response) {
                    if (response.code() == 200)
                        if (response.body() != null && response.body().getCode() == 200)
                            if (response.body().getData().size() != 0) {
                                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
                                linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
                                binding.palnRecycelr.setLayoutManager(linearLayoutManager);
                                binding.palnRecycelr.setAdapter(new HomePlanAdapter(activity, response.body().getData()));
                            }
                }

                @Override
                public void onFailure(@NonNull Call<PropertyPlanModel> call, @NonNull Throwable t) {
                    Log.e("TAG", "onFailure() called with: call = [" + call + "], t = [" + t.getLocalizedMessage() + "]");
                }
            });
        }
    */
    private void getHomeData() {
        ApiInterface apiInterface = RetrofitClient.getClient(activity);

        apiInterface.getMyHomeData(
                session.getAccessToken(),
                session.getUserId()
        ).enqueue(new Callback<HomeDataModel>() {
            @Override
            public void onResponse(@NonNull Call<HomeDataModel> call, @NonNull Response<HomeDataModel> response) {
                binding.homeDataProgress.setVisibility(View.GONE);
                if(response.code() == 200)
                    if(response.body() != null)
                        if(response.body().getCode()  == 200){

                        }else {

                            session.setLogin(false);
                            startActivity(new Intent(activity , LoginActivity.class)
                                    .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                            );
                            session.logout();
                            activity.finish();
                            Toast.makeText(activity, "Server Not responding....!", Toast.LENGTH_SHORT).show();
                        }

            }

            @Override
            public void onFailure(@NonNull Call<HomeDataModel> call, @NonNull Throwable t) {
                binding.homeDataProgress.setVisibility(View.GONE);
                Log.e("TAG", "onFailure() called with: call = [" + call + "], t = [" + t.getLocalizedMessage() + "]");
            }
        });


    }

    private  void getMyAssociatesList(){

        ApiInterface apiInterface = RetrofitClient.getClient(activity);

        apiInterface.getMyAssociates(
                AUTHORIZATION,
                session.getAccessToken(),
                session.getUserId()
        ).enqueue(new Callback<MyAssociateModel>() {
            @Override
            public void onResponse(@NonNull Call<MyAssociateModel> call, @NonNull Response<MyAssociateModel> response) {
                try {
                    if(response.code() == 200)
                        if(response.body() != null ){
                            if(response.body().getCode() == 200){
                                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
                                linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                                binding.palnRecycelr.setLayoutManager(linearLayoutManager);
                                binding.palnRecycelr.setAdapter(new HomePlanAdapter(activity, response.body().getData()));
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
                Log.e("TAG", "onFailure() called with: call = [" + call + "], t = [" + t + "]");
            }
        });

    }
}