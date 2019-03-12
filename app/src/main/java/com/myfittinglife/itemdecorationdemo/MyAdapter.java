package com.myfittinglife.itemdecorationdemo;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @Author      LD
 * @Time        2019/3/11 16:32
 * @Describe    RecyclerView适配器
 * @Modify
 */
public class MyAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public MyAdapter(int layoutResId, List<String> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, String item) {
//        helper.setText(R.id.tv_content, item);
    }
}
