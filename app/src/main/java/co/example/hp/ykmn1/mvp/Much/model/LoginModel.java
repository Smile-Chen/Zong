package co.example.hp.ykmn1.mvp.Much.model;

import com.google.gson.Gson;

import co.example.hp.ykmn1.http.OkhtttpUtils;

/**
 * Created by hp on 2018/6/22.
 */

public class LoginModel {
    private static final String TAG = "LoginModel";
    public void logins(final InClient inClient){
        String url="http://365jia.cn/news/api3/365jia/news/headline?page=1";
        OkhtttpUtils.getInstance().get(url, new OkhtttpUtils.OkCallback() {
            @Override
            public void onError(Exception e) {
            }

            @Override
            public void onSuccess(String json) {
                LoginBean loginBean = new Gson().fromJson(json, LoginBean.class);
                int code = loginBean.getCode();
                if (code==0){
                    if (inClient!=null){
                        inClient.getSuccess(loginBean);
                    }
                }else {
                    if (inClient!=null){
                        inClient.getError("失败");
                    }
                }

            }
        });

    }

    public interface InClient{
        void getSuccess(LoginBean loginBean);
        void getError(String error);
    }

}
