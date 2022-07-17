package baseball.sorting;

import java.util.ArrayList;

import baseball.Order;
import baseball.player.Player;

public class BubbleSort extends Sort {

	/**
	 * リストの要素をバブルソートを用いて昇順に並び替え，その結果を表示する
	 * @param list  Integer型のArrayListのオブジェクト
	 */
	public void sort(ArrayList<Player> list, Order order) {
		int i, k, n;
		n = list.size(); // リストの要素の個数を得る
		for (k = 1; k < n; k++) {
			for (i = 0; i < n - k; i++)
				if (order.comparator(list.get(i), list.get(i+1)) > 0){
					swap(list, i, i + 1); // リストの指定した2つの要素を入れ替える
				}
		}
		//printArray(list);
	}
}