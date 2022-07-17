package baseball.player;

/**
 * バッターを表すクラスです
 */

public class Batter extends Player {

	/**
	 * 打席数を表します．
	 */
	private int pa;

	/**
	 * 打数を表します．打率などのソートをするときに使用します．
	 */
	private int atBat;

	/**
	 * 安打数を表します．
	 */
	private int hit;

	/**
	 * 2塁打の数を表します．長打率の計算に使用します．
	 */
	private int twoBaseHit;

	/**
	 * 3塁打の数を表します．長打率の計算に使用します．
	 */
	private int threeBaseHit;

	/**
	 * 本塁打の数を表します．
	 */
	private int homerun;

	/**
	 * 打点を表します．
	 */
	private int rbi;

	/**
	 * 三振の数を表します．
	 */
	private int strikeOut;

	// 打率, 長打率は上記フィールドから計算

	/**
	 * Batterクラスのコンストラクタです．引数は，親クラスまたは本クラスの同じ名前のフィールドに対応します．
	 * ただし，引数の型はString型で，ほとんどのフィールドはint型などでString型ではありません．
	 * そのため，フィールドに代入するには型変換の必要があります．
	 *
	 * @param name
	 * @param team
	 * @param hand
	 * @param game
	 * @param pa
	 * @param atBat
	 * @param hit
	 * @param twoBaseHit
	 * @param threeBaseHit
	 * @param homerun
	 * @param rbi
	 * @param strikeOut
	 */
	public Batter(String name, String team, String hand, String game,
			String pa, String atBat, String hit, String twoBaseHit,
			String threeBaseHit, String homerun, String rbi,
			String strikeOut) {

		super(name, team, hand, game);
		this.pa = Integer.parseInt(pa);
		this.atBat = Integer.parseInt(atBat);
		this.hit = Integer.parseInt(hit);
		this.twoBaseHit = Integer.parseInt(twoBaseHit);
		this.threeBaseHit = Integer.parseInt(threeBaseHit);
		this.homerun = Integer.parseInt(homerun);
		this.rbi = Integer.parseInt(rbi);
		this.strikeOut = Integer.parseInt(strikeOut);

	}

	/**
	 * 打率を求めます．
	 * @return
	 */
	public double getAverage() {

		double ret;

		if(atBat == 0) ret = 0.0;
		else ret = (double) hit / (double) atBat;

		return ret;
	}

	/**
	 * フィールドpaのゲッターです．
	 * @return
	 */
	public int getPa() {
		return this.pa;
	}


	/**
	 * フィールドhitのゲッターです．
	 * @return
	 */
	public int getHit() {
		return this.hit;
	}

	/**
	 * フィールドhomerunのゲッターです．
	 * @return
	 */
	public int getHomerun() {
		return this.homerun;
	}

	/**
	 * フィールドrbiのゲッターです．
	 * @return
	 */
	public int getRbi() {
		return this.rbi;
	}

	/**
	 * フィールドstrikeOutのゲッターです．
	 * @return
	 */
	public int getStrikeOut() {
		return this.strikeOut;
	}

	/**
	 * 長打率を求めます．
	 * @return
	 */
	public double getSlg() {

		double ret = 0.0;

		if(atBat == 0) ret = 0.0;
		else{
			int tb = hit + twoBaseHit + threeBaseHit*2 + homerun*3; // 塁打
			ret = (double) tb / (double) atBat;
		}

		return ret;
	}


	/**
	 * 利き手の表記を記述します．
	 *
	 * @return 表示される文字列
	 */
	@Override
	protected String toStringHand() {

		String ret = null;
		/* 変更前
		if (hand == 0)
			ret = "右打ち";
		else if (hand == 1)
			ret = "左打ち";
		else if (hand == 2)
			ret = "両打ち";
		*/
		if (hand == Hand.RIGHT)
			ret = "右打ち";
		else if (hand == Hand.LEFT)
			ret = "左打ち";
		else if (hand == Hand.SWITCH)
			ret = "両打ち";

		return ret;
	}

	/**
	 * 成績の表記を記述します．
	 *
	 * @return 表示される文字列
	 */
	@Override
	protected String toStringStatics() {
		return String.format("%d試合, 打率%.3f, %d打席, %d安打, %d本塁打, %d打点, %d三振, 長打率%.3f",
				getGame(), getAverage(), getPa(), getHit(), getHomerun(), getRbi(),
						getStrikeOut(), getSlg());
	}
}
