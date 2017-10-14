package text.bwie.com.yinyuebofangqi.presenter;

import text.bwie.com.yinyuebofangqi.modle.SingegrModle;
import text.bwie.com.yinyuebofangqi.view.bean.SingerBeab;
import text.bwie.com.yinyuebofangqi.view.interfaces.RecycInterface;
import text.bwie.com.yinyuebofangqi.view.interfaces.RecycInterfaceTwo;

/**
 * 类描述：
 * 姓名 ：刘希鑫
 */

public class SingerPresenter implements RecycInterfaceTwo<SingerBeab> {
    private RecycInterface rc;
    private SingegrModle http;

    public void getId(RecycInterface recycInterface){
        this.rc=recycInterface;
        http = new SingegrModle();
    }
    public void getDataHttp(String type){

        http.getid(this);
        http.geturl(type, SingerBeab.class);
    }

    @Override
    public void prosperity(SingerBeab o) {
       rc.prosperity(o);
    }

    @Override
    public void nothing(int i, String nothing) {

    }
}
