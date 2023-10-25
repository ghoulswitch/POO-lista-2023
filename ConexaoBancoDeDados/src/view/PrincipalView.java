package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class PrincipalView extends JFrame implements ActionListener, MouseListener {

	JMenuBar mb;
	JMenu mnFuncionario, mnSistema;
	JMenuItem miCadastrarFuncionario, miConsultaFuncionario, miSair;
	private JLabel lblImageBackground;
	private JLabel lblCadastraFuncionario, lblConsultaFuncionario;
	private JLabel lblCadastraDependente, lblConsultaDependente;
	private JPanel painelSuperior, painelCentral;
	private BorderLayout layoutPrincipal;
	
	public PrincipalView() {
		setUndecorated(true);
		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(Toolkit.getDefaultToolkit().getScreenSize());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container container = getContentPane();
		//Depois de configurado os parâmetros da janela a seguinte função inicializa os componentes.
		inicializaComponentes();
		
	}
	
	public void inicializaComponentes() {       

        mb = new JMenuBar();

        mnSistema = new JMenu("Agenda");
        miSair = new JMenuItem("Sair");

        mnSistema.add(miSair);

        mnFuncionario = new JMenu("Funcionario");
        miCadastrarFuncionario = new JMenuItem("Cadastrar");
        miCadastrarFuncionario.addActionListener(this);
        miConsultaFuncionario = new JMenuItem("Consultar");
        miConsultaFuncionario.addActionListener(this);
        mnFuncionario.add(miCadastrarFuncionario);
        mnFuncionario.add(new JSeparator());
        mnFuncionario.add(miConsultaFuncionario);
        
        mb.add(mnSistema);        
        mb.add(mnFuncionario);
        
        setJMenuBar(mb);        
                
        painelCentral = new JPanel();
        painelCentral.setLayout(new FlowLayout(FlowLayout.CENTER));
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagens/img_background.jpg"));	
        lblImageBackground = new JLabel();
        lblImageBackground.setIcon(icon); //coloca a imagem na label
        painelCentral.add(lblImageBackground);
        getContentPane().add(painelCentral, BorderLayout.CENTER);
        
        painelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 5));
        painelSuperior.setPreferredSize(new Dimension(0, 150));
        getContentPane().add(painelSuperior, BorderLayout.NORTH);
        
        lblCadastraFuncionario = new JLabel(new ImageIcon(getClass().getResource("/imagens/ic_adicionar_pessoa.png")));
        lblCadastraFuncionario.setText("Cadastrar Funcionario");
        lblCadastraFuncionario.addMouseListener(this);
        lblConsultaFuncionario = new JLabel(new ImageIcon(getClass().getResource("/imagens/ic_procurar_pessoa.png")));
        lblConsultaFuncionario.setText("Consulta Funcionario");
        lblConsultaFuncionario.addMouseListener(this);       
        lblCadastraDependente = new JLabel();
        lblCadastraDependente.setText("Cadastrar Dependente");
        lblCadastraDependente.addMouseListener(this);
        lblConsultaDependente = new JLabel();
        lblConsultaDependente.setText("Consulta Dependente");
        lblConsultaDependente.addMouseListener(this);

        painelSuperior.add(lblCadastraFuncionario);
        painelSuperior.add(lblConsultaFuncionario);
        painelSuperior.add(lblCadastraDependente);
        painelSuperior.add(lblConsultaDependente);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
        if (e.getSource() == lblCadastraFuncionario){
            new CadastroFuncionarioView().setVisible(true);            
        }else if (e.getSource() == lblConsultaFuncionario){
            new ListaFuncionarioView().setVisible(true);
        }
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == miCadastrarFuncionario){
            new CadastroFuncionarioView().setVisible(true);            
        }else if (e.getSource() == miConsultaFuncionario){
            new ListaFuncionarioView().setVisible(true);
        }        
	}
	
}
