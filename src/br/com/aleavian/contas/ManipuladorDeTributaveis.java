package br.com.aleavian.contas;

import br.com.aleavian.contas.modelo.Tributavel;
import br.com.caelum.javafx.api.util.Evento;

public class ManipuladorDeTributaveis {

	private int total;

	public void calculaImpostos(Evento evento) {
		total = 0;
	
		int tamanho = evento.getTamanhoDaLista("listaTributaveis");
		for (int i = 0; i < tamanho; i++) {
			Tributavel t = evento.getTributavel("listaTributaveis", i);
			total += t.getValorImposto();
		}
	}
	
	public int getTotal() {
		return total;
	}

}
