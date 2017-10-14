package text.bwie.com.yinyuebofangqi.view.activity;

import android.content.Intent;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import text.bwie.com.yinyuebofangqi.R;
import text.bwie.com.yinyuebofangqi.presenter.SingerPresenter;
import text.bwie.com.yinyuebofangqi.view.bean.SingerBeab;
import text.bwie.com.yinyuebofangqi.view.interfaces.RecycInterface;

import static text.bwie.com.yinyuebofangqi.R.id.singer_name;

/**
 * 类描述：歌手信息详情
 * 姓名 ：刘希鑫
 */

public class SingerInformation extends MvpActivity implements RecycInterface<SingerBeab>{
    /**
     * adad
     */
    private TextView mSingerName;
    private ImageView mSingerImage;
    /**
     * 姓名 :
     */
    private TextView mSingerName2;
    /**
     * 内容
     */
    private TextView mSingerXiangqing;
    /**
     * 查看更多信息
     */
    private TextView mSingerChakangengduo;
    private ImageView singer_fanhui;

    /**
     * http://tingapi.ting.baidu.com/v1/restserver/ting?format=json&calback=&from=webapp_music&method=baidu.ting.artist.getSongList&tinguid=90654808&limits=6&use_cluster=1&order=2
     */

    @Override
    protected void laoutData() {
        Intent intent=getIntent();
        String type = intent.getStringExtra("type");

        SingerPresenter http=new SingerPresenter();
        http.getId(this);
        http.getDataHttp(type);
       //返回的点击事件
        fanhui();

    }
//返回的点击事件
    private void fanhui() {
        singer_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    void initData() {
        mSingerName = (TextView) findViewById(singer_name);
        mSingerImage = (ImageView) findViewById(R.id.singer_image);
        mSingerName2 = (TextView) findViewById(R.id.singer_name2);
        mSingerXiangqing = (TextView) findViewById(R.id.singer_xiangqing);
        mSingerChakangengduo = (TextView) findViewById(R.id.singer_chakangengduo);
        singer_fanhui = (ImageView) findViewById(R.id.singer_fanhui);
    }

    @Override
    int setSelfViewId() {
        return R.layout.activity_singer;
    }


    @Override
    public void prosperity(SingerBeab SingerBeab) {
        mSingerName.setText(SingerBeab.getName());
        mSingerName2.setText("姓名 : "+SingerBeab.getName());
        mSingerXiangqing.setText(SingerBeab.getIntro());
        Glide.with(SingerInformation.this).load(SingerBeab.getAvatar_s500()).into(mSingerImage);
        SpannableString sp = new SpannableString(mSingerChakangengduo.getText().toString());
        sp.setSpan(new URLSpan(SingerBeab.getUrl()),0,6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mSingerChakangengduo.setText(sp);
        mSingerChakangengduo.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public void nothing(int i, String nothing) {

    }
}
