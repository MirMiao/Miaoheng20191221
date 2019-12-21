package com.bw.miaoheng20191221.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bw.miaoheng20191221.R;

/**
 * 时间 :2019/12/21  8:57
 * 作者 :苗恒
 * 功能 :
 */
public class OtherFragment  extends Fragment {

    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.otherfragment, container, false);
        textView = inflate.findViewById(R.id.tv);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String key = getArguments().getString("key");
        textView.setText(key);
    }

    public static OtherFragment getInstance(String s) {
        OtherFragment otherFragment = new OtherFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key",s);
        otherFragment.setArguments(bundle);
        return otherFragment;
    }
}
