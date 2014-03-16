package com.senac.estrutura.Controle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.senac.estrutura.Modelo.ListaTel;

public class ManipulaArquivo <T> {

	FileWriter arquivoW;
	PrintWriter gravaArquivo;
	FileReader arquivoR;
	BufferedReader lerArquivo;

	public void abreArquivoW(String caminho) throws IOException {
		arquivoW = new FileWriter(caminho, true);
		gravaArquivo = new PrintWriter(arquivoW);
	}

	public void abreArquivoR(String caminho) throws IOException {
		arquivoR = new FileReader(caminho);
		lerArquivo = new BufferedReader(arquivoR);
	}

	public void gravaArquivo(T agenda) {

		gravaArquivo.println(((ListaTel) agenda).getNome() + ";" + ((ListaTel) agenda).getFone());
	}

	public String lerArquivo() throws IOException {
		String linha = lerArquivo.readLine();
		if (linha == null) {
			throw new IOException("Fim Arquivo");
		} else {
			return linha;
		}
	}

	public void fechaArquivoW() {
		gravaArquivo.close();
	}

	public void fechaArquivoR() throws IOException {
		lerArquivo.close();
	}
}
