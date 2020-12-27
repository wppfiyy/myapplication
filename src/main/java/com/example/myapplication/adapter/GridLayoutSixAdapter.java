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

public class GridLayoutSixAdapter extends DelegateAdapter.Adapter {
    private ArrayList<BannerBen.DataDTO.HotGoodsListDTO>list;
    private Context context;
    private GridLayoutHelper gridLayoutHelper;

    public GridLayoutSixAdapter(ArrayList<BannerBen.DataDTO.HotGoodsListDTO> list, Context context, GridLayoutHelper gridLayoutHelper) {
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
        View view = LayoutInflater.from(context).inflate(R.layout.gride_six, parent, false);
        return new GridsixHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        GridsixHolder gridsixHolder= (GridsixHolder) holder;
        gridsixHolder.price.setText("￥"+list.get(position).getRetail_price());
        gridsixHolder.brief.setText(list.get(position).getGoods_brief());
        gridsixHolder.name.setText(list.get(position).getName());
        Glide.with(context).load(list.get(position).getList_pic_url()).into(gridsixHolder.url);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class GridsixHolder extends RecyclerView.ViewHolder {
        private ImageView url;
        private TextView name;
        private TextView brief;
        private TextView price;
        public GridsixHolder(@NonNull View itemView) {
            super(itemView);
            url=itemView.findViewById(R.id.gride_six_url);
            name=itemView.findViewById(R.id.gride_six_name);
            brief=itemView.findViewById(R.id.gride_six_brief);
            price=itemView.findViewById(R.id.gride_six_price);
        }
    }
}
