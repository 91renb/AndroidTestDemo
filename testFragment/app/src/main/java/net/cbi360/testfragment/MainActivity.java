package net.cbi360.testfragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/* Activity：选择 FragmentActivity 和 AppCompatActivity 都可以 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirstFragment firstFragment = new FirstFragment();

        // 传值给Fragment
        // 页面之间的传值：Bundle是传递数据的集合
        Bundle bundle = new Bundle();
        bundle.putString("title", "标题的值");
        // 通过Bundle把参数传给Activity
        firstFragment.setArguments(bundle);

        // 使用fragment方法2：动态加，通过代码来加

        // 获取到低版本兼容的FragmentManager
        FragmentManager fm = getSupportFragmentManager();
        // 支持3.0以上版本
        // getFragmentManager();
        // 1.开启Fragment事务
        FragmentTransaction transaction = fm.beginTransaction();
        // 2.添加一个fragment到activity指定的控件内部
        // （参数：布局容器FrameLayout的ID，fragment对象，动态添加时需要设置一个id/tag）
        transaction.add(R.id.content, firstFragment, "first");
        // 3.提交（对fragment进行任何操作都必须提交）
        transaction.commit();

        //fm.beginTransaction().add(R.id.content, new FirstFragment(), "first").commit();
    }
}
