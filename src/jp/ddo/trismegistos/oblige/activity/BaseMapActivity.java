package jp.ddo.trismegistos.oblige.activity;

import jp.ddo.trismegistos.oblige.util.ActivityUtil;
import android.os.Bundle;

import com.google.android.maps.MapActivity;

/**
 * MapActivityの基底クラス.
 * 
 * @author y_sugasawa
 * @since 2012/07/01
 */
public class BaseMapActivity extends MapActivity {

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

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

}
