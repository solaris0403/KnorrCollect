package tw.com.knorr.activity.presenter;

import tw.com.knorr.activity.model.IMainActivityModel;
import tw.com.knorr.activity.model.impl.MainActivityModel;
import tw.com.knorr.activity.view.IMainActivityView;

/**
 * Created by user on 10/15/15.
 */
public class MainActivityPresenter {
    private IMainActivityView mainActivityView;
    private IMainActivityModel mainActivityModel;

    public MainActivityPresenter() {
        this(new MainActivityModel());
    }

    public MainActivityPresenter(IMainActivityModel mainActivityModel) {
        this.mainActivityModel = mainActivityModel;
    }

    public IMainActivityView getMainActivityView() {
        return mainActivityView;
    }

    public void setMainActivityView(IMainActivityView mainActivityView) {
        this.mainActivityView = mainActivityView;
    }

    /**
     * 设置选择的tab
     * @param tab
     */
    public void setTab(int tab){
        if (mainActivityModel!=null){
            mainActivityView.setSelectedTab(tab);
        }
    }
}
