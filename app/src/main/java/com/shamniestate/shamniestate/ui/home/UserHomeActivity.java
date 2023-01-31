package com.shamniestate.shamniestate.ui.home;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.databinding.ActivityUserHomeBinding;
import com.shamniestate.shamniestate.ui.auth.LoginActivity;
import com.shamniestate.shamniestate.ui.auth.SignupUserInfoActivity;
import com.shamniestate.shamniestate.ui.misc.AboutUsActivity;
import com.shamniestate.shamniestate.ui.misc.ChatSupportActivity;
import com.shamniestate.shamniestate.ui.misc.EmiCalculatorActivity;
import com.shamniestate.shamniestate.ui.misc.HomeLoanEnquiryActivity;
import com.shamniestate.shamniestate.utils.Session;
import com.shamniestate.shamniestate.visitors.AddVisitorInfoActivity;
import com.shamniestate.shamniestate.visitors.VisitorDocumentsActivity;
import com.shamniestate.shamniestate.visitors.VisitorListActivity;
import com.squareup.picasso.Picasso;

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

        if(!session.getProfileImage().equalsIgnoreCase(""))
            Picasso.get().load(session.getProfileImage()).placeholder(R.drawable.profile).into(binding.profileImage);

        if(session.getUserName().equalsIgnoreCase(""))
            binding.userName.setText(session.getUserName());



        binding.icMenu.setOnClickListener(view -> binding.drawerLayout.open());
    }

    private void setUpBottomNav() {
        loadFrag(new UserHomeFragment());

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.bottom_nav_home) {

                if (session.isLoggedIn()) {
                    loadFrag(new UserHomeFragment());
                } else {
                    startActivity(new Intent(activity, LoginActivity.class));
                }
                binding.textHomeTitle.setText(R.string.app_name);
            } else if (itemId == R.id.bottom_nav_search) {

                if (session.isLoggedIn()) {
                    loadFrag(new UserSearchFragment());
                } else {
                    startActivity(new Intent(activity, LoginActivity.class));
                }
                binding.textHomeTitle.setText(R.string.search);
            } else if (itemId == R.id.bottom_nav_need_help) {
                if (session.isLoggedIn()) {
                    loadFrag(new AssociateFragment());
                } else {
                    startActivity(new Intent(activity, LoginActivity.class));
                }
                binding.textHomeTitle.setText(R.string.need_help);
            } else if (itemId == R.id.bottom_nav_associate) {
                if (session.isLoggedIn()) {
                    loadFrag(new UserAssociateFragment());
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
            if (session.isLoggedIn())startActivity(new Intent(activity, AboutUsActivity.class));
            else startActivity(new Intent(activity, LoginActivity.class));
        });

        binding.navEmiCalculator.setOnClickListener(v -> {
            if(session.isLoggedIn())startActivity(new Intent(activity, EmiCalculatorActivity.class));
            else startActivity(new Intent(activity, LoginActivity.class));
        });

        binding.navNewAssociates.setOnClickListener(v -> {
            if(session.isLoggedIn()) startActivity(new Intent(activity, SignupUserInfoActivity.class));
            else startActivity(new Intent(activity, LoginActivity.class));
        });

        binding.navMyVisitors.setOnClickListener(v -> {
            if(session.isLoggedIn()) startActivity(new Intent(activity, VisitorListActivity.class));
            else startActivity(new Intent(activity, LoginActivity.class));
        });

        binding.navMyAssociates.setOnClickListener(v -> {
            if(session.isLoggedIn()) startActivity(new Intent(activity, MyAssociatesActivity.class));
            else startActivity(new Intent(activity, LoginActivity.class));
        });


        binding.navNewVisitors.setOnClickListener(v -> {
            if(session.isLoggedIn()) startActivity(new Intent(activity, AddVisitorInfoActivity.class));
            else startActivity(new Intent(activity, LoginActivity.class));
        });

        binding.navSupportManagerLay.setOnClickListener(v -> {
            if (session.isLoggedIn()){
                String url = "https://api.whatsapp.com/send?phone=+919993511311";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
            else startActivity(new Intent(activity, LoginActivity.class));
        });

        binding.navBankLoanLay.setOnClickListener(v -> {
            if (session.isLoggedIn())startActivity(new Intent(activity, HomeLoanEnquiryActivity.class));
            else startActivity(new Intent(activity, LoginActivity.class));
        });

        binding.navContactLay.setOnClickListener(v -> {
            if (session.isLoggedIn())startActivity(new Intent(activity, HomeLoanInquiryActivity.class));
            else startActivity(new Intent(activity, ChatSupportActivity.class));
        });

        binding.navMyProfile.setOnClickListener(v -> {
            binding.bottomNavigation.setSelectedItemId(R.id.bottom_nav_associate);
            binding.drawerLayout.close();
        });

        binding.navHeader.setOnClickListener(v -> {
            binding.bottomNavigation.setSelectedItemId(R.id.bottom_nav_associate);
            binding.drawerLayout.close();
        });

        binding.navHomeLay.setOnClickListener(v -> {
            binding.bottomNavigation.setSelectedItemId(R.id.bottom_nav_home);
            binding.drawerLayout.close();
        });

        binding.navDashboardLay.setOnClickListener(view -> {
            if (binding.navDashboardMenuLay.getVisibility() == View.VISIBLE) {
                binding.navDashboardMenuLay.setVisibility(View.GONE);
                binding.imageNavDashboardArrow.setImageResource(R.drawable.ic_arrow_down);
            } else {
                binding.navDashboardMenuLay.setVisibility(View.VISIBLE);
                binding.imageNavDashboardArrow.setImageResource(R.drawable.ic_arrow_up);
            }
        });

      binding.navCommercialSearchLay.setOnClickListener(v -> {
            if (session.isLoggedIn()){
                session.setSearch("commercial");
                binding.bottomNavigation.setSelectedItemId(R.id.bottom_nav_search);
                binding.drawerLayout.close();
            }
            else startActivity(new Intent(activity, LoginActivity.class));
        });

        binding.navResidentialSearchLay.setOnClickListener(v -> {
            if (session.isLoggedIn()){
                session.setSearch("residential");
                binding.bottomNavigation.setSelectedItemId(R.id.bottom_nav_search);
                binding.drawerLayout.close();
            }
            else startActivity(new Intent(activity, LoginActivity.class));

        });

        binding.navFarmhouseSearchLay.setOnClickListener(v -> {
            if (session.isLoggedIn()){
                session.setSearch("farmhouse");
                binding.bottomNavigation.setSelectedItemId(R.id.bottom_nav_search);
                binding.drawerLayout.close();
            }
            else startActivity(new Intent(activity, LoginActivity.class));
        });

        binding.navPremiumPropertyLay.setOnClickListener(v -> {
            if (session.isLoggedIn()){
                session.setSearch("premium");
                binding.bottomNavigation.setSelectedItemId(R.id.bottom_nav_search);
                binding.drawerLayout.close();
            }
            else startActivity(new Intent(activity, LoginActivity.class));
        });
    }


    @Override
    protected void onResume() {
        super.onResume();

        if(!session.getUserName().equalsIgnoreCase(""))
            binding.userName.setText(session.getUserName());

        if(!session.getEmail().equalsIgnoreCase(""))
            binding.userEmail.setText(session.getEmail());

        if(!session.getProfileImage().equalsIgnoreCase(""))
            Picasso.get().load(session.getProfileImage()).placeholder(R.drawable.profile).into(binding.profileImage);
        else binding.profileImage.setImageResource(R.drawable.profile);

    }
}