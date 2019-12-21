package com.bw.miaoheng20191221.adapter;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.miaoheng20191221.R;
import com.bw.miaoheng20191221.entity.ShopEntity;

import java.util.List;

/**
 * 时间 :2019/12/21  9:20
 * 作者 :苗恒
 * 功能 :
 */
public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.MyViewHolder> {
    Context context;
    List<ShopEntity.ResultBean> result;
    public ShopAdapter(Context context, List<ShopEntity.ResultBean> result) {
        this.context=context;
        this.result=result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.item,null);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.tv_name.setText(result.get(position).getCommodityName());
        holder.tv_price.setText("￥"+result.get(position).getPrice());
        Glide.with(context).load(result.get(position).getMasterPic()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher_round).circleCrop().into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 adapterCallBack.getName(result.get(position).getCommodityName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private   ImageView imageView;
        private   TextView tv_name;
        private   TextView tv_price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_price = itemView.findViewById(R.id.tv_price);
        }
    }
    public AdapterCallBack adapterCallBack;

    public void setAdapterCallBack(AdapterCallBack adapterCallBack) {
        this.adapterCallBack = adapterCallBack;
    }

    public interface AdapterCallBack{
        void getName(String s);
    }
}
