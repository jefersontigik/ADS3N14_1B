package com.br.senacrs.ap3.controle;

import java.io.IOException;
import java.util.ArrayList;

public class GrafoInicial {

	public ArrayList<String> dadosGrafo(){
		String linha = "";
		ArquivoTexto arq = new ArquivoTexto();
		ArrayList<String> lista = new ArrayList<String>();

		try {
			arq.arquivoRead("dadosGeo.txt");
			linha = arq.lerArquivo();

			while (linha != null) {

				String palavra  = linha;
				lista.add(palavra);
				linha = arq.lerArquivo();
			}
			arq.fechaArquivo();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return lista;
	}
}
