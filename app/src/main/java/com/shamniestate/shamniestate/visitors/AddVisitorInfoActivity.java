package com.shamniestate.shamniestate.visitors;

import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.AUTHORIZATION;
import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.img_upload;
import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.signup_img;
import static com.shamniestate.shamniestate.utils.BitmapToFile.bitmapToFile;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
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
import com.shamniestate.shamniestate.databinding.ActivityAddVisitorInfoBinding;
import com.shamniestate.shamniestate.models.VisitorUtilModel;
import com.shamniestate.shamniestate.utils.Session;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddVisitorInfoActivity extends AppCompatActivity {

    private ActivityAddVisitorInfoBinding binding;
    private AddVisitorInfoActivity activity;
    private VisitorUtilModel model = null;
    private int VISITOR_IMAGE_CODE = 100;
    private Bitmap bitmap;
    private Uri filepath;
    private File visitorImageFile = null;
    private Session session ;
    private  String selectedVisitorImage  = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddVisitorInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;
        session = new Session(activity);
        binding.textContinue.setOnClickListener(view -> {

            if (validate()) {
                model = new VisitorUtilModel();
                model.setVisitorDob(binding.visitorDobEdit.getText().toString());
                model.setVisitorDov(binding.visitorDateOfVisit.getText().toString());
                model.setVisitorName(binding.visitorNameEdit.getText().toString());
                model.setVisitorEmail(binding.visitorEmailEdit.getText().toString());
                model.setVisitorMob(binding.visitorMobileEdit.getText().toString());
                model.setVisitorSelfie(selectedVisitorImage);
                model.setVisitorProffession(binding.visitorProfessionEdit.getText().toString());

                startActivity(new Intent(activity, VisitorAddressActivity.class)
                        .putExtra("visitor_data", (Serializable) model)
                );
            }

        });

        binding.visitorDateOfVisit.setOnClickListener(view -> selectDate(binding.visitorDateOfVisit));
        binding.visitorDobEdit.setOnClickListener(view -> selectDate(binding.visitorDobEdit));


        binding.visitorImage.setOnClickListener(v -> Dexter.withContext(activity)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {

                        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                        intent.setType("image/*");
                        startActivityForResult(intent, VISITOR_IMAGE_CODE);
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

                    }
                })
                .check());


    }

    private Bitmap setBitmap(ImageView imageView) {

        try {
            bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bitmap;
    }

    private boolean validate() {
        if (binding.visitorEmailEdit.getText().toString().equalsIgnoreCase("")) {
            binding.visitorEmailEdit.setError("Enter Visitor Email..!");
            binding.visitorEmailEdit.requestFocus();
            return false;
        } else if (!emailValidator(binding.visitorEmailEdit.getText().toString())) {
            binding.visitorEmailEdit.setError("Invalid  Email..!");
            binding.visitorEmailEdit.requestFocus();
            return false;
        } else if (binding.visitorMobileEdit.getText().toString().equalsIgnoreCase("")) {
            binding.visitorMobileEdit.setError("Enter Mobile..!");
            binding.visitorMobileEdit.requestFocus();
            return false;
        } else if (binding.visitorProfessionEdit.getText().toString().equalsIgnoreCase("")) {
            binding.visitorProfessionEdit.setError("Enter Profession..!");
            binding.visitorProfessionEdit.requestFocus();
            return false;
        } else if (binding.visitorNameEdit.getText().toString().equalsIgnoreCase("")) {
            binding.visitorNameEdit.setError("Enter Visitor Name..!");
            binding.visitorNameEdit.requestFocus();
            return false;
        } else if (binding.visitorDobEdit.getText().toString().equalsIgnoreCase("dd/yy/mm")) {
            Toast.makeText(activity, "Select Date of Birth", Toast.LENGTH_SHORT).show();
            return false;
        } else if (binding.visitorDateOfVisit.getText().toString().equalsIgnoreCase("dd/yy/mm")) {
            Toast.makeText(activity, "Select Date of Visit", Toast.LENGTH_SHORT).show();
            return false;
        } else if (visitorImageFile == null) {
            Toast.makeText(activity, "Select Visitor Image..!", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }

    }


    public boolean emailValidator(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            assert data != null;
            filepath = data.getData();

            if(requestCode == VISITOR_IMAGE_CODE ){
                bitmap = setBitmap(binding.visitorImage);
                visitorImageFile = bitmapToFile(activity, bitmap);
                uploadImage(binding.visitorImage , binding.aahdrFProgress, visitorImageFile ,bitmap, "aadhar_front_image" , 1);
            }
        }
    }


    private void uploadImage(ImageView aadharFrontImage, ProgressBar aahdrFProgress, File aadharCardFront, Bitmap bitmap, String pan_image, int i) {
        aahdrFProgress.setVisibility(View.VISIBLE);
        aadharFrontImage.setVisibility(View.GONE);
        ANRequest.MultiPartBuilder anAdd = AndroidNetworking.upload((BaseUrls.BASE_URL + img_upload));
        anAdd.addHeaders("Access_Token",session.getAccessToken());
        anAdd.addMultipartFile("visitor_selfie", aadharCardFront);
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
                                aadharFrontImage.setVisibility(View.VISIBLE);
                                selectedVisitorImage = Data ;
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


    private void selectDate(TextView DateBtn) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (datePicker, year1, month1, day1) -> {
            String date = year1 + "-" + (month1 + 1) + "-" + day1;
            //    datePicker.setBackgroundResource(R.drawable.edit_background);
            DateBtn.setText(date);
        }, year, month, day);

        datePickerDialog.show();
    }
}