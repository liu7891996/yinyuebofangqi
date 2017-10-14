package text.bwie.com.yinyuebofangqi.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import text.bwie.com.yinyuebofangqi.R;
import text.bwie.com.yinyuebofangqi.view.activity.DetailsActivity;
import text.bwie.com.yinyuebofangqi.view.bean.Bean;
import text.bwie.com.yinyuebofangqi.view.bean.MusicBeanChild;

/**
 * 类描述：展示列表适配器
 * 姓名 ：刘希鑫
 */

public class RecycAdapter extends RecyclerView.Adapter {
    Context context;
    List<Bean> bean;
    List<MusicBeanChild> musicBeanChildren;
  private final  int TYPE=0;
    private final int TYPE2=1;


    public RecycAdapter(Context context, List<Bean> bean, List<MusicBeanChild> musicBeanChildren) {
        this.context = context;
        this.bean = bean;
        this.musicBeanChildren = musicBeanChildren;
    }

    @Override
    public int getItemViewType(int position) {
        String tpe=musicBeanChildren.get(position).getType();
        if (tpe.equals("#")){
            return TYPE;
        }else{
            return TYPE2   ;
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int itemViewType = getItemViewType(viewType);
       if (itemViewType==0){
           View view= LayoutInflater.from(context).inflate(R.layout.adapter_recy_two,null);
           return new ViewHodler2(view);
       }else{
           View view= LayoutInflater.from(context).inflate(R.layout.adapter_recyc,null);
           return new ViewHodler(view);
       }




    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
       int itemViewType=getItemViewType(position);
       if (itemViewType==0){
           if (holder instanceof ViewHodler2){
           ViewHodler2 viewhodler2= (ViewHodler2) holder;
           viewhodler2.text.setText(musicBeanChildren.get(position).getListName());
           }
       }else{
           if (holder instanceof ViewHodler){
               ViewHodler viewhodler= (ViewHodler) holder;
               //   viewhodler.image
               final Bean.BillboardBean billboard = bean.get(position).getBillboard();
               Glide.with(context).load(billboard.getPic_s260()).into(viewhodler.image);
               final List<Bean.SongListBean> song_list = bean.get(position).getSong_list();
               Log.e("text1------------",song_list.get(0).getTitle());
               Log.e("text2------------",song_list.get(1).getTitle());
               Log.e("text3------------",song_list.get(2).getTitle());
               viewhodler.text1.setText(song_list.get(0).getTitle());
               viewhodler.text2.setText(song_list.get(1).getTitle());
               viewhodler.text3.setText(song_list.get(2).getTitle());
               viewhodler.linearLayout.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       String title = song_list.get(0).getTitle();
                       Toast.makeText(context,title,Toast.LENGTH_LONG).show();
                       String str=billboard.getBillboard_type();
                       Intent intent=new Intent(context, DetailsActivity.class);
                       intent.putExtra("type",str);
                       context.startActivity(intent);
                   }
               });
           }
       }
  }



    @Override
    public int getItemCount() {
        return bean.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder{
        TextView text1;
        TextView text2;
        TextView text3;
        LinearLayout linearLayout;

        ImageView image;


        public ViewHodler(View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.recyc_image);
            text1=itemView.findViewById(R.id.recyc_text1);
            text2=itemView.findViewById(R.id.recyc_text2);
            text3=itemView.findViewById(R.id.recyc_text3);
            linearLayout = itemView.findViewById(R.id.linearlayout);

        }
    }

    class ViewHodler2 extends RecyclerView.ViewHolder{
        TextView text;
        public ViewHodler2(View itemView) {
            super(itemView);
          text= itemView.findViewById(R.id.recyc_title);
        }
    }

    public interface MyItemOnClickListener {
        public void onItemOnClick(View view,int postion);
    }

}
