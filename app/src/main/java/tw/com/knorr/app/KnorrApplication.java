package tw.com.knorr.app;

import android.app.Application;

import com.tony.volleydemo.http.utils.VolleyPlus;

/**
 * Created by user on 10/15/15.
 */
public class KnorrApplication extends Application {
    private static KnorrApplication instance = new KnorrApplication();

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        VolleyPlus.init(this);
    }

    public static KnorrApplication getInstance() {
        if (instance == null) {
            instance = new KnorrApplication();
        }
        return instance;
    }
}
