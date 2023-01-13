package com.shamniestate.shamniestate.ui.home;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shamniestate.shamniestate.databinding.FragmentUserNeedHelpBinding;


public class UserAssociateFragment extends Fragment {
    private Activity activity;
    private FragmentUserNeedHelpBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentUserNeedHelpBinding.inflate(inflater, container, false);
        activity = requireActivity();



        return binding.getRoot();
    }
}