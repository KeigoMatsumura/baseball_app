package baseball.testDrive;

import baseball.League;
import baseball.Order;
import baseball.PlayerType;
import baseball.SetPlayers;
import baseball.SetPlayersInterface;

/*
 * ソートの委譲を実装後に
 * PlayersDataの動作を大きなデータベースで確認するテストプログラム
 */
public class TestBaseball5c {

	public static void main(String[] args){

		SetPlayersInterface sp = new SetPlayers();
		sp.scanPlayers("pitchers.csv", "batters.csv");

		sp.setLeague(League.BOTH, PlayerType.BOTH); // 全Player, PitcherとBatter
		sp.sort(Order.GAME); // 試合数順に並び替え
		sp.dumpResult("outputTestBaseball5c1.csv");

		sp.setLeague(League.PACIFIC, PlayerType.BATTER); // パリーグ, Batter
		sp.sort(Order.SLG); // 長打率順に並び替え
		sp.dumpResult("outputTestBaseball5c2.csv");

		sp.clearPlayers(); // selectedPlayersを初期化
		sp.setLeague(League.PACIFIC, PlayerType.BATTER); // パリーグ, Batter
		sp.sort(Order.HOMERUN); // 本塁打数順に並び替え
		sp.dumpResult("outputTestBaseball5c3.csv");

		sp.setLeague(League.PACIFIC, PlayerType.PITCHER); // パリーグ, Pitcher
		sp.sort(Order.SAVE); // セーブ数順に並び替え
		sp.dumpResult("outputTestBaseball5c4.csv");

		sp.sort(Order.PERCENTAGE); // 勝率順に並び替え
		sp.dumpResult("outputTestBaseball5c5.csv");

		sp.setLeague(League.CENTRAL, PlayerType.BATTER); // セリーグ, Batter
		sp.sort(Order.AVERAGE); // 打率順に並び替え
		sp.dumpResult("outputTestBaseball5c6.csv");

		sp.sort(Order.STRIKE_OUT); // 三振数順に並び替え
		sp.dumpResult("outputTestBaseball5c7.csv");

		sp.sort(Order.HIT); // 安打数順に並び替え
		sp.dumpResult("outputTestBaseball5c8.csv");

		sp.setLeague(League.CENTRAL, PlayerType.PITCHER); // セリーグ, Pitcher
		sp.sort(Order.ERA); // 防御率順に並び替え
		sp.dumpResult("outputTestBaseball5c9.csv");

		sp.sort(Order.WIN); // 勝利数順に並び替え
		sp.dumpResult();

	}

}
