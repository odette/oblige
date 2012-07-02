package jp.ddo.trismegistos.oblige;

import android.app.Activity;
import android.content.Intent;

/**
 * アクティビティを実行するクラス.
 * 
 * @author y_sugasawa
 * @since 2012/06/27
 */
public class Router {

	/**
	 * アクティビティを実行する.
	 * 
	 * @param fromActivity 遷移元アクティビティ
	 * @param toActivity 遷移先アクティビティ
	 * @param src インテント
	 */
	public static void go(final Activity fromActivity, final Class<? extends Activity> toActivity, final Intent src) {
		fromActivity.startActivity(getIntent(fromActivity, toActivity, src));
	}

	/**
	 * アクティビティを起動モード付きで実行する.
	 * 
	 * @param fromActivity 遷移元アクティビティ
	 * @param toActivity 遷移先アクティビティ
	 * @param src インテント
	 * @param flags 起動モード
	 */
	public static void go(final Activity fromActivity, final Class<? extends Activity> toActivity, final Intent src,
			final int flags) {
		final Intent intent = getIntent(fromActivity, toActivity, src);
		intent.setFlags(flags);
		fromActivity.startActivity(intent);
	}

	/**
	 * アクティビティを実行する.<br>
	 * 実行後に遷移元サクティビティを終了する.
	 * 
	 * @param fromActivity 遷移元アクティビティ
	 * @param toActivity 遷移先アクティビティ
	 * @param src インテント
	 */
	public static void goAfterEnd(final Activity fromActivity, final Class<? extends Activity> toActivity,
			final Intent src) {
		go(fromActivity, toActivity, src);
		fromActivity.finish();
	}

	/**
	 * アクティビティを実行する.<br>
	 * 遷移先から情報を受け取って処理を戻す場合はこれを使用する.
	 * 
	 * @param fromActivity 遷移元アクティビティ
	 * @param toActivity 遷移先アクティビティ
	 * @param src インテント
	 * @param requestCode リクエストコード
	 */
	public static void goForResult(final Activity fromActivity, final Class<? extends Activity> toActivity,
			final Intent src, final int requestCode) {
		fromActivity.startActivityForResult(getIntent(fromActivity, toActivity, src), requestCode);
	}

	/**
	 * インテントを作成する.
	 * 
	 * @param fromActivity 遷移元アクティビティ
	 * @param toActivity 遷移先アクティビティ
	 * @param src インテント
	 * @return インテント
	 */
	private static Intent getIntent(final Activity fromActivity, final Class<? extends Activity> toActivity,
			final Intent src) {
		final Intent intent = new Intent(fromActivity, toActivity);
		intent.putExtras(src);

		return intent;
	}
}
