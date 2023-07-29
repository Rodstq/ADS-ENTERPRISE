package guiCliente;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.zip.DataFormatException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

import controladores.Cliente.ClienteAtualizarDatabase;
<<<<<<< HEAD
=======

>>>>>>> 8a6ae09405037b49a33a26b985a9cdd4ae694462
import data.tratamento.clients.ClienteAtualizarTratamento;
import data.tratamento.clients.ClienteValidadoraInput;
import data.tratamento.clients.Clientes;
import data.tratamento.clients.infoClienteException;
import interfaces.Main;
public class GuiClientesAtualizar extends GuiClientesPrincipal {

	private JPanel contentPane;
	private JTextField inputCpfCliente;
	private JTextField inputNomeCliente;
	private JTextField inputDataNascimentoCliente;
	private JTextField inputEstadoCliente;
	private JTextField inputCidadeCliente;
	private JTextField inputBairroCliente;
	private JTextField inputRuaCliente;
	private JTextField inputCepCliente;
	private JTextField inputDescricaoEnderecoCliente;
	private JTextField inputTelefoneCliente;

	public static void clientesAtualizar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiClientesAtualizar frame = new GuiClientesAtualizar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public GuiClientesAtualizar() {
		setAutoRequestFocus(false);
		setAlwaysOnTop(true);
		

		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCpf = new JLabel("CPF do Cliente:");
		lblCpf.setBounds(12, 12, 121, 15);
		contentPane.add(lblCpf);

		inputCpfCliente = new JTextField();
		inputCpfCliente.setDocument(new ClienteValidadoraInput(11, ClienteValidadoraInput.dadoInserido.cpfCliente));
		inputCpfCliente.setColumns(10);
		inputCpfCliente.setBounds(136, 10, 110, 19);
		contentPane.add(inputCpfCliente);

		JButton btnLimparInfo = new JButton("Limpar");
		btnLimparInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputNomeCliente.setText("");
				inputCpfCliente.setText("");
				inputDataNascimentoCliente.setText("");				
				inputTelefoneCliente.setText("");
				inputEstadoCliente.setText("");
				inputCidadeCliente.setText("");
				inputBairroCliente.setText("");				
				inputCepCliente.setText("");
				inputRuaCliente.setText("");
				inputDescricaoEnderecoCliente.setText("");

			}
		});
		btnLimparInfo.setBounds(678, 425, 117, 25);
		contentPane.add(btnLimparInfo);



		ClienteAtualizarTratamento flag =new ClienteAtualizarTratamento();	
		
		JRadioButton rbnCheckDataNascimento = new JRadioButton("Data de Nascimento");
		rbnCheckDataNascimento.setBounds(27, 48, 168, 23);
		contentPane.add(rbnCheckDataNascimento);

		rbnCheckDataNascimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbnCheckDataNascimento.isSelected()) {
					inputDataNascimentoCliente.setVisible(true);
					inputDataNascimentoCliente.setDocument(new ClienteValidadoraInput(8, ClienteValidadoraInput.dadoInserido.nascimentoCliente));
					flag.nascimentoFlag(true);
				} else {
					inputDataNascimentoCliente.setVisible(false);
					flag.nascimentoFlag(false);
				}
			}
		});
		
		inputDataNascimentoCliente = new JTextField();
		inputDataNascimentoCliente.setBounds(222, 50, 200, 19);
		contentPane.add(inputDataNascimentoCliente);
		inputDataNascimentoCliente.setVisible(false);
		
		
		JRadioButton rbnCheckNome = new JRadioButton("Nome do cliente:");
		rbnCheckNome.setBounds(27, 92, 154, 23);
		contentPane.add(rbnCheckNome);
		rbnCheckNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbnCheckNome.isSelected()) {
					inputNomeCliente.setVisible(true);
					inputNomeCliente.setDocument(new ClienteValidadoraInput(50, ClienteValidadoraInput.dadoInserido.nomeCliente));

					flag.nomeFlag(true);
					
				} else {
					inputNomeCliente.setVisible(false);
					flag.nomeFlag(false);
				}
			}
		});

		inputNomeCliente = new JTextField();
		inputNomeCliente.setBounds(189, 94, 200, 19);
		contentPane.add(inputNomeCliente);
		inputNomeCliente.setVisible(false);
		JRadioButton rbnCheckTelefone = new JRadioButton("Telefone:");
		rbnCheckTelefone.setBounds(27, 133, 98, 23);
		contentPane.add(rbnCheckTelefone);

		rbnCheckTelefone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbnCheckTelefone.isSelected()) {
					inputTelefoneCliente.setVisible(true);
					inputTelefoneCliente.setDocument(new ClienteValidadoraInput(11, ClienteValidadoraInput.dadoInserido.telefoneCliente));

					flag.telefonFlag(true);
				} else {
					flag.telefonFlag(false);
					inputTelefoneCliente.setVisible(false);
					
				}
			}
		});
		inputTelefoneCliente = new JTextField();
		inputTelefoneCliente.setBounds(136, 135, 114, 19);
		contentPane.add(inputTelefoneCliente);
		inputTelefoneCliente.setVisible(false);

		JRadioButton rbnCheckEstado = new JRadioButton("Estado:");
		rbnCheckEstado.setBounds(27, 176, 83, 23);
		contentPane.add(rbnCheckEstado);

		rbnCheckEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbnCheckEstado.isSelected()) {
					inputEstadoCliente.setVisible(true);
					inputEstadoCliente.setDocument(new ClienteValidadoraInput(25, ClienteValidadoraInput.dadoInserido.estadoCliente));

					flag.estadoFlag(true);
				} else {
					flag.estadoFlag(false);
					inputEstadoCliente.setVisible(false);
					
				}
			}
		});
		inputEstadoCliente = new JTextField();
		inputEstadoCliente.setBounds(118, 178, 114, 19);
		contentPane.add(inputEstadoCliente);
		inputEstadoCliente.setVisible(false);

		JRadioButton rbnCheckCidade = new JRadioButton("Cidade:");
		rbnCheckCidade.setBounds(27, 216, 83, 23);
		contentPane.add(rbnCheckCidade);

		rbnCheckCidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbnCheckCidade.isSelected()) {
					inputCidadeCliente.setVisible(true);
					inputCidadeCliente.setDocument(new ClienteValidadoraInput(25, ClienteValidadoraInput.dadoInserido.cidadeCliente));

					flag.cidadFlag(true);
				} else {
					flag.cidadFlag(false);
					
					inputCidadeCliente.setVisible(false);
				}
			}
		});
		inputCidadeCliente = new JTextField();
		inputCidadeCliente.setBounds(118, 218, 114, 19);
		contentPane.add(inputCidadeCliente);
		inputCidadeCliente.setVisible(false); 

		JRadioButton rbnCheckBairro = new JRadioButton("Bairro:");
		rbnCheckBairro.setBounds(27, 251, 83, 23);
		contentPane.add(rbnCheckBairro);

		rbnCheckBairro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbnCheckBairro.isSelected()) {
					inputBairroCliente.setVisible(true);
					inputBairroCliente.setDocument(new ClienteValidadoraInput(25, ClienteValidadoraInput.dadoInserido.bairroCliente));

					flag.bairrFlag(true);
				} else {
					inputBairroCliente.setVisible(false);
					flag.bairrFlag(false);
				}
			}
		});
		inputBairroCliente = new JTextField();
		inputBairroCliente.setBounds(118, 253, 114, 19);
		contentPane.add(inputBairroCliente);
		inputBairroCliente.setVisible(false); 

		JRadioButton rbnCheckRua = new JRadioButton("Rua:");
		rbnCheckRua.setBounds(27, 293, 68, 23);
		contentPane.add(rbnCheckRua);

		rbnCheckRua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbnCheckRua.isSelected()) {
					inputRuaCliente.setVisible(true);
					inputRuaCliente.setDocument(new ClienteValidadoraInput(25, ClienteValidadoraInput.dadoInserido.ruaCliente));

					flag.ruaFlag(true);
				} else {
					flag.ruaFlag(false);
					inputRuaCliente.setVisible(false);
				}
			}
		});
		inputRuaCliente = new JTextField();
		inputRuaCliente.setBounds(96, 295, 114, 19);
		contentPane.add(inputRuaCliente);
		inputRuaCliente.setVisible(false); 

		JRadioButton rbnCheckCep = new JRadioButton("Cep:");
		rbnCheckCep.setBounds(27, 344, 68, 23);
		contentPane.add(rbnCheckCep);

		rbnCheckCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbnCheckCep.isSelected()) {
					inputCepCliente.setVisible(true);
					inputCepCliente.setDocument(new ClienteValidadoraInput(8, ClienteValidadoraInput.dadoInserido.cepCliente));

					flag.cepFlag(true);
				} else {
					flag.cepFlag(false);
					inputCepCliente.setVisible(false);
				}
			}
		});
		inputCepCliente = new JTextField();
		inputCepCliente.setBounds(96, 346, 114, 19);
		contentPane.add(inputCepCliente);
		inputCepCliente.setVisible(false);

		JRadioButton rdbtnCheckDescricaoEndereco = new JRadioButton("Descrição do endereço:");
		rdbtnCheckDescricaoEndereco.setBounds(27, 386, 205, 23);
		contentPane.add(rdbtnCheckDescricaoEndereco);

		rdbtnCheckDescricaoEndereco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnCheckDescricaoEndereco.isSelected()) {
					inputDescricaoEnderecoCliente.setVisible(true);
					inputDescricaoEnderecoCliente.setDocument(new ClienteValidadoraInput(25, ClienteValidadoraInput.dadoInserido.descricaoCliente));

					flag.descricaFlag(true);
				} else {
					
					flag.descricaFlag(false);
					inputDescricaoEnderecoCliente.setVisible(false);
				}
			}
		});
		

		JButton btnAtualizarCliente = new JButton("Atualizar");
		btnAtualizarCliente.setBounds(807, 425, 117, 25);
		contentPane.add(btnAtualizarCliente);
		btnAtualizarCliente.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)  {
		        
		    	ClienteAtualizarTratamento atualizar =new ClienteAtualizarTratamento();
		        
		    	
		    	String nomeCliente = inputNomeCliente.getText();
		    	String cpfCliente = inputCpfCliente.getText();
		    	String nascimento = inputDataNascimentoCliente.getText();
		    	String  telefoneCliente = inputTelefoneCliente.getText();
		    	
		    
		    	String cepCliente = inputCepCliente.getText();
		    	String estadoCliente = inputEstadoCliente.getText();
		    	String cidadeCliente = inputCidadeCliente.getText();
		    	String bairroCliente =  inputBairroCliente.getText();
		    	String ruaCliente =  inputRuaCliente.getText();
		    	String descricaoEndereco = inputDescricaoEnderecoCliente.getText();
  
		            try {
						flag.clienteAtualizarCadastroCliente(nascimento, cpfCliente, nomeCliente, telefoneCliente);
					} catch (infoClienteException e1) {
						
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
						
					} catch (DataFormatException erroFormato) {
						
						JOptionPane.showMessageDialog(null, erroFormato.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
					}
		            
            
		            try {
						flag.clienteAtualizarEnderecoCliente(cpfCliente, cepCliente, estadoCliente, cidadeCliente, bairroCliente, ruaCliente, descricaoEndereco);
					} catch (infoClienteException erro) {
						
						JOptionPane.showMessageDialog(null, erro.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
					}
		            
		            if(!inputCpfCliente.getText().isBlank()) {
		            	
		            	inputNomeCliente.setText("");					
						inputDataNascimentoCliente.setText("");				
						inputTelefoneCliente.setText("");
						inputEstadoCliente.setText("");
						inputCidadeCliente.setText("");
						inputBairroCliente.setText("");				
						inputCepCliente.setText("");
						inputRuaCliente.setText("");
						inputDescricaoEnderecoCliente.setText("");
		            }
		            
		    }
		});
		inputDescricaoEnderecoCliente = new JTextField();
		inputDescricaoEnderecoCliente.setBounds(240, 388, 425, 19);
		contentPane.add(inputDescricaoEnderecoCliente);
		
		inputDescricaoEnderecoCliente.setVisible(false);
		
        JLabel opaqueLabel = new JLabel("AdsGestão");
        opaqueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        opaqueLabel.setFont(new Font("Dialog", Font.BOLD, 80));
        opaqueLabel.setBounds(215, 40, 490, 341);
        opaqueLabel.setOpaque(true);
        opaqueLabel.setBackground(new Color(0, 0, 0, 0)); 
        opaqueLabel.setForeground(new Color(0, 0, 0, 50));
        contentPane.add(opaqueLabel);
	    
	    
		JButton btnMenuPrincial = new JButton("menu principal");
		btnMenuPrincial.setBounds(27, 425, 154, 25);
		contentPane.add(btnMenuPrincial);
		btnMenuPrincial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.main(null);
				dispose();
				
			}
		});

	}
}