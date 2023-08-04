package interfaces.interfacesPedidos;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class InterfacePedidosPrincipal extends JFrame {
    private JButton btnConsulta;
    private JButton btnDeletar;

    public static void AbrirInterfacePedidos() {
        EventQueue.invokeLater(new Runnable() {
            @Override
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
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pedidos Principal");
        setBounds(100, 100, 300, 150);
        setResizable(false);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(2, 1, 10, 10));

        btnConsulta = new JButton("Consulta de Pedidos");
        contentPane.add(btnConsulta);

        btnDeletar = new JButton("Deletar Pedido");
        contentPane.add(btnDeletar);

        btnConsulta.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
                InterfacePedidosConsulta.AbrirInterfacePedidosConsulta();
                dispose();
            }
        });

        btnDeletar.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
                InterfacePedidosDeletar.AbrirInterfacePedidosDeletar();
                dispose();
            }
        });
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
			public void run() {
                new InterfacePedidosPrincipal();
            }
        });
    }
}
