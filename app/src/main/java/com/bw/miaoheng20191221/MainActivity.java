package com.bw.miaoheng20191221;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.bw.miaoheng20191221.view.fragment.HomeFragment;
import com.bw.miaoheng20191221.view.fragment.OtherFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        radioGroup = findViewById(R.id.rg);
        final List<Fragment> list=new ArrayList<>();
        list.add(new HomeFragment());
        final OtherFragment bei = OtherFragment.getInstance("北京");
        OtherFragment wo = OtherFragment.getInstance("我的");
        list.add(bei);
        list.add(wo);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_1:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.rb_2:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.rb_3:
                        viewPager.setCurrentItem(2);
                        break;

                }
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            radioGroup.check(radioGroup.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
