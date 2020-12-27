package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.example.myapplication.Ben.BannerBen;
import com.example.myapplication.R;

import java.util.List;

public class TopicItemAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<BannerBen.DataDTO.TopicListDTO> list;

    public TopicItemAdapter(Context mContext, List<BannerBen.DataDTO.TopicListDTO> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(mContext).inflate(R.layout.single_seven,parent,false);
        return new ViewHolder(root);
    }

    @Override
    public int getItemViewType(int position) {
        return 7;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position)==7){
            BannerBen.DataDTO.TopicListDTO topicListBean = list.get(position);
            ViewHolder viewHolder = (ViewHolder) holder;
            Glide.with(mContext).load(topicListBean.getItem_pic_url()).into(viewHolder.iv_topic);
            viewHolder.tv_title.setText(topicListBean.getTitle());
            viewHolder.tv_intro.setText(topicListBean.getSubtitle());
            viewHolder.tv_price.setText("¥  "+topicListBean.getPrice_info()+" 元起");
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_title;
        private final TextView tv_price;
        private final TextView tv_intro;
        private final ImageView iv_topic;

        public ViewHolder(View root) {
            super(root);
            tv_title = root.findViewById(R.id.tv_topictitle_home);
            tv_price = root.findViewById(R.id.tv_topicprice_home);
            tv_intro = root.findViewById(R.id.tv_topicintro_home);
            iv_topic = root.findViewById(R.id.iv_topic_home);
        }
    }
}