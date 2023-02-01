package com.shamniestate.shamniestate.ui.home;

import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.AUTHORIZATION;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.shamniestate.shamniestate.RetrofitApis.ApiInterface;
import com.shamniestate.shamniestate.RetrofitApis.RetrofitClient;
import com.shamniestate.shamniestate.databinding.ActivityHomeLoanInquiryBinding;
import com.shamniestate.shamniestate.models.PropertyPlanModel;
import com.shamniestate.shamniestate.models.PropertyTypeModel;
import com.shamniestate.shamniestate.models.SignupModel;
import com.shamniestate.shamniestate.utils.ProgressDialog;
import com.shamniestate.shamniestate.utils.Session;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeLoanInquiryActivity extends AppCompatActivity {

   private HomeLoanInquiryActivity activity ;
   private Session session ;
   private int selectedPropertyType = -1;
   private ArrayList<String> propertyName = new ArrayList<>();
   private ArrayList<Integer> propertyIds = new ArrayList<>();
   private ActivityHomeLoanInquiryBinding binding ;

   
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeLoanInquiryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = this ;
        session = new Session(activity);
        getPropertyType();
        binding.textSubmit.setOnClickListener(view -> {
            if(validate())
                submitEnquiry();
        });

    }

    private  boolean validate(){
        if(binding.edtEmail.getText().toString().equalsIgnoreCase("")){
            binding.edtEmail.setError("Enter Your Email...!");
            binding.edtEmail.requestFocus();
            return false;
        }else if(binding.edtName.getText().toString().equalsIgnoreCase("")){
            binding.edtName.setError("Enter Your Name...!");
            binding.edtName.requestFocus();
            return false;
        }else if(binding.edtMobile.getText().toString().equalsIgnoreCase("")){
            binding.edtMobile.setError("Enter Your Mobile...!");
            binding.edtMobile.requestFocus();
            return false;
        }else if(binding.edtLocation.getText().toString().equalsIgnoreCase("")){
            binding.edtLocation.setError("Enter Your Location...!");
            binding.edtLocation.requestFocus();
            return false;
        }else if(selectedPropertyType == -1 ){
            Toast.makeText(activity, "Select Property Type...!", Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }

    }

    private void submitEnquiry() {

        ProgressDialog pd = new ProgressDialog(activity);
        pd.show();

        ApiInterface apiInterface = RetrofitClient.getClient(activity);

        apiInterface.submitInquiry(
                AUTHORIZATION,
                binding.edtName.getText().toString(),
                binding.edtMobile.getText().toString(),
                binding.edtEmail.getText().toString(),
                binding.edtLocation.getText().toString(),
                String.valueOf(selectedPropertyType)
        ).enqueue(new Callback<SignupModel>() {
            @Override
            public void onResponse(@NonNull Call<SignupModel> call, @NonNull Response<SignupModel> response) {
              pd.dismiss();
                if(response.code() ==200 )
                    if(response.body() != null)
                        if(response.body().getCode() == 200){
                            Toast.makeText(activity, "Query Submit Successfully..!", Toast.LENGTH_SHORT).show();
                            finish();
                        }else {
                            Toast.makeText(activity, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        }
            }

            @Override
            public void onFailure(@NonNull Call<SignupModel> call, @NonNull Throwable t) {
                pd.dismiss();
                Log.e("TAG", "onFailure() called with: call = [" + call + "], t = [" + t.getLocalizedMessage() + "]");
            }
        });

    }

    private void getPropertyType() {
        ApiInterface apiInterface = RetrofitClient.getClient(activity);
        apiInterface.getPropertyType(session.getAccessToken()).enqueue(new Callback<PropertyTypeModel>() {
            @Override
            public void onResponse(@NonNull Call<PropertyTypeModel> call, @NonNull Response<PropertyTypeModel> response) {
                if (response.code() == 200)
                    if (response.body() != null && response.body().getCode() == 200)
                        if (response.body().getData().size() != 0) {
                            for (int i = 0; i < response.body().getData().size(); i++) {
                                propertyIds.add(Integer.parseInt(response.body().getData().get(i).getPropertyTypeMasterId()));
                                propertyName.add(response.body().getData().get(i).getPropertyTypeMasterName());
                            }
                            setAdapter();
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
                            for (int i = 0; i < response.body().getData().size(); i++) {
                                propertyIds.add(response.body().getData().get(i).getPropertyPlan());
                                propertyName.add(response.body().getData().get(i).getPropertyPlanName());
                            }

                            setAdapter();
                        }
            }

            @Override
            public void onFailure(@NonNull Call<PropertyPlanModel> call, @NonNull Throwable t) {
                Log.e("TAG", "onFailure() called with: call = [" + call + "], t = [" + t.getLocalizedMessage() + "]");
            }
        });
    }

    private void setAdapter() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity, android.R.layout.simple_spinner_item, propertyName);
        binding.propertyNameSpi.setAdapter(adapter);
        binding.propertyNameSpi.setOnItemSelectedListener((view, position, id, item) -> {
            selectedPropertyType = propertyIds.get(position);
            Log.e("TAG", "setAdapter() called selected Property id "+selectedPropertyType);
        });
    }
}