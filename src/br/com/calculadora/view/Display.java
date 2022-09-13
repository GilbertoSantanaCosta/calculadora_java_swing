package br.com.calculadora.view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
@SuppressWarnings("serial")
public class Display extends JPanel{

	private final JLabel textDisplay = new JLabel();
	
	public Display() {
		setBackground(new Color(46,49,50));
		textDisplay.setText("1234,56");
		textDisplay.setForeground(Color.WHITE);
		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 25));
		
		add(textDisplay);
	}
}
