package baseball.testDrive;

import java.util.ArrayList;
import java.util.List;

import baseball.player.Batter;
import baseball.player.Pitcher;
import baseball.player.Player;

/*
 * Player, Pitcher, Batterクラスのprint文に関するメソッドを含めた
 * 確認をするテストプログラム
 * ポリモフィズムを使っている
 */
public class TestBaseball1b {

	public static void main(String[] args) {

		final int NUMBER = 6;

		List<Boolean> judges = new ArrayList<Boolean>();
		List<String> strings = new ArrayList<String>();
		strings.add("大谷　翔平, (日), 右投げ, 21試合, 10勝, 4敗, 0セーブ, 1HP, 防御率1.86, 勝率0.714");
		strings.add("大谷　翔平, (日), 左打ち, 104試合, 打率0.322, 382打席, 104安打, 22本塁打, 67打点, 98三振, 長打率0.588");
		strings.add("和田　毅, (ソ), 左投げ, 24試合, 15勝, 5敗, 0セーブ, 0HP, 防御率3.04, 勝率0.750");
		strings.add("金子　侑司, (西), 両打ち, 129試合, 打率0.265, 520打席, 122安打, 1本塁打, 33打点, 69三振, 長打率0.311");
		strings.add("マシソン, (巨), 右投げ, 70試合, 8勝, 4敗, 1セーブ, 49HP, 防御率2.36, 勝率0.667");
		strings.add("新井　貴浩, (広), 右打ち, 132試合, 打率0.300, 513打席, 136安打, 19本塁打, 101打点, 101三振, 長打率0.489");

		Player[] players = new Player[NUMBER];
		players[0] = new Pitcher("大谷　翔平", "f", "0", "21", "10", "4", "0", "1", "420", "29");
		players[1] = new Batter("大谷　翔平", "f", "1", "104", "382", "323", "104", "18", "1", "22", "67", "98");
		players[2] = new Pitcher("和田　毅", "h", "1", "24", "15", "5", "0", "0", "489", "55");
		players[3] = new Batter("金子　侑司", "l", "2", "129", "520", "460", "122", "12", "3", "1", "33", "69");
		players[4] = new Pitcher("マシソン", "g", "0", "70", "8", "4", "1", "49", "240", "21");
		players[5] = new Batter("新井　貴浩", "c", "0", "132", "513", "454", "136", "23", "3", "19", "101", "101");

		List<Player> pList = new ArrayList<Player>();
		for (int i = 0; i < NUMBER; i++)
			pList.add(players[i]);

		for (int i = 0; i < NUMBER; i++){// 選手を順に表示

			Player p = pList.get(i);
			String playerData = p.toStringData();
			System.out.printf("(%d) %s\n", i+1, playerData);

			String s = strings.get(i);
			if(playerData.equals(s) )
				judges.add(true);
			else
				judges.add(false);
		}

		System.out.println();

		// 各行の判定結果の表示
		for(int i=0; i<NUMBER; i++){

			String judge;
			if(judges.get(i) == true) judge = "OK";
			else judge = "NG";
			System.out.printf("(%d)%s", i+1, judge);
			if(i!=NUMBER-1) System.out.print(", ");
		}
		System.out.println();
	}
}
