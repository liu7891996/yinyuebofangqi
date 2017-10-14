package text.bwie.com.yinyuebofangqi.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.List;

import text.bwie.com.yinyuebofangqi.R;
import text.bwie.com.yinyuebofangqi.presenter.MusicPresenter;
import text.bwie.com.yinyuebofangqi.view.activity.SingerInformation;
import text.bwie.com.yinyuebofangqi.view.bean.Bean;
import text.bwie.com.yinyuebofangqi.view.bean.BofangMusicBean;
import text.bwie.com.yinyuebofangqi.view.interfaces.AdapterOne;

/**
 * 类描述：
 * 姓名 ：刘希鑫
 */
//
public class DetailsAdapter extends RecyclerView.Adapter implements AdapterOne<BofangMusicBean> {
    private MusicPresenter musicPresenter;
    Context context;
    List<Bean.SongListBean> arr;
    private String[] provinces = new String[] { "分享", "查看歌手信息", "下载"};
    UMShareListener umShareListener;
    public DetailsAdapter(Context context, List<Bean.SongListBean> song_list) {
        this.context = context;
        this.arr = song_list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
View view= LayoutInflater.from(context).inflate(R.layout.details_recyc,null);
        return new ViewHodler(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHodler viewhodler= (ViewHodler) holder;
        viewhodler.geming.setText(arr.get(position).getAlbum_title());
        viewhodler.name.setText(arr.get(position).getArtist_name());
        Glide.with(context).load(arr.get(position).getPic_small()).into(viewhodler.image);
        viewhodler.diandian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"点击弹窗",Toast.LENGTH_LONG).show();
              tanchaung(position);
            }


        });
        viewhodler.linearLayout.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {

                Toast.makeText(context,"播放歌曲",Toast.LENGTH_LONG).show();
                musicPresenter = new MusicPresenter();

                String song_id = arr.get(position).getSong_id();
                musicPresenter.getHttp(song_id,BofangMusicBean.class);

            }
        });
    }
    private void tanchaung(final int position) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle(arr.get(position).getAlbum_title());
        /**
          * 1、public Builder setItems(int itemsId, final OnClickListener
           * listener) itemsId表示字符串数组的资源ID，该资源指定的数组会显示在列表中。 2、public Builder
          * setItems(CharSequence[] items, final OnClickListener listener)
          * items表示用于显示在列表中的字符串数组
          */

        builder.setItems(provinces, new DialogInterface.OnClickListener()
       {
             @Override
             public void onClick(DialogInterface dialog, int which)
             {
                 /*
                 * * ad变量用final关键字定义，因为在隐式实现的Runnable接口 的run()方法中 需要访问final变量。
                 * */


                 switch (which){
                     case 0://分享的点击处理

                         new ShareAction((Activity) context)
                                 .setPlatform(SHARE_MEDIA.QQ)//传入平台
                                 .withText("hello")//分享内容
                                 .setCallback(shareListener)//回调监听器
                                 .share();

                         break;
                     case 1://查看歌手信息
                         Intent intent=new Intent(context, SingerInformation.class);
                         intent.putExtra("type",arr.get(position).getTing_uid());
                         context.startActivity(intent);
                         break;
                     case 2://下载的点击处理

                         break;
                 }



            }

        });

        builder.create().show();

    }
    @Override
    public int getItemCount() {
        return arr.size();
    }

    //音乐播放请求数据的接口回调
    @Override
    public void prosperity(BofangMusicBean bofangMusicBean) {





    }

    @Override
    public void nothing(int i, String nothing) {

    }

    public class ViewHodler extends RecyclerView.ViewHolder{


        private final TextView name;
        private final TextView geming;
        private final ImageView image;
        private final LinearLayout linearLayout;
        private final ImageView diandian;
        public ViewHodler(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.detai_recyc_name);
            geming = itemView.findViewById(R.id.detai_recyc_geming);
            image = itemView.findViewById(R.id.detai_recyc_image);
            linearLayout = itemView.findViewById(R.id.details_linear);
            diandian=itemView.findViewById(R.id.detai_recyc_diandian);

        }
    }
    private UMShareListener shareListener;

    {
        shareListener = new UMShareListener() {
            /**
             * @param platform 平台类型
             * @descrption 分享开始的回调
             */
            @Override
            public void onStart(SHARE_MEDIA platform) {

            }

            /**
             * @param platform 平台类型
             * @descrption 分享成功的回调
             */
            @Override
            public void onResult(SHARE_MEDIA platform) {
                Toast.makeText(context, "成功了", Toast.LENGTH_LONG).show();
            }

            /**
             * @param platform 平台类型
             * @param t        错误原因
             * @descrption 分享失败的回调
             */
            @Override
            public void onError(SHARE_MEDIA platform, Throwable t) {
                Toast.makeText(context, "失败" + t.getMessage(), Toast.LENGTH_LONG).show();
            }

            /**
             * @param platform 平台类型
             * @descrption 分享取消的回调
             */
            @Override
            public void onCancel(SHARE_MEDIA platform) {
                Toast.makeText(context, "取消了", Toast.LENGTH_LONG).show();

            }
        };
    }
}
