package com.bw.miaoheng20191221.width;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.miaoheng20191221.R;
import com.bw.miaoheng20191221.app.App;

import java.util.List;

/**
 * 时间 :2019/12/21  9:04
 * 作者 :苗恒
 * 功能 :
 */
public class FlowLayout extends ViewGroup {
    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, final int t, int r, int b) {
         int left=0;
         int top=0;
         int right=0;
         int bottom=0;
        int childCount = getChildCount();
        if(childCount>0){
            for (int i = 0; i < childCount; i++) {
                final View childAt = getChildAt(i);
                childAt.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                         TextView textView= (TextView) childAt;
                         flowCallBack.getName(textView.getText().toString());
                    }
                });
                 childAt.measure(0,0);

                int childWidth = childAt.getMeasuredWidth();
                int  childHeight = childAt.getMeasuredHeight();
                int widthPixels = getResources().getDisplayMetrics().widthPixels;
                right=left+childWidth;
                if(right>widthPixels){
                     left=0;
                     right=left+childWidth;
                     top=bottom+30;
                }
                bottom=childHeight+top;
                childAt.layout(left,top,right,bottom);
                left+=childWidth+30;
            }
        }
    }

    public void add(List<String> tags) {
         if(tags.size()>0&&tags!=null){
             for (int i = 0; i < tags.size(); i++) {
                 TextView textView = new TextView(App.getContext());
                 textView.setText(tags.get(i));
                 textView.setPadding(10,10,10,10);
                 textView.setTextColor(Color.BLACK);
                 textView.setBackgroundResource(R.drawable.flow);
                 addView(textView);
             }
         }
    }

    public void addShopView(String s) {
        TextView textView = new TextView(App.getContext());
          textView.setText(s);
        textView.setPadding(10,10,10,10);
        textView.setTextColor(Color.BLACK);
        textView.setBackgroundResource(R.drawable.flow);
        addView(textView);
    }
    public  FlowCallBack flowCallBack;

    public void setFlowCallBack(FlowCallBack flowCallBack) {
        this.flowCallBack = flowCallBack;
    }

    public interface FlowCallBack{
        void getName(String s);
    }
}
