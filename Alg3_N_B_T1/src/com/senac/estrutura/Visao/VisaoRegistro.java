package com.senac.estrutura.Visao;

import static java.lang.System.out;

import java.io.IOException;
import java.util.Scanner;

import com.senac.estrutura.Controle.ManipulaArquivo;
import com.senac.estrutura.Modelo.ListaGenerica;
import com.senac.estrutura.Modelo.ListaTel;
import com.senac.estrutura.Modelo.NodoGen;

public class VisaoRegistro {

	String linha = "";
	String opcao;
	ListaGenerica<ListaTel> lista = new ListaGenerica<ListaTel>();
	ManipulaArquivo<ListaTel> arq = new ManipulaArquivo<ListaTel>();
	ListaTel agenda = new ListaTel();
	NodoGen<ListaTel> nodo = new NodoGen<ListaTel>();

	String[] a = new String[2];

	public String montaMenu() {
		out.println("Informe a opção desejada:"
				+ "\n 1 - Inserir novo registro" + "\n 2 - Apagar registro"
				+ "\n 3 - Listar todos " + "\n 4 - Pesquisar" + "\n 5 - Sair");
		return opcao = new Scanner(System.in).next();
	}

	public void insereRegistro() {
		out.println("Digite o nome");
		agenda.setNome(new Scanner(System.in).next().toString());

		out.println("Digite o Telefone");
		agenda.setFone(new Scanner(System.in).next().toString());

		nodo.setData(agenda);

		try {
			arq.abreArquivoW("Agenda.txt");
			arq.gravaArquivo(nodo.getData());
			arq.fechaArquivoW();
		} catch (IOException i) {
			out.println(i.getMessage());
		}
	}
	
	public void carregaLista(){
		try {
			arq.abreArquivoR("Agenda.txt");
		} catch (IOException i) {
			out.println(i.getMessage());
		}

		while (linha != null) {
			try {
				linha = arq.lerArquivo();
				a = linha.split(";");

				if (lista.listaVazia()) {
					agenda.setNome(a[0]);
					agenda.setFone(a[1]);
					nodo.setData(agenda);

					lista = new ListaGenerica<ListaTel>();
					lista.insert(nodo);
				} else {

					agenda.setNome(a[0]);
					agenda.setFone(a[1]);
					nodo.setData(agenda);

					lista = new ListaGenerica<ListaTel>();
					lista.insert(nodo);
				}
				

			} catch (IOException i) {
				out.println(i.getMessage());
				break;
			}			
		}
	}

	public void listaTodos() {
		do{
			out.println(lista.getTail().getNext().getData().getNome());
			
		}while(lista.getTail() != null);
	}
}
