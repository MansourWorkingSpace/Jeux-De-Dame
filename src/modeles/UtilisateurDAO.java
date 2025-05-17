package modeles;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.ConnexionDB;

public  class UtilisateurDAO {

    public boolean inscrire(Utilisateur user) throws SQLException {

        String query = "insert into utilisateur (email, mdp, nom, prenom) values (?, ?, ?, ?)";

        try {

            PreparedStatement ps = ConnexionDB.getConnection().prepareStatement(query);

            ps.setString(1, user.getEmail());
            ps.setString(2, user.getMdp());
            ps.setString(3, user.getNom());
            ps.setString(4, user.getPrenom());

            return ps.executeUpdate()>0;

        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    };

    public boolean login(String email, String mdp, String nom, String prenom) throws SQLException {
        String query = "select * from utilisateur where email = ? and mdp = ?" ;

        try {

            PreparedStatement ps = ConnexionDB.getConnection().prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, mdp);
            ResultSet rs = ps.executeQuery();

            if(rs.next())
                return true;
            else
                return false;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    };
}
