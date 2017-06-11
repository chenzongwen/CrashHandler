package com.owen.crashhandler;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;

import com.owen.crashhandler.main.CrashHandler;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Owen Chan
 * On 2017-06-07.
 */

public class ClientApp extends Application {

    private static ClientApp INSTANCE;
    private PendingIntent restartIntent;


    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler.CrashUploader crashUploader = new CrashHandler.CrashUploader() {

            @Override
            public void uploadCrashMessage(ConcurrentHashMap<String, Object> info) {

            }
        };
        INSTANCE = this;
        // 以下用来捕获程序崩溃异常
        Intent intent = new Intent();
        intent.setClassName("com.owen.crashhandler", "com.owen.crashhandler.main.MainActivity");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        restartIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);

        CrashHandler.getInstance().init(this, crashUploader, restartIntent);
    }


    public synchronized static ClientApp getInstance() {
        return INSTANCE;
    }

}
