package interfaces.guiCliente;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.zip.DataFormatException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import data.tratamento.clients.ClienteCadastroTratamento;
import data.tratamento.clients.ClienteValidadoraInput;
import data.tratamento.clients.infoClienteException;
import interfaces.Main;

public class GuiClientesCadastro extends GuiClientesPrincipal {

	private JPanel contentPane;
	private JTextField inputNomeCliente;
	private JTextField inputDescricaoCliente;
	private JTextField inputRuaCliente;
	private JTextField inputDataNascimentoCliente;
	private JTextField inputTelefoneCliente;
	private JTextField inputCepCliente;
	private JTextField inputBairroCliente;
	private JTextField inputCidadeCliente;
	private JTextField inputCpfCLiente;
	private JTextField inputEstadoCliente;

	/**
	 * Launch the application.
	 */
	public static void clientesCadastro() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					GuiClientesCadastro frame = new GuiClientesCadastro();
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
	public GuiClientesCadastro () {

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

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(487, 53, 67, 15);
		contentPane.add(lblTelefone);

		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		lblDataDeNascimento.setBounds(166, 53, 147, 15);
		contentPane.add(lblDataDeNascimento);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(12, 80, 54, 30);
		contentPane.add(lblEstado);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(176, 88, 54, 15);
		contentPane.add(lblCidade);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(523, 80, 31, 20);
		contentPane.add(lblCep);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(349, 88, 48, 15);
		contentPane.add(lblBairro);

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(12, 122, 70, 15);
		contentPane.add(lblRua);

		JLabel lblDescrio = new JLabel("Descrição:");
		lblDescrio.setBounds(12, 156, 74, 15);
		contentPane.add(lblDescrio);

		//Ler o que foi digitado
		inputNomeCliente = new JTextField();
		inputNomeCliente.setDocument(new ClienteValidadoraInput(30, ClienteValidadoraInput.dadoInserido.nomeCliente));
		inputNomeCliente.setBounds(140, 17, 388, 19);
		contentPane.add(inputNomeCliente);
		inputNomeCliente.setColumns(10);



		inputDescricaoCliente = new JTextField();
		inputDescricaoCliente.setDocument(new ClienteValidadoraInput(25, ClienteValidadoraInput.dadoInserido.descricaoCliente));
		inputDescricaoCliente.setColumns(10);
		inputDescricaoCliente.setBounds(104, 154, 388, 19);
		contentPane.add(inputDescricaoCliente);


		inputRuaCliente = new JTextField();
		inputRuaCliente.setDocument(new ClienteValidadoraInput(25, ClienteValidadoraInput.dadoInserido.ruaCliente));
		inputRuaCliente.setColumns(10);
		inputRuaCliente.setBounds(49, 122, 388, 19);
		contentPane.add(inputRuaCliente);

		inputDataNascimentoCliente = new JTextField();
		inputDataNascimentoCliente.setDocument(new ClienteValidadoraInput(8, ClienteValidadoraInput.dadoInserido.nascimentoCliente));
		inputDataNascimentoCliente.setColumns(10);
		inputDataNascimentoCliente.setBounds(313, 51, 163, 19);
		contentPane.add(inputDataNascimentoCliente);


		inputTelefoneCliente = new JTextField();
		inputTelefoneCliente.setDocument(new ClienteValidadoraInput(11, ClienteValidadoraInput.dadoInserido.telefoneCliente));
		inputTelefoneCliente.setColumns(10);
		inputTelefoneCliente.setBounds(559, 51, 145, 19);
		contentPane.add(inputTelefoneCliente);

		inputCepCliente = new JTextField();
		inputCepCliente.setDocument(new ClienteValidadoraInput(8, ClienteValidadoraInput.dadoInserido.cepCliente));
		inputCepCliente.setColumns(10);
		inputCepCliente.setBounds(559, 86, 145, 19);
		contentPane.add(inputCepCliente);


		inputBairroCliente = new JTextField();
		inputBairroCliente.setDocument(new ClienteValidadoraInput(25, ClienteValidadoraInput.dadoInserido.bairroCliente));
		inputBairroCliente.setColumns(10);
		inputBairroCliente.setBounds(402, 86, 110, 19);
		contentPane.add(inputBairroCliente);


		inputCidadeCliente = new JTextField();
		inputCidadeCliente.setDocument(new ClienteValidadoraInput(25, ClienteValidadoraInput.dadoInserido.cidadeCliente));
		inputCidadeCliente.setColumns(10);
		inputCidadeCliente.setBounds(233, 86, 110, 19);
		contentPane.add(inputCidadeCliente);


		inputCpfCLiente = new JTextField();
		inputCpfCLiente.setDocument(new ClienteValidadoraInput(11, ClienteValidadoraInput.dadoInserido.cpfCliente));
		inputCpfCLiente.setColumns(10);
		inputCpfCLiente.setBounds(49, 51, 110, 19);
		contentPane.add(inputCpfCLiente);


		inputEstadoCliente = new JTextField();
		inputEstadoCliente.setDocument(new ClienteValidadoraInput(25, ClienteValidadoraInput.dadoInserido.estadoCliente));
		inputEstadoCliente.setColumns(10);
		inputEstadoCliente.setBounds(73, 86, 90, 19);
		contentPane.add(inputEstadoCliente);


		JButton btnLimparInfo = new JButton("Limpar");
		btnLimparInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {


				inputNomeCliente.setText("");
				inputCpfCLiente.setText("");
				inputDataNascimentoCliente.setText("");
				inputTelefoneCliente.setText("");
				inputEstadoCliente.setText("");
				inputCidadeCliente.setText("");
				inputBairroCliente.setText("");
				inputCepCliente.setText("");
				inputRuaCliente.setText("");
				inputDescricaoCliente.setText("");

			}
		});
		btnLimparInfo.setBounds(678, 425, 117, 25);
		contentPane.add(btnLimparInfo);

		JButton btnCadastrarCliente = new JButton("Cadastrar");

		try {
		btnCadastrarCliente.addActionListener(new ActionListener() {
		    @Override
			public void actionPerformed  (ActionEvent e) {

		    	String nomeCliente = inputNomeCliente.getText();
		    	String cpfCliente = inputCpfCLiente.getText();
		    	String dataNascimento = inputDataNascimentoCliente.getText();
		    	String  telefoneCliente = inputTelefoneCliente.getText();
		    	String cepCliente = inputCepCliente.getText();
		    	String estadoCliente = inputEstadoCliente.getText();
		    	String cidadeCliente = inputCidadeCliente.getText();
		    	String bairroCliente =  inputBairroCliente.getText();
		    	String ruaCliente =  inputRuaCliente.getText();
		    	String descricaoEndereco = inputDescricaoCliente.getText();


		               try {
		        		   ClienteCadastroTratamento cliente = new ClienteCadastroTratamento();
		        		   cliente.cadastrarClienteInfoTratamento(cpfCliente, nomeCliente,  dataNascimento, telefoneCliente);

		        		   cliente.cadastrarEnderecoCliente(cepCliente, estadoCliente, cidadeCliente, bairroCliente,
		        				    ruaCliente, descricaoEndereco, cpfCliente);


							JOptionPane.showMessageDialog(null, "Sucesso ao cadastrar o cliente", "Erro", JOptionPane.INFORMATION_MESSAGE);

		                } catch (infoClienteException erro) {
		                	 JOptionPane.showMessageDialog(null, erro.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

		                } catch(DataFormatException e1) {

		                	JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

		                }catch (SQLException e2) {

		                	JOptionPane.showMessageDialog(null, e2.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		                }

		    }
		}); } catch(Exception msg){

		}

		btnCadastrarCliente.setBounds(807, 425, 117, 25);
		contentPane.add(btnCadastrarCliente);

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
			@Override
			public void actionPerformed(ActionEvent e) {
				Main frame = new Main();
                frame.setVisible(true);
				dispose();

			}
		});
	}
}




