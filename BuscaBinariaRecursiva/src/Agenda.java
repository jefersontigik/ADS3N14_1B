

public class Agenda{
	
	private String nome;
	private String endereco;
	private String telefone1;
	private String telefone2;
	private String telefone3;
	private String telefone4;
	
	public Agenda(){
		this.nome = null;
		this.endereco = null;
		this.telefone1 = null;
		this.telefone2 = null;
		this.telefone3 = null;
		this.telefone4 = null;
	}
	
	public Agenda(String nome){
		this.nome = nome;
		this.endereco = null;
		this.telefone1 = null;
		this.telefone2 = null;
		this.telefone3 = null;
		this.telefone4 = null;
	}
	
	public Agenda(String nome, 
			String endereco, 
			String telefone1, 
			String telefone2, 
			String telefone3, 
			String telefone4){
		this.nome = nome;
		this.endereco = endereco;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.telefone3 = telefone3;
		this.telefone4 = telefone4;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}
	public String getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
	public String getTelefone3() {
		return telefone3;
	}
	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}
	public String getTelefone4() {
		return telefone4;
	}
	public void setTelefone4(String telefone4) {
		this.telefone4 = telefone4;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Agenda other = (Agenda) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
}
