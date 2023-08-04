package interfaces.interfacesPedidos;

import interfaces.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfacePedidosPrincipal extends JFrame {
    private JButton btnConsulta;
    private JButton btnDeletar;
    private JButton BackButton;

    public static void AbrirInterfacePedidos() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InterfacePedidosPrincipal frame = new InterfacePedidosPrincipal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public InterfacePedidosPrincipal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Pedidos Principal");
        setBounds(100, 100, 422, 230);
        setResizable(false);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{365, 0};
        gbl_contentPane.rowHeights = new int[]{59, 59, 59, 0};
        gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);
                
                        btnConsulta = new JButton("Consulta de Pedidos");
                        GridBagConstraints gbc_btnConsulta = new GridBagConstraints();
                        gbc_btnConsulta.fill = GridBagConstraints.BOTH;
                        gbc_btnConsulta.insets = new Insets(0, 0, 5, 0);
                        gbc_btnConsulta.gridx = 0;
                        gbc_btnConsulta.gridy = 0;
                        contentPane.add(btnConsulta, gbc_btnConsulta);
                        
                                btnConsulta.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        InterfacePedidosConsulta.AbrirInterfacePedidosConsulta();
                                        dispose();
                                    }
                                });
        
                btnDeletar = new JButton("Deletar Pedido");
                GridBagConstraints gbc_btnDeletar = new GridBagConstraints();
                gbc_btnDeletar.fill = GridBagConstraints.BOTH;
                gbc_btnDeletar.insets = new Insets(0, 0, 5, 0);
                gbc_btnDeletar.gridx = 0;
                gbc_btnDeletar.gridy = 1;
                contentPane.add(btnDeletar, gbc_btnDeletar);
                
                        btnDeletar.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                InterfacePedidosDeletar.AbrirInterfacePedidosDeletar();
                                dispose();
                            }
                        });
        
        BackButton = new JButton("Voltar");
        BackButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Main frame = new Main();
                frame.setVisible(true);
                dispose();
        	}
        });
        GridBagConstraints gbc_BackButton = new GridBagConstraints();
        gbc_BackButton.gridheight = 2;
        gbc_BackButton.fill = GridBagConstraints.BOTH;
        gbc_BackButton.gridx = 0;
        gbc_BackButton.gridy = 2;
        contentPane.add(BackButton, gbc_BackButton);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InterfacePedidosPrincipal();
            }
        });
    }
}