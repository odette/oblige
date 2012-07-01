package jp.ddo.trismegistos.oblige.transaction;

/**
 * トランザクションの抽象クラス.
 * 
 * @author y_sugasawa
 * @since 2012/06/27
 */
public interface Transaction {

	/**
	 * トランザクションを開始する.
	 */
	public void begin();
}
