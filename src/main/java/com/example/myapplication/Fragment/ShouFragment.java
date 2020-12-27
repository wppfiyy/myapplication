package com.example.myapplication.Fragment;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;


import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.myapplication.Ben.BannerBen;
import com.example.myapplication.R;
import com.example.myapplication.adapter.SingleFourAdapter;
import com.example.myapplication.adapter.SingleThreeAdapter;
import com.example.myapplication.adapter.SingleTwoAdapter;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.contract.MyContract;
import com.example.myapplication.madapter.BannerAdapter;
import com.example.myapplication.presenter.MyPresenter;

import java.util.ArrayList;
import java.util.List;

public class ShouFragment extends BaseFragment<MyPresenter> implements MyContract.IMainView {

    private RecyclerView mRecycler;
    private ArrayList<BannerBen.DataDTO.BannerDTO> bannerList;
    private BannerAdapter bannerAdapter;
    private SingleLayoutHelper singleLayoutHelper;
    private SingleTwoAdapter singleTwoAdapter;
    private DelegateAdapter delegateAdapter;


    private ArrayList<BannerBen.DataDTO.ChannelDTO> channelDTOS;
    private SingleThreeAdapter singleThreeAdapter;
    private ArrayList<BannerBen.DataDTO.NewGoodsListDTO> newGoodsListDTOS;
    private SingleFourAdapter singleFourAdapter;
    //    private GridLayoutAdapter gridLayoutAdapter;
//    private ArrayList<BannerBen.DataDTO.HotGoodsListDTO> hotGoodsListDTOS;
//    private GridLayoutSixAdapter gridLayoutSixAdapter;
//    private ArrayList<BannerBen.DataDTO.TopicListDTO> topicListDTOS;
//    private HorizontalAdapter horizontalAdapter;
//    private ArrayList<BannerBen.DataDTO.CategoryListDTO> goodsListDTOS;
//    private FuAdapter fuAdapter;


    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_shou, container, false);
        initView(inflate);
        return inflate;
    }*/

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_shou;
    }

    @Override
    public void initData() {
       per.fun();
    }

    @Override
    public void initView(@NonNull final View view) {
        mRecycler=view.findViewById(R.id.recycler);
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(getContext());
        RecyclerView.RecycledViewPool pool = new RecyclerView.RecycledViewPool();
        mRecycler.setRecycledViewPool(pool);
        pool.setMaxRecycledViews(0,10);

//        //第一行
//        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
//        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
//        singleLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
//        singleLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
//        //singleLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
//        singleLayoutHelper.setAspectRatio(12);// 设置设置布局内每行布局的宽与高的比
//
//
//        SingleAdapter singleAdapter = new SingleAdapter(singleLayoutHelper);




        //第二行
        //banner图片集合
        bannerList = new ArrayList<>();
        SingleLayoutHelper helper = new SingleLayoutHelper();
        singleTwoAdapter = new SingleTwoAdapter(bannerList, helper);


        //第三行
        channelDTOS = new ArrayList<>();
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(5);
        gridLayoutHelper.setItemCount(5);// 设置布局里Item个数
        gridLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        //gridLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
        gridLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的
        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper.setWeights(new float[]{20, 20, 20, 20, 20});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(20);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(20);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(5);// 设置每行多少个网格
        singleThreeAdapter = new SingleThreeAdapter(channelDTOS, getContext(), gridLayoutHelper);



        //第四行
        SingleLayoutHelper singleFourHelper = new SingleLayoutHelper();
        singleFourAdapter = new SingleFourAdapter(singleFourHelper);



        //设置适配器
        delegateAdapter = new DelegateAdapter(virtualLayoutManager, false);
//        delegateAdapter.addAdapter(singleAdapter);
        delegateAdapter.addAdapter(singleTwoAdapter);
        delegateAdapter.addAdapter(singleThreeAdapter);
        delegateAdapter.addAdapter(singleFourAdapter);
        mRecycler.setLayoutManager(virtualLayoutManager);
        mRecycler.setAdapter(delegateAdapter);
    }

    @Override
    public void onInit(BannerBen bannerBen) {
        bannerList.addAll(bannerBen.getData().getBanner());
        singleTwoAdapter.notifyDataSetChanged();
        channelDTOS.addAll(bannerBen.getData().getChannel());
        singleThreeAdapter.notifyDataSetChanged();
        singleFourAdapter.notifyDataSetChanged();
    }
}