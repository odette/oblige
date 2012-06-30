package jp.ddo.trismegistos.oblige.controller;

/**
 * ルーティング情報を集約するクラスの基底クラス。
 * 
 * @author y_sugasawa
 * @since 2012/07/01
 */
public abstract class Controller {

	/** 遷移する場合の定数 */
	public static final int MOVE = 0;

	/** 遷移しない場合の定数 */
	public static final int NO_MOVE = 1;
}
