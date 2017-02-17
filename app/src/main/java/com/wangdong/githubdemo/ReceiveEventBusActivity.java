package com.wangdong.githubdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

public class ReceiveEventBusActivity extends AppCompatActivity {
    private Button mSendEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_event_bus);
        mSendEvent = (Button) findViewById(R.id.btn_sent_event);
        mSendEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new MessageEvent("Hello EventBus !"));
                finish();
            }
        });
    }
}
