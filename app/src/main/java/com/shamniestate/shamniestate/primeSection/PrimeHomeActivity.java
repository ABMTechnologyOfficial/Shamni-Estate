package com.shamniestate.shamniestate.primeSection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.databinding.ActivityPrimeHomeBinding;
import com.shamniestate.shamniestate.databinding.ActivityUserHomeBinding;
import com.shamniestate.shamniestate.primeSection.fragments.PrimeAssociateFragment;
import com.shamniestate.shamniestate.primeSection.fragments.PrimeHelpFragment;
import com.shamniestate.shamniestate.primeSection.fragments.PrimeHomeFragment;
import com.shamniestate.shamniestate.primeSection.fragments.PrimeSearchFragment;
import com.shamniestate.shamniestate.ui.auth.LoginActivity;
import com.shamniestate.shamniestate.ui.auth.SignupUserInfoActivity;
import com.shamniestate.shamniestate.ui.home.MyAssociatesActivity;
import com.shamniestate.shamniestate.ui.home.UserAssociateFragment;
import com.shamniestate.shamniestate.ui.home.UserHomeActivity;
import com.shamniestate.shamniestate.ui.home.UserHomeFragment;
import com.shamniestate.shamniestate.ui.home.UserNeedHelpFragment;
import com.shamniestate.shamniestate.ui.home.UserSearchFragment;
import com.shamniestate.shamniestate.ui.misc.AboutUsActivity;
import com.shamniestate.shamniestate.ui.misc.EmiCalculatorActivity;
import com.shamniestate.shamniestate.ui.misc.HomeLoanEnquiryActivity;
import com.shamniestate.shamniestate.utils.Session;
import com.shamniestate.shamniestate.visitors.VisitorListActivity;

public class PrimeHomeActivity extends AppCompatActivity {
    private Activity activity;
    private ActivityPrimeHomeBinding binding;
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
        binding = ActivityPrimeHomeBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        activity = this;

        session = new Session(activity);

        setUpBottomNav();
        setUpNavigationView();

        binding.icMenu.setOnClickListener(view -> binding.drawerLayout.open());
    }

    private void setUpBottomNav() {
        loadFrag(new PrimeHomeFragment());

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.bottom_nav_home) {

                if (session.isLoggedIn()) {
                    loadFrag(new PrimeHomeFragment());
                } else {
                    startActivity(new Intent(activity, LoginActivity.class));
                }
                binding.textHomeTitle.setText(R.string.app_name);
            } else if (itemId == R.id.bottom_nav_search) {

                if (session.isLoggedIn()) {
                    loadFrag(new PrimeSearchFragment());
                } else {
                    startActivity(new Intent(activity, LoginActivity.class));
                }
                binding.textHomeTitle.setText(R.string.search);
            } else if (itemId == R.id.bottom_nav_need_help) {
                if (session.isLoggedIn()) {
                    loadFrag(new PrimeHelpFragment());
                } else {
                    startActivity(new Intent(activity, LoginActivity.class));
                }
                binding.textHomeTitle.setText(R.string.need_help);
            } else if (itemId == R.id.bottom_nav_associate) {
                if (session.isLoggedIn()) {
                    loadFrag(new PrimeAssociateFragment());
                } else {
                    startActivity(new Intent(activity, LoginActivity.class));
                }
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
        binding.navAboutUsLay.setOnClickListener(v -> {
            if (session.isLoggedIn()) startActivity(new Intent(activity, AboutUsActivity.class));
            else startActivity(new Intent(activity, LoginActivity.class));
        });

        binding.navEmiCalculatorLay.setOnClickListener(v -> {
            if (session.isLoggedIn())
                startActivity(new Intent(activity, EmiCalculatorActivity.class));
            else startActivity(new Intent(activity, LoginActivity.class));
        });

        binding.navNewAssoLay.setOnClickListener(v -> {
            if (session.isLoggedIn())
                startActivity(new Intent(activity, SignupUserInfoActivity.class));
            else startActivity(new Intent(activity, LoginActivity.class));
        });

        binding.navVisitorListLay.setOnClickListener(v -> {
            if (session.isLoggedIn())
                startActivity(new Intent(activity, VisitorListActivity.class));
            else startActivity(new Intent(activity, LoginActivity.class));
        });

        binding.navMyAssoLay.setOnClickListener(v -> {
            if (session.isLoggedIn())
                startActivity(new Intent(activity, MyAssociatesActivity.class));
            else startActivity(new Intent(activity, LoginActivity.class));
        });

        binding.navChatSupportLay.setOnClickListener(v -> {
            if (session.isLoggedIn()) {
                String url = "https://api.whatsapp.com/send?phone=+919993511311";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            } else startActivity(new Intent(activity, LoginActivity.class));
        });

        binding.navHomeLoanLay.setOnClickListener(v -> {
            if (session.isLoggedIn())
                startActivity(new Intent(activity, HomeLoanEnquiryActivity.class));
            else startActivity(new Intent(activity, LoginActivity.class));
        });

        binding.navCommercialSearchLay.setOnClickListener(v -> {
            if (session.isLoggedIn()) {
                session.setSearch("commercial");
                binding.bottomNavigation.setSelectedItemId(R.id.bottom_nav_search);
                binding.drawerLayout.close();
            } else startActivity(new Intent(activity, LoginActivity.class));
        });

        binding.navFarmhouseSearchLay.setOnClickListener(v -> {
            if (session.isLoggedIn()) {
                session.setSearch("farmhouse");
                binding.bottomNavigation.setSelectedItemId(R.id.bottom_nav_search);
                binding.drawerLayout.close();
            } else startActivity(new Intent(activity, LoginActivity.class));
        });

        binding.navResidentialSearchLay.setOnClickListener(v -> {
            if (session.isLoggedIn()) {
                session.setSearch("residential");
                binding.bottomNavigation.setSelectedItemId(R.id.bottom_nav_search);
                binding.drawerLayout.close();
            } else startActivity(new Intent(activity, LoginActivity.class));

        });

        binding.navLogoutLay.setOnClickListener(v -> {
            if (session.isLoggedIn()) logout();
            else startActivity(new Intent(activity, LoginActivity.class));
        });
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