package tw.com.knorr.util;

import android.util.Log;

/**
 * Log封装类
 */
public class LogUtils {
	private static boolean isDebug = true;
	private static String TAG = LogUtils.class.getSimpleName();

	public static void i(Object str) {
		if (isDebug)
			Log.i(TAG, str.toString());
	}

	public static void i(String tag, Object str) {
		if (isDebug) {
			Log.i(tag, str.toString());
		}
	}

	public static void d(Object str) {
		if (isDebug) {
			Log.d(TAG, str.toString());
		}
	}

	public static void d(String tag, Object str) {
		if (isDebug) {
			Log.d(tag, str.toString());
		}
	}

	public static void v(Object str) {
		if (isDebug) {
			Log.v(TAG, str.toString());
		}
	}

	public static void v(String tag, Object str) {
		if (isDebug) {
			Log.v(tag, str.toString());
		}
	}

	public static void w(Object str) {
		if (isDebug) {
			Log.w(TAG, str.toString());
		}
	}

	public static void w(String tag, Object str) {
		if (isDebug) {
			Log.w(tag, str.toString());
		}
	}

	public static void e(Object str) {
		if (isDebug) {
			Log.e(TAG, str.toString());
		}
	}

	public static void e(String tag, Object str) {
		if (isDebug) {
			Log.e(tag, str.toString());
		}
	}
}
