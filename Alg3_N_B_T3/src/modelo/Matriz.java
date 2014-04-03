package modelo;

public class Matriz {
	
	private static int linha = 10;
	private static int coluna = 10;
	private int[][] matriz = new int[getLinha()][getColuna()];
	
	
	public static int getLinha() {
		return linha;
	}
	public static int getColuna() {
		return coluna;
	}
	public int[][] getMatriz() {
		return matriz;
	}
	public void setMatriz(int x, int y, int valor) {
		this.matriz[x][y] = valor;
	}
	
}
