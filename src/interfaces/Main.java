package interfaces;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import guiCliente.GuiClientesPrincipal;
import interfacesProdutos.InterfaceProdutosPrincipal;
import interfacesVendas.TelaVendas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Main extends JFrame {

	private JPanel contentPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login.telaLogin();
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
		btnModuloVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaVendas.TelaCaixa(Login.getVendedor(), Login.getCPFVendedor());
			}
		});
	
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
	    
	    

        
		btnMduloClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	GuiClientesPrincipal.clientePrincipal();
              dispose();
         }
         });
		
	}
					
	}
