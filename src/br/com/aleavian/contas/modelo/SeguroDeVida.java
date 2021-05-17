package br.com.aleavian.contas.modelo;

public class SeguroDeVida extends Object implements Tributavel {

	private String titular;
	private double valor;
	private int numeroApolice;

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getNumeroApolice() {
		return numeroApolice;
	}

	public void setNumeroApolice(int numeroApolice) {
		this.numeroApolice = numeroApolice;
	}
	
	@Override
	public double getValorImposto() {
		return 42 + (this.valor * 0.02);
	}

	@Override
	public String toString() {
		return "SeguroDeVida [titular=" + titular + ", valor=" + valor + 
				", numeroApolice=" + numeroApolice + "]";
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof SeguroDeVida) {
			SeguroDeVida outroSeguro = (SeguroDeVida) obj;
			
			if (this.numeroApolice == outroSeguro.numeroApolice) {
				return true;
			}
		}
		
		return false;
	}

}




















