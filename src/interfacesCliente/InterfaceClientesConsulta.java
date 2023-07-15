package interfacesCliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladores.ClienteConsultaDatabase;
import controladores.ClienteConsultaPedidosDatabase;
import utils.PDF;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.util.*;

import javax.swing.table.DefaultTableModel;

import com.lowagie.text.DocumentException;

import classesCliente.ClienteConsultaTratamento;

import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

public class InterfaceClientesConsulta extends InterfaceClientesPrincipal {

	private JPanel contentPane;
	private JTextField inputNomeCliente;
	private JTextField inputCpfCLiente;
	private JTable tabelaResultadoCliente;

	/**
	 * Launch the application.
	 */
	public static void clienteConsulta() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceClientesConsulta frame = new InterfaceClientesConsulta();
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
	public InterfaceClientesConsulta () {


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
		
		

		JButton btnConsultarCliente = new JButton("Consultar");
		
		
		btnConsultarCliente.setBounds(814, 429, 117, 25);
		contentPane.add(btnConsultarCliente);
		
		 	DefaultTableModel tabelaInfoCliente = new DefaultTableModel(new Object[][] {},
	                new String[] { "nome do cliente", "cpf do cliente", "data de nascimento", "telefone", "complemento", "estado", "cidade",
	                        "bairro", "rua", "cep"}) {
		 	    @Override
		 	    public boolean isCellEditable(int row, int column) {
		 	        return false;
		 	    }
		 	    };
		 	
	        tabelaResultadoCliente = new JTable(tabelaInfoCliente);
	        tabelaResultadoCliente.getColumnModel().getColumn(0).setPreferredWidth(100);
	        tabelaResultadoCliente.getColumnModel().getColumn(1).setPreferredWidth(100);
	        tabelaResultadoCliente.getColumnModel().getColumn(2).setPreferredWidth(120);
	        tabelaResultadoCliente.getColumnModel().getColumn(3).setPreferredWidth(80);
	        tabelaResultadoCliente.getColumnModel().getColumn(4).setPreferredWidth(80);
	        tabelaResultadoCliente.getColumnModel().getColumn(5).setPreferredWidth(100);
	        tabelaResultadoCliente.getColumnModel().getColumn(6).setPreferredWidth(100);
	        tabelaResultadoCliente.getColumnModel().getColumn(7).setPreferredWidth(100);
	        tabelaResultadoCliente.getColumnModel().getColumn(8).setPreferredWidth(80);
	        tabelaResultadoCliente.getColumnModel().getColumn(8).setPreferredWidth(80);
       
	        
		JScrollPane scrollInformacoesCliente = new JScrollPane(tabelaResultadoCliente);
		scrollInformacoesCliente.setBounds(34, 94, 897, 141);
		contentPane.add(scrollInformacoesCliente);
		JLabel lblInformaesDoCliente = new JLabel("Informações do cliente:");
		lblInformaesDoCliente.setBounds(12, 80, 166, 15);
		contentPane.add(lblInformaesDoCliente);
		
		JLabel lblUltimosPedidosDo = new JLabel("Ultimos pedidos do cliente:");
		lblUltimosPedidosDo.setBounds(12, 238, 212, 29);
		contentPane.add(lblUltimosPedidosDo);
		
		DefaultTableModel tabelaInfoPedidos = new DefaultTableModel(
		        new Object[][] {},
		        new String[] { "id da loja", "data do pedido", "valor total", "nome do vendedor", "cpf do cliente"}) {
	 	   
	 	    public boolean isCellEditable(int row, int column) {
	 	        return false;
	 	    }
	 	    };
		JTable produtosResultadoCliente = new JTable(tabelaInfoPedidos);
		produtosResultadoCliente.getColumnModel().getColumn(0).setPreferredWidth(100);
		produtosResultadoCliente.getColumnModel().getColumn(1).setPreferredWidth(100);
		produtosResultadoCliente.getColumnModel().getColumn(2).setPreferredWidth(120);
		produtosResultadoCliente.getColumnModel().getColumn(3).setPreferredWidth(120);
		produtosResultadoCliente.getColumnModel().getColumn(3).setPreferredWidth(120);

		JScrollPane scrollInformacoesProduto = new JScrollPane(produtosResultadoCliente);
		scrollInformacoesProduto.setBounds(34, 272, 897, 141);
		contentPane.add(scrollInformacoesProduto);
		
       	JButton btnSalvarPdf = new JButton("Salvar em pdf");
       	btnSalvarPdf.setEnabled(false);
   		btnSalvarPdf.addActionListener(new ActionListener() {
   			public void actionPerformed(ActionEvent e) {
   				
   			
   				PDF pdf = new PDF();
   				
   				
   				
   				pdf.setListInfoCliente(tabelaInfoCliente);  				
   				pdf.setListInfoPedidosCliente(tabelaInfoPedidos);
   				
   				
   				
   				try {
					pdf.gerarPdf();
				} catch (DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
   				
   				
   				
   		 	
   				}
   				
   			
   		});
   		
   		
   	
   		btnSalvarPdf.setBounds(507, 429, 166, 25);
   		contentPane.add(btnSalvarPdf);

		
		btnConsultarCliente.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                  	                         	                
	                ClienteConsultaTratamento infoCliente = new ClienteConsultaTratamento();
	               
	                
	                if(!inputNomeCliente.getText().isBlank() && !inputNomeCliente.getText().isEmpty()) {
	                //retorna os valores do database após passar pela classe de tratamentto de informações do cliente
	                List<Object[]> resultadosNomeCliente =infoCliente.setConsultaNomeClienteEndereco(inputNomeCliente.getText());
	           
	                tabelaInfoCliente.setRowCount(0);

	                for (Object[] cliente : resultadosNomeCliente) {
	                	//vai ser adicionada uma nova linha com o conteúdo do cliente e vai crescer de acordo com o resultados
	                    tabelaInfoCliente.addRow(cliente); 
	                }
	                btnSalvarPdf.setEnabled(true);
	                }else if(!inputCpfCLiente.getText().isBlank() && !inputCpfCLiente.getText().isEmpty()) {
	                	
		                List<Object[]> resultadosCpfCliente = infoCliente.setConsultaCpfClienteEndereco(inputCpfCLiente.getText());
		 	           
		                tabelaInfoCliente.setRowCount(0);

		                for (Object[] cliente : resultadosCpfCliente) {
		                    tabelaInfoCliente.addRow(cliente); 
		                }              	
		                btnSalvarPdf.setEnabled(true);
	                }else {
	                	
	                	  JOptionPane.showMessageDialog(null, "Digite pelo menos nome ou cpf", "Error",  JOptionPane.ERROR_MESSAGE);
              	
	                }
	                    
	                    tabelaInfoPedidos.setRowCount(0);
	                    
	                    List<Object[]> resultadosProduto = ClienteConsultaPedidosDatabase.consultaProdutos(inputNomeCliente.getText(), inputCpfCLiente.getText());
	                    
	                    for (Object[] produtos : resultadosProduto) {
		                	//vai ser adicionada uma nova linha com o conteúdo do cliente e vai crescer de acordo com o resultados
		                    tabelaInfoPedidos.addRow(produtos); 
	                   
              
	                }
	            }
	        });
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Limpa as informações
				inputNomeCliente.setText("");
				inputCpfCLiente.setText("");
				tabelaInfoCliente.setRowCount(0); //vai zerar a tabela quando apertar o botao consultar
				tabelaInfoPedidos.setRowCount(0);
				btnSalvarPdf.setEnabled(false);
			}
		});
		btnLimpar.setBounds(685, 429, 117, 25);
		contentPane.add(btnLimpar);	

	}
}




