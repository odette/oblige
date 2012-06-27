package jp.ddo.trismegistos.oblige.holder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import jp.ddo.trismegistos.oblige.holder.exception.HolderException;
import android.app.Application;

/**
 * アプリケーションを保持するクラス。
 * 
 * @author y_sugasawa
 * @since 2012/06/28
 */
public class ApplicationHolder {

	/** アプリケーションのKEY値 */
	private static final String KEY = "application";

	/** アプリケーション */
	private static final Map<String, Application> holder = new ConcurrentHashMap<String, Application>();

	/**
	 * アプリケーションを取得する。
	 * 
	 * @return アプリケーション
	 */
	public static Application get() {
		if (holder.containsKey(KEY) == false) {
			throw new HolderException(ApplicationHolder.class.getName() + ": does not exist KEY.");
		}
		final Application application = holder.get(KEY);
		if (application == null) {
			throw new HolderException(ApplicationHolder.class.getName() + ": VALUE is null.");
		}
		return application;
	}

	/**
	 * アプリケーションを設定する。
	 * 
	 * @param application アプリケーション
	 */
	public static void set(final Application application) {
		if (application == null) {
			throw new HolderException(ApplicationHolder.class.getName() + ": args ia null.");
		}
		if (holder.containsKey(KEY)) {
			throw new HolderException(ApplicationHolder.class.getName() + ": VALUE is alerdy exist.");
		}
		holder.put(KEY, application);
	}
}
