package com.shamniestate.shamniestate.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.databinding.FragmentAssociateBinding;
import com.shamniestate.shamniestate.ui.auth.LoginActivity;
import com.shamniestate.shamniestate.ui.auth.SignupUserInfoActivity;
import com.shamniestate.shamniestate.ui.misc.EmiCalculatorActivity;
import com.shamniestate.shamniestate.visitors.AddVisitorInfoActivity;
import com.shamniestate.shamniestate.visitors.VisitorListActivity;

public class AssociateFragment extends Fragment {

    FragmentAssociateBinding binding ;
    Activity activity ;
    public AssociateFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
               binding = FragmentAssociateBinding.inflate(getLayoutInflater());

               activity = requireActivity() ;

        binding.addNewAssociate.setOnClickListener(v -> {
            startActivity(new Intent(activity, SignupUserInfoActivity.class));
        });

        binding.myVisitors.setOnClickListener(v -> {
            startActivity(new Intent(activity, VisitorListActivity.class));
        });

        binding.myAssociates.setOnClickListener(v -> {
            startActivity(new Intent(activity, MyAssociatesActivity.class));
        });

      binding.navEmiCalculator.setOnClickListener(v -> {
            startActivity(new Intent(activity, EmiCalculatorActivity.class));
        });


        binding.aadNewVisitor.setOnClickListener(v -> {
            startActivity(new Intent(activity, AddVisitorInfoActivity.class));
        });


        return binding.getRoot();
    }
}