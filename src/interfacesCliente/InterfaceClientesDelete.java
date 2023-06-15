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
	private JTextField inputNomeCliente;
	private JTextField inputCpfCliente;

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
		
		JLabel lblNomeCliente = new JLabel("Nome do cliente:");
		lblNomeCliente.setBounds(29, 39, 132, 27);
		getContentPane().add(lblNomeCliente);
		
		JLabel lblCpfCliente = new JLabel("CPF do cliente:");
		lblCpfCliente.setBounds(29, 78, 132, 27);
		getContentPane().add(lblCpfCliente);
		
		inputNomeCliente = new JTextField();
		inputNomeCliente.setBounds(160, 43, 478, 19);
		getContentPane().add(inputNomeCliente);
		inputNomeCliente.setColumns(10);
		
		inputCpfCliente = new JTextField();
		inputCpfCliente.setColumns(10);
		inputCpfCliente.setBounds(144, 82, 167, 19);
		getContentPane().add(inputCpfCliente);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(673, 417, 117, 25);
		getContentPane().add(btnLimpar);
		btnLimpar.addActionListener(new ActionListener() {
			
		    public void actionPerformed  (ActionEvent e) {
		    	
		    	inputCpfCliente.setText("");
		    	inputNomeCliente.setText("");

		    } 
		    });
		
		
		JButton btnDeletarCliente = new JButton("Deletar");
		btnDeletarCliente.setBounds(802, 417, 117, 25);
		getContentPane().add(btnDeletarCliente);
		
		btnDeletarCliente.addActionListener(new ActionListener() {
			
		    public void actionPerformed  (ActionEvent e) {
		    	
		    	   	
		    	ClienteDeleteTratamento delete = new ClienteDeleteTratamento();
		    	delete.deleteCliente(inputCpfCliente.getText(), inputNomeCliente.getText());
		    	

		    } 
		    });
		
}
}