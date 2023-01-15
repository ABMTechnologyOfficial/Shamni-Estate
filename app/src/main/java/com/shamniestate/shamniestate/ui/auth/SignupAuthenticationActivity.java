package com.shamniestate.shamniestate.ui.auth;

import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.AUTHORIZATION;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import android.widget.RadioButton;
import android.widget.Toast;

import com.shamniestate.shamniestate.RetrofitApis.ApiInterface;
import com.shamniestate.shamniestate.RetrofitApis.RetrofitClient;
import com.shamniestate.shamniestate.databinding.ActivitySignupAuthenticationBinding;
import com.shamniestate.shamniestate.models.SignupModel;
import com.shamniestate.shamniestate.models.UtilModel;
import com.shamniestate.shamniestate.utils.ProgressDialog;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupAuthenticationActivity extends AppCompatActivity {
    private Activity activity;
    private ActivitySignupAuthenticationBinding binding;
    private UtilModel model = new UtilModel();
    String selectedWorkingType = "0";
    boolean ischecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupAuthenticationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = SignupAuthenticationActivity.this;

        model = (UtilModel) getIntent().getSerializableExtra("model");

        binding.textContinue.setOnClickListener(view -> startActivity(new Intent(activity, SignupDocumentsActivity.class)));
        binding.icBack.setOnClickListener(view -> onBackPressed());

        binding.radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton button = findViewById(checkedId);

            if (button.getText().toString().equalsIgnoreCase("Part Time")) {
                selectedWorkingType = "0";
            } else {
                selectedWorkingType = "1";
            }
        });

        binding.textContinue.setOnClickListener(v -> {
            if (validate()) {
                ProgressDialog progressDialog = new ProgressDialog(activity);
                progressDialog.show();
                model.setAssociateEmail(binding.userEmail.getText().toString());

                Log.e("TAG", "onClick() called with: v = [" + model.toString() + "]");
                Log.e("TAG", "onClick() called with: selectedWorkingType = [" + selectedWorkingType + "]");
                Log.e("TAG", "onClick() called with: pass  = [" + binding.userPassword.getText().toString() + "]");
                Log.e("TAG", "onClick() called with: c pass = [" + binding.userCPassword.getText().toString() + "]");

                if(model.getAccountType().equalsIgnoreCase("2")){
                    startActivity(new Intent(activity,PaymentActivity.class)
                            .putExtra("data",model)
                            .putExtra("pass",binding.userPassword.getText().toString())
                            .putExtra("workType",selectedWorkingType)
                            .putExtra("ref_code",binding.userReferrralCode.getText().toString()));
                      progressDialog.dismiss();
                }else {
                    addData(progressDialog);
                }
            }
        });
        binding.userShamniCheck.setOnCheckedChangeListener((buttonView, isChecked) -> ischecked = isChecked);


    }

    private  void addData(ProgressDialog progressDialog){

        ApiInterface apiInterface = RetrofitClient.getClient(activity);
        apiInterface.signup(
                AUTHORIZATION,
                model.getAccountType(),
                selectedWorkingType,
                model.getAssociateName(),
                model.getAssociateDob(),
                model.getAssociateGender(),
                model.getAssociateMobile(),
                model.getAssociateAddress(),
                model.getAssociateCity(),
                model.getAssociateState(),
                model.getAssociateCityZip(),
                model.getAssociateAadharCardNo(),
                model.getAssociatePanNo(),
                model.getAssociateBankName(),
                model.getAssociateAccNo(),
                model.getAssociateBnkIfscNo(),
                model.getAssociateBnkAccName(),
                model.getAssociateEmail(),
                binding.userPassword.getText().toString(),
                binding.userCPassword.getText().toString(),
                binding.userReferrralCode.getText().toString(),
                "1",
                model.getAssociateReraRegNo(),
                model.getAssociateAadharCardFront(),
                model.getAssociateAadharCardBack(),
                model.getAssociateBlankCheque(),
                model.getAssociatePanCardFront()
        ).enqueue(new Callback<SignupModel>() {
            @Override
            public void onResponse(@NonNull Call<SignupModel> call, @NonNull Response<SignupModel> response) {
                progressDialog.dismiss();
                startActivity(new Intent(activity,LoginActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                Toast.makeText(activity, "Your Account Created..! ", Toast.LENGTH_SHORT).show();

                finish();
                if (response.code() == 200)
                    if (response.body() != null && response.body().getCode() == 200) {
                        Toast.makeText(activity, "Your Account Created..! ", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(activity, "Failed..", Toast.LENGTH_SHORT).show();
                    }
            }

            @Override
            public void onFailure(@NonNull Call<SignupModel> call, @NonNull Throwable t) {
                progressDialog.dismiss();
                Log.e("TAG", "onFailure() called with: call = [" + call + "], t = [" + t + "]");
            }
        });

    }

    public boolean emailValidator(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }


    private boolean validate() {
        if (binding.userEmail.getText().toString().equalsIgnoreCase("")) {
            binding.userEmail.setError("Enter Account  Number");
            binding.userEmail.requestFocus();
            return false;
        } else if (binding.userPassword.getText().toString().equalsIgnoreCase("")) {
            binding.userPassword.setError("Enter  Bank Holder Name");
            binding.userPassword.requestFocus();
            return false;
        } else if (binding.userCPassword.getText().toString().equalsIgnoreCase("")) {
            binding.userCPassword.setError("Enter IFSC Code ");
            binding.userCPassword.requestFocus();
            return false;
        } else if (!binding.userCPassword.getText().toString().equalsIgnoreCase((binding.userCPassword.getText().toString()))) {
            Toast.makeText(activity, "Password Not Match.!", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!ischecked) {
            Toast.makeText(activity, "Please accept terms of condition...!", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!emailValidator(binding.userEmail.getText().toString())) {
            binding.userEmail.setError("Invalid Email.!");
            binding.userEmail.requestFocus();
            return false;
        } else {
            return true;
        }

    }
}