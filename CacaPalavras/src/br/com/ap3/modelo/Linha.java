package br.com.ap3.modelo;

public class Linha{
	private char[] letras;
	private int lin;
	private boolean used;
	
	public Linha(char[] c, int lin){
		this.letras = c;
		this.lin = lin;
	}
	public char[] getLetras(){
		return letras;
	}
	
	public Linha copy(){
		return new Linha(letras, lin);
	}
	
	public void setUsed(boolean b){
		this.used = b;
	}
	
	public boolean isUsed(){
		return used;
	}
	
	public int getLinha(){
		return lin;
	}
	
	public int getTam(){
		return letras.length; 
	}
	
}
