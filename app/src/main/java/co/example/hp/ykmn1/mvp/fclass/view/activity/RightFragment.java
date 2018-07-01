package co.example.hp.ykmn1.mvp.fclass.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.List;

import co.example.hp.ykmn1.R;
import co.example.hp.ykmn1.http.HttpConfig;
import co.example.hp.ykmn1.http.OkhtttpUtils;
import co.example.hp.ykmn1.mvp.fclass.model.RightBean;
import co.example.hp.ykmn1.mvp.fclass.view.adapter.RightAdapter;

/**
 * Created by hp on 2018/7/1.
 */

public class RightFragment extends Fragment{

    private RecyclerView btnRightRecyclerview;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.btn04_right_recycler, container, false);

        btnRightRecyclerview = view.findViewById(R.id.btn_right_recyclerview);

        Bundle arguments = getArguments();
        int cid = arguments.getInt("cid");
        String child_url = HttpConfig.classify_child_url;
        OkhtttpUtils.getInstance().get(child_url+"?cid="+cid, new OkhtttpUtils.OkCallback() {
            @Override
            public void onError(Exception e) {
            }

            @Override
            public void onSuccess(String json) {
                Gson gson = new Gson();
                RightBean rightBean = gson.fromJson(json, RightBean.class);
                List<RightBean.DataBean> data = rightBean.getData();
                RightAdapter rightAdapter = new RightAdapter(data, getContext());
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                btnRightRecyclerview.setLayoutManager(linearLayoutManager);
                 btnRightRecyclerview.setAdapter(rightAdapter);
            }
        });

        return view;
    }



}
