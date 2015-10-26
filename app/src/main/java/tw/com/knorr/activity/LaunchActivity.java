package tw.com.knorr.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.google.android.gcm.GCMRegistrar;
import com.google.android.gcm.GCMUtils;

import tw.com.knorr.R;
import tw.com.knorr.fragment.LaunchFragment;
import tw.com.knorr.main.BaseActivity;

import static tw.com.knorr.activity.CommonUtilities.DISPLAY_MESSAGE_ACTION;
import static tw.com.knorr.activity.CommonUtilities.EXTRA_MESSAGE;
import static tw.com.knorr.activity.CommonUtilities.SENDER_ID;

/**
 * 程序启动界面
 */
public class LaunchActivity extends BaseActivity{
    private FragmentManager fm;
    private LaunchFragment launchFragment;
    private GCMUtils gcm;

    private final static String TAG = GCMUtils.class.getName();
    private LaunchActivity mContext;
    AsyncTask<Void, Void, Void> mRegisterTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        fm = getSupportFragmentManager();
        if (launchFragment == null){
            launchFragment = new LaunchFragment();
        }
        fm.beginTransaction().add(R.id.fragment_container, launchFragment).show(launchFragment).commit();

        checkNotNull(SENDER_ID, "SENDER_ID");
        // Make sure the device has the proper dependencies.
        GCMRegistrar.checkDevice(this);
        // Make sure the manifest was properly set - comment out this line
        // while developing the app, then uncomment it when it's ready.
        GCMRegistrar.checkManifest(this);
        this.registerReceiver(mHandleMessageReceiver, new IntentFilter(DISPLAY_MESSAGE_ACTION));
        final String regId = GCMRegistrar.getRegistrationId(this);
        CommonUtilities.displayMessage(this, "regId:" + regId + "\n");
        if (regId.equals("")) {
            // Automatically registers application on startup.
            GCMRegistrar.register(this, SENDER_ID);
        } else {
            // Device is already registered on GCM, check server.
            if (GCMRegistrar.isRegisteredOnServer(this)) {
                // Skips registration.
                //mDisplay.append(getString(R.string.already_registered) + "\n");
            }
//			} else {
//				// Try to register again, but not in the UI thread.
//				// It's also necessary to cancel the thread onDestroy(),
//				// hence the use of AsyncTask instead of a raw thread.
//				final Context context = this;
//				mRegisterTask = new AsyncTask<Void, Void, Void>() {
//					@Override
//					protected Void doInBackground(Void... params) {
//						boolean registered = ServerUtilities.register(context, regId);
//						// At this point all attempts to register with the app
//						// server failed, so we need to unregister the device
//						// from GCM - the app will try to register again when
//						// it is restarted. Note that GCM will send an
//						// unregistered callback upon completion, but
//						// GCMIntentService.onUnregistered() will ignore it.
//						if (!registered) {
//							GCMRegistrar.unregister(context);
//						}
//						return null;
//					}
//
//					@Override
//					protected void onPostExecute(Void result) {
//						mRegisterTask = null;
//					}
//
//				};
//		//		mRegisterTask.execute(null, null, null);
//			}
        }
    }

    private void checkNotNull(Object reference, String name) {
        if (reference == null) {
            throw new NullPointerException(this.getString(R.string.error_config, name));
        }
    }
    private final BroadcastReceiver mHandleMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String newMessage = intent.getExtras().getString(EXTRA_MESSAGE);
//            mDisplay.append(newMessage + "\n");
            Log.i(TAG, newMessage + "\n");
        }
    };

    @Override
    protected void onDestroy() {
        if (mRegisterTask != null) {
            mRegisterTask.cancel(true);
        }
        mContext.unregisterReceiver(mHandleMessageReceiver);
        GCMRegistrar.onDestroy(this);

        super.onDestroy();
    }
}
