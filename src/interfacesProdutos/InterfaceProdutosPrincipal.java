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

public class InterfaceProdutosPrincipal extends JFrame {

	private JPanel contentPane;
	JTable tblData;
	private JTextField id_estoqueTF;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextField txtProd = new JTextField();
		txtProd.setBounds(131, 61, 254, 20);
		getContentPane().add(txtProd);
		txtProd.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("id :");
		lblNewLabel.setBounds(68, 35, 16, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Quantidade :");
		lblNewLabel_1.setBounds(68, 95, 71, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblNewLabel_1);
		
		JTextField txtQtd = new JTextField();
		txtQtd.setBounds(149, 92, 78, 20);
		getContentPane().add(txtQtd);
		txtQtd.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Produto :");
		lblNewLabel_2.setBounds(68, 64, 254, 14);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblNewLabel_2);
		
		JTextField txtId = new JTextField();
		txtId.setBounds(94, 33, 45, 20);
		getContentPane().add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Valor :");
		lblNewLabel_3.setBounds(149, 36, 35, 14);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblNewLabel_3);
		
		JTextField txtVlr = new JTextField();
		txtVlr.setBounds(194, 33, 71, 20);
		getContentPane().add(txtVlr);
		txtVlr.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Data de Validade :");
		lblNewLabel_4.setBounds(405, 38, 101, 14);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Data de Entrada :");
		lblNewLabel_5.setBounds(405, 63, 97, 14);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Data de Saída : ");
		lblNewLabel_6.setBounds(405, 88, 87, 14);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblNewLabel_6);
		
		JTextField txtDataE = new JTextField();
		txtDataE.setBounds(509, 60, 86, 20);
		getContentPane().add(txtDataE);
		txtDataE.setColumns(10);
		
		JTextField txtDataV = new JTextField();
		txtDataV.setBounds(509, 35, 86, 20);
		getContentPane().add(txtDataV);
		txtDataV.setColumns(10);
		
		JTextField txtDataS = new JTextField();
		txtDataS.setBounds(509, 85, 86, 20);
		getContentPane().add(txtDataS);
		txtDataS.setColumns(10);
		
		JLabel txtIdEstoque = new JLabel("Id Estoque");
		txtIdEstoque.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtIdEstoque.setBounds(241, 95, 60, 14);
		contentPane.add(txtIdEstoque);
		
		id_estoqueTF = new JTextField();
		id_estoqueTF.setBounds(311, 92, 74, 20);
		contentPane.add(id_estoqueTF);
		id_estoqueTF.setColumns(10);
		
		JButton botaoCadastrar = new JButton("Cadastrar Produto");
		botaoCadastrar.setBounds(405, 159, 182, 45);
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
		getContentPane().add(botaoCadastrar);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(10, 215, 685, 274);
		contentPane.add(scrollPane_1);
		
		JTable tblData = new JTable();
		scrollPane_1.setViewportView(tblData);
		
		JButton botaoConsultar = new JButton("Consultar produto");
		botaoConsultar.setBounds(105, 159, 182, 45);
		botaoConsultar.setFont(new Font("Tahoma", Font.BOLD, 13));
		botaoConsultar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
							
			
											
					ProdutosConsulta produtosConsulta = new ProdutosConsulta();
					produtosConsulta.setTblData(tblData);
					produtosConsulta.consultarProdutos(txtProd.getText());
									
				
					
			
				
			} 
		 });
		
		getContentPane().add(botaoConsultar);
		
	  }
	}
