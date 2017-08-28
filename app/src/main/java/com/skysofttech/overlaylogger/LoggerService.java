package com.skysofttech.overlaylogger;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.skysofttech.overlaylogger.domain.Log;
import com.skysofttech.overlaylogger.ui.widget.LoggerWidget;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Serhii Slobodianiuk
 * Date: 8/28/17
 */

public class LoggerService extends Service {

    private static final String TAG = LoggerService.class.getCanonicalName();

    private static final String ACTION_CHANGE_STATE = "ACTION_CHANGE_STATE";
    private static final String EXTRA_CHANGE_STATE = "EXTRA_CHANGE_STATE";

    private LoggerWidget widget;

    public static void setState(@NonNull Context context, boolean isShowing) {
        Intent intent = new Intent(ACTION_CHANGE_STATE, null, context, LoggerService.class);
        intent.putExtra(EXTRA_CHANGE_STATE, isShowing);
        context.startService(intent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        widget = new LoggerWidget.Builder()
                .setContext(this)
                .build();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null && intent.getAction() != null) {
            switch (intent.getAction()) {
                case ACTION_CHANGE_STATE: {
                    if (!(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this))) {
                        boolean show = intent.getBooleanExtra(EXTRA_CHANGE_STATE, false);
                        if (show) {
                            widget.show();
                            setTestLog();
                        } else {
                            widget.hide();
                        }
                    } else {
                        android.util.Log.w(TAG, "Can't change state! Device does not have drawOverlays permissions!");
                    }
                    break;
                }
            }
        }
        return START_STICKY;
    }

    private void setTestLog(){
        List<Log> logs = new ArrayList<>();

        for (int i = 0; i < 20; i++){
            Log log = new Log(Log.Type.values()[i % 2], "Log " + i + " text text text text Log text text text text Log text text text text");
            logs.add(log);
        }

        widget.setLogs(logs);
    }

}
