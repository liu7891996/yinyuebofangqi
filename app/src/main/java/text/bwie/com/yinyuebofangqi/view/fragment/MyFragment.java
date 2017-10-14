package text.bwie.com.yinyuebofangqi.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 类描述：
 * 姓名 ：刘希鑫
 */

public abstract class MyFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = initView();
        initID(view);
        initExecute();
        return view;
    }

    protected abstract void initExecute();

    protected abstract void initID(View view);

    protected abstract View initView();


}
