package Exemplo.Pacote;
import javax.swing.JOptionPane;
import Exemplo.Dependente;

public class ExemploPacote {
	public static void main(String[] args) {
		
		String resposta;
		
		resposta = JOptionPane.showInputDialog("Insira seu código:");
		int codigo = Integer.parseInt(resposta);
		
		String nome = JOptionPane.showInputDialog("Insira seu nome:");
		
		resposta = JOptionPane.showInputDialog("Insira sua idade");
		int idade = Integer.parseInt(resposta);
	
		Dependente dependente = new Dependente(codigo, nome, idade);
		
		//JOptionPane.showConfirmDialog(null, "O seu nome é: " + nome);
		//JOptionPane.showConfirmDialog(null, "Sua idade é: " + idade);
		//JOptionPane.showConfirmDialog(null, "O seu código é: " + codigo);
		
		String mensagem = "O seu nome: " + nome + "\nSua idade: " + idade + "\nSeu código: " + codigo;
				
		JOptionPane.showMessageDialog(null, mensagem);
		
	}

}
