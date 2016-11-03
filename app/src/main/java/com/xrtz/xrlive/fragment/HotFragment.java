package com.xrtz.xrlive.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xrtz.xrlive.R;
import com.xrtz.xrlive.activity.SurfacePlayerVideoActivity;
import com.xrtz.xrlive.adapter.HotAdapter;
import com.xrtz.xrlive.bean.HotLiveBean;
import com.xrtz.xrlive.listener.RecyclerViewClickListener;
import com.xrtz.xrlive.view.RecycleViewDivider;

import java.util.ArrayList;
import java.util.List;

/**
 * HomeFragment里显示的 热门 的子界面
 */
public class HotFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;
    HotAdapter hotAdapter;
    public HotFragment() {

    }

    public static HotFragment newInstance(String param1, String param2) {
        HotFragment fragment = new HotFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hot, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycleView);
        List<HotLiveBean> list = new ArrayList<>();
        list.add(new HotLiveBean("小小丸子","大连市","20002",R.mipmap.test1));
        list.add(new HotLiveBean("幕依","北京市","17453",R.mipmap.test2));
        list.add(new HotLiveBean("杨木木","太原市","11153",R.mipmap.test3));
        list.add(new HotLiveBean("自测","深圳市","31153",R.mipmap.test5));
        hotAdapter = new HotAdapter(list);

        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext().getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.addItemDecoration(new RecycleViewDivider(container.getContext().getApplicationContext(), LinearLayoutManager.VERTICAL, 5, R.drawable.divider_mileage));
        recyclerView.setAdapter(hotAdapter);

        //调用RecyclerView#addOnItemTouchListener方法能添加一个RecyclerView.OnItemTouchListener对象
        recyclerView.addOnItemTouchListener(new RecyclerViewClickListener(container.getContext().getApplicationContext(),new RecyclerViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getContext(), SurfacePlayerVideoActivity.class);
                //intent.putExtra("path","rtmp://211.149.239.170:1935/live/");//默认的测试的看视频的地址
                if(position>0) {
                    intent.putExtra("path", "rtmp://live.hkstv.hk.lxdns.com/live/hks");
                }else{
                    intent.putExtra("path","rtmp://211.149.239.170:1935/live/");
                }
                startActivity(intent);
                //Toast.makeText(MainActivity.this,"Click "+mData.get(position),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                //Toast.makeText(MainActivity.this,"Long Click "+mData.get(position),Toast.LENGTH_SHORT).show();
            }
        }));

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}