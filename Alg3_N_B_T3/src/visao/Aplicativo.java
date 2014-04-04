package visao;

import static java.lang.System.out;

public class Aplicativo {

	public static void main(String[] args) {

		Tela tela = new Tela();

		while(!tela.menuInicioUser().equals("2")){
			tela.posicionaBarcos();
			char op;
			do{
				op = tela.menuJogoUser().charAt(0);
				switch (op) {
				case '1':
					tela.jogo(Integer.parseInt(tela.coordX()), Integer.parseInt(tela.coordY()));
					break;

				case '2':
					out.println("Jogo Encerrado!");
					System.exit(0);
					break;
				
				default:
					out.println("Opção Inválida!");
					break;
				}
			}while(op != '2');
		}
		out.println("Jogo Encerrado!");
	}
}
