package baseball.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

import baseball.player.Player;

/**
 * Playerの成績をcsvファイルに出力するためのクラス
 *
 */
public class DumpPlayers {

	/**
	 * 時刻の入ったファイル名にPlayerの成績を出力します．
	 *
	 * @param players
	 *            ファイルに成績を出力するPlayerのリスト
	 */
	public static void dumpPlayers(List<Player> players) {
		String outputFileName = new String();
		GregorianCalendar cal = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddkkmmss");
		outputFileName = "output" + sdf.format(cal.getTime()) + ".csv";

		dumpPlayers(outputFileName, players);
	}

	/**
	 * ファイル名を指定してPlayerの成績を出力します．
	 *
	 * @param filename
	 *            ファイル名
	 * @param players
	 *            ファイルに成績を出力するPlayerのリスト
	 */
	public static void dumpPlayers(String filename, List<Player> players) {

		Path path = Paths.get(filename);

		// ここをつくる
		//BufferedWriterクラスのオブジェクトを取得する
		try(BufferedWriter writer = Files.newBufferedWriter(path)){
			//toStringメソッドを利用してテキストをcsvファイルに出力する
			for(Player temp : players){
				System.out.println(temp.toStringData());
				writer.write(temp.toStringData() + "\n");
			}
			//指定のファイルが開けない時に例外IOExceptionを投げる
		}catch(IOException e) {
			System.out.println(e);
		}

	}
}