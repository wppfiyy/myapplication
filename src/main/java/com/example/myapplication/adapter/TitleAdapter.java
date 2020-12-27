package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.myapplication.R;


public class TitleAdapter extends DelegateAdapter.Adapter {
    private LinearLayoutHelper linearLayoutHelper;
    private Context context;
    private String title;

    public TitleAdapter(LinearLayoutHelper linearLayoutHelper, Context context, String title) {
        this.linearLayoutHelper = linearLayoutHelper;
        this.context = context;
        this.title = title;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {

        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.title, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.tv_brandtitle_home.setText(title);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv_brandtitle_home;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_brandtitle_home = itemView.findViewById(R.id.tv_branttitle_home);
        }
    }
}