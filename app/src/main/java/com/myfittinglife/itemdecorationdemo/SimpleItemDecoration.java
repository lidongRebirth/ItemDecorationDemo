package com.myfittinglife.itemdecorationdemo;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @Author      LD
 * @Time        2019/3/11 16:44
 * @Describe    简易版的分割线（只是一条线，不涉及颜色宽度等）
 * @Modify
 */
public class SimpleItemDecoration extends RecyclerView.ItemDecoration {
    /**
     * @param outRect   用于规定分割线的范围
     * @param view      指RecyclerView中的Item
     * @param parent    指RecyclerView本身
     * @param state     状态
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        if (parent.getChildAdapterPosition(view) != 0) {
            //直接设置为1px
            outRect.top = 2;
        }
    }
}
