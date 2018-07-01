package co.example.hp.ykmn1.mvp.fclass.view.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import co.example.hp.ykmn1.R;
import co.example.hp.ykmn1.mvp.fclass.model.LeftBean;
import co.example.hp.ykmn1.mvp.fclass.model.RightBean;

/**
 * Created by hp on 2018/7/1.
 */

public class RightAdapter extends RecyclerView.Adapter<RightAdapter.RightViewHolder>{
     public List<RightBean.DataBean>list;
     public Context context;

    public RightAdapter(List<RightBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @Override
    public int getItemCount() {
        return list == null ?0 : list.size();
    }
    @Override
    public RightViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.btn04_right, null);
        return new RightViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RightViewHolder holder, int position) {
            holder.btnRightTvName.setText(list.get(position).getName());

        List<RightBean.DataBean.ListBean> listBeans = this.list.get(position).getList();
        RightRecyclerAdapter rightRecyclerAdapter = new RightRecyclerAdapter(listBeans,context);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 4);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
         holder.rightRecycler.setLayoutManager(gridLayoutManager);
         holder.rightRecycler.setAdapter(rightRecyclerAdapter);
    }
    public class RightViewHolder extends ViewHolder{

        private final TextView btnRightTvName;
        private final RecyclerView rightRecycler;

        public RightViewHolder(View itemView) {
            super(itemView);
            btnRightTvName = itemView.findViewById(R.id.btn_right_tv_name);
            rightRecycler = itemView.findViewById(R.id.right_recycler);
        }
    }



}
