package com.shamniestate.shamniestate.ui.home;

import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.AUTHORIZATION;
import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.BASE_URL;
import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.property_details;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.RetrofitApis.ApiInterface;
import com.shamniestate.shamniestate.RetrofitApis.RetrofitClient;
import com.shamniestate.shamniestate.adapters.AmenitiesAdapter;
import com.shamniestate.shamniestate.adapters.SearchResultAmenityAdapter;
import com.shamniestate.shamniestate.databinding.ActivityUserPropertyDetailsBinding;
import com.shamniestate.shamniestate.models.AmenitiesListModel;
import com.shamniestate.shamniestate.models.PropertyDetailsModel;
import com.shamniestate.shamniestate.models.PropertyModel;
import com.shamniestate.shamniestate.utils.ProgressDialog;
import com.shamniestate.shamniestate.utils.Session;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserPropertyDetailsActivity extends AppCompatActivity {

    ActivityUserPropertyDetailsBinding binding;
    UserPropertyDetailsActivity activity;
    PropertyModel.PropertyData data = null;
    ArrayList<SlideModel> slideModelArrayList = new ArrayList<>();
    private List<AmenitiesListModel.AmenitiesData> amenitiesList = new ArrayList<>();
    private List<AmenitiesListModel.AmenitiesData> availableAmenitiesList = new ArrayList<>();
    private Session session ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserPropertyDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = UserPropertyDetailsActivity.this;
        session = new Session(activity);

        if (getIntent() != null) {
            data = (PropertyModel.PropertyData) getIntent().getSerializableExtra("data");
        }


        getPropertyAmenities();

        binding.propertyName.setText(data.getPropertyTitle());
        binding.propertyBuilderAddress.setText(data.getCityName());
        binding.propertyCityName.setText(data.getCityName());
        binding.propertyCode.setText(data.getPropertyCode());
        binding.propertyByName.setText(data.getPropertyBuilder());
        binding.propertyByName.setText(data.getPropertyBuilder());
        binding.propertyDescription.setText(data.getPropertyDes());
        binding.propertyLication.setText(data.getPropertyAddress());
        binding.propertyPricePerUnit.setText(data.getPropertyPricePerUnit());
        binding.totalBalcony.setText(data.getNoOfBalcony());
        binding.totalBedroom.setText(data.getNoOfBedroom());
        binding.totalBathroom.setText(data.getNoOfBathroom());
        binding.propertyArea.setText(data.getMaxUnitArea() + " " + data.getAreaUnitType());
        binding.propertyPrice.setText(calculate_price(Integer.parseInt(data.getPropertyMinPrice())) + " - " + calculate_price(Integer.parseInt(data.getPropertyMaxPrice())));

        Picasso.get().load(data.getPropertyImage()).placeholder(com.denzcoskun.imageslider.R.drawable.loading).into(binding.imageSlider);
        getPropertyDetails();
        ///// slideModelArrayList.add(new SlideModel(data.getPropertyImage(), ScaleTypes.FIT));
        // binding.imageSlider.setImageList(slideModelArrayList);


        String lat, lang;
        lat = data.getPropertyLatitude();
        lang = data.getPropertyLongitude();

        if (!lat.equalsIgnoreCase("") && !lang.equalsIgnoreCase("")) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.fragment_container, new MapFragment(Double.parseDouble(lat), Double.parseDouble(lang), false));
            transaction.commit();
        } else {
            binding.mapLinar.setVisibility(View.GONE);
        }
    }

    private String calculate_price(int price) {

        String comnfir_price = "";
        if (price >= 100000 && price <= 10000000) {
            comnfir_price = String.valueOf(price / 100000) + " Lac";
        } else if (price >= 10000000) {
            comnfir_price = String.valueOf(price / 10000000) + " Cr";
        } else {
            comnfir_price = String.valueOf(price / 1000) + " K ";
        }
        return comnfir_price;

    }


    /*private  void setAmenities(){
        String[] amenityArray = data.getAmenitiesId().split(",");
        Log.e("TAG", "setAmenities() called data.getAmenitiesId() "+data.getAmenitiesId());

        for (String s : amenityArray) {
            Log.e("TAG", "setAmenities() called data.amenityArray() " + s);
        }

        for (String currentAmenityId : amenityArray) {
            for (int x = 0; x < amenitiesList.size(); x++) {
                if (currentAmenityId.equalsIgnoreCase(amenitiesList.get(x).getAmenitiesId())) {
                    availableAmenitiesList.add(amenitiesList.get(x));
                    Log.e("TAG", "setAmenities() called data.amenityArray() " +amenitiesList.get(x));
                    break;
                }
            }
        }
        Log.e("TAG", "setAmenities() called amenities array size  "+availableAmenitiesList.size());

       binding.amenitiesRecycler.setLayoutManager(new GridLayoutManager(activity, 2));
       binding.amenitiesRecycler.setAdapter(new AmenitiesAdapter(activity, availableAmenitiesList));

    }
    */
    private void getPropertyAmenities() {
        ApiInterface apiInterface = RetrofitClient.getClient(activity);
        apiInterface.getPropertyAmenities(session.getAccessToken()).enqueue(new Callback<AmenitiesListModel>() {
            @Override
            public void onResponse(@NonNull Call<AmenitiesListModel> call, @NonNull Response<AmenitiesListModel> response) {
                if (response.code() == 200)
                    if (response.body() != null && response.body().getCode() == 200)
                        if (response.body().getData().size() != 0) {
                            amenitiesList = response.body().getData();
                            ////setAmenities();
                        }
            }

            @Override
            public void onFailure(@NonNull Call<AmenitiesListModel> call, @NonNull Throwable t) {
                Log.e("TAG", "onFailure() called with: call = [" + call + "], t = [" + t.getLocalizedMessage() + "]");
            }
        });
    }


    private  void getPropertyDetails() {

        ProgressDialog pd = new ProgressDialog(activity);
        pd.show();

        Map<String, String> header = new HashMap<>();
        header.put("Access_Token", session.getAccessToken());
        header.put("Content-Type", "application/json");
        header.put("Cookie", "PHPSESSID=34f13756327abbf81f28c886be58d001");

        ApiInterface apiInterface = RetrofitClient.getClient(activity);
        apiInterface.getPropertyDetails(header,AUTHORIZATION, data.getPropertyId()).enqueue(new Callback<PropertyDetailsModel>() {
            @Override
            public void onResponse(@NonNull Call<PropertyDetailsModel> call, @NonNull Response<PropertyDetailsModel> response) {
                pd.dismiss();
                if (response.code() == 200)
                    if (response.body() != null)
                        if (response.body().getCode() == 200) {

                            if (response.body().getData().getPropertyGallery().size() != 0) {
                                for (int i = 0; i < response.body().getData().getPropertyGallery().size(); i++) {
                                    slideModelArrayList.add(new SlideModel(response.body().getData().getPropertyGallery().get(i).getGalleryName(), ScaleTypes.FIT));
                                    Log.e("TAG", "onResponse() called with: call = [" + call + "], Image = [" + response.body().getData().getPropertyGallery().get(i).getGalleryName() + "]");
                                }

                                binding.imageSlider2.setImageList(slideModelArrayList, ScaleTypes.FIT);
                            }

                            if(response.body().getData().getPropertyAmenities().size() != 0 ){
                                binding.amenitiesRecycler.setLayoutManager(new GridLayoutManager(activity, 2));
                                binding.amenitiesRecycler.setAdapter(new AmenitiesAdapter(activity, response.body().getData().getPropertyAmenities()));
                            }

                        }else {
                            binding.galleryLinear.setVisibility(View.GONE);
                            binding.amenitiesLinear.setVisibility(View.GONE);
                        }

            }

            @Override
            public void onFailure(@NonNull Call<PropertyDetailsModel> call, @NonNull Throwable t) {
                Log.e("TAG", "onFailure() called with: call = [" + call + "], t = [" + t + "]");
                pd.dismiss();
            }
        });


//
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, BASE_URL + property_details, new com.android.volley.Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//             pd.dismiss();
//                Log.e("TAG", "onResponse() called with: response = [" + response + "]");
//            }
//        }, new com.android.volley.Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                pd.dismiss();
//                Log.e("TAG", "onErrorResponse() called with: error = [" + error.getLocalizedMessage() + "]");
//
//            }
//        }){
//
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> param = new HashMap<>();
//                param.put("Access_Token", session.getAccessToken());
//                return  param ;
//            }
//
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> param = new HashMap<>();
//                param.put("property_id",data.getPropertyId());
//                return  param ;
//            }
//        };
//
//
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        requestQueue.add(stringRequest);
//
//    }
//
//

    }

}
