package baseball.player;

/**
 * 利き腕の種別を持つ列挙型です．
 *
 */
public enum Hand {

	/** 右投げ（右打ち）を表す識別子です． */
	RIGHT("0"),
	/** 左投げ（左打ち）を表す識別子です． */
	LEFT("1"),
	/** 両投げ（両打ち）を表す識別子です． */
	SWITCH("2");

	/**
	 * このフィールドは，各識別子のデータベース内での整数値を表します．
	 */
	private final String id;

	/**
	 * Handのコンストラクタです．フィールドidを設定します．
	 * 
	 * @param id
	 */
	private Hand(String id) {
		this.id = id;
	}

	/**
	 * String型引数に対して，対応するHand種別を戻します．
	 * 
	 * @param id
	 * @return 対応するHandです．
	 */
	public static Hand parseHand(String id) {
		Hand ret = null;
		for (Hand h : values()) {
			if (h.getId().equals(id)) {
				ret = h;
			}
		}
		return ret;
	}

	/**
	 * フィールドidのゲッターです．メソッドparseHandで使うプライベートメソッドです．
	 * 
	 * @return
	 */
	private String getId() {
		return id;
	}

}
