package com.br.senacrs.ap3.controle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.br.senacrs.ap3.modelo.Agenda;

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

		gravaArquivo.println(((Agenda) agenda).getNome() + "#" + ((Agenda) agenda).getTelefone1()+ "#" + ((Agenda) agenda).getTelefone2()+ "#" + ((Agenda) agenda).getTelefone3());
	}

	public String lerArquivo() throws IOException {
		String linha = lerArquivo.readLine();
//		return linha;
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
