package br.com.aleavian.contas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import br.com.aleavian.contas.exception.SaldoInsuficienteException;
import br.com.aleavian.contas.modelo.Conta;
import br.com.aleavian.contas.modelo.ContaCorrente;
import br.com.aleavian.contas.modelo.ContaPoupanca;
import br.com.aleavian.contas.modelo.RepositorioDeContas;
import br.com.caelum.javafx.api.util.Evento;

public class ManipuladorDeContas {

	private Conta conta;

	public void criaConta(Evento evento) {
		String tipo = evento.getSelecionadoNoRadio("tipo");

		if (tipo.equals("Conta Corrente")) {
			this.conta = new ContaCorrente();
		} else if (tipo.equals("Conta Poupan�a")) {
			this.conta = new ContaPoupanca();
		}

		this.conta.setNumero(evento.getInt("numero"));
		this.conta.setAgencia(evento.getString("agencia"));
		this.conta.setTitular(evento.getString("titular"));
	}

	public void saca(Evento evento) throws SaldoInsuficienteException {
		double valorDigitado = evento.getDouble("valorOperacao");
		System.out.println("sacando " + valorDigitado);

		if (this.conta.getTipo().equals("Conta Corrente")) {

		}
		this.conta.saca(valorDigitado);
	}

	public void deposita(Evento evento) {
		double valorDigitado = evento.getDouble("valorOperacao");
		System.out.println("depositando " + valorDigitado);

		this.conta.deposita(valorDigitado);
	}

	public void transfere(Evento evento) throws SaldoInsuficienteException {
		Conta destino = (Conta) evento.getSelecionadoNoCombo("destino");

		double valor = evento.getDouble("valorTransferencia");
		conta.transfere(valor, destino);
	}

	public void ordenaLista(Evento evento) {
		List<Conta> contas = evento.getLista("destino");
		Collections.sort(contas);
	}
	
	public void salvaDados(Evento evento) {
		List<Conta> contas = evento.getLista("listaContas");
		
		RepositorioDeContas repositorio = new RepositorioDeContas();
		repositorio.armazenaDadosDasContas(contas);
	}
	
	public List<Conta> carregaDados() {
		RepositorioDeContas repositorio = new RepositorioDeContas();
		return repositorio.carregaDadosDasContas();
	}

}















