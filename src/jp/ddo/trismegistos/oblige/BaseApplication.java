package jp.ddo.trismegistos.oblige;

import jp.ddo.trismegistos.oblige.holder.ApplicationHolder;
import android.app.Application;
import android.util.Log;

/**
 * Applicationの基底クラス.
 * 
 * @author y_sugasawa
 * @since 2012/07/01
 */
public class BaseApplication extends Application {

	/** タグ */
	private static final String TAG = "BaseAppication";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onCreate() {
		Log.d(TAG, "onCreate()");
		ApplicationHolder.set(this);
	}
}
