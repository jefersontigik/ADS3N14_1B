package com.br.senacrs.ap3.estruturas;

import java.util.ArrayList;
import java.util.Collections;

import com.br.senacrs.ap3.controle.GrafoInicial;


public class Grafo {
	
	private ArrayList<Aresta> arestas = new ArrayList<Aresta>();
	private ArrayList<Vertice> vertices = new ArrayList<Vertice>();
	private boolean temCiclo = false;
	private GrafoInicial grfInit = new GrafoInicial();
	private String[] vertic = null;
	private String[] arest = null;
	private int vrt = 0, art = 0, aux = 0, peso;
	private String origem , destino;
	private ArrayList<Vertice> menorCaminho = new ArrayList<Vertice>();
	
	public void limpaListas(){
		this.arestas.clear();
		this.vertices.clear();
		this.setTemCiclo(false);
	}

	public boolean possuiCiclo() {
		return temCiclo;
	}

	public void setTemCiclo(boolean temCiclo) {
		this.temCiclo = temCiclo;
	}

	public void adicionaAresta(int custo, String origem, String destino){
		int i, j, k;
		
		i = this.adicionaVertice(origem);
		j = this.adicionaVertice(destino);
		
		Aresta a = new Aresta(custo, this.vertices.get(i), this.vertices.get(j));
		
		temCiclo(a);
		this.arestas.add(a);
		k = this.arestas.size();
		
		this.vertices.get(i).adicionaIncidentes(this.arestas.get(k-1));
		this.vertices.get(j).adicionaIncidentes(this.arestas.get(k-1));
	}
			
	public void setArestas(ArrayList<Aresta> arestas) {
		this.limpaListas();
		
		for (int i = 0; i < arestas.size() ; i++)
			this.adicionaAresta(arestas.get(i).getCusto(), arestas.get(i).getOrigem().getNome(), arestas.get(i).getDestino().getNome());
	}

	public void setVertices(ArrayList<Vertice> vertices) {
		this.limpaListas();
		
		for (int i = 0; i < vertices.size() ; i++){

			if(this.posicaoVertice(vertices.get(i).getNome()) == this.vertices.size()){
				
				for(int j = 0; j < vertices.get(i).getIncidentes().size(); j++){

					if ((vertices.get(i).getNome().equals(vertices.get(i).getIncidentes().get(j).getOrigem().getNome())) &&
							(this.posicaoVertice(vertices.get(i).getIncidentes().get(j).getDestino().getNome())!=this.vertices.size())){

						this.adicionaAresta(vertices.get(i).getIncidentes().get(j).getCusto(), 
										vertices.get(i).getIncidentes().get(j).getOrigem().getNome(), 
										vertices.get(i).getIncidentes().get(j).getDestino().getNome());
						
					}else if ((vertices.get(i).getNome().equals(vertices.get(i).getIncidentes().get(j).getDestino().getNome())) &&
							(this.posicaoVertice(vertices.get(i).getIncidentes().get(j).getOrigem().getNome()) != this.vertices.size())){

						this.adicionaAresta(vertices.get(i).getIncidentes().get(j).getCusto(), 
								vertices.get(i).getIncidentes().get(j).getOrigem().getNome(), 
								vertices.get(i).getIncidentes().get(j).getDestino().getNome());
						
					}
				}
				this.adicionaVertice(vertices.get(i).getNome());
			}
		}
	}

	public int adicionaVertice(String nome){
		int i = this.posicaoVertice(nome); 
		
		if(i == this.vertices.size()){
			this.vertices.add(new Vertice(nome));
			return (this.vertices.size() -1);
		}
		
		return i;
	}
	
	public void limparVerticesPai(){
		for(int i = 0; i < this.getVertices().size() ;i++)
			this.getVertices().get(i).setPai(null);
	}
	
	public void limparVerticeVisitado(){
		for(int i = 0; i < this.getVertices().size(); i++)
			this.getVertices().get(i).setVisitado(false);
	}
	
	public void limparArestaVisitada(){
		for(int i = 0; i < this.getArestas().size(); i++)
			this.getArestas().get(i).setVisitado(false);
	}
	
	public void imprimeArvore(){
		
		for (int i = 0; i < arestas.size(); i++)
			System.out.print("("+this.arestas.get(i).getOrigem().getNome() + "; " + this.arestas.get(i).getDestino().getNome() + ") Custo: " + this.arestas.get(i).getCusto() + " | ");
		
		System.out.println();
	}

	public ArrayList<Vertice> getVertices() {
		return vertices;
	}
	
	public int posicaoVertice(String nome){
		int i;
		
		for (i = 0; i < this.vertices.size() ; i++)
			if (this.vertices.get(i).getNome().equals(nome))
				return i;
		
		return this.vertices.size();
	
	}
	
	public Vertice acharVertice(String nome){
		return this.vertices.get(this.posicaoVertice(nome));
	}
	
	public Aresta acharAresta(Vertice vet1, Vertice vet2){
		for(int i = 0; i < this.arestas.size(); i++){
			
			if( ((this.arestas.get(i).getOrigem().getNome().equals(vet1.getNome())) &&
				(this.arestas.get(i).getDestino().getNome().equals(vet2.getNome()))) ||
				((this.arestas.get(i).getOrigem().getNome().equals(vet2.getNome())) &&
				(this.arestas.get(i).getDestino().getNome().equals(vet1.getNome()))) ){
				
				return this.arestas.get(i);
			}
		}
		return null;
	}
	
	public void criarGrafo(){
		for(int i = 0; i < grfInit.dadosGrafo().size(); i++){
			if(grfInit.dadosGrafo().get(i).equals("vertices"))
				vrt = i + 1;
			
			if(grfInit.dadosGrafo().get(i).equals("arestas"))
				art = i + 1;
		}
		
		String[] vertice1 = new String[2], vertice2 = new String[2];
		
		for(; aux < grfInit.dadosGrafo().size(); aux++){
			
			if(grfInit.dadosGrafo().get(vrt).split(" ").length > 1){				
				vertic = grfInit.dadosGrafo().get(vrt).split(" ");
				arest = grfInit.dadosGrafo().get(art).split(" ");
				
				vertice1 = vertic[0].split("\\.");
				vertice2 = vertic[1].split("\\.");
				peso = Integer.parseInt(vertice2[0]) - Integer.parseInt(vertice1[0]);

				origem = arest[0];
				destino = arest[1];
				adicionaAresta(peso,origem,destino);
				vrt++;
				art++;		
								
			}
		}
	}
	
	public ArrayList<Aresta> getArestas() {
		return arestas;
	}

	public boolean temCiclo(Aresta aresta){
		
		Vertice anterior = aresta.getDestino();
		
		for(int j = 0; j < this.getArestas().size(); j++){
			
			for(int i = 0; i < this.getArestas().size(); i++){
				
				if ((aresta == this.getArestas().get(i)) && (this.getArestas().get(i).isVisitado() == false))
					this.getArestas().get(i).setVisitado(true);
				
				else if (aresta != this.getArestas().get(i)){
					
					if (anterior.getNome().equals(this.getArestas().get(i).getOrigem().getNome())){
						
						if	(aresta.getOrigem().getNome().equals(this.getArestas().get(i).getDestino().getNome())){
							
							this.limparArestaVisitada();
							this.temCiclo = true;
							return true;
							
						}else{
							
							anterior = this.getArestas().get(i).getDestino();
							this.getArestas().get(i).setVisitado(true);
						}	
						
					}else if (anterior.getNome().equals(this.getArestas().get(i).getDestino().getNome())){
						
						if	(aresta.getOrigem().getNome().equals(this.getArestas().get(i).getOrigem().getNome())){
							
							this.limparArestaVisitada();
							this.temCiclo = true;
							return true;
							
						}else{
							
							anterior = this.getArestas().get(i).getOrigem();
							this.getArestas().get(i).setVisitado(true);
						}
					}
				}
			}
		}
		this.limparArestaVisitada();
		this.temCiclo = false;
		return false;
	}
	//=================================  DIJKSTRA  ================================= 
    public ArrayList<Vertice> encontrarMenorCaminhoDijkstra(Vertice ver1,Vertice ver2) {
    	
        Vertice verticeCaminho;
        Vertice atual;
        Vertice vizinho;
        Aresta ligacao;
        ArrayList<Vertice> naoVisitados = new ArrayList<Vertice>();

        menorCaminho.add(ver1);

        for (int i = 0; i < this.getVertices().size(); i++) {
        	
            if (this.getVertices().get(i).getNome().equals(ver1.getNome()))
            	
                this.getVertices().get(i).setDistancia(0);
            
            else
            	
                this.getVertices().get(i).setDistancia(9999);

            naoVisitados.add(this.getVertices().get(i));
        }

        Collections.sort(naoVisitados);

        while (!naoVisitados.isEmpty()) {
       
            atual = naoVisitados.get(0);
            /*
             * Para cada vizinho (cada aresta), calcula-se a sua possivel
             * distancia, somando a distancia do vertice atual com a da aresta
             * correspondente. Se essa distancia for menor que a distancia do
             * vizinho, esta eh atualizada.
             */
            for (int i = 0; i < atual.getVizinhos().size(); i++) {
            	
                vizinho = atual.getVizinhos().get(i);
                
                if (!vizinho.isVisitado()) {
                
                	ligacao = this.acharAresta(atual,vizinho);
                	
                    if (vizinho.getDistancia() > (atual.getDistancia() + ligacao.getCusto())) {
                    	
                        vizinho.setDistancia(atual.getDistancia() + ligacao.getCusto());
                        vizinho.setPai(atual);

                        /*
                         * Se o vizinho eh o vertice procurado, e foi feita uma
                         * mudanca na distancia, a lista com o menor caminho
                         * anterior eh apagada, pois existe um caminho menor
                         * vertices pais, ateh o vertice origem.
                         */
                        if (vizinho == ver2) {
                        	
                            menorCaminho.clear();
                            verticeCaminho = vizinho;
                            menorCaminho.add(vizinho);
                            
                            while (verticeCaminho.getPai() != null) {
                            	
                                menorCaminho.add(verticeCaminho.getPai());
                                verticeCaminho = verticeCaminho.getPai();

                            }

                            Collections.sort(menorCaminho);

                        }
                    }
                }

            }
            atual.setVisitado(true);
            naoVisitados.remove(atual);

            Collections.sort(naoVisitados);

        }
        this.limparVerticesPai();
        
        return menorCaminho;
    }
    
    public int exibirCustoTotal(){

    	int custo = 0;
    	for(int i = 0; i < menorCaminho.size(); i++){
        	custo += menorCaminho.get(i).getDistancia();
        }
    	return custo;
    }
}