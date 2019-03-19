package net.cbi360.testfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class OneFragment extends Fragment {
    OneOnClickListener activity;
    int index = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (null != savedInstanceState) {
            // 恢复参数的值
            index = savedInstanceState.getInt("index");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, null);
        Button button = (Button)view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.i("OneFragment", "点击了按钮");
                index++;
                activity.OneOnClick(index);
            }
        });
        return view;
    }

//    public void setActivity(CommonActivity activity) {
//        this.activity = activity;
//
//    }

    // 解耦（减少关联性，方便不同activity重用）
    public void setOneOnClickListener(OneOnClickListener activity) {
        this.activity = activity;

    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        // 也可以从生命周期方法中拿到 Activity
//        activity = (OneOnClickListener)getActivity();
//    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // 保存参数的值
        outState.putInt("index", index);
    }
}
