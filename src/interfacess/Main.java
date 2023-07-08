package interfacess;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import interfacesCliente.InterfaceClientesConsulta;
import interfacesCliente.InterfaceClientesPrincipal;
import interfacesProdutos.InterfaceProdutosPrincipal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Label;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Checkbox;
import java.awt.Canvas;

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
		
		//Ao clicar no botao de estoque, abre a GUI dos produtos
		
		btnModuloEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceProdutosPrincipal.ProdutosPrincipal();
				dispose();
			}
		});
		contentPane.add(btnModuloEstoque);
		
        JLabel opaqueLabel = new JLabel("AdsGestão");
        opaqueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        opaqueLabel.setFont(new Font("Dialog", Font.BOLD, 80));
        opaqueLabel.setBounds(116, 14, 490, 162);
        opaqueLabel.setOpaque(true);
        opaqueLabel.setBackground(new Color(0, 0, 0, 0)); 
        opaqueLabel.setForeground(new Color(0, 0, 0, 50));
        contentPane.add(opaqueLabel);
	    
	    
		//abre a janela do modulo clientes
		btnMduloClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	InterfaceClientesPrincipal.clientePrincipal();
              dispose();
         }
         });
		
	}
		
			
	}
