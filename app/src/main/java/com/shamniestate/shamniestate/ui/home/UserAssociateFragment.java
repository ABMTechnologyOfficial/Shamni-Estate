package com.shamniestate.shamniestate.ui.home;

import static android.content.ContentValues.TAG;

import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.AUTHORIZATION;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.shamniestate.shamniestate.RetrofitApis.ApiInterface;
import com.shamniestate.shamniestate.RetrofitApis.RetrofitClient;
import com.shamniestate.shamniestate.databinding.FragmentUserAssociateBinding;
import com.shamniestate.shamniestate.databinding.FragmentUserNeedHelpBinding;
import com.shamniestate.shamniestate.models.LoginModel;
import com.shamniestate.shamniestate.models.UserProfileModel;
import com.shamniestate.shamniestate.ui.misc.AboutUsActivity;
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

        binding.editProfile.setOnClickListener(v -> startActivity(new Intent(activity, ProfileDetailsActivity.class).putExtra("associateId", session.getUserId())));

        binding.textName.setText(session.getUserName());
        binding.logout.setOnClickListener(view -> logout());
        binding.chatWithAdmin.setOnClickListener(view -> {
            String url = "https://api.whatsapp.com/send?phone=+919993511311";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });

        binding.aboutUs.setOnClickListener(view -> startActivity(new Intent(activity, AboutUsActivity.class)));
        getProfile();
        return binding.getRoot();

    }

    private void getProfile() {

        Log.d(TAG, "getProfile() called" + session.getAccessToken());

        ApiInterface apiInterface = RetrofitClient.getClient(activity);
        apiInterface.getProfile(
                AUTHORIZATION,
                session.getUserId().trim()
        ).enqueue(new Callback<UserProfileModel>() {
            @Override
            public void onResponse(@NonNull Call<UserProfileModel> call, @NonNull Response<UserProfileModel> response) {
                if (response.code() == 200 && response.body() != null)
                    if (response.body().getCode() == 200) {
                        UserProfileModel.ProfileData.UserProfile data = response.body().getData().getUserProfile().get(0);

                        String workingType = data.getWorkingType();
                        String accountType = data.getWorkingType();

                        if (workingType.equalsIgnoreCase("0")) {
                            binding.workingType.setText("Part Time");
                        } else {
                            binding.workingType.setText("Full Time");
                        }

                        if (accountType.equalsIgnoreCase("0")) {
                            binding.userType.setText("Individual");
                        } else if (accountType.equalsIgnoreCase("1")) {
                            binding.userType.setText("Channel Partner");
                        } else {
                            binding.userType.setText("Associate Prime");
                        }

                        session.setUserName(data.getAssociateName());
                        binding.textName.setText(data.getAssociateName());
                        binding.textPhone.setText(data.getAssociateMobile());
                        binding.textAddress.setText(data.getAssociateAddress());
                        /// Picasso.get().load(data.getAssociateProfile()).placeholder(R.drawable.profile).into(binding.profileimg);

                    } else {
                        Toast.makeText(activity, "No", Toast.LENGTH_SHORT).show();
                    }
            }

            @Override
            public void onFailure(@NonNull Call<UserProfileModel> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure() called with: call = [" + call + "], t = [" + t + "]");
            }
        });

    }

    private void logout() {
        new AlertDialog.Builder(activity)
                .setTitle("Logout?")
                .setMessage("Are you sure you want to logout?")
                .setPositiveButton("Yes", (dialogInterface, i) -> session.logout())
                .setNegativeButton("Cancel", null)
                .show();
    }
}