package com.example.weifeng.check_in.check;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.weifeng.check_in.R;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<MyViewHolder>{

    private List<String> list;

    public HomeAdapter(List<String> list) {
        this.list = list;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {
        holder.tv.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv;
    public MyViewHolder(View itemView) {
        super(itemView);
        tv = itemView.findViewById(R.id.textview);
    }
}