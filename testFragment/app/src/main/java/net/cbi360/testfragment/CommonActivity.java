package net.cbi360.testfragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;

public class CommonActivity extends FragmentActivity implements OneOnClickListener {
    TwoFragment two;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

        FragmentManager fm = getSupportFragmentManager();
        OneFragment one = (OneFragment)fm.findFragmentByTag("one");
        one.setOneOnClickListener(this);
        two = (TwoFragment)fm.findFragmentByTag("two");
    }

    public void OneOnClick(int index) {
        String msg = "点击了" + index + "按钮";
        Log.i("CommonActivity", msg);
        two.setMessage(msg);
    }
}

