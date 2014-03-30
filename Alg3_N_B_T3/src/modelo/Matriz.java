package modelo;

public class Matriz {
	
	private static int linha = 10;
	private static int coluna = 10;
	private String[][] matriz = new String[getLinha()][getColuna()];
	
	
	public static int getLinha() {
		return linha;
	}
	public static int getColuna() {
		return coluna;
	}
	public String[][] getMatriz() {
		return matriz;
	}
	public void setMatriz(String[][] matriz) {
		this.matriz = matriz;
	}
	
}
