package interfaces;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfacesCliente.interfaceClientesConsulta;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JMenuBar;
import java.awt.Choice;
import java.awt.Label;
import javax.swing.JMenuItem;
import javax.swing.JTree;
import javax.swing.JComboBox;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JMenu;
import java.awt.Checkbox;
import java.awt.Canvas;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnModuloVendas = new JButton("Módulo de Vendas");
	
		btnModuloVendas.setBounds(272, 256, 194, 43);
		contentPane.add(btnModuloVendas);
		
		JButton btnMduloClientes = new JButton("Módulo de Clientes");

		btnMduloClientes.setBounds(272, 333, 194, 43);
		contentPane.add(btnMduloClientes);
		
		JButton btnModuloEstoque = new JButton("Módulo de Estoque");
		btnModuloEstoque.setBounds(272, 171, 194, 43);
		contentPane.add(btnModuloEstoque);
		
		JEditorPane dtrpnAdsGesto = new JEditorPane();
		dtrpnAdsGesto.setText("Ads Gestão");
		dtrpnAdsGesto.setBounds(305, 89, 107, 21);
		contentPane.add(dtrpnAdsGesto);
		
		//abre a janela do modulo clientes
		btnMduloClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	interfaceClientesConsulta.clienteConsulta();
              dispose();
         }
         });
		
	}
		
		
    
		
	}
