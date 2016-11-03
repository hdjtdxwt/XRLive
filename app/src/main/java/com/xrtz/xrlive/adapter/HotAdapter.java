package com.xrtz.xrlive.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xrtz.xrlive.R;
import com.xrtz.xrlive.bean.HotLiveBean;
import com.xrtz.xrlive.view.CircleImageView;

import java.util.List;

/**
 * Created by Administrator on 2016/11/3.
 */

public class HotAdapter extends RecyclerView.Adapter<HotAdapter.HotHolder> {
    List<HotLiveBean> list;

    public HotAdapter(List<HotLiveBean> list) {
        this.list = list;
    }

    @Override
    public HotHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HotHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hot_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(HotHolder holder, int position) {
        HotLiveBean bean = list.get(position);
        holder.nameTv.setText(bean.getName());
        holder.addressTv.setText(bean.getAddress());
        holder.lookingNumTv.setText(bean.getLookingNum());
        holder.bigImage.setImageResource(bean.getResId());
        holder.icon.setImageResource(bean.getResId());
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class HotHolder extends RecyclerView.ViewHolder {
        CircleImageView icon;
        ImageView bigImage;
        TextView nameTv;
        TextView addressTv;
        TextView lookingNumTv;

        public HotHolder(View itemView) {
            super(itemView);
            nameTv = (TextView) itemView.findViewById(R.id.name);
            icon = (CircleImageView) itemView.findViewById(R.id.icon);
            bigImage = (ImageView) itemView.findViewById(R.id.big_image);
            addressTv = (TextView) itemView.findViewById(R.id.address);
            lookingNumTv = (TextView) itemView.findViewById(R.id.lookingnum);

        }
    }
}