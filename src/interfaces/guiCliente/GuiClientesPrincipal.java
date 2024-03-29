package interfaces.guiCliente;

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
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import interfaces.Main;

public class GuiClientesPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void clientePrincipal() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					GuiClientesPrincipal frame = new GuiClientesPrincipal();
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
	public GuiClientesPrincipal() {
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 962, 530);


		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JButton btnConsultarClientes = new JButton("Consultar Clientes");
		menuBar.add(btnConsultarClientes);
		btnConsultarClientes.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {

            	GuiClientesConsulta.clienteConsulta();
              dispose();
         }
         });

		JButton btnCadastrarClientes = new JButton("Cadastrar Clientes");
		menuBar.add(btnCadastrarClientes);
		btnCadastrarClientes.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {

            	GuiClientesCadastro.clientesCadastro();
              dispose();
         }
         });

		JButton btnDeletarClientes = new JButton("Deletar Clientes");
		menuBar.add(btnDeletarClientes);
		btnDeletarClientes.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {

            	GuiClientesDelete.clienteDelete();
              dispose();
         }
         });

		JButton btnAtualizarClientes = new JButton("Atualizar Clientes");
		menuBar.add(btnAtualizarClientes);
		btnAtualizarClientes.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {

            	GuiClientesAtualizar.clientesAtualizar();
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

		JButton btnMenuPrincial = new JButton("menu principal");
		btnMenuPrincial.setBounds(27, 425, 154, 25);
		contentPane.add(btnMenuPrincial);
		btnMenuPrincial.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main frame = new Main();
                frame.setVisible(true);
				dispose();

			}
		});


	}

}