package com.shamniestate.shamniestate.visitors;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.RetrofitApis.ApiInterface;
import com.shamniestate.shamniestate.RetrofitApis.RetrofitClient;
import com.shamniestate.shamniestate.databinding.ActivityVisitorProfileBinding;
import com.shamniestate.shamniestate.models.VisitorDetailsModel;
import com.shamniestate.shamniestate.models.VisitorsListModel;
import com.shamniestate.shamniestate.utils.ProgressDialog;
import com.shamniestate.shamniestate.utils.Session;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VisitorProfileActivity extends AppCompatActivity {

    ActivityVisitorProfileBinding binding ;
    private  VisitorProfileActivity activity ;
    private Session session ;
    private  String visitorId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVisitorProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this ;
        session = new Session(activity);

        visitorId = getIntent().getStringExtra("visitorId");

         getVisitorDetails();
    }

    private  void getVisitorDetails(){

        ProgressDialog pd = new ProgressDialog(activity);
        pd.show();
        ApiInterface apiInterface = RetrofitClient.getClient(activity);
        apiInterface.getMyVisitorsDetails(
                session.getAccessToken(),
                visitorId
        ).enqueue(new Callback<VisitorDetailsModel>() {
            @Override
            public void onResponse(@NonNull Call<VisitorDetailsModel> call, @NonNull Response<VisitorDetailsModel> response) {

                pd.dismiss();
                if(response.code() == 200 )
                    if(response.body() != null)
                        if(response.body().getCode() == 200){

                            VisitorDetailsModel.VisitorDetailsData data = response.body().getData().get(0);

                            binding.userAadharNumber.setText(data.getVisitorAadharCardNo());
                            binding.userName.setText(data.getVisitorName());
                            binding.userAddress.setText(data.getVisitorAddress());
                            binding.userCity.setText(data.getVisitorCity());
                            binding.visitDate.setText(data.getVisitorDov());
                            binding.visitorDob.setText(data.getVisitorDob());
                            binding.visitorBudget.setText(data.getVisitorBudget());
                            binding.visitorProfession.setText(data.getVisitorProffession());
                            binding.visitorUnitNumber.setText(data.getVisitorUnitNo());
                            binding.projectCode.setText(data.getVisitorProjectCode());
                            binding.projectName.setText(data.getVisitorProjectName());
                            binding.userEmail.setText(data.getVisitorEmail());
                            binding.userAadharNumber.setText(data.getVisitorAadharCardNo());

                            Picasso.get().load(data.getVisitorSelfie()).placeholder(R.drawable.profile).into(binding.profileImage);
                            Picasso.get().load(data.getVisitorAadharCardBack()).placeholder(R.drawable.profile).into(binding.aadharBackImage);
                            Picasso.get().load(data.getVisitorAadharCardFront()).placeholder(R.drawable.profile).into(binding.aadharFrontImage);


                        }else {
                            Toast.makeText(activity, "Visitor Details Not found...", Toast.LENGTH_SHORT).show();
                        }


            }

            @Override
            public void onFailure(@NonNull Call<VisitorDetailsModel> call, @NonNull Throwable t) {
                pd.dismiss();
                Log.e("TAG", "onFailure() called with: call = [" + call + "], t = [" + t.getLocalizedMessage() + "]");
            }
        });

    }

}