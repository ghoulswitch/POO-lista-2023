package DoisdoOito;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MinhaJanela extends JFrame {
	
	JLabel label;
	JButton button;
	JTextField textField;
	
	public MinhaJanela() {
		
		//título da janela
			setTitle("Motivo da minha morte:");
			setSize(400, 350);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//título do lado espaço p usuário preencher sla
			label = new JLabel("Funcionaaa");
	        label.setSize(80, 50);
	        label.setLocation(15, 2);
	        
	        //cria um botão
	        button = new JButton("Clique aqui");
	        button.setLocation(15, 65);
	        button.setSize(100, 39);
	        
	        //cria uma linha de texto?
	        textField = new JTextField();
	        textField.setLocation(100, 15);
	        textField.setSize(100, 25);
	        
	        Container container = getContentPane();
	        container.setLayout(null);
	        container.add(label);
	        container.add(button);
	        container.add(textField);
		}

	

}
