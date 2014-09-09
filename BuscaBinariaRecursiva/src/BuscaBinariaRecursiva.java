import java.util.Arrays;
import java.util.Scanner;


public class BuscaBinariaRecursiva {

	public static void main(String []args){          
        try{  
            Scanner entrada = new Scanner(System.in);  
              
            String nome[] = new String[10];  
            int comeco, meio = 0, fim;  
            boolean acha = false;  
            String pesquisa = "", desejo = "";  
            char continua = 'S';  
              
            /* Entrada de dados */  
            for (int i = 0; i < nome.length; i++){  
                System.out.print("\nEntre com o " + (i+1) + "° nome !");  
                nome[i] = entrada.next().toUpperCase();  
                System.out.println("Posição Cadastro = " + i);  
            }  
              
            /* Comando de ordenação */               
            Arrays.sort(nome);  
            System.out.println("\n       Nomes ordenados \n");  
              
            for (int i = 0; i < nome.length; i++){  
                System.out.println(nome[i]);  
            }  
              
            /* Método pesquisar */              
            do{  
                System.out.println("\nEntre com o nome a ser pesquisado !");  
                pesquisa = entrada.next();  
                  
                comeco = 0;  
                fim = nome.length;  
                acha = false;  
                  
                while(comeco < fim){  
                    meio = ((comeco + fim)/2);  
                    if(pesquisa.toUpperCase().equalsIgnoreCase(nome[meio])){  
                        acha = true;  
                        break;  
                    }  
                    else{  
                        if(pesquisa.toUpperCase().startsWith(nome[meio]))  
                            fim = meio - 1;  
                        else   
                            comeco = meio + 1;  
                    }          
                }  
                  
                if(acha){  
                    System.out.println("O nome " + pesquisa + " foi localizado na posição " + meio);  
                }else{  
                    System.out.println("O nome " + pesquisa + " não foi localizado !");  
                }  
                System.out.println("Deseja continuar, S/N ? ");  
                desejo = entrada.next().toUpperCase();  
                continua = desejo.charAt(0);                
            }while(continua != 'N');    
            System.in.read();  
        }catch(Exception erro){  
            System.exit(0);              
        }  
    }   
	
//	public static void main(String[] args) {
//		int[] array = { 1, 8, 34, 67, 9, 6, 78, 12, 56, 41, 90 };
//		Arrays.sort(array);
//		System.out.println(Arrays.toString(array));
//		System.out.println(busca(array, 6));
//		System.out.println(busca(array, 78));
//		System.out.println(busca(array, 90));
//	}
//
//	private static int busca(int[] array, int chave) {
//		return buscaBinariaRecursiva(array, 0, array.length - 1, chave);
//	}
//
//	private static int buscaBinariaRecursiva(int[] array, int menor, int maior,
//			int chave) {
//		int media = (maior + menor) / 2;
//		int valorMeio = array[media];
//
//		if (menor > maior)
//			return -1;
//		else if(valorMeio == chave) 
//			return media;
//		else if (valorMeio < chave)
//			return buscaBinariaRecursiva(array, media+1, maior, chave);
//		else
//			return buscaBinariaRecursiva(array, menor, media-1, chave);
//	}
}
