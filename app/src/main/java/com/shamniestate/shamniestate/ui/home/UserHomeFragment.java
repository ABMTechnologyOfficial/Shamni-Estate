package com.shamniestate.shamniestate.ui.home;

import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.AUTHORIZATION;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shamniestate.shamniestate.RetrofitApis.ApiInterface;
import com.shamniestate.shamniestate.RetrofitApis.RetrofitClient;
import com.shamniestate.shamniestate.adapters.HomePageSlider;
import com.shamniestate.shamniestate.adapters.HomePlanAdapter;
import com.shamniestate.shamniestate.adapters.PopularPropertyAdapter;
import com.shamniestate.shamniestate.adapters.PropertyAdapter;
import com.shamniestate.shamniestate.databinding.FragmentUserHomeBinding;
import com.shamniestate.shamniestate.models.HomeSliderModel;
import com.shamniestate.shamniestate.models.PropertyModel;
import com.shamniestate.shamniestate.models.PropertyPlanModel;
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
    private Session session ;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentUserHomeBinding.inflate(inflater, container, false);
        activity = getActivity();

        session = new Session(activity);

        getPropertyList();
        getPropertyPlan();

        binding.homeBanerSliderNew.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        binding.homeBanerSliderNew.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        binding.homeBanerSliderNew.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        binding.homeBanerSliderNew.setScrollTimeInSec(2); //set scroll delay in seconds :
        binding.homeBanerSliderNew.startAutoCycle();

        models.add(new HomeSliderModel.HomeSliderData(1));
        models.add(new HomeSliderModel.HomeSliderData(1));
        models.add(new HomeSliderModel.HomeSliderData(1));

        HomePageSlider homePageSlider = new HomePageSlider(models,getContext());
        binding.homeBanerSliderNew.setSliderAdapter(homePageSlider);

        binding.searchView.setOnClickListener(view -> startActivity(new Intent(getContext(), FilterActivity.class)));
        binding.userEmail.setOnClickListener(view -> startActivity(new Intent(getContext(), FilterActivity.class)));

        return binding.getRoot();

    }

    private void getPropertyList() {
        ApiInterface apiInterface = RetrofitClient.getClient(activity);
        apiInterface.getAllProperty(AUTHORIZATION,"").enqueue(new Callback<PropertyModel>() {
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
                            binding.popularPropertyRecycelr.setAdapter(new PopularPropertyAdapter(activity,response.body().getData()));
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

    private void getPropertyPlan() {
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
                            binding.palnRecycelr.setAdapter(new HomePlanAdapter(activity,response.body().getData()));
                        }
            }

            @Override
            public void onFailure(@NonNull Call<PropertyPlanModel> call, @NonNull Throwable t) {
                Log.e("TAG", "onFailure() called with: call = [" + call + "], t = [" + t.getLocalizedMessage() + "]");
            }
        });
    }
}