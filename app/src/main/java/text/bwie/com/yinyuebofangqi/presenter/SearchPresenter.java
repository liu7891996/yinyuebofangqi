package text.bwie.com.yinyuebofangqi.presenter;

import text.bwie.com.yinyuebofangqi.modle.SearchModle;
import text.bwie.com.yinyuebofangqi.view.bean.SearchBean;
import text.bwie.com.yinyuebofangqi.view.interfaces.SearchInterface;
import text.bwie.com.yinyuebofangqi.view.interfaces.SearchInterfaceTwo;

/**
 * 类描述：歌曲搜索
 * 姓名 ：刘希鑫
 */

public class SearchPresenter implements SearchInterfaceTwo<SearchBean> {
    private SearchInterface se;
    private SearchModle modle;

    public void getid(SearchInterface searchInterface){
        this.se=searchInterface;
        modle = new SearchModle();
    }

    public void getcode(String name,Class clazz){

        modle.getUrlId(this);
        modle.postUrlHttp(name,clazz);

    }


    @Override
    public void prosperity(SearchBean searchBean) {
       se.prosperity(searchBean);
    }

    @Override
    public void nothing(int i, String nothing) {

    }
}
