package com.shamniestate.shamniestate.ui.home;

import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.AUTHORIZATION;
import static com.shamniestate.shamniestate.utils.CommonMethods.isValidEmail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.RetrofitApis.ApiInterface;
import com.shamniestate.shamniestate.RetrofitApis.RetrofitClient;
import com.shamniestate.shamniestate.databinding.ActivityBookHoldPropertyBinding;
import com.shamniestate.shamniestate.models.SignupModel;
import com.shamniestate.shamniestate.utils.ProgressDialog;
import com.shamniestate.shamniestate.utils.Session;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookHoldPropertyActivity extends AppCompatActivity {

    private ActivityBookHoldPropertyBinding binding ;
    private  BookHoldPropertyActivity activity ;
    private Session session ;
    private  String type  ,selectedDate = "",slotId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookHoldPropertyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = this ;
        session = new Session(activity);

        type  = getIntent().getStringExtra("type");
        slotId  = getIntent().getStringExtra("slotId");

        if(type.equalsIgnoreCase("book"))
            binding.title.setText("Book Property");
        else
            binding.title.setText("Hold Property");


        binding.textContinue.setOnClickListener(v -> {
            if(isValidate()){
             bookHoldSlot();
            }
        });

        binding.icBack.setOnClickListener(v -> onBackPressed());

        binding.userDobEdit.setOnClickListener(v -> selectDate(binding.userDobEdit));
    }

    private void bookHoldSlot() {
        ProgressDialog pd = new ProgressDialog(activity);
        pd.show();

        ApiInterface apiInterface = RetrofitClient.getClient(activity);

        Call<SignupModel> call ;
        if(type.equalsIgnoreCase("book"))
        {
            call = apiInterface.bookProperty(
                    AUTHORIZATION,
                    session.getAccessToken(),
                    slotId,
                    session.getUserId(),
                    binding.userNameEdit.getText().toString(),
                    binding.userDobEdit.getText().toString(),
                    binding.userFatherEdit.getText().toString(),
                    binding.userMobileEdit1.getText().toString(),
                    binding.userMobileEdit2.getText().toString(),
                    binding.userCityEdit.getText().toString(),
                    binding.userStateEdit.getText().toString(),
                    binding.userZipEdit.getText().toString(),
                    binding.userAddressEditPermanent.getText().toString(),
                    binding.userAddressEditCurrent.getText().toString(),
                    binding.userPanNumber.getText().toString(),
                    binding.userEnail.getText().toString()
            );

        }else {
            call = apiInterface.holdProperty(
                    AUTHORIZATION,
                    session.getAccessToken(),
                    slotId,
                    session.getUserId(),
                    binding.userNameEdit.getText().toString(),
                    binding.userDobEdit.getText().toString(),
                    binding.userFatherEdit.getText().toString(),
                    binding.userMobileEdit1.getText().toString(),
                    binding.userMobileEdit2.getText().toString(),
                    binding.userCityEdit.getText().toString(),
                    binding.userStateEdit.getText().toString(),
                    binding.userZipEdit.getText().toString(),
                    binding.userAddressEditPermanent.getText().toString(),
                    binding.userAddressEditCurrent.getText().toString(),
                    binding.userPanNumber.getText().toString(),
                    binding.userEnail.getText().toString()
            );


        }

        call.enqueue(new Callback<SignupModel>() {
            @Override
            public void onResponse(@NonNull Call<SignupModel> call, @NonNull Response<SignupModel> response) {
                pd.dismiss();
                if(response.code() == 200)
                    if(response.body() != null)
                        if(response.body().getCode() == 200){
                            Toast.makeText(BookHoldPropertyActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                          finish();
                        }else {
                            Toast.makeText(BookHoldPropertyActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        }
            }

            @Override
            public void onFailure(@NonNull Call<SignupModel> call, @NonNull Throwable t) {
                pd.dismiss();
                Log.e("TAG", "onFailure() called with: call = [" + call + "], t = [" + t + "]");
            }
        });

    }


    private  boolean isValidate(){

        if(binding.userAddressEditCurrent.getText().toString().equalsIgnoreCase("")){
            binding.userAddressEditCurrent.setError("Enter current address");
            binding.userAddressEditCurrent.requestFocus();
            return  false ;
        }else  if(binding.userAddressEditPermanent.getText().toString().equalsIgnoreCase("")){
            binding.userAddressEditPermanent.setError("Enter permanent address");
            binding.userAddressEditPermanent.requestFocus();
            return  false ;
        }else  if(binding.userEnail.getText().toString().equalsIgnoreCase("")){
            binding.userEnail.setError("Enter email address");
            binding.userEnail.requestFocus();
            return  false ;
        }else  if(binding.userCityEdit.getText().toString().equalsIgnoreCase("")){
            binding.userCityEdit.setError("Enter City");
            binding.userCityEdit.requestFocus();
            return  false ;
        }else  if(binding.userStateEdit.getText().toString().equalsIgnoreCase("")){
            binding.userStateEdit.setError("Enter State");
            binding.userStateEdit.requestFocus();
            return  false ;
        }else  if(binding.userZipEdit.getText().toString().equalsIgnoreCase("")){
            binding.userZipEdit.setError("Enter Pin Code");
            binding.userZipEdit.requestFocus();
            return  false ;
        }else  if(binding.userNameEdit.getText().toString().equalsIgnoreCase("")){
            binding.userNameEdit.setError("Enter Applicant  Name");
            binding.userNameEdit.requestFocus();
            return  false ;
        }else  if(binding.userFatherEdit.getText().toString().equalsIgnoreCase("")){
            binding.userFatherEdit.setError("Enter Father/Mother/Husband  Name");
            binding.userFatherEdit.requestFocus();
            return  false ;
        }else  if(binding.userMobileEdit1.getText().toString().equalsIgnoreCase("")){
            binding.userMobileEdit1.setError("Enter Contact number 1 ");
            binding.userMobileEdit1.requestFocus();
            return  false ;
        }else  if(binding.userMobileEdit2.getText().toString().equalsIgnoreCase("")){
            binding.userMobileEdit2.setError("Enter Contact number 2 ");
            binding.userMobileEdit2.requestFocus();
            return  false ;
        }else  if(selectedDate.equalsIgnoreCase("")){
            Toast.makeText(activity, "select Date of Birth", Toast.LENGTH_SHORT).show();
            return  false ;
        }else  if(!isValidEmail(binding.userEnail.getText().toString())){
            binding.userEnail.setError("Invalid email address");
            binding.userEnail.requestFocus();
            return  false ;
        }else {
            return  true ;
        }


    }
    private void selectDate(TextView DateBtn) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (datePicker, year1, month1, day1) -> {
            String date = year1 + "-" + (month1 + 1) + "-" + day1;
            //    datePicker.setBackgroundResource(R.drawable.edit_background);
            DateBtn.setText(date);
            selectedDate = date ;
        }, year, month, day);

        datePickerDialog.show();
    }
}