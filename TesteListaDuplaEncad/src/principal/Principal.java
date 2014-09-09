package principal;

public class Principal {

	public static void main(String[] args) {
		
		Lista<Object> lista = new Lista<Object>();
		
		Agenda dado = new Agenda();
		dado.setNome("Paulo");
		dado.setEndereco("Rua As");
		dado.setTelefone1("96125412");
		lista.adicionaNoComeco(dado);
		
		dado.setNome("Ana");
		dado.setEndereco("Rua Dois");
		dado.setTelefone1("19426521");
		lista.adicionaNoComeco(dado);
		
		dado.setNome("Maria");
		dado.setEndereco("Rua Acesso");
		dado.setTelefone1("784083740");
		lista.adicionaNoComeco(dado);
		
		System.out.println(lista.toString());

	}

}
