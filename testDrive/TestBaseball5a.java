package baseball.testDrive;

import baseball.League;
import baseball.PlayerType;
import baseball.SetPlayers;
import baseball.SetPlayersInterface;

/*
 * PlayersDataの動作を小さいデータベースで確認するテストプログラム
 */
public class TestBaseball5a {

	public static void main(String[] args){

		SetPlayersInterface sp = new SetPlayers();
		sp.scanPlayers("TestBaseball3pitcher.csv","TestBaseball3batter.csv");

		sp.setLeague(League.BOTH, PlayerType.BOTH); // 全Player, PitcherとBatter
		sp.dumpResult("outputTestBaseball5a1.csv");

		sp.setLeague(League.CENTRAL, PlayerType.BATTER); // セリーグ, Batter
		sp.dumpResult("outputTestBaseball5a2.csv");

		sp.setLeague(League.PACIFIC, PlayerType.PITCHER); // パリーグ, Pitcher
		sp.dumpResult("outputTestBaseball5a3.csv");
	}
}
