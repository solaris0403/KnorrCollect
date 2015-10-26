package com.google.android.gcm;

/**
 * Created by user on 10/23/15.
 */
public class GCMUtils {
//    private final static String lancherActivityClassName = LaunchActivity.class.getName();
//    private final static String TAG = GCMUtils.class.getName();
//    private LaunchActivity mContext;
//    AsyncTask<Void, Void, Void> mRegisterTask;
//    public GCMUtils(LaunchActivity context){
//        this.mContext = context;
//    }
//    /**
//     * 初始化
//     */
//    public void init(String sender_id){
//        checkNotNull(SENDER_ID, "SENDER_ID");
//        // Make sure the device has the proper dependencies.
//        GCMRegistrar.checkDevice(mContext);
//        // Make sure the manifest was properly set - comment out this line
//        // while developing the app, then uncomment it when it's ready.
//        GCMRegistrar.checkManifest(mContext);
//        mContext.registerReceiver(mHandleMessageReceiver, new IntentFilter(DISPLAY_MESSAGE_ACTION));
//        final String regId = GCMRegistrar.getRegistrationId(mContext);
//        CommonUtilities.displayMessage(mContext, "regId:"+regId+"\n");
//        if (regId.equals("")) {
//            // Automatically registers application on startup.
//            GCMRegistrar.register(mContext, SENDER_ID);
//        } else {
//            // Device is already registered on GCM, check server.
//            if (GCMRegistrar.isRegisteredOnServer(mContext)) {
//                // Skips registration.
//                //mDisplay.append(getString(R.string.already_registered) + "\n");
//            }
////			} else {
////				// Try to register again, but not in the UI thread.
////				// It's also necessary to cancel the thread onDestroy(),
////				// hence the use of AsyncTask instead of a raw thread.
////				final Context context = this;
////				mRegisterTask = new AsyncTask<Void, Void, Void>() {
////					@Override
////					protected Void doInBackground(Void... params) {
////						boolean registered = ServerUtilities.register(context, regId);
////						// At this point all attempts to register with the app
////						// server failed, so we need to unregister the device
////						// from GCM - the app will try to register again when
////						// it is restarted. Note that GCM will send an
////						// unregistered callback upon completion, but
////						// GCMIntentService.onUnregistered() will ignore it.
////						if (!registered) {
////							GCMRegistrar.unregister(context);
////						}
////						return null;
////					}
////
////					@Override
////					protected void onPostExecute(Void result) {
////						mRegisterTask = null;
////					}
////
////				};
////		//		mRegisterTask.execute(null, null, null);
////			}
//        }
//    }
//    private void checkNotNull(Object reference, String name) {
//        if (reference == null) {
//            throw new NullPointerException(mContext.getString(R.string.error_config, name));
//        }
//    }
//    private final BroadcastReceiver mHandleMessageReceiver = new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            String newMessage = intent.getExtras().getString(EXTRA_MESSAGE);
////            mDisplay.append(newMessage + "\n");
//            Log.i(TAG, newMessage + "\n");
//        }
//    };
//
//    public void onDestroy(){
//        if (mRegisterTask != null) {
//            mRegisterTask.cancel(true);
//        }
//        mContext.unregisterReceiver(mHandleMessageReceiver);
//        GCMRegistrar.onDestroy(mContext);
//    }
}
