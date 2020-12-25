package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.example.myapplication.Fragment.FengFragment;
import com.example.myapplication.Fragment.GouFragment;
import com.example.myapplication.Fragment.ShouFragment;
import com.example.myapplication.Fragment.WoFragment;
import com.example.myapplication.Fragment.ZhuanFragment;
import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RadioButton mBut1;
    private RadioButton mBut2;
    private RadioButton mBut3;
    private RadioButton mBut4;
    private RadioButton mBut5;
    private RadioGroup mRadio;
    private ShouFragment shouFragment;
    private ZhuanFragment zhuanFragment;
    private FragmentManager manager;
    private FengFragment fengFragment;
    private GouFragment gouFragment;
    private WoFragment woFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }



    private void initView() {
        mBut1=(RadioButton) findViewById(R.id.but1);
        mBut2=(RadioButton)findViewById(R.id.but2);
        mBut3=(RadioButton)findViewById(R.id.but3);
        mBut4=(RadioButton)findViewById(R.id.but4);
        mBut5=(RadioButton)findViewById(R.id.but5);
        mRadio=(RadioGroup) findViewById(R.id.radio);

        mBut1.setOnClickListener(this);
        mBut2.setOnClickListener(this);
        mBut3.setOnClickListener(this);
        mBut4.setOnClickListener(this);
        mBut5.setOnClickListener(this);

        shouFragment = new ShouFragment();
        zhuanFragment = new ZhuanFragment();
        fengFragment = new FengFragment();
        gouFragment = new GouFragment();
        woFragment = new WoFragment();
        manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.count,shouFragment)
                .add(R.id.count,zhuanFragment)
                .add(R.id.count,fengFragment)
                .add(R.id.count,gouFragment)
                .add(R.id.count,woFragment)
                .show(shouFragment)
                .hide(zhuanFragment)
                .hide(fengFragment)
                .hide(gouFragment)
                .hide(woFragment)
                .commit();



    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.but1:
                manager.beginTransaction()
                        .show(shouFragment)
                        .hide(zhuanFragment)
                        .hide(fengFragment)
                        .hide(gouFragment)
                        .hide(woFragment)
                        .commit();
                break;

            case R.id.but2:
                manager.beginTransaction()
                        .show(zhuanFragment)
                        .hide(shouFragment)
                        .hide(fengFragment)
                        .hide(gouFragment)
                        .hide(woFragment)
                        .commit();
                break;

            case R.id.but3:
                manager.beginTransaction()
                        .show(fengFragment)
                        .hide(shouFragment)
                        .hide(zhuanFragment)
                        .hide(gouFragment)
                        .hide(woFragment)
                        .commit();
                break;

            case R.id.but4:
                manager.beginTransaction()
                        .show(gouFragment)
                        .hide(shouFragment)
                        .hide(zhuanFragment)
                        .hide(fengFragment)
                        .hide(woFragment)
                        .commit();
                break;

            case R.id.but5:
                manager.beginTransaction()
                        .show(woFragment)
                        .hide(shouFragment)
                        .hide(zhuanFragment)
                        .hide(fengFragment)
                        .hide(shouFragment)
                        .commit();
                break;
        }
    }
}