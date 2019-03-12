package com.myfittinglife.itemdecorationdemo;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
*  @Author      LD
*  @Time        2019.3.11
*  @Describe    主页面
*  @Modify
*/
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    private List<String> dataList;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();

//        myAdapter = new MyAdapter(R.layout.item_recyclerview,dataList);       //简单布局
        myAdapter = new MyAdapter(R.layout.item_recyclerview2,dataList);         //复杂布局

        recyclerview.setAdapter(myAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
//        recyclerview.addItemDecoration(new SimpleItemDecoration());       //简易版本的

        //自定义的分割线
        MyDecoration myDecoration = new MyDecoration();
        myDecoration.setColor(ContextCompat.getColor(this,R.color.gray)).setMargin(ConvertUtils.dp2px(this, 15)).setDividerHeight(ConvertUtils.dp2px(this,3));
        recyclerview.addItemDecoration(myDecoration);

    }
    private void initData(){
        dataList = new ArrayList<>();
        for(int i = 0;i<20;i++){
            dataList.add("子项"+i);
        }
    }
}
