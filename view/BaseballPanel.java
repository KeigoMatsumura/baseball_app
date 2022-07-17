package baseball.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * 並列処理のおなじない
 */
@SuppressWarnings("serial")
public class BaseballPanel extends JPanel{

	public BaseballPanel(int width, int height, Color color){
		
		setPreferredSize(new Dimension(width, height));
		setBackground(color);
	}
}
