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

					tela.atualizaTela(Integer.parseInt(tela.coordX()), Integer.parseInt(tela.coordY()));
					break;
				case '2':

					break;

				case '3':
					out.println("Jogo Encerrado!");
					System.exit(0);
					break;

				default:
					out.println("Opcao Invalida!");
					break;
				}
			}while(op != '3');
		}
		out.println("Jogo Encerrado!");
	}
}
