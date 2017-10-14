package text.bwie.com.yinyuebofangqi.view.activity;

import android.content.Intent;
import android.os.Handler;

import text.bwie.com.yinyuebofangqi.R;

public class MainActivity extends MvpActivity {


    @Override
    protected void laoutData() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                //你需要跳转的地方的代码
                Intent intent=new Intent(MainActivity.this,MyActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000); //延迟2秒跳转
    }

    @Override
    void initData() {

    }

    @Override
    int setSelfViewId() {
        return R.layout.activity_main;
    }
}
