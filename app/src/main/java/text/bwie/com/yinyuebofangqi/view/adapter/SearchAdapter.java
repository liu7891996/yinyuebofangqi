package text.bwie.com.yinyuebofangqi.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import text.bwie.com.yinyuebofangqi.R;
import text.bwie.com.yinyuebofangqi.presenter.MusicPresenter;
import text.bwie.com.yinyuebofangqi.view.bean.BofangMusicBean;
import text.bwie.com.yinyuebofangqi.view.bean.SearchBean;

/**
 * 类描述：
 * 姓名 ：刘希鑫
 */

public class SearchAdapter extends RecyclerView.Adapter {
    Context context;
    private MusicPresenter  presenter =new MusicPresenter();
    List<SearchBean.SongBean> album;
    public SearchAdapter(Context context, List<SearchBean.SongBean> album) {
        this.context = context;
        this.album = album;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

      View view=LayoutInflater.from(context).inflate(R.layout.adapter_search,parent,false);
        return new ViewHodler(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
         ViewHodler viewHodler= (ViewHodler) holder;
        viewHodler.geshou.setText(album.get(position).getArtistname());
        viewHodler.name.setText(album.get(position).getSongname());



        viewHodler.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String songid = album.get(position).getSongid();
                presenter.getHttp(songid, BofangMusicBean.class);
            }
        });
    }

    @Override
    public int getItemCount() {
        return album.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder{

        private  TextView name;
        private  TextView geshou;
        private  ImageView image;
        private final LinearLayout linearLayout;

        public ViewHodler(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.search_adapter_name);
            geshou = itemView.findViewById(R.id.search_adapter_mesic);
            image = itemView.findViewById(R.id.search_adapter_diandian);
            linearLayout = itemView.findViewById(R.id.search_adapter_linear);
        }
    }

}
