package controladores.vendedores;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import conexaoDb.Db;
import conexaoDb.DbErrorException;

public class VendedoresCadastroDatabase extends JFrame {
    private JTextField nomeTextField;
    private JTextField cpfTextField;
    private JTextField dataNascimentoTextField;
    private JTextArea enderecoTextArea;
    private JButton cadastrarButton;

    public VendedoresCadastroDatabase() {
        setTitle("Cadastro de Vendedor");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        JLabel nomeLabel = new JLabel("Nome:");
        JLabel cpfLabel = new JLabel("CPF:");
        JLabel dataNascimentoLabel = new JLabel("Data de Nascimento (dd/MM/yyyy):");
        JLabel enderecoLabel = new JLabel("Endereço:");
        nomeTextField = new JTextField(20);
        cpfTextField = new JTextField(15);
        dataNascimentoTextField = new JTextField(10);
        enderecoTextArea = new JTextArea(4, 20);
        cadastrarButton = new JButton("Cadastrar");

        cadastrarButton.addActionListener(e -> cadastrarVendedor());

        mainPanel.add(nomeLabel);
        mainPanel.add(nomeTextField);
        mainPanel.add(cpfLabel);
        mainPanel.add(cpfTextField);
        mainPanel.add(dataNascimentoLabel);
        mainPanel.add(dataNascimentoTextField);
        mainPanel.add(enderecoLabel);
        mainPanel.add(new JScrollPane(enderecoTextArea));
        mainPanel.add(cadastrarButton);

        add(mainPanel);
    }

    private void cadastrarVendedor() {
        String nome = nomeTextField.getText();
        String cpf = cpfTextField.getText();
        String dataNascimentoStr = dataNascimentoTextField.getText();
        String endereco = enderecoTextArea.getText();

        if (nome.isEmpty() || cpf.isEmpty() || dataNascimentoStr.isEmpty() || endereco.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.");
            return;
        }

        Date dataNascimento;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dataNascimento = dateFormat.parse(dataNascimentoStr);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Data de Nascimento inválida. Use o formato dd/MM/yyyy.");
            return;
        }

        try {
            Connection connection = Db.Connect();

            String sql = "INSERT INTO vendedor (cpf_vendedor, nome_vendedor, data_nascimento) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cpf);
            preparedStatement.setString(2, nome);
            preparedStatement.setDate(3, new java.sql.Date(dataNascimento.getTime()));

            preparedStatement.executeUpdate();

            Db.CloseDb();

            JOptionPane.showMessageDialog(this, "Vendedor cadastrado com sucesso!");
        } catch (DbErrorException e) {
            JOptionPane.showMessageDialog(this, "Erro ao finalizar conexão: " + e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar vendedor no banco de dados: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VendedoresCadastroDatabase().setVisible(true));
    }
}
