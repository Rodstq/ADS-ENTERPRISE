package interfacesProdutos;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import classesFornecedores.Fornecedor;
import controladores.Produtos.ProdutosConsulta;
import interfaces.Main;
import controladores.Fornecedores.FornecedoresCadastrar;
import utils.Validadora;
import controladores.Produtos.ProdutosCadastrar;
import classesProdutos.Produto;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Checkbox;
import javax.swing.ButtonGroup;
import data.tratamento.produtos.CadastrarTratamento;

public class InterfaceProdutosPrincipal extends JFrame {

	private JPanel cadastrarProduto;
	private JPanel consultarProduto;
	private JPanel cadastrarFornecedor;
	JTable tblData;
	private JTextField id_estoqueTF;
	private JTabbedPane tabbedPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String escolha;
	private JTextField cnpjFornecedor;
	private JTextField nomeFornecedor;
	private JTextField quantidadeTF;

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
				txtProdConsultar.setDocument(new Validadora(50,Validadora.dadoInserido.dadoLivre));
				txtProdConsultar.setBounds(141, 69, 254, 20);
				txtProdConsultar.setColumns(10);
				consultarProduto.add(txtProdConsultar);
				
				JLabel produtoNomeConsultar = new JLabel("Produto :");
				produtoNomeConsultar.setBounds(83, 72, 62, 14);
				produtoNomeConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
				consultarProduto.add(produtoNomeConsultar);
				
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				scrollPane_1.setBounds(10, 215, 685, 215);
				consultarProduto.add(scrollPane_1);
				
				JTable tblData_1 = new JTable();
				scrollPane_1.setViewportView(tblData_1);
				
				JLabel lblNewLabelConsultar = new JLabel("id :");
				consultarProduto.add(lblNewLabelConsultar);
				lblNewLabelConsultar.setBounds(83, 44, 16, 14);
				lblNewLabelConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
				
				JTextField txtIdConsultar = new JTextField();
				
//				nome do campo  metodo usado   classe  qtd limite   tipo de dado a ser inserido
				txtIdConsultar.setDocument(new Validadora(50, Validadora.dadoInserido.numeroInt));
				
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
				
				JButton btnMenuPrincial = new JButton("menu principal");
				btnMenuPrincial.setBounds(10, 441, 154, 25);
				consultarProduto.add(btnMenuPrincial);
				btnMenuPrincial.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Main.main(null);
						dispose();
						
					}
				});
				
				
		
								
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
						txtId.setDocument(new Validadora(9, Validadora.dadoInserido.numeroInt));
						cadastrarProduto.add(txtId);
						txtId.setBounds(59, 14, 138, 20);
						txtId.setColumns(10);		
						

						quantidadeTF = new JTextField();
						quantidadeTF.setDocument(new Validadora(10, Validadora.dadoInserido.numeroInt));
						quantidadeTF.setBounds(363, 71, 110, 20);
						cadastrarProduto.add(quantidadeTF);
						quantidadeTF.setColumns(10);
						
						JLabel QuantidadeLbl = new JLabel("Quantidade :");
						QuantidadeLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
						QuantidadeLbl.setBounds(286, 74, 72, 14);
						cadastrarProduto.add(QuantidadeLbl);
						
						JLabel cnpjFornecedorLabel = new JLabel("CNPJ Fornecedor:");
						cadastrarProduto.add(cnpjFornecedorLabel);
						cnpjFornecedorLabel.setBounds(33, 74, 93, 14);
						cnpjFornecedorLabel.setFont(new Font("Tahoma", Font.BOLD, 11));		
						
						JTextField txtQtd = new JTextField();
						txtQtd.setDocument(new Validadora(14, Validadora.dadoInserido.numeroInt));
						cadastrarProduto.add(txtQtd);
						txtQtd.setBounds(138, 71, 138, 20);
						txtQtd.setColumns(10);
						
						JLabel lblNewLabel_3 = new JLabel("Valor :");
						lblNewLabel_3.setBounds(327, 17, 35, 14);
						lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
						cadastrarProduto.add(lblNewLabel_3);
						
						JTextField txtVlr = new JTextField();
						txtVlr.setDocument(new Validadora(8, Validadora.dadoInserido.numeroDouble));
						txtVlr.setBounds(372, 14, 101, 20);
						cadastrarProduto.add(txtVlr);
						txtVlr.setColumns(10);
						
						JTextField txtProd = new JTextField();
						cadastrarProduto.add(txtProd);
						txtProd.setBounds(90, 43, 383, 20);
						txtProd.setColumns(10);
						
						JLabel produtoNome = new JLabel("Produto :");
						cadastrarProduto.add(produtoNome);
						produtoNome.setBounds(33, 45, 60, 14);
						produtoNome.setFont(new Font("Tahoma", Font.BOLD, 11));
						
						JButton btnMenuPrincialProd = new JButton("menu principal");
						btnMenuPrincialProd.setBounds(10, 441, 154, 25);
						cadastrarProduto.add(btnMenuPrincialProd);
						btnMenuPrincialProd.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Main.main(null);
								dispose();
								
							}
						});
				
						
										// CRIANDO PANEL CADASTRAR FORNECEDOR
										cadastrarFornecedor = new JPanel();
										consultarProduto.setBorder(new EmptyBorder(5, 5, 5, 5));
										consultarProduto.setLayout(null);
										tabbedPane.add(cadastrarFornecedor, "cadastrar Fornecedor");
										cadastrarFornecedor.setLayout(null);
										
										JLabel cnpjLbl = new JLabel("CNPJ Fornecedor :");
										cnpjLbl.setBounds(36, 52, 113, 14);
										cnpjLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
										cadastrarFornecedor.add(cnpjLbl);
										
										cnpjFornecedor = new JTextField();
										cnpjFornecedor.setDocument(new Validadora(14,Validadora.dadoInserido.numeroInt));
										cnpjFornecedor.setBounds(145, 49, 215, 20);
										cnpjFornecedor.setColumns(10);
										cadastrarFornecedor.add(cnpjFornecedor);	
										
										JLabel NomeFornecedorLbl = new JLabel("Nome Fornecedor :");
										NomeFornecedorLbl.setBounds(36, 82, 113, 14);
										NomeFornecedorLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
										cadastrarFornecedor.add(NomeFornecedorLbl);
										
										nomeFornecedor = new JTextField();
										nomeFornecedor.setDocument(new Validadora(14,Validadora.dadoInserido.dadoLivre));										
										nomeFornecedor.setBounds(145, 79, 215, 20);
										nomeFornecedor.setColumns(10);
										cadastrarFornecedor.add(nomeFornecedor);	
										
										JLabel lblNewLabel_2 = new JLabel("Cadastrar Fornecedor ");
										lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
										lblNewLabel_2.setBounds(36, 11, 149, 14);
										cadastrarFornecedor.add(lblNewLabel_2);
										
										JButton btnCadFornecedor = new JButton("Cadastrar Fornecedor");
										btnCadFornecedor.setFont(new Font("Tahoma", Font.BOLD, 12));
										btnCadFornecedor.setBounds(67, 138, 253, 45);
										btnCadFornecedor.addActionListener(new ActionListener() {
									
											public void actionPerformed(ActionEvent e) {
												try {
													
														Fornecedor fornecedor = new Fornecedor();
														
														FornecedoresCadastrar fornecedorCadastrar = new FornecedoresCadastrar();
														CadastrarTratamento fornecedorCheck = new CadastrarTratamento();
														fornecedor.setCnpj(cnpjFornecedor.getText());
														fornecedor.setNome(nomeFornecedor.getText());
														
														fornecedorCheck.verificarVaziosFornecedor(cnpjFornecedor.getText(), nomeFornecedor.getText());
														
														try {
															fornecedorCadastrar.cadastrarFornecedor(fornecedor);
														} catch (Exception f) {
															fornecedorCheck.verificaErro(fornecedorCadastrar.getErroMessage());
															JOptionPane.showMessageDialog(rootPane, fornecedorCadastrar.getErroMessage());
													}
														
												} catch (Exception g) {
													JOptionPane.showMessageDialog(rootPane, "Existem campos em branco, preencha-os");
												}
												
											}
										});
										
										JButton btnMenuPrincialCNPJ = new JButton("menu principal");
										btnMenuPrincialCNPJ.setBounds(10, 441, 154, 25);
										cadastrarFornecedor.add(btnMenuPrincialCNPJ);
										btnMenuPrincialCNPJ.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												Main.main(null);
												dispose();
												
											}
										});
										
										cadastrarFornecedor.add(btnCadFornecedor);
										
						
						
		
		
			// BOTOES CONSULTAR E CADASTRAR
		
		JButton botaoConsultar = new JButton("Consultar produto");
		botaoConsultar.setBounds(199, 146, 282, 45);
		botaoConsultar.setFont(new Font("Tahoma", Font.BOLD, 13));
		botaoConsultar.addActionListener( new ActionListener() {
			
			public boolean validacao() {
				try {
					if(escolha.equals("id")) {		
						Integer.parseInt(txtIdConsultar.getText());
					} else {
						txtProdConsultar.getText();
					}
						return true;
				} catch (Exception a) {
					return false;
				}		
			}
			
			public void actionPerformed(ActionEvent e) {
				
				ProdutosConsulta produtosConsulta = new ProdutosConsulta();
				if(escolha!=null) {
					if (validacao()) {
					produtosConsulta.setTblData(tblData_1);
					produtosConsulta.getEscolha(escolha,txtIdConsultar.getText(),txtProdConsultar.getText());					
					produtosConsulta.consultarProdutos();
					} else {
						JOptionPane.showMessageDialog(rootPane, "Campo escolhido preenchido de forma inválida, pesquise por um número válido");
					}
			} else {
				JOptionPane.showMessageDialog(rootPane, "Escolha um campo de consulta");
			}
		      
			}
		 });
		consultarProduto.add(botaoConsultar);	
		
		JButton botaoCadastrar = new JButton("Cadastrar Produto");
		botaoCadastrar.setBounds(215, 159, 282, 45);
		botaoCadastrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		botaoCadastrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
						Produto produto = new Produto();
						
						produto.setId_produto(Integer.parseInt(txtId.getText()));
						produto.setNome_produto(txtProd.getText());
						produto.setCnpj(txtQtd.getText());
						produto.setValorVenda(Double.parseDouble(txtVlr.getText()));
						produto.setId_estoque(1);
						produto.setQuantidade(Integer.parseInt(quantidadeTF.getText()));
											
						ProdutosCadastrar produtosCadastrar = new ProdutosCadastrar();
						CadastrarTratamento verificarVazio = new CadastrarTratamento();
						verificarVazio.verificarVazios(txtId.getText(),txtProd.getText(),txtQtd.getText(),txtVlr.getText(),txtId.getText(),quantidadeTF.getText());
						
						try {					
							produtosCadastrar.cadastrarProdutos(produto);
						} catch (Exception i) {						
							
					
						verificarVazio.verificaErro(produtosCadastrar.getErroMessage());
						JOptionPane.showMessageDialog(rootPane, produtosCadastrar.getErroMessage());					
						}
					
				} catch (Exception a) {
					a.printStackTrace();
					JOptionPane.showMessageDialog(rootPane, "Existem campos em branco, preencha-os");
				}
			}});
		
		cadastrarProduto.add(botaoCadastrar);
		
		getContentPane().add(tabbedPane);		
	
	  }
	}
