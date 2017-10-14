package text.bwie.com.yinyuebofangqi.modle;

import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import text.bwie.com.yinyuebofangqi.modle.url.Url;
import text.bwie.com.yinyuebofangqi.view.interfaces.SearchInterfaceTwo;

/**
 * 类描述：
 * 姓名 ：刘希鑫
 */

public class SearchModle  {
       private SearchInterfaceTwo se;
       private Gson gson;
       public void getUrlId(SearchInterfaceTwo two){
           this.se=two;
           gson=new Gson();
       }

       Handler handler=new Handler(){
           @Override
           public void handleMessage(Message msg) {
               super.handleMessage(msg);
              Object o=msg.obj;
               se.prosperity(o);


           }
       };
       public void postUrlHttp(String name, final Class clazz){
           final String url= Url.URL+Url.RTF_JSON+Url.SEARCH+name;
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
                   Message msg=handler.obtainMessage();
                   msg.obj=o;
                   handler.sendMessage(msg);
               }
           });



       }

}
