package baseball.testDrive;

import java.util.ArrayList;
import java.util.List;

import baseball.io.DumpPlayers;
import baseball.player.Batter;
import baseball.player.Pitcher;
import baseball.player.Player;

/*
 * ファイル出力クラスDumpPlayersの動作確認をするための
 * テストプログラム
 */
public class TestBaseball2 {

	public static void main(String[] args) {

		Player[] players = new Player[6];
		players[0] = new Pitcher("大谷　翔平", "f", "0", "21", "10", "4", "0", "1", "420", "29");
		players[1] = new Batter("大谷　翔平", "f", "1", "104", "382", "323", "104", "18", "1", "22", "67", "98");
		players[2] = new Pitcher("和田　毅", "h", "1", "24", "15", "5", "0", "0", "489", "55");
		players[3] = new Batter("金子　侑司", "l", "2", "129", "520", "460", "122", "12", "3", "1", "33", "69");
		players[4] = new Pitcher("マシソン", "g", "0", "70", "8", "4", "1", "49", "240", "21");
		players[5] = new Batter("新井　貴浩", "c", "0", "132", "513", "454", "136", "23", "3", "19", "101", "101");
		List<Player> pList = new ArrayList<Player>();
		for (int i = 0; i < players.length; i++)
			pList.add(players[i]);

		// dumpPlayers(String,ArrayList)による出力
		DumpPlayers.dumpPlayers(pList); 
	}
}
