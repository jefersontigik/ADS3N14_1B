package com.br.senacrs.ListaTelefonica;

import com.br.senacrs.ListaTelefonica.controle.ListaControlador;
import com.br.senacrs.ListaTelefonica.visao.ConsoleVisao;

public class ListaTelefonica {
	
	public static void main(String[] args) {
		ConsoleVisao visao = new ConsoleVisao();
		ListaControlador controle = new ListaControlador(visao);
		String comando = "";
		
		controle.leituraArquivo("telefones.dat");
		visao.mensagem("Digite 'ajuda' para comandos validos.");
		while (!comando.equals("sair")) {
			controle.mostraContato();
			comando = visao.ler("Comando").toLowerCase();
			if (comando.equals("avancar"))
				controle.contatoSeguinte();
			if (comando.equals("voltar"))
				controle.contatoAnterior();
			if (comando.equals("inserir"))
				controle.incluirContato();
			if (comando.equals("excluir"))
				controle.removeContato();
			if (comando.equals("procurar"))
				controle.procuraContato();
			if (comando.equals("ajuda"))
				visao.mensagem("ajuda  avancar  voltar  inserir  excluir  procurar  sair");
		}
		controle.salvaArquivo("telefones.dat");
	}

}
