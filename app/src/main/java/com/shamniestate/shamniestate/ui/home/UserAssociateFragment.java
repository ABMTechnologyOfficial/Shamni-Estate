package com.shamniestate.shamniestate.ui.home;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shamniestate.shamniestate.RetrofitApis.ApiInterface;
import com.shamniestate.shamniestate.RetrofitApis.RetrofitClient;
import com.shamniestate.shamniestate.databinding.FragmentUserAssociateBinding;
import com.shamniestate.shamniestate.databinding.FragmentUserNeedHelpBinding;
import com.shamniestate.shamniestate.models.LoginModel;
import com.shamniestate.shamniestate.utils.Session;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UserAssociateFragment extends Fragment {
    private Activity activity;
    private FragmentUserAssociateBinding binding;
    private Session session;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentUserAssociateBinding.inflate(inflater, container, false);
        activity = requireActivity();

        session = new Session(activity);

        binding.editProfile.setOnClickListener(v -> startActivity(new Intent(activity, ProfileDetailsActivity.class)));

        getProfile();
        return binding.getRoot();
    }

    private void getProfile() {

        Log.d(TAG, "getProfile() called"+session.getAccessToken());

        ApiInterface apiInterface = RetrofitClient.getClient(activity);
        apiInterface.getProfile(
                session.getAccessToken().trim(),
                session.getUserId().trim()
        ).enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(@NonNull Call<LoginModel> call, @NonNull Response<LoginModel> response) {
                if (response.code() == 200 && response.body() != null)
                    if (response.body().getCode() == 200) {
                        LoginModel.Datum data = response.body().getData().get(0);
//
//                        binding.textName.setText(data.getAssociateName());
//                        binding.textPhone.setText(data.getAssociateMobile());
//                        binding.textAddress.setText(data.getAssociateAddress());
//                        Picasso.get().load(data.getAssociateProfile()).placeholder(R.drawable.profile).into(binding.profileimg);
                    }
            }

            @Override
            public void onFailure(@NonNull Call<LoginModel> call, @NonNull Throwable t) {

            }
        });

    }

}