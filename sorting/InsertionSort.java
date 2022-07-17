package baseball.sorting;
import java.util.ArrayList;

import baseball.Order;
import baseball.player.Player;


public class InsertionSort extends Sort{
	public void sort(ArrayList<Player> list, Order order) {
		int n,k,j;
		n = list.size();
		for (k = 1; k < n; k++) {
			for (j = k; j > 0; j--) {
				if (order.comparator(list.get(j), list.get(j-1)) >0) swap(list, j, j-1);
				else break;
			}
		}
		//printArray(unitArray);
	}
}
