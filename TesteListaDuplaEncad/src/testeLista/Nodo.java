package testeLista;

public class Nodo <T> extends Agenda{
	
	private T dados;
	private Nodo<T> prox;
	private Nodo<T> ant;
	
	public Nodo(){
		this.dados = null;
		this.prox = null;
		this.ant = null;
	}
	
	public Nodo(T dados){
		this.dados = dados;
		this.prox = null;
		this.ant = null;
	}

	public T getDados() {
		return dados;
	}

	public void setDados(T dados) {
		this.dados = dados;
	}

	public Nodo<T> getProx() {
		return prox;
	}

	public void setProx(Nodo<T> prox) {
		this.prox = prox;
	}

	public Nodo<T> getAnt() {
		return ant;
	}

	public void setAnt(Nodo<T> ant) {
		this.ant = ant;
	}

}
