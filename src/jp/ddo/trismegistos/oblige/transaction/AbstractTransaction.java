package jp.ddo.trismegistos.oblige.transaction;

import java.util.HashMap;
import java.util.Map;

import jp.ddo.trismegistos.oblige.activity.Callback;
import android.os.AsyncTask;

/**
 * ビジネスロジックを実行するクラスの抽象クラス.<br>
 * 使用するデータは実装クラスのコンストラクタで受け取って使用すること.<br>
 * また、戻り値はフィールドのresultMapがコールバックの引数になる.
 * 
 * @author y_sugasawa
 * @since 2012/07/01
 */
public abstract class AbstractTransaction extends AsyncTask<Void, Void, Integer> implements Transaction {

	/** コールバック */
	protected Callback act;

	/** リクエストコード */
	private int requestCode;

	/** 結果格納用Map */
	protected Map<String, Object> resultMap;

	/**
	 * コンストラクタ.
	 * 
	 * @param act コールバック
	 * @param requestCode レクエストコード
	 */
	public AbstractTransaction(final Callback act, final int requestCode) {
		this.act = act;
		this.requestCode = requestCode;
		resultMap = new HashMap<String, Object>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void begin() {
		execute();
	}

	/**
	 * バックグラウンド処理.<br>
	 * 実際の処理内容はgo()メソッドに記述すること.<br>
	 * {@inheritDoc}
	 */
	@Override
	protected Integer doInBackground(Void... params) {
		return go();
	}

	/**
	 * ビズネスロジック.<br>
	 * このメソッドの戻り値がcallbackに渡される.
	 * 
	 * @return 終了ステータスコード
	 */
	abstract int go();

	/**
	 * 終了処理.<br>
	 * {@inheritDoc}
	 * 
	 * @param responseCode 処理の終了ステータス
	 */
	@Override
	protected void onPostExecute(final Integer responseCode) {
		flush(responseCode);
		act.callback(responseCode, requestCode, resultMap);
	}

	/**
	 * 終了処理.<br>
	 * 終了後に処理を行いたい場合はこのメソッドをオーバーライドすること.
	 * 
	 * @param responseCode 処理の終了ステータス
	 */
	protected void flush(final Integer responseCode) {
	}

}
