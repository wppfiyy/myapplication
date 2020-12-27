package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;

import com.example.myapplication.Ben.BannerBen;
import com.example.myapplication.R;

import java.util.List;

public class HorizontalAdapter extends DelegateAdapter.Adapter<HorizontalAdapter.HorizontalViewHolder> {
    private int position;
    private Context mContext;

    private LayoutHelper mLayoutHelper;
    private List<BannerBen.DataDTO.TopicListDTO> topicList;
    private int xOffset;
    private TopicItemAdapter topicItemAdapter;


    public HorizontalAdapter(Context mContext, LayoutHelper mLayoutHelper, List<BannerBen.DataDTO.TopicListDTO> topicList) {
        this.mContext = mContext;
        this.mLayoutHelper = mLayoutHelper;
        this.topicList = topicList;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mLayoutHelper;
    }

    @Override
    public HorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 4) {
            return new HorizontalViewHolder(
                    LayoutInflater.from(mContext).inflate(R.layout.layout_recycler, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalViewHolder holder, int position) {
        if (holder.itemView instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) holder.itemView;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            topicItemAdapter = new TopicItemAdapter(mContext, topicList);
            recyclerView.setAdapter(topicItemAdapter);
        }
    }


    @Override
    public int getItemViewType(int position) {
        return 4;
    }

    @Override
    public int getItemCount() {
        return topicList.size()>0?1:0;
    }


    @Override
    public void onViewDetachedFromWindow(@NonNull HorizontalViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        if (holder.itemView instanceof RecyclerView) {
            RecyclerView recyclerView = ((RecyclerView) holder.itemView);
            LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
            position = manager.findFirstVisibleItemPosition();
            View view = manager.findViewByPosition(position);
            ViewGroup.MarginLayoutParams lp =
                    (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (view != null) {
                xOffset = view.getLeft() - lp.leftMargin; //如果你设置了margin则减去
            }
        }
    }

    @Override
    public void onViewAttachedToWindow(@NonNull HorizontalViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        if (holder.itemView instanceof RecyclerView) {
            RecyclerView recyclerView = ((RecyclerView) holder.itemView);
            LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
            manager.scrollToPositionWithOffset(position, xOffset);
        }
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder {
        public HorizontalViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}