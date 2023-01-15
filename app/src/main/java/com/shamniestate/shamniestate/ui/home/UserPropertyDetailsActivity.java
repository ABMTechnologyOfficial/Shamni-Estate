package com.shamniestate.shamniestate.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.databinding.ActivityUserPropertyDetailsBinding;
import com.shamniestate.shamniestate.models.PropertyModel;

import java.util.ArrayList;

public class UserPropertyDetailsActivity extends AppCompatActivity {

  ActivityUserPropertyDetailsBinding binding ;
  UserPropertyDetailsActivity activity ;
  PropertyModel.PropertyData data = null;
    ArrayList<SlideModel> slideModelArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserPropertyDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = UserPropertyDetailsActivity.this;

        if (getIntent() != null){
            data = (PropertyModel.PropertyData) getIntent().getSerializableExtra("data");
        }


        binding.propertyName.setText(data.getPropertyTitle());
        binding.propertyBuilderAddress.setText(data.getCityName());
        binding.propertyCityName.setText(data.getCityName());
        binding.propertyCode.setText(data.getPropertyCode());
        binding.propertyByName.setText(data.getPropertyBuilder());
        binding.propertyDescription.setText(data.getPropertyDes());
        binding.propertyLication.setText(data.getPropertyAddress());
        binding.propertyPricePerUnit.setText(data.getPropertyPricePerUnit());
        binding.propertyArea.setText(data.getMaxUnitArea()+" "+data.getAreaUnitType());
        binding.propertyPrice.setText(data.getPropertyMaxPrice());

        slideModelArrayList.add(new SlideModel(data.getPropertyImage(), ScaleTypes.FIT));
        binding.imageSlider.setImageList(slideModelArrayList);

        String lat , lang ;
        lat = data.getPropertyLatitude() ;
        lang = data.getPropertyLongitude();

        if(!lat.equalsIgnoreCase("") && !lang.equalsIgnoreCase("")){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.fragment_container, new MapFragment(Double.parseDouble(lat), Double.parseDouble(lang), false));
            transaction.commit();
        }else {
            binding.mapLinar.setVisibility(View.GONE);
        }

    }
}