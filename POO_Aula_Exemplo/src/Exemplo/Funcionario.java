package Exemplo;

public class Funcionario extends Pessoa {
	
	private float salario;
	
	public Funcionario(int codigo, String nome, int idade, float salario) {
		super(codigo, nome);
		this.salario = salario;
	}

}
