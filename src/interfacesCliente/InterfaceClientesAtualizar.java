package interfacesCliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class InterfaceClientesAtualizar extends InterfaceClientesPrincipal {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void clientesAtualizar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceClientesAtualizar frame = new InterfaceClientesAtualizar();
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
	public InterfaceClientesAtualizar() {

		
		
	}

}
