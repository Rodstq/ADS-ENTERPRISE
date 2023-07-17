package interfacesVendas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import conexaoDb.Db;
import java.awt.FlowLayout;

public class TelaVendas extends JFrame {

	private JPanel contentPane;
	private JTextField NomeProdField;
	private static JTextField CodProdField;
	private JTable ProdTable;
	private DefaultTableModel tableModel;

	public static String getCodProdField() {
		return CodProdField.getText();
	}

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
		setTitle("Tela de vendas");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Db.CloseDb();
			}
		});
		Db.Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
				contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
				JPanel MainPanel = new JPanel();
				contentPane.add(MainPanel);
				GridBagLayout gbl_MainPanel = new GridBagLayout();
				gbl_MainPanel.columnWidths = new int[] { 365, 0 };
				gbl_MainPanel.rowHeights = new int[] { 0, 89, 14, 64, 0, 0 };
				gbl_MainPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
				gbl_MainPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
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
								gbc_FormPanel.anchor = GridBagConstraints.NORTH;
								gbc_FormPanel.fill = GridBagConstraints.HORIZONTAL;
								gbc_FormPanel.gridx = 0;
								gbc_FormPanel.gridy = 1;
								MainPanel.add(FormPanel, gbc_FormPanel);
								GridBagLayout gbl_FormPanel = new GridBagLayout();
								gbl_FormPanel.columnWidths = new int[] { 137, 132, 70, 0 };
								gbl_FormPanel.rowHeights = new int[] { 19, 0, 0, 0 };
								gbl_FormPanel.columnWeights = new double[] { 1.0, 1.0, 0.0, Double.MIN_VALUE };
								gbl_FormPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
								FormPanel.setLayout(gbl_FormPanel);
								
										JLabel CodProdLabel = new JLabel("Código do produto:");
										GridBagConstraints gbc_CodProdLabel = new GridBagConstraints();
										gbc_CodProdLabel.anchor = GridBagConstraints.WEST;
										gbc_CodProdLabel.insets = new Insets(0, 0, 5, 5);
										gbc_CodProdLabel.gridx = 0;
										gbc_CodProdLabel.gridy = 0;
										FormPanel.add(CodProdLabel, gbc_CodProdLabel);
										
										CodProdField = new JTextField();
										GridBagConstraints gbc_CodProdField = new GridBagConstraints();
										gbc_CodProdField.gridwidth = 2;
										gbc_CodProdField.insets = new Insets(0, 0, 5, 0);
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
				gbc_NomeProdField.gridwidth = 2;
				gbc_NomeProdField.insets = new Insets(0, 0, 5, 0);
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
												tableModel.addRow(new Object[] { codProd, nomeProd });
												System.out.println("Nome do produto encontrado: " + nomeProduto);
											} else {
												// Item não encontrado
												System.out.println(
														"Item não encontrado na tabela Produtos com o id_produto: " + codProd);
												AddError.main(null);
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
														gbc_AddButton.gridx = 2;
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
																		gbc_TablePanel.anchor = GridBagConstraints.NORTH;
																		gbc_TablePanel.insets = new Insets(0, 0, 5, 0);
																		gbc_TablePanel.fill = GridBagConstraints.HORIZONTAL;
																		gbc_TablePanel.gridx = 0;
																		gbc_TablePanel.gridy = 3;
																		MainPanel.add(TablePanel, gbc_TablePanel);
																		GridBagLayout gbl_TablePanel = new GridBagLayout();
																		gbl_TablePanel.columnWidths = new int[]{423, 0};
																		gbl_TablePanel.rowHeights = new int[]{15, 15, 0};
																		gbl_TablePanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
																		gbl_TablePanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
																		TablePanel.setLayout(gbl_TablePanel);
																		
																				JPanel panel = new JPanel();
																				GridBagConstraints gbc_panel = new GridBagConstraints();
																				gbc_panel.anchor = GridBagConstraints.NORTH;
																				gbc_panel.fill = GridBagConstraints.HORIZONTAL;
																				gbc_panel.insets = new Insets(0, 0, 5, 0);
																				gbc_panel.gridx = 0;
																				gbc_panel.gridy = 0;
																				TablePanel.add(panel, gbc_panel);
																				panel.setLayout(new GridLayout(0, 2, 0, 0));
																				
																						JLabel lblNewLabel = new JLabel("Código:");
																						panel.add(lblNewLabel);
																						
				JLabel TableProdNome = new JLabel("Nome:");
				panel.add(TableProdNome);
				
				JPanel panel_2 = new JPanel();
				GridBagConstraints gbc_panel_2 = new GridBagConstraints();
				gbc_panel_2.fill = GridBagConstraints.BOTH;
				gbc_panel_2.gridx = 0;
				gbc_panel_2.gridy = 1;
				TablePanel.add(panel_2, gbc_panel_2);
				panel_2.setLayout(new GridLayout(0, 1, 0, 0));
				
						ProdTable = new JTable();
						panel_2.add(ProdTable);
						ProdTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Código", "Nome" }) {
							Class<?>[] columnTypes = new Class[] { String.class, String.class };

							public Class<?> getColumnClass(int columnIndex) {
								return columnTypes[columnIndex];
							}
						});
						
						tableModel = (DefaultTableModel) ProdTable.getModel();


						
				JPanel panel_1 = new JPanel();
				GridBagConstraints gbc_panel_1 = new GridBagConstraints();
				gbc_panel_1.anchor = GridBagConstraints.SOUTH;
				gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
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
		SubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
