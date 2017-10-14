package text.bwie.com.yinyuebofangqi.view.activity;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import text.bwie.com.yinyuebofangqi.R;
import text.bwie.com.yinyuebofangqi.presenter.MusicPresenter;
import text.bwie.com.yinyuebofangqi.view.app.Danli;
import text.bwie.com.yinyuebofangqi.view.app.Player;
import text.bwie.com.yinyuebofangqi.view.app.TimerFormatter;
import text.bwie.com.yinyuebofangqi.view.bean.BofangMusicBean;
import text.bwie.com.yinyuebofangqi.view.fragment.MusicLyricFragment;
import text.bwie.com.yinyuebofangqi.view.fragment.MusicPictureFragment;

/**
 * 类描述：歌曲详情界面
 * 姓名 ：刘希鑫
 */

public class MusicParticular extends MvpActivity implements View.OnClickListener {
    private ImageView mMusicFanhui;
    /**
     * 歌名
     */
    private TextView mMusicGeming;
    /**
     * 歌手
     */
    private RadioGroup radiogroup;
    private List<Fragment> list;
    private FragmentManager fm;
    private TextView mMusicGeshouname;
    private FrameLayout mMusicFramelayout;
    private RadioButton mMusicRadbutton1;
    private RadioButton mMusicRadbutton2;
    /**
     * 00:00
     */
    private TextView mMusicDangqianshijian;
    private SeekBar mMusicSeekbar;
    /**
     * 04:15
     */
    private TextView mMusicZongshijian;
    private ImageView mMusicShang;
    private CheckBox mMusicKaishi;
    private ImageView mMusicXia;
    private MediaPlayer mediaPlayer;
    private MusicPresenter presenter;
    private BofangMusicBean musicName;
    private Player player;
    private Timer timer=new Timer();
    private MusicPictureFragment pictureFragment;
    private MusicLyricFragment lyricFragment;


    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int progress= (int) msg.obj;

            mMusicDangqianshijian.setText(""+TimerFormatter.formatterTime(mediaPlayer.getCurrentPosition()));

            mMusicZongshijian.setText(""+ TimerFormatter.formatterTime(mediaPlayer.getDuration()));
        }
    };


    //oncreate
    @Override
    protected void laoutData() {



        //判断进入这个界面的时候，音乐是否是播放状态
       if (mediaPlayer!=null){
        if (mediaPlayer.isPlaying()){
            mMusicKaishi.setChecked(true);

        }else{
            mMusicKaishi.setChecked(false);

        }
       }
        //中间的切换歌词
        fragmentLyic();
        //开始的点击状态
        checkkaishi();
        //得到歌曲信息
        musicxiangqing();
        //对控件加入数据
        shuju();
//     得到播放时间
        shijian();
   //
     

    }
//中间的歌词和歌盘切换
    private void fragmentLyic() {
        list = new ArrayList<>();
        fm = getSupportFragmentManager();

        list.add(pictureFragment);
        list.add(lyricFragment);
            FragmentTransaction transaction=fm.beginTransaction();
    transaction.add(R.id.music_framelayout,list.get(0));
        transaction.add(R.id.music_framelayout,list.get(1));
        transaction.show(list.get(0)).hide(list.get(1));
        transaction.commit();
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
       RadioButton rb=(RadioButton) radioGroup.findViewById(i);
         int tag=Integer.parseInt(rb.getTag().toString());
             FragmentTransaction fragmentTransaction=fm.beginTransaction();
         for (int a=0;a<list.size();a++){
             if (tag==a){
                 fragmentTransaction.show(list.get(a));
             }else {
                 fragmentTransaction.hide(list.get(a));
             }
         }
         fragmentTransaction.commit();
            }
        });

    }

    //获得播放的时间
    private void shijian() {
        final int duration = mediaPlayer.getDuration();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
              //每次都需要去获取当前音乐的播放位置
                int currentp=mediaPlayer.getCurrentPosition();
                int progress = (currentp * 100)/ duration ; // 100 / 1000  //0.1% * 100

                //发送消息
                Message msg=handler.obtainMessage();
                msg.obj=progress;
                msg.what=1;
                handler.sendMessage(msg);

            }
        },0,1000);

}


    //对控件加入数据
    private void shuju() {
        if (musicName!=null){
        BofangMusicBean.SonginfoBean songinfo = musicName.getSonginfo();
        mMusicGeming.setText(songinfo.getAlbum_title());
        mMusicGeshouname.setText(songinfo.getAuthor());
    }}

    //得到歌曲信息
    private void musicxiangqing() {
        presenter = new MusicPresenter();

        musicName = presenter.getMusicName();

    }
   //开始暂停的点击事件
    private void checkkaishi() {

        mMusicKaishi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    mediaPlayer.start();
                    pictureFragment.donghua();
                }else{
                    mediaPlayer.pause();
                    pictureFragment.fandonghua();
                }
            }
        });
    }

    //找到控件id
    @Override
    void initData() {
        lyricFragment= new MusicLyricFragment();
        pictureFragment = new MusicPictureFragment();
        mediaPlayer = Danli.getInstance();
        mMusicFanhui = (ImageView) findViewById(R.id.music_fanhui);
        mMusicFanhui.setOnClickListener(this);
        radiogroup = (RadioGroup) findViewById(R.id.music_radiogroup);
        mMusicGeming = (TextView) findViewById(R.id.music_geming);
        mMusicGeshouname = (TextView) findViewById(R.id.music_geshouname);
        mMusicFramelayout = (FrameLayout) findViewById(R.id.music_framelayout);
        mMusicRadbutton1 = (RadioButton) findViewById(R.id.music_radbutton1);
        mMusicRadbutton2 = (RadioButton) findViewById(R.id.music_radbutton2);
        mMusicDangqianshijian = (TextView) findViewById(R.id.music_dangqianshijian);
        mMusicSeekbar = (SeekBar) findViewById(R.id.music_seekbar);
        mMusicZongshijian = (TextView) findViewById(R.id.music_zongshijian);
        mMusicShang = (ImageView) findViewById(R.id.music_shang);
        mMusicShang.setOnClickListener(this);
        mMusicKaishi = (CheckBox) findViewById(R.id.music_kaishi);
        mMusicSeekbar.setOnSeekBarChangeListener(new SeekBarChangeEvent());
        player = new Player(mMusicSeekbar);
        mMusicXia = (ImageView) findViewById(R.id.music_xia);
        mMusicXia.setOnClickListener(this);
    }
//传入布局
    @Override
    int setSelfViewId() {
        return R.layout.activity_music;

    }


    //点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.music_fanhui:
                finish();
                break;
            case R.id.music_shang:
                break;

            case R.id.music_xia:
                break;
        }
    }
//进度条的点击事件
    class SeekBarChangeEvent implements SeekBar.OnSeekBarChangeListener {
        int progress;

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {
            // 原本是(progress/seekBar.getMax())*player.mediaPlayer.getDuration()
            this.progress = progress * player.mediaPlayer.getDuration()
                    / seekBar.getMax();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // seekTo()的参数是相对与影片时间的数字，而不是与seekBar.getMax()相对的数字
            player.mediaPlayer.seekTo(progress);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        //判断进入这个界面的时候，音乐是否是播放状态
        if (mediaPlayer!=null){
            if (mediaPlayer.isPlaying()){
                mMusicKaishi.setChecked(true);

            }else{
                mMusicKaishi.setChecked(false);

            }
    }}
}
