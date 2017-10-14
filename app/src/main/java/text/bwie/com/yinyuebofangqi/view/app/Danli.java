package text.bwie.com.yinyuebofangqi.view.app;

import android.media.MediaPlayer;

/**
 * 类描述：
 * 姓名 ：刘希鑫
 */

public class Danli {


    private static MediaPlayer mediaPlayer;
    public static MediaPlayer getInstance() {
        if(mediaPlayer == null) {
            synchronized (MediaPlayer.class) {
                if(mediaPlayer == null) {
                    mediaPlayer = new MediaPlayer();
                }
            }
        }
        return mediaPlayer;
    }
}
