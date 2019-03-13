package net.cbi360.testfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
// support.v4 表示低版本兼容的Fragment，没有时表示支持3.0以上的版本
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FirstFragment extends Fragment {
    @Nullable
    @Override
    /* 系统会在片段首次绘制其用户界面时调用此方法，并将创建的UI界面返回 */
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /* 接收传递的参数 */
        Bundle bundle = getArguments();
        String title = bundle.getString("title");

        /* 返回一个view，把布局返回去 */
        View view = inflater.inflate(R.layout.fragment_first, null);
        TextView textView = view.findViewById(R.id.textView);
        textView.setText(title);

        return view;
    }

    /* fragment传值 */
//    public void setData(String a) {
//
//    }
}
