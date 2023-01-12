package com.shamniestate.shamniestate.ui.getstarted;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.ui.auth.LoginActivity;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ImageView imageView = findViewById(R.id.shamni_logo);
       //// setAnimations(imageView);

        Thread thread = new Thread(() -> {
            try {
                sleep(2000);
                startActivity( new Intent(SplashActivity.this, LoginActivity.class));
                finish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();


    }

    private void setAnimations(ImageView imageView) {
        YoYo.with(Techniques.ZoomIn).duration(1000).repeat(0).playOn(imageView);
//

//
    }


}