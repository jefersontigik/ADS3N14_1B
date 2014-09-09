package testeLista;

public class Lista<T> extends Nodo<T>{

	private Nodo<T> head;
	private Nodo<T> tail;
	private double totElem;

	public Lista(){
		this.head = null;
		this.tail = null;
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

	public boolean listaVazia(){
		return (this.head == null);
	}

	public void adicionaHead(T elemento) {
		Nodo<T> novoNo = new Nodo<T>(elemento);
		if(this.listaVazia())
			this.tail = novoNo;
		else{
			novoNo.setProx(this.head);
			this.head.setAnt(novoNo);
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
			novoNo.setAnt(this.tail);
			this.tail.setProx(novoNo);
		}
		this.tail = novoNo;
		this.totElem ++;
	}
	public Nodo<T> pega(String chave) {
		Nodo<T> atual = this.head;
		while((atual != null) && (((Agenda) atual.getDados()).getNome() != chave)){
			atual = atual.getProx();
		}
		return atual;
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

	public void adicionaNoComeco(T elemento) {

		Nodo<T> nova = new Nodo<T>(elemento);
		if(this.totElem == 0){
			this.tail = this.head = nova;
		}else{
			head.setProx(nova); 
			head = nova;
		}
		this.totElem++;
	}
	public void removeDoComeco() {

	}
	public void removeDoFim() {

	}

	public String toString() {

		String msg = "";
		int volta = 0;
        Nodo<T> atual = this.head;
        while(this.tail != null){
        	volta++;
              msg += ((Agenda) atual.getDados()).getNome()+" "+volta+"\n";
              atual = atual.getProx();
        }
        return msg;
	}

}
