package co.example.hp.ykmn1.mvp.fclass.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import co.example.hp.ykmn1.R;
import co.example.hp.ykmn1.mvp.fclass.model.LeftBean;

/**
 * Created by hp on 2018/7/1.
 */

public class LeftAdapter extends BaseAdapter{
    public List<LeftBean.DataBean>list;
    public Context context;

    public LeftAdapter(List<LeftBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         ViewHolder viewHolder;
        convertView = View.inflate(context, R.layout.btn04_left, null);
        viewHolder = new ViewHolder();
        viewHolder.textName = convertView.findViewById(R.id.classify_left_tv_name);
        viewHolder.textName.setText(list.get(position).getName());

        return convertView;

    }

     //创建ViewHolder
    class ViewHolder{
        TextView textName;
     }


}
