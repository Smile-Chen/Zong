package co.example.hp.ykmn1.mvp.Much.view.iview;


import co.example.hp.ykmn1.base.BaseIView;
import co.example.hp.ykmn1.mvp.Much.model.LoginBean;

/**
 * Created by hp on 2018/6/22.
 */

public interface IView extends BaseIView{
    void getDataSuccess(LoginBean loginBean);
    void getDataError(String error);

}
