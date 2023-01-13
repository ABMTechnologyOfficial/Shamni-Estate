package com.shamniestate.shamniestate.ui.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationBarView;
import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.databinding.ActivityUserHomeBinding;
import com.shamniestate.shamniestate.utils.Session;

public class UserHomeActivity extends AppCompatActivity {
    private Activity activity;
    private ActivityUserHomeBinding binding;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = UserHomeActivity.this;

        session = new Session(activity);

        setUpNavigationView();
        setUpBottomNav();
    }

    private void setUpBottomNav() {
        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.bottom_nav_home) {
                loadFrag(new UserHomeFragment());
            } else if (itemId == R.id.bottom_nav_search) {
                loadFrag(new UserSearchFragment());
            } else if (itemId == R.id.bottom_nav_need_help) {
                loadFrag(new UserNeedHelpFragment());
            } else if (itemId == R.id.bottom_nav_associate) {
                loadFrag(new UserAssociateFragment());
            }

            return true;
        });
    }

    private void loadFrag(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction().replace(binding.container.getId(), fragment);
        ft.commit();
    }

    private void setUpNavigationView() {
        binding.navLogoutLay.setOnClickListener(v -> logout());
    }

    private void logout() {
        new AlertDialog.Builder(activity)
                .setTitle("Logout?")
                .setMessage("Are you sure you want to logout?")
                .setPositiveButton("Yes", (dialogInterface, i) -> session.logout())
                .setNegativeButton("Cancel", null)
                .show();
    }
}