package interfacesCliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

public class interfaceClientesCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField inputNomeCliente;
	private JTextField inputDescricaoCliente;
	private JTextField inputRuaCliente;
	private JTextField inputDataNascimentoCliente;
	private JTextField inputTelefoneCliente;
	private JTextField inputCepCliente;
	private JTextField inputBairroCliente;
	private JTextField inputCidadeCliente;
	private JTextField inputCpfCLiente;
	private JTextField inputEstadoCliente;

	/**
	 * Launch the application.
	 */
	public static void clienteConsulta() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfaceClientesCadastro frame = new interfaceClientesCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public interfaceClientesCadastro () {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 481);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnConsularClientes = new JButton("Consular Clientes");
		menuBar.add(btnConsularClientes);
		
		JButton btnCadastrarClientes = new JButton("Cadastrar Clientes");
		menuBar.add(btnCadastrarClientes);
		
		JButton btnDeletarClientes = new JButton("Deletar Clientes");
		menuBar.add(btnDeletarClientes);
		
		JButton btnAtualizarClientes = new JButton("Atualizar Clientes");
		menuBar.add(btnAtualizarClientes);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeDoCliente = new JLabel("Nome do Cliente:");
		lblNomeDoCliente.setBounds(12, 12, 121, 29);
		contentPane.add(lblNomeDoCliente);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(12, 53, 31, 15);
		contentPane.add(lblCpf);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(487, 53, 67, 15);
		contentPane.add(lblTelefone);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		lblDataDeNascimento.setBounds(166, 53, 147, 15);
		contentPane.add(lblDataDeNascimento);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(12, 80, 54, 30);
		contentPane.add(lblEstado);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(176, 88, 54, 15);
		contentPane.add(lblCidade);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(523, 80, 31, 20);
		contentPane.add(lblCep);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(349, 88, 48, 15);
		contentPane.add(lblBairro);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(12, 122, 70, 15);
		contentPane.add(lblRua);
		
		JLabel lblDescrio = new JLabel("Descrição:");
		lblDescrio.setBounds(12, 156, 74, 15);
		contentPane.add(lblDescrio);
		
		//Ler o que foi digitado
		inputNomeCliente = new JTextField();
		inputNomeCliente.setBounds(140, 17, 388, 19);
		contentPane.add(inputNomeCliente);
		inputNomeCliente.setColumns(10);
		
		
			
		inputDescricaoCliente = new JTextField();
		inputDescricaoCliente.setColumns(10);
		inputDescricaoCliente.setBounds(104, 154, 388, 19);
		contentPane.add(inputDescricaoCliente);
		
		
		inputRuaCliente = new JTextField();
		inputRuaCliente.setColumns(10);
		inputRuaCliente.setBounds(49, 122, 388, 19);
		contentPane.add(inputRuaCliente);
		
		inputDataNascimentoCliente = new JTextField();
		inputDataNascimentoCliente.setColumns(10);
		inputDataNascimentoCliente.setBounds(313, 51, 163, 19);
		contentPane.add(inputDataNascimentoCliente);
		
		
		inputTelefoneCliente = new JTextField();
		inputTelefoneCliente.setColumns(10);
		inputTelefoneCliente.setBounds(559, 51, 145, 19);
		contentPane.add(inputTelefoneCliente);
		
		inputCepCliente = new JTextField();
		inputCepCliente.setColumns(10);
		inputCepCliente.setBounds(559, 86, 145, 19);
		contentPane.add(inputCepCliente);
		
		
		inputBairroCliente = new JTextField();
		inputBairroCliente.setColumns(10);
		inputBairroCliente.setBounds(402, 86, 110, 19);
		contentPane.add(inputBairroCliente);
		
		
		inputCidadeCliente = new JTextField();
		inputCidadeCliente.setColumns(10);
		inputCidadeCliente.setBounds(233, 86, 110, 19);
		contentPane.add(inputCidadeCliente);
		
		
		inputCpfCLiente = new JTextField();
		inputCpfCLiente.setColumns(10);
		inputCpfCLiente.setBounds(49, 51, 110, 19);
		contentPane.add(inputCpfCLiente);
		
		
		inputEstadoCliente = new JTextField();
		inputEstadoCliente.setColumns(10);
		inputEstadoCliente.setBounds(73, 86, 90, 19);
		contentPane.add(inputEstadoCliente);
		
		
		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Limpa as informações
				inputNomeCliente.setText("");
				inputCpfCLiente.setText("");
				inputDataNascimentoCliente.setText("");				
				inputTelefoneCliente.setText("");
				inputEstadoCliente.setText("");
				inputCidadeCliente.setText("");
				inputBairroCliente.setText("");				
				inputCepCliente.setText("");
				inputRuaCliente.setText("");
				inputDescricaoCliente.setText("");
			
			}
		});
		btnNewButton.setBounds(471, 380, 117, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cadastro");
		
		try {
		btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed  (ActionEvent e) {
		    	
		   //Insere no Database as informações do cliente
//		HibernateUtilCadastroClientes.persistirCliente(inputNomeCliente.getText(), inputCpfCLiente.getText(), inputDataNascimentoCliente.getText(),
//				inputTelefoneCliente.getText(),inputEstadoCliente.getText(), inputCidadeCliente.getText(), inputBairroCliente.getText(),
//				inputCepCliente.getText(),inputRuaCliente.getText(), inputDescricaoCliente.getText());
		
		//Limpa após inserir os dados
		inputNomeCliente.setText("");
		inputCpfCLiente.setText("");
		inputDataNascimentoCliente.setText("");				
		inputTelefoneCliente.setText("");
		inputEstadoCliente.setText("");
		inputCidadeCliente.setText("");
		inputBairroCliente.setText("");				
		inputCepCliente.setText("");
		inputRuaCliente.setText("");
		inputDescricaoCliente.setText("");

		    	
		    }
		}); } catch(Exception msg){
			
		}
		
		btnNewButton_1.setBounds(600, 380, 117, 25);
		contentPane.add(btnNewButton_1);
	}
}




