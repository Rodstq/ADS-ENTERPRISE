package interfacesPedidos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class InterfacePedidosConsulta extends JFrame {
    private JPanel contentPane;
    private JTable table;
    private JComboBox<String> comboBoxFiltro;
    private JTextField textFieldFiltro;
    private JButton btnConsultar;
    private JButton btnLimparFiltro;
    
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

        JPanel panelCenter = new JPanel(new BorderLayout());
        contentPane.add(panelCenter, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane();
        panelCenter.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        scrollPane.setViewportView(table);

        btnConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              //  consultarPedidos();
            }
        });

        btnLimparFiltro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limparFiltro();
            }
        });

        setVisible(true);
    }


    private void limparFiltro() {
        textFieldFiltro.setText("");
        comboBoxFiltro.setSelectedIndex(0);
       // consultarPedidos();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InterfacePedidosConsulta();
            }
        });
    }
}
