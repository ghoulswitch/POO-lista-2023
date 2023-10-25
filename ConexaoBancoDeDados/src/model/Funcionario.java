package model;

import java.util.List;
import dao.FuncionarioDAO;

public class Funcionario {
	
	private int codigo;
	private String nome;
	private String cargo;
	private double salario;
	
	//Atributos e construtores para criação de um novo objeto da classe Funcionario
	public Funcionario(int codigo, String nome, String cargo, double salario) {
		this.codigo = codigo;
		this.nome = nome;
		this.cargo = cargo;
		this.salario = salario;
	}
	
	public Funcionario(String nome, String cargo, double salario) {
		this.nome = nome;
		this.cargo = cargo;
		this.salario = salario;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	//Aceita um valor como parâmetro e atualiza
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	//Aceita um valor como parâmetro e atualiza
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCargo() {
		return cargo;
	}

	//Aceita um valor como parâmetro e atualiza
	public void setCargo(String cargo) {
		this.cargo = cargo;
		
	}
	
	public double getSalario() {
		return salario;
		
	}
	
	//Aceita um valor como parâmetro e atualiza
	public void setSalario(double salario) {
		this.salario = salario;
		
	}
	
	public String toString() {
		return "Funcionario{" + "codigo=" + codigo + ", nome=" + nome + ", cargo=" + cargo + ", salario=" + salario + '}';
		
	}
	
	//Chama o DAO e retorna um valor boolenano indicando se foi adicionado um novo funcionário ou não na tabela
	//"adicionarFuncionario" pertence a clsse FuncionarioDAO, que é responsável por gerenciar a conexão com o banco de dados
	public boolean cadastrar() {
		return FuncionarioDAO.adicionarFuncionario(this);
		
	}
	
	public static List<Funcionario> listarFuncionarios() {
		return FuncionarioDAO.listarFuncionarios();
		
	}
	
	public static List<Funcionario> listarFuncionariosPorNome(String nome) {
		return FuncionarioDAO.listarFuncionariosPorNome(nome);
	}

}
