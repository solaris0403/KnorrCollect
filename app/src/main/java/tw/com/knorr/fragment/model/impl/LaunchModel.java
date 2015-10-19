package tw.com.knorr.fragment.model.impl;

import com.tony.volleydemo.http.core.Listener;
import com.tony.volleydemo.http.core.Request;
import com.tony.volleydemo.http.request.JsonObjectRequest;
import com.tony.volleydemo.http.request.JsonRequest;
import com.tony.volleydemo.http.utils.VolleyPlus;

import tw.com.knorr.fragment.model.ILaunchModel;

/**
 * Created by user on 10/19/15.
 */
public class LaunchModel implements ILaunchModel {
    JsonRequest request;

    @Override
    public void checkUpdate(Listener listener) {
        request = new JsonObjectRequest(Request.Method.GET, "http://www.baidu.com", null, listener);
        VolleyPlus.getRequestQueue().add(request);
    }

    @Override
    public void pushGCMRegisterId(Listener listener) {

    }
}
