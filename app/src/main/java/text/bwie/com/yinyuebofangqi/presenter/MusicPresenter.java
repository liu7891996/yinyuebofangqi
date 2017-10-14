package text.bwie.com.yinyuebofangqi.presenter;

import android.media.MediaPlayer;

import java.io.IOException;

import text.bwie.com.yinyuebofangqi.modle.MusicModler;
import text.bwie.com.yinyuebofangqi.view.app.Danli;
import text.bwie.com.yinyuebofangqi.view.bean.BofangMusicBean;
import text.bwie.com.yinyuebofangqi.view.fragment.MusicPictureFragment;
import text.bwie.com.yinyuebofangqi.view.interfaces.AdapterOne;
import text.bwie.com.yinyuebofangqi.view.interfaces.AdapterTwo;

/**
 * 类描述：音乐播放的p层
 * 姓名 ：刘希鑫
 */

public class MusicPresenter implements AdapterTwo<BofangMusicBean> {

    private AdapterOne re;



   private  static MediaPlayer  mediaPlayer;
   private static BofangMusicBean bean;
    private MusicModler musicModler;



  int a=0;
    private MusicPictureFragment pictureFragment;

    public void getId(AdapterOne adapterOne){
        this.re=adapterOne;


    }
    public void getHttp(String songid,Class clazz){
        musicModler = new MusicModler();
        mediaPlayer=Danli.getInstance();
        musicModler.getId(this);
        musicModler.get(songid,clazz);
 }


    //返回成功数据
    @Override
    public void prosperity(BofangMusicBean bofangMusicBean2) {

        //得到音乐的接口
         bean=bofangMusicBean2;
        BofangMusicBean.BitrateBean bitrate = bean.getBitrate();
        String file_link = bitrate.getFile_link();

        music2(file_link);
    }

    //音乐播放
    public void music2(String url){
        pictureFragment = new MusicPictureFragment();
        try {

//判断音乐播放状态
if (mediaPlayer.isPlaying()){

    mediaPlayer.stop();
    mediaPlayer.reset();
    mediaPlayer.setDataSource(url);
    mediaPlayer.prepare();
    mediaPlayer.start();



}else{
    mediaPlayer.setDataSource(url);
    mediaPlayer.prepare();
    mediaPlayer.start();

}
 } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //失败的返回
    @Override
    public void nothing(int i, String nothing) {

    }

//调取歌手信息
    public BofangMusicBean getMusicName(){
        return bean;
       }

}
