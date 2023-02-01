package com.shamniestate.shamniestate.ui.home;

import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.AUTHORIZATION;
import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.BASE_URL;
import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.MAP_IMAGE_URL;
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
import com.shamniestate.shamniestate.adapters.PropertySlotsAdapter;
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
   //// PropertyModel.PropertyData data = null;
    ArrayList<SlideModel> slideModelArrayList = new ArrayList<>();
    private List<AmenitiesListModel.AmenitiesData> amenitiesList = new ArrayList<>();
    private List<AmenitiesListModel.AmenitiesData> availableAmenitiesList = new ArrayList<>();
    private Session session ;
    private  String property_id = "" , property_image = null , total_area = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserPropertyDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = UserPropertyDetailsActivity.this;
        session = new Session(activity);

        if (getIntent() != null) {
           // data = (PropertyModel.PropertyData) getIntent().getSerializableExtra("data");
            property_id = getIntent().getStringExtra("property_id");
            property_image = getIntent().getStringExtra("property_image");
            total_area = getIntent().getStringExtra("total_area");

            if(property_image != null)
             Picasso.get().load(property_image).placeholder(com.denzcoskun.imageslider.R.drawable.loading).into(binding.imageSlider);

        }
        getPropertyDetails();

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
    private  void getPropertyDetails() {

        ProgressDialog pd = new ProgressDialog(activity);
        pd.show();

        ApiInterface apiInterface = RetrofitClient.getClient(activity);
        apiInterface.getPropertyDetails( AUTHORIZATION,session.getAccessToken(), property_id).enqueue(new Callback<PropertyDetailsModel>() {
            @Override
            public void onResponse(@NonNull Call<PropertyDetailsModel> call, @NonNull Response<PropertyDetailsModel> response) {
                pd.dismiss();
                if (response.code() == 200)
                    if (response.body() != null)
                        if (response.body().getCode() == 200) {

                            PropertyDetailsModel.PropertyData.Property data = response.body().getData().getProperty().get(0);
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
                            binding.propertyTotalArea.setText(data.getPlotArea());
                            binding.totalBathroom.setText(data.getNoOfBathroom());
                            binding.propertyArea.setText(total_area + " " + data.getAreaUnitType());
                            binding.propertyPrice.setText(calculate_price(Integer.parseInt(data.getPropertyMinPrice())) + " - " + calculate_price(Integer.parseInt(data.getPropertyMaxPrice())));

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

                            if(response.body().getData().getPropertySlot().size() != 0 ){
                                binding.slotsLinear.setVisibility(View.VISIBLE);
                                binding.slotsRecycler.setLayoutManager(new GridLayoutManager(activity,4));
                                binding.slotsRecycler.setAdapter(new PropertySlotsAdapter(activity, response.body().getData().getPropertySlot()));
                            }


                            if(!response.body().getData().getProperty().get(0).getPropertyMap().equalsIgnoreCase("")){
                                 Picasso.get().load(MAP_IMAGE_URL+response.body().getData().getProperty().get(0).getPropertyMap())
                                        .placeholder(com.denzcoskun.imageslider.R.drawable.loading)
                                        .into(binding.mapImage);
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

    }

}
