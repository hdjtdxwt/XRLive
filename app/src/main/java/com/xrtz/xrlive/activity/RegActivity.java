package com.xrtz.xrlive.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xrtz.xrlive.R;

import butterknife.ButterKnife;

public class RegActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        ButterKnife.bind(this);

    }
}
