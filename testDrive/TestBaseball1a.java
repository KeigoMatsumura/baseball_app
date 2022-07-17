package baseball.testDrive;

import java.util.ArrayList;

import baseball.player.Batter;
import baseball.player.Pitcher;

/*
 * Pitcher, Batterクラスのprint文に関するメソッド以外を
 * 確認するテストプログラム
 */
public class TestBaseball1a {

	public static void main(String[] args) {

		ArrayList<Pitcher> pList = new ArrayList<Pitcher>(); // Pitcher用のArrayList
		ArrayList<Batter> bList = new ArrayList<Batter>(); // Batter用のArrayList

		// PitcherのデータをpListに追加
		Pitcher[] pitchers = new Pitcher[3];
		pitchers[0] = new Pitcher("大谷　翔平", "F", "0", "21", "10", "4", "0", "1", "420", "29");
		pitchers[1] = new Pitcher("マシソン", "G", "0", "70", "8", "4", "1", "49", "240", "21");
		pitchers[2] = new Pitcher("和田　毅", "H", "1", "24", "15", "5", "0", "0", "489", "55");
		for (int i = 0; i < pitchers.length; i++)
			pList.add(pitchers[i]);

		// BatterのデータをbListに追加
		Batter[] batters = new Batter[3];
		batters[0] = new Batter("新井　貴浩", "C", "0", "132", "513", "454", "136", "23", "3", "19", "101", "101");
		batters[1] = new Batter("大谷　翔平", "F", "1", "104", "382", "323", "104", "18", "1", "22", "67", "98");
		batters[2] = new Batter("金子　侑司", "L", "2", "129", "520", "460", "122", "12", "3", "1", "33", "69");
		for (int i = 0; i < batters.length; i++)
			bList.add(batters[i]);

		for (Pitcher p : pList){
			System.out.printf("%sは%d試合で%d勝，%dホールドポイントをあげています。\n", p.getName(), p.getGame(), ((Pitcher) p).getWin(),
					((Pitcher) p).getSave());
		}
		// 以下のfor文内では，ヒントのためにString.formatメソッドを使っています．
		for (Batter b : bList){
			String str = String.format("%sは%d試合で%d安打，%d本塁打をあげています。\n", b.getName(), b.getGame(), ((Batter)b).getHit(),
					((Batter) b).getHomerun());
			System.out.printf(str);
		}

	}
}
