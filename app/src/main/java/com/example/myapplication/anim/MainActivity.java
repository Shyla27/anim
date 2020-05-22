package com.example.myapplication.anim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {
/*
   */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);



        //Hooks
        View image = findViewById(R.id.imageView);
        View logo = findViewById(R.id.textView);
        View slogan = findViewById(R.id.textView2);
       //Animations
        Animation topAnim = AnimationUtils.loadAnimation(this, R.anim.topanim);
        Animation bottomAnim = AnimationUtils.loadAnimation(this, R.anim.topanim);
//Set animation to elements
        image.setAnimation(topAnim);
        logo.setAnimation(bottomAnim);
        slogan.setAnimation(bottomAnim);
        final Intent i = new Intent(this, ArtsActivity.class);
        Thread timer = new Thread() {
            public void run () {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }
}
