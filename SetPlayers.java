package baseball;
import java.util.ArrayList;

import baseball.io.DumpPlayers;
import baseball.io.ScanPlayers;
import baseball.player.Player;


/**
 * SetPlayersInterfaceの実装クラスです．
 */
public class SetPlayers implements SetPlayersInterface {

	/**
	 * Pitcherクラスのデータを管理するArrayListです．
	 */
	private ArrayList<Player> pitchers;

	/**
	 * Batterクラスのデータを管理するArrayListです．
	 */
	private ArrayList<Player> batters;

	/**
	 * ファイルに出力するPlayerを格納しておくArrayListです．
	 */
	private ArrayList<Player> selectedPlayers;

	/**
	 * 現在対象になっているリーグを格納します．
	 */
	private League league;

	/**
	 * 現在の対象がPitcherかBatterかを格納します．
	 */
	private PlayerType playerType;

	/**
	 * コンストラクタでは，フィールドleague，playerTypeを初期値のNONEに設定します．
	 */
	public SetPlayers() {
		league = League.NONE;
		playerType = PlayerType.NONE;
	}

	/**
	 * Pitcherのデータはフィールドpitchersへ，BatterのデータはフィールドBattersへ代入します．
	 */
	@Override
	public void scanPlayers(String pitcherFilename, String batterFilename){
		pitchers = ScanPlayers.scanPitchers(pitcherFilename);
		batters = ScanPlayers.scanBatters(batterFilename);
	}

	/**
	 * ソート対象のLeagueまたはPlayerTypeが前回のソートから変わった場合は，selectedPlayersを初期化して，
	 *  引数のLeague, PlayerTypeに一致する全Playerを再格納するようにします．
	 */

	@Override
	public void setLeague(League league, PlayerType playerType) {
		if(this.league != league || this.playerType != playerType) {
			/**
			 * selectedPlayersを初期化します．
			 */
			clearPlayers();
			this.league = league;
			this.playerType = playerType;

			if(league.equals(League.BOTH)) {
				copyLeaguePlayers(true);
				copyLeaguePlayers(false);

			}
			else if(league.equals(League.PACIFIC))
				copyLeaguePlayers(true);
			else
				copyLeaguePlayers(false);
		}
	}


	/**
	 * 現在，Pitcherが対象になっているかを表します．
	 * @return playerTypeがBOTHまたはPITCHERならば，Pitcherが対象なのでtrueを戻します．
	 */
	private boolean isPitcherType() {
		boolean ret = false;
		if(playerType == PlayerType.BOTH || playerType == PlayerType.PITCHER) ret = true;
		return ret;
	}

	/**
	 * 現在，Batterが対象になっているかを表します．
	 * typeがBOTHまたはBATTERならば，Batterが対象なのでtrueを戻します．
	 */
	private boolean isBatterType() {
		boolean ret = false;
		if(playerType == PlayerType.BOTH || playerType == PlayerType.BATTER) ret = true;
		return ret;
	}


	/**
	 * selectedPlayersを初期化（新しくArrayListを生成し，leagueとplayerTyeを初期値NONEに設定する）します．
	 */
	@Override
	public void clearPlayers() {
		selectedPlayers = new ArrayList<>();
		league = League.NONE;
		playerType = PlayerType.NONE;
	}


	/**
	 * 一方のリーグのPlayerを，出力対象Playerを格納するArrayListにコピーします．
	 * @param isPacific trueならパシフィックリーグのPlayerのみ，falseならセントラルリーグのPlayerのみをコピーします．
	 */
	private void copyLeaguePlayers(boolean isPacific) {
		if(isPacific) {
			if(isPitcherType()) {
				for(Player tmp : pitchers) {
					if(tmp.isPacific())
						selectedPlayers.add(tmp);
				}
			}
			if(isBatterType()) {
				for(Player tmp : batters) {
					if(tmp.isPacific())
						selectedPlayers.add(tmp);
				}
			}
		}
		else {
			if(isPitcherType()) {
				for(Player tmp : pitchers) {
					if(!tmp.isPacific())
						selectedPlayers.add(tmp);
				}
			}
			if(isBatterType()) {
				for(Player tmp : batters) {
					if(!tmp.isPacific())
						selectedPlayers.add(tmp);
				}
			}
		}
	}

	/**
	 * selectedPlayersのPlayerを，Orderに従ってソートします．
	 * 次のソートをするときは，一部のPlayerのみを対象にするため，
	 * Playerリストから一部のPlayerを除いて削除します：
	 * Pitcherの防御率，Pitcherの勝率，Batterの打率と長打率．
	 *
	 */
	@Override
	public void sort(Order order) {
		order.sort(selectedPlayers);
	}

	/**
	 * selectedPlayersのPlayerが順に入ったファイルを出力します．
	 */
	@Override
	public void dumpResult() {
		DumpPlayers.dumpPlayers(selectedPlayers);
	}

	/**
	 * selectedPlayersのPlayerが順に入ったファイルを出力します．
	 */
	@Override
	public void dumpResult(String filename) {
		DumpPlayers.dumpPlayers(filename, selectedPlayers);
	}


}
