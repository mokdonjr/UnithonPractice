package com.seungchan.unithonpractice.ui;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


import com.seungchan.unithonpractice.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements NationalWeatherFragment.OnFragmentInteractionListener, CameraFragment.OnFragmentInteractionListener
    , IconSelectFragment.OnFragmentInteractionListener, OpinionFragment.OnFragmentInteractionListener{
    private static String TAG = "MainActivity";

    private Boolean isFabOpened = false;
    @BindView(R.id.fab_main)
    FloatingActionButton fabMain;
    @BindView(R.id.fab_call_camera_fragment)
    FloatingActionButton fabCallCameraFragment;
    @BindView(R.id.fab_call_icon_select_fragment)
    FloatingActionButton fabCallIconSelectFragment;
    private Animation fab_open, fab_close, rotate_forward, rotate_backward;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        Fragment upContent = null;
//        FragmentTransaction nationalWeatherFragmentTransaction = getSupportFragmentManager().beginTransaction();
//        upContent = NationalWeatherFragment.newInstance(); // 위도, 경도 인자로 넘기기 <-- BackgroundService
//        nationalWeatherFragmentTransaction.add(R.id.up_content, upContent);

        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        rotate_forward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_forward);
        rotate_backward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_backward);
    }

    @OnClick(R.id.fab_main) void onClickFabFloatingButton(){
        animateFabOpening();
    }

    @OnClick(R.id.fab_call_camera_fragment) void onClickFabCallCameraFloatingButton(){
        Fragment selectedFragment = null;
        FragmentTransaction deviceSettingFragmentTransaction = getSupportFragmentManager().beginTransaction();
        selectedFragment = CameraFragment.newInstance();
        deviceSettingFragmentTransaction.replace(R.id.down_content, selectedFragment);
        deviceSettingFragmentTransaction.commit();
    }

    @OnClick(R.id.fab_call_icon_select_fragment) void onClickFabCallIconSelectFloatingButton(){
        Fragment selectedFragment = null;
        FragmentTransaction deviceSettingFragmentTransaction = getSupportFragmentManager().beginTransaction();
        selectedFragment = IconSelectFragment.newInstance();
        deviceSettingFragmentTransaction.replace(R.id.down_content, selectedFragment);
        deviceSettingFragmentTransaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) { }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void animateFabOpening() {

        if (isFabOpened) {

            fabMain.startAnimation(rotate_backward);
            fabCallCameraFragment.startAnimation(fab_close);
            fabCallIconSelectFragment.startAnimation(fab_close);

            fabCallCameraFragment.setClickable(false);
            fabCallIconSelectFragment.setClickable(false);
            isFabOpened = false;
            Log.d(TAG, "플로팅바 close");

        } else {

            fabMain.startAnimation(rotate_forward);
            fabCallCameraFragment.startAnimation(fab_open);
            fabCallIconSelectFragment.startAnimation(fab_open);

            fabCallCameraFragment.setClickable(true);
            fabCallIconSelectFragment.setClickable(true);
            isFabOpened = true;
            Log.d(TAG, "플로팅바 open");
        }
    }
}
