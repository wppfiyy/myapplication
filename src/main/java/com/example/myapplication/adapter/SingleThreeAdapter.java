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
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.myapplication.Ben.BannerBen;
import com.example.myapplication.R;

import java.util.ArrayList;

public class SingleThreeAdapter extends DelegateAdapter.Adapter {
    private ArrayList<BannerBen.DataDTO.ChannelDTO>list;
    private Context context;
   private GridLayoutHelper gridLayoutHelper;

    public SingleThreeAdapter(ArrayList<BannerBen.DataDTO.ChannelDTO> list, Context context, GridLayoutHelper gridLayoutHelper) {
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_three, parent, false);
        return new SingleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SingleHolder singleHolder= (SingleHolder) holder;
        singleHolder.tv.setText(list.get(position).getName());
        Glide.with(context).load(list.get(position).getIcon_url()).into(singleHolder.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class SingleHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv;
        public SingleHolder(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.single_three_img);
            tv=itemView.findViewById(R.id.single_three_tv);
        }
    }
}
