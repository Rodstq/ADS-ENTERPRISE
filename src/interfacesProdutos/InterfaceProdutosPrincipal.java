package interfacesProdutos;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import classesProdutos.ProdutoConsultaTratamento;
import controladores.ProdutosConsulta;
import controladores.ProdutosCadastrar;
import classesProdutos.Produto;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Checkbox;
import javax.swing.ButtonGroup;

public class InterfaceProdutosPrincipal extends JFrame {

	private JPanel cadastrarProduto;
	private JPanel consultarProduto;
	JTable tblData;
	private JTextField id_estoqueTF;
	private JTabbedPane tabbedPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String escolha;

	/**
	 * Launch the application.
	 */
	public static void ProdutosPrincipal() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceProdutosPrincipal frame = new InterfaceProdutosPrincipal();
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
	public InterfaceProdutosPrincipal() {
		
		tabbedPane = new JTabbedPane();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 544);
		
		// CRIANDO PANEL CONSULTAR
		consultarProduto = new JPanel();
		tabbedPane.add(consultarProduto,"consultar");
		consultarProduto.setBorder(new EmptyBorder(5, 5, 5, 5));
		consultarProduto.setLayout(null);
				
		// ADICIONANDO ELEMENTOS DO CONSULTAR
				JTextField txtProdConsultar = new JTextField();
				txtProdConsultar.setBounds(141, 69, 254, 20);
				txtProdConsultar.setColumns(10);
				consultarProduto.add(txtProdConsultar);
				
				JLabel produtoNomeConsultar = new JLabel("Produto :");
				produtoNomeConsultar.setBounds(83, 72, 62, 14);
				produtoNomeConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
				consultarProduto.add(produtoNomeConsultar);
				
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				scrollPane_1.setBounds(10, 215, 685, 251);
				consultarProduto.add(scrollPane_1);
				
				JTable tblData_1 = new JTable();
				scrollPane_1.setViewportView(tblData_1);
				
				JLabel lblNewLabelConsultar = new JLabel("id :");
				consultarProduto.add(lblNewLabelConsultar);
				lblNewLabelConsultar.setBounds(83, 44, 16, 14);
				lblNewLabelConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
				
				JTextField txtIdConsultar = new JTextField();
				consultarProduto.add(txtIdConsultar);
				txtIdConsultar.setBounds(109, 41, 45, 20);
				txtIdConsultar.setColumns(10);		
				
				JLabel lblNewLabel_1 = new JLabel("Consultar Por : ");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_1.setBounds(10, 11, 110, 14);
				consultarProduto.add(lblNewLabel_1);
				
				JRadioButton RadioButtonIdConsultar = new JRadioButton("");
				RadioButtonIdConsultar.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
//						RadioButtonNomeConsultaBoolean = false; 
//						RadioButtonIdConsultarBoolean = true;
						
						// desativando label e texto produto nome
						produtoNomeConsultar.setEnabled(false);
						txtProdConsultar.setEnabled(false);
						escolha = "id";
						//ativando label e texto produto id
						lblNewLabelConsultar.setEnabled(true);
						txtIdConsultar.setEnabled(true);
					}
					
				});
				buttonGroup.add(RadioButtonIdConsultar);
				RadioButtonIdConsultar.setBounds(56, 41, 21, 23);
				consultarProduto.add(RadioButtonIdConsultar);	
				
				JRadioButton RadioButtonNomeConsulta = new JRadioButton("");
				RadioButtonNomeConsulta.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						// ativando label e texto produto nome
						produtoNomeConsultar.setEnabled(true);
						txtProdConsultar.setEnabled(true);
						escolha = "produto";
						//desativando label e texto produto id
						lblNewLabelConsultar.setEnabled(false);
						txtIdConsultar.setEnabled(false);
									
					}
					
				});
				buttonGroup.add(RadioButtonNomeConsulta);
				RadioButtonNomeConsulta.setBounds(56, 66, 21, 23);
				consultarProduto.add(RadioButtonNomeConsulta);
				
				JButton botaoConsultar = new JButton("Consultar produto");
				botaoConsultar.setBounds(199, 146, 282, 45);
				botaoConsultar.setFont(new Font("Tahoma", Font.BOLD, 13));
				botaoConsultar.addActionListener( new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {							
						ProdutosConsulta produtosConsulta = new ProdutosConsulta();
						produtosConsulta.setTblData(tblData_1);
						produtosConsulta.setQuery(escolha, txtIdConsultar.getText(), txtProdConsultar.getText());
						produtosConsulta.consultarProdutos();
				  }
						  
				 });
				consultarProduto.add(botaoConsultar);
				
		
				
		//	 CRIANDO PANEL CADASTRAR		
		cadastrarProduto = new JPanel();
		tabbedPane.add(cadastrarProduto, "cadastrar");
		cadastrarProduto.setLayout(null);	
		
		// ADICIONANDO ELEMENTOS DO CADASTRAR
		JLabel lblNewLabel = new JLabel("id :");
		cadastrarProduto.add(lblNewLabel);
		lblNewLabel.setBounds(33, 17, 16, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JTextField txtId = new JTextField();
		cadastrarProduto.add(txtId);
		txtId.setBounds(59, 14, 133, 20);
		txtId.setColumns(10);		
		
		JLabel quantidadeLabel = new JLabel("Quantidade :");
		cadastrarProduto.add(quantidadeLabel);
		quantidadeLabel.setBounds(33, 74, 71, 14);
		quantidadeLabel.setFont(new Font("Tahoma", Font.BOLD, 11));		
		
		id_estoqueTF = new JTextField();
		cadastrarProduto.add(id_estoqueTF);
		id_estoqueTF.setBounds(284, 71, 101, 20);
		id_estoqueTF.setColumns(10);
		
		JTextField txtQtd = new JTextField();
		cadastrarProduto.add(txtQtd);
		txtQtd.setBounds(114, 71, 78, 20);
		txtQtd.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Valor :");
		lblNewLabel_3.setBounds(215, 17, 35, 14);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		cadastrarProduto.add(lblNewLabel_3);
		
		JTextField txtVlr = new JTextField();
		txtVlr.setBounds(284, 14, 101, 20);
		cadastrarProduto.add(txtVlr);
		txtVlr.setColumns(10);
		
		JTextField txtProd = new JTextField();
		cadastrarProduto.add(txtProd);
		txtProd.setBounds(90, 43, 373, 20);
		txtProd.setColumns(10);
		
		JLabel produtoNome = new JLabel("Produto :");
		cadastrarProduto.add(produtoNome);
		produtoNome.setBounds(33, 45, 60, 14);
		produtoNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_4 = new JLabel("Data de Validade :");
		lblNewLabel_4.setBounds(490, 38, 101, 14);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Data de Entrada :");
		lblNewLabel_5.setBounds(490, 63, 97, 14);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Data de Saída : ");
		lblNewLabel_6.setBounds(490, 88, 87, 14);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblNewLabel_6);
		
		JTextField txtDataE = new JTextField();
		txtDataE.setBounds(594, 60, 86, 20);
		getContentPane().add(txtDataE);
		txtDataE.setColumns(10);
		
		JTextField txtDataV = new JTextField();
		txtDataV.setBounds(594, 35, 86, 20);
		getContentPane().add(txtDataV);
		txtDataV.setColumns(10);
		
		JTextField txtDataS = new JTextField();
		txtDataS.setBounds(594, 85, 86, 20);
		getContentPane().add(txtDataS);
		txtDataS.setColumns(10);
		
		JLabel txtIdEstoque = new JLabel("Id Estoque");
		txtIdEstoque.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtIdEstoque.setBounds(215, 74, 60, 14);
		cadastrarProduto.add(txtIdEstoque);
		
		JButton botaoCadastrar = new JButton("Cadastrar Produto");
		botaoCadastrar.setBounds(215, 159, 282, 45);
		botaoCadastrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		botaoCadastrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Produto produto = new Produto();
				produto.setId_produto(txtId.getText());
				produto.setNome_produto(txtProd.getText());
				produto.setQuantidade(Integer.parseInt(txtQtd.getText()));
				produto.setValor(Double.parseDouble(txtVlr.getText()));
				produto.setId_estoque(id_estoqueTF.getText());
				
				
				ProdutosCadastrar produtosCadastrar = new ProdutosCadastrar();
				produtosCadastrar.cadastrarProdutos(produto);
				
			}});
		cadastrarProduto.add(botaoCadastrar);
		getContentPane().add(tabbedPane);		
	
	  }
	}
