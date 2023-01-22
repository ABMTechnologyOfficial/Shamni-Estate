package com.shamniestate.shamniestate.ui.auth;

import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.AUTHORIZATION;
import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.signup_img;
import static com.shamniestate.shamniestate.utils.BitmapToFile.bitmapToFile;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.shamniestate.shamniestate.RetrofitApis.ApiInterface;
import com.shamniestate.shamniestate.RetrofitApis.BaseUrls;
import com.shamniestate.shamniestate.RetrofitApis.RetrofitClient;
import com.shamniestate.shamniestate.databinding.ActivityBankingInformationBinding;
import com.shamniestate.shamniestate.models.BankListModel;
import com.shamniestate.shamniestate.models.UtilModel;
import com.shamniestate.shamniestate.utils.Session;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BankingInformationActivity extends AppCompatActivity {
    private Activity activity;
    private ActivityBankingInformationBinding binding;
    UtilModel model = new UtilModel();
    private  String selectedBankName = "";
    private File  cancelCheque = null;
    private Uri filepath;
    private Bitmap bitmap;
    int CANCELCHEQUE = 100;
    private  String selectedCnacelCheque = "";
    Session session ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBankingInformationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = BankingInformationActivity.this;

        session = new Session(activity );
        model = (UtilModel) getIntent().getSerializableExtra("model");

        Log.e("TAG", "addData() called"+model);

        binding.textContinue.setOnClickListener(view -> startActivity(new Intent(activity, SignupAuthenticationActivity.class)));
        binding.icBack.setOnClickListener(view -> onBackPressed());

        getBankList();

        binding.cancelChequeImage.setOnClickListener(v -> Dexter.withContext(activity)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {

                        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                        intent.setType("image/*");
                        startActivityForResult(intent,CANCELCHEQUE);
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

                    }
                })
                .check());


        binding.textContinue.setOnClickListener(v -> {
            if(validate()){
                model.setAssociateBankName(selectedBankName);
                model.setAssociateBlankCheque(session.getCancel_cheque_image());
                model.setAssociateAccNo(binding.userBankAccountNumber.getText().toString());
                model.setAssociateBnkIfscNo(binding.userBankIfsc.getText().toString());
                model.setAssociateBnkAccName(binding.userBankHolderName.getText().toString());
                model.setAssociateBlankCheque(selectedCnacelCheque);
                startActivity(new Intent(activity,SignupAuthenticationActivity.class).putExtra("model",(Serializable) model));
            }
        });

    }

    private Bitmap setBitmap(ImageView imageView) {

        try {
            bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bitmap;
    }

    private  boolean validate(){

        if(binding.userBankAccountNumber.getText().toString().equalsIgnoreCase("")){
            binding.userBankAccountNumber.setError("Enter Account  Number");
            binding.userBankAccountNumber.requestFocus();
            return  false ;
        }else   if(binding.userBankHolderName.getText().toString().equalsIgnoreCase("")){
            binding.userBankHolderName.setError("Enter  Bank Holder Name");
            binding.userBankHolderName.requestFocus();
            return  false ;
        }else   if(binding.userBankIfsc.getText().toString().equalsIgnoreCase("")){
            binding.userBankIfsc.setError("Enter IFSC Code ");
            binding.userBankIfsc.requestFocus();
            return  false ;
        }else if(cancelCheque == null){
            Toast.makeText(activity, "Select Cancel Cheque Image", Toast.LENGTH_SHORT).show();
            return  false;
        }else if(selectedBankName.equalsIgnoreCase("")){
            Toast.makeText(activity, "Select Bank Name", Toast.LENGTH_SHORT).show();
            return  false;
        }
        else {
            return  true ;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            assert data != null;
            filepath = data.getData();
            if(requestCode == CANCELCHEQUE ){
                bitmap = setBitmap(binding.cancelChequeImage);
                cancelCheque = bitmapToFile(activity, bitmap);
                uploadImage(binding.cancelChequeImage, "associate_blank_cheque" , binding.cancelChequeProgress, cancelCheque ,bitmap, "aadhar_front_image");
            }

        }
    }

    private void uploadImage(ImageView aadharFrontImage, String key, ProgressBar aahdrFProgress, File aadharCardFront, Bitmap bitmap, String pan_image) {
        aahdrFProgress.setVisibility(View.VISIBLE);
        aadharFrontImage.setVisibility(View.GONE);
        ANRequest.MultiPartBuilder anAdd = AndroidNetworking.upload((BaseUrls.BASE_URL + signup_img));
        anAdd.addHeaders("Authorization",AUTHORIZATION);
        anAdd.addMultipartFile(key, aadharCardFront);
        anAdd.setPriority(Priority.HIGH);
        anAdd.build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        aahdrFProgress.setVisibility(View.GONE);
                        try {
                            Log.d("---rrrProfile", "save_postsave_post" + jsonObject.toString());
                            int  code = jsonObject.getInt("code");
                            String Data = jsonObject.getString("Data");
                            aahdrFProgress.setVisibility(View.GONE);

                            if (code == 200) {
                                aadharFrontImage.setImageBitmap(bitmap);
                                session.setValue(pan_image , Data);
                                aadharFrontImage.setVisibility(View.VISIBLE);
                                selectedCnacelCheque = Data ;
                                Log.e("TAG", "onResponse() called with: jsonObject = [" + Data + "]");
                            }
                        } catch (JSONException e) {
                            aahdrFProgress.setVisibility(View.GONE);
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        aahdrFProgress.setVisibility(View.GONE);
                        Log.e("TAG", "onError: " + anError.getErrorBody());

                    }
                });


    }


    private void getBankList() {
        ApiInterface apiInterface = RetrofitClient.getClient(activity);
        apiInterface.getBankList().enqueue(new Callback<BankListModel>() {
            @Override
            public void onResponse(@NonNull Call<BankListModel> call, @NonNull Response<BankListModel> response) {
                try {
                    if (response.code() == 200)
                        if (response.body() != null)
                            if (response.body().getCode() == 200) {
                                List<BankListModel.Datum> data = response.body().getData();

                                ArrayList<String> bankListNames = new ArrayList<>();

                                for (int i = 0; i < data.size(); i++) {
                                    bankListNames.add(data.get(i).getBankName());
                                }


                                ArrayAdapter<String> adapter = new ArrayAdapter<>(activity, android.R.layout.simple_spinner_item, bankListNames);
                                binding.bankSpinner.setAdapter(adapter);
                                binding.bankSpinner.setOnItemSelectedListener((view, position, id, item) -> selectedBankName = bankListNames.get(position));

                            } else {
                                Log.e(BaseUrls.TAG, "onResponse() called with: call = [" + call + "], response = [" + response + "]");
                            }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(@NonNull Call<BankListModel> call, @NonNull Throwable t) {
                Log.e(BaseUrls.TAG, "login onFailure() called with: call = [" + call + "], t = [" + t.getLocalizedMessage() + "]");
            }
        });
    }
}







/*
*
*
*
* aaaf file_63c2ecaf58075.png
* aaab file_63c2ecc89adb2.png
* pan file_63c2ecd9f185d.png
* cac file_63c2ecfdf0316.png
*
* */