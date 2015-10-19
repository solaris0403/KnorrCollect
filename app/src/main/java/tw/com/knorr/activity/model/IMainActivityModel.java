package tw.com.knorr.activity.model;

import com.tony.volleydemo.http.core.Listener;

/**
 * Created by user on 10/15/15.
 */
public interface IMainActivityModel {
    public void checkUpdate(Listener listener);
    public void pushGcmRegisterId();
    public void destroy();
}
