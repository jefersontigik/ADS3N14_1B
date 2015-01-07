package com.br.senacrs.ap3.ES;

import java.io.*;
import java.util.*;

public class Teclado{
	private static InputStreamReader is = new InputStreamReader( System.in );
	private static BufferedReader br = new BufferedReader( is );
	private static StringTokenizer st;
	private static String nt;
	private static boolean debug = false;

	private static StringTokenizer getToken() throws IOException, NullPointerException{
		String s = br.readLine();
		return new StringTokenizer(s);
	} 


	public static int lerInteiro(){
		return lerInteiro(0);
	}

	public static int lerInteiro(int valorPadrao){
		try {
			st = getToken(); 
			nt = st.nextToken();
			return Integer.parseInt(nt);
		}catch (IOException ioe){
			if (debug)
				System.err.println("KEYBOARD:: Erro de entrada e saída lendo um inteiro. "+"Retorna "+valorPadrao);
			
			return valorPadrao;
		}catch (NumberFormatException nfe){
			if (debug)
				System.err.println("KEYBOARD:: Erro de conversão de "+nt+" para um inteiro. "+
						"Retorna "+valorPadrao);
			return valorPadrao;
		}catch (NoSuchElementException nsee){
			if (debug)
				System.err.println("KEYBOARD:: Entrada não contém um inteiro. "+
						"Retorna "+valorPadrao);
			return valorPadrao;
		}
	}
	
	public static String readString(){
		return lerString("");
	} 

	public static String lerString(String valorPadrao){
		try{
			nt = br.readLine();
			
			return nt.trim().length() == 0 ? valorPadrao : nt;
			
		}catch (IOException ioe){
			if (debug)
				System.err.println("KEYBOARD:: Erro de entrada e saída lendo uma string. "+"Retorna "+valorPadrao);
			return valorPadrao;
		}
	}

	public static void debugLigado(){
		debug = true;
		System.err.println("KEYBOARD:: Mostrando mensagens de erro e avisos...");
	}

	public static void debugDesl(){
		debug = false;
	} 
}