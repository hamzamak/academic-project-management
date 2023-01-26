
package Persistance.DAO;

import Metier.Etape;
import Persistance.Connexion_SQL;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;


public class DaoEtape  implements  InterfaceDAOEtape {

    java.sql.Connection cnx = null;
    java.sql.PreparedStatement prepared = null;
    ResultSet resultat = null;

    public DaoEtape() {
        cnx = Connexion_SQL.ConnectDB();
    }

    @Override
    public int getIdProjet(int professeur) { // car un seul prof qui definit tous les etapes d'un projet
        int idProj = 0;
        // ici on peut faire projet where date order by asc puis where profess from etape 
        // pour que le prod choisit soit le plus recent ajoutee pour que archive methode ne confuse pas
        String sql = "select projet from etape where Professeur='" + professeur + "'";
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {
                idProj = resultat.getInt("projet");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProjet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idProj;
    }

    @Override
    public boolean addEtape(Etape etape, boolean isEtapeDepart) {
        boolean isDefini = false;
        String sql = "insert into etape (titre,duree ,etape_departe,Professeur,projet,documentation,livraison) values (?,?,?,?,?,?,?) ";

        try {
            prepared = cnx.prepareStatement(sql);
            prepared.setString(1, etape.getTitre());
            prepared.setInt(2, etape.getDuree());
            if (isEtapeDepart) {
                prepared.setString(3, getMax_Id_etape() + 1 + " " + etape.getTitre());
                isDefini = true;
            } else {
                prepared.setString(3, "Pas definie");
            }

            prepared.setInt(4, etape.getIDProfesseur());
            prepared.setInt(5, etape.getIDProjet());
            prepared.setString(6, etape.getDocumentation());
            prepared.setString(7, etape.getLivraison());
            prepared.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DaoEtape.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isDefini;
    }

    @Override
    public void deleteEtape(Integer id_etape) {

        String sql = "delete from etape  where id_etape='" + id_etape + "'";
        try {

            prepared = cnx.prepareStatement(sql);
            prepared.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DaoEtape.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean updateEtape(Integer id_etape, Etape etape, boolean isEtapeDepart) {
        String sql = "update  etape set titre= ?,duree=? ,etape_departe=?,Professeur=?,projet=?,documentation=?,livraison=? where id_etape='" + id_etape + "'";
        boolean isDefini = false;
        try {
            prepared = cnx.prepareStatement(sql);
            prepared.setString(1, etape.getTitre());
            prepared.setInt(2, etape.getDuree());
            if (isEtapeDepart) {
                prepared.setString(3, id_etape + " " + etape.getTitre());
                isDefini = true;
            } else {
                prepared.setString(3, "Pas definie");
            }

            prepared.setInt(4, etape.getIDProfesseur());
            prepared.setInt(5, etape.getIDProjet());
            prepared.setString(6, etape.getDocumentation());
            prepared.setString(7, etape.getLivraison());
            prepared.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DaoEtape.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isDefini;

    }

    @Override
    public void updateEtapeDepart(Integer id_projet, String etape_departe) {

        String sql = "update etape set etape_departe=? where projet='" + id_projet + "'";

        try {
            prepared = cnx.prepareStatement(sql);
            prepared.setString(1, etape_departe);
            prepared.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DaoEtape.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getEtapeDepart(Integer id_projet) {
        String sql = "select etape_departe from etape where projet='" + id_projet + "'";
        String etape_departe = "Pas definie";
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {
                if (!resultat.getString("etape_departe").equals("Pas definie")) {
                    etape_departe = resultat.getString("etape_departe");
                    break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoEtape.class.getName()).log(Level.SEVERE, null, ex);
        }
        return etape_departe;
    }

    @Override
    public void update_List_Etape_Depart_Pas_Defini(int id_projet) {
        updateEtapeDepart(id_projet, getEtapeDepart(id_projet));
    }

    @Override
    public void update_List_Etape_Depart(String etape_departe, int id_projet) {
        String sql = "update etape set etape_departe=? where projet='" + id_projet + "'";
        try {
            prepared = cnx.prepareStatement(sql);
            prepared.setString(1, etape_departe);
            prepared.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DaoEtape.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public int getMax_Id_etape() {
        int maxID = 0;
        try {
            Statement s2 = (Statement) cnx.createStatement();
            s2.execute("SELECT MAX(id_etape) FROM etape");
            ResultSet rs2 = s2.getResultSet();
            if (rs2.next()) {
                maxID = rs2.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoEtape.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maxID;
    }

    @Override
    public int getIdProfesseurFromEtape(int id_projet) {
        String sql = "select Professeur from etape where projet='" + id_projet + "'";
        int id_prof = 0;
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {
                id_prof = resultat.getInt("Professeur");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoEtape.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id_prof;
    }

    public boolean first_Affectation_Prof_Etape(int id_prof) {
        if (id_prof != 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void ShowIntable(JTable tableEtape) {
        String sql = "select id_etape,titre,duree,etape_departe,professeur, projet from etape";

        try {
            prepared = cnx.prepareStatement(sql);

            resultat = prepared.executeQuery();

            tableEtape.setModel(DbUtils.resultSetToTableModel(resultat));

        } catch (SQLException ex) {
            Logger.getLogger(DaoEtape.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public int getSomme_Duree_Etape(int id_projet) {
        // !!!!! pour connaitre la dure restante pors du creation d'une nouvelle etape
        String sql = "select duree from etape where projet='" + id_projet + "'";
        int duree = 0;
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {
                duree += resultat.getInt("duree");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoEtape.class.getName()).log(Level.SEVERE, null, ex);
        }
        return duree;
    }

    @Override
    public Etape getEtapeByID(Integer id_etape) {
        String sql = "select * from etape where id_etape ='" + id_etape + "'";
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {
              
                String titre = (resultat.getString("titre"));
                Integer duree = (resultat.getInt("duree"));

                String etape_departe = resultat.getString("etape_departe");
                String DocArea = (resultat.getString("documentation"));
                String livraison = (resultat.getString("livraison"));
                Integer prof = resultat.getInt("Professeur");
                Integer projet = resultat.getInt("projet");
                return new Etape(id_etape, titre, duree, etape_departe, DocArea, livraison, prof, projet);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoEtape.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null ;
    }
    
    
     public ArrayList<Integer> getIDProjets(int professeur) { // car un seul prof qui definit tous les etapes d'un projet
        int idProj = 0;
        ArrayList<Integer> liste = new ArrayList<>() ;
        String sql = "select projet from etape where Professeur='" + professeur + "'";
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {
                idProj = resultat.getInt("projet");
                liste.add(idProj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProjet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liste; // liste des id projets
    }

}
