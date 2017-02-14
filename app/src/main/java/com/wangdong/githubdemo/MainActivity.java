package com.wangdong.githubdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button startService;
    private Button stopService;
    private Button startIntentService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService = (Button) findViewById(R.id.btn_start_service);
        stopService = (Button) findViewById(R.id.btn_stop_service);
        startIntentService = (Button) findViewById(R.id.btn_start_intent_service);

        final Intent intent = new Intent(this,FristService.class);

        startService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(intent);
            }
        });

        stopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(intent);
            }
        });

        startIntentService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten = new Intent(MainActivity.this,MyIntentService.class);
                startService(inten);
            }
        });
    }
}
