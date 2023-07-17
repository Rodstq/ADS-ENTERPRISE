package interfacesCliente;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class InterfaceClientesPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void clientePrincipal() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceClientesPrincipal frame = new InterfaceClientesPrincipal();
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
	public InterfaceClientesPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 962, 530);
		

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnConsultarClientes = new JButton("Consultar Clientes");
		menuBar.add(btnConsultarClientes);
		btnConsultarClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	InterfaceClientesConsulta.clienteConsulta();
              dispose();
         }
         });
		
		JButton btnCadastrarClientes = new JButton("Cadastrar Clientes");
		menuBar.add(btnCadastrarClientes);
		btnCadastrarClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	InterfaceClientesCadastro.clientesCadastro();
              dispose();
         }
         });
		
		JButton btnDeletarClientes = new JButton("Deletar Clientes");
		menuBar.add(btnDeletarClientes);
		btnDeletarClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	InterfaceClientesDelete.clienteDelete();
              dispose();
         }
         });
		
		JButton btnAtualizarClientes = new JButton("Atualizar Clientes");
		menuBar.add(btnAtualizarClientes);
		btnAtualizarClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	InterfaceClientesAtualizar.clientesAtualizar();
              dispose();
         }
         });
		
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);
	    contentPane.setLayout(null);

        JLabel opaqueLabel = new JLabel("AdsGestão");
        opaqueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        opaqueLabel.setFont(new Font("Dialog", Font.BOLD, 80));
        opaqueLabel.setBounds(215, 40, 490, 341);
        opaqueLabel.setOpaque(true);
        opaqueLabel.setBackground(new Color(0, 0, 0, 0)); 
        opaqueLabel.setForeground(new Color(0, 0, 0, 50));
        contentPane.add(opaqueLabel);
	    
	    
	    
	}

}