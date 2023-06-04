package org.testesDiversos;
import javax.swing.*;

import org.classes.util.HibernateUtilConsultaClientes;
import org.maptabels.models.*;

import java.awt.event.*;

public class InterfaceDb {
	
	
    public static void AbrirConsulta() {
    	
    	
    	HibernateUtilConsultaClientes colunas = new HibernateUtilConsultaClientes();
    	
       JFrame f = new JFrame("Teste consulta");
       JTextField tf = new JTextField();
           
        JTextField qualColuna = new JTextField();
        qualColuna.setBounds(80, 70, 150,20);
      
        
        tf.setBounds(100, 100, 150, 20);
        
        JButton b = new JButton("Clique para consulta");
        b.setBounds(100, 150, 200, 70);
        
         
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
               colunas.setColuna(qualColuna.getText());
            	
                tf.setText(colunas.consultaCliente());
            }
        });
        f.add(b);
        f.add(tf);
        f.add(qualColuna);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
    }
}
