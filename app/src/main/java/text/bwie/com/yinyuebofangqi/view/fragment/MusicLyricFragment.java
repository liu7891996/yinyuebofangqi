package text.bwie.com.yinyuebofangqi.view.fragment;

import android.media.MediaPlayer;
import android.view.View;

import text.bwie.com.yinyuebofangqi.R;
import text.bwie.com.yinyuebofangqi.presenter.LyricPresenter;
import text.bwie.com.yinyuebofangqi.presenter.MusicPresenter;
import text.bwie.com.yinyuebofangqi.view.app.Danli;
import text.bwie.com.yinyuebofangqi.view.app.LyricView;
import text.bwie.com.yinyuebofangqi.view.bean.BofangMusicBean;
import text.bwie.com.yinyuebofangqi.view.bean.LyricBean;
import text.bwie.com.yinyuebofangqi.view.interfaces.SearchInterface;

/**
 * 类描述：
 * 姓名 ：刘希鑫
 */

public class MusicLyricFragment extends MyFragment implements SearchInterface<LyricBean>{

    private LyricPresenter presenter;
    private MusicPresenter musicPresenter;
    private BofangMusicBean musicName;
    private LyricView lyricView;
    private MediaPlayer mediaPlayer;

    @Override
    protected void initExecute() {
        musicPresenter = new MusicPresenter();
        musicName = musicPresenter.getMusicName();
        BofangMusicBean.SonginfoBean songinfo = musicName.getSonginfo();
        String song_id = songinfo.getSong_id();
        presenter = new LyricPresenter();
        presenter.getID(this);
        presenter.gethttp(song_id,LyricBean.class);
    }

    @Override
    protected void initID(View view) {
        lyricView = view.findViewById(R.id.lyricview);
        mediaPlayer = Danli.getInstance();
    }

    @Override
    protected View initView() {
        View view=View.inflate(getActivity(), R.layout.fragment_two,null);
        return view;
    }

    @Override
    public void prosperity(LyricBean lyricBean) {
//拿到歌词解析的类
    }

    @Override
    public void nothing(int i, String nothing) {

    }
}
