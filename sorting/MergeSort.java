package baseball.sorting;

import java.util.ArrayList;

import baseball.Order;
import baseball.player.Player;


public class MergeSort extends Sort{
	/**
	 * マージソートによりソートする．
	 */
	public void sort(ArrayList<Player> list, Order order) {
		mergeSort(list, order, 0, list.size() - 1);
		System.out.printf("sort players by merge sort in %s\n", order);
	}
	/**
	 *マージソートの再帰呼び出し．sortメソッドから呼び出す
	 * @param list　ソート対象のPlayerリスト
	 * @param order　ソートするときの順序を定める
	 * @param left　再帰呼び出しの範囲の左端の添字
	 * @param right　再帰呼び出し範囲の右端の添字
	 */
	public void mergeSort(ArrayList<Player> list, Order order, int left, int right) {
		ArrayList<Player> lList = new ArrayList<>();
		ArrayList<Player> rList = new ArrayList<>();
		int mid = (left + right) / 2;

		if(left < mid)
			mergeSort(list, order, left, mid);

		if(mid + 1 < right)
			mergeSort(list, order, mid+1, right);

		for(int i = 0; i <= mid - left; i++) {
			lList.add(i, list.get(i+left));
		}
		for(int i = 0; i < right - mid; i++) {
			rList.add(i, list.get(i + mid + 1));
		}
		//lListとrListをマージした結果を同じ範囲にセット
		int j = left;
		for(Player p : merge(order, lList, rList)) {
			list.set(j++, p);
		}
	}

	/**
	 *マージ手続きです．mergeSortメソッドから呼び出します．
	 * @param order ソートするときの順序を決める
	 * @param lList 1つ目のマージ対象Playerリストです．
	 * @param rList 2つ目のマージ対象Playerリストです．
	 * @return マージ結果のplayerリストを戻します．
	 */
	public ArrayList<Player> merge(Order order, ArrayList<Player> lList, ArrayList<Player> rList) {
		ArrayList<Player> ret = new ArrayList<>();

		while(!lList.isEmpty() && !rList.isEmpty()) {
			if(order.comparator(lList.get(0), rList.get(0)) <= 0){
				ret.add(lList.remove(0));
			}
			else {
				ret.add(rList.remove(0));
			}
		}
		while(!lList.isEmpty())
			ret.add(lList.remove(0));
		while(!rList.isEmpty())
			ret.add(rList.remove(0));
		return ret;
	}

}


