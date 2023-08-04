package interfaces.interfacesPedidos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import controladores.PedidoProdutoDetalheDb;
import controladores.PedidosConsultaDb;
import models.classesPedidos.PedidosConsulta;
import models.classesPedidos.ProdutoDetalhado;

public class InterfacePedidosConsulta extends JFrame {
    private JPanel contentPane;
    private JTable table;
    private JComboBox<String> comboBoxFiltro;
    private JTextField textFieldFiltro;
    private JButton btnConsultar;
    private JButton btnLimparFiltro;
    private JButton btnVoltar;

	/**
	 * Launch the application.
	 */
    public static void AbrirInterfacePedidosConsulta() {
    	EventQueue.invokeLater(new Runnable() {
            @Override
			public void run() {
				try {
					InterfacePedidosConsulta frame = new InterfacePedidosConsulta();
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
    public InterfacePedidosConsulta() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 827, 431);
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panelNorth = new JPanel();
        contentPane.add(panelNorth, BorderLayout.NORTH);


        JLabel lblFiltro = new JLabel("Filtro:");
        panelNorth.add(lblFiltro);

        comboBoxFiltro = new JComboBox<>();
        comboBoxFiltro.addItem("Nenhum");
        comboBoxFiltro.addItem("CPF do Cliente");
        comboBoxFiltro.addItem("CPF do Vendedor");
        comboBoxFiltro.addItem("ID do Pedido");
        comboBoxFiltro.addItem("Data de Compra");
        panelNorth.add(comboBoxFiltro);

        textFieldFiltro = new JTextField();
        panelNorth.add(textFieldFiltro);
        textFieldFiltro.setColumns(10);

        btnConsultar = new JButton("Consultar");
        panelNorth.add(btnConsultar);

        btnLimparFiltro = new JButton("Limpar Filtro");
        panelNorth.add(btnLimparFiltro);

        btnVoltar = new JButton("Voltar");
        panelNorth.add(btnVoltar);

        JPanel panelCenter = new JPanel(new BorderLayout());
        contentPane.add(panelCenter, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane();
        panelCenter.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        scrollPane.setViewportView(table);



        comboBoxFiltro.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
                String filtroSelecionado = (String) comboBoxFiltro.getSelectedItem();
                if (filtroSelecionado.equals("Nenhum")) {
                    textFieldFiltro.setEnabled(false);
                } else {
                    textFieldFiltro.setEnabled(true);
                }
            }
        });

        if (comboBoxFiltro.getSelectedItem().equals("Nenhum")) {
            textFieldFiltro.setEnabled(false);
        }


        btnConsultar.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
                String filtro = textFieldFiltro.getText();
                String tipoFiltro = (String) comboBoxFiltro.getSelectedItem();

                PedidosConsultaDb pedidoConsultaDb = new PedidosConsultaDb();


                List<PedidosConsulta> resultados = pedidoConsultaDb.consultarPedidos(filtro, tipoFiltro);

                if (resultados.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Não há pedidos com o filtro informado!", "Filtro",
                            JOptionPane.INFORMATION_MESSAGE);
                    return; // sem o return volta vazio
                }


                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("ID do Pedido");
                model.addColumn("Data do Pedido");
                model.addColumn("CPF do Vendedor");
                model.addColumn("CPF do Cliente");
                model.addColumn("Valor total dos Produtos");
                model.addColumn("Quantidade de produtos");
                model.addColumn("Detalhes");

                for (PedidosConsulta pedido : resultados) {
                    model.addRow(new Object[]{
                            pedido.getIdPedido(),
                            pedido.getDataPedido(),
                            pedido.getCpfVendedor(),
                            pedido.getCpfCliente(),
                            pedido.getValorProdutos(),
                            pedido.getQuantitadeTotalProdutos(),
                            "Abrir"
                    });
                }

                table.setModel(model);

            }


        });


        btnLimparFiltro.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
                limparFiltro();
            }
        });



        btnVoltar.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
                InterfacePedidosPrincipal.AbrirInterfacePedidos();
                dispose();
            }
        });

        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                int col = table.columnAtPoint(evt.getPoint());
                if (col == 6) {
                    String idPedido = table.getValueAt(row, 0).toString();
                    abrirInterfaceDetalhesProdutos(idPedido);
                }
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void abrirInterfaceDetalhesProdutos(String idPedido) {
        int idPedidoInt = Integer.parseInt(idPedido);
        PedidoProdutoDetalheDb pedidoProdutoDetalheDb = new PedidoProdutoDetalheDb();
        List<ProdutoDetalhado> detalhes = pedidoProdutoDetalheDb.obterDetalhesPedido(idPedidoInt);
        InterfaceDetalhesProdutos.AbrirInterfaceDetalhes(detalhes);
    }

    private void limparFiltro() {
        textFieldFiltro.setText("");
        comboBoxFiltro.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
			public void run() {
                new InterfacePedidosConsulta();
            }
        });
    }
}
