package interfacesVendas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexaoDb.Db;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import javax.swing.JSeparator;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TelaVendas extends JFrame {

	private JPanel contentPane;
	private JTextField NomeProdField;
	private JTextField CodProdField;
	private JTable ProdTable;
	private DefaultTableModel tableModel;


	/**
	 * Launch the application.
	 */
	public static void TelaCaixa() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVendas frame = new TelaVendas();
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
	public TelaVendas() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Db.CloseDb();
			}
		});
		Db.Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel MainPanel = new JPanel();
		contentPane.add(MainPanel);
		GridBagLayout gbl_MainPanel = new GridBagLayout();
		gbl_MainPanel.columnWidths = new int[]{0, 0};
		gbl_MainPanel.rowHeights = new int[]{0, 84, 14, 36, 0, 0};
		gbl_MainPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_MainPanel.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		MainPanel.setLayout(gbl_MainPanel);
		
		JLabel lblVendas = new JLabel("VENDAS");
		lblVendas.setForeground(new Color(102, 102, 102));
		lblVendas.setFont(new Font("Dialog", Font.BOLD, 24));
		GridBagConstraints gbc_lblVendas = new GridBagConstraints();
		gbc_lblVendas.insets = new Insets(0, 0, 5, 0);
		gbc_lblVendas.gridx = 0;
		gbc_lblVendas.gridy = 0;
		MainPanel.add(lblVendas, gbc_lblVendas);
		
		JPanel FormPanel = new JPanel();
		GridBagConstraints gbc_FormPanel = new GridBagConstraints();
		gbc_FormPanel.insets = new Insets(0, 0, 5, 0);
		gbc_FormPanel.anchor = GridBagConstraints.SOUTH;
		gbc_FormPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_FormPanel.gridx = 0;
		gbc_FormPanel.gridy = 1;
		MainPanel.add(FormPanel, gbc_FormPanel);
		GridBagLayout gbl_FormPanel = new GridBagLayout();
		gbl_FormPanel.columnWidths = new int[]{137, 114, 70, 0};
		gbl_FormPanel.rowHeights = new int[]{19, 0, 0, 0};
		gbl_FormPanel.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_FormPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		FormPanel.setLayout(gbl_FormPanel);
		
		JLabel CodProdLabel = new JLabel("Código do produto:");
		GridBagConstraints gbc_CodProdLabel = new GridBagConstraints();
		gbc_CodProdLabel.anchor = GridBagConstraints.EAST;
		gbc_CodProdLabel.insets = new Insets(0, 0, 5, 5);
		gbc_CodProdLabel.gridx = 0;
		gbc_CodProdLabel.gridy = 0;
		FormPanel.add(CodProdLabel, gbc_CodProdLabel);
		
		CodProdField = new JTextField();
		GridBagConstraints gbc_CodProdField = new GridBagConstraints();
		gbc_CodProdField.insets = new Insets(0, 0, 5, 5);
		gbc_CodProdField.fill = GridBagConstraints.HORIZONTAL;
		gbc_CodProdField.gridx = 1;
		gbc_CodProdField.gridy = 0;
		FormPanel.add(CodProdField, gbc_CodProdField);
		CodProdField.setColumns(10);
		
		JLabel NomeProdLabel = new JLabel("Nome do produto:");
		GridBagConstraints gbc_NomeProdLabel = new GridBagConstraints();
		gbc_NomeProdLabel.insets = new Insets(0, 0, 5, 5);
		gbc_NomeProdLabel.anchor = GridBagConstraints.WEST;
		gbc_NomeProdLabel.gridx = 0;
		gbc_NomeProdLabel.gridy = 1;
		FormPanel.add(NomeProdLabel, gbc_NomeProdLabel);
		
		NomeProdField = new JTextField();
		GridBagConstraints gbc_NomeProdField = new GridBagConstraints();
		gbc_NomeProdField.insets = new Insets(0, 0, 5, 5);
		gbc_NomeProdField.fill = GridBagConstraints.HORIZONTAL;
		gbc_NomeProdField.gridx = 1;
		gbc_NomeProdField.gridy = 1;
		FormPanel.add(NomeProdField, gbc_NomeProdField);
		NomeProdField.setColumns(10);
		
		JButton AddButton = new JButton("Adicionar");
		AddButton.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
				int codProd = Integer.parseInt(CodProdField.getText());
				String nomeProd = NomeProdField.getText();

				String query = "SELECT * FROM produtos WHERE id_produto = ?";
				PreparedStatement stmt = null;

				try {
					Connection con = Db.getCon();
					stmt = con.prepareStatement(query);
					stmt.setInt(1, codProd);

					ResultSet rs = stmt.executeQuery();

					// Item encontrado
					if (rs.next()) {
						String nomeProduto = rs.getString("nome_produto");
						nomeProd = nomeProduto;
						DefaultTableModel tableModel = (DefaultTableModel) ProdTable.getModel();
						tableModel.addRow(new Object[]{codProd, nomeProd});
						System.out.println("Nome do produto encontrado: " + nomeProduto);
					} else {
						// Item não encontrado
						System.out.println("Item não encontrado na tabela Produtos com o id_produto: " + codProd);
					}

					rs.close();
					stmt.close();

				} catch (SQLException ex) {
					throw new RuntimeException("Erro ao executar a consulta: " + ex.getMessage(), ex);
				}
		    }
		});

		GridBagConstraints gbc_AddButton = new GridBagConstraints();
		gbc_AddButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_AddButton.insets = new Insets(0, 0, 0, 5);
		gbc_AddButton.gridx = 1;
		gbc_AddButton.gridy = 2;
		FormPanel.add(AddButton, gbc_AddButton);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 2;
		MainPanel.add(separator, gbc_separator);
		
		JPanel TablePanel = new JPanel();
		GridBagConstraints gbc_TablePanel = new GridBagConstraints();
		gbc_TablePanel.insets = new Insets(0, 0, 5, 0);
		gbc_TablePanel.fill = GridBagConstraints.BOTH;
		gbc_TablePanel.gridx = 0;
		gbc_TablePanel.gridy = 3;
		MainPanel.add(TablePanel, gbc_TablePanel);
		TablePanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		TablePanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Código:");
		lblNewLabel.setBounds(0, 0, 165, 18);
		panel.add(lblNewLabel);
		
		JLabel TableProdNome = new JLabel("Nome:");
		TableProdNome.setBounds(165, 0, 165, 18);
		panel.add(TableProdNome);

		ProdTable = new JTable();
		ProdTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"C\u00F3digo", "Nome"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		TablePanel.add(ProdTable);
	
		
		// Dentro do construtor TelaVendas()
		ProdTable.setModel(new DefaultTableModel(
		    new Object[][]{},
		    new String[]{"Código", "Nome"}
		));
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 4;
		MainPanel.add(panel_1, gbc_panel_1);
		
		JButton SubmitButton = new JButton("Finalizar");
		panel_1.add(SubmitButton);

		JButton RemoveButton = new JButton("Remover");
		RemoveButton.setEnabled(false);
		RemoveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = ProdTable.getSelectedRow();
				if (selectedRow != -1) {
					tableModel.removeRow(selectedRow);
				}
			}
		});

		panel_1.add(RemoveButton);
		SubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		ProdTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (ProdTable.getSelectedRow() != -1) {
					RemoveButton.setEnabled(true);
				} else {
					RemoveButton.setEnabled(false);
				}
			}
		});

	}
}
