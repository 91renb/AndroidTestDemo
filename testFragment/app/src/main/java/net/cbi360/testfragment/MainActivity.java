package net.cbi360.testfragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

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
        bundle.putString("title", "子模块的标题-FirstFragment");
        // 通过Bundle把参数传给Activity
        firstFragment.setArguments(bundle);

        // 使用fragment方法2：动态添加一个fragment到activity指定的控件内部

        // 获取到低版本兼容的FragmentManager（ getFragmentManager(); 支持3.0以上版本 ）
        FragmentManager fm = getSupportFragmentManager();

        // 1.开启一个Fragment事务（即可对Fragment进行操作）
        FragmentTransaction transaction = fm.beginTransaction();

        // 2.添加一个fragment到activity指定的控件内部（每调用一次add方法，就添加一次，会重复叠加）
        // （参数：布局容器FrameLayout的ID，fragment对象，动态添加时需要设置一个id/tag）
        transaction.add(R.id.content, firstFragment, "first");

        // 加入返回任务栈，可通过系统返回按钮控制返回
        transaction.addToBackStack(null); // 任务名可为空
        transaction.addToBackStack("任务名"); // 通过任务名可控制多层返回

        // 2.1 添加一个fragment到activity指定的控件内部（会先清除原有的，再重新添加）
        // transaction.replace(R.id.content, firstFragment, "first");

        // 2.2 将 Fragment UI 与 activity 解绑（即只是UI不可见，还在里面）-》执行createView，每次都创建UI会比较浪费内存
        // transaction.detach(firstFragment);

        // 2.3 将 Fragment UI 与 activity 重新绑定（即回收UI）-》执行createView，每次都创建UI会比较浪费内存
        // transaction.attach(firstFragment);

        // 2.4 将 Fragment 与 activity 彻底解绑
        // transaction.remove(firstFragment);

        // 2.5 显示 Fragment（不会调用任何生命周期方法）——》常用这个
        // transaction.show(firstFragment);

        // 2.6 隐藏 Fragment（不会调用任何生命周期方法）——》常用这个
        // transaction.hide(firstFragment);

        // 3.提交（对fragment进行任何操作都必须提交）
        // transaction.commit();

        /*
            commit 和 commitAllowingStateLoss 的区别：
            为了防止在 onSaveInstanceState 方法中调用 commit 会报错，我们使用 commitAllowingStateLoss，可以防止状态丢失报错！
            所以在使用Fragment时，大多数使用 commitAllowingStateLoss 进行提交操作。（防止报错！）
         */
        transaction.commitAllowingStateLoss();

        //fm.beginTransaction().add(R.id.content, new FirstFragment(), "first").commit();
    }

    @Override
    public void onBackPressed() {
        Log.i("11", "点击了系统返回按钮");
        super.onBackPressed();

        FragmentManager fm = getSupportFragmentManager();
        /* 返回到上一页 */
        fm.popBackStack();
        /* 返回到指定页 */
        fm.popBackStack("abc", 0);
    }

}
