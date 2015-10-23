package tw.com.knorr.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import tw.com.knorr.R;
import tw.com.knorr.activity.presenter.MainActivityPresenter;
import tw.com.knorr.activity.view.IMainActivityView;
import tw.com.knorr.fragment.AccountFragment;
import tw.com.knorr.fragment.CookbookFragment;
import tw.com.knorr.fragment.IndexFragment;
import tw.com.knorr.fragment.NewsFragment;
import tw.com.knorr.fragment.RedeemFragment;
import tw.com.knorr.fragment.CaptureFragment;
import tw.com.knorr.main.BaseActivity;

/**
 * TAB界面
 */
public class MainActivity extends BaseActivity implements IMainActivityView, View.OnClickListener {
    private MainActivityPresenter presenter;
    private Button[] mBtnTabs;
    private Fragment[] mFragments;
    private int mCurrentTabIndex = -1;
    private int mIndex = -1;
    private FragmentManager fm;
    private static final String[] mTitles = {"扫描", "账号", "兑换", "食谱", "消息"};
    private TextView mTxtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        presenter = new MainActivityPresenter();
        presenter.setMainActivityView(this);
        presenter.setTab(getIntent().getIntExtra(IndexFragment.TAB, 0));
    }

    private void initView() {
        //创建Tab的下标引用
        mBtnTabs = new Button[5];
        mBtnTabs[0] = (Button) findViewById(R.id.btn_tab_scan);
        mBtnTabs[1] = (Button) findViewById(R.id.btn_tab_account);
        mBtnTabs[2] = (Button) findViewById(R.id.btn_tab_redeem);
        mBtnTabs[3] = (Button) findViewById(R.id.btn_tab_cookbook);
        mBtnTabs[4] = (Button) findViewById(R.id.btn_tab_news);
        for (Button tab : mBtnTabs) {
            tab.setOnClickListener(this);
        }
        mFragments = new Fragment[5];
        mFragments[0] = new CaptureFragment();
        mFragments[1] = new AccountFragment();
        mFragments[2] = new RedeemFragment();
        mFragments[3] = new CookbookFragment();
        mFragments[4] = new NewsFragment();

        mTxtTitle = (TextView) findViewById(R.id.txt_title);
        fm = getSupportFragmentManager();
    }

    @Override
    public void setSelectedTab(int tabIndex) {
        //改变tab选项以及整个界面的内容
        //tab
        Log.e(IndexFragment.TAB, tabIndex + "");
        mBtnTabs[tabIndex].setSelected(true);
        if (mCurrentTabIndex >= 0) {
            mBtnTabs[mCurrentTabIndex].setSelected(false);
        }

        //fragment
        if (!mFragments[tabIndex].isAdded()) {
            fm.beginTransaction().add(R.id.fragment_container, mFragments[tabIndex]).commit();
        }
        if (mCurrentTabIndex >= 0) {
            fm.beginTransaction().hide(mFragments[mCurrentTabIndex]).show(mFragments[tabIndex]).commit();
        }

        //title
        mTxtTitle.setText(mTitles[tabIndex]);
        if (0 == tabIndex){
            mTxtTitle.setVisibility(View.GONE);
        }else{
            mTxtTitle.setVisibility(View.VISIBLE);
        }

        mCurrentTabIndex = tabIndex;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_tab_scan:
                mIndex = 0;
                break;
            case R.id.btn_tab_account:
                mIndex = 1;
                break;
            case R.id.btn_tab_redeem:
                mIndex = 2;
                break;
            case R.id.btn_tab_cookbook:
                mIndex = 3;
                break;
            case R.id.btn_tab_news:
                mIndex = 4;
                break;
            default:
                break;
        }
        presenter.setTab(mIndex);
    }
}
