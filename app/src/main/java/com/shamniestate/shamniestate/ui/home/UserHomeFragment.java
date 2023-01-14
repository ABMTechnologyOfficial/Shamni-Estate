package com.shamniestate.shamniestate.ui.home;

import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.AUTHORIZATION;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shamniestate.shamniestate.RetrofitApis.ApiInterface;
import com.shamniestate.shamniestate.RetrofitApis.RetrofitClient;
import com.shamniestate.shamniestate.adapters.PropertyAdapter;
import com.shamniestate.shamniestate.databinding.FragmentUserHomeBinding;
import com.shamniestate.shamniestate.models.PropertyModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserHomeFragment extends Fragment {
    private Activity activity;
    private FragmentUserHomeBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentUserHomeBinding.inflate(inflater, container, false);
        activity = getActivity();

        getPropertyList();

        return binding.getRoot();
    }


    private void getPropertyList() {
        ApiInterface apiInterface = RetrofitClient.getClient(getContext());
        apiInterface.getAllProperty(AUTHORIZATION,"").enqueue(new Callback<PropertyModel>() {
            @Override
            public void onResponse(@NonNull Call<PropertyModel> call, @NonNull Response<PropertyModel> response) {
                binding.progress.setVisibility(View.GONE);
                try {
                    if (response.code() == 200)
                        if (response.isSuccessful() && response.body() != null) {
                            binding.homeRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
                            binding.homeRecycler.setAdapter(new PropertyAdapter(getContext(), response.body().getData()));
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