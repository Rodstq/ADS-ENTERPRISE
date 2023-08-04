package interfaces;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import conexaoDb.Db;

public class Login extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField CPFfield;
    private JTextField PasswordField;
    private JLabel UserLabel;
    private static String Vendedor;
    private static String CPFVendedor;

    public static String getVendedor() {
        return Vendedor;
    }

    public static String getCPFVendedor() {
        return CPFVendedor;
    }

    /**
     * Launch the application.
     */
    public static void telaLogin() {
        try {
            Login dialog = new Login();
            dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean autenticarVendedor(String nome, String cpf) {
        String query = "SELECT COUNT(*) FROM vendedor WHERE nome_vendedor = ? AND cpf_vendedor = ?";
        Db.Connect();
        try (Connection con = Db.getCon();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            Vendedor = nome;
            CPFVendedor = cpf;
            ResultSet rs = stmt.executeQuery();
            rs.next();
            int rowCount = rs.getInt(1);
            return rowCount > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            Db.CloseDb();
        }
    }


    /**
     * Create the dialog.
     */
    public Login() {
    	setResizable(false);
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        {
            JPanel panel = new JPanel();
            getContentPane().add(panel, BorderLayout.NORTH);
            GridBagLayout gbl_panel = new GridBagLayout();
            gbl_panel.columnWidths = new int[]{444, 0};
            gbl_panel.rowHeights = new int[]{36, 117, 29, 0};
            gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
            gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
            panel.setLayout(gbl_panel);
            {
                JPanel panel_1 = new JPanel();
                GridBagConstraints gbc_panel_1 = new GridBagConstraints();
                gbc_panel_1.insets = new Insets(0, 0, 5, 0);
                gbc_panel_1.fill = GridBagConstraints.BOTH;
                gbc_panel_1.gridx = 0;
                gbc_panel_1.gridy = 0;
                panel.add(panel_1, gbc_panel_1);
                {
                    JLabel Title = new JLabel("Ads Enterprise");
                    Title.setFont(new Font("Dialog", Font.BOLD, 21));
                    panel_1.add(Title);
                }
            }
            GridBagConstraints gbc_contentPanel = new GridBagConstraints();
            gbc_contentPanel.insets = new Insets(0, 0, 5, 0);
            gbc_contentPanel.gridx = 0;
            gbc_contentPanel.gridy = 1;
            panel.add(contentPanel, gbc_contentPanel);
            contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
            GridBagLayout gbl_contentPanel = new GridBagLayout();
            gbl_contentPanel.columnWidths = new int[]{31, 114, 0};
            gbl_contentPanel.rowHeights = new int[]{0, 19, 0};
            gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
            gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
            contentPanel.setLayout(gbl_contentPanel);
            {
                UserLabel = new JLabel("Usuário");
                GridBagConstraints gbc_UserLabel = new GridBagConstraints();
                gbc_UserLabel.anchor = GridBagConstraints.WEST;
                gbc_UserLabel.insets = new Insets(0, 0, 5, 5);
                gbc_UserLabel.gridx = 0;
                gbc_UserLabel.gridy = 0;
                contentPanel.add(UserLabel, gbc_UserLabel);
            }
            {
                CPFfield = new JTextField();
                GridBagConstraints gbc_CPFfield = new GridBagConstraints();
                gbc_CPFfield.anchor = GridBagConstraints.NORTHWEST;
                gbc_CPFfield.insets = new Insets(0, 0, 5, 0);
                gbc_CPFfield.gridx = 1;
                gbc_CPFfield.gridy = 0;
                contentPanel.add(CPFfield, gbc_CPFfield);
                CPFfield.setColumns(10);
            }
            {
                JLabel Nome = new JLabel("Senha");
                GridBagConstraints gbc_Nome = new GridBagConstraints();
                gbc_Nome.insets = new Insets(0, 0, 0, 5);
                gbc_Nome.anchor = GridBagConstraints.WEST;
                gbc_Nome.gridx = 0;
                gbc_Nome.gridy = 1;
                contentPanel.add(Nome, gbc_Nome);
            }
            {
                PasswordField = new JTextField();
                GridBagConstraints gbc_PasswordField = new GridBagConstraints();
                gbc_PasswordField.fill = GridBagConstraints.HORIZONTAL;
                gbc_PasswordField.gridx = 1;
                gbc_PasswordField.gridy = 1;
                contentPanel.add(PasswordField, gbc_PasswordField);
                PasswordField.setColumns(10);
            }
            {
                JPanel buttonPane = new JPanel();
                GridBagConstraints gbc_buttonPane = new GridBagConstraints();
                gbc_buttonPane.anchor = GridBagConstraints.NORTHWEST;
                gbc_buttonPane.gridx = 0;
                gbc_buttonPane.gridy = 2;
                panel.add(buttonPane, gbc_buttonPane);
                GridBagLayout gbl_buttonPane = new GridBagLayout();
                gbl_buttonPane.columnWidths = new int[]{240, 231, 0};
                gbl_buttonPane.rowHeights = new int[]{25, 0};
                gbl_buttonPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
                gbl_buttonPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
                buttonPane.setLayout(gbl_buttonPane);
                {
                    JButton okButton = new JButton("Entrar");
                    okButton.addActionListener(new ActionListener() {
                        @Override
						public void actionPerformed(ActionEvent e) {
                            String cpf = CPFfield.getText();
                            String senha = PasswordField.getText();

                            if (autenticarVendedor(cpf, senha)) {
                                Main frame = new Main();
                                frame.setVisible(true);
                                dispose();
                            } else {
                                JOptionPane.showMessageDialog(Login.this, "CPF ou senha incorretos!", "Erro de autenticação", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });
                    okButton.setActionCommand("OK");
                    GridBagConstraints gbc_okButton = new GridBagConstraints();
                    gbc_okButton.anchor = GridBagConstraints.NORTHEAST;
                    gbc_okButton.insets = new Insets(0, 0, 0, 5);
                    gbc_okButton.gridx = 0;
                    gbc_okButton.gridy = 0;
                    buttonPane.add(okButton, gbc_okButton);
                    getRootPane().setDefaultButton(okButton);
                }
                {
                    JButton cancelButton = new JButton("Sair");
                    cancelButton.addActionListener(new ActionListener() {
                        @Override
						public void actionPerformed(ActionEvent e) {
                            dispose();
                        }
                    });
                    cancelButton.setActionCommand("Cancel");
                    GridBagConstraints gbc_cancelButton = new GridBagConstraints();
                    gbc_cancelButton.anchor = GridBagConstraints.NORTHWEST;
                    gbc_cancelButton.gridx = 1;
                    gbc_cancelButton.gridy = 0;
                    buttonPane.add(cancelButton, gbc_cancelButton);
                }


            }
        }
    }

}
