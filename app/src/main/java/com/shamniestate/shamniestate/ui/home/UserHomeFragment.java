package com.shamniestate.shamniestate.ui.home;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.databinding.FragmentUserHomeBinding;

public class UserHomeFragment extends Fragment {
    private Activity activity;
    private FragmentUserHomeBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentUserHomeBinding.inflate(inflater, container, false);
        activity = requireActivity();



        return binding.getRoot();
    }
}