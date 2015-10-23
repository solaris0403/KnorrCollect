package tw.com.knorr.fragment.presenter;

import tw.com.knorr.fragment.model.ICaptureModel;
import tw.com.knorr.fragment.model.impl.CaptureModel;
import tw.com.knorr.fragment.view.ICaptureView;

/**
 * Created by user on 10/23/15.
 */
public class CapturePresenter {
    private ICaptureModel captureModel;
    private ICaptureView captureView;
    public CapturePresenter(){
        this(new CaptureModel());
    }

    public CapturePresenter(ICaptureModel captureModel){
        this.captureModel = captureModel;
    }

    public void setCaptureView(ICaptureView captureView) {
        this.captureView = captureView;
    }

    public ICaptureView getCaptureView() {
        return captureView;
    }
}
