package control;

import java.util.List;
import java.util.ArrayList;
import model.Funcionario;

public class FuncionarioController {
	
	//Esse método chama o de cadastro (de Funcionario) que retorna, em valor booleano, se foi ou não cadastrado.
	public boolean adicionarFuncionario(String nome, String cargo, double salario) {
		Funcionario funcionario = new Funcionario(nome, cargo, salario);
		return funcionario.cadastrar();
		
	}
    
    public List<String[]> listarFuncionarios(){
        List<String[]> dadosFuncionarios = new ArrayList<>();
        List<Funcionario> funcionarios = Funcionario.listarFuncionarios();        
        for (Funcionario funcionario : funcionarios){
            String[] dadosFuncionario = new String[4];
            dadosFuncionario[0] = String.valueOf(funcionario.getCodigo());
            dadosFuncionario[1] = funcionario.getNome();
            dadosFuncionario[2] = funcionario.getCargo();
            dadosFuncionario[3] = String.valueOf(funcionario.getSalario());
            dadosFuncionarios.add(dadosFuncionario);
        }        
        return dadosFuncionarios;
    }
    
    public List<String[]> listarFuncionariosPorNome(String nome){
        List<String[]> dadosFuncionarios = new ArrayList<>();
        List<Funcionario> funcionarios = Funcionario.listarFuncionariosPorNome(nome);        
        for (Funcionario funcionario : funcionarios){
            String[] dadosFuncionario = new String[4];
            dadosFuncionario[0] = String.valueOf(funcionario.getCodigo());
            dadosFuncionario[1] = funcionario.getNome();
            dadosFuncionario[2] = funcionario.getCargo();
            dadosFuncionario[3] = String.valueOf(funcionario.getSalario());
            dadosFuncionarios.add(dadosFuncionario);
        }        
        return dadosFuncionarios;
    }    
        
}
