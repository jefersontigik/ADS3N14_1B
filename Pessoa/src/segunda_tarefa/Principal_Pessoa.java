package segunda_tarefa;

import javax.swing.JOptionPane;

public class Principal_Pessoa {

	public static void main(String[] args) {
		Pessoa p = new Pessoa();
		p.setNome(JOptionPane.showInputDialog("Informe o nome da pessoa: "));
		p.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Informe a idade da pessoa: ")));
		
		JOptionPane.showMessageDialog(null, "Dados informados: \nNome pessoa: "+p.getNome()+"\nIdade pessoa: "+ p.getIdade());

	}

}
