package com.wangdong.githubdemo;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "SecondActivity";
    
    private Button bindService;
    private Button btnunbindService;
    private Button getServiceCount;

    BindService.MyBinder binder;

    //定义一个ServiceConnection
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            binder = (BindService.MyBinder) iBinder;
            Log.d(TAG, "onServiceConnected: ");
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(TAG, "onServiceDisconnected: ");
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        bindService = (Button) findViewById(R.id.btn_bind_service);
        btnunbindService = (Button) findViewById(R.id.btn_unbind_service);
        getServiceCount = (Button) findViewById(R.id.btn_get_status);

        final Intent intent = new Intent(this,BindService.class);

        bindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bindService(intent,conn, Service.BIND_AUTO_CREATE);
            }
        });

        btnunbindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unbindService(conn);
            }
        });

        getServiceCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SecondActivity.this,"Service 的count值为："+binder.getCount(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
