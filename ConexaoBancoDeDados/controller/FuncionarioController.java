package controller;

import java.util.ArrayList;
import java.util.List;

import dao.FuncionarioDAO;
import model.Funcionario;

public class FuncionarioController {

	public boolean cadastrarFuncionarios(String nome, String cargo, double salario) {
		
		Funcionario funcionario = new Funcionario(nome, cargo, salario);
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.cadastrar(funcionario);
		
		return true;
	}
	
	public List<String[]> listaFuncionarios() {
		List<String[]> dadosFuncionarios = new ArrayList<String[]>();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    	List<Funcionario> funcionarios = funcionarioDAO.listaFuncionarios();
    	for(Funcionario func : funcionarios) {
        	String[] dados = new String[4];
        	dados[0] = String.valueOf(func.getCodigo());
        	dados[1] = func.getNome();
        	dados[2] = func.getCargo();
        	dados[3] = String.valueOf(func.getSalario());
        	dadosFuncionarios.add(dados);
        }
    	return dadosFuncionarios;
	}
}
