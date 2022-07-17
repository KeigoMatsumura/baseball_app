package baseball.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import baseball.player.Batter;
import baseball.player.Pitcher;
import baseball.player.Player;

/**
 * あらかじめ決められたフォーマットのcsvファイルからPlayerのデータを読み出すためのクラスです．
 *
 */
public class ScanPlayers {

	/**
	 * 指定されたファイル名のcsvファイルからPitcherのデータを読み出し，PlayerクラスのArrayListとして戻します．
	 *
	 * @param filename
	 *            Pitcherのデータが入っているcsvファイル
	 * @return PitcherのデータのArrayList
	 */
	public static ArrayList<Player> scanPitchers(String filename) {
		return readPlayerData(filename, true);
	}

	/**
	 * 指定されたファイル名のcsvファイルからBatterのデータを読み出し，PlayerクラスのArrayListとして戻します．
	 *
	 * @param filename
	 *            Batterのデータが入っているcsvファイル
	 * @return BatterのデータのArrayList
	 */
	public static ArrayList<Player> scanBatters(String filename) {
		return readPlayerData(filename, false);
	}

	/**
	 * 指定されたファイル名のcsvファイルからPitcherまたはBatterのデータを読み出し，１行ずつ文字列を区切ってPlayerクラスのインスタンスに
	 * 変換し，ArrayListとして戻します．PitcherかBatterかは引数により指定します．PitcherとBatterの読み出しを同時にはしません．
	 *
	 * @param filename
	 *            PitcherまたはBatterのデータが入っているcsvファイル
	 * @param isPitcher
	 *            filenameのファイルがPitcherのcsvファイルならtrue,Batterのcsvファイルならfalseにします．
	 * @return PitcherまたはBatterのデータのArrayList
	 */
	private static ArrayList<Player> readPlayerData(String filename, boolean isPitcher) {

		ArrayList<Player> ret = new ArrayList<Player>();
		Path path = Paths.get(filename);

		// ここをつくる
		//BufferedReaderクラスのオブジェクトを取得する
		try(BufferedReader reader = Files.newBufferedReader(path)){
			String line;
			reader.readLine();
			reader.readLine();
			//ファイル終端に達するまでテキストを読み込む
			while ((line = reader.readLine()) != null) {
				String[] token = line.split(",");
				if(isPitcher) {
					ret.add(new Pitcher(token[0], token[1], token[2], token[3], token[4],
							token[5], token[6], token[7], token[8], token[9]));
				}
				else {
					ret.add(new Batter(token[0], token[1], token[2], token[3], token[4],
							token[5], token[6], token[7], token[8], token[9], token[10], token[11]));
				}
			}

			//指定のファイルが開けない時に例外IOExceptionを投げる
		}catch(IOException e) {
			System.out.println(e);
		}

		return ret;
	}

}
