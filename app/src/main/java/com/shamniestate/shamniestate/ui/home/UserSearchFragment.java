package com.shamniestate.shamniestate.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.databinding.FragmentUserSearchBinding;
import com.shamniestate.shamniestate.ui.misc.FilterActivity;


public class UserSearchFragment extends Fragment {
    private Activity activity;
    private FragmentUserSearchBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentUserSearchBinding.inflate(inflater, container, false);
        activity = requireActivity();

        binding.serachCardview.setOnClickListener(v -> startActivity(new Intent(activity, FilterActivity.class)));
        binding.llSearchContainer.setOnClickListener(v -> startActivity(new Intent(activity, FilterActivity.class)));
        binding.serachCardview.setOnClickListener(v -> startActivity(new Intent(activity, FilterActivity.class)));
        binding.userEmail.setOnClickListener(v -> startActivity(new Intent(activity, FilterActivity.class)));
        binding.getRoot().setOnClickListener(v -> startActivity(new Intent(activity, FilterActivity.class)));

        return binding.getRoot();
    }
}