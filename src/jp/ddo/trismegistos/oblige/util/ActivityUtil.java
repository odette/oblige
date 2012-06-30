package jp.ddo.trismegistos.oblige.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.app.ProgressDialog;
import android.util.Log;

/**
 * Activityに関するUtilメソッドの集合クラス。
 * 
 * @author y_sugasawa
 * @since 2012/07/01
 */
public class ActivityUtil {

	/** タグ */
	private static final String TAG = "ActivityUtil";

	/**
	 * Activity名からレイアウトIDを取得し、Activityに設定する。<br>
	 * (例) DbInitActivity → db_init.xml
	 * 
	 * @param activity アクティビティ
	 */
	public void drawView(final Activity activity) {

		final String activityName = activity.getClass().getSimpleName();
		final Pattern activityNamePattern = Pattern.compile("Activity$");
		final Matcher matcher = activityNamePattern.matcher(activityName);
		final String basicName = matcher.replaceFirst("");

		final StringBuilder sb = new StringBuilder();
		final int length = basicName.length();
		boolean isBeforeUpper = false;

		for (int i = 0; i < length; i++) {
			Character c = basicName.charAt(i);
			if (Character.isUpperCase(c)) {
				if (i > 0 && isBeforeUpper) {
					sb.append("_");
				}
				c = Character.toLowerCase(c);
				isBeforeUpper = true;
			} else {
				isBeforeUpper = false;
			}
			sb.append(c);
		}

		final String xmlName = sb.toString();
		Log.d(TAG, "XML fielName is " + xmlName);

		final int xmlId = activity.getResources().getIdentifier(xmlName, "layout", activity.getPackageName());
		activity.setContentView(xmlId);
	}

	/** 読込中ダイアログ(くるくる) */
	private ProgressDialog loadingDialog;

	/**
	 * 読込中ダイアログを表示する.
	 * 
	 * @param activity アクティビティ
	 * @param message メッセージ
	 */
	protected void dispLoadingDialog(final Activity activity, final String message) {
		if (loadingDialog == null || loadingDialog.isShowing() == false) {
			loadingDialog = new ProgressDialog(activity);
			loadingDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			loadingDialog.setMessage(message);
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
}
