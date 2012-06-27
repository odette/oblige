package jp.ddo.trismegistos.oblige.controller;

import jp.ddo.trismegistos.oblige.activity.BaseActivity;
import android.app.Activity;

/**
 * シナリオの基底クラス。
 * 
 * @author y_sugasawa
 * @since 2012/06/27
 */
public abstract class Scenario<T> {

	/** アクティビティ */
	private BaseActivity activity;

	/** 遷移先アクティビティ */
	private Class<Activity> toActivity;

	/** データクラス */
	private T info;

	/**
	 * コンストラクタ。
	 * 
	 * @param fromActivity 遷移元アクティビティ
	 * @param toActivity 遷移先アクティビティ
	 */
	public Scenario(final BaseActivity fromActivity, final Class<Activity> toActivity) {
		activity = fromActivity;
		this.toActivity = toActivity;
	}

	/**
	 * アクティビティを取得する。
	 * 
	 * @return アクティビティ
	 */
	public BaseActivity getBaseActivity() {
		return activity;
	}

	/**
	 * データクラスを取得する。
	 * 
	 * @return データクラス
	 */
	public T getInfo() {
		return info;
	}
}
