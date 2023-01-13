package com.shamniestate.shamniestate.ui.getstarted;

import static java.lang.Thread.sleep;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.ui.UserHomeActivity;
import com.shamniestate.shamniestate.ui.auth.LoginActivity;
import com.shamniestate.shamniestate.utils.Session;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        session = new Session(this);

        ImageView imageView = findViewById(R.id.shamni_logo);
        // setAnimations(imageView);

        Thread thread = new Thread(() -> {
            try {
                sleep(2000);

                if (session.isLoggedIn()) {
                    startActivity(new Intent(SplashActivity.this, UserHomeActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();


    }

//    private void setAnimations(ImageView imageView) {
//        YoYo.with(Techniques.ZoomIn).duration(1000).repeat(0).playOn(imageView);
////
//
////
//    }


}