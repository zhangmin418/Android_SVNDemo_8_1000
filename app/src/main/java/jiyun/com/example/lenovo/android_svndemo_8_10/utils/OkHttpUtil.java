package jiyun.com.example.lenovo.android_svndemo_8_10.utils;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by lenovo on 2017/8/11.
 */

public class OkHttpUtil {
    private static OkHttpUtil util;
        private OkHttpClient client;
        private OkHttpUtil(){
            client = new OkHttpClient.Builder().build();
        }
        public static OkHttpUtil getInstance(){
            if (util == null){
                synchronized (OkHttpUtil.class){
                    if (util == null)
                        util = new OkHttpUtil();
                }
            }
            return util;
        }
        public Call loadData_Get(String url, Callback callback){
            Request request = new Request.Builder().url(url).build();
            Call call = client.newCall(request);
            call.enqueue(callback);
            return call;
        }

        public Call loadData_Post(String url, RequestBody body, Callback callback){
            Request request = new Request.Builder().post(body).url(url).build();
            Call call = client.newCall(request);
            call.enqueue(callback);
            return call;
        }
}
