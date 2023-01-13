package com.shamniestate.shamniestate.ui.home;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.databinding.FragmentUserSearchBinding;


public class UserSearchFragment extends Fragment {
    private Activity activity;
    private FragmentUserSearchBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentUserSearchBinding.inflate(inflater, container, false);
        activity = requireActivity();



        return binding.getRoot();
    }
}