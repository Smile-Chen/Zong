package co.example.hp.ykmn1.base;

/**
 * Created by hp on 2018/6/28.
 */

public abstract class BasePresenter<V extends BaseIView> {
    protected V view;

    public BasePresenter(V view) {
        this.view = view;
        onModel();
    }

    protected abstract void onModel();




}
