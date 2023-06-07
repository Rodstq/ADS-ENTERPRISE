package interfacesCliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladores.consultaCliente;

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

public class interfaceClientesConsulta extends JFrame {

	private JPanel contentPane;
	private JTextField inputNomeCliente;
	private JTextField inputCpfCLiente;

	/**
	 * Launch the application.
	 */
	public static void clienteConsulta() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfaceClientesConsulta frame = new interfaceClientesConsulta();
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
	public interfaceClientesConsulta () {
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
		
		//Ler o que foi digitado
		inputNomeCliente = new JTextField();
		inputNomeCliente.setBounds(140, 17, 388, 19);
		contentPane.add(inputNomeCliente);
		inputNomeCliente.setColumns(10);
		
		
		inputCpfCLiente = new JTextField();
		inputCpfCLiente.setColumns(10);
		inputCpfCLiente.setBounds(49, 51, 110, 19);
		contentPane.add(inputCpfCLiente);
		
		
		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Limpa as informações
				inputNomeCliente.setText("");
				inputCpfCLiente.setText("");
				
			}
		});
		btnNewButton.setBounds(471, 380, 117, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Consultar");
		
		try {
		btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed  (ActionEvent e) {

	
		 consultaCliente.consultaCliente(inputNomeCliente.getText(), inputCpfCLiente.getText());
		 
		    	
		//Limpa após inserir os dados
		inputNomeCliente.setText("");
		inputCpfCLiente.setText("");
	
		    	
		    }
		}); } catch(Exception msg){
			
		}
		
		btnNewButton_1.setBounds(600, 380, 117, 25);
		contentPane.add(btnNewButton_1);
	}
}




