package com.wangdong.githubdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

public class FristService extends Service {
    private static final String TAG = "FristService";
    public FristService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    //Service 被创建时回调该方法
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }
    //Service 被启动时回调该方法
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        long endTime = System.currentTimeMillis() +20 *1000;
        while (System.currentTimeMillis()<endTime){
            synchronized (this){
                try {
                    wait(endTime - System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
