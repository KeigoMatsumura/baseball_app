package baseball.player;

/**
 * ピッチャーを表すクラスです
 */
public class Pitcher extends Player {

	/**
	 * 勝利数を表します．
	 */
	private int win;
	
	/**
	 * 敗戦数を表します．
	 */
	private int loss;
	
	/**
	 * セーブ数を表します．
	 */
	private int save; 
	
	/**
	 * ホールドポイントを表します．
	 */
	private int hp; 
	
	/**
	 * アウトを取った数を表します．防御率の計算に使用します．
	 */
	private int out;
	
	/**
	 * 自責点を表します．防御率の計算に使用します．
	 */
	private int er;
	
	
	// 防御率，勝率は上記フィールドから計算

	/**
	 * Pitcherクラスのコンストラクタです．引数は，親クラスまたは本クラスの同じ名前のフィールドに対応します．
	 * ただし，引数の型はString型で，ほとんどのフィールドはint型などでString型ではありません．
	 * そのため，フィールドに代入するには型変換の必要があります．
	 * 
	 * @param name
	 * @param team
	 * @param hand
	 * @param game
	 * @param win
	 * @param loss
	 * @param save
	 * @param hp
	 * @param out
	 * @param er
	 */
	public Pitcher(String name, String team, String hand, String game, String win, 
			String loss, String save, String hp, String out, String er) {

		super(name, team, hand, game);
		this.win = Integer.parseInt(win);
		this.loss = Integer.parseInt(loss);
		this.save = Integer.parseInt(save);
		this.hp = Integer.parseInt(hp);
		this.out = Integer.parseInt(out);
		this.er = Integer.parseInt(er);

	}

	/**
	 * フィールドwinのゲッターです．
	 * @return
	 */
	public int getWin() {
		return this.win;
	}

	/**
	 * フィールドlossのゲッターです．
	 * @return
	 */
	public int getLoss() {
		return this.loss;
	}

	/**
	 * フィールドsaveのゲッターです．
	 * @return
	 */
	public int getSave() {
		return this.save;
	}

	/**
	 * フィールドhpのゲッターです．
	 * @return
	 */
	public int getHp() {
		return this.hp;
	}
	
	/**
	 * 防御率を求めます．
	 * @return
	 */
	public double getEra() {

		double ret;

		if (out == 0)
			ret = -1.0;
		else
			ret = (double) (er * 27) / (double) out;

		return ret;
	}
	
	/**
	 * 勝率を求めます．
	 * @return
	 */
	public double getPercentage() {

		double ret;

		if (win + loss == 0)
			ret = 0.0;
		else
			ret = (double) win / (double) (win + loss);

		return ret;
	}

	/**
	 * フィールドoutのゲッターです．
	 * @return
	 */
	public int getOut() {
		return this.out;
	}

	/**
	 * フィールドerのゲッターです．
	 * @return
	 */
	public int getEr() {
		return this.er;
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
		if (this.hand == 0)
			ret = "右投げ";
		else if (this.hand == 1)
			ret = "左投げ";
		else if (this.hand == 2)
			ret = "両投げ";
		*/
		if (this.hand == Hand.RIGHT)
			ret = "右投げ";
		else if (this.hand == Hand.LEFT)
			ret = "左投げ";
		else if (this.hand == Hand.SWITCH)
			ret = "両投げ";

		return ret;
	}

	/**
	 * 成績の表記を記述します．
	 * 
	 * @return 表示される文字列
	 */
	@Override
	protected String toStringStatics() {
		return String.format("%d試合, %d勝, %d敗, %dセーブ, %dHP, "
				+ "防御率%.2f, 勝率%.3f", getGame(),
				getWin(), getLoss(), getSave(), getHp(), getEra(), getPercentage());
	}

	
}