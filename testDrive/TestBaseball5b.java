package baseball.testDrive;

import baseball.*;

/*
 * PlayersDataの動作を大きなデータベースで確認するテストプログラム
 */
public class TestBaseball5b {

	public static void main(String[] args){
		
		SetPlayersInterface sp = new SetPlayers();
		sp.scanPlayers("pitchers.csv", "batters.csv");
		
		sp.setLeague(League.BOTH, PlayerType.BOTH); // 全Player, PitcherとBatter
		sp.dumpResult("outputTestBaseball5b1.csv");
		
		sp.setLeague(League.CENTRAL, PlayerType.BATTER); // セリーグ, Batter
		sp.dumpResult("outputTestBaseball5b2.csv");
		
		sp.setLeague(League.PACIFIC, PlayerType.PITCHER); // パリーグ, Pitcher
		sp.dumpResult("outputTestBaseball5b3.csv");
	}
	
}
