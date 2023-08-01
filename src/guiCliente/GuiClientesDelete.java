package guiCliente;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import data.tratamento.clients.ClienteDeleteTratamento;
import data.tratamento.clients.ClienteValidadoraInput;
import data.tratamento.clients.infoClienteException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;

public class GuiClientesDelete extends GuiClientesPrincipal {

	private JPanel contentPane;
	
	
	
	private JTextField inputDeleteCpfAllPedido;
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
	 * @throws ParseException 
	 */
	public GuiClientesDelete() throws ParseException {

		inputDeleteCpfAllPedido = new JTextField();
		inputDeleteCpfAllPedido.setVisible(false);		
		inputDeleteCpfAllPedido.setBounds(343, 116, 167, 19);
		getContentPane().add(inputDeleteCpfAllPedido);
		inputDeleteCpfAllPedido.setColumns(14);
		
		inputCpfDeleteCadastro = new JTextField();
		inputCpfDeleteCadastro.setVisible(false);
		
		inputCpfDeleteCadastro.setColumns(10);
		inputCpfDeleteCadastro.setBounds(343, 75, 167, 19);
		getContentPane().add(inputCpfDeleteCadastro);
		
		
		ClienteDeleteTratamento flag = new ClienteDeleteTratamento();
		
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(673, 417, 117, 25);
		getContentPane().add(btnLimpar);
		btnLimpar.addActionListener(new ActionListener() {
			
		    public void actionPerformed  (ActionEvent e) {
		    	
		    	inputCpfDeleteCadastro.setText("");
		    	inputDeleteCpfAllPedido.setText("");			
		    	inputCpfDeleteUnicoPedido.setText("");
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

		JCheckBox boxDeleteCadastroCliente = new JCheckBox("deletar cadastro do cliente");
		boxDeleteCadastroCliente.setBounds(46, 75, 247, 23);
		getContentPane().add(boxDeleteCadastroCliente);
	
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
		
		inputIddeletePedido.setBounds(564, 35, 114, 19);
		getContentPane().add(inputIddeletePedido);
		inputIddeletePedido.setColumns(10);
		
		inputCpfDeleteUnicoPedido = new JTextField();
		inputCpfDeleteUnicoPedido.setVisible(false);
		
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
					
					lblCpfCadastroDelete.setVisible(false);
					inputCpfDeleteCadastro.setVisible(false);
					
					lblCpfPedido.setVisible(false);
					inputDeleteCpfAllPedido.setVisible(false);

					boxDeleteAllPedido.setSelected(false);
					boxDeleteCadastroCliente.setSelected(false);
					
					flag.flagDeleteUnico(true);
					flag.flagDeleteId(true);
					
					inputIddeletePedido.setDocument(new ClienteValidadoraInput(4, ClienteValidadoraInput.dadoInserido.cpfCliente));
					inputCpfDeleteUnicoPedido.setDocument(new ClienteValidadoraInput(11, ClienteValidadoraInput.dadoInserido.cpfCliente));
					
					
				}else {
					
					
					lblCpfUnicoPedido.setVisible(false);
					inputCpfDeleteUnicoPedido.setVisible(false);
					lblId.setVisible(false);
					inputIddeletePedido.setVisible(false);
					flag.flagDeleteUnico(false);
					flag.flagDeleteId(false);
					

				}
				
			}
		});
		
		
	boxDeleteCadastroCliente.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(boxDeleteCadastroCliente.isSelected()) {
					
					lblCpfCadastroDelete.setVisible(true);
					inputCpfDeleteCadastro.setVisible(true);

					lblCpfUnicoPedido.setVisible(false);
					inputCpfDeleteUnicoPedido.setVisible(false);
					lblId.setVisible(false);
					inputIddeletePedido.setVisible(false);
					
					lblCpfPedido.setVisible(false);
					inputDeleteCpfAllPedido.setVisible(false);
					
					boxDeleteUnicoPedido.setSelected(false);
					boxDeleteAllPedido.setSelected(false);
					
					flag.flagDeleteCadastro(true);
					
					inputCpfDeleteCadastro.setDocument(new ClienteValidadoraInput(11, ClienteValidadoraInput.dadoInserido.cpfCliente));
					
				}else {
					
					lblCpfCadastroDelete.setVisible(false);
					inputCpfDeleteCadastro.setVisible(false);
					flag.flagDeleteCadastro(false);
					

					
				}
				
			}
		});
	
	
	
	boxDeleteAllPedido.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
			if(boxDeleteAllPedido.isSelected()) {

				lblCpfPedido.setVisible(true);
				inputDeleteCpfAllPedido.setVisible(true);
				
				boxDeleteUnicoPedido.setSelected(false);
				boxDeleteCadastroCliente.setSelected(false);
				
				lblCpfCadastroDelete.setVisible(false);
				inputCpfDeleteCadastro.setVisible(false);

				lblCpfUnicoPedido.setVisible(false);
				inputCpfDeleteUnicoPedido.setVisible(false);
				lblId.setVisible(false);
				inputIddeletePedido.setVisible(false);
				
				
				flag.flagDeleteAllPedidos(true);
				
				inputDeleteCpfAllPedido.setDocument(new ClienteValidadoraInput(11, ClienteValidadoraInput.dadoInserido.cpfCliente));
			
	
			}else {
				
				lblCpfPedido.setVisible(false);
				inputDeleteCpfAllPedido.setVisible(false);
				flag.flagDeleteAllPedidos(false);
			
			}
			
		}
	});

	btnDeletarCliente.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	        ClienteDeleteTratamento delete = new ClienteDeleteTratamento();

	        int idPedidoDel = 0;
	        String allPedidoDel = inputDeleteCpfAllPedido.getText();
	        String cadastroClienteDel = inputCpfDeleteCadastro.getText();
	        String unicoPedidoDel = inputCpfDeleteUnicoPedido.getText();

	        if (!inputIddeletePedido.getText().isEmpty()) {
	            idPedidoDel = Integer.parseInt(inputIddeletePedido.getText());
	        }
	        
	        
	        boolean sucesso = true;
	        try {
	            if (boxDeleteAllPedido.isSelected() == true) {
	            	
	                delete.deleteAllPedidos(allPedidoDel);
	                
	            }else if (boxDeleteCadastroCliente.isSelected() == true) {
	                delete.deleteClienteCadastro(cadastroClienteDel);
	            }

	            else if (boxDeleteUnicoPedido.isSelected() == true) {
	                delete.deleteUnicoPedido(unicoPedidoDel, idPedidoDel);
	            }

	        } catch (infoClienteException ex) {
	            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
	            sucesso = false;
	        }
	
	        
	     //cpf ou id não existe	        
			try {
				if(!delete.verificarCpf(allPedidoDel) && sucesso && boxDeleteAllPedido.isSelected() == true) {
						JOptionPane.showMessageDialog(null, "O cpf não existe", "Erro", JOptionPane.ERROR_MESSAGE);		
					
				}
				
				
				if(!delete.verificarCpf(unicoPedidoDel) && sucesso && boxDeleteUnicoPedido.isSelected() == true) {
				
					JOptionPane.showMessageDialog(null, "O cpf não existe", "Erro", JOptionPane.ERROR_MESSAGE);
					
				}else if(!delete.verificarPedido(idPedidoDel) && sucesso && boxDeleteUnicoPedido.isSelected() == true) {
					
					JOptionPane.showMessageDialog(null, "O id do pedido não existe", "Erro", JOptionPane.ERROR_MESSAGE);
					
				}
				
				if(!delete.verificarCpf(cadastroClienteDel)  && sucesso && boxDeleteCadastroCliente.isSelected() == true) {
					
					JOptionPane.showMessageDialog(null, "O cpf não existe", "Erro", JOptionPane.ERROR_MESSAGE);	
				}
				
			} catch (HeadlessException | infoClienteException e2) {
				
				JOptionPane.showMessageDialog(null, "erro ao realizar um delete, por favor informe ao administrador", "Erro", JOptionPane.ERROR_MESSAGE);

			}
		
			
			
			
			//sucesso ao deletar
		try {
			if(!allPedidoDel.isBlank() && sucesso && delete.verificarCpf(allPedidoDel) ) {
				
				JOptionPane.showMessageDialog(null, "sucesso ao deletar todo os pedido",null, JOptionPane.INFORMATION_MESSAGE);
			}
				else if(!cadastroClienteDel.isBlank() && sucesso && delete.verificarCpf(cadastroClienteDel)) {
			JOptionPane.showMessageDialog(null, "sucesso ao deletar cadastro",null, JOptionPane.INFORMATION_MESSAGE);
					
			}else if(!unicoPedidoDel.isBlank() && idPedidoDel !=0 && sucesso && delete.verificarCpf(unicoPedidoDel)
					&& delete.verificarPedido(idPedidoDel)) {
				
				JOptionPane.showMessageDialog(null, "sucesso ao deletar o pedido",null, JOptionPane.INFORMATION_MESSAGE);
				
				}
			
		} catch (HeadlessException | infoClienteException e1) {
			
			JOptionPane.showMessageDialog(null, "erro ao realizar um delete, por favor informe ao administrador", "Erro", JOptionPane.ERROR_MESSAGE);
			}

    
	    }
	});

		
}
}