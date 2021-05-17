package br.com.aleavian.contas.modelo;

import br.com.aleavian.contas.exception.SaldoInsuficienteException;

public class ContaCorrente extends Conta implements Tributavel {
	
	public void saca(double valor) throws SaldoInsuficienteException {
		super.saca(valor + 0.1);
	}

	public String getTipo() {
		return "Conta Corrente";
	}

	@Override
	public double getValorImposto() {
		return this.saldo * 0.01;
	}
	
}