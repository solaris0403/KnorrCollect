package tw.com.knorr.app;

import android.app.Application;

import com.tony.volleydemo.http.utils.VolleyPlus;

/**
 * Created by user on 10/15/15.
 */
public class KnorrApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        VolleyPlus.init(this);
    }
}
