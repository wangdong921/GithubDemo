package com.wangdong.githubdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventBusActivity extends AppCompatActivity {
    private Button mGotoReceive;
    private TextView mShowMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
        initView();
        mGotoReceive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EventBusActivity.this,ReceiveEventBusActivity.class);
                startActivity(intent);
            }
        });
        //注册EventBus
        EventBus.getDefault().register(this);
    }

    private void initView() {
        mGotoReceive = (Button) findViewById(R.id.btn_goto_receive);
        mShowMsg = (TextView) findViewById(R.id.tv_show_message);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent messageEvent){
        mShowMsg.setText(messageEvent.getMsg().toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
