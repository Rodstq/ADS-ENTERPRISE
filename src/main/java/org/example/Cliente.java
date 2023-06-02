 package org.example;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cliente {

    public static void main(String[] args) {
        JFrame f = new JFrame();//instanciando JFrame
        JButton b = new JButton("Adicionar Cliente");

        //adicionando campo de nome do Cliente
        final JTextField nome = new JTextField();
        nome.setBounds(50,50,150,20);
        //adicionando Label do campo do nome do Cliente
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(50,20,150,20);

        //adicionando campo de cpf do cliente
        final JTextField cpf = new JTextField();
        cpf.setBounds(250,50,150,20);
        //adicionando label do campo do cpf do cliente
        JLabel cpfLabel = new JLabel("CPF:");
        cpfLabel.setBounds(250,20,150,20);

        //label mostrando nome adicionado
        JLabel nomeAdicionado = new JLabel();
        nomeAdicionado.setBounds(100, 150, 250,40);
        nomeAdicionado.setLayout(null);

        //label mostrando cpf adicionado
        JLabel cpfAdicionado = new JLabel();
        cpfAdicionado.setBounds(300, 150, 250,40);
        cpfAdicionado.setLayout(null);

        //definindo tamanho e posição do botao b
        b.setBounds(100,200,250,40);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nomeAdicionado.setText(nome.getText());
                cpfAdicionado.setText(cpf.getText());
                double cpfDouble = Double.parseDouble(cpfAdicionado.getText());
            }
        });


        //adicionando o botao b ao JFrame
        f.add(b);
        f.add(nome);
        f.add(cpf);
        f.add(nomeLabel);
        f.add(cpfLabel);
        f.add(nomeAdicionado);
        f.add(cpfAdicionado);


        //definindo tamanho da tela
        f.setSize(500,300);
        f.setLayout(null);
        f.setVisible(true);
    }
}
