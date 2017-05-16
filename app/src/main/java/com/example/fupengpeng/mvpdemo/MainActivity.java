package com.example.fupengpeng.mvpdemo;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView{

    @BindView(R.id.main_lv)
    ListView mainLv;
    @BindView(R.id.main_prb)
    ProgressBar mainPrb;

    private List<String> mData;
    private ArrayAdapter<String> adapter;


    //daima xiugai 
    /**
     * 视图与业务
     * <p>
     * 视图（可见即为视图）
     * progressbar 加载动画
     * listview 展示数据
     * butten 点击加载
     * <p>
     * 视图操作(也属于视图)
     * progressbar 显示
     * progressbar 隐藏
     * setData 设置数据（改变listview）
     * <p>
     * 业务：
     * 获取到数据并且通知视图改变
     */
    /*
    业务方面
        点击加载数据
            此处依然传mainActivity，但是此时MainAcitivity是作为借口MainView的实现类而存在的。
            当Activity生命周期结束后，仍然会以接口的实现类而存在
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mData = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mData);
        mainLv.setAdapter(adapter);
    }

//    //    progressbar 显示
//    public void showPrb(){
//        mainPrb.setVisibility(View.VISIBLE);
//        mainLv.setVisibility(View.GONE);
//    }
//    //    * progressbar 隐藏
//    public void hidePrb(){
//        mainPrb.setVisibility(View.GONE);
//        mainLv.setVisibility(View.VISIBLE);
//    }
//
//
//    //    * setData 设置数据（改变listview）
//    public void setData(List<String> datas){
//        adapter.addAll(datas);
//        adapter.notifyDataSetChanged();
//    }

    @OnClick(R.id.main_btn)
    public void onClick() {
        //业务方面
        //点击加载数据
        new MainPresenter(this).loadData();
    }

    @Override
    public void showPrb() {

    }

    @Override
    public void hidePrb() {

    }

    @Override
    public void setData(List<String> datas) {

    }
}