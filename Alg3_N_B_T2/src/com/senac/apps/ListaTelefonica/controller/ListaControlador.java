package com.senac.apps.ListaTelefonica.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.senac.apps.ListaTelefonica.model.ListaEncadeada;
import com.senac.apps.ListaTelefonica.model.ListaOrdenada;
import com.senac.apps.ListaTelefonica.model.Nodo;
import com.senac.apps.ListaTelefonica.model.Pessoa;
import com.senac.apps.ListaTelefonica.view.ConsoleVisao;

public class ListaControlador {
	private ListaEncadeada<Pessoa> arquivo;
	private ListaOrdenada<Pessoa> contatos;
	private ConsoleVisao visao;
	private Nodo<Pessoa> atual;
	
	public ListaControlador(ConsoleVisao visao) {
		this.visao = visao;
		this.contatos = new ListaOrdenada<Pessoa>();
		this.arquivo  = new ListaEncadeada<Pessoa>();
		this.atual = null;
	}

	public void leituraArquivo(String nomeArquivo) {
		try {
			Scanner arq = new Scanner(new FileReader(nomeArquivo));
			while(arq.hasNext()) {
				String nome = arq.nextLine();
				String telefone = arq.nextLine();
				Pessoa pessoa = new Pessoa(nome);
				pessoa.setTelefone(telefone);
				arquivo.insert(new Nodo<Pessoa>(pessoa));
				if (!nome.startsWith("#"))
					contatos.insert(new Nodo<Pessoa>(pessoa));
			}
			atual = contatos.getHead();
		} catch (FileNotFoundException e) {
			visao.erroLog(e.getMessage());
		}
	}

	public void mostraContato() {
		if (atual == null) {
			visao.mensagem("Nenhum contato existente.");
		} else {
			Pessoa contato = atual.getData();
			visao.imprimeContato(contato.getNome(), contato.getTelefone());
		}
	}

	public void contatoSeguinte() {
		if (atual != null) {
			atual = atual.getNext();
			if (atual == null)
				atual = contatos.getHead();
		}
	}

	public void contatoAnterior() {
		if (atual != null) {
			atual = atual.getPrevious();
			if (atual == null)
				atual = contatos.getTail();
		}
	}

	public void incluirContato() {
		Pessoa contato = new Pessoa();
		contato.setNome(visao.ler("Nome"));
		contato.setTelefone(visao.ler("Telefone"));
		Nodo<Pessoa> novo = new Nodo<Pessoa>(contato);
		contatos.insert(novo);
		arquivo.anexa(new Nodo<Pessoa>(contato));
		atual = novo;
	}

	public void removeContato() {
		if (atual != null) {
			contatos.remove(atual);
			contatoSeguinte();
		}
	}

	private Nodo<Pessoa> procuraContato(ListaEncadeada<Pessoa> lista, String chave)
	{
		Nodo<Pessoa> iterador = lista.getHead();
		while (iterador != null) {
			Pessoa contato = iterador.getData();
			String nome = contato.getNome().toLowerCase();
			if (nome.startsWith(chave)) {
				return iterador;
			}
			iterador = iterador.getNext();
		}
		return null;
	}
	
	public void procuraContato() {
		String chave = visao.ler("Inicio do Nome").toLowerCase();
		Nodo<Pessoa> contato = procuraContato(contatos, chave);
		if (contato != null)
			atual = contato;
	}

	public void salvaArquivo(String nomeArquivo) {
		FileWriter arq = null;
		try {
			arq = new FileWriter(nomeArquivo,false);
			Nodo<Pessoa> iterador = arquivo.getHead();
			while (iterador != null) {
				Pessoa contato = iterador.getData();
				if (procuraContato(contatos, contato.getNome()) == null)
					arq.append("#"+contato.getNome()+"\n");
				else
					arq.append(contato.getNome()+"\n");
				arq.append(contato.getTelefone()+"\n");
				iterador = iterador.getNext();
			}
		} catch (IOException e) {
			visao.mensagem(e.getMessage());
		} finally {
			if (arq != null)
				try {
					arq.close();
				} catch (IOException e) {
					visao.mensagem(e.getMessage());
				}
		}
	}

}
