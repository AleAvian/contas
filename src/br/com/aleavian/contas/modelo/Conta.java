package br.com.aleavian.contas.modelo;

import br.com.aleavian.contas.exception.SaldoInsuficienteException;

public abstract class Conta implements Comparable<Conta> {

	private String agencia;
	private int numero;
	private String titular;
	protected double saldo;
	
	public Conta() {

	}

	public Conta(String agencia, int numero, String titular) {
		this.agencia = agencia;
		this.numero = numero;
		this.titular = titular;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public abstract String getTipo();
	
	public void saca(double valor) throws SaldoInsuficienteException {
		if (valor <= 0) {
			throw new IllegalArgumentException("O valor do saque deve ser positivo.");
		}
		
		if (this.saldo >= valor) {
			this.saldo -= valor;
		} else {
			throw new SaldoInsuficienteException();
		}
	}
	
	public void deposita(double valor) {
		this.saldo += valor;
	}
	
	public void transfere(double valor, Conta destino) throws SaldoInsuficienteException {
		this.saca(valor);
		destino.deposita(valor);
	}
	
	public String pegaDadosDaConta() {
		String informacoes = "Titular: " + this.titular;
		informacoes += "\nN�mero: " + this.numero;
		informacoes += "\nAg�ncia: " + this.agencia;
		informacoes += "\nSaldo: " + this.saldo;
		
		return informacoes;
	}
	
	@Override
	public String toString() {
		return "Conta [agencia=" + agencia + ", numero=" + numero + "]";
	}

	public boolean equals(Object obj) {
		if (obj instanceof Conta) {
			Conta outraConta = (Conta) obj;
			
			return this.numero == outraConta.numero
				&& this.agencia.equals(outraConta.agencia);
		}
		
		return false;
	}
	
	@Override
	public int compareTo(Conta outraConta) {
		return this.titular.compareTo(outraConta.titular);
	}

}




