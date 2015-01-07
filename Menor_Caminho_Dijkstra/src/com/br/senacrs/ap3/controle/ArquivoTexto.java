package com.br.senacrs.ap3.controle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ArquivoTexto {
	
	FileWriter arquivoW;
	PrintWriter gravaArquivo;
	FileReader arquivoRead;
	BufferedReader lerArquivo;;
	
	public void arquivoRead(String caminho) throws IOException {
		arquivoRead = new FileReader(caminho);
		lerArquivo = new BufferedReader(arquivoRead);
	}
	
	public String lerArquivo() throws IOException {
		String linha = lerArquivo.readLine();
		return linha;
	}

	public void fechaArquivo() throws IOException {
		lerArquivo.close();
	}

}
