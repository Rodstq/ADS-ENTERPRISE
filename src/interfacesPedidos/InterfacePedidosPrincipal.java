package interfacesPedidos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class InterfacePedidosPrincipal extends JFrame {
    private JButton btnConsulta;
    private JButton btnDeletar;
    
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
        setBounds(100, 100, 831, 414);
        setTitle("Pedidos Principal");

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new FlowLayout());
        setContentPane(contentPane);

        btnConsulta = new JButton("Consulta de Pedidos");
        btnConsulta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InterfacePedidosConsulta.AbrirInterfacePedidosConsulta();
                dispose();
            }
        });
        contentPane.add(btnConsulta);

        btnDeletar = new JButton("Deletar Pedido");
        btnDeletar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	InterfacePedidosDeletar.AbrirInterfacePedidosDeletar();
            	dispose();
            }
        });
        contentPane.add(btnDeletar);
    }

    
}



