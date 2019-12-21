package com.bw.miaoheng20191221.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.miaoheng20191221.R;
import com.bw.miaoheng20191221.adapter.ShopAdapter;
import com.bw.miaoheng20191221.base.BaseFragment;
import com.bw.miaoheng20191221.base.mvp.BasePresenter;
import com.bw.miaoheng20191221.contract.IShopContract;
import com.bw.miaoheng20191221.entity.ShopEntity;
import com.bw.miaoheng20191221.entity.TagEntity;
import com.bw.miaoheng20191221.presenter.ShopPresenter;
import com.bw.miaoheng20191221.view.activity.Main2Activity;
import com.bw.miaoheng20191221.width.FlowLayout;

import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

/**
 * 时间 :2019/12/21  8:55
 * 作者 :苗恒
 * 功能 :
 */
public class HomeFragment extends BaseFragment<ShopPresenter> implements IShopContract.IView {

    private EditText et_serch;
    private Button bt_serch;
    private FlowLayout flowLayout;
    private RecyclerView recyclerView;

    @Override
    protected ShopPresenter initPresenter() {
        return new ShopPresenter();
    }

    @Override
    protected void initView(View inflate) {
        et_serch = inflate.findViewById(R.id.et_serch);
        bt_serch = inflate.findViewById(R.id.bt_serch);
        flowLayout = inflate.findViewById(R.id.flow);
        recyclerView = inflate.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        flowLayout.setFlowCallBack(new FlowLayout.FlowCallBack() {
            @Override
            public void getName(String s) {
                String url="http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword="+ URLEncoder.encode(s) +"&page=1&count=10";
                presenter.getShopData(url);
            }
        });
    }

    @Override
    protected int bindLayoutid() {
        return R.layout.homefragment;
    }

    @Override
    protected void initData() {
      presenter.getTagData("http://blog.zhaoliang5156.cn/baweiapi/"+ URLEncoder.encode("手机"));
      //获取输入的内容
        bt_serch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = et_serch.getText().toString();
                flowLayout.addShopView(s);
                String url="http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword="+ URLEncoder.encode(s) +"&page=1&count=10";
                presenter.getShopData(url);
            }
        });
    }

    @Override
    public void success(Object data) {
        if(data instanceof TagEntity){
            List<String> tags = ((TagEntity) data).getTags();
            flowLayout.add(tags);
        }else if(data instanceof ShopEntity){
            List<ShopEntity.ResultBean> result = ((ShopEntity) data).getResult();
            ShopAdapter shopAdapter = new ShopAdapter(getActivity(), result);
            recyclerView.setAdapter(shopAdapter);

            shopAdapter.setAdapterCallBack(new ShopAdapter.AdapterCallBack() {
                @Override
                public void getName(String s) {
                    Toast.makeText(getContext(), ""+s, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(), Main2Activity.class);
                    startActivity(intent);
                }
            });
        }
    }
    @Override
    public void error(Throwable throwable) {

    }
}
