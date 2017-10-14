package text.bwie.com.yinyuebofangqi.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * 类描述：父类，里面有重写的方法，只需要继承这个就可以了
 * 姓名 ：刘希鑫
 */

public abstract class MvpActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(setSelfViewId());
        initData();
        laoutData();
    }
  /*
  * 执行代码
  * */
    protected abstract void laoutData();

    /*
    * 找到控件
    * */
     abstract void initData();

    abstract int setSelfViewId();
}
