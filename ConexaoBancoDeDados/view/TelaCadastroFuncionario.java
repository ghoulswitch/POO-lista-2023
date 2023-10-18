package view;

import dao.FabricaDeConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import model.Funcionario;

public class TelaCadastroFuncionario extends JFrame implements ActionListener{
    
    private JLabel lblNome, lblSalario, lblCargo;
    private JTextField txtNome, txtSalario, txtCargo;
    private JPanel painelCenter, painelBottom;
    private JButton btnCadastrar, btnCancelar;    
    
    private BorderLayout layoutPai;
    private FlowLayout layoutBottom;
   
    public TelaCadastroFuncionario(){
        
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
        }else if (e.getSource() == btnCancelar){
            dispose();
        }
    }
    
    public void cadastrarFuncionario(){
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(txtNome.getText());
        funcionario.setCargo(txtCargo.getText());
        funcionario.setSalario(Double.parseDouble(txtSalario.getText()));
                
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

                funcionario.setCodigo(codigo);
                funcionario.setNome(nome);
                funcionario.setCargo(cargo);
                funcionario.setSalario(salario);                    
                System.out.println(funcionario.toString());
            }        

        }catch(SQLException ex){
            
        }        
    }
}