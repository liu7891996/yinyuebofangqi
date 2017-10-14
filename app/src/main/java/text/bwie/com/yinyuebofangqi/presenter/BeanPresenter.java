package text.bwie.com.yinyuebofangqi.presenter;

import text.bwie.com.yinyuebofangqi.modle.BeanModler;
import text.bwie.com.yinyuebofangqi.view.bean.Bean;
import text.bwie.com.yinyuebofangqi.view.interfaces.RecycInterface;
import text.bwie.com.yinyuebofangqi.view.interfaces.RecycInterfaceTwo;

/**
 * 类描述：
 * 姓名 ：刘希鑫
 */

public class BeanPresenter implements RecycInterfaceTwo<Bean> {
    RecycInterface re;
    private BeanModler modler;

    public void getcontext(RecycInterface recycInterface){
        this.re=recycInterface;
        modler = new BeanModler();
    }
    public void diaoyong(String type){

        modler.getid(this);
        modler.geturl(type,Bean.class);
    }

    @Override
    public void prosperity(Bean bean) {
    re.prosperity(bean);
    }

    @Override
    public void nothing(int i, String nothing) {

    }




}
