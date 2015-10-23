package tw.com.knorr.fragment.model.impl;

import com.tony.volleydemo.http.core.Listener;
import com.tony.volleydemo.http.core.Request;
import com.tony.volleydemo.http.request.StringRequest;
import com.tony.volleydemo.http.utils.VolleyPlus;

import tw.com.knorr.fragment.model.ILaunchModel;

/**
 * Created by user on 10/19/15.
 */
public class LaunchModel implements ILaunchModel {
    StringRequest updateRequest, pushRequest;

    @Override
    public void checkUpdate(Listener listener) {
        updateRequest = new StringRequest(Request.Method.GET, "http://www.baidu.com", listener);
        VolleyPlus.getRequestQueue().add(updateRequest);
    }

    @Override
    public void pushGCMRegisterId(Listener listener) {
        pushRequest = new StringRequest(Request.Method.GET, "http://www.baidu.com", listener);
        VolleyPlus.getRequestQueue().add(pushRequest);
    }

    @Override
    public void destroy() {
        if (updateRequest != null) updateRequest.cancel();
        if (pushRequest != null) pushRequest.cancel();
    }
}
