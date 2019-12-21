package com.bw.miaoheng20191221.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bw.miaoheng20191221.base.mvp.BasePresenter;
import com.bw.miaoheng20191221.base.mvp.IBaseView;

/**
 * 时间 :2019/12/21  8:37
 * 作者 :苗恒
 * 功能 :
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IBaseView {
    public P presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(bindLayoutid(), container, false);
        presenter=initPresenter();
        if (presenter != null) {
            presenter.attach(this);
        }
        initView(inflate);

        return inflate;
    }

    protected abstract P initPresenter();

    protected abstract void initView(View inflate);

    protected abstract int bindLayoutid();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract void initData();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.deattach();
        }
    }
}
