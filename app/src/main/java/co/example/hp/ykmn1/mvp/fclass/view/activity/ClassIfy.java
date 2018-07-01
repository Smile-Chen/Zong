package co.example.hp.ykmn1.mvp.fclass.view.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.List;

import co.example.hp.ykmn1.R;
import co.example.hp.ykmn1.base.BaseActivity;
import co.example.hp.ykmn1.base.BasePresenter;
import co.example.hp.ykmn1.http.HttpConfig;
import co.example.hp.ykmn1.http.OkhtttpUtils;
import co.example.hp.ykmn1.mvp.fclass.model.LeftBean;
import co.example.hp.ykmn1.mvp.fclass.view.adapter.LeftAdapter;

/**
 * Created by hp on 2018/6/28.
 */

public class ClassIfy extends BaseActivity{


    private ListView classifyListView;

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.btn04_classify;
    }
    @Override
    protected void initData() {
    }
    @Override
    protected void initLisenter() {
    }
    @Override
    protected void initView() {

        classifyListView = findViewById(R.id.classify_listview);

        //创建fragment管理器
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        RightFragment rightFragment = new RightFragment();
        transaction.replace(R.id.classify_fram,rightFragment);

        Bundle bundle = new Bundle();
        bundle.putInt("cid",1);
         rightFragment.setArguments(bundle);
        transaction.commit();

         //网络获取数据
        String url = HttpConfig.classify_prent_url;
        OkhtttpUtils.getInstance().get(url, new OkhtttpUtils.OkCallback() {
            @Override
            public void onError(Exception e) {
            }

            @Override
            public void onSuccess(String json) {
                Gson gson = new Gson();
                LeftBean leftBean = gson.fromJson(json, LeftBean.class);
                final List<LeftBean.DataBean> data = leftBean.getData();
                LeftAdapter leftAdapter = new LeftAdapter(data,ClassIfy.this);
                classifyListView.setAdapter(leftAdapter);

                classifyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        int cid = data.get(position).getCid();
                        //创建fragment管理器

                        FragmentManager supportFragmentManager = getSupportFragmentManager();
                        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
                        RightFragment rightFragment = new RightFragment();
                        transaction.replace(R.id.classify_fram,rightFragment);

                        Bundle bundle = new Bundle();
                        bundle.putInt("cid",cid);
                        rightFragment.setArguments(bundle);
                        transaction.commit();


                    }
                });

            }
        });




    }

}
