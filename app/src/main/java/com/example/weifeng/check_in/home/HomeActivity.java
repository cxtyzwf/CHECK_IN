package com.example.weifeng.check_in.home;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.ImageView;

import com.example.weifeng.check_in.R;
import com.example.weifeng.check_in.check.CheckActivity;
import com.mcxtzhang.commonadapter.rv.CommonAdapter;
import com.mcxtzhang.commonadapter.rv.ViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

     RecyclerView mRV;
     List<SwipeCardBean> mDatas;
     CommonAdapter<SwipeCardBean> mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mRV=findViewById(R.id.recyclerView);
        mRV.setLayoutManager(new OverLayCareLayoutManager());
        mRV.setAdapter(mAdapter = new CommonAdapter<SwipeCardBean>(this, mDatas = SwipeCardBean.initDatas(), R.layout.item_swipe_card) {
            @Override
            public void convert(ViewHolder viewHolder, SwipeCardBean swipeCardBean) {
                viewHolder.setText(R.id.tvName, swipeCardBean.getName());
//                viewHolder.setText(R.id.tvPrecent, swipeCardBean.getPostition() + " /" + mDatas.size());
                Picasso.with(HomeActivity.this).load(swipeCardBean.getUrl()).into((ImageView) viewHolder.getView(R.id.iv));
            }
        });

        CardConfig.initConfig(this);
        ItemTouchHelper.Callback callback = new RenRenCallback(mRV,mAdapter,mDatas);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(mRV);

    }

    public void checkClick(View view) {
        startActivity(new Intent(this, CheckActivity.class));
    }
}
