package co.example.hp.ykmn1.http;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by mumu on 2018/6/14.
 */

public class OkhtttpUtils {
    private static final String TAG = "OkhtttpUtils";
    private static OkhtttpUtils mOkhtttpUtils;
    private OkHttpClient mOkHttpClien;
    private final Handler mHandler;

    private OkhtttpUtils() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //创建一个主线程的handler
        mHandler = new Handler(Looper.getMainLooper());
        mOkHttpClien = new OkHttpClient.Builder()
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .writeTimeout(5000, TimeUnit.MILLISECONDS)
                 .addInterceptor(httpLoggingInterceptor)
                .build();
    }


    public static OkhtttpUtils getInstance() {
        if (mOkhtttpUtils == null) {
            synchronized (OkhtttpUtils.class) {
                if (mOkhtttpUtils == null) {
                    return mOkhtttpUtils = new OkhtttpUtils();
                }
            }
        }
        return mOkhtttpUtils;
    }

    public void get(String url, final OkCallback okCallback) {
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();

        final Call call = mOkHttpClien.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                if (okCallback != null) {

                    //切换到主线程
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            okCallback.onError(e);
                        }
                    });

                }
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {

                try {
                    if (response != null && response.isSuccessful()) {
                        final String json = response.body().string();
                        Log.d(TAG, "onResponse: " + json);
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (okCallback != null) {
                                    okCallback.onSuccess(json);
                                    return;
                                }

                            }
                        });
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d(TAG, "onResponse: " + e.getMessage());
                    if (okCallback != null) {
                        okCallback.onError(new Exception("网络异常"));
                    }
                }

            }
        });
    }

    public void post(String url, Map<String, String> map, final OkCallback okCallback) {

        FormBody.Builder builder = new FormBody.Builder();
        if (map != null) {
            for (String key : map.keySet()) {
                builder.add(key, map.get(key));
            }
        }
        FormBody formBody = builder.build();
        Request request = new Request.Builder()
                .post(formBody)
                .url(url)
                .build();
        final Call call = mOkHttpClien.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                if (okCallback != null) {

                    //切换到主线程
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            okCallback.onError(e);
                        }
                    });

                }
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {

                try {
                    if (response != null && response.isSuccessful()) {
                        final String json = response.body().string();
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (okCallback != null) {
                                    okCallback.onSuccess(json);
                                    return;
                                }
                            }
                        });
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (okCallback != null) {
                    okCallback.onError(new Exception("网络异常"));
                }

            }
        });
    }

    public interface OkCallback {
        void onError(Exception e);
        void onSuccess(String json);
    }


}


