package interfacesVendas;

import controladores.Cliente.ClienteConsultaDatabase;
import data.tratamento.clients.Clientes;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LinkCPF extends JFrame {

	private JPanel contentPane;
	private JTextField CPFField;
	private JTextField NomeField;
	private static DefaultTableModel tableModel;
	private JTable table;

	private ClienteConsultaDatabase clienteConsultaDatabase;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LinkCPF frame = new LinkCPF();
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
	public LinkCPF() {
		clienteConsultaDatabase = new ClienteConsultaDatabase();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{566, 0};
		gbl_contentPane.rowHeights = new int[]{73, 275, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		// Criação do modelo da tabela com os cabeçalhos "CPF" e "Nome"
		String[] colunas = {"CPF", "Nome"};
		tableModel = new DefaultTableModel(colunas, 0);

		JPanel FormPanel = new JPanel();
		GridBagLayout gbl_FormPanel = new GridBagLayout();
		FormPanel.setLayout(gbl_FormPanel);
		GridBagConstraints gbc_FormPanel = new GridBagConstraints();
		gbc_FormPanel.insets = new Insets(0, 0, 5, 0);
		gbc_FormPanel.anchor = GridBagConstraints.NORTHWEST;
		gbc_FormPanel.gridx = 0;
		gbc_FormPanel.gridy = 0;
		contentPane.add(FormPanel, gbc_FormPanel);

		JLabel lblNewLabel = new JLabel("CPF do cliente:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		FormPanel.add(lblNewLabel, gbc_lblNewLabel);

		CPFField = new JTextField();

		
		GridBagConstraints gbc_CPFField = new GridBagConstraints();
		gbc_CPFField.fill = GridBagConstraints.HORIZONTAL;
		gbc_CPFField.insets = new Insets(0, 0, 5, 0);
		gbc_CPFField.gridx = 1;
		gbc_CPFField.gridy = 0;
		FormPanel.add(CPFField, gbc_CPFField);
		CPFField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nome do cliente: ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		FormPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		NomeField = new JTextField();


		GridBagConstraints gbc_NomeField = new GridBagConstraints();
		gbc_NomeField.fill = GridBagConstraints.HORIZONTAL;
		gbc_NomeField.insets = new Insets(0, 0, 5, 0);
		gbc_NomeField.gridx = 1;
		gbc_NomeField.gridy = 1;
		FormPanel.add(NomeField, gbc_NomeField);
		NomeField.setColumns(10);

		JButton SearchButton = new JButton("Pesquisar");

		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = NomeField.getText();
				String cpf = CPFField.getText();

				if (!cpf.isEmpty()) {
					Clientes cliente = new Clientes();
					cliente.setCpf(cpf);

					List<Object[]> resultados = clienteConsultaDatabase.infoClienteCpf(cliente);
					// Limpa os dados atuais da tabela
					tableModel.setRowCount(0);
					// Preenche a tabela com os dados retornados do banco de dados
					for (Object[] clienteDados : resultados) {
						// Adiciona somente o CPF e o nome na tabela
						tableModel.addRow(new Object[]{clienteDados[1], clienteDados[0]});
					}
				} else if (!nome.isEmpty()) {
					Clientes cliente = new Clientes();
					cliente.setNomeCliente(nome);

					List<Object[]> resultados = clienteConsultaDatabase.infoCliente(cliente);
					// Limpa os dados atuais da tabela
					tableModel.setRowCount(0);
					// Preenche a tabela com os dados retornados do banco de dados
					for (Object[] clienteDados : resultados) {
						// Adiciona somente o CPF e o nome na tabela
						tableModel.addRow(new Object[]{clienteDados[1], clienteDados[0]});
					}
				}
			}
		});

		GridBagConstraints gbc_SearchButton = new GridBagConstraints();
		gbc_SearchButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_SearchButton.insets = new Insets(0, 0, 0, 5);
		gbc_SearchButton.gridx = 1;
		gbc_SearchButton.gridy = 2;
		FormPanel.add(SearchButton, gbc_SearchButton);

		JPanel Tabblepanel = new JPanel();
		GridBagConstraints gbc_Tabblepanel = new GridBagConstraints();
		gbc_Tabblepanel.insets = new Insets(0, 0, 5, 0);
		gbc_Tabblepanel.fill = GridBagConstraints.BOTH;
		gbc_Tabblepanel.gridx = 0;
		gbc_Tabblepanel.gridy = 1;
		contentPane.add(Tabblepanel, gbc_Tabblepanel);
		GridBagLayout gbl_Tabblepanel = new GridBagLayout();
		gbl_Tabblepanel.columnWidths = new int[]{570, 570, 0};
		gbl_Tabblepanel.rowHeights = new int[]{15, 0, 0};
		gbl_Tabblepanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_Tabblepanel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		Tabblepanel.setLayout(gbl_Tabblepanel);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.anchor = GridBagConstraints.NORTHWEST;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		Tabblepanel.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{281, 299, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		JLabel Nomelbl = new JLabel("Nome:");
		GridBagConstraints gbc_Nomelbl = new GridBagConstraints();
		gbc_Nomelbl.anchor = GridBagConstraints.WEST;
		gbc_Nomelbl.insets = new Insets(0, 0, 0, 5);
		gbc_Nomelbl.gridx = 0;
		gbc_Nomelbl.gridy = 0;
		panel.add(Nomelbl, gbc_Nomelbl);

		JLabel lblCpf = new JLabel("CPF:");
		GridBagConstraints gbc_lblCpf = new GridBagConstraints();
		gbc_lblCpf.anchor = GridBagConstraints.WEST;
		gbc_lblCpf.gridx = 1;
		gbc_lblCpf.gridy = 0;
		panel.add(lblCpf, gbc_lblCpf);

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.anchor = GridBagConstraints.WEST;
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.VERTICAL;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		Tabblepanel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{577, 0};
		gbl_panel_2.rowHeights = new int[]{1, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);

		table = new JTable(tableModel);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.HORIZONTAL;
		gbc_table.anchor = GridBagConstraints.NORTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		panel_2.add(table, gbc_table);

		JPanel SubmitPannel = new JPanel();
		GridBagConstraints gbc_SubmitPannel = new GridBagConstraints();
		gbc_SubmitPannel.fill = GridBagConstraints.HORIZONTAL;
		gbc_SubmitPannel.gridx = 0;
		gbc_SubmitPannel.gridy = 2;
		contentPane.add(SubmitPannel, gbc_SubmitPannel);

		JButton SubmitButton = new JButton("Finalizar");
		SubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Implemente a lógica para o botão "Finalizar" aqui, se necessário
			}
		});
		

		CPFField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NomeField.setEnabled(false);
				
			}
		});
		CPFField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (CPFField.getText().isEmpty()){
					NomeField.setEnabled(true);
				}
			}
		});
		
		NomeField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				CPFField.setEnabled(false);
			}
		});
		
		NomeField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (NomeField.getText().isEmpty()){
					CPFField.setEnabled(true);
				}
			}
		});
		
		SearchButton.requestFocusInWindow();
		SubmitPannel.add(SubmitButton);
	}
}
