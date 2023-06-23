package interfacesCliente;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classesCliente.ClienteDeleteTratamento;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class InterfaceClientesDelete extends InterfaceClientesPrincipal {

	private JPanel contentPane;
	private JTextField inputDeletePedido;
	private JTextField inputCpfDeleteCadastro;

	/**
	 * Launch the application.
	 */
	public static void clienteDelete() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceClientesDelete frame = new InterfaceClientesDelete();
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
	public InterfaceClientesDelete() {
		
		JLabel lblDeletarCadastroCliente = new JLabel("Deletar cadastro do cliente");
		lblDeletarCadastroCliente.setBounds(29, 78, 227, 27);
		getContentPane().add(lblDeletarCadastroCliente);
		
		inputDeletePedido = new JTextField();
		inputDeletePedido.setBounds(89, 43, 167, 19);
		getContentPane().add(inputDeletePedido);
		inputDeletePedido.setColumns(10);
		
		inputCpfDeleteCadastro = new JTextField();
		inputCpfDeleteCadastro.setColumns(10);
		inputCpfDeleteCadastro.setBounds(89, 113, 167, 19);
		getContentPane().add(inputCpfDeleteCadastro);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(673, 417, 117, 25);
		getContentPane().add(btnLimpar);
		btnLimpar.addActionListener(new ActionListener() {
			
		    public void actionPerformed  (ActionEvent e) {
		    	
		    	inputCpfDeleteCadastro.setText("");
		    	inputDeletePedido.setText("");

		    } 
		    });
		
		
		JButton btnDeletarCliente = new JButton("Deletar");
		btnDeletarCliente.setBounds(802, 417, 117, 25);
		getContentPane().add(btnDeletarCliente);
		
		JLabel lblCpfCadastro = new JLabel("CPF:");
		lblCpfCadastro.setBounds(29, 109, 53, 27);
		getContentPane().add(lblCpfCadastro);
		
		JLabel lblCpfPedido = new JLabel("CPF:");
		lblCpfPedido.setBounds(29, 39, 53, 27);
		getContentPane().add(lblCpfPedido);
		
		JLabel lblDeletarPedidoCliente = new JLabel("Deletar pedido cliente:");
		lblDeletarPedidoCliente.setBounds(29, 12, 227, 27);
		getContentPane().add(lblDeletarPedidoCliente);
		
		btnDeletarCliente.addActionListener(new ActionListener() {
			
		    public void actionPerformed  (ActionEvent e) {
		    	
		    	   	
		    	ClienteDeleteTratamento delete = new ClienteDeleteTratamento();
		    	delete.deleteClienteCadastro(inputCpfDeleteCadastro.getText());
		    	delete.deleteClientePedido(inputDeletePedido.getText());
		    	

		    } 
		    });
		
}
}