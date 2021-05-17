package br.com.aleavian.contas.modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RepositorioDeContas {

	public List<Conta> carregaDadosDasContas() {
		List<Conta> contas = new ArrayList<Conta>();
		
		try {
			Scanner leitor = new Scanner(new File("contas.txt"));
			
			while (leitor.hasNextLine()) {
				String linha = leitor.nextLine();
				String[] dados = linha.split(";");
				
				Conta conta = new ContaCorrente();
				if (dados[4].equals("Conta Poupan�a")) {
					conta = new ContaPoupanca();
				}
				
				conta.setAgencia(dados[0]);
				conta.setNumero(Integer.valueOf(dados[1]));
				conta.setTitular(dados[2]);
				conta.deposita(Double.valueOf(dados[3].replace(",", ".")));
						
				contas.add(conta);
			}
			
			leitor.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
				
		return contas;
	}
	
	
	public void armazenaDadosDasContas(List<Conta> contas) {
		try {
			PrintWriter escritor = new PrintWriter("contas.txt");
			
			for (Conta contaDaVez : contas) {
				String dados = String.format("%s;%d;%s;%.2f;%s",
						contaDaVez.getAgencia(),
						contaDaVez.getNumero(),
						contaDaVez.getTitular(),
						contaDaVez.getSaldo(),
						contaDaVez.getTipo());
				
				escritor.println(dados);
				escritor.flush();
			}
			
			escritor.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
