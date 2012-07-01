package jp.ddo.trismegistos.oblige.activity;

import jp.ddo.trismegistos.oblige.util.ActivityUtil;
import android.app.Activity;
import android.os.Bundle;

/**
 * Activityの基底クラス.
 * 
 * @author y_sugasawa
 * @since 2012/06/24
 */
public abstract class BaseNoMapActivity extends Activity {

	/** ActivityUtil */
	protected ActivityUtil acu = new ActivityUtil();

	/**
	 * 基底処理の他にレイアウトIDの設定を行う.<br>
	 * {@inheritDoc}
	 */
	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		acu.drawView(this);
	}

}
