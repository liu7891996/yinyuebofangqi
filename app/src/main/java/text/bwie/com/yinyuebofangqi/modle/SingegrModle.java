package text.bwie.com.yinyuebofangqi.modle;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import text.bwie.com.yinyuebofangqi.modle.url.Url;
import text.bwie.com.yinyuebofangqi.view.interfaces.RecycInterfaceTwo;

/**
 * 类描述：
 * 姓名 ：刘希鑫
 */

public class SingegrModle {
    private RecycInterfaceTwo two;
    Gson gson;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Object bean= msg.obj;
            two.prosperity(bean);
        }
    };
    public void getid(RecycInterfaceTwo re){
        this.two=re;
        gson=new Gson();
    }

    //get请求，得到类
    public void geturl(String type, final Class clazz){
        final String url= Url.URL+Url.RTF_JSON  +Url.TING_UID+type;
        Log.e("url===============",url);
        OkHttpClient okHttpClient=new OkHttpClient.Builder().addInterceptor(new HttpInterceptor()).build();
        final Request request=new Request.Builder()
                .url(url)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Object bean =  gson.fromJson(string, clazz);
                Message message=handler.obtainMessage();
                message.obj=bean;
                handler.sendMessage(message);
            }
        });

    }
}
