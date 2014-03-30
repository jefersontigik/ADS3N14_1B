package modelo;

public class Matriz {
	
	private static int linha = 10;
	private static int coluna = 10;
	private char[][] matriz = new char[getLinha()][getColuna()];
	
	
	public static int getLinha() {
		return linha;
	}
	public static int getColuna() {
		return coluna;
	}
	public char[][] getMatriz() {
		return matriz;
	}
	public void setMatriz(char[][] matriz) {
		this.matriz = matriz;
	}
	
}
