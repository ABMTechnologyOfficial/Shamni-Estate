package com.shamniestate.shamniestate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.shamniestate.shamniestate.adapters.ServiceAdapter;
import com.shamniestate.shamniestate.databinding.ActivityServiceBinding;
import com.shamniestate.shamniestate.databinding.ActivityTestingBinding;
import com.shamniestate.shamniestate.models.ServiceModel;

import java.util.ArrayList;
import java.util.List;

public class ServiceActivity extends AppCompatActivity {

    List<ServiceModel> serviceModels = new ArrayList<>();
    private ServiceActivity activity ;
    private ActivityServiceBinding binding ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityServiceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity =this ;

        serviceModels.add(new ServiceModel(R.drawable.home_emi,"Home Loan"));
        serviceModels.add(new ServiceModel(R.drawable.sofa,"Interiors Furnishing"));
        serviceModels.add(new ServiceModel(R.drawable.home_service,"Zero Brokerage Rentals"));
        serviceModels.add(new ServiceModel(R.drawable.balance,"Legal And Registration"));
        serviceModels.add(new ServiceModel(R.drawable.home_search,"Property Inspection"));
        serviceModels.add(new ServiceModel(R.drawable.shipping,"Packers And Movers"));
        serviceModels.add(new ServiceModel(R.drawable.vastu,"Vastu"));
        serviceModels.add(new ServiceModel(R.drawable.double_bed,"Furniture And Appliances On Rent"));
        serviceModels.add(new ServiceModel(R.drawable.solarpanel,"Solar Rooftop"));

        binding.recycler.setLayoutManager(new GridLayoutManager(activity,3));
        binding.recycler.setAdapter(new ServiceAdapter(activity,serviceModels));

    }
}