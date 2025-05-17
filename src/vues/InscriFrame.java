package vues;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionListener;

public class InscriFrame extends JFrame{
    private JTextField emailField, nomField, prenomField;
    private JPasswordField passwordField;
    private JButton inscrireButton, btnQuitter;
    private JPanel contentPane;

    public InscriFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Inscription");
        setBounds(100, 100, 450, 332);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblAdrmail = new JLabel("Adresse mail :");
        lblAdrmail.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAdrmail.setBounds(10, 21, 137, 27);
        contentPane.add(lblAdrmail);

        JLabel lblMotDePasse = new JLabel("Mot de passe :");
        lblMotDePasse.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblMotDePasse.setBounds(10, 68, 137, 27);
        contentPane.add(lblMotDePasse);

        JLabel lblNom = new JLabel("Nom :");
        lblNom.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNom.setBounds(10, 121, 137, 27);
        contentPane.add(lblNom);

        JLabel lblPrnom = new JLabel("Pr\u00E9nom :");
        lblPrnom.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPrnom.setBounds(10, 173, 137, 27);
        contentPane.add(lblPrnom);

        emailField = new JTextField();
        emailField.setBounds(165, 21, 247, 30);
        emailField.setFont(new Font("Tahoma", Font.BOLD, 14));
        contentPane.add(emailField);
        emailField.setColumns(10);

        nomField = new JTextField();
        nomField.setColumns(10);
        nomField.setFont(new Font("Tahoma", Font.BOLD, 14));
        nomField.setBounds(165, 121, 247, 30);
        contentPane.add(nomField);

        prenomField = new JTextField();
        prenomField.setColumns(10);
        prenomField.setFont(new Font("Tahoma", Font.BOLD, 14));
        prenomField.setBounds(165, 173, 247, 30);
        contentPane.add(prenomField);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.BOLD, 14));
        passwordField.setBounds(167, 70, 245, 27);
        contentPane.add(passwordField);

        inscrireButton = new JButton("S'inscrire");
        inscrireButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        inscrireButton.setBounds(80, 248, 108, 34);
        contentPane.add(inscrireButton);

        btnQuitter = new JButton("Quitter");
        btnQuitter.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnQuitter.setBounds(229, 248, 108, 34);
        contentPane.add(btnQuitter);
    }

    public String getEmail() {
        return emailField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public String getNom() {
        return nomField.getText();
    }

    public String getPrenom() {
        return prenomField.getText();
    }

    public void addInscriptionListener(ActionListener listener) {
        inscrireButton.addActionListener(listener);
    }

    public void addQuitterListener(ActionListener listener) {
        btnQuitter.addActionListener(listener);
    }

    public void showMessage(String message, String titre, int type) {
        JOptionPane.showMessageDialog(this, message, titre, type);
    }
}
