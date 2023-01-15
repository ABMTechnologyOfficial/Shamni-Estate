package com.shamniestate.shamniestate.ui.auth;

import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.signup_img;
import static com.shamniestate.shamniestate.utils.BitmapToFile.bitmapToFile;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.icu.util.UniversalTimeScale;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

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
import com.shamniestate.shamniestate.RetrofitApis.BaseUrls;
import com.shamniestate.shamniestate.databinding.ActivitySignupDocumentsBinding;
import com.shamniestate.shamniestate.models.UtilModel;
import com.shamniestate.shamniestate.utils.Session;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class SignupDocumentsActivity extends AppCompatActivity {
    private Activity activity;
    int AADHARCARDFRONT = 100 , AADHARCARDBACK = 200 , PANCARD = 300 ;
    ActivitySignupDocumentsBinding binding;
    private File panImage = null, aadharCardFront= null, aadharCardBack = null;
    private Uri filepath;
    private Bitmap bitmap;
    Session session ;
    private  UtilModel model = new UtilModel() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupDocumentsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = this;

        session = new Session(activity);

        model = (UtilModel) getIntent().getSerializableExtra("model");

        binding.icBack.setOnClickListener(view -> onBackPressed());
        binding.textContinue.setOnClickListener(view -> startActivity(new Intent(activity, BankingInformationActivity.class)));

        binding.aadharFrontImage.setOnClickListener(v -> Dexter.withContext(activity)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {

                        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                        intent.setType("image/*");
                         startActivityForResult(intent,AADHARCARDFRONT);
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

                    }
                })
                .check());

        binding.aadharBackImage.setOnClickListener(v -> Dexter.withContext(activity)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {

                        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                        intent.setType("image/*");
                        startActivityForResult(intent,AADHARCARDBACK);
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

                    }
                })
                .check());

        binding.panImage.setOnClickListener(v -> Dexter.withContext(activity)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {

                        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                        intent.setType("image/*");
                        startActivityForResult(intent,PANCARD);
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
                model.setAssociateAadharCardFront(session.getAadhar_front_image());
                model.setAssociateAadharCardBack(session.getAadhar_back_image());
                model.setAssociatePanCardFront(session.getPan_image());
                model.setAssociatePanNo(binding.panNumberEdit.getText().toString());
                model.setAssociateAadharCardNo(binding.aahdarNumberEdit.getText().toString());
                startActivity(new Intent(activity,BankingInformationActivity.class).putExtra("model",(Serializable) model));
            }
        });

    }

    private  boolean validate(){

        if(binding.aahdarNumberEdit.getText().toString().equalsIgnoreCase("")){
            binding.aahdarNumberEdit.setError("Enter Your Aadhar Number");
            binding.aahdarNumberEdit.requestFocus();
            return  false ;
        }else   if(binding.panNumberEdit.getText().toString().equalsIgnoreCase("")){
            binding.panNumberEdit.setError("Enter Your Pan Card Number");
            binding.panNumberEdit.requestFocus();
            return  false ;
        }else if(aadharCardBack == null){
            Toast.makeText(activity, "Select Aadhar Card Back Image", Toast.LENGTH_SHORT).show();
            return  false;
        }else if(aadharCardFront == null){
            Toast.makeText(activity, "Select Aadhar Card Front Image", Toast.LENGTH_SHORT).show();
            return  false;
        }else if(panImage == null){
            Toast.makeText(activity, "Select Pan Card  Image", Toast.LENGTH_SHORT).show();
            return  false;
        }
        else {
             return  true ;
        }

    }

    private Bitmap setBitmap(ImageView imageView) {

        try {
            bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bitmap;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            assert data != null;
            filepath = data.getData();

            if(requestCode == AADHARCARDFRONT ){
                bitmap = setBitmap(binding.aadharFrontImage);
                aadharCardFront = bitmapToFile(activity, bitmap);
                uploadImage(binding.aadharFrontImage, "associate_aadhar_card_front" , binding.aahdrFProgress, aadharCardFront ,bitmap, "aadhar_front_image");
            }else if(requestCode == AADHARCARDBACK){
                bitmap = setBitmap(binding.aadharBackImage);
                aadharCardBack = bitmapToFile(activity, bitmap);
                uploadImage(binding.aadharBackImage, "associate_aadhar_card_back" , binding.aahdrBackProgress, aadharCardBack ,bitmap , "aadhar_front_image");
            }else {
                bitmap = setBitmap(binding.panImage);
                panImage = bitmapToFile(activity, bitmap);
                uploadImage(binding.panImage, "associate_pan_card_front" , binding.panProgress, panImage ,bitmap,"pan_image");
            }

        }
    }

    private void uploadImage(ImageView aadharFrontImage, String key, ProgressBar aahdrFProgress, File aadharCardFront, Bitmap bitmap, String pan_image) {

        ANRequest.MultiPartBuilder anAdd = AndroidNetworking.upload((BaseUrls.BASE_URL + signup_img));
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

}