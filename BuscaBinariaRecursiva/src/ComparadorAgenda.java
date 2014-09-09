import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class ComparadorAgenda implements Comparator<Agenda>{
	public int compare(Agenda p1, Agenda p2) { 
		{ 
			int res = 0; 
			if (p1.getNome().compareTo(p2.getNome()) < 0) 
				res = -1; 
			if (p1.getNome().compareTo(p2.getNome()) == 1) 
				res = 1; 
			return res; 
		} 
	} 

	public static Agenda PesquisarPorNome(ArrayList<Agenda> ListaASerPesquisada, String chave){ 
		// Como faremos uma busca binária, a Lista Precisa ser ordenada: 
		Collections.sort(ListaASerPesquisada , new ComparadorAgenda()); // Ordena a Lista com uma nova instância do objeto comparador 
		Agenda ag = new Agenda(); 
		ag.setNome(chave); // Essa pessoa será usada como critério de comparação para a busca binária 
		int ResultIndex = Collections.binarySearch(ListaASerPesquisada, ag, new ComparadorAgenda()); // Busca Binária com o objeto comparador 
		if (ResultIndex >-1){ 
			return ag; 
		}else { 
			return null; 
		} 
	} 
}
