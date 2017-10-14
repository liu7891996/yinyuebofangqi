package text.bwie.com.yinyuebofangqi.view.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.umeng.socialize.UMShareAPI;

import java.util.List;

import text.bwie.com.yinyuebofangqi.R;
import text.bwie.com.yinyuebofangqi.presenter.BeanPresenter;
import text.bwie.com.yinyuebofangqi.view.adapter.DetailsAdapter;
import text.bwie.com.yinyuebofangqi.view.bean.Bean;
import text.bwie.com.yinyuebofangqi.view.interfaces.RecycInterface;

/**
 * 类描述：歌曲列表
 * 姓名 ：刘希鑫
 */

public class DetailsActivity extends MvpActivity implements RecycInterface<Bean> {

    private ImageView fanhui;
    private ImageView image;
    private TextView bangdan;
    private TextView shijian;
    private TextView jieshao;
    private RecyclerView recyclerView;

    @Override
    protected void laoutData() {
        Intent intent=getIntent();
        String type = intent.getStringExtra("type");
        BeanPresenter http=new BeanPresenter();
        http.getcontext(this);
        http.diaoyong(type);
    }

    @Override
    void initData() {
        fanhui = (ImageView) findViewById(R.id.details_fanhui);
        image = (ImageView) findViewById(R.id.details_image);
        bangdan = (TextView) findViewById(R.id.details_bangdan);
        shijian = (TextView) findViewById(R.id.details_shijian);
        jieshao = (TextView) findViewById(R.id.details_jieshao);
        recyclerView = (RecyclerView) findViewById(R.id.details_recyc);


    }

    @Override
    int setSelfViewId() {
        return R.layout.activity_details;
    }

    @Override
    public void prosperity(Bean bean) {
        Bean.BillboardBean billboard = bean.getBillboard();
       bangdan.setText(billboard.getName());
        shijian.setText("更新时间："+billboard.getUpdate_date());
        Glide.with(DetailsActivity.this).load(billboard.getPic_s260()).into(image);
        jieshao.setText(billboard.getComment());
        List<Bean.SongListBean> song_list = bean.getSong_list();
        //适配器
        DetailsAdapter adapter=new DetailsAdapter(DetailsActivity.this,song_list);
      recyclerView.setLayoutManager(new LinearLayoutManager(DetailsActivity.this));
        recyclerView.setAdapter(adapter);
   fanhui.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           finish();
       }
   });

    }

    @Override
    public void nothing(int i, String nothing) {

    }
    //分享的QQ分享或者授权的Activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
        if(Build.VERSION.SDK_INT>=23){
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.CALL_PHONE,Manifest.permission.READ_LOGS,Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.SET_DEBUG_APP,Manifest.permission.SYSTEM_ALERT_WINDOW,Manifest.permission.GET_ACCOUNTS,Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this,mPermissionList,123);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
      String permissions[], int[] grantResults) {


    }
}
