package jp.ddo.trismegistos.oblige.activity;

import jp.ddo.trismegistos.oblige.R;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;

/**
 * Activityの基底クラス。
 * 
 * @author y_sugasawa
 * @since 2012/06/24
 */
public abstract class BaseActivity extends Activity {

	/** 読込中ダイアログ(くるくる) */
	private ProgressDialog loadingDialog;

	/**
	 * レイアウトIDを取得する。
	 * 
	 * @return レイアウトID
	 */
	abstract protected int getLayoutId();

	/**
	 * 基底処理の他にレイアウトIDの設定を行う。<br>
	 * レイアウトIDの設定には<code>BaseActivity#getLayoutId()</code>を使用する.<br>
	 * {@inheritDoc}
	 */
	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getLayoutId());
	}

	/**
	 * 読込中ダイアログを表示する.
	 */
	protected void dispLoadingDialog() {
		if (loadingDialog == null || loadingDialog.isShowing() == false) {
			loadingDialog = new ProgressDialog(this);
			loadingDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			loadingDialog.setMessage(getLoadingMessage());
			loadingDialog.setCancelable(true);
		}

		if (loadingDialog.isShowing() == false) {
			loadingDialog.show();
		}
	}

	/**
	 * 読込中ダイアログを消去する.
	 */
	public void dismissLoadingDialog() {
		if (loadingDialog != null && loadingDialog.isShowing()) {
			loadingDialog.dismiss();
		}
	}

	/**
	 * 読込中ダイアログに使用する文字列を取得する.
	 * 
	 * @return 読込中ダイアログ表示文字列
	 */
	protected String getLoadingMessage() {
		return getString(R.string.loadingMessage);
	}
}
