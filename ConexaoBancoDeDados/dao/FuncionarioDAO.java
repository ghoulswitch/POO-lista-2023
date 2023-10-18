package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Funcionario;
import view.TelaCadastroFuncionario;

public class FuncionarioDAO {

	public void cadastrar(Funcionario funcionario) {
        try {
            Connection conexao = FabricaDeConexao.getConexao();
            PreparedStatement stmt = conexao.prepareStatement("INSERT INTO Funcionario(nome, cargo, salario) VALUES (?, ?, ?);");
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.setDouble(3, funcionario.getSalario());
            stmt.execute();
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(TelaCadastroFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	public List<Funcionario> listaFuncionarios() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		try{
            Connection conexao = FabricaDeConexao.getConexao();
            String sql = "SELECT codigo, nome, cargo, salario FROM Funcionario";
            PreparedStatement stmt = conexao.prepareStatement(sql);    
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                String cargo = rs.getString("cargo");
                double salario = rs.getDouble("salario");

                Funcionario funcionario = new Funcionario(codigo, nome, cargo, salario);
                funcionarios.add(funcionario);
            }        

        }catch(SQLException ex){
            
        	}
		
		return funcionarios;
	}
}
