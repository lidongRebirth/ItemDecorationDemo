package com.myfittinglife.itemdecorationdemo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;


/**
 * @Author LD
 * @Time 2019/3/9 12:23
 * @Describe 分割线（增加功能：颜色变化、高度变化、左右偏移）  注意将RecyclerView的背景设置为白色
 * @Modify
 */
public class MyDecoration extends RecyclerView.ItemDecoration {

    private float mDividerHeight = 1; //线的高度
    private Paint mPaint;           //画笔将自己弄出来偏移量的分割线画出颜色
    private float margin = 0;       //左右偏移量

    public MyDecoration() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);          //抗锯齿
        mPaint.setColor(Color.GRAY);        //默认颜色
    }

    //通过建造者模式来设置三个属性
    //设置左右偏移(默认是设置的一样的，若需要自己更改)
    public MyDecoration setMargin(float margin) {
        this.margin = margin;
        return this;
    }

    //设置颜色
    public MyDecoration setColor(int color) {
        mPaint.setColor(color);
        return this;
    }

    //设置分割线高度
    public MyDecoration setDividerHeight(float height) {
        this.mDividerHeight = height;
        return this;
    }

    //在这里就已经把宽度的偏移给做好了
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);


        //第一个ItemView不需要在上面绘制分割线
        if (parent.getChildAdapterPosition(view) != 0) {
            //这里直接硬编码为1px（默认属性为1）
            outRect.top = (int) mDividerHeight;//指相对itemView顶部的偏移量
        }
    }

    //这里主要是绘制颜色的
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);

        int childCount = parent.getChildCount();
        //因为getItemOffsets是针对每一个ItemView，而onDraw方法是针对RecyclerView本身，所以需要循环遍历来设置
        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            int index = parent.getChildAdapterPosition(view);
            //第一个ItemView不需要绘制
            if (index == 0) {
                continue;//跳过本次循环体中尚未执行的语句，立即进行下一次的循环条件判断
            }
            float dividerTop = view.getTop() - mDividerHeight;                                          //？？？为啥是减：因为坐标是下为正右为正，所以它的上边就得减
            float dividerLeft = parent.getPaddingLeft() + margin;                                     //加入偏移量
            float dividerBottom = view.getTop();
            float dividerRight = parent.getWidth() - parent.getPaddingRight() - margin;               //加入偏移量
            c.drawRect(dividerLeft, dividerTop, dividerRight, dividerBottom, mPaint);
        }
    }
}
