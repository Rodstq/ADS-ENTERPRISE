package interfaces.interfacesProdutos;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import models.classesFornecedores.Fornecedor;
import controladores.Produtos.ProdutosConsulta;
import controladores.Produtos.ProdutosAtualizar;
import controladores.Fornecedores.FornecedoresAtualizar;
import controladores.Fornecedores.FornecedoresCadastrar;
import utils.Validadora;
import controladores.Produtos.ProdutosCadastrar;
import models.classesProdutos.Produto;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

import java.awt.CheckboxGroup;

import javax.swing.ButtonGroup;
import data.tratamento.produtos.CadastrarTratamento;
import interfaces.Main;
import data.tratamento.produtos.AtualizarTratamento;

public class InterfaceProdutosPrincipal extends JFrame {

	private JPanel cadastrarProduto;
	private JPanel consultarProduto;
	private JPanel atualizarProduto;
	private JTabbedPane fornecedor;
	private JPanel deletarProduto;
	JTable tblData;
	private JTextField id_estoqueTF;
	private JTabbedPane tabbedPane;
	private JTabbedPane produtos;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroupFornecedor = new ButtonGroup();
	private String escolha;
	private String escolhaFornecedor;
	private JTextField cnpjFornecedor;
	private JTextField nomeFornecedor;
	private JTextField quantidadeTF;
	private Boolean quantidadeErro = false;
	private JTextField idAtualizarTF;
	private JTextField cnpjAtualizarTF;
	private JTextField nomeAtualizarTF;
	private JTextField valorAtualizarTF;
	private JTextField quantidadeAtualizarTF;
	private JTextField idProdDeletar;
	private JTextField nomeFornecedorAtualizar;
	private JTextField cnpjAtualizarID;
	private JTextField IdEstoqueTF;
	private JTextField textFieldNomeFornecedor;
	private JTextField textFieldCnpjFornecedor;

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
		
		setBounds(100, 100, 721, 544);
				
		produtos = new JTabbedPane();
		
		tabbedPane.add(produtos,"Produtos");

		
		// PANE PRODUTOS
		
		// CONSULTAR
		
		consultarProduto = new JPanel();
		produtos.add(consultarProduto,"consultar");
		consultarProduto.setBorder(new EmptyBorder(5, 5, 5, 5));
		consultarProduto.setLayout(null);
		
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
		scrollPane_1.setBounds(10, 170, 685, 215);
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
		btnMenuPrincial.setBounds(10, 413, 154, 25);
		consultarProduto.add(btnMenuPrincial);
		btnMenuPrincial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main frame = new Main();
                frame.setVisible(true);
				dispose();
				
			}
		});
		
		
		// CADASTRAR		

		cadastrarProduto = new JPanel();
		produtos.add(cadastrarProduto, "cadastrar");
		cadastrarProduto.setLayout(null);	
		
		
		JLabel idLabel = new JLabel("Id :");
		cadastrarProduto.add(idLabel);
		idLabel.setBounds(33, 17, 26, 14);
		idLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
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
		
		JLabel valorLabel = new JLabel("Valor :");
		valorLabel.setBounds(327, 17, 35, 14);
		valorLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		cadastrarProduto.add(valorLabel);
		
		JTextField txtVlr = new JTextField();
		txtVlr.setDocument(new Validadora(8, Validadora.dadoInserido.numeroDouble));
		txtVlr.setBounds(372, 14, 101, 20);
		cadastrarProduto.add(txtVlr);
		txtVlr.setColumns(10);
		
		JLabel IdEstoque = new JLabel("Id Estoque : ");
		IdEstoque.setFont(new Font("Tahoma", Font.BOLD, 11));
		IdEstoque.setBounds(33, 102, 93, 14);
		cadastrarProduto.add(IdEstoque);
		
		IdEstoqueTF = new JTextField();
		IdEstoqueTF.setDocument(new Validadora(9, Validadora.dadoInserido.numeroInt));
		IdEstoqueTF.setBounds(106, 100, 132, 20);
		cadastrarProduto.add(IdEstoqueTF);
		IdEstoqueTF.setColumns(10);
		
		JTextField txtProd = new JTextField();
		cadastrarProduto.add(txtProd);
		txtProd.setBounds(90, 43, 383, 20);
		txtProd.setColumns(10);
		
		JLabel produtoNome = new JLabel("Produto :");
		cadastrarProduto.add(produtoNome);
		produtoNome.setBounds(33, 45, 60, 14);
		produtoNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton btnMenuPrincialProd = new JButton("menu principal");
		btnMenuPrincialProd.setBounds(10, 413, 154, 25);
		cadastrarProduto.add(btnMenuPrincialProd);
		btnMenuPrincialProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main frame = new Main();
                frame.setVisible(true);
				dispose();
			}
		});
		
		
		// Atualizar
		
		AtualizarTratamento verificarVazio = new AtualizarTratamento();

		atualizarProduto = new JPanel();
		produtos.add(atualizarProduto, "Atualizar");
		atualizarProduto.setLayout(null);
		
		idAtualizarTF = new JTextField();
		idAtualizarTF.setColumns(10);
		idAtualizarTF.setBounds(228, 32, 138, 20);
		atualizarProduto.add(idAtualizarTF);
		
		nomeAtualizarTF = new JTextField();
		nomeAtualizarTF.setText("desabilitado");
		nomeAtualizarTF.setColumns(10);
		nomeAtualizarTF.setBounds(95, 152, 373, 20);
		atualizarProduto.add(nomeAtualizarTF);
		nomeAtualizarTF.setEnabled(false);
		
		JCheckBox nomeCheckBox = new JCheckBox("Nome :",false);
		nomeCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(nomeCheckBox.isSelected()) {
					nomeAtualizarTF.setDocument(new Validadora(14, Validadora.dadoInserido.dadoLivre));
					verificarVazio.checkBoxValidacao(nomeCheckBox.isSelected(),nomeAtualizarTF);
				} else {
					nomeAtualizarTF.setDocument(new Validadora(14, Validadora.dadoInserido.dadoLivre));
					nomeAtualizarTF.setText("desabilitado");	
					nomeAtualizarTF.setEnabled(false);
					
				}	
			}
		});
		nomeCheckBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		nomeCheckBox.setBounds(24, 152, 97, 23);
		atualizarProduto.add(nomeCheckBox);
		
		
		valorAtualizarTF = new JTextField();
		valorAtualizarTF.setText("desabilitado");
		valorAtualizarTF.setColumns(10);
		valorAtualizarTF.setBounds(95, 122, 91, 20);
		atualizarProduto.add(valorAtualizarTF);
		valorAtualizarTF.setEnabled(false);
		
		JCheckBox valorCheckBox = new JCheckBox("Valor :",false);
		
		valorCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(valorCheckBox.isSelected()) {
					valorAtualizarTF.setDocument(new Validadora(10, Validadora.dadoInserido.numeroInt));
					verificarVazio.checkBoxValidacao(valorCheckBox.isSelected(),valorAtualizarTF);
				} else {
					valorAtualizarTF.setDocument(new Validadora(10, Validadora.dadoInserido.dadoLivre));
					valorAtualizarTF.setText("desabilitado");
					valorAtualizarTF.setEnabled(false);
				}	
			}
			
		});
	
	valorCheckBox.setFont(new Font("Tahoma", Font.BOLD, 11));
	valorCheckBox.setBounds(24, 122, 60, 23);
	atualizarProduto.add(valorCheckBox);
		
		quantidadeAtualizarTF = new JTextField();
		quantidadeAtualizarTF.setText("desabilitado");
		quantidadeAtualizarTF.setColumns(10);
		quantidadeAtualizarTF.setBounds(127, 212, 110, 20);
		atualizarProduto.add(quantidadeAtualizarTF);
		quantidadeAtualizarTF.setEnabled(false);
		
		JCheckBox quantidadeNewCheckBox = new JCheckBox("Quantidade :", false);
		quantidadeNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				if(quantidadeNewCheckBox.isSelected()) {
					quantidadeAtualizarTF.setDocument(new Validadora(14, Validadora.dadoInserido.numeroInt));
					verificarVazio.checkBoxValidacao(quantidadeNewCheckBox.isSelected(),quantidadeAtualizarTF);
				} else {
					quantidadeAtualizarTF.setDocument(new Validadora(14, Validadora.dadoInserido.dadoLivre));
					quantidadeAtualizarTF.setText("desabilitado");	
					quantidadeAtualizarTF.setEnabled(false);
				}	
			}
		});
		quantidadeNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		quantidadeNewCheckBox.setBounds(24, 212, 97, 23);
		atualizarProduto.add(quantidadeNewCheckBox);
		
		
		cnpjAtualizarTF = new JTextField();
		cnpjAtualizarTF.setText("desabilitado");
		cnpjAtualizarTF.setColumns(10);
		cnpjAtualizarTF.setBounds(152, 182, 138, 20);
		atualizarProduto.add(cnpjAtualizarTF);	
		cnpjAtualizarTF.setEnabled(false);
		
		JCheckBox cnpjCheckBox = new JCheckBox("CNPJ Fornecedor :",false);
		cnpjCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(cnpjCheckBox.isSelected()) {
					cnpjAtualizarTF.setDocument(new Validadora(14, Validadora.dadoInserido.numeroInt));
					verificarVazio.checkBoxValidacao(cnpjCheckBox.isSelected(),cnpjAtualizarTF);
				} else {
					cnpjAtualizarTF.setDocument(new Validadora(14, Validadora.dadoInserido.dadoLivre));
					cnpjAtualizarTF.setText("desabilitado");	
					cnpjAtualizarTF.setEnabled(false);
					
				}	
			}
		});
		
		cnpjCheckBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		cnpjCheckBox.setBounds(24, 182, 134, 23);
		atualizarProduto.add(cnpjCheckBox);
		  
		JLabel idAtualizar = new JLabel("ID do produto a ser atualizado :");
		idAtualizar.setFont(new Font("Tahoma", Font.BOLD, 12));
		idAtualizar.setBounds(10, 34, 207, 14);
		atualizarProduto.add(idAtualizar);
		
	
		
		JLabel dadosInfoLabel = new JLabel("Dados a serem atualizados :");
		dadosInfoLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		dadosInfoLabel.setBounds(10, 98, 192, 14);
		atualizarProduto.add(dadosInfoLabel);
		
		
		JButton atualizarProdutoBtn = new JButton("Atualizar Produto");
		atualizarProdutoBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		atualizarProdutoBtn.setBounds(213, 288, 282, 45);
		atualizarProduto.add(atualizarProdutoBtn);
		atualizarProdutoBtn.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				ProdutosAtualizar produtosAtualizar = new ProdutosAtualizar();
			
				
				try {
					boolean verificados = verificarVazio.retornarAtivos(nomeAtualizarTF.isEnabled(),cnpjAtualizarTF.isEnabled(),valorAtualizarTF.isEnabled(),quantidadeAtualizarTF.isEnabled());
					verificarVazio.verificarVazios(idAtualizarTF.getText(), nomeAtualizarTF.getText(), cnpjAtualizarTF.getText(), valorAtualizarTF.getText(), quantidadeAtualizarTF.getText(),verificados);
										
					produtosAtualizar.execQuery(nomeAtualizarTF.isEnabled(), cnpjAtualizarTF.isEnabled(), valorAtualizarTF.isEnabled(),quantidadeAtualizarTF.isEnabled(),
					idAtualizarTF.getText(), nomeAtualizarTF.getText(), cnpjAtualizarTF.getText(), valorAtualizarTF.getText(), quantidadeAtualizarTF.getText());	
					
					JOptionPane.showMessageDialog(rootPane, "Atualização realizada");

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(rootPane, e1.getMessage());
				}
				
		}
		});
		
		
		JButton btnMenuPrincialAtualizar = new JButton("menu principal");
		btnMenuPrincialAtualizar.setBounds(10, 413, 154, 25);
		atualizarProduto.add(btnMenuPrincialAtualizar);
		btnMenuPrincialAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main frame = new Main();
                frame.setVisible(true);
				dispose();
			}
		});
		
			// PANE FORNECEDOR
		
			AtualizarTratamento verificarVazioFornecedor = new AtualizarTratamento();
			
			fornecedor = new JTabbedPane();
			tabbedPane.add(fornecedor,"Fornecedor");
			
			JPanel consultarProduto_1 = new JPanel();
			consultarProduto_1.setLayout(null);
			consultarProduto_1.setBorder(new EmptyBorder(5, 5, 5, 5));
			fornecedor.addTab("consultar", null, consultarProduto_1, null);
			
			textFieldNomeFornecedor = new JTextField();
			textFieldNomeFornecedor.setColumns(10);
			textFieldNomeFornecedor.setBounds(141, 69, 254, 20);
			consultarProduto_1.add(textFieldNomeFornecedor);
			
			JLabel lblNomeFornecedor = new JLabel("nome :");
			lblNomeFornecedor.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNomeFornecedor.setBounds(83, 72, 62, 14);
			consultarProduto_1.add(lblNomeFornecedor);
			
			JScrollPane scrollPaneResultadorFornecedor = new JScrollPane();
			scrollPaneResultadorFornecedor.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPaneResultadorFornecedor.setBounds(10, 170, 685, 215);
			consultarProduto_1.add(scrollPaneResultadorFornecedor);
			
			JLabel lblCnpjFornecedor = new JLabel("cnpj :");
			lblCnpjFornecedor.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblCnpjFornecedor.setBounds(83, 44, 37, 14);
			consultarProduto_1.add(lblCnpjFornecedor);
			
			textFieldCnpjFornecedor = new JTextField();
			textFieldCnpjFornecedor.setColumns(10);
			textFieldCnpjFornecedor.setBounds(122, 41, 45, 20);
			consultarProduto_1.add(textFieldCnpjFornecedor);
			
			JLabel consultarPorLbl = new JLabel("Consultar Por : ");
			consultarPorLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
			consultarPorLbl.setBounds(10, 11, 110, 14);
			consultarProduto_1.add(consultarPorLbl);
			
			JRadioButton RadioButtonIdConsultarFornecedor = new JRadioButton("");
			consultarProduto_1.add(RadioButtonIdConsultarFornecedor);
			
			RadioButtonIdConsultarFornecedor.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {						
					// desativando label e texto produto nome
					lblNomeFornecedor.setEnabled(false);
					textFieldNomeFornecedor.setEnabled(false);
					escolhaFornecedor = "cnpj";
					//ativando label e texto produto id
					textFieldCnpjFornecedor.setEnabled(true);
					lblCnpjFornecedor.setEnabled(true);
				}
				
			});
			buttonGroupFornecedor.add(RadioButtonIdConsultarFornecedor);
			RadioButtonIdConsultarFornecedor.setBounds(56, 41, 21, 23);
			consultarProduto_1.add(RadioButtonIdConsultarFornecedor);	
			
			JRadioButton RadioButtonNomeConsultarFornecedor = new JRadioButton("");
			RadioButtonNomeConsultarFornecedor.setSize(21, 23);
			RadioButtonNomeConsultarFornecedor.setLocation(56, 66);
			consultarProduto_1.add(RadioButtonNomeConsultarFornecedor);
			
			RadioButtonNomeConsultarFornecedor.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {						
					// desativando label e texto produto nome
					lblNomeFornecedor.setEnabled(true);
					textFieldNomeFornecedor.setEnabled(true);
					escolhaFornecedor = "nomeFornecedor";
					//ativando label e texto produto id
					textFieldCnpjFornecedor.setEnabled(false);
					lblCnpjFornecedor.setEnabled(false);
				}
				
			});
			
			buttonGroupFornecedor.add(RadioButtonNomeConsultarFornecedor);
			
			JButton btnMenuPrincialFornecedor = new JButton("menu principal");
			btnMenuPrincialFornecedor.setBounds(10, 413, 154, 25);
			consultarProduto_1.add(btnMenuPrincialFornecedor);
			
			JButton btnConsultarFornecedor = new JButton("Consultar Fornecedor");
			btnConsultarFornecedor.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnConsultarFornecedor.setBounds(200, 114, 282, 45);
			consultarProduto_1.add(btnConsultarFornecedor);
			
			JPanel cadatrar = new JPanel();
			fornecedor.add(cadatrar,"cadastrar");
			cadatrar.setLayout(null);
			
			JLabel cnpjLbl = new JLabel("CNPJ Fornecedor :");
			cnpjLbl.setBounds(22, 104, 100, 14);
			cnpjLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
			cadatrar.add(cnpjLbl);
			
			cnpjFornecedor = new JTextField();
			cnpjFornecedor.setDocument(new Validadora(14,Validadora.dadoInserido.numeroInt));
			cnpjFornecedor.setBounds(127, 101, 154, 20);
			cnpjFornecedor.setColumns(10);
			cadatrar.add(cnpjFornecedor);	
			
			JLabel NomeFornecedorLbl = new JLabel("Nome Fornecedor :");
			NomeFornecedorLbl.setBounds(22, 156, 105, 14);
			NomeFornecedorLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
			cadatrar.add(NomeFornecedorLbl);
			
			nomeFornecedor = new JTextField();
			nomeFornecedor.setDocument(new Validadora(14,Validadora.dadoInserido.dadoLivre));										
			nomeFornecedor.setBounds(132, 153, 274, 20);
			nomeFornecedor.setColumns(10);
			cadatrar.add(nomeFornecedor);	
			
			JLabel lblNewLabel_2 = new JLabel("Cadastrar Fornecedor ");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel_2.setBounds(27, 27, 135, 15);
			cadatrar.add(lblNewLabel_2);
			
			JButton btnCadFornecedor = new JButton("Cadastrar Fornecedor");
			btnCadFornecedor.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnCadFornecedor.setBounds(210, 237, 282, 45);
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
								JOptionPane.showMessageDialog(rootPane, "Fornecedor cadastrado");
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
			btnMenuPrincialCNPJ.setBounds(10, 413, 154, 25);
			cadatrar.add(btnMenuPrincialCNPJ);
			
			btnMenuPrincialCNPJ.addActionListener(new ActionListener() {
		
				@Override
				public void actionPerformed(ActionEvent e) {
					Main frame = new Main();
	                frame.setVisible(true);
					dispose();										
				}
			});
			
			cadatrar.add(btnCadFornecedor);
			
			JPanel atualizarFornecedorTab = new JPanel();
			atualizarFornecedorTab.setLayout(null);
			fornecedor.addTab("atualizar",atualizarFornecedorTab);
			
			JLabel dadosLabelFornecedor = new JLabel("Dados a serem atualizados :");
			dadosLabelFornecedor.setFont(new Font("Tahoma", Font.BOLD, 12));
			dadosLabelFornecedor.setBounds(10, 77, 192, 14);
			atualizarFornecedorTab.add(dadosLabelFornecedor);
			
			
			JCheckBox nomeFornecedorCheckBox = new JCheckBox("Nome :", false);
			nomeFornecedorCheckBox.setFont(new Font("Tahoma", Font.BOLD, 11));
			nomeFornecedorCheckBox.setBounds(24, 131, 97, 23);
			atualizarFornecedorTab.add(nomeFornecedorCheckBox);
			
			nomeFornecedorCheckBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					verificarVazioFornecedor.checkBoxValidacao(nomeFornecedorCheckBox.isSelected(),nomeFornecedorAtualizar);
				}
				
			});
			
			nomeFornecedorAtualizar = new JTextField();
			nomeFornecedorAtualizar.setText("desabilitado");
			nomeFornecedorAtualizar.setEnabled(false);
			nomeFornecedorAtualizar.setColumns(10);
			nomeFornecedorAtualizar.setBounds(95, 131, 373, 20);
			atualizarFornecedorTab.add(nomeFornecedorAtualizar);
			
			JButton btnAtualizarFornecedor = new JButton("Atualizar Fornecedor");
			btnAtualizarFornecedor.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnAtualizarFornecedor.setBounds(202, 233, 282, 45);
			atualizarFornecedorTab.add(btnAtualizarFornecedor);
			
			btnAtualizarFornecedor.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent e) {
					
					FornecedoresAtualizar fornecedorAtualizar = new FornecedoresAtualizar();
				
					
					try {
						boolean verificados = verificarVazioFornecedor.retornarAtivosFornecedor(nomeFornecedorAtualizar.isEnabled());
						verificarVazioFornecedor.verificarVaziosFornecedor(cnpjAtualizarID.getText(),nomeFornecedorAtualizar.getText(),verificados);
											
						fornecedorAtualizar.execQuery(nomeFornecedorAtualizar.isEnabled(),nomeFornecedorAtualizar.getText(),cnpjAtualizarID.getText());	
						
						JOptionPane.showMessageDialog(rootPane, "Atualização realizada");

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(rootPane, e1.getMessage());
					}
					
			}
			});
			
			JButton btnMenuPrincialAtualizar_1 = new JButton("menu principal");
			btnMenuPrincialAtualizar_1.setBounds(10, 413, 154, 25);
			atualizarFornecedorTab.add(btnMenuPrincialAtualizar_1);
	
			btnMenuPrincialAtualizar_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Main frame = new Main();
	                frame.setVisible(true);
					dispose();
				}
			});
			
			JLabel lblCnpjDoFornecedor = new JLabel("Cnpj do Fornecedor a ser atualizado :");
			lblCnpjDoFornecedor.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblCnpjDoFornecedor.setBounds(10, 13, 238, 14);
			atualizarFornecedorTab.add(lblCnpjDoFornecedor);
			
			cnpjAtualizarID = new JTextField();
			cnpjAtualizarID.setDocument(new Validadora(14,Validadora.dadoInserido.numeroInt));
			cnpjAtualizarID.setColumns(10);
			cnpjAtualizarID.setBounds(246, 11, 138, 20);
			atualizarFornecedorTab.add(cnpjAtualizarID);
			

						
		
		
			// BOTOES CONSULTAR E CADASTRAR
		
		JButton botaoConsultar = new JButton("Consultar produto");
		botaoConsultar.setBounds(200, 114, 282, 45);
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
		botaoCadastrar.setBounds(206, 145, 282, 45);
		botaoCadastrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		botaoCadastrar.addActionListener(new ActionListener() {
			
			ProdutosCadastrar produtosCadastrar = new ProdutosCadastrar();

			CadastrarTratamento verificarVazio = new CadastrarTratamento();
			
			
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					Produto produto = new Produto();
				
					
					produto.setId_produto(Integer.parseInt(txtId.getText()));
					produto.setNome_produto(txtProd.getText());
					produto.setCnpj(txtQtd.getText());
					produto.setValorVenda(Double.parseDouble(txtVlr.getText()));
					produto.setId_estoque(Integer.parseInt(IdEstoqueTF.getText()));
					System.out.println(produto.getId_estoque());
					produto.setQuantidade(Integer.parseInt(quantidadeTF.getText()));
					
					if (!Integer.toString(produto.getQuantidade()).isBlank() && produto.getQuantidade() < 1) {
						quantidadeErro = true;
						throw new Exception();
					}
				
					
					verificarVazio.verificarVazios(txtId.getText(),txtProd.getText(),txtQtd.getText(),txtVlr.getText(),txtId.getText(),quantidadeTF.getText());
						
						try {
								produtosCadastrar.cadastrarProdutos(produto);
						
							} catch (Exception i) {	
							
								i.printStackTrace();
								verificarVazio.verificaErro(produtosCadastrar.getErroMessage());
								JOptionPane.showMessageDialog(rootPane, produtosCadastrar.getErroMessage());	
								
							}	
						
				} catch (Exception a) {
						a.printStackTrace();
					if (quantidadeErro){
						JOptionPane.showMessageDialog(rootPane, "Quantidade não pode ser menor que 1");
						quantidadeErro=false;
					}else {
						JOptionPane.showMessageDialog(rootPane, "Existem campos em branco");
					}
				}
			}});
		
		cadastrarProduto.add(botaoCadastrar);
		
		
		
		getContentPane().add(tabbedPane);		
	
	  }
	}
