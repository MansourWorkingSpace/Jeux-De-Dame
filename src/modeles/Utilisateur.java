package modeles;

public class Utilisateur {

    private String email;
    private String mdp;      // Mot de passe
    private String nom;
    private String prenom;

    public Utilisateur(String email, String mdp, String nom, String prenom) {
        this.email = email;
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getMdp() {
        return mdp;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
}
