package guiCliente;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.tratamento.clients.ClienteDeleteTratamento;
import data.tratamento.clients.ClienteValidadoraInput;
import data.tratamento.clients.infoClienteException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class GuiClientesDelete extends GuiClientesPrincipal {

	private JPanel contentPane;
	private JTextField inputDeleteCpfPedido;
	private JTextField inputCpfDeleteCadastro;
	private JTextField inputIddeletePedido;
	private JTextField inputCpfDeleteUnicoPedido;

	/**
	 * Launch the application.
	 */
	public static void clienteDelete() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiClientesDelete frame = new GuiClientesDelete();
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
	public GuiClientesDelete() {
		
		inputDeleteCpfPedido = new JTextField();
		inputDeleteCpfPedido.setVisible(false);
		inputDeleteCpfPedido.setDocument(new ClienteValidadoraInput(11, ClienteValidadoraInput.dadoInserido.cpfCliente));
		inputDeleteCpfPedido.setBounds(343, 116, 167, 19);
		getContentPane().add(inputDeleteCpfPedido);
		inputDeleteCpfPedido.setColumns(10);
		
		inputCpfDeleteCadastro = new JTextField();
		inputCpfDeleteCadastro.setVisible(false);
		inputCpfDeleteCadastro.setDocument(new ClienteValidadoraInput(11, ClienteValidadoraInput.dadoInserido.cpfCliente));
		inputCpfDeleteCadastro.setColumns(10);
		inputCpfDeleteCadastro.setBounds(343, 75, 167, 19);
		getContentPane().add(inputCpfDeleteCadastro);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(673, 417, 117, 25);
		getContentPane().add(btnLimpar);
		btnLimpar.addActionListener(new ActionListener() {
			
		    public void actionPerformed  (ActionEvent e) {
		    	
		    	inputCpfDeleteCadastro.setText("");
		    	inputDeleteCpfPedido.setText("");
		    	inputDeleteCpfPedido.setText("");
		    	inputIddeletePedido.setText("");

		    } 
		    });
		
		
		JButton btnDeletarCliente = new JButton("Deletar");
		btnDeletarCliente.setBounds(802, 417, 117, 25);
		getContentPane().add(btnDeletarCliente);
		
		JLabel lblCpfCadastroDelete = new JLabel("CPF:");
		lblCpfCadastroDelete.setVisible(false);
		lblCpfCadastroDelete.setBounds(296, 71, 53, 27);
		getContentPane().add(lblCpfCadastroDelete);
		
		JLabel lblCpfPedido = new JLabel("CPF:");
		lblCpfPedido.setVisible(false);
		lblCpfPedido.setBounds(296, 112, 53, 27);
		getContentPane().add(lblCpfPedido);
		
		JCheckBox boxDeleteAllPedido = new JCheckBox("Deletar todos os  pedidos ");
		boxDeleteAllPedido.setBounds(46, 114, 214, 23);
		getContentPane().add(boxDeleteAllPedido);
		boxDeleteAllPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(boxDeleteAllPedido.isSelected()) {
					lblCpfPedido.setVisible(true);
					inputDeleteCpfPedido.setVisible(true);
				}else {
					
					lblCpfPedido.setVisible(false);
					inputDeleteCpfPedido.setVisible(false);

					
				}
				
			}
		});
		
		JCheckBox boxDeleteCadastroCliente = new JCheckBox("deletar cadastro do cliente");
		boxDeleteCadastroCliente.setBounds(46, 75, 247, 23);
		getContentPane().add(boxDeleteCadastroCliente);
		boxDeleteCadastroCliente.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(boxDeleteCadastroCliente.isSelected()) {
					
					lblCpfCadastroDelete.setVisible(true);
					inputCpfDeleteCadastro.setVisible(true);
					
				}else {
					
					lblCpfCadastroDelete.setVisible(false);
					inputCpfDeleteCadastro.setVisible(false);

					
				}
				
			}
		});
		
		JCheckBox boxDeleteUnicoPedido = new JCheckBox("delete um pedido especifico");
		boxDeleteUnicoPedido.setBounds(46, 33, 247, 23);
		getContentPane().add(boxDeleteUnicoPedido);
		JLabel lblCpfUnicoPedido = new JLabel("CPF:");
		lblCpfUnicoPedido.setVisible(false);
		lblCpfUnicoPedido.setBounds(296, 37, 70, 15);
		getContentPane().add(lblCpfUnicoPedido);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setVisible(false);
		lblId.setBounds(531, 37, 26, 15);
		getContentPane().add(lblId);
		
		inputIddeletePedido = new JTextField();
		inputIddeletePedido.setVisible(false);
		inputIddeletePedido.setDocument(new ClienteValidadoraInput(4, ClienteValidadoraInput.dadoInserido.cpfCliente));
		inputIddeletePedido.setBounds(564, 35, 70, 19);
		getContentPane().add(inputIddeletePedido);
		inputIddeletePedido.setColumns(10);
		
		inputCpfDeleteUnicoPedido = new JTextField();
		inputCpfDeleteUnicoPedido.setVisible(false);
		inputCpfDeleteUnicoPedido.setDocument(new ClienteValidadoraInput(11, ClienteValidadoraInput.dadoInserido.cpfCliente));
		inputCpfDeleteUnicoPedido.setColumns(10);
		inputCpfDeleteUnicoPedido.setBounds(342, 33, 168, 19);
		getContentPane().add(inputCpfDeleteUnicoPedido);
		boxDeleteUnicoPedido.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(boxDeleteUnicoPedido.isSelected()) {
					
					lblCpfUnicoPedido.setVisible(true);
					inputCpfDeleteUnicoPedido.setVisible(true);
					lblId.setVisible(true);
					inputIddeletePedido.setVisible(true);
					
				}else {
					
					lblCpfUnicoPedido.setVisible(false);
					inputCpfDeleteUnicoPedido.setVisible(false);
					lblId.setVisible(false);
					inputIddeletePedido.setVisible(false);
					
				}
				
			}
		});
	
		btnDeletarCliente.addActionListener(new ActionListener() {
			
		    public void actionPerformed  (ActionEvent e) {
		    	
		    	   	
		    	ClienteDeleteTratamento delete = new ClienteDeleteTratamento();
		    	    		
		    	String allPedidoDel = inputDeleteCpfPedido.getText();
		    	String cadastroClienteDel = inputCpfDeleteCadastro.getText();
		    	String unicoPedidoDel = inputCpfDeleteUnicoPedido.getText();		    	 
		    	int idPedidoDel =  Integer.parseInt(inputIddeletePedido.getText());
		    	
		    	
					try {
												
						delete.deleteAllPedidos(allPedidoDel);
						delete.deleteClienteCadastro(cadastroClienteDel);
						delete.deleteUnicoPedido(unicoPedidoDel, idPedidoDel);
						
					} catch (infoClienteException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
					}

		    } 
		    });
		
		
		
}
}