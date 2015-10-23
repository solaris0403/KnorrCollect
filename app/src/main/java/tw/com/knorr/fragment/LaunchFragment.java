package tw.com.knorr.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.os.Handler;

import tw.com.knorr.R;
import tw.com.knorr.activity.IndexActivity;
import tw.com.knorr.fragment.presenter.LaunchPresenter;
import tw.com.knorr.fragment.view.ILaunchView;

/**
 * Launch Fragment
 */
public class LaunchFragment extends Fragment implements ILaunchView {
    private LaunchPresenter launchPresenter;
    private static Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        launchPresenter = new LaunchPresenter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_launch, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        launchPresenter.setLaunchView(this);
        launchPresenter.checkUpdate();
        showProgress();
    }

    /**
     * 显示加载的进度条
     */
    public void showProgress() {
        //动画显示
    }

    @Override
    public void showUpdate() {
        //如果有更新 则显示更新的动作
    }

    @Override
    public void intoMainView() {
        //进入主界面
        Intent intent = new Intent(this.getActivity(), IndexActivity.class);
        startActivity(intent);
        this.getActivity().finish();
    }
}
