package com.wangdong.githubdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {
    private List<String> mDatas;
    private RecyclerView mRecyclerView;
    private MyRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        initData();
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_frist);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MyRecyclerAdapter();
        mRecyclerView.setAdapter(mAdapter);
    }

    /**
     * 初始化数据
     */
    private void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i <= 'Z'; i++) {
            mDatas.add("" + (char) i);
        }
    }

    class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

        @Override
        public MyRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(ThirdActivity.this)
                    .inflate(R.layout.recycler_item, parent, false));
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(MyRecyclerAdapter.MyViewHolder holder, int position) {
            holder.mTv.setText(mDatas.get(position));
        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView mTv;

            public MyViewHolder(View itemView) {
                super(itemView);
                mTv = (TextView) itemView.findViewById(R.id.tv_char);
            }
        }
    }
}
