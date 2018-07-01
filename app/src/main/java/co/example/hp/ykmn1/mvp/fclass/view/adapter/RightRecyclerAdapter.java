package co.example.hp.ykmn1.mvp.fclass.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import co.example.hp.ykmn1.R;
import co.example.hp.ykmn1.app.MyApp;
import co.example.hp.ykmn1.mvp.fclass.model.RightBean;

/**
 * Created by hp on 2018/7/1.
 */

public class RightRecyclerAdapter extends RecyclerView.Adapter<RightRecyclerAdapter.RightRecyclerViewHolder>{
               public List<RightBean.DataBean.ListBean>listBeans;
                public Context context;

    public RightRecyclerAdapter(List<RightBean.DataBean.ListBean> listBeans, Context context) {
        this.listBeans = listBeans;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return listBeans.size()==0?0:listBeans.size();
    }
    @Override
    public RightRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.right__content, null);
        return new RightRecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RightRecyclerViewHolder holder, int position) {
        String icon = listBeans.get(position).getIcon();
        ImageLoader.getInstance().displayImage(icon,holder.rightImImage, MyApp.getOptions());
          holder.rightTvName.setText(listBeans.get(position).getName());
    }

    public class RightRecyclerViewHolder extends RecyclerView.ViewHolder {

        private final ImageView rightImImage;
        private final TextView rightTvName;

        public RightRecyclerViewHolder(View itemView) {
            super(itemView);
            rightImImage = itemView.findViewById(R.id.right_im_image);
            rightTvName = itemView.findViewById(R.id.right_tv_name);
        }
    }
}
