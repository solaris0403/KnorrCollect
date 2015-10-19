package tw.com.knorr.activity.presenter;

import com.tony.volleydemo.http.core.Listener;

import tw.com.knorr.activity.model.IMainActivityModel;
import tw.com.knorr.activity.model.impl.MainActivityModel;
import tw.com.knorr.activity.view.IMainActivityView;

/**
 * Created by user on 10/15/15.
 */
public class MainActivityPresenter {
    private IMainActivityModel mainActivityModel;
    private IMainActivityView mainActivityView;

    public MainActivityPresenter() {
        this(new MainActivityModel());
    }

    public MainActivityPresenter(IMainActivityModel model) {
        this.mainActivityModel = model;
    }

    public void setView(IMainActivityView view){
        this.mainActivityView = view;
    }

    public IMainActivityView getView(){
        return mainActivityView;
    }

    public void checkUpdate(){
        if (mainActivityModel != null){
            mainActivityModel.checkUpdate(new Listener() {
                @Override
                public void onSuccess(Object o) {
                    mainActivityView.intoIndexFragment();
                }
            });
        }
    }

    public void destroy(){
        if (mainActivityModel!=null){
            mainActivityModel.destroy();
        }
    }
}
