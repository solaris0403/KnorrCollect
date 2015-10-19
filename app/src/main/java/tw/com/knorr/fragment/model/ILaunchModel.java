package tw.com.knorr.fragment.model;

import com.tony.volleydemo.http.core.Listener;

/**
 * Created by user on 10/19/15.
 */
public interface ILaunchModel {
    public void checkUpdate(Listener listener);
    public void pushGCMRegisterId(Listener listener);
}
