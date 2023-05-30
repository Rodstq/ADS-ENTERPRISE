package org.example;
import org.example.util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        HibernateUtil.persistirProduto("Produto 2", 58.45, 3);

    }
}