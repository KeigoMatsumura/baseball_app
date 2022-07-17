package baseball.testDrive;

import java.util.ArrayList;

import baseball.io.DumpPlayers;
import baseball.io.ScanPlayers;
import baseball.player.Player;

/*
 * ファイル入力クラスScanPlayersの動作確認をするための
 * テストプログラム
 */
public class TestBaseball3 {

	public static void main(String[] args) {
		
		ArrayList<Player> aList = new ArrayList<Player>();
		aList.addAll( ScanPlayers.scanPitchers("pitchers.csv") );
		aList.addAll( ScanPlayers.scanBatters("batters.csv") );

		DumpPlayers.dumpPlayers(aList);

	}
}
