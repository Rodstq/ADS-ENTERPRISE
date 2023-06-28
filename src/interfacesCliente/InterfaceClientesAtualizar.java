package interfacesCliente;

import java.awt.EventQueue;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import classesCliente.Clientes;
import classesCliente.ClienteAtualizarTratamento;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

import controladores.ClienteAtualizarDatabase;
public class InterfaceClientesAtualizar extends InterfaceClientesPrincipal {

	private JPanel contentPane;
	private JTextField textFieldCPF;
	private JTextField textFieldNomeCliente;
	private JTextField textFieldDataNascimento;
	private JTextField textFieldEstado;
	private JTextField textFieldCidade;
	private JTextField textFieldBairro;
	private JTextField textFieldRua;
	private JTextField textFieldCep;
	private JTextField textFieldDescricaoEndereco;
	private JTextField textFieldTelefone;

	public static void clientesAtualizar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceClientesAtualizar frame = new InterfaceClientesAtualizar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public InterfaceClientesAtualizar() {

		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCpf = new JLabel("CPF do Cliente:");
		lblCpf.setBounds(12, 12, 121, 15);
		contentPane.add(lblCpf);

		textFieldCPF = new JTextField();
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(136, 10, 110, 19);
		contentPane.add(textFieldCPF);

		JButton btnLimparInfo = new JButton("Limpar");
		btnLimparInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnLimparInfo.setBounds(678, 425, 117, 25);
		contentPane.add(btnLimparInfo);

		JButton btnAtualizarCliente = new JButton("Atualizar");
		btnAtualizarCliente.setBounds(807, 425, 117, 25);
		contentPane.add(btnAtualizarCliente);
		btnAtualizarCliente.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        ClienteAtualizarDatabase atualizarCliente = new ClienteAtualizarDatabase();
		        
		        Clientes cliente =new Clientes();
		        
		        ClienteAtualizarTratamento atualizar =new ClienteAtualizarTratamento();
		        	LocalDate teste = null;
		        	if(!textFieldDataNascimento.getText().isBlank() || !textFieldDataNascimento.getText().isEmpty()) {
		        	LocalDate dataNascimento = LocalDate.parse(textFieldDataNascimento.getText(), DateTimeFormatter.ofPattern("ddMMyyyy"));
		        	teste = dataNascimento;
		        	}
          
		            atualizar.clienteAtualizarCadastroCliente(teste, textFieldCPF.getText(),  textFieldNomeCliente.getText(), textFieldTelefone.getText());
		            
		            		            atualizar.clienteAtualizarEnderecoCliente( textFieldCep.getText(), textFieldEstado.getText(), textFieldCidade.getText(), 
		            		textFieldBairro.getText(), textFieldRua.getText(),textFieldDescricaoEndereco.getText());

		            
		    }
		});



		JRadioButton rbnCheckNome = new JRadioButton("Nome do cliente:");
		rbnCheckNome.setBounds(27, 92, 154, 23);
		contentPane.add(rbnCheckNome);
		rbnCheckNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbnCheckNome.isSelected()) {
					textFieldNomeCliente.setVisible(true);
				} else {
					textFieldNomeCliente.setVisible(false);
				}
			}
		});

		textFieldNomeCliente = new JTextField();
		textFieldNomeCliente.setBounds(189, 94, 200, 19);
		contentPane.add(textFieldNomeCliente);
		textFieldNomeCliente.setVisible(false);

		JRadioButton rbnCheckDataNascimento = new JRadioButton("Data de Nascimento");
		rbnCheckDataNascimento.setBounds(27, 48, 168, 23);
		contentPane.add(rbnCheckDataNascimento);

		rbnCheckDataNascimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbnCheckDataNascimento.isSelected()) {
					textFieldDataNascimento.setVisible(true);
				} else {
					textFieldDataNascimento.setVisible(false);
				}
			}
		});
		textFieldDataNascimento = new JTextField();
		textFieldDataNascimento.setBounds(222, 50, 200, 19);
		contentPane.add(textFieldDataNascimento);
		textFieldDataNascimento.setVisible(false);

		JRadioButton rbnCheckTelefone = new JRadioButton("Telefone:");
		rbnCheckTelefone.setBounds(27, 133, 98, 23);
		contentPane.add(rbnCheckTelefone);

		rbnCheckTelefone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbnCheckTelefone.isSelected()) {
					textFieldTelefone.setVisible(true);
				} else {
					textFieldTelefone.setVisible(false);
				}
			}
		});
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(136, 135, 114, 19);
		contentPane.add(textFieldTelefone);
		textFieldTelefone.setVisible(false);

		JRadioButton rbnCheckEstado = new JRadioButton("Estado:");
		rbnCheckEstado.setBounds(27, 176, 83, 23);
		contentPane.add(rbnCheckEstado);

		rbnCheckEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbnCheckEstado.isSelected()) {
					textFieldEstado.setVisible(true);
				} else {
					textFieldEstado.setVisible(false);
				}
			}
		});
		textFieldEstado = new JTextField();
		textFieldEstado.setBounds(118, 178, 114, 19);
		contentPane.add(textFieldEstado);
		textFieldEstado.setVisible(false);

		JRadioButton rbnCheckCidade = new JRadioButton("Cidade:");
		rbnCheckCidade.setBounds(27, 216, 83, 23);
		contentPane.add(rbnCheckCidade);

		rbnCheckCidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbnCheckCidade.isSelected()) {
					textFieldCidade.setVisible(true);
				} else {
					textFieldCidade.setVisible(false);
				}
			}
		});
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(118, 218, 114, 19);
		contentPane.add(textFieldCidade);
		textFieldCidade.setVisible(false); 

		JRadioButton rbnCheckBairro = new JRadioButton("Bairro:");
		rbnCheckBairro.setBounds(27, 251, 83, 23);
		contentPane.add(rbnCheckBairro);

		rbnCheckBairro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbnCheckBairro.isSelected()) {
					textFieldBairro.setVisible(true);
				} else {
					textFieldBairro.setVisible(false);
				}
			}
		});
		textFieldBairro = new JTextField();
		textFieldBairro.setBounds(118, 253, 114, 19);
		contentPane.add(textFieldBairro);
		textFieldBairro.setVisible(false); 

		JRadioButton rbnCheckRua = new JRadioButton("Rua:");
		rbnCheckRua.setBounds(27, 293, 68, 23);
		contentPane.add(rbnCheckRua);

		rbnCheckRua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbnCheckRua.isSelected()) {
					textFieldRua.setVisible(true);
				} else {
					textFieldRua.setVisible(false);
				}
			}
		});
		textFieldRua = new JTextField();
		textFieldRua.setBounds(96, 295, 114, 19);
		contentPane.add(textFieldRua);
		textFieldRua.setVisible(false); 

		JRadioButton rbnCheckCep = new JRadioButton("Cep:");
		rbnCheckCep.setBounds(27, 344, 68, 23);
		contentPane.add(rbnCheckCep);

		rbnCheckCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbnCheckCep.isSelected()) {
					textFieldCep.setVisible(true);
				} else {
					textFieldCep.setVisible(false);
				}
			}
		});
		textFieldCep = new JTextField();
		textFieldCep.setBounds(96, 346, 114, 19);
		contentPane.add(textFieldCep);
		textFieldCep.setVisible(false);

		JRadioButton rdbtnCheckDescricaoEndereco = new JRadioButton("Descrição do endereço:");
		rdbtnCheckDescricaoEndereco.setBounds(27, 386, 205, 23);
		contentPane.add(rdbtnCheckDescricaoEndereco);

		rdbtnCheckDescricaoEndereco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnCheckDescricaoEndereco.isSelected()) {
					textFieldDescricaoEndereco.setVisible(true);
				} else {
					textFieldDescricaoEndereco.setVisible(false);
				}
			}
		});
		textFieldDescricaoEndereco = new JTextField();
		textFieldDescricaoEndereco.setBounds(240, 388, 425, 19);
		contentPane.add(textFieldDescricaoEndereco);
		textFieldDescricaoEndereco.setVisible(false);
	}
}
