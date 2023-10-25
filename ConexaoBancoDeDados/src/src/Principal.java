package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dao.FabricaDeConexao;

public class Principal {
	
	public static void main(String[] args) {
		Connection conexao = FabricaDeConexao.getConexao();
		
		try {
			PreparedStatement stmt = conexao.prepareStatement("INSERT INTO Funcionario(nome, cargo, salario) VALUES (?, ?, ?);");
            stmt.setString(1, "Joao");
            stmt.setString(2, "Analista");
            stmt.setDouble(3, 3500);
            stmt.execute();
			conexao.close();
		}catch (SQLException ex) {
			System.out.println(ex.toString());
		}
	}

}
