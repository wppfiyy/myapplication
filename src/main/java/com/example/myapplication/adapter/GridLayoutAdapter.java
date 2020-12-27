package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.myapplication.Ben.BannerBen;
import com.example.myapplication.R;

import java.util.ArrayList;

public class GridLayoutAdapter extends DelegateAdapter.Adapter {
    private ArrayList<BannerBen.DataDTO.NewGoodsListDTO> list;
    private Context context;
    private GridLayoutHelper gridLayoutHelper;

    public GridLayoutAdapter(ArrayList<BannerBen.DataDTO.NewGoodsListDTO> list, Context context, GridLayoutHelper gridLayoutHelper) {
        this.list = list;
        this.context = context;
        this.gridLayoutHelper = gridLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_five, parent, false);
        return new GridHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        GridHolder gridHolder = (GridHolder) holder;
        Glide.with(context).load(list.get(position).getList_pic_url()).into(gridHolder.iv);
        gridHolder.name.setText(list.get(position).getName());
        gridHolder.pic.setText("$" + list.get(position).getRetail_price());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class GridHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView name;
        private TextView pic;

        public GridHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.single_five_urlimage);
            name = itemView.findViewById(R.id.single_five_name);
            pic = itemView.findViewById(R.id.single_five_price);

        }
    }
}
