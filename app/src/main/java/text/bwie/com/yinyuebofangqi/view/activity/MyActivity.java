package text.bwie.com.yinyuebofangqi.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;
import java.util.List;

import text.bwie.com.yinyuebofangqi.R;
import text.bwie.com.yinyuebofangqi.presenter.MusicPresenter;
import text.bwie.com.yinyuebofangqi.view.app.Player;
import text.bwie.com.yinyuebofangqi.view.app.Danli;
import text.bwie.com.yinyuebofangqi.view.bean.BofangMusicBean;
import text.bwie.com.yinyuebofangqi.view.fragment.MediaWrap;
import text.bwie.com.yinyuebofangqi.view.fragment.MyMusicFragment;

/**
 * 类描述：主界面，包括侧拉菜单，我的歌曲和在线歌曲
 * 姓名 ：刘希鑫
 */

public class MyActivity extends MvpActivity {
   List<Fragment> arr=new ArrayList<>();
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageView window;
    private SlidingMenu leftmenu;
    private ImageView electronicConversion;
    private LinearLayout my_particular;

    //my_activity_bofang:播放图片
    private CheckBox my_activity_bofang;
   //my_activity_geshou：歌手名字
    private TextView my_activity_geshou;
    //my_activity_image 歌曲图片
    private ImageView my_activity_image;
    //歌曲名字
    private TextView my_activity_name;
    //下一首
    private ImageView my_activity_xiayishou;
    //进度条
    private SeekBar skbProgress;
    private MediaPlayer mediaPlayer;
    private MusicPresenter musicPlayer;
    private BofangMusicBean musicName;
    private ImageView sousuo;
    private Player player;

    @Override
    protected void laoutData() {

    layoutviewpager();
        //侧拉菜单
        initce();
       //菜单点击事件
        windowClick();


    //歌曲详情界面弹出
        musicParticular();
        //点击暂停、开始
        startStop();
//搜索音乐
        souMusic();
    }

    //搜索音乐
    private void souMusic() {
       sousuo.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
             Intent intent=new Intent(MyActivity.this,SearchActivity.class);
               startActivity(intent);
           }
       });
    }

    //点击暂停、开始
    private void startStop() {
        my_activity_bofang.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){

                    //音乐开始
                    mediaPlayer.start();
                    Toast.makeText(MyActivity.this,"状态"+b,Toast.LENGTH_LONG).show();
                }else{
                    //音乐暂停
                    mediaPlayer.pause();
                    Toast.makeText(MyActivity.this,"状态"+b,Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    //歌曲详情界面弹出
    private void musicParticular() {
        my_particular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MyActivity.this,MusicParticular.class);
                startActivity(intent);
            }
        });
    }

    //侧拉菜单
    private void initce() {
        leftmenu = new SlidingMenu(this);
        View left=View.inflate(this,R.layout.left,null);
        leftmenu.setMenu(left);
        //查找侧拉中控件的id
           celaID(left);
        //侧拉中控件的点击事件
           celaOnclick();
       leftmenu.setBehindOffsetRes(R.dimen.slidingmenu_offets);
       //设置渐入渐出的值
        leftmenu.setFadeDegree(0.35f);
        //设置触摸屏的模式
        leftmenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        leftmenu.attachToActivity(this,SlidingMenu.SLIDING_CONTENT);
    }
   //侧拉菜单中的点击事件
    private void celaOnclick() {
        //日夜切换
        electronicConversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sha=getSharedPreferences("name",MODE_PRIVATE);
                boolean  isNight=sha.getBoolean("night",false);
                if (isNight){
                    //白天模式
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    sha.edit().putBoolean("night",false).commit();

                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    sha.edit().putBoolean("night",true).commit();

                }
                recreate();//最后的这个绝对不能忘，不然切换回失效的
            }
        });
    }
    //找到侧拉菜单中控件的id
    private void celaID(View left) {
        //日夜间切换
        electronicConversion = left.findViewById(R.id.ElectronicConversion);

    }

    //侧拉菜单弹出点击事件
    private void windowClick() {
     window.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
if (!leftmenu.isMenuShowing()){
    leftmenu.showMenu();
}
         }
     });
    }

    //viewpager加tablayout联动实现标题
    private void layoutviewpager() {
        tabLayout.addTab(tabLayout.newTab().setText("我的音乐"));
        tabLayout.addTab(tabLayout.newTab().setText("在线音乐"));
        final List<String> list=new ArrayList<>();
        list.add("我的音乐");
        list.add("在线音乐");
        arr.add(new MyMusicFragment());
        arr.add(new MediaWrap());
        //上下关联
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return arr.get(position);
            }

            @Override
            public int getCount() {
                return arr.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }
        });
    }

    //找到控件id
    @Override
    void initData() {

        mediaPlayer = Danli.getInstance();
        sousuo = (ImageView) findViewById(R.id.sousuo);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        window = (ImageView) findViewById(R.id.window);
        my_activity_bofang = (CheckBox) findViewById(R.id.my_activity_bofang);
        my_activity_geshou = (TextView) findViewById(R.id.my_activity_geshou);
        my_activity_image = (ImageView) findViewById(R.id.my_activity_image);
        my_activity_name = (TextView)findViewById(R.id.my_activity_name);
        my_activity_xiayishou = (ImageView)findViewById(R.id.my_activity_xiayishou);
        skbProgress = (SeekBar) findViewById(R.id.skbProgress);
        skbProgress.setOnSeekBarChangeListener(new SeekBarChangeEvent());
        player = new Player(skbProgress);
        //展开歌曲详情界面
        my_particular = (LinearLayout) findViewById(R.id.my_particular);
    }

    //传入布局
    @Override
    int setSelfViewId() {
        return R.layout.activity_my;
    }


    //重新唤醒activity，判断音乐播放状态，改变checkbox的状态
    @Override
    protected void onStart() {
        super.onStart();
        //viewpager加tablayout联动实现标题
        if (mediaPlayer.isPlaying()){
            my_activity_bofang.setChecked(true);
            musicPlayer = new MusicPresenter();
            musicName = musicPlayer.getMusicName();
            BofangMusicBean.SonginfoBean songinfo = musicName.getSonginfo();
            Glide.with(MyActivity.this).load(songinfo.getPic_small()).into(my_activity_image);
            my_activity_name.setText(songinfo.getTitle());
            my_activity_geshou.setText(songinfo.getAuthor());
        }else{
            my_activity_bofang.setChecked(false);
        }
    }
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

}
