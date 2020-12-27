package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
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

public class SingleTwoAdapter extends DelegateAdapter.Adapter {
    private ArrayList<BannerBen.DataDTO.BannerDTO>imgs;
    private SingleLayoutHelper singleLayoutHelper;

    public SingleTwoAdapter(ArrayList<BannerBen.DataDTO.BannerDTO> imgs, SingleLayoutHelper singleLayoutHelper) {
        this.imgs = imgs;
        this.singleLayoutHelper = singleLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_two, parent, false);
        return new BannerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            BannerViewHolder bannerViewHolder= (BannerViewHolder) holder;
            bannerViewHolder.img.setImages(imgs);
            bannerViewHolder.img.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    BannerBen.DataDTO.BannerDTO db= (BannerBen.DataDTO.BannerDTO) path;
                    Glide.with(context).load(db.getImage_url()).into(imageView);
                }
            }).start();
    }

    @Override
    public int getItemCount() {
        return 1;
    }
    class BannerViewHolder extends RecyclerView.ViewHolder {
        private Banner img;
        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.single_two_img);
        }
    }
}
