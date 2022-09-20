package br.com.calculadora.view;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.calculadora.modelo.Memoria;

import java.awt.*;
@SuppressWarnings("serial")
public class Display extends JPanel{

	private final JLabel textDisplay = new JLabel();
	
	public Display() {
		setBackground(new Color(46,49,50));
		textDisplay.setText(Memoria.getInstancia().getTextoAtual());
		textDisplay.setForeground(Color.WHITE);
		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 25));
		
		add(textDisplay);   
	}
}
