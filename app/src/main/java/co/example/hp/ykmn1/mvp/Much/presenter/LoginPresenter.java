package co.example.hp.ykmn1.mvp.Much.presenter;

import co.example.hp.ykmn1.base.BasePresenter;
import co.example.hp.ykmn1.mvp.Much.model.LoginBean;
import co.example.hp.ykmn1.mvp.Much.model.LoginModel;
import co.example.hp.ykmn1.mvp.Much.view.iview.IView;

/**
 * Created by hp on 2018/6/22.
 */

public class LoginPresenter extends BasePresenter<IView> {
        protected LoginModel loginModel;

    public LoginPresenter(IView view) {
        super(view);
    }

    @Override
    protected void onModel() {
       loginModel=new LoginModel();
    }
    public void logins(){
        loginModel.logins(new LoginModel.InClient() {
            @Override
            public void getSuccess(LoginBean loginBean) {
                if (view!=null){
                    view.getDataSuccess(loginBean);
                }
            }

            @Override
            public void getError(String error) {
                if (view!=null){
                    view.getDataError(error);
                }
            }
        });


    }



}
