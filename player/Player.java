package baseball.player;

import java.util.ArrayList;

/**
 * Playerのデータを管理するための抽象クラスです． Pitcherクラス，Batterクラスが継承しています．
 */
public abstract class Player {

	/**
	 * 名前を表します．
	 */
	protected String name;

	 /**
	  * 所属チームをchar型で表します．
	  */
	protected char team;

	/**
	 * 利き腕をenumのHandで表します．
	 */
	protected Hand hand; // 課題13-2(4)ではここをHand型に変えること

	/**
	 * 試合数を表します．
	 */
	protected int game;

	/**
	 * Playerクラスとして共通の部分のフィールドを定めます． 下位クラスから呼び出します．
	 * 各引数はフィールドに対応しますが，name以外は引数とフィールドとで型が異なるので変換が必要です．
	 *
	 * @param name
	 *            名前
	 * @param team
	 *            所属チーム
	 * @param hand
	 *            利き腕
	 * @param game
	 *            試合数
	 */
	public Player(String name, String team, String hand, String game) {
		this.name = name;
		this.team = team.charAt(0);
		this.hand = Hand.parseHand(hand); // 課題13-2(4)ではここを変えること
		this.game = Integer.parseInt(game);

	}

	/**
	 * teamフィールドのゲッター
	 *
	 * @return 所属チームをcharで戻す．
	 */
	public char getTeam() {

		return this.team;
	}

	/**
	 * teamフィールドの値を指定のStringに変換します．
	 *
	 * @return 所属チームをStringで戻す．
	 */
	public String toStringTeam() {

		return Team.toStringTeam(team);

	}

	/**
	 * nameのゲッター
	 *
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * handのゲッター
	 *
	 * @return hand
	 */
	public Hand getHand() {
		return this.hand;
	}

	/**
	 * gameのゲッター
	 *
	 * @return game
	 */
	public int getGame() {
		return this.game;
	}

	/**
	 * 所属チームがパシフィックリーグのチームかを戻します．
	 *
	 * @return 所属チームがパシフィックリーグならtrue
	 */
	public boolean isPacific() {
		return Team.isPacific(team);

	}

	/**
	 * 利き手の表記を，下位クラスPitcherまたはBatterで記述します．
	 *
	 * @return 表示される文字列
	 */
	protected abstract String toStringHand();

	/**
	 * 成績の表記を，下位クラスPitcherまたはBatterで記述します．
	 *
	 * @return 表示される文字列
	 */
	protected abstract String toStringStatics();

	/**
	 * Playerの名前，チーム，利き手，成績をStringで出力します． 利き手，成績の表記は抽象メソッドであり，具体的な記述は下位クラスで行います．
	 *
	 * @return 出力される文字列
	 */
	public String toStringData() { // 選手の名前，チーム，利き手，成績をStringで出力
		return String.format("%s, (%s), %s, %s", this.name, toStringTeam(), toStringHand(), toStringStatics());
	}

	public static ArrayList<Player> parsePlayer(String pitcherFilename) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}


}