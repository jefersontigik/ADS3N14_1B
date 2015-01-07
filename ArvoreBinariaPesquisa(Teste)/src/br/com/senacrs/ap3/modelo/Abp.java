package br.com.senacrs.ap3.modelo;

import java.util.ArrayList;


public class Abp {
	private Nodo raiz;
	
	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}

	public Abp(Nodo novo){
		this.raiz = novo;
	}	

	public int encontraMax(int a, int b){
		if(a > b) 
			return a;
		else 
			return b;
	}

	public void inserir(Nodo nodo, int valor){
		
		if (valor < nodo.getDados()){
			if (nodo.getEsq()!= null){
				inserir(nodo.getEsq(), valor);
			}else{
				System.out.print("Valor " + valor + " inserido à esquerda de " + nodo.getDados()+":	");
				nodo.setEsq(new Nodo(valor));
				imprimeArvore(raiz);
				System.out.println();
				raiz = balanceamentoAVL(raiz);
			}
		}
		
		if (valor > nodo.getDados()){
			if (nodo.getDir() != null){
				inserir(nodo.getDir(), valor);
			}else{
				System.out.print("Valor " + valor + " inserido à direita de " + nodo.getDados()+":	");
				nodo.setDir(new Nodo(valor));
				imprimeArvore(raiz);
				System.out.println();
				raiz = balanceamentoAVL(raiz);
			}
		}
	}
	
	public Nodo balanceamentoAVL(Nodo nodo){
		
        if (fatorBalanceamento(nodo) == +2) {
            if (fatorBalanceamento(nodo.getDir()) == -1) {
            	System.out.print("1° Rotação Esq. em "+ nodo.getDir().getDados()+" + ");
                nodo.setDir(rotacao_esquerda(nodo.getDir())); 
            }
            System.out.println("2° Rotação Dir. em "+ nodo.getDados()+".");
            nodo = rotacao_direita(nodo); 
        }
        
        if (fatorBalanceamento(nodo) == -2) {
            if (fatorBalanceamento(nodo.getEsq()) == +1) {
            	System.out.print("3° Rotação Dir. em "+ nodo.getEsq().getDados()+" + ");
            	nodo.setEsq(rotacao_direita(nodo.getEsq()));
            } 
            System.out.println("4° Rotação Esq. em "+ nodo.getDados()+".");
            nodo = rotacao_esquerda(nodo);
        }
        return nodo;
	}
	
	public static Nodo rotacao_direita(Nodo nodo) {
//		
//		Nodo aux = nodo.getEsq();
//		if(aux.getDir() != null)
//			nodo.setEsq(aux.getDir());
//		else
//			nodo.setEsq(null);
//		aux.setDir(nodo);
		
        Nodo fe, bkp;
        
        fe = nodo.getEsq();
        if(fe.getDir() != null)
        	bkp = fe.getDir();
        else
        	bkp = null;
        fe.setDir(nodo);
        nodo.setEsq(bkp);
        return fe;
//        return aux;
    }
	
	public static Nodo  dupla_rotacao_direita(Nodo nodo){
		nodo.setDir(rotacao_direita(nodo.getDir()));
		
		return rotacao_esquerda(nodo);
	}
	
	public static Nodo rotacao_esquerda(Nodo nodo) {
        
//		Nodo aux = nodo.getDir();
//		if(aux.getEsq() != null)
//			nodo.setDir(aux.getEsq());
//		else
//			nodo.setDir(null);
//		aux.setEsq(nodo);
		
        Nodo fd, bkp;
        
        fd = nodo.getDir();
        if(fd.getEsq() != null)
        	bkp = fd.getEsq();
        else
        	bkp = null;
        fd.setEsq(nodo);
        nodo.setDir(bkp);
        
        return fd;
//		return aux;
    }
	
	public static Nodo  dupla_rotacao_esquerda(Nodo nodo){
		nodo.setEsq(rotacao_esquerda(nodo.getEsq()));
		
		return rotacao_direita(nodo);
	}

	public void imprimeTodosCaminhosRaizAteFolha(Nodo nodo,ArrayList<Integer> caminho){
		if(nodo == null){
			return;
		}
		caminho.add(nodo.getDados());

		if(nodo.getEsq() == null && nodo.getDir() == null){
			System.out.println(caminho);
			return;
		}else{
			imprimeTodosCaminhosRaizAteFolha(nodo.getEsq(), new ArrayList<Integer>(caminho));
			imprimeTodosCaminhosRaizAteFolha(nodo.getDir(), new ArrayList<Integer>(caminho));
		}	   
	}

	public static int altura(Nodo nodo){
		if (nodo == null) 
			return 0;
		return 1 + Math.max(altura (nodo.getEsq()), altura (nodo.getDir()));
	}
	
	public static int fatorBalanceamento(Nodo nodo ){
		if (nodo == null) 
			return 0;
		return altura(nodo.getEsq()) - altura(nodo.getDir());
	}

	public int somaMaxRaizAteFolha(Nodo nodo){
		if(nodo == null)
			return 0;
		return encontraMax(somaMaxRaizAteFolha(nodo.getEsq()) , somaMaxRaizAteFolha(nodo.getDir())) + nodo.getDados() ;
	}

	//	public int diametre(Nodo node, int d)
	//	{
	//		if(node==null)
	//			return 0;
	//		
	//		esq=diametre(node.left, d);
	//		dir=diametre(node.right, d);
	//		
	//		if(esq+dir+1>d)
	//			d=esq+dir+1;
	//		
	//		return findMax(esq, dir)+1;
	//	}

	public int diametro(Nodo nodo){
		if(nodo == null)
			return 0;
		else{
			return Math.max((altura(nodo.getEsq()) + altura(nodo.getDir()) + 1), Math.max(diametro(nodo.getEsq()), diametro(nodo.getDir())));
		}		
	}

	public int somaMaxCaminho(Nodo nodo){
		if(nodo == null)
			return 0;
		else{
			return Math.max( (somaMaxRaizAteFolha(nodo.getEsq())+somaMaxRaizAteFolha(nodo.getDir())+nodo.getDados()), Math.max( somaMaxCaminho(nodo.getEsq()), somaMaxCaminho(nodo.getDir()) ) );
		}
	}
	
	public void imprimeArvore(Nodo nodo){
		
		if(nodo != null){
		
//			System.out.print(nodo);		
//			if(nodo.getEsq() == null)
//				System.out.print("()");
//			else
//				imprimeArvore(nodo.getEsq());
//			if(nodo.getDir() == null)
//				System.out.print("()");
//			else
//				imprimeArvore(nodo.getDir());
			System.out.print(nodo);	
			imprimeArvore(nodo.getEsq());
			imprimeArvore(nodo.getDir());
			System.out.print(")"); 
		}		
		
	}
	
	public void imprimeArvoreEmOrdem(Nodo nodo){
		if(nodo != null){
		
			if(nodo.getEsq() == null)
				System.out.print("()");
			else
				imprimeArvore(nodo.getEsq());
			
			System.out.print(nodo);
			
			if(nodo.getDir() == null)
				System.out.print("()");
			else
				imprimeArvore(nodo.getDir());
			
			System.out.print(")"); 
			
		}
	}
	
	public void imprimeArvorePosOrdem(Nodo nodo){
		if(nodo != null){
			
			imprimeArvore(nodo.getEsq());
			imprimeArvore(nodo.getDir());
			System.out.print(nodo);
			System.out.print(")"); 
		}
	}
}
