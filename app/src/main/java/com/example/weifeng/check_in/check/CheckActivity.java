package com.example.weifeng.check_in.check;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.weifeng.check_in.R;
import com.example.weifeng.check_in.home.HomeActivity;

import java.util.ArrayList;
import java.util.List;

public class CheckActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private HomeAdapter mAdapter;
    private TextView date_show;
    private Button date_choose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        initData();
        date_show = findViewById(R.id.date_show);
        date_choose = findViewById(R.id.date_choose);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter = new HomeAdapter(mDatas));
    }

    private void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A';i<'Z';i++){
            mDatas.add(""+(char)i);
        }
    }

    public void check_late(View view) {
        date_show.setVisibility(View.GONE);
        date_choose.setVisibility(View.GONE);
    }

    public void check_leave(View view) {
        date_show.setVisibility(View.GONE);
        date_choose.setVisibility(View.GONE);
    }

    public void check_date(View view) {
        date_show.setVisibility(View.VISIBLE);
        date_choose.setVisibility(View.VISIBLE);
    }

    public void date_choose(View view) {
}

    public void date_choose_ok(View view) {
    }
}
