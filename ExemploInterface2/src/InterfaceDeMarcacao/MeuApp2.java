package InterfaceDeMarcacao;

public class MeuApp2 {
	
	public void calcularSalarioDeFuncionario(Funcionario funcionario) {
		if (funcionario instanceof Gerente) {
			
		}else if (funcionario instanceof Coordenador) {
			
		}else if (funcionario instanceof Operador) {
			
			//Em vez de ficar criando um método para cada tipo 
			//de funcionário, juntamos tudo em apenas 1 utilizando 
			//a interface de marcação.
			
		}
		
	}

}
