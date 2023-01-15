package com.shamniestate.shamniestate.ui.home;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.databinding.ActivityUserHomeBinding;
import com.shamniestate.shamniestate.ui.misc.AboutUsActivity;
import com.shamniestate.shamniestate.ui.misc.ChatSupportActivity;
import com.shamniestate.shamniestate.ui.misc.EmiCalculatorActivity;
import com.shamniestate.shamniestate.ui.misc.HomeLoanEnquiryActivity;
import com.shamniestate.shamniestate.utils.Session;

public class UserHomeActivity extends AppCompatActivity {
    private Activity activity;
    private ActivityUserHomeBinding binding;
    private Session session;

    @Override
    public void onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.close();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = UserHomeActivity.this;

        session = new Session(activity);

        setUpBottomNav();
        setUpNavigationView();

        binding.icMenu.setOnClickListener(view -> binding.drawerLayout.open());
    }

    private void setUpBottomNav() {
        loadFrag(new UserHomeFragment());

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.bottom_nav_home) {
                loadFrag(new UserHomeFragment());
                binding.textHomeTitle.setText(R.string.app_name);
            } else if (itemId == R.id.bottom_nav_search) {
                loadFrag(new UserSearchFragment());
                binding.textHomeTitle.setText(R.string.search);
            } else if (itemId == R.id.bottom_nav_need_help) {
                loadFrag(new UserNeedHelpFragment());
                binding.textHomeTitle.setText(R.string.need_help);
            } else if (itemId == R.id.bottom_nav_associate) {
                loadFrag(new UserAssociateFragment());
                binding.textHomeTitle.setText(R.string.associate);
            }

            return true;
        });
    }

    private void loadFrag(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction().replace(binding.container.getId(), fragment);
        ft.commit();
    }

    private void setUpNavigationView() {
        binding.navAboutUsLay.setOnClickListener(v -> startActivity(new Intent(activity, AboutUsActivity.class)));
        binding.navEmiCalculatorLay.setOnClickListener(v -> startActivity(new Intent(activity, EmiCalculatorActivity.class)));
        binding.navChatSupportLay.setOnClickListener(v -> startActivity(new Intent(activity, ChatSupportActivity.class)));
        binding.navHomeLoanLay.setOnClickListener(v -> startActivity(new Intent(activity, HomeLoanEnquiryActivity.class)));

        binding.navCommercialSearchLay.setOnClickListener(v -> {
            session.setSearch("commercial");
            binding.bottomNavigation.setSelectedItemId(R.id.bottom_nav_search);
            binding.drawerLayout.close();
        });
        binding.navFarmhouseSearchLay.setOnClickListener(v -> {
            session.setSearch("farmhouse");
            binding.bottomNavigation.setSelectedItemId(R.id.bottom_nav_search);
            binding.drawerLayout.close();
        });
        binding.navResidentialSearchLay.setOnClickListener(v -> {
            session.setSearch("residential");
            binding.bottomNavigation.setSelectedItemId(R.id.bottom_nav_search);
            binding.drawerLayout.close();
        });

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