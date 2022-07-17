package baseball;

/**
 * BaseballViewのインスタンスが「実行」ボタンによりPlayerのリストに関する操作をできるようにします．
 */
public interface SetPlayersInterface {
	
	/**
	 * Pitcher及びBatterのデータが入ったcsvファイルからデータを読み出します．
	 * @param pitcherFilename Pitcherのデータが入っているcsvファイルのファイル名
	 * @param batterFilename Batterのデータが入っているcsvファイルのファイル名
	 */
	public void scanPlayers(String pitcherFilename, String batterFilename);
		
	/**
	 * ソート対象のリーグを設定し， Playerリストを対象の全選手にします．
	 * @param league ソート対象のリーグ
	 * @param playerType 対象とする選手のPlayerType
	 */
	public void setLeague(League league, PlayerType playerType); 	
	
	/**
	 * Playerリストを一度，空にします．
	 */
	public void clearPlayers(); 
	
	/**
	 * Playerリストをorder順にソートします．
	 * 次のソートをするときは，一部のPlayerのみを対象にするため，Playerリストから一部のPlayerを除いて削除します：
	 * Pitcherの防御率，Pitcherの勝率，Batterの打率と長打率．
	 * @param order Playerリストの順序をOrderにより指定
	 */
	public void sort(Order order); 
	
	/**
	 * 現時点のPlayerリストをデフォルトのファイル名のファイルに出力します．
	 */
	public void dumpResult();
	
	/**
	 * 現時点のPlayerリストをファイル名filenameのファイルに出力します．(今回の課題では，操作パネルからこのメソッドの呼び出しをすることはありません．)
	 * @param filename 出力ファイル名
	 */
	public void dumpResult(String filename); 

}
