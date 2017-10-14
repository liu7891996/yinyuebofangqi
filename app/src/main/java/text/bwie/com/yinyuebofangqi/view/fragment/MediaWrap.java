package text.bwie.com.yinyuebofangqi.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import text.bwie.com.yinyuebofangqi.R;
import text.bwie.com.yinyuebofangqi.presenter.RecycPresenter;
import text.bwie.com.yinyuebofangqi.view.adapter.RecycAdapter;
import text.bwie.com.yinyuebofangqi.view.bean.Bean;
import text.bwie.com.yinyuebofangqi.view.bean.MusicBeanChild;
import text.bwie.com.yinyuebofangqi.view.interfaces.RecycInterface;

/**
 * 类描述：音乐列表fragment
 * 姓名 ：刘希鑫
 */

public class MediaWrap extends MyFragment implements RecycInterface<List<Bean>>{


    private RecyclerView recyclerView;

    @Override
    protected void initExecute() {
        RecycPresenter recycHttp=new RecycPresenter();
        recycHttp.getcontext(this);
        recycHttp.execution();
    }

    @Override
    protected void initID(View view) {
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        

    }

    @Override
    protected View initView() {
       View view = View.inflate(getActivity(), R.layout.fragment_media,null);
        return view;
    }
  //成功返回bean类集合
    @Override
    public void prosperity(List<Bean> bean) {


        //将数据存到数组中
        List<MusicBeanChild> musicBeanChildren=new ArrayList<>();
        String[] title=getResources().getStringArray(R.array.music_title);
        String[] type=getResources().getStringArray(R.array.musiclist_type);
        for (int i=0;i<title.length;i++){
            MusicBeanChild musicBeanChild=new MusicBeanChild();
            musicBeanChild.setType(type[i]);
            musicBeanChild.setListName(title[i]);
            musicBeanChildren.add(musicBeanChild);
        }
        RecycAdapter adapter=new RecycAdapter(getActivity(),bean,musicBeanChildren);
        recyclerView.setAdapter(adapter);


    }
//失败返回的
    @Override
    public void nothing(int i, String nothing) {

    }


}
