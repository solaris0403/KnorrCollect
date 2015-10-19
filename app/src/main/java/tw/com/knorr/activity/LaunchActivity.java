package tw.com.knorr.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import tw.com.knorr.R;
import tw.com.knorr.fragment.LaunchFragment;
import tw.com.knorr.main.BaseActivity;

/**
 * 程序启动界面
 */
public class LaunchActivity extends BaseActivity{
    private FragmentManager fm;
    private LaunchFragment launchFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        fm = getSupportFragmentManager();
        if (launchFragment == null){
            launchFragment = new LaunchFragment();
        }
        fm.beginTransaction().add(R.id.fragment_container, launchFragment).show(launchFragment).commit();
    }
}
