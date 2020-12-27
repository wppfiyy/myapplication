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
import java.util.List;

public class FuAdapter extends DelegateAdapter.Adapter {
    public List<BannerBen.DataDTO.CategoryListDTO.GoodsListDTO>list;
    private Context context;
    private GridLayoutHelper gridLayoutHelper;

    public FuAdapter(List<BannerBen.DataDTO.CategoryListDTO.GoodsListDTO> list, Context context, GridLayoutHelper gridLayoutHelper) {
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
        View view = LayoutInflater.from(context).inflate(R.layout.categorylist, parent, false);
        return new FuHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FuHolder fuHolder= (FuHolder) holder;

        fuHolder.prive.setText("￥"+list.get(position).getRetail_price());
        fuHolder.name.setText(list.get(position).getName());
        Glide.with(context).load(list.get(position).getList_pic_url()).into(fuHolder.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class FuHolder extends RecyclerView.ViewHolder {
    private ImageView iv;
    private TextView name;
    private TextView prive;
        public FuHolder(@NonNull View itemView) {
        super(itemView);
        iv=itemView.findViewById(R.id.categroy_url);
        name=itemView.findViewById(R.id.category_name);
        prive=itemView.findViewById(R.id.categroy_price);
    }
}
}
