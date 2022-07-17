package baseball.player;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * チームを表すクラスです
 */

public class Team {

	private static final Map<Character, String> teamTable = new HashMap<Character, String>() {
		{
			put('f', "日");
			put('h', "ソ");
			put('m', "ロ");
			put('l', "西");
			put('e', "楽");
			put('b', "オ");
			put('c', "広");
			put('g', "巨");
			put('a', "デ");
			put('t', "神");
			put('s', "ヤ");
			put('d', "中");
		}
	};

	/**
	 * char型teamの値に対してを指定のStringを戻します．
	 *
	 * @param team
	 *            チームを表すchar
	 * @return 所属チームをStringで戻す．
	 */
	public static String toStringTeam(char team) {
		return teamTable.get(team);
	}

	/**
	 * char型teamのチームがパシフィックリーグのチームかを戻します．
	 *
	 * @param team
	 *            チームを表すchar
	 * @return チームがパシフィックリーグならtrue
	 */
	public static boolean isPacific(char team) {
		List<Character> list = Arrays.asList('f', 'h', 'm', 'l', 'e', 'b');
		return list.contains(team);

	}

}
