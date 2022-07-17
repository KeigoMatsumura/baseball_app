package baseball.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

import baseball.Order;
import baseball.PlayerType;

/**
 * 並列処理のおなじない
 */
@SuppressWarnings("serial")
public class SelectOrder extends JPanel implements ActionListener {

	// パネルのカラー
	private Color color;

	// パネルの大きさ
	private Dimension dimension;
	
	// アクションリスナー用フィールド
	private String command = "";

	// 中のパネル
	private JPanel selectOrderBoth;
	private JPanel selectOrderPitcher;
	private JPanel selectOrderBatter;

	// 選択するボタンのグループ
	ButtonGroup selectOrderGroup;

	// ボタンにより選択されたorderとPlayerType
	private Order order = Order.NONE;
	private PlayerType playerType = PlayerType.BOTH;

	// 選択可能なorder
	private final String[][] BOTH_KEY = { { "順序指定なし", "both none" } };
	private final String[][] PITCHER_KEY = { { "順序指定なし", "pitcher none" }, { "試合数順", "pitcher game" },
			{ "勝利数順", "pitcher win" }, { "敗戦数順", "pitcher loss" },
			{ "セーブ数順", "pitcher save" }, { "HP数順", "pitcher hp" }, { "防御率順", "pitcher era" },{ "勝率順", "pitcher percentage" }, 
			};

	private final String[][] BATTER_KEY = { { "順序指定なし", "batter none" }, { "試合数順", "batter game" }, { "打率順", "batter average" }, 
			{ "打席数順", "batter pa" }, { "安打数順", "batter hit" },
			{ "本塁打数順", "batter homerun" }, { "打点順", "bater rbi" }, { "三振数順", "batter strike out" },
			{ "長打率順", "batter slg" } };

	public SelectOrder(Dimension dimension, Color color) {

		super(new FlowLayout());
		this.dimension = dimension;
		setPreferredSize(dimension);
		setBackground(color);
		this.color = color;
		createView();
	}

	public void createView() {

		selectOrderGroup = new ButtonGroup();

		// 内側のパネルを作る
		selectOrderBoth = makeSmallSelectOrder("ピッチャー＆バッター", BOTH_KEY);
		selectOrderPitcher = makeSmallSelectOrder("ピッチャー", PITCHER_KEY);
		selectOrderBatter = makeSmallSelectOrder("バッター", BATTER_KEY);

		// 中のパネルを貼り付け
		add(selectOrderBoth);
		add(selectOrderPitcher);
		add(selectOrderBatter);
	}

	private JPanel makeSmallSelectOrder(String title, String[][] key) { // 内側のパネルを作る

		JPanel ret = null;

		ArrayList<JRadioButton> radioButtons = new ArrayList<JRadioButton>();
		for (int i = 0; i < key.length; i++) {
			JRadioButton button = new JRadioButton(key[i][0], true);
			button.setActionCommand(key[i][1]);
			selectOrderGroup.add(button);
			radioButtons.add(button);
			button.addActionListener(this);
		}

		ret = new SelectOrderTemplate(title, new Dimension((dimension.width-20)/3, dimension.height), radioButtons, color);

		return ret;

	}

	public PlayerType getPlayerType() {

		return playerType;
	}

	public Order getOrder() {

		return order;
	}

	public void actionPerformed(ActionEvent event) { // order選択のためのアクションリスナー

		command = event.getActionCommand();

		if (command.equals(BOTH_KEY[0][1])) {
			playerType = PlayerType.BOTH;
			order = Order.NONE;
		} else if (command.equals(PITCHER_KEY[0][1])) {
			playerType = PlayerType.PITCHER;
			order = Order.NONE;
		} else if (command.equals(PITCHER_KEY[1][1])) {
			playerType = PlayerType.PITCHER;
			order = Order.GAME;
		} else if (command.equals(PITCHER_KEY[2][1])) {
			playerType = PlayerType.PITCHER;
			order = Order.WIN;
		} else if (command.equals(PITCHER_KEY[3][1])) {
			playerType = PlayerType.PITCHER;
			order = Order.LOSS;
		} else if (command.equals(PITCHER_KEY[4][1])) {
			playerType = PlayerType.PITCHER;
			order = Order.SAVE;
		} else if (command.equals(PITCHER_KEY[5][1])) {
			playerType = PlayerType.PITCHER;
			order = Order.HP;
		} else if (command.equals(PITCHER_KEY[6][1])) {
			playerType = PlayerType.PITCHER;
			order = Order.ERA;
		} else if (command.equals(PITCHER_KEY[7][1])) {
			playerType = PlayerType.PITCHER;
			order = Order.PERCENTAGE;
		} else if (command.equals(BATTER_KEY[0][1])) {
			playerType = PlayerType.BATTER;
			order = Order.NONE;
		} else if (command.equals(BATTER_KEY[1][1])) {
			playerType = PlayerType.BATTER;
			order = Order.GAME;
		} else if (command.equals(BATTER_KEY[2][1])) {
			playerType = PlayerType.BATTER;
			order = Order.AVERAGE;
		} else if (command.equals(BATTER_KEY[3][1])) {
			playerType = PlayerType.BATTER;
			order = Order.PA;
		} else if (command.equals(BATTER_KEY[4][1])) {
			playerType = PlayerType.BATTER;
			order = Order.HIT;
		} else if (command.equals(BATTER_KEY[5][1])) {
			playerType = PlayerType.BATTER;
			order = Order.HOMERUN;
		} else if (command.equals(BATTER_KEY[6][1])) {
			playerType = PlayerType.BATTER;
			order = Order.RBI;
		} else if (command.equals(BATTER_KEY[7][1])) {
			playerType = PlayerType.BATTER;
			order = Order.STRIKE_OUT;
		} else if (command.equals(BATTER_KEY[8][1])) {
			playerType = PlayerType.BATTER;
			order = Order.SLG;
		}

		System.out.println("set comparator to " + command);
	}
}
