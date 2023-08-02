package controladores.vendedores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CadastroVendedorFrame extends JFrame {
    private JTextField nomeTextField;
    private JTextField cpfTextField;
    private JTextField dataNascimentoTextField;
    private JTextArea enderecoTextArea;
    private JButton cadastrarButton;

    public CadastroVendedorFrame() {
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

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarVendedor();
            }
        });

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

        // Verifica se todos os campos estão preenchidos
        if (nome.isEmpty() || cpf.isEmpty() || dataNascimentoStr.isEmpty() || endereco.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.");
            return;
        }

        // Converte a data de nascimento para o formato correto
        Date dataNascimento;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dataNascimento = dateFormat.parse(dataNascimentoStr);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Data de Nascimento inválida. Use o formato dd/MM/yyyy.");
            return;
        }

        // Aqui você pode implementar a lógica para cadastrar o vendedor no sistema
        // Por exemplo, pode ser chamada uma função que salva os dados do vendedor em um banco de dados

        JOptionPane.showMessageDialog(this, "Vendedor cadastrado com sucesso!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CadastroVendedorFrame().setVisible(true);
            }
        });
    }
}