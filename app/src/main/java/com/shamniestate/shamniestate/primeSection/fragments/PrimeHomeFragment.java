package com.shamniestate.shamniestate.primeSection.fragments;

import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.AUTHORIZATION;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shamniestate.shamniestate.RetrofitApis.ApiInterface;
import com.shamniestate.shamniestate.RetrofitApis.RetrofitClient;
import com.shamniestate.shamniestate.adapters.PopularPropertyAdapter;
import com.shamniestate.shamniestate.adapters.PropertyAdapter;
import com.shamniestate.shamniestate.adapters.primeAdapters.PropertyListAdapter;
import com.shamniestate.shamniestate.databinding.FragmentPrimeHomeBinding;
import com.shamniestate.shamniestate.models.PropertyModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PrimeHomeFragment extends Fragment {


    FragmentPrimeHomeBinding binding;
    Activity activity;

    public PrimeHomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPrimeHomeBinding.inflate(getLayoutInflater());
        activity = requireActivity();

        getPropertyList();

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

                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
                            linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
                            binding.popularPropertyRecycelr.setLayoutManager(linearLayoutManager);
                            binding.popularPropertyRecycelr.setAdapter(new PopularPropertyAdapter(activity,response.body().getData()));
                            binding.propertyProgress.setVisibility(View.GONE);

                            binding.homeRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
                            binding.homeRecycler.setAdapter(new PropertyListAdapter(getContext(), response.body().getData()));
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