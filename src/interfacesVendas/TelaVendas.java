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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import conexaoDb.Db;
import controladores.Pedido.PedidoController;
import controladores.Cliente.ClienteConsultaDatabase;
import data.tratamento.clients.Clientes;

import javax.swing.table.TableModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.SimpleTimeZone;

public class TelaVendas extends JFrame {

    private JPanel contentPane;
    private JTextField NomeProdField;
    private static JTextField CodProdField;
    private JTable ProdTable;
    private DefaultTableModel tableModel;
    private static String cpfSelecionado;
    private JTextField CPFField;
    private JTextField NomeField;
    private JTable ClientesTable;
    ArrayList<Integer> ProdutosComprados = new ArrayList<Integer>();

    public static void setCpfSelecionado(String cpf) {
        cpfSelecionado = cpf;
    }

    public static String getCodProdField() {
        return CodProdField.getText();
    }

    ClienteConsultaDatabase ClienteConsultaDatabase = new ClienteConsultaDatabase();

    /**
     * Launch the application.
     */
    public static void TelaCaixa(String nomeVendedor, String VendedorCPF) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaVendas frame = new TelaVendas(nomeVendedor, VendedorCPF);
                frame.setVisible(true);
            }
        });
    }

    /**
     * Create the frame.
     */
    public TelaVendas(String nomeVendedor, String VendedorCPF) {
        setTitle("Tela de vendas");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Db.CloseDb();
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 796, 858);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel MainPanel = new JPanel();
        contentPane.add(MainPanel);
        GridBagLayout gbl_MainPanel = new GridBagLayout();
        gbl_MainPanel.columnWidths = new int[]{365, 0};
        gbl_MainPanel.rowHeights = new int[]{0, 0, 89, 14, 213, -12, 0, 0};
        gbl_MainPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_MainPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        MainPanel.setLayout(gbl_MainPanel);

        JLabel lblVendas = new JLabel("VENDAS");
        lblVendas.setForeground(new Color(102, 102, 102));
        lblVendas.setFont(new Font("Dialog", Font.BOLD, 24));
        GridBagConstraints gbc_lblVendas = new GridBagConstraints();
        gbc_lblVendas.insets = new Insets(0, 0, 5, 0);
        gbc_lblVendas.gridx = 0;
        gbc_lblVendas.gridy = 0;
        MainPanel.add(lblVendas, gbc_lblVendas);

        JLabel lblOlFulano = new JLabel("Olá, " + nomeVendedor + "!");
        GridBagConstraints gbc_lblOlFulano = new GridBagConstraints();
        gbc_lblOlFulano.insets = new Insets(0, 0, 5, 0);
        gbc_lblOlFulano.gridx = 0;
        gbc_lblOlFulano.gridy = 1;
        MainPanel.add(lblOlFulano, gbc_lblOlFulano);

        JPanel FormPanel = new JPanel();
        GridBagConstraints gbc_FormPanel = new GridBagConstraints();
        gbc_FormPanel.insets = new Insets(0, 0, 5, 0);
        gbc_FormPanel.anchor = GridBagConstraints.NORTH;
        gbc_FormPanel.fill = GridBagConstraints.HORIZONTAL;
        gbc_FormPanel.gridx = 0;
        gbc_FormPanel.gridy = 2;
        MainPanel.add(FormPanel, gbc_FormPanel);
        GridBagLayout gbl_FormPanel = new GridBagLayout();
        gbl_FormPanel.columnWidths = new int[]{137, 132, 70, 0};
        gbl_FormPanel.rowHeights = new int[]{19, 0, 0, 0};
        gbl_FormPanel.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
        gbl_FormPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
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
                Db.Connect();
                int codProd = 0;
                String nomeProd = "";
                if (!CodProdField.getText().isEmpty()) {

                    codProd = Integer.parseInt(CodProdField.getText());
                    nomeProd = NomeProdField.getText();

                    String query = "SELECT * FROM produto WHERE id_produto = ?";
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
                            tableModel.addRow(new Object[]{codProd, nomeProd});
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
                } else if (!NomeProdField.getText().isEmpty()) {
                    String query = "SELECT * FROM produto WHERE nome_produto = ?";
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
                            tableModel.addRow(new Object[]{codProd, nomeProd});
                            System.out.println("Nome do produto encontrado: " + nomeProduto);
                        } else {
                            // Item não encontrado
                            String nomeProduto = rs.getString("nome_produto");
                            nomeProd = nomeProduto;
                            System.out.println(
                                    "Item não encontrado na tabela Produtos com o nome_produto: " + nomeProduto);
                            AddError.main(null);
                        }

                        rs.close();
                        stmt.close();

                    } catch (SQLException ex) {
                        throw new RuntimeException("Erro ao executar a consulta: " + ex.getMessage(), ex);
                    }
                }
                Db.CloseDb();
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
        gbc_separator.gridy = 3;
        MainPanel.add(separator, gbc_separator);

        JPanel TablePanel = new JPanel();
        GridBagConstraints gbc_TablePanel = new GridBagConstraints();
        gbc_TablePanel.anchor = GridBagConstraints.NORTH;
        gbc_TablePanel.insets = new Insets(0, 0, 5, 0);
        gbc_TablePanel.fill = GridBagConstraints.HORIZONTAL;
        gbc_TablePanel.gridx = 0;
        gbc_TablePanel.gridy = 4;
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
        ProdTable.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"Código", "Nome"}) {
            Class<?>[] columnTypes = new Class[]{String.class, String.class};

            public Class<?> getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });

        tableModel = (DefaultTableModel) ProdTable.getModel();


        JPanel panel_1 = new JPanel();
        GridBagConstraints gbc_panel_1 = new GridBagConstraints();
        gbc_panel_1.insets = new Insets(0, 0, 5, 0);
        gbc_panel_1.anchor = GridBagConstraints.SOUTHEAST;
        gbc_panel_1.gridx = 0;
        gbc_panel_1.gridy = 5;
        MainPanel.add(panel_1, gbc_panel_1);

        JButton FecharCompraButton = new JButton("Fechar Compra");
        panel_1.add(FecharCompraButton);

        JButton RemoveButton = new JButton("Remover");
        RemoveButton.setEnabled(false);
        RemoveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = ProdTable.getSelectedRow();
                if (selectedRow != -1) {
                    tableModel.removeRow(selectedRow);
                    RemoveButton.setEnabled(false);
                }
            }
        });
        panel_1.add(RemoveButton);

        JPanel LinkCpfPanel = new JPanel();
        LinkCpfPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        GridBagConstraints gbc_LinkCpfPanel = new GridBagConstraints();
        gbc_LinkCpfPanel.fill = GridBagConstraints.BOTH;
        gbc_LinkCpfPanel.gridx = 0;
        gbc_LinkCpfPanel.gridy = 6;
        MainPanel.add(LinkCpfPanel, gbc_LinkCpfPanel);
        GridBagLayout gbl_LinkCpfPanel = new GridBagLayout();
        gbl_LinkCpfPanel.columnWidths = new int[]{566, 0};
        gbl_LinkCpfPanel.rowHeights = new int[]{73, 275, 0, 0};
        gbl_LinkCpfPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_LinkCpfPanel.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
        LinkCpfPanel.setLayout(gbl_LinkCpfPanel);

        JPanel FormPanel_1 = new JPanel();
        GridBagConstraints gbc_FormPanel_1 = new GridBagConstraints();
        gbc_FormPanel_1.anchor = GridBagConstraints.NORTHWEST;
        gbc_FormPanel_1.insets = new Insets(0, 0, 5, 0);
        gbc_FormPanel_1.gridx = 0;
        gbc_FormPanel_1.gridy = 0;
        LinkCpfPanel.add(FormPanel_1, gbc_FormPanel_1);
        GridBagLayout gbl_FormPanel_1 = new GridBagLayout();
        gbl_FormPanel_1.columnWidths = new int[]{0, 0, 0};
        gbl_FormPanel_1.rowHeights = new int[]{0, 0, 0, 0};
        gbl_FormPanel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        gbl_FormPanel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        FormPanel_1.setLayout(gbl_FormPanel_1);

        JLabel lblNewLabel_1 = new JLabel("CPF do cliente:");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 0;
        FormPanel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);

        CPFField = new JTextField();


        CPFField.setColumns(10);
        GridBagConstraints gbc_CPFField = new GridBagConstraints();
        gbc_CPFField.fill = GridBagConstraints.HORIZONTAL;
        gbc_CPFField.insets = new Insets(0, 0, 5, 0);
        gbc_CPFField.gridx = 1;
        gbc_CPFField.gridy = 0;
        FormPanel_1.add(CPFField, gbc_CPFField);

        JLabel lblNewLabel_1_1 = new JLabel("Nome do cliente: ");
        GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
        gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1_1.gridx = 0;
        gbc_lblNewLabel_1_1.gridy = 1;
        FormPanel_1.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);

        NomeField = new JTextField();

        NomeField.setColumns(10);
        GridBagConstraints gbc_NomeField = new GridBagConstraints();
        gbc_NomeField.fill = GridBagConstraints.HORIZONTAL;
        gbc_NomeField.insets = new Insets(0, 0, 5, 0);
        gbc_NomeField.gridx = 1;
        gbc_NomeField.gridy = 1;
        FormPanel_1.add(NomeField, gbc_NomeField);

        JButton SearchButton = new JButton("Pesquisar");

        SearchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = NomeField.getText();
                String cpf = CPFField.getText();

                if (!cpf.isEmpty()) {
                    Clientes cliente = new Clientes();
                    cliente.setCpf(cpf);

                    List<Object[]> resultados = ClienteConsultaDatabase.infoClienteCpf(cliente);
                    // Limpa os dados atuais da tabela
                    DefaultTableModel clientesTableModel = (DefaultTableModel) ClientesTable.getModel();
                    clientesTableModel.setRowCount(0);
                    // Preenche a tabela com os dados retornados do banco de dados
                    for (Object[] clienteDados : resultados) {
                        // Adiciona somente o CPF e o nome na tabela
                        clientesTableModel.addRow(new Object[]{clienteDados[1], clienteDados[0]});
                    }
                } else if (!nome.isEmpty()) {
                    Clientes cliente = new Clientes();
                    cliente.setNomeCliente(nome);

                    List<Object[]> resultados = ClienteConsultaDatabase.infoCliente(cliente);
                    // Limpa os dados atuais da tabela
                    DefaultTableModel clientesTableModel = (DefaultTableModel) ClientesTable.getModel();
                    clientesTableModel.setRowCount(0);
                    // Preenche a tabela com os dados retornados do banco de dados
                    for (Object[] clienteDados : resultados) {
                        // Adiciona somente o CPF e o nome na tabela
                        clientesTableModel.addRow(new Object[]{clienteDados[1], clienteDados[0]});
                    }
                }
            }
        });


        GridBagConstraints gbc_SearchButton = new GridBagConstraints();
        gbc_SearchButton.insets = new Insets(0, 0, 0, 5);
        gbc_SearchButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_SearchButton.gridx = 1;
        gbc_SearchButton.gridy = 2;
        FormPanel_1.add(SearchButton, gbc_SearchButton);

        JPanel Tabblepanel = new JPanel();
        GridBagConstraints gbc_Tabblepanel = new GridBagConstraints();
        gbc_Tabblepanel.fill = GridBagConstraints.BOTH;
        gbc_Tabblepanel.insets = new Insets(0, 0, 5, 0);
        gbc_Tabblepanel.gridx = 0;
        gbc_Tabblepanel.gridy = 1;
        LinkCpfPanel.add(Tabblepanel, gbc_Tabblepanel);
        GridBagLayout gbl_Tabblepanel = new GridBagLayout();
        gbl_Tabblepanel.columnWidths = new int[]{570, 570, 0};
        gbl_Tabblepanel.rowHeights = new int[]{15, 0, 0};
        gbl_Tabblepanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
        gbl_Tabblepanel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        Tabblepanel.setLayout(gbl_Tabblepanel);

        JPanel LabelTablepanel = new JPanel();
        GridBagConstraints gbc_LabelTablepanel = new GridBagConstraints();
        gbc_LabelTablepanel.anchor = GridBagConstraints.NORTHWEST;
        gbc_LabelTablepanel.gridwidth = 2;
        gbc_LabelTablepanel.insets = new Insets(0, 0, 5, 0);
        gbc_LabelTablepanel.gridx = 0;
        gbc_LabelTablepanel.gridy = 0;
        Tabblepanel.add(LabelTablepanel, gbc_LabelTablepanel);
        GridBagLayout gbl_LabelTablepanel = new GridBagLayout();
        gbl_LabelTablepanel.columnWidths = new int[]{402, 378, 0};
        gbl_LabelTablepanel.rowHeights = new int[]{0, 0};
        gbl_LabelTablepanel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
        gbl_LabelTablepanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        LabelTablepanel.setLayout(gbl_LabelTablepanel);

        JLabel Nomelbl = new JLabel("Nome:");
        GridBagConstraints gbc_Nomelbl = new GridBagConstraints();
        gbc_Nomelbl.anchor = GridBagConstraints.WEST;
        gbc_Nomelbl.insets = new Insets(0, 0, 0, 5);
        gbc_Nomelbl.gridx = 0;
        gbc_Nomelbl.gridy = 0;
        LabelTablepanel.add(Nomelbl, gbc_Nomelbl);

        JLabel lblCpf = new JLabel("CPF:");
        GridBagConstraints gbc_lblCpf = new GridBagConstraints();
        gbc_lblCpf.anchor = GridBagConstraints.WEST;
        gbc_lblCpf.gridx = 1;
        gbc_lblCpf.gridy = 0;
        LabelTablepanel.add(lblCpf, gbc_lblCpf);

        JPanel ClientesTablePanel = new JPanel();
        GridBagConstraints gbc_ClientesTablePanel = new GridBagConstraints();
        gbc_ClientesTablePanel.insets = new Insets(0, 0, 0, 5);
        gbc_ClientesTablePanel.fill = GridBagConstraints.VERTICAL;
        gbc_ClientesTablePanel.anchor = GridBagConstraints.WEST;
        gbc_ClientesTablePanel.gridwidth = 2;
        gbc_ClientesTablePanel.gridx = 0;
        gbc_ClientesTablePanel.gridy = 1;
        Tabblepanel.add(ClientesTablePanel, gbc_ClientesTablePanel);
        GridBagLayout gbl_ClientesTablePanel = new GridBagLayout();
        gbl_ClientesTablePanel.columnWidths = new int[]{774, 0};
        gbl_ClientesTablePanel.rowHeights = new int[]{1, 0};
        gbl_ClientesTablePanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_ClientesTablePanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        ClientesTablePanel.setLayout(gbl_ClientesTablePanel);

        ClientesTable = new JTable(new DefaultTableModel(new Object[][]{}, new String[]{"Nome", "CPF"}));
        GridBagConstraints gbc_ClientesTable = new GridBagConstraints();
        gbc_ClientesTable.fill = GridBagConstraints.HORIZONTAL;
        gbc_ClientesTable.anchor = GridBagConstraints.NORTH;
        gbc_ClientesTable.gridx = 0;
        gbc_ClientesTable.gridy = 0;
        ClientesTablePanel.add(ClientesTable, gbc_ClientesTable);

        JPanel SubmitPannel = new JPanel();
        GridBagConstraints gbc_SubmitPannel = new GridBagConstraints();
        gbc_SubmitPannel.anchor = GridBagConstraints.EAST;
        gbc_SubmitPannel.gridx = 0;
        gbc_SubmitPannel.gridy = 2;
        LinkCpfPanel.add(SubmitPannel, gbc_SubmitPannel);

        JButton SubmitButton = new JButton("Finalizar");
        SubmitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Db.Connect();
                try {
                    System.out.println(ProdutosComprados + cpfSelecionado + VendedorCPF);
                    PedidoController.criarPedido(ProdutosComprados, cpfSelecionado, VendedorCPF);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                Db.CloseDb();
            }
        });

        SubmitPannel.add(SubmitButton);

        ClientesTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                int selectedRow = ClientesTable.getSelectedRow();
                if (selectedRow != -1) {
                    cpfSelecionado = (String) ClientesTable.getValueAt(selectedRow, 0);
                }
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

        CPFField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (NomeField.getText().isEmpty()) {
                    NomeField.setEnabled(false);
                }
            }
        });
        CPFField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (NomeField.getText().isEmpty()) {
                    CPFField.setEnabled(true);
                }
            }
        });

        NomeField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (CPFField.getText().isEmpty()) {
                    CPFField.setEnabled(false);
                }
            }
        });

        NomeField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (CPFField.getText().isEmpty()) {
                    NomeField.setEnabled(true);
                }
            }
        });

        FecharCompraButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int rowCount = tableModel.getRowCount();
                for (int i = 0; i < rowCount; i++) {
                    int idProduto = (int) tableModel.getValueAt(i, 0);
                    ProdutosComprados.add(idProduto);
                }
                //tableModel.setRowCount(0);
                FecharCompraButton.setEnabled(false);
            }
        });
    }
}
