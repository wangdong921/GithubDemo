package com.wangdong.githubdemo;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;


public class MyIntentService extends IntentService {
    private static final String TAG = "MyIntentService";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        long endTime = System.currentTimeMillis() + 20*1000;
        while (System.currentTimeMillis()<endTime){
            synchronized (this){
                try {
                    wait(endTime-System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        Log.d(TAG, "onHandleIntent: 耗时任务结束");
    
    }

}
