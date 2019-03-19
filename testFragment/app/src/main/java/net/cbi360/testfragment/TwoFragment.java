package net.cbi360.testfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TwoFragment extends Fragment {
    TextView textView;
    String msg = "";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (null != savedInstanceState) {
            // 恢复参数的值
            msg = savedInstanceState.getString("msg");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, null);
        textView = (TextView)view.findViewById(R.id.textView2);
        textView.setText(msg);

        return view;
    }

    public void setMessage(String msg) {
        Log.i("TwoFragment", msg);
        this.msg = msg;
        textView.setText(msg);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // 保存参数的值
        outState.putString("msg", msg);
    }
}
