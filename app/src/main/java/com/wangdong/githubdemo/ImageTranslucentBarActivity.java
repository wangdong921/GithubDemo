package com.wangdong.githubdemo;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ImageTranslucentBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_translucent_bar);
        ActionBar actionBar =getSupportActionBar();
        actionBar.hide();
    }
}
