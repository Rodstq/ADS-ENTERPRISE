package org.example;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Produtos {
    // criando tela produtos

    public static void main(String[] args) {
        // criando tela produto
        JFrame produto = new JFrame();
        produto.setSize(400,300);


        // criando campo nome do produto e seu label
        JTextField nomeProduto = new JTextField();
        nomeProduto.setBounds(30,50,100,20);
        JLabel nomeProdutoLabel = new JLabel("Produto :");
        nomeProdutoLabel.setBounds(30,30,100,20);
        // criando campo valor do produto e seu label
        JTextField valorProdutoText = new JTextField();
        valorProdutoText.setBounds(150,50,100,20);
        JLabel valorProdutoTextLabel = new JLabel("Valor :");
        valorProdutoTextLabel.setBounds(150,30,100,20);
        // criando campo código do produto
        JTextField codigoProduto = new JTextField();
        codigoProduto.setBounds(270,50,100,20);
        JLabel codigoProdutoLabel = new JLabel("Codigo  ");
        codigoProdutoLabel.setBounds(270,30,100,20);
        // criando botao adicionar produtos
        JButton adicionarProduto = new JButton("Adicionar Produto");
        adicionarProduto.setBounds(100,130,200,35);
        //criando label para mostrar os dados do produto
        JLabel dadosProdutoAdicionado = new JLabel();
        dadosProdutoAdicionado.setBounds(20,100,400,35);
        adicionarProduto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //criando variavel double com valor do produto inserido
                double valorProduto = Double.parseDouble(valorProdutoText.getText());
                dadosProdutoAdicionado.setText("O produto é :" + nomeProduto.getText() + ", valor:" + valorProduto + ", código:" + codigoProduto.getText());
            }
        });

        //adicionando todos os elementos na tela
        produto.add(nomeProduto);
        produto.add(valorProdutoText);
        produto.add(codigoProduto);
        produto.add(adicionarProduto);
        produto.add(nomeProdutoLabel);
        produto.add(valorProdutoTextLabel);
        produto.add(codigoProdutoLabel);
        produto.add(dadosProdutoAdicionado);

        produto.setLayout(null);
        produto.setVisible(true);
    }
}
