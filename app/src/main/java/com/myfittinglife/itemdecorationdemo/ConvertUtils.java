package com.myfittinglife.itemdecorationdemo;

import android.content.Context;

/**
 * @Author      LD
 * @Time        2019/2/15 12:06
 * @Describe    px和dp相互转化
 * @Modify
 */
public class ConvertUtils {
    /**
     * dp值转换成px值
     *
     * @param dpValue dp值
     * @return px值
     */
    public static int dp2px(Context context, final float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * px值转换成dp值
     *
     * @param pxValue px值
     * @return dp值
     */
    public static int px2dp(Context context, final float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * sp值转换成px值
     *
     * @param spValue sp值
     * @return px值
     */
    public static int sp2px(Context context, final float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * px值转换成sp值
     *
     * @param pxValue px值
     * @return sp值
     */
    public static int px2sp(Context context, final float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }
}
