package controlleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import modeles.Utilisateur;
import modeles.UtilisateurDAO;
import vues.AuthFrame;
import vues.InscriFrame;

import javax.swing.*;

public class UtilisateurControlleur {

    private AuthFrame authFrame;
    private InscriFrame inscriFrame;
    private UtilisateurDAO utilisateurDAO;

    public UtilisateurControlleur(InscriFrame inscri,AuthFrame auth) {
        authFrame = auth;
        inscriFrame = inscri;
        utilisateurDAO = new UtilisateurDAO();

        authFrame.addLoginListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });

        authFrame.addGoToInscriListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToInscriptionFrame();
            }
        });

        authFrame.addQuitListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);  // Quit the application
            }
        });

        inscriFrame.addInscriptionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleInscription();
            }
        });

        inscriFrame.addQuitterListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void handleLogin() {
        String email = authFrame.getEmail();
        String password = authFrame.getPassword();

        try {
            if (utilisateurDAO.login(email, password, "", "")) {
                authFrame.showMessage("Login successful", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                authFrame.showMessage("Invalid email or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            authFrame.showMessage("Error while logging in", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void switchToInscriptionFrame() {
        authFrame.setVisible(false);
        inscriFrame.setVisible(true);
    }

    private void handleInscription() {
        String email = inscriFrame.getEmail();
        String password = inscriFrame.getPassword();
        String nom = inscriFrame.getNom();
        String prenom = inscriFrame.getPrenom();

        try {
            boolean success = utilisateurDAO.inscrire(new Utilisateur(email, password, nom, prenom));
            if (success) {
                inscriFrame.showMessage("Inscription successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                switchToAuthFrame();
            } else {
                inscriFrame.showMessage("Inscription failed", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            inscriFrame.showMessage("Error while registering", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void switchToAuthFrame() {
        inscriFrame.setVisible(false);
        authFrame.setVisible(true);
    }

}
