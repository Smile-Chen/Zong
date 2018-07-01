package co.example.hp.ykmn1.mvp.Much.view.activity;

import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


import co.example.hp.ykmn1.base.BaseActivity;
import co.example.hp.ykmn1.mvp.Much.model.LoginBean;
import co.example.hp.ykmn1.mvp.Much.presenter.LoginPresenter;
import co.example.hp.ykmn1.mvp.Much.view.adapter.LoginAdapter;
import co.example.hp.ykmn1.mvp.Much.view.iview.IView;

/**
 * Created by hp on 2018/6/28.
 */

public class RecyclerMuch extends BaseActivity<LoginPresenter>implements IView{

    private RecyclerView recycler;
    private LoginAdapter loginAdapter;
    private List<LoginBean.DataBeanX.DataBean>list=new ArrayList<>();

    @Override
    protected LoginPresenter getPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.btn01_recycler;
    }
    @Override
    protected void initData() {
        prenter.logins();
    }

    @Override
    protected void initLisenter() {

    }

    @Override
    protected void initView() {
        recycler = findViewById(R.id.recycler_view);
    }


    @Override
    public void getDataSuccess(LoginBean loginBean) {
        List<LoginBean.DataBeanX.DataBean> data = loginBean.getData().getData();
        list.addAll(data);
        final LoginAdapter loginAdapter = new LoginAdapter(list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RecyclerMuch.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(linearLayoutManager);
        recycler.setAdapter(loginAdapter);
        loginAdapter.setOnItemClickListener(new LoginAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, final int position) {
                ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "rotation", 720);
                alpha.setDuration(8000);
                alpha.start();


                AlertDialog.Builder builder = new AlertDialog.Builder(RecyclerMuch.this);
                builder.setTitle("删除");
                builder.setMessage("确定删除吗?");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        list.remove(position);
                        loginAdapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("取消",null);
                builder.show();
            }
        });
    }

    @Override
    public void getDataError(String error) {

    }
    @Override
    public Context context() {
        return context();
    }


}