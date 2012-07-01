package jp.ddo.trismegistos.oblige.holder.exception;

/**
 * Holderクラスで発生するException.
 * 
 * @author y_sugasawa
 * @since 2012/06/28
 */
public class HolderException extends RuntimeException {

	/** ID */
	private static final long serialVersionUID = 1L;

	/**
	 * コンストラクタ.
	 */
	public HolderException() {
		super();
	}

	/**
	 * コンストラクタ.
	 * 
	 * @param message メッセージ
	 */
	public HolderException(final String message) {
		super(message);
	}

	/**
	 * コンストラクタ.
	 * 
	 * @param message メッセージ
	 * @param cause 原因
	 */
	public HolderException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * コンストラクタ.
	 * 
	 * @param cause 原因
	 */
	public HolderException(final Throwable cause) {
		super(cause);
	}
}
