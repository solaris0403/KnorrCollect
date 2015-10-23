package tw.com.knorr.fragment.presenter;

import com.tony.volleydemo.http.core.Listener;
import com.tony.volleydemo.http.core.VolleyError;

import tw.com.knorr.fragment.model.ILaunchModel;
import tw.com.knorr.fragment.model.impl.LaunchModel;
import tw.com.knorr.fragment.view.ILaunchView;

/**
 * 启动视图控制器
 */
public class LaunchPresenter {
    private ILaunchModel launchModel;
    private ILaunchView launchView;

    public LaunchPresenter() {
        this(new LaunchModel());
    }

    public LaunchPresenter(ILaunchModel launcheModel) {
        this.launchModel = launcheModel;
    }

    public ILaunchView getLauncheView() {
        return launchView;
    }

    public void setLaunchView(ILaunchView launcheView) {
        this.launchView = launcheView;
    }

    /**
     * 检测更新
     */
    public void checkUpdate() {
        if (launchModel != null) {
            launchModel.checkUpdate(new Listener<String>() {
                @Override
                public void onSuccess(String jsonObject) {
                }

                @Override
                public void onError(VolleyError error) {
                    super.onError(error);
                }

                @Override
                public void onFinish() {
                    super.onFinish();
                    pushId();
                }
            });
        }
    }

    /**
     * 推送GCM的注册ID到服务器
     */
    public void pushId(){
        if (launchModel != null) {
            launchModel.pushGCMRegisterId(new Listener<String>() {
                @Override
                public void onSuccess(String jsonObject) {
                }

                @Override
                public void onError(VolleyError error) {
                    super.onError(error);
                }

                @Override
                public void onFinish() {
                    super.onFinish();
                    launchView.intoMainView();
                    launchModel.destroy();
                }
            });
        }
    }
}
