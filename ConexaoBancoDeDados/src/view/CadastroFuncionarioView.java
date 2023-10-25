package view;

import control.FuncionarioController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CadastroFuncionarioView extends JFrame implements ActionListener{
    
    private JLabel lblNome, lblSalario, lblCargo;
    private JTextField txtNome, txtSalario, txtCargo;
    private JPanel painelCenter, painelBottom;
    private JButton btnCadastrar, btnCancelar;    
    private BorderLayout layoutPai;
    private FlowLayout layoutBottom;
   
    public CadastroFuncionarioView(){
        
        setTitle("Formulário de Cadastro de Funcionário");
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
                
        Container container = getContentPane(); 

        layoutPai = new BorderLayout();
        container.setLayout(layoutPai);
        
        painelCenter = new JPanel();
        painelCenter.setLayout(null);
        
        painelBottom = new JPanel();
        layoutBottom = new FlowLayout(FlowLayout.LEFT, 25,15);
        painelBottom.setLayout(layoutBottom);
        
        container.add(painelCenter, BorderLayout.CENTER);
        container.add(painelBottom, BorderLayout.SOUTH);
        
        lblNome = new JLabel("Nome:");
        lblNome.setBounds(15,15, 100, 30);        
        txtNome = new JTextField();
        txtNome.setBounds(115, 15, 250, 30);
        
        lblCargo = new JLabel("Cargo:");
        lblCargo.setBounds(15,50, 100, 30);
        txtCargo = new JTextField();
        txtCargo.setBounds(115, 50, 100, 30);
            
        lblSalario = new JLabel("Salario:");
        lblSalario.setBounds(15, 85, 50, 30);
        txtSalario = new JTextField();
        txtSalario.setBounds(115, 85, 100, 30);

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(this);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(this);
        
        painelBottom.add(btnCadastrar);
        painelBottom.add(btnCancelar);
        painelBottom.setBackground(new Color(200,200,200));
        
        painelCenter.add(lblNome); 
        painelCenter.add(txtNome);
        painelCenter.add(lblCargo); 
        painelCenter.add(txtCargo);
        painelCenter.add(lblSalario); 
        painelCenter.add(txtSalario); 

    }

	
	@Override
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCadastrar){
            cadastrarFuncionario();
            //listarFuncionarios();
        }else if (e.getSource() == btnCancelar){
            dispose();
        }
	}
    
    public void cadastrarFuncionario(){
        String nome = txtNome.getText();
        String cargo = txtCargo.getText();
        double salario = Double.parseDouble(txtSalario.getText());
        FuncionarioController funcionarioController = new FuncionarioController();
        boolean resultado = funcionarioController.adicionarFuncionario(nome, cargo, salario);
        if (resultado){
            JOptionPane.showMessageDialog(null,"Funcionário Cadastrado!");
        }else{
            JOptionPane.showMessageDialog(null,"Problema ao Cadastrar Funcionário!");
        }
    }

    private void listarFuncionarios() {
        FuncionarioController funcionarioController = new FuncionarioController();
        java.util.List<String[]> funcionariosDados = funcionarioController.listarFuncionarios();
        for(String[] dados : funcionariosDados){
            System.out.println(dados[0]+"\t"+dados[1]+"\t"+dados[2]+"\t"+dados[3]);
        }
    }

}
