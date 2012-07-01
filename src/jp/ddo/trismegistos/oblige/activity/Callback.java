package jp.ddo.trismegistos.oblige.activity;

import java.util.Map;

/**
 * コールバックメソッドを定義するInterface.
 * 
 * @author y_sugasawa
 * @since 2012/07/01
 */
public interface Callback {

	/** 成功時のレスポンスコード */
	public static final int SUCCESS = 0;

	/** 失敗時のレスポンスコード */
	public static final int ERROR = -1;

	/**
	 * コールバックメソッド.
	 * 
	 * @param responseCode レスポンスコード
	 * @param requestCode リクエストコード
	 * @param resultMap 結果
	 */
	public void callback(final int responseCode, final int requestCode, final Map<String, Object> resultMap);
}
