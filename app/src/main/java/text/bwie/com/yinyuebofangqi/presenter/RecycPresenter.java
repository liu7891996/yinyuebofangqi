package text.bwie.com.yinyuebofangqi.presenter;

import java.util.List;

import text.bwie.com.yinyuebofangqi.modle.RecycModler;
import text.bwie.com.yinyuebofangqi.view.bean.Bean;
import text.bwie.com.yinyuebofangqi.view.interfaces.RecycInterface;
import text.bwie.com.yinyuebofangqi.view.interfaces.RecycInterfaceTwo;

/**
 * 类描述：
 * 姓名 ：刘希鑫
 */

public class RecycPresenter implements RecycInterfaceTwo<List<Bean>>{
    private RecycInterface re;
    private RecycModler modler;

    public void getcontext(RecycInterface recycInterface){
        this.re=recycInterface;
        modler = new RecycModler();
    }

    public void execution(){

        modler.getid(this);
        modler.getlisturl(Bean.class);



    }

    @Override
    public void prosperity(List<Bean> bean) {

         re.prosperity(bean);
    }

    @Override
    public void nothing(int i, String nothing) {
        re.nothing(i,nothing);
    }
}
