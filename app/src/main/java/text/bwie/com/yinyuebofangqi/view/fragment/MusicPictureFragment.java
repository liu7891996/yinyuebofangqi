package text.bwie.com.yinyuebofangqi.view.fragment;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import text.bwie.com.yinyuebofangqi.R;

/**
 * 类描述：音乐详情界面的歌盘动画
 * 姓名 ：刘希鑫
 */

public class MusicPictureFragment extends MyFragment{

    private ImageView yuanpan;
    private ImageView bofang;
    private ObjectAnimator animator;

    @Override
    protected void initExecute() {

    }
  //添加id
    @Override
    protected void initID(View view) {
        yuanpan = view.findViewById(R.id.yuanpan);
        bofang = view.findViewById(R.id.bofang);
    }

    @Override
    protected View initView() {
        View view=View.inflate(getActivity(),R.layout.fragment_one,null);
        return view;
    }

    //添加的动画
    public void donghua(){
        //音乐的棍子动画
        ObjectAnimator animator1=ObjectAnimator.ofFloat(bofang,"rotation",0f,10f);
        bofang.setPivotX(0);
        bofang.setPivotY(0);
        animator1.setDuration(2000);
        animator1.start();
        //音乐圆盘的动画
        animator = ObjectAnimator.ofFloat(yuanpan,"rotation",0f,360f);
        animator.setDuration(5000);
        animator.setRepeatCount(-1);
        animator.setInterpolator(new LinearInterpolator());
        animator.start();
    }
    //圆盘停止转动，音乐棍挪开
    public void fandonghua(){
        ObjectAnimator animator1=ObjectAnimator.ofFloat(bofang,"rotation",10f,0f);
        animator1.setDuration(2000);
        animator1.start();
        //停止圆盘的动画
        animator.end();
    }

}
