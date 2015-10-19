package tw.com.knorr.activity.model.impl;

import com.tony.volleydemo.http.core.Listener;
import com.tony.volleydemo.http.core.Request;
import com.tony.volleydemo.http.request.StringRequest;
import com.tony.volleydemo.http.utils.VolleyPlus;

import tw.com.knorr.activity.model.IMainActivityModel;

/**
 * Created by user on 10/15/15.
 */
public class MainActivityModel implements IMainActivityModel {
    StringRequest request;
    @Override
    public void checkUpdate(Listener listener) {
        request = new StringRequest(Request.Method.GET, "http://www.baidu.com", listener);
        VolleyPlus.getRequestQueue().add(request);
    }

    @Override
    public void pushGcmRegisterId() {

    }

    @Override
    public void destroy() {
        if (request != null){
            request.cancel();
        }
    }
}
