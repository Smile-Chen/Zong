package co.example.hp.ykmn1.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by hp on 2018/6/28.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
              protected P prenter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
         prenter=getPresenter();
         initView();
         initLisenter();
         initData();

    }

    protected abstract void initData();
    protected abstract void initLisenter();
    protected abstract void initView();
    protected abstract P getPresenter();
    protected abstract int getLayoutId();


}
