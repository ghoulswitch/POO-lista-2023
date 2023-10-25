package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import model.Funcionario;

public class FuncionarioDAO {
	//É um método C# para adicionar um novo funcionário a uma base de dados em uma tabela chamada "Funcionário" 
	public static boolean adicionarFuncionario(Funcionario funcionario) {
		//O método usa SQL INSERT p adicionar as informações do funcionário na tabela
		String sql = "INSERT INTO Funcionario (nome, cargo, salario) VALUES(?,?,?)";
		try {
			//Cria conexão com o banco de dados e prepara para adicionar um novo funcionário na tabela "Funcionario" com as colunas "nome", "cargo" e "salário".
			Connection conexao = FabricaDeConexao.getConexao();
			//Objeto para inserir os valores passados como parâmetros do método.
			PreparedStatement stmt = conexao.prepareStatement(sql);
			//Setar os valores dos parâmetros da instrução SQL
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getCargo());
			stmt.setDouble(3, funcionario.getSalario());
			stmt.execute();
			conexao.close();
			return true;
		}catch (SQLException ex) {
			System.out.println(ex.toString());
		}
		return false;
	}
	
	//Criar os métodos para atualizar, deletar e listar por atributos
	
	//Método que lista os funcionários na tabela Funcionário do banco.
	public static List<Funcionario> listarFuncionarios() {
		List<Funcionario> funcionarios = new ArrayList<>();
		String sql = "SELECT codigo, nome, cargo, salario"
				+ "FROM Funcionario";
		try {
			//Conexão com o banco e cria uma consulta, se a conexão falhar é usado o "System.exit" para encerrar a aplicação.
			Connection conexao = FabricaDeConexao.getConexao();
			if (conexao == null) {
				System.out.println("Sem conexao");
				System.exit(0);
			}
			
			Statement stmt = conexao.createStatement();
			System.out.println("Statement criada!");
			
			//Executa a consulta SQL no banco e retorna ResultSet p processar os resultados da consulta
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("Query criada!");
			
			//Verifica se tem mais registros no ResultSet, se tiver o códgio abaixo será executado
			while (rs.next()) {
				int codigo = rs.getInt("codigo");
				String nome = rs.getString("nome");
				String cargo = rs.getString("cargo");
				double salario = rs.getDouble("salario");
				
				Funcionario funcionario = new Funcionario(codigo, nome, cargo, salario);
				funcionarios.add(funcionario);
				System.out.println(funcionario.toString());
				}
			conexao.close();
			} catch (SQLException ex) {
				System.out.println(ex.toString());
		}
		return funcionarios;
	}

	public static List<Funcionario> listarFuncionariosPorNome(String nomeDePesquisa) {
		List<Funcionario> funcionarios = new ArrayList<>();
		String sql = "SELECT codigo, nome, cargo, salario"
				+ "FROM Funcionario"
				+ "WHERE nome like CONCAT(?, '%')";
		try {
			
			Connection conexao = FabricaDeConexao.getConexao();
			if(conexao == null) {
				System.out.println("Sem conexao");
				System.exit(0);
			}
			
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, nomeDePesquisa);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int codigo = rs.getInt("codigo");
				String nome = rs.getString("nome");
				String cargo = rs.getString("cargo");
				double salario = rs.getDouble("salario");
				Funcionario funcionario = new Funcionario(codigo, nome, cargo, salario);
				funcionarios.add(funcionario);
				
			}
			
			conexao.close();
			
		}catch (SQLException ex) {
			System.out.println(ex.toString());
		}
		return funcionarios;
	}
	
}
