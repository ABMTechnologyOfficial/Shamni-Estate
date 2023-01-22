package com.shamniestate.shamniestate.ui.home;

import static android.content.ContentValues.TAG;
import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.AUTHORIZATION;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.RetrofitApis.ApiInterface;
import com.shamniestate.shamniestate.RetrofitApis.RetrofitClient;
import com.shamniestate.shamniestate.databinding.ActivityProfileDetailsBinding;
import com.shamniestate.shamniestate.models.UserProfileModel;
import com.shamniestate.shamniestate.utils.Session;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileDetailsActivity extends AppCompatActivity {

    private Session session ;
    private ActivityProfileDetailsBinding binding ;
    private  ProfileDetailsActivity activity ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this ;
        session = new Session(activity);

        getProfile();

    }

    private void getProfile() {

        Log.d(TAG, "getProfile() called"+session.getAccessToken());

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

                        String workingType= data.getWorkingType() ;
                        String accountType= data.getWorkingType() ;

                        if(workingType.equalsIgnoreCase("0")){
                            binding.workingType.setText("Part Time");
                        }else {
                            binding.workingType.setText("Full Time");
                        }

                        if(accountType.equalsIgnoreCase("0")){
                            binding.userType.setText("Individual");
                        }else if(accountType.equalsIgnoreCase("1")){
                            binding.userType.setText("Channel Partner");
                        }else {
                            binding.userType.setText("Associate Prime");
                        }

                        session.setUserName(data.getAssociateName());
                        binding.userName.setText(data.getAssociateName());
                        binding.userMobile.setText(data.getAssociateMobile());
                        binding.userAddress.setText(data.getAssociateAddress());
                        binding.userAadharNumber.setText(data.getAssociateAadharCardNo());
                        binding.userPanNumber.setText(data.getAssociatePanNo());
                        binding.userAccountHolderName.setText(data.getAssociateBnkAccName());
                        binding.userBankName.setText(data.getAssociateBankName());
                        binding.userCity.setText(data.getAssociateCity());
                        binding.userBankIfsc.setText(data.getAssociateBnkIfscNo());
                        binding.userBankAccountNumber.setText(data.getAssociateAccNo());

                        try {
                            if (!data.getAssociateBlankCheque().equalsIgnoreCase("")) {
                                Picasso.get().load(data.getAssociateBlankCheque()).placeholder(R.drawable.profile).into(binding.cancelChequeImage);
                            }

                            if (!data.getAssociateAadharCardFront().equalsIgnoreCase("")) {
                                Log.d(TAG, "onResponse() called with: call = "+ data.getAssociateAadharCardFront()+ "]");
                                Picasso.get().load(data.getAssociateAadharCardFront()).placeholder(R.drawable.profile).into(binding.aadharFrontImage);
                            }

                            if (!data.getAssociateAadharCardBack().equalsIgnoreCase("")) {
                                Log.d(TAG, "onResponse() called with: data.getAssociateAadharCardBack() = "+ data.getAssociateAadharCardBack()+ "]");
                                Picasso.get().load(data.getAssociateAadharCardBack()).placeholder(R.drawable.profile).into(binding.aadharBackImage);
                            }

                            if (!data.getAssociatePanCardFront().equalsIgnoreCase("")) {
                                Log.d(TAG, "onResponse() called with: data.getAssociatePanCardFront() = "+ data.getAssociatePanCardFront()+ "]");
                                Picasso.get().load(data.getAssociatePanCardFront()).placeholder(R.drawable.profile).into(binding.panImage);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }else {
                        Toast.makeText(activity, "No", Toast.LENGTH_SHORT).show();
                    }
            }

            @Override
            public void onFailure(@NonNull Call<UserProfileModel> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure() called with: call = [" + call + "], t = [" + t + "]");
            }
        });

    }
}