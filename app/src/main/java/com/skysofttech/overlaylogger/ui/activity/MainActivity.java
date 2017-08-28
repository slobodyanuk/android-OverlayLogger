package com.skysofttech.overlaylogger.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.skysofttech.overlaylogger.LoggerService;

/**
 * Author: Serhii Slobodianiuk
 * Date: 8/28/17
 */

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoggerService.setState(this, true);
    }
}
