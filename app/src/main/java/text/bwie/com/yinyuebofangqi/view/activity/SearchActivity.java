package text.bwie.com.yinyuebofangqi.view.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.List;

import text.bwie.com.yinyuebofangqi.R;
import text.bwie.com.yinyuebofangqi.presenter.SearchPresenter;
import text.bwie.com.yinyuebofangqi.view.adapter.SearchAdapter;
import text.bwie.com.yinyuebofangqi.view.app.MyImageView;
import text.bwie.com.yinyuebofangqi.view.bean.SearchBean;
import text.bwie.com.yinyuebofangqi.view.interfaces.SearchInterface;

/**
 * 类描述：歌曲搜索
 * 姓名 ：刘希鑫
 */

public class SearchActivity extends MvpActivity implements SearchInterface<SearchBean>{

    private EditText editText;
    private ImageView fanhui;
    private ImageView imageView;
    private RecyclerView recyclerView;
    private SearchPresenter presenter;

    private MyImageView sousuojiazai;

    @Override
    protected void laoutData() {
//返回上一页
        fanhuisahngyiye();
        presenter = new SearchPresenter();
        presenter.getid(this);
       //点击搜索
        onsousuo();

    }
    //点击搜索
    private void onsousuo() {
    imageView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String s = editText.getText().toString();
            presenter.getcode(s,SearchBean.class);
            sousuojiazai.setVisibility(View.VISIBLE);
//           jinru.setVisibility(View.VISIBLE);
        }
    });
    }

    //返回上一页
    private void fanhuisahngyiye() {
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
    }

    @Override
    void initData() {
        editText = (EditText) findViewById(R.id.search_edit);
        fanhui = (ImageView) findViewById(R.id.search_fanhui);
        imageView = (ImageView) findViewById(R.id.search_sousuo);
        sousuojiazai = (MyImageView) findViewById(R.id.sousuojiazai);
        recyclerView = (RecyclerView) findViewById(R.id.search_recyc);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        jinru = (ImageView) findViewById(R.id.search_jinru);
    }

    @Override
    int setSelfViewId() {
        return R.layout.activity_search;
    }

    @Override
    public void prosperity(SearchBean searchBean) {
     sousuojiazai.setVisibility(View.GONE);
        List<SearchBean.SongBean> song = searchBean.getSong();
        SearchAdapter adapter=new SearchAdapter(SearchActivity.this,song);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void nothing(int i, String nothing) {

    }
}
