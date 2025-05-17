package vues;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class AuthFrame extends JFrame {
    private JPanel contentPane;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JLabel lblAdrMail;
    private JLabel lblMotDePasse;
    private JButton btnInscrire;
    private JButton btnLogin;
    private JButton btnQuitter;

    public AuthFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 250);
        setTitle("Authentification");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblAdrMail = new JLabel("Adresse mail : ");
        lblAdrMail.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAdrMail.setBounds(10, 30, 139, 23);
        contentPane.add(lblAdrMail);

        lblMotDePasse = new JLabel("Mot de passe :");
        lblMotDePasse.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblMotDePasse.setBounds(10, 85, 139, 23);
        contentPane.add(lblMotDePasse);

        emailField = new JTextField();
        emailField.setFont(new Font("Tahoma", Font.BOLD, 14));
        emailField.setBounds(183, 27, 219, 30);
        contentPane.add(emailField);
        emailField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.BOLD, 14));
        passwordField.setBounds(183, 82, 219, 30);
        contentPane.add(passwordField);

        btnInscrire = new JButton("S'inscrire");
        btnInscrire.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnInscrire.setBounds(10, 160, 115, 30);
        contentPane.add(btnInscrire);

        btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnLogin.setBounds(148, 160, 115, 30);
        contentPane.add(btnLogin);

        btnQuitter = new JButton("Quitter");
        btnQuitter.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnQuitter.setBounds(287, 160, 115, 30);
        contentPane.add(btnQuitter);

    }

    public String getEmail() {
        return emailField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public void addLoginListener(ActionListener listener) {
        btnLogin.addActionListener(listener);
    }

    public void addGoToInscriListener(ActionListener listener) {
        btnInscrire.addActionListener(listener);
    }

    public void addQuitListener(ActionListener listener) {
        btnQuitter.addActionListener(listener);
    }

    public void showMessage(String message, String titre, int type) {
        JOptionPane.showMessageDialog(this, message, titre, type);
    }
}
