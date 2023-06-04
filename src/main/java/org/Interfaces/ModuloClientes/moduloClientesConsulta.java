package org.Interfaces.ModuloClientes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JList;
import javax.swing.JComboBox;

public class moduloClientesConsulta extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void moduloCliente() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					moduloClientesConsulta frame = new moduloClientesConsulta();
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
	public moduloClientesConsulta() {
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
		lblDataDeNascimento.setBounds(151, 53, 147, 15);
		contentPane.add(lblDataDeNascimento);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(12, 80, 54, 30);
		contentPane.add(lblEstado);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(151, 95, 54, 15);
		contentPane.add(lblCidade);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(497, 85, 31, 20);
		contentPane.add(lblCep);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(334, 88, 48, 15);
		contentPane.add(lblBairro);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(12, 122, 70, 15);
		contentPane.add(lblRua);
		
		JLabel lblDescrio = new JLabel("Descrição:");
		lblDescrio.setBounds(12, 156, 74, 15);
		contentPane.add(lblDescrio);
		
		JLabel lblPedidosRealizados = new JLabel("Pedidos realizados:");
		lblPedidosRealizados.setBounds(12, 196, 163, 20);
		contentPane.add(lblPedidosRealizados);
		
		JLabel lblDataDoltimo = new JLabel("Data do último pedido:");
		lblDataDoltimo.setBounds(12, 239, 163, 20);
		contentPane.add(lblDataDoltimo);
		
		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.setBounds(471, 380, 117, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Consultar");
		btnNewButton_1.setBounds(600, 380, 117, 25);
		contentPane.add(btnNewButton_1);
	}
}
