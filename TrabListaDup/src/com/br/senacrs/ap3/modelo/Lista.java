package com.br.senacrs.ap3.modelo;

public class Lista<T> {

	protected Nodo<T> head;
	protected Nodo<T> tail;
	private double totElem;

	public Lista(){
		this.head = null;
		this.tail = null;
		this.totElem = 0;
	}
	
	public Lista(Nodo<T> head, Nodo<T> tail){
		this.head = head;
		this.tail = tail;
		this.totElem = 0;
	}

	public Nodo<T> getHead() {
		return head;
	}

	public void setHead(Nodo<T> head) {
		this.head = head;
	}

	public Nodo<T> getTail() {
		return tail;
	}

	public void setTail(Nodo<T> tail) {
		this.tail = tail;
	}

	public double getTotElem() {
		return totElem;
	}

	public void setTotElem(double totElem) {
		this.totElem = totElem;
	}
	
	public void aumentaTamanho() {  
		this.totElem++;  
    }  
    public void diminuiTamanho() {  
    	this.totElem--;  
    } 

	public boolean listaVazia(){
		return (this.head == null);
	}

	public void adicionaHead(T elemento) {
		Nodo<T> novoNo = new Nodo<T>(elemento);
		
		if(this.listaVazia()){
			this.tail = novoNo;
		}else{
			this.head.setAnt(novoNo);
			novoNo.setProx(this.head);
			
		}
		this.head = novoNo;
		this.totElem ++;
	}
	public void adicionaTail(T elemento) {
		Nodo<T> novoNo = new Nodo<T>(elemento);
		
		if(this.listaVazia()){
			this.head = novoNo;
		}
		else{
			this.tail.setProx(novoNo);
			novoNo.setAnt(this.tail);
			
		}
		this.tail = novoNo;
		this.totElem ++;
	}
	
	public void insert(Nodo<T> novo) {
		if (getHead() == null) {
			novo.setProx(head);
			head = novo;
			if (tail == null)
				tail = head;
		} else {
			novo.setProx(getHead().getProx());
			getHead().setProx(novo);
			if (getHead() == tail)
				tail = novo;
		}
	}
	
	public boolean removerNo(String chave){
		Nodo<T> atual = this.head;
		while((atual != null) && (((Agenda) atual.getDados()).getNome() != chave)){
			atual = atual.getProx();
		}
		if(atual == null){
			return false;
		}else{
			if(atual == this.head){
				this.head = this.head.getProx();
				if(this.head == this.tail){
					this.tail = null;
				}else{
					this.head.setAnt(null);
				}
			}else{
				if(atual == this.tail){
					this.tail = this.tail.getAnt();
					this.tail.setProx(null);
				}else{
					atual.getProx().setAnt(atual.getAnt());
					atual.getAnt().setProx(atual.getProx());
				}
			}
		}
		this.totElem --;
		return true;
	}

	public int tamanho() {
		return 0;
	}
	public boolean contem(String obj) {
		return false;
	}
	
	public void removeDoComeco() {

	}
	public void removeDoFim() {

	}
	
	public String toString() {
		
		Nodo<T> atual = this.head;
		double tam = this.getTotElem();
		String msg= "";
		while(atual != null){
			msg += ((Agenda)atual.getDados()).getNome()+
			" | "+((Agenda)atual.getDados()).getEndereco()+
			" | "+((Agenda)atual.getDados()).getTelefone1()+
			" | "+((Agenda)atual.getDados()).getTelefone2()+
			" | "+((Agenda)atual.getDados()).getTelefone3()+
			" | "+((Agenda)atual.getDados()).getTelefone4()+
			"\n";
			atual = atual.getProx();
			tam--;
		}
        return msg;
	}

	public void append(Nodo<T> novo) {
		if (tail != null) {
			tail.setProx(novo);
		} else {
			head = novo;
		}
		tail = novo;
	}
}
