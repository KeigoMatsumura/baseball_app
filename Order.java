package baseball;

/**
 * どの成績の順でソートするかを表すための列挙型です．
 *
 */

import java.util.ArrayList;
import java.util.Iterator;

import baseball.player.Batter;
import baseball.player.Pitcher;
import baseball.player.Player;
import baseball.sorting.InsertionSort;
import baseball.sorting.MergeSort;
import baseball.sorting.Sort;

public enum Order {

	/** ソートをしないときに選択します．文字列は何も返しません． */
	NONE(0, null) {
		@Override
		public double comparator(Player p1, Player p2) {
			return 0;
		}
		public String toString() {
			return "";
		}

	},
	/** 試合数順に降順ソートするときに選択します．文字列は"descending game order"を返します． */
	GAME(0, new MergeSort()) {
		public double comparator(Player p1, Player p2) {
			return ((Player) p2).getGame() - ((Player) p1).getGame(); // 多い方が前;
		}

		public String toString() {
			return "descending game order";
		}
	},
	/** Pitcherを勝利数順に降順ソートするときに選択します．文字列は"descending win order"を返します． */
	WIN(0, new MergeSort()) {
		public double comparator(Player p1, Player p2) {
			return ((Pitcher) p2).getWin() - ((Pitcher) p1).getWin(); // 多い方が前;
		}

		public String toString() {
			return "descending win order";
		}
	},
	/** Pitcherを敗戦数順に降順ソートするときに選択します．文字列は"descending loss order"を返します． */
	LOSS(0, new MergeSort()) {
		public double comparator(Player p1, Player p2) {
			return ((Pitcher) p2).getLoss() - ((Pitcher) p1).getLoss(); // 多い方が前;
		}

		public String toString() {
			return "descending loss order";
		}
	},
	/** Pitcherをセーブ数順に降順ソートするときに選択します．文字列は"descending save order"を返します． */
	SAVE(0, new MergeSort()) {
		public double comparator(Player p1, Player p2) {
			return ((Pitcher) p2).getSave() - ((Pitcher) p1).getSave(); // 多い方が前;
		}

		public String toString() {

			return "descending save order";
		}
	},
	/** Pitcherをホールドポイントの順に降順ソートするときに選択します．文字列は"descending hp order"を返します． */
	HP(0, new MergeSort()) {
		public double comparator(Player p1, Player p2) {
			return ((Pitcher) p2).getHp() - ((Pitcher) p1).getHp(); // 多い方が前;
		}

		public String toString() {

			return "descending hp order";
		}
	},
	/** Pitcherを防御率の順に昇順ソートするときに選択します．対象にならないPlayer（Pitcher）の判別にアウトを取った数を使います．文字列は"ascending era order"を返します． */
	ERA(432, new InsertionSort()) {
		public double comparator(Player p1, Player p2) {
			return ((Pitcher) p2).getEra() - ((Pitcher) p1).getEra(); // 多い方が前;
		}

		public String toString() {
			return "ascending era order";
		}
		protected int getValue(Player player) {
			return ((Pitcher)player).getOut();
		}
	},
	/** Pitcherを勝率の順に降順ソートするときに選択します．対象にならないPlayer（Pitcher）の判別に勝利数を使います．文字列は"descending winning percentage order"を返します． */
	PERCENTAGE(10, new InsertionSort()) {
		public double comparator(Player p1, Player p2) {
			return ((Pitcher) p2).getPercentage() - ((Pitcher) p1).getPercentage(); // 多い方が前;
		}

		public String toString() {
			return "descending winning percentage order";
		}
		protected int getValue(Player player) {
			return ((Pitcher)player).getWin();
		}
	},
	/** Batterを打率の順に降順ソートするときに選択します．対象にならないPlayer（Batter）の判別に打席数を使います．文字列は"descending average order"を返します． */
	AVERAGE(444, new InsertionSort()) {
		public double comparator(Player p1, Player p2) {
			return ((Batter) p2).getAverage() - ((Batter) p1).getAverage(); // 多い方が前;
		}

		public String toString() {
			return "descending average order";
		}
		protected int getValue(Player player) {
			return ((Batter)player).getPa();
		}
	},
	/** Batterを打席数の順に降順ソートするときに選択します．文字列は"descending pa order"を返します． */
	PA(0, new MergeSort()) {
		public double comparator(Player p1, Player p2) {
			return ((Batter) p2).getPa() - ((Batter) p1).getPa(); // 多い方が前;
		}

		public String toString() {

			return "descending ps order";
		}
	},
	/** Batterを安打数順に降順ソートするときに選択します．文字列は"descending hit order"を返します． */
	HIT(0, new MergeSort()) {
		public double comparator(Player p1, Player p2) {
			return ((Batter) p2).getHit() - ((Batter) p1).getHit(); // 多い方が前;
		}

		public String toString() {
			return "descending hit order";
		}
	},
	/** Batterを本塁打数順に降順ソートするときに選択します．文字列は"descending homerun order"を返します． */
	HOMERUN(0, new MergeSort()) {
		public double comparator(Player p1, Player p2) {
			return ((Batter) p2).getHomerun() - ((Batter) p1).getHomerun(); // 多い方が前;
		}

		public String toString() {
			return "descending homerun order";
		}
	},
	/** Batterを打点順に降順ソートするときに選択します．文字列は"descending rbi order"を返します． */
	RBI(0, new MergeSort()) {
		public double comparator(Player p1, Player p2) {
			return ((Batter) p2).getRbi() - ((Batter) p1).getRbi(); // 多い方が前;
		}

		public String toString() {
			return "descending rbi order";
		}
	},
	/** Batterを三振数順に降順ソートするときに選択します．文字列は"descending strike out order"を返します． */
	STRIKE_OUT(0, new MergeSort()) {
		public double comparator(Player p1, Player p2) {
			return ((Batter) p2).getStrikeOut() - ((Batter) p1).getStrikeOut(); // 多い方が前;
		}

		public String toString() {
			return "descending out order";
		}
	},
	/** Batterを長打率の順に降順ソートするときに選択します．対象にならないPlayer（Batter）の判別に打席数を使います．文字列は"descending slugging percentage order"を返します． */
	SLG(0, new MergeSort()) {
		public double comparator(Player p1, Player p2) {
			return ((Batter) p2).getSlg() - ((Batter) p1).getSlg(); // 多い方が前;
		}

		public String toString() {
			return "descending slugging order";
		}
		protected int getValue(Player player) {
			return ((Batter)player).getPa();
		}
	};

	/**
	 * このフィールドは，ソートアルゴリズムを表します．
	 */
	private Sort sortMethod;

	/**
	 * このフィールドは，規定数（この値より少ない場合は対象外にする）を表します．
	 */
	private int limit;

	/**
	 * Sortのコンストラクタです．フィールドlimit, sortMethodを設定します．
	 *
	 * @param limit　それぞれのOrderのときの規定数（この値より少ない場合は対象外にする）を定めます．
	 * @param sortMethod　それぞれのOrderのときのソートアルゴリズムを定めます．
	 */
	private Order(int limit, Sort sortMethod) {
		this.limit = limit;
		this.sortMethod = sortMethod;
	}

	/**
	 * それぞれのOrderの規定数，ソートアルゴリズムでselectedPlayersのPlayerをソートします．
	 * Pitcherの防御率と勝率，Batterの打率と長打率でソートするとき，対象にならないPlayerを，出力対象Playerを格納するArrayListから削除します．
	 *
	 * @param selectedPlayers　ソート対象の選手のリストを定めます．
	 */
	public void sort(ArrayList<Player> selectedPlayers) {
		if (limit != 0) {
			Iterator<Player> iterator = selectedPlayers.iterator();
			while(iterator.hasNext()) {
				if(getValue(iterator.next()) < limit) {
					iterator.remove();
				}
			}
		}
		if (sortMethod != null) {
			sortMethod.sort(selectedPlayers, this);
		}

	}


	/**
	 * それぞれのOrderの，対象にならないPlayerの判別に用いる，指定されたPlayerの項目の値を返します．
	 *
	 * @param player　Playerを指定します．
	 */
	protected int getValue(Player player) {
		return 0;
	}

	/**
	 * それぞれのOrderの，指定された2つのPlayerの項目の値を，比較した結果を返します．
	 *
	 * @param p1　1人目のPlayerを指定します．
	 * @param p2　2人目のPlayerを指定します．
	 * @return p1の方が前になるときは0より小さく，p2の方が前になるときは0より大きくし，同点（入れ替えなし）の時は0にする．
	 */
	public abstract double comparator(Player p1, Player p2);

	/**
	 * それぞれのOrderの，文字列を返します．
	 *
	 * @return 文字列を返します．
	 */
	public abstract String toString();
}
