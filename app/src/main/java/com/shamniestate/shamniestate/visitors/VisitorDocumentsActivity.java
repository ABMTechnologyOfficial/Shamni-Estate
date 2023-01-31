package com.shamniestate.shamniestate.visitors;

import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.AUTHORIZATION;
import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.MAP_IMAGE_URL;
import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.img_upload;
import static com.shamniestate.shamniestate.utils.BitmapToFile.bitmapToFile;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;

import android.Manifest;
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

import com.shamniestate.shamniestate.databinding.ActivityVisitorDocumentsBinding;
import com.shamniestate.shamniestate.models.PropertyDetailsModel;
import com.shamniestate.shamniestate.models.PropertyModel;
import com.shamniestate.shamniestate.models.SignupModel;
import com.shamniestate.shamniestate.models.VisitorUtilModel;
import com.shamniestate.shamniestate.ui.auth.LoginSuccessActivity;
import com.shamniestate.shamniestate.utils.ProgressDialog;
import com.shamniestate.shamniestate.utils.Session;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VisitorDocumentsActivity extends AppCompatActivity {

    private ActivityVisitorDocumentsBinding binding;
    private VisitorDocumentsActivity activity;
    private Session session;
    private Uri filepath = null;
    private Bitmap bitmap;
    private ArrayList<String> propertyNameList = new ArrayList<>();
    private ArrayList<String> propertyIdsList = new ArrayList<>();
    private ArrayList<String> propertyCodeList = new ArrayList<>();
    private ArrayList<String> propertySlotIdList = new ArrayList<>();
    private ArrayList<String> propertySlotNameList = new ArrayList<>();

    int AADHARCARDFRONT = 100, AADHARCARDBACK = 200, PANCARD = 300;
    private File aadharCardFront = null, aadharCardBack = null;
    private String selectedAadharCardFront = "", selectedAadharCardBack = "";
    private VisitorUtilModel model = null;
    private  String selectedPropertyName = "" , selectedPropertyCode = "" , selectedPropertyId = "" , selectedSlotId = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVisitorDocumentsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = this;
        session = new Session(activity);

        model = (VisitorUtilModel) getIntent().getSerializableExtra("visitor_data");

        binding.textContinue.setOnClickListener(view -> {
            if (validate()) {
                addVisitor();
                Log.e("TAG", "onCreate() called with: Okay = [" + savedInstanceState + "]");
            }
        });

        getPropertyList();

        binding.aadharFrontImage.setOnClickListener(v -> Dexter.withContext(activity)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                        intent.setType("image/*");
                        startActivityForResult(intent, AADHARCARDFRONT);
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
                        startActivityForResult(intent, AADHARCARDBACK);
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

    private void addVisitor() {
        Log.e("TAG", "addVisitor() called Model " + model.toString());
        ProgressDialog pd = new ProgressDialog(activity);
        pd.show();

        ApiInterface apiInterface = RetrofitClient.getClient(activity);
        apiInterface.newVisitor(
                session.getAccessToken(),
                session.getUserId(),
                model.getVisitorName(),
                model.getVisitorMob(),
                model.getVisitorDob(),
                model.getVisitorDov(),
                model.getVisitorProffession(),
                model.getVisitorEmail(),
                model.getVisitorAddress(),
                model.getVisitorCity(),
                model.getVisitorState(),
                model.getVisitorCityCode(),
                model.getVisitorAadharCardNo(),
                binding.budgetEdit.getText().toString(),
                selectedPropertyName,
                binding.projectCodeEdit.getText().toString(),
                selectedSlotId,
                selectedAadharCardFront,
                selectedAadharCardBack,
                model.getVisitorSelfie()
        ).enqueue(new Callback<SignupModel>() {
            @Override
            public void onResponse(@NonNull Call<SignupModel> call, @NonNull Response<SignupModel> response) {
            pd.dismiss();
                if (response.code() == 200)
                    if (response.body() != null)
                        if (response.body().getCode() == 200) {
                            Toast.makeText(activity, "Visitor Added..", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(activity, LoginSuccessActivity.class));
                            finish();
                        } else
                            Toast.makeText(activity, response.body().getMsg(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(@NonNull Call<SignupModel> call, @NonNull Throwable t) {
                pd.dismiss();
                Log.e("TAG", "onFailure() called with: call = [" + call + "], t = [" + t.getLocalizedMessage() + "]");
            }
        });


    }

    private boolean validate() {
        if (binding.aahdarNumberEdit.getText().toString().equalsIgnoreCase("")) {
            binding.aahdarNumberEdit.setError("Enter Your Aadhar Number");
            binding.aahdarNumberEdit.requestFocus();
            return false;
        } else if (selectedSlotId.equalsIgnoreCase("")) {
            Toast.makeText(activity, "Select Slot", Toast.LENGTH_SHORT).show();
            return false;
        } else if (binding.projectCodeEdit.getText().toString().equalsIgnoreCase("")) {
            binding.projectCodeEdit.setError("Enter Project Code..!");
            binding.projectCodeEdit.requestFocus();
            return false;
        } else if (selectedPropertyName.equalsIgnoreCase("")) {
            Toast.makeText(activity, "Select Property Name", Toast.LENGTH_SHORT).show();
            return false;
        } else if (binding.budgetEdit.getText().toString().equalsIgnoreCase("")) {
            binding.budgetEdit.setError("Enter Visitors Budget..!");
            binding.budgetEdit.requestFocus();
            return false;
        } else if (aadharCardBack == null) {
            Toast.makeText(activity, "Select Aadhar Card Back Image", Toast.LENGTH_SHORT).show();
            return false;
        } else if (aadharCardFront == null) {
            Toast.makeText(activity, "Select Aadhar Card Front Image", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
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

            if (requestCode == AADHARCARDFRONT) {
                bitmap = setBitmap(binding.aadharFrontImage);
                aadharCardFront = bitmapToFile(activity, bitmap);
                uploadImage(binding.aadharFrontImage, "visitor_aadhar_card_front", binding.aahdrFProgress, aadharCardFront, bitmap, "aadhar_front_image", 1);
            } else if (requestCode == AADHARCARDBACK) {
                bitmap = setBitmap(binding.aadharBackImage);
                aadharCardBack = bitmapToFile(activity, bitmap);
                uploadImage(binding.aadharBackImage, "visitor_aadhar_card_back", binding.aahdrBackProgress, aadharCardBack, bitmap, "aadhar_front_image", 2);
            }
        }
    }

    private void uploadImage(ImageView aadharFrontImage, String key, ProgressBar aahdrFProgress, File aadharCardFront, Bitmap bitmap, String pan_image, int i) {
        aahdrFProgress.setVisibility(View.VISIBLE);
        aadharFrontImage.setVisibility(View.GONE);
        ANRequest.MultiPartBuilder anAdd = AndroidNetworking.upload((BaseUrls.BASE_URL + img_upload));
        anAdd.addHeaders("Access_Token", session.getAccessToken());
        anAdd.addMultipartFile(key, aadharCardFront);
        anAdd.setPriority(Priority.HIGH);
        anAdd.build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        aahdrFProgress.setVisibility(View.GONE);
                        try {
                            Log.d("---rrrProfile", "save_postsave_post" + jsonObject.toString());
                            int code = jsonObject.getInt("code");
                            String Data = jsonObject.getString("Data");
                            aahdrFProgress.setVisibility(View.GONE);

                            if (code == 200) {
                                aadharFrontImage.setImageBitmap(bitmap);
                                session.setValue(pan_image, Data);
                                aadharFrontImage.setVisibility(View.VISIBLE);

                                if (i == 1) selectedAadharCardFront = Data;
                                else if (i == 2) selectedAadharCardBack = Data;

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

    private void getPropertyList() {
        ApiInterface apiInterface = RetrofitClient.getClient(activity);
        apiInterface.getAllProperty(AUTHORIZATION,"").enqueue(new Callback<PropertyModel>() {
            @Override
            public void onResponse(@NonNull Call<PropertyModel> call, @NonNull Response<PropertyModel> response) {
                try {
                    if (response.code() == 200)
                        if (response.isSuccessful() && response.body() != null) {

                            for (int i = 0; i < response.body().getData().size(); i++) {
                                propertyNameList.add(response.body().getData().get(i).getPropertyTitle());
                                propertyCodeList.add(response.body().getData().get(i).getPropertyCode());
                                propertyIdsList.add(response.body().getData().get(i).getPropertyId());
                            }
                            setPropertyNamesAdapter();
                        }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(@NonNull Call<PropertyModel> call, @NonNull Throwable t) {
                Log.e("TAG", "onFailure() called with: call = [" + call + "], t = [" + t.getLocalizedMessage() + "]");
            }
        });
    }

    private void setPropertyNamesAdapter() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity, android.R.layout.simple_spinner_item, propertyNameList);
        binding.propertyNameSpi.setAdapter(adapter);
        binding.propertyNameSpi.setOnItemSelectedListener((view, position, id, item) -> {
            selectedPropertyName = propertyNameList.get(position);
            selectedPropertyCode = propertyCodeList.get(position);
            selectedPropertyId  = propertyIdsList.get(position);
            binding.projectCodeEdit.setText(selectedPropertyCode);
            getPropertyDetails(selectedPropertyId);
        });

    }

    private  void getPropertyDetails(String proId) {

        ProgressDialog pd = new ProgressDialog(activity);
        pd.show();

        ApiInterface apiInterface = RetrofitClient.getClient(activity);
        apiInterface.getPropertyDetails( AUTHORIZATION,session.getAccessToken(), proId).enqueue(new Callback<PropertyDetailsModel>() {
            @Override
            public void onResponse(@NonNull Call<PropertyDetailsModel> call, @NonNull Response<PropertyDetailsModel> response) {
                pd.dismiss();
                if (response.code() == 200)
                    if (response.body() != null)
                        if (response.body().getCode() == 200) {
                            for (int i = 0; i < response.body().getData().getPropertySlot().size(); i++) {
                                propertySlotIdList.add(response.body().getData().getPropertySlot().get(i).getSlotId());
                                propertySlotNameList.add(response.body().getData().getPropertySlot().get(i).getSlotNo());
                                setPropertySlotAdapter();
                            }
                       }

            }

            private void setPropertySlotAdapter() {
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity, android.R.layout.simple_spinner_item, propertySlotNameList);
                binding.propertySlotSpi.setAdapter(adapter);
                binding.propertySlotSpi.setOnItemSelectedListener((view, position, id, item) -> {
                selectedSlotId = propertySlotIdList.get(position);
                });


            }

            @Override
            public void onFailure(@NonNull Call<PropertyDetailsModel> call, @NonNull Throwable t) {
                Log.e("TAG", "onFailure() called with: call = [" + call + "], t = [" + t + "]");
                pd.dismiss();
            }
        });

    }

}