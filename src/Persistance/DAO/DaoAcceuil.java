package Persistance.DAO;

import Metier.Acceuil;
import Persistance.Connexion_SQL;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DaoAcceuil implements InterfaceDAOAcceuil {

    Connection cnx = null;
    PreparedStatement prepared = null;
    ResultSet resultat = null;

    public DaoAcceuil() {
        cnx = Connexion_SQL.ConnectDB();
    }

    @Override
    public Integer getCountEtudiant() {
        int count = 0;
        try {
            Statement s = (Statement) cnx.createStatement();
            s.execute("SELECT count(id_etd) FROM etudiant");
            ResultSet rs = s.getResultSet();
            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoAcceuil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;

    }

    @Override
    public Integer getCountProfesseur() {
        int count = 0;
        try {
            Statement s = (Statement) cnx.createStatement();
            s.execute("SELECT count(id_prof) FROM professeur");
            ResultSet rs = s.getResultSet();
            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoAcceuil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;

    }

    @Override
    public Integer getCountDepartement() {
        int count = 0;
        try {
            Statement s = (Statement) cnx.createStatement();
            s.execute("SELECT count(id_depart) FROM departement");
            ResultSet rs = s.getResultSet();
            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoAcceuil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;

    }

    @Override
    public Integer getCountFiliere() {
        int count = 0;
        try {
            Statement s = (Statement) cnx.createStatement();
            s.execute("SELECT count(id_filiere) FROM filiere");
            ResultSet rs = s.getResultSet();
            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoAcceuil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;

    }

    @Override
    public Integer getCountEntreprise() {
        int count = 0;
        try {
            Statement s = (Statement) cnx.createStatement();
            s.execute("SELECT count(id_entreprise) FROM entreprise");
            ResultSet rs = s.getResultSet();
            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoAcceuil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;

    }

    @Override
    public Integer getCountAdmin() {
        int count = 0;
        try {
            Statement s = (Statement) cnx.createStatement();
            s.execute("SELECT count(id_adm) FROM administateurs");
            ResultSet rs = s.getResultSet();
            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoAcceuil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;

    }

    @Override
    public Integer getCountLabo() {
        int count = 0;
        try {
            Statement s = (Statement) cnx.createStatement();
            s.execute("SELECT count(id_lab) FROM laboratoire");
            ResultSet rs = s.getResultSet();
            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoAcceuil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;

    }

    @Override
    public Acceuil getCount() {
       
        return new Acceuil(getCountEtudiant(), getCountProfesseur(), getCountDepartement()
                , getCountFiliere(), getCountEntreprise(), getCountLabo(), getCountAdmin());

    }
}
