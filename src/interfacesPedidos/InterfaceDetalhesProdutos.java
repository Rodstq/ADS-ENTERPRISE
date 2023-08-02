package interfacesPedidos;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import classesPedidos.ProdutoDetalhado;
import java.text.DecimalFormat;
import java.util.List;

public class InterfaceDetalhesProdutos extends JFrame {

    private JTable table;
    private DefaultTableModel model;
    private double totalCompra;

    public static void AbrirInterfaceDetalhes(List<ProdutoDetalhado> detalhesProdutos) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InterfaceDetalhesProdutos frame = new InterfaceDetalhesProdutos(detalhesProdutos);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public InterfaceDetalhesProdutos(List<ProdutoDetalhado> detalhesProdutos) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        setTitle("Detalhes dos Produtos do Pedido");

        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        scrollPane.setViewportView(table);

        model = new DefaultTableModel();
        model.addColumn("ID do Produto");
        model.addColumn("Nome do Produto");
        model.addColumn("Valor do Produto");
        model.addColumn("Quantidade Comprada");
        model.addColumn("Valor Total do Produto");

        totalCompra = 0;
        for (ProdutoDetalhado detalhe : detalhesProdutos) {
            model.addRow(new Object[]{
                    detalhe.getIdProduto(),
                    detalhe.getNomeProduto(),
                    detalhe.getValor(),
                    detalhe.getQuantidadeComprada(),
                    detalhe.getValorTotalProduto()
            });

            totalCompra += detalhe.getValorTotalProduto();
        }

        table.setModel(model);

        // Formatação do valor total da compra para duas casas decimais
        DecimalFormat df = new DecimalFormat("#0.00");
        String totalCompraFormatted = df.format(totalCompra);

        // Adicionando o valor total da compra no final da interface
        JLabel lblTotalCompra = new JLabel("Valor Total da Compra: R$ " + totalCompraFormatted);
        contentPane.add(lblTotalCompra, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
