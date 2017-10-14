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
import text.bwie.com.yinyuebofangqi.view.bean.BofangMusicBean;
import text.bwie.com.yinyuebofangqi.view.interfaces.AdapterTwo;

/**
 * 类描述：音乐的网络请求解析
 * 姓名 ：刘希鑫
 */

public class MusicModler {
    AdapterTwo re;
    private Gson gson;

    public void getId(AdapterTwo recycInterfaceTwo){
        this.re=recycInterfaceTwo;


    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            BofangMusicBean obj = (BofangMusicBean) msg.obj;
            re.prosperity(obj);
        }
    };


     public void get(String song_id, final Class clazz){
         final String url= Url.URL+Url.RTF_JSON+Url.SONG_ID+song_id;
         Log.e("url----",url);
         gson = new Gson();

         OkHttpClient okHttpClient=new OkHttpClient.Builder().addInterceptor(new HttpInterceptor()).build();
         Request request=new Request.Builder()
                 .url(url)
                 .build();
         okHttpClient.newCall(request).enqueue(new Callback() {
             @Override
             public void onFailure(Call call, IOException e) {

             }

             @Override
             public void onResponse(Call call, Response response) throws IOException {
                 String string = response.body().string();

                 Object o = gson.fromJson(string, clazz);
                  Message message=handler.obtainMessage();
                 message.obj=o;
                 handler.sendMessage(message);


             }
         });


     }

}
