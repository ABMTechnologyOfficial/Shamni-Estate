package com.shamniestate.shamniestate.ui.getstarted;

import static java.lang.Thread.sleep;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.snackbar.Snackbar;
import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.RetrofitApis.ApiInterface;
import com.shamniestate.shamniestate.RetrofitApis.RetrofitClient;
import com.shamniestate.shamniestate.models.AppDetailsModel;
import com.shamniestate.shamniestate.ui.home.UserHomeActivity;
import com.shamniestate.shamniestate.ui.auth.LoginActivity;
import com.shamniestate.shamniestate.utils.Session;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {
    private Session session;
    private boolean isAvailable = false ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        session = new Session(this);
        CoordinatorLayout codinate = findViewById(R.id.codinate);
        getAppDetails();
        ImageView imageView = findViewById(R.id.shamni_logo);
        // setAnimations(imageView);

        Thread thread = new Thread(() -> {
            try {
                sleep(2000);
                if (isAvailable) {
                    if (session.isLoggedIn()) {
                        startActivity(new Intent(SplashActivity.this, UserHomeActivity.class));
                    } else {
                        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    }
                    finish();
                } else {
                    Snackbar
                            .make(codinate, "Pehle App Ka Paisa do..!", Snackbar.LENGTH_LONG).show();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
    }



    private  void getAppDetails(){


        ApiInterface apiInterface = RetrofitClient.getApp(SplashActivity.this);
        apiInterface.getAppDetails("1").enqueue(new Callback<AppDetailsModel>() {
            @Override
            public void onResponse(@NonNull Call<AppDetailsModel> call, @NonNull Response<AppDetailsModel> response) {

                try {
                    if(response.code() == 200)
                        if(response.body() != null ){
                            if(response.body().getResult().equalsIgnoreCase("true"))
                             isAvailable = true;
                        }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(@NonNull Call<AppDetailsModel> call, @NonNull Throwable t) {
                Log.e("TAG", "onFailure() called with: call = [" + call + "], t = [" + t + "]");
            }
        });

    }
}