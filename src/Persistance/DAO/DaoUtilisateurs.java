
package Persistance.DAO;

import Metier.Utilisateurs;
import Persistance.Connexion_SQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;


public class DaoUtilisateurs implements InterfaceDAOUsers{

    java.sql.Connection cnx = null;
    java.sql.PreparedStatement prepared = null;
    ResultSet resultat = null;

    public DaoUtilisateurs() {
        cnx = Connexion_SQL.ConnectDB();
    }

    @Override
    public ArrayList<Utilisateurs> getAll() {
        ArrayList<Utilisateurs> liste = new ArrayList<>();
        String sql = "select * from administateurs";
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {
                Integer ID = resultat.getInt("id_adm");
                String nom = resultat.getString("nom");
                String password = resultat.getString("password");
                String metier = resultat.getString("metier");
                liste.add(new Utilisateurs(ID, nom, password, metier));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoUtilisateurs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liste;
    }
    
    @Override
     public Utilisateurs getUserByID(Integer id_user) {
        String sql = "select * from administateurs where id_adm='"+id_user+"'";
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {
                String nom = resultat.getString("nom");
                String password = resultat.getString("password");
                String metier = resultat.getString("metier");
                return new Utilisateurs(id_user, nom, password, metier);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoUtilisateurs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
    

    @Override
    public void ShowIntable(JTable tableUtilisateurs) {
        String sql = "select* from administateurs";
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();

            tableUtilisateurs.setModel(DbUtils.resultSetToTableModel(resultat));

        } catch (SQLException ex) {
            Logger.getLogger(DaoUtilisateurs.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void addUser(Utilisateurs user) {
        String sql = "insert into administateurs (nom,password,metier) values (?,?,?) ";
        try {
            prepared = cnx.prepareStatement(sql);

            prepared.setString(1, user.getUserName());
            prepared.setString(2, user.getPassword());
            prepared.setString(3, user.getMetier());
            prepared.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DaoUtilisateurs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateUtilisateurs(Utilisateurs ancienUser, Utilisateurs newUser) {
        String sql = "update  administateurs set nom=?,password=?, metier =? where id_adm='" + ancienUser.getID() + "'";

        try {
            prepared = cnx.prepareStatement(sql);

            prepared.setString(1, newUser.getUserName());
            prepared.setString(2, newUser.getPassword());
            prepared.setString(3, newUser.getMetier());
            prepared.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DaoUtilisateurs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteUtilisateurs(Integer ID) {
        String sql = "delete from  administateurs where id_adm='" + ID + "'";

        try {
            prepared = cnx.prepareStatement(sql);
            prepared.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DaoUtilisateurs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
