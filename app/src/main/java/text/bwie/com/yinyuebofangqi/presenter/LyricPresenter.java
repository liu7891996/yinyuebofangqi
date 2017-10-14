package text.bwie.com.yinyuebofangqi.presenter;

import text.bwie.com.yinyuebofangqi.modle.LyricModler;
import text.bwie.com.yinyuebofangqi.view.bean.LyricBean;
import text.bwie.com.yinyuebofangqi.view.interfaces.SearchInterface;
import text.bwie.com.yinyuebofangqi.view.interfaces.SearchInterfaceTwo;

/**
 * 类描述：
 * 姓名 ：刘希鑫
 */

public class LyricPresenter implements SearchInterfaceTwo<LyricBean> {
    private SearchInterface se;
    private LyricModler modler;

    public void getID(SearchInterface searchInterface){
          this.se=searchInterface;
        modler = new LyricModler();
    }

    public void gethttp(String songid,Class clazz){
       modler.getID(this);
        modler.getHttp(songid,clazz);
    }

    @Override
    public void prosperity(LyricBean lyricBean) {
             se.prosperity(lyricBean);
    }

    @Override
    public void nothing(int i, String nothing) {

    }
}
