package interfacesPedidos;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import classesPedidos.PedidosConsulta;
import controladores.PedidosConsultaDb;
import java.util.List;

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 827, 431);
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panelNorth = new JPanel();
        contentPane.add(panelNorth, BorderLayout.NORTH);
        

        JLabel lblFiltro = new JLabel("Filtro:");
        panelNorth.add(lblFiltro);

        comboBoxFiltro = new JComboBox<String>();
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

                for (PedidosConsulta pedido : resultados) {
                    model.addRow(new Object[]{
                            pedido.getIdPedido(),
                            pedido.getDataPedido(),
                            pedido.getCpfVendedor(),
                            pedido.getCpfCliente(),
                            pedido.getValorProdutos(),
                            pedido.getQuantitadeTotalProdutos()
                    });
                }

                table.setModel(model);
                
            }
            
            
        });


        btnLimparFiltro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limparFiltro();
            }
        });
        


        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InterfacePedidosPrincipal.AbrirInterfacePedidos();
                dispose();
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }


    private void limparFiltro() {
        textFieldFiltro.setText("");
        comboBoxFiltro.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InterfacePedidosConsulta();
            }
        });
    }
}
