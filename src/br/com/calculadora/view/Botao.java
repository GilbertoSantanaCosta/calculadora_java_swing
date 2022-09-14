package br.com.calculadora.view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.*;

@SuppressWarnings("serial")
public class Botao extends JButton{

	public Botao(String texto, Color cor){
		setText(texto);
		setOpaque(true);
		setBackground(cor);
		setFont(new Font("courier", Font.PLAIN, 10));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setForeground(Color.WHITE);
	}
}
