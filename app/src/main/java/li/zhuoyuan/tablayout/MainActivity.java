package li.zhuoyuan.tablayout;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<String> titles;
    private ArrayList<Fragment> fragments;
    private Fragment firstFragment, twofragment, threefragment;
    private MyFragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        initdate();
    }

    private void initdate() {
        viewPager.setAdapter(adapter);
        adapter = new MyFragmentAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(adapter);
    }

    private void initview() {
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        firstFragment = new FirstFragment();
        twofragment = new TwoFragment();
        threefragment = new ThreeFragment();
        titles = new ArrayList<>();
        fragments = new ArrayList<>();
        fragments.add(firstFragment);
        fragments.add(twofragment);
        fragments.add(threefragment);
        //设置TabLayout的模式
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i < 3; i++) {
            titles.add("标题" + (i + 1));
            //为TabLayout添加tab名称
            tabLayout.addTab(tabLayout.newTab().setText(titles.get(i)));
        }
        //TabLayout加载viewpager
        tabLayout.setupWithViewPager(viewPager);
        Log.i("TAG", "状态栏高度: " + getStatusBarHeight(this));

    }

    /**
     * 获取状态栏高度
     *
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        Class<?> c = null;
        Object obj = null;
        java.lang.reflect.Field field = null;
        int x = 0;
        int statusBarHeight = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = context.getResources().getDimensionPixelSize(x);
            return statusBarHeight;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusBarHeight;
    }
}
