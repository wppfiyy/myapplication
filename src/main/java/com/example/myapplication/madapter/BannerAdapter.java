package com.example.myapplication.madapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.myapplication.Ben.BannerBen;
import com.example.myapplication.R;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class BannerAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<BannerBen.DataDTO.BannerDTO> bannerList;
    private SingleLayoutHelper singleLayoutHelper;

    public BannerAdapter(Context context, ArrayList<BannerBen.DataDTO.BannerDTO> bannerList, SingleLayoutHelper singleLayoutHelper) {
        this.context = context;
        this.bannerList = bannerList;
        this.singleLayoutHelper = singleLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.banner_item, parent, false);
        return new BannerViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BannerViewHolder bannerViewHolder= (BannerViewHolder) holder;
        bannerViewHolder.banner.setImages(bannerList).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                BannerBen.DataDTO.BannerDTO pen= (BannerBen.DataDTO.BannerDTO) path;
                Glide.with(context).load(pen.getImage_url()).into(imageView);
            }
        }).start();
    }

    @Override
    public int getItemCount() {
        return bannerList.size();
    }

    private class BannerViewHolder extends RecyclerView.ViewHolder {
        Banner banner;
        public BannerViewHolder(View root) {
            super(root);
            banner=root.findViewById(R.id.banner);
        }
    }
}
