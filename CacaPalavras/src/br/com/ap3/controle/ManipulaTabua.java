package br.com.ap3.controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import br.com.ap3.controle.ManipulaArquivo;
import br.com.ap3.modelo.Linha;

public class ManipulaTabua {
	private Linha[] palavras;
	private Linha[] tabua;
	private int width;
	private int height;
	private Random r = new Random();
	private boolean invalida = false;
	static ManipulaTabua tabuleiro;
	static ArrayList<String> palavra;

	public ManipulaTabua(ArrayList<String> palavra, int x, int y){
		width = x;
		height = y;
		char[] c;
		tabua = new Linha[height];
		for (int i = 0; i< height; i++){
			c = new char[width];
			for(int j = 0; j< x; j++){
				c[j] = ' ';
			}
			tabua[i] = new Linha(c,0);
		}
		palavras = new Linha[palavra.size()];
		for (int i=0; i < palavra.size(); i++){
			String s = palavra.get(i).toString();
			Linha l = new Linha(s.toCharArray(),0);
			
			if (s.length() > x && s.length() > y)
				invalida = true;
			
			palavras[i] = l;
		}
		tabua = preencheVazios(geraTabua(tabua));
	}

	public char[][] getTabua(){
		char[][] resp = new char[height][width];
		for(int i=0; i < height; i++)
			for(int j = 0; j<width; j++)
				resp[i][j] = tabua[i].getLetras()[j];

		return resp;
	}
	
	private Linha[] preencheVazios(Linha[] lins){
		char[] c = new char[width];		
		for (int i = 0; i < lins.length; i++){
			c = lins[i].getLetras();
			for(int j = 0; j< width; j++)
				if (c[j] == ' ') c[j] = sorteiaLetra();
			tabua[i] = new Linha(c,0);
		}
		return lins;
	}
	
	public Linha[] geraTabua(Linha[] t){
		Linha pal = restantes(); 
		if (pal == null || invalida)
			return t;
		while (true){		
			int x = 0 + r.nextInt()%(width - 0);
			int y = 0 + r.nextInt()%(height - 0);
			if (x < 0) x = 0 - x;
			if (y < 0) y = 0 - y;
			
			int direcao = 0 + r.nextInt()% 3;
			int inverte = 0 + r.nextInt()% 4;
			if (inverte == 0){
				for (int i=0; i < pal.getLetras().length; i++){
					char aux = pal.getLetras()[i];
					pal.getLetras()[i] = pal.getLetras()[pal.getLetras().length - i - 1];
					pal.getLetras()[pal.getLetras().length - i - 1] = aux;
				}
			}
			if (direcao < 0) 
				direcao = 0 - direcao; 
			
			if (cabeLinha(x, y, t, pal) && direcao == 0)
				return geraTabua(posicionaLinha(x, y, t, pal));
			
			if (cabeColuna(x, y, t, pal) && direcao == 1)
				return geraTabua(posicionaColuna(x, y, t, pal));

			if (cabeDiagonal(x, y, t, pal) && direcao == 2)
				return geraTabua(posicionaDiagonal(x, y, t, pal));					
		}
		
	}
	
	private Linha[] posicionaLinha(int x, int y, Linha[] t, Linha pal){
		Linha[] lins = new Linha[height];
		Linha l;
		for (int i = 0; i < t.length; i++)
			 lins[i] = t[i].copy();
		l = lins[y];
		for (int j = 0; j <= pal.getLetras().length-1; j++)
			l.getLetras()[x + j] = pal.getLetras()[j];
		pal.setUsed(true);
		return lins;
	}

	private Linha[] posicionaColuna(int x, int y, Linha[] t, Linha pal){
		Linha[] lins = new Linha[height];
		Linha l;
		for (int i = 0; i < t.length; i++)
			 lins[i] = t[i].copy();
		for (int i = 0; i <= pal.getLetras().length-1; i++){
			l = lins[y + i];			
			l.getLetras()[x] = pal.getLetras()[i];
		}
		pal.setUsed(true);
		return lins;
	}

	private Linha[] posicionaDiagonal(int x, int y, Linha[] t, Linha pal){
		Linha[] lins = new Linha[height];
		Linha l;
		for (int i = 0; i < t.length; i++)
			 lins[i] = t[i].copy();
		int i = 0;
		
		while(i <= pal.getLetras().length-1){
			l = lins[y + i];			
			l.getLetras()[x + i] = pal.getLetras()[i];
			i++;
		}
		pal.setUsed(true);
		return lins;
	}	
	
	
	private boolean cabeLinha(int x, int y, Linha[] tab, Linha l){
		char[] c = l.getLetras();
		boolean encontrou;
		char[] t = tab[y].getLetras();
		encontrou = true;
		
		if (width-x < c.length) return false;
		int j;
		for ( j = x; j < width && j < (x + c.length) ; j++){
			if (t[j] != c[j - x] && t[j] != ' '){
				encontrou = false;
				break;
			}
		}
		if (encontrou && j >= x + c.length )
			return true;		
		return false;
	}

	private boolean cabeColuna(int x, int y, Linha[] tab, Linha l){
		char[] c = l.getLetras();
		boolean encontrou;
		encontrou = true;
		
		if (height-y < c.length) return false;
		int i;
		for (i = y; i < height && i < (y + c.length) ; i++){
			char[] t = tab[i].getLetras();			
			if (t[x] != c[i-y] && t[x] != ' '){
				encontrou = false;
				break;
			}
		}
		if (encontrou && i >= y + c.length )
			return true;	
		return false;
	}
	
	private boolean cabeDiagonal(int x, int y, Linha[] tab, Linha l){
		char[] c = l.getLetras();
		boolean encontrou;
		encontrou = true;
		
		if (height - y < c.length || width-x < c.length) return false;
		int i = y;
		int j = x;
		while (i < height && j < width && i < (y + c.length) && j < (x + c.length)){
			char[] t = tab[i].getLetras();
			if (t[j] != c[j-x] && t[j] != ' '){
				encontrou = false;
				break;
			}
			i++;
			j++;
		}
		if (encontrou && i >= (y + c.length) && (j >= x + c.length))
			return true;	
		return false;
	}	
	
	private Linha restantes(){
		for (int i = 0; i< palavras.length; i++)
			if (!palavras[i].isUsed())
				return palavras[i];
		return null;
	}
	
	private char sorteiaLetra(){
		char c = (char) r.nextInt();
		return (char)((int)'a' + ((int)c %((int)'z' - (int)'a')));
	}
	
	public Set<String> carregaLista(){
		String linha = "";
		ManipulaArquivo<String> arq = new ManipulaArquivo<String>();
		Set<String> lista = new TreeSet<String>();

		try {
			arq.abreArquivoR("BaseCacaPalavras.txt");
			linha = arq.lerArquivo();

			while (linha != null) {

				String palavra  = linha;
				lista.add(palavra);
				linha = arq.lerArquivo();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public void geraMatriz(ArrayList<String> palavra, int x, int y){
		tabuleiro = new ManipulaTabua(palavra, x, y);
		char t[][] = tabuleiro.getTabua();
		for(int i = 0; i < y; i++){
			for(int j = 0; j < x; j++){
				System.out.print(t[i][j]);
				System.out.print(" ");
			}
			System.out.println(" ");			
		}
	}
}
