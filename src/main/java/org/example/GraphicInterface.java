package org.example;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicInterface {

    public static void main(String[] args) {
        JFrame f = new JFrame();//instanciando JFrame
        JButton b = new JButton("Adicionar Cliente");

        final JTextField nome = new JTextField();
        nome.setBounds(50,50,150,20);
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(50,20,150,20);

        final JTextField cpf = new JTextField();
        cpf.setBounds(250,50,150,20);
        JLabel cpfLabel = new JLabel("CPF:");
        cpfLabel.setBounds(250,20,150,20);

        //definindo tamanho e posição do botao b
        b.setBounds(100,200,250,40);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nome.setText("Cliente adicionado!!");
            }
        });

        //adicionando o botao b ao JFrame
        f.add(b);
        f.add(nome);
        f.add(cpf);
        f.add(nomeLabel);
        f.add(cpfLabel);


        //definindo tamanho da tela
        f.setSize(500,300);
        f.setLayout(null);
        f.setVisible(true);
    }
}
