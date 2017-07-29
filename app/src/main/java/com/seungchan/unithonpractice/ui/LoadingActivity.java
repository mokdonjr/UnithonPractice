package com.seungchan.unithonpractice.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.seungchan.unithonpractice.R;

public class LoadingActivity extends AppCompatActivity {
    private static String TAG = "LoadingActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
    }
}
