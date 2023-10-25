package view;

import control.FuncionarioController;
import model.ListaFuncionarioTableModel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

import control.FuncionarioController;

public class ListaFuncionarioView extends JFrame implements ActionListener, KeyListener {

	   
    private JLabel lblNome;
    private JTextField txtNome;
    private JButton btnPesquisar;    
    private JTable tblFuncionarios;
    private JPanel painelSuperior;
    
    public ListaFuncionarioView(){
        setTitle("Consulta de Funcionários");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        inicializaComponentes();
        pack();
    }
    
    private void inicializaComponentes(){
        painelSuperior = new JPanel();
        painelSuperior.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));
        
        lblNome = new JLabel("Nome: ");
        txtNome = new JTextField(30);
        txtNome.setToolTipText("Digite o nome do funcionário que deseja pesquisar.");
        btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.addActionListener(this);
        painelSuperior.add(lblNome);
        painelSuperior.add(txtNome);
        painelSuperior.add(btnPesquisar);
        
        getContentPane().add(painelSuperior, BorderLayout.NORTH);

        tblFuncionarios = new JTable(new ListaFuncionarioTableModel());
        JScrollPane scrollTable = new JScrollPane(tblFuncionarios);
                
        getContentPane().add(scrollTable, BorderLayout.CENTER);
        
    }

    
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
        String nome = txtNome.getText();
        List<String[]> dadosFuncionarios = new FuncionarioController().listarFuncionariosPorNome(nome);
        tblFuncionarios.setModel(new ListaFuncionarioTableModel(dadosFuncionarios));
	}
    
    
}
