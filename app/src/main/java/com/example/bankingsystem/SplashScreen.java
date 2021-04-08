package com.example.bankingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import static java.lang.Thread.sleep;

public class SplashScreen extends AppCompatActivity {

    ImageView app_img;
    TextView app_name;
    LottieAnimationView lottieAnimationView=null;
    Animation top_anim,bottom_anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        app_img=(ImageView)findViewById(R.id.app_img);
        app_name=(TextView)findViewById(R.id.app_name);
        lottieAnimationView=(LottieAnimationView)findViewById(R.id.lottie);

        top_anim= AnimationUtils.loadAnimation(this,R.anim.top_anim);
        bottom_anim=AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        app_img.setAnimation(top_anim);
        app_name.setAnimation(bottom_anim);

        app_img.animate().translationY(-1600).setDuration(1000).setStartDelay(4000);
        app_name.animate().translationY(-1600).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(1400).setDuration(1000).setStartDelay(4000);

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(5000);
                    Intent intent=new Intent(SplashScreen.this,MainActivity.class);
                    if(intent.resolveActivity(getPackageManager())!=null)
                    {
                        startActivity(intent);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();
    }
}