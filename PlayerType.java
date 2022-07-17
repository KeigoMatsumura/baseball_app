package baseball;

/**
 * PitcherかBatterかを表す列挙型です．
 *
 */
public enum PlayerType {

	/** PitcherとBatterの両方を対象にする場合に使用します． */
	BOTH, 
	/** Pitcherのみを対象にする場合に使用します． */
	PITCHER, 
	/** Batterのみを対象にする場合に使用します． */
	BATTER, 
	/** 初期設定などで使います．*/
	NONE;
}

