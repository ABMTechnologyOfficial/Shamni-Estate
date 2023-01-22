package com.shamniestate.shamniestate.ui.auth;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.primeSection.PrimeHomeActivity;
import com.shamniestate.shamniestate.ui.getstarted.SplashActivity;
import com.shamniestate.shamniestate.ui.home.UserHomeActivity;
import com.shamniestate.shamniestate.utils.Session;

public class LoginSuccessActivity extends AppCompatActivity {

    private Session session ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        session = new Session(LoginSuccessActivity.this);

        Thread thread = new Thread(() -> {
            try {
                sleep(3000);

                if(session.getUserIType().equalsIgnoreCase("2")){
                    startActivity(new Intent(LoginSuccessActivity.this, PrimeHomeActivity.class)
                            .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    finish();
                }else {
                    startActivity(new Intent(LoginSuccessActivity.this, UserHomeActivity.class)
                            .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    finish();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();

    }
}