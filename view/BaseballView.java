package baseball.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import baseball.*;

public class BaseballView implements ActionListener {

	private final static String PITCHER_FILENAME = "pitchers.csv"; // Pitcher用データファイル名
	private final static String BATTER_FILENAME = "batters.csv"; // Batter用データファイル名
	
	// 表示フレーム
	private JFrame frame;
	private final int FRAME_WIDTH = 560; // フレームの幅
	private final int FRAME_HEIGHT = 370; // フレームの高さ

	// 全体パネル
	private JPanel panel;

	// 上部パネル
	private JPanel selectOrder;
	private final Dimension UPPER_DIMENSION = new Dimension(FRAME_WIDTH, FRAME_HEIGHT-80); // パネルサイズ
	private final Color UPPER_COLOR = Color.WHITE; // パネルの色

	// 下部パネル
	private JPanel lowerPanel;
	private final Dimension LOWER_DIMENSION = new Dimension(FRAME_WIDTH, 80); // パネルサイズ
	private final Color LOWER_COLOR = Color.GRAY; // パネルの色

	// リーグ選択
	private JPanel selectLeague; // リーグ選択
	private JCheckBox pacificCkBox; // パシフィックリーグを選択するチェックボックス
	private JCheckBox centralCkBox; // セントラルリーグを選択するチェックボックス

	// 実行ボタン，リセットボタン
	private JPanel execPanel; // 実行ボタンとリセットボタンのパネル
	private JButton exec;
	private JButton reset;

	// データベース管理
	private SetPlayersInterface spi;

	public BaseballView() {

		spi = new SetPlayers(); // Singletonパターンを使っていない場合
		// spi = PlayersData.getInstance(); // Singletonパターンを使った場合
		
		spi.scanPlayers(PITCHER_FILENAME, BATTER_FILENAME);
	}

	/**
	 * 各種パネルを表示する
	 */
	public void createView() {

		// 表示フレームの生成
		frame = new JFrame("Baseball Database");
		frame.setBackground(Color.WHITE);

		// 全体パネルを生成
		panel = new JPanel(new FlowLayout());
		panel.setBackground(Color.WHITE);

		// 上部パネルを生成
		selectOrder = new SelectOrder(UPPER_DIMENSION, UPPER_COLOR);

		// 下部パネル
		lowerPanel = new JPanel(new FlowLayout());
		lowerPanel.setPreferredSize(LOWER_DIMENSION);
		lowerPanel.setBackground(LOWER_COLOR);

		// 下部パネル：リーグ選択のチェックボックスのパネルを生成
		selectLeague = makeSelectLeague(LOWER_COLOR);

		// 下部パネル：実行ボタンのみから成るパネルを生成
		execPanel = makeExecPanel(LOWER_COLOR);

		// 下部パネルに２つのパネルを貼り付ける
		lowerPanel.add(selectLeague);
		lowerPanel.add(execPanel);

		// 全体パネルに上部パネルと下部パネルを貼付ける
		panel.add(selectOrder);
		panel.add(lowerPanel);

		// 全パネルをフレームに貼付ける
		frame.add(panel);

		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT); // フレームのサイズをセット
		frame.setVisible(true); // フレームを表示する

	}

	private JPanel makeSelectLeague(Color color) { // リーグ選択のパネルを作る

		JPanel ret = new JPanel();

		// パシフィックリーグ選択用チェックボックス，初期状態で選択されている
		pacificCkBox = new JCheckBox("パシフィックリーグ", true);
		ret.add(pacificCkBox);
		// セントラルリーグ選択用チェックボックス，初期状態で選択されていない
		centralCkBox = new JCheckBox("セントラルリーグ", true);
		ret.add(centralCkBox);

		ret.setBackground(color);

		return ret;
	}

	public League getLeague() {

		League ret = League.NONE;

		// チェックボックスの選択状態による場合分け
		if (pacificCkBox.isSelected() && centralCkBox.isSelected())
			ret = League.BOTH;
		else if (pacificCkBox.isSelected())
			ret = League.PACIFIC;
		else if (centralCkBox.isSelected())
			ret = League.CENTRAL;

		System.out.println("Target league: " + ret);

		return ret;
	}

	private JPanel makeExecPanel(Color color) { // 実行ボタン,リセットボタンのパネルを作る

		JPanel ret = new JPanel();

		exec = new JButton("実行");
		exec.setActionCommand("exec");
		exec.addActionListener(this);
		
		reset = new JButton("リセット");
		reset.setActionCommand("reset");
		reset.addActionListener(this);
		
		ret.add(exec); // 実行ボタンを貼り付け
		ret.add(reset); // リセットボタンを貼り付け
		ret.setBackground(color);

		return ret;
	}

	public void actionPerformed(ActionEvent event) { // 実行ボタンのイベントリスナー

		if (event.getSource() == exec) {

			SelectOrder skf = (SelectOrder) selectOrder;
			League league = getLeague();

			if (league != League.NONE) { // リーグの選択があるときのみ実行
				spi.setLeague(league, skf.getPlayerType()); // LeagueとPlayerTypeを設定
				spi.sort(skf.getOrder());

				spi.dumpResult();
			} else{
				
				spi.clearPlayers();

			}
		} else if(event.getSource() == reset){
			
			spi.clearPlayers();
			
		}
	}

}