package baseball.sorting;

import java.util.ArrayList;

import baseball.Order;
import baseball.player.Player;

/**
 * Playerのリストのソートをできるようにするための抽象クラスです．
 */
public abstract class Sort {

	/**
	 * Playerリストのソート手法を与えるための抽象メソッドです．
	 * @param list ソート対象のPlayerリスト
	 * @param order ソートするときの順序を定める
	 */
	public abstract void sort(ArrayList<Player> list, Order order);

	/**
	 * Playerリストのi番目とj番目を入れ替えます．
	 * @param list 要素入れ替え対象のPlayerリスト
	 * @param i 入れ替えるPlayerの添字
	 * @param j 入れ替えるPlayerの添字
	 */
	protected void swap(ArrayList<Player> list, int i, int j){

		Player tmp;
		tmp = list.get(i);
		list.set(i,list.get(j));
		list.set(j, tmp);

	}
}
