package tw.com.knorr.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;

import tw.com.knorr.R;
import tw.com.knorr.activity.presenter.MainActivityPresenter;
import tw.com.knorr.activity.view.IMainActivityView;
import tw.com.knorr.fragment.IndexFragment;
import tw.com.knorr.fragment.LaunchFragment;
import tw.com.knorr.main.BaseActivity;

public class IndexActivity extends BaseActivity implements IMainActivityView{
    private MainActivityPresenter presenter;
    private FragmentManager fm;
    private LaunchFragment launchFragment;
    private IndexFragment indexFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        if (launchFragment == null){
            launchFragment = new LaunchFragment();
        }
        fm.beginTransaction().add(R.id.fragment_container, launchFragment).show(launchFragment).commit();
        presenter = new MainActivityPresenter();
        presenter.setView(this);
        presenter.checkUpdate();
    }

    @Override
    public void showVersionUpdate() {
        //如果有新版本
        Toast.makeText(this, "ads", Toast.LENGTH_SHORT).show();
        presenter.destroy();
    }

    @Override
    public void intoIndexFragment() {
        //进入主界面
        if (indexFragment == null){
            indexFragment = new IndexFragment();
        }
        fm.beginTransaction().replace(R.id.fragment_container, indexFragment).commit();
    }
}
