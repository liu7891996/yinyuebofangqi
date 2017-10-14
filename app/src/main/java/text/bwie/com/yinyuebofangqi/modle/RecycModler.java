package text.bwie.com.yinyuebofangqi.modle;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import text.bwie.com.yinyuebofangqi.modle.url.Url;
import text.bwie.com.yinyuebofangqi.view.bean.Bean;
import text.bwie.com.yinyuebofangqi.view.interfaces.RecycInterfaceTwo;

/**
 * 类描述：
 * 姓名 ：刘希鑫
 */

public class RecycModler {
    private RecycInterfaceTwo re;
    private Gson gson;

    private String[] type=new String[]{"1","2","11","12","16","21","22","23","24","25"};
Handler handler=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        List<Bean> o= (List<Bean>) msg.obj;
            re.prosperity(o);
    }
};

    public void getid(RecycInterfaceTwo rec){
        this.re=rec;
        gson = new Gson();
    }
//post请求
//    public void posturl(final Context context, String url, Map<String,String> map, final Class clazz){
//    if (TextUtils.isEmpty(url)){
//        throw new RuntimeException("url is null!!!");
//    }
//        PostFormBuilder postFormBuilder= OkHttpUtils.post().url(url);
//        //拼接参数
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            postFormBuilder.addParams(entry.getKey(), entry.getValue());
//        }
//        postFormBuilder.build().execute(new StringCallback() {
//            @Override
//            public void onError(Request request, Exception e) {
//                showErrorInfo(context);
//                re.nothing(-1,"无数据");
//            }
//
//            @Override
//            public void onResponse(String response) {
//                dealWithResponse( response, clazz);
//            }
//        });
//
//
//
//
//
//    }

    //get请求,返回集合
    public void getlisturl(  final Class clazz){
        final List<Bean> arr=new ArrayList<>();
       for (int a=0;a<type.length;a++){
           final  int index=a;
           final String url= Url.URL+Url.RTF_JSON+Url.TERM+Url.TYPE+type[a]+Url.SIZE+10+Url.OFFSET+0+"&qq-pf-to=pcqq.temporaryc2c";
           Log.e("url===============",url);

//       if (TextUtils.isEmpty(url)){
//           throw new RuntimeException("url is null!!!");
//       }
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
             String str= response.body().string();
                Object o = gson.fromJson(str, clazz);

arr.add((Bean) o);

                if (index==type.length-1) {
                    Message message = handler.obtainMessage();
                    message.obj = arr;
                    handler.sendMessage(message);
                }
            }
        });

       }


    }


 //请求数据解析json串
    private void dealWithResponse(String response,Class clazz){
       if (!TextUtils.isEmpty(response)){
           Object o = gson.fromJson(response, clazz);
          Log.e("------","正常3");
            re.prosperity(o);
       }
    }


    //网络判断
    private void showErrorInfo(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("请求数据有误，请稍后再试！");
        builder.setPositiveButton("确定", null);
        builder.setNegativeButton("取消", null);
        builder.show();
    }

}
