package tw.com.knorr.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * 所有Activity的父类 设置一些通用配置
 */
public class BaseActivity extends AppCompatActivity {
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fm = getSupportFragmentManager();
    }


    /**
     * 添加Fragment
     * @param resId fragment container
     * @param fragment fragment
     */
    protected void showFragment(int resId, Fragment fragment){
        if (fragment != null){
            if (!fragment.isAdded()){
                fm.beginTransaction().add(resId, fragment).commit();
            }
            fm.beginTransaction().show(fragment).commit();
        }
    }
}
