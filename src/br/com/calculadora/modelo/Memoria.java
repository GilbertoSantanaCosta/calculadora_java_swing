package br.com.calculadora.modelo;

import java.util.ArrayList;
import java.util.List;

public class Memoria {

	private enum TipoComando {
		ZERAR, NUMERO, DIV, MULT, SUB, SOMA, IGUAL, VIRGULA
	};
	private static final Memoria instancia = new Memoria();
	
	private String textoAtual = ""; 
	
	private List<MemoriaObservador> observadores = new ArrayList<>();
	
	private Memoria () {
		
	}
	
	public static Memoria getInstancia() {
		
		return instancia;
	}
	
	public void adicionarObservador(MemoriaObservador observador) {
		observadores.add(observador);
	}
	
	public String getTextoAtual() {
		return textoAtual.isEmpty() ? "0" : textoAtual;
	}
	
	public void processarComando(String texto) {
		
		TipoComando tipoComando = detectarTipoDeComando(texto);
		
		if("AC".equals(texto)) {
			textoAtual = "";
		} else {
			textoAtual += texto;
		}
		
		observadores.forEach(o -> o.valorAlterado(getTextoAtual()));
	}

	private TipoComando detectarTipoDeComando(String texto) {
		if(textoAtual.isEmpty() && texto == "0") {
			return null;
		}
		
		try {
			Integer.parseInt(texto);
			return TipoComando.NUMERO;
		} catch (NumberFormatException e) {
			// quando n�o for numero 
			
			if("AC".equals(texto)) {
				return TipoComando.ZERAR;
			} else if("/".equals(texto)) {
				return TipoComando.DIV;
			}else if("*".equals(texto)) {
				return TipoComando.MULT;
			}else if("+".equals(texto)) {
				return TipoComando.SOMA;
			}else if("-".equals(texto)) {
				return TipoComando.SUB;
			}else if("=".equals(texto)) {
				return TipoComando.IGUAL;
			}else if(",".equals(texto)) {
				return TipoComando.VIRGULA;
			}
		}
		
		return null;
	}
 
	
}
