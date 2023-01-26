/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistance.DAO;

import Metier.Projets;
import Persistance.Connexion_SQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author pc
 */
public class DaoProjet implements InterfaceDAOProjets {

    java.sql.Connection cnx = null;
    java.sql.PreparedStatement prepared = null;
    ResultSet resultat = null;

    public DaoProjet() {
        cnx = Connexion_SQL.ConnectDB();
    }

    public ArrayList<Projets> getAll() {
        String sql = "select * from projet";
        ArrayList<Projets> list = new ArrayList<>();
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {
                Integer id = resultat.getInt("id_projet");
                String titre = resultat.getString("titre");
                Integer duree = resultat.getInt("duree");
                java.sql.Date date_depart = resultat.getDate("date_depart");
                Object Laboratoire = resultat.getObject("Laboratoire");
                Object Entreprise = resultat.getObject("Entreprise");
                Integer etudiant = resultat.getInt("etudiant");
                String Type = resultat.getString("Type");

                list.add(new Projets(id, Type, titre, duree, date_depart, Laboratoire, Entreprise, etudiant));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProjet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Projets getProjetById(Integer ID) {
        String sql = "select * from projet where id_projet ='" + ID + "'";
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            resultat = prepared.executeQuery();
            while (resultat.next()) {

                String titre = resultat.getString("titre");
                Integer duree = resultat.getInt("duree");
                java.sql.Date date_depart = resultat.getDate("date_depart");

                Object IDLab = resultat.getObject("Laboratoire");
                Object IDEntrep = resultat.getObject("entreprise");
                Integer IDEtudiant = resultat.getInt("etudiant");
                String type_projet = resultat.getString("type");

                return new Projets(ID, type_projet, titre, duree, date_depart, IDLab, IDEntrep, IDEtudiant);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProjet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void addProjet(Projets projet) {
        String sql = "insert into projet (titre,duree ,date_depart,laboratoire,entreprise,etudiant,type) values (?,?,?,?,?,?,?) ";
        try {
            prepared = cnx.prepareStatement(sql);

            prepared.setString(1, projet.getTitre());
            prepared.setInt(2, projet.getDuree());
            prepared.setDate(3, projet.getDate_depart());

            prepared.setObject(4, projet.getIDLab());
            prepared.setObject(5, projet.getIDEntrep());
            prepared.setInt(6, projet.getIDEtudiant());
            prepared.setString(7, projet.getType_projet());
            prepared.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DaoProjet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void updateProjet(Projets oldprojet, Projets newProjet) {
        String sql = "update  projet set titre=?,duree=? ,date_depart=?,Laboratoire=?,entreprise=?,etudiant=?,Type=? where id_projet ='" + oldprojet.getIDProjet() + "'";
        try {
            prepared = cnx.prepareStatement(sql);

            prepared.setString(1, newProjet.getTitre());
            prepared.setInt(2, newProjet.getDuree());
            prepared.setDate(3, newProjet.getDate_depart());

            prepared.setObject(4, newProjet.getIDLab());
            prepared.setObject(5, newProjet.getIDEntrep());
            prepared.setInt(6, newProjet.getIDEtudiant());
            prepared.setString(7, newProjet.getType_projet());
            prepared.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DaoProjet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public int getDurree(int idProjet) {

        try {
//  order by date_depart ASC
            String sql = "select  duree from projet where id_projet ='" + idProjet + "'";
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {

                return resultat.getInt("duree");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProjet.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public java.sql.Date getDateDepart(int id) {
        // dans requete getprojetID (id prof) de table etape si il ya plusieurs prof(cle etrangere) , le dernier sera choisi 
        // par order by asc on a sure qu on n'a choisi le prof le plus recent ajoute au base de donnee 
        // Donc propriete archive sera projete sur ce professeur , (cad si date actuelle > datefin projet 
        // associe a ce prof  ) on doit l'archiver
        // order by date_depart ASC SI SEulement on ajoute ceci
        try {
            String sql = "select date_depart  from projet where id_projet ='" + id + "'";
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {
                return resultat.getDate("date_depart");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProjet.class.getName()).log(Level.SEVERE, null, ex);

        }

        return null;
    }

    @Override
    public Calendar getCalenderDateFin(java.sql.Date date_depart, int duree) {
        String date = date_depart.toString();

        String yyyy = date.substring(0, 4);
        int year = Integer.parseInt(yyyy);

        String mm = date.substring(5, 7);
        int mois = Integer.parseInt(mm);

        String j = date.substring(8);
        int jour = Integer.parseInt(j);
        Calendar c = new GregorianCalendar(year, mois, jour);
        c.add(Calendar.MONTH, duree);

        return c;
    }

    @Override
    public boolean rechercheEtdById(int idEtudiant) {
        try {
            String sql = "select etudiant from projet ";
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {
                if (resultat.getInt("etudiant") == idEtudiant) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProjet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void deleteProjet(int id) {

        try {
            String sql = "delete from projet  where id_projet ='" + id + "'";
            prepared = cnx.prepareStatement(sql);
            prepared.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DaoProjet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ShowIntablePFE_PFA(JTable tableProjet) {
        String sql = "select* from projet where Type=? OR Type= ?";
        String type1 = "PFA";
        String type2 = "PFE";
        try {
            prepared = cnx.prepareStatement(sql);
            prepared.setString(1, type1);
            prepared.setString(2, type2);
            resultat = prepared.executeQuery();

            tableProjet.setModel(DbUtils.resultSetToTableModel(resultat));

        } catch (SQLException ex) {
            Logger.getLogger(DaoProjet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public java.sql.Date getDateDepartByIDEtud(int idEtudiant) {

        try {
            // Si etudiant a 2 projets on doit recuperer le plus recent puis sa date dep et sa duree 
            // puis additionner pour avoir date fin du projet si on va ajouter a cet etudiant par la suite a un projet
            // un doctorat  si il ne redouble pas cette date fin va etre plus grand que date de depart
            // du nouveau projet attribue 
            String sql = "select date_depart  from projet where etudiant ='" + idEtudiant + "' order by date_depart desc ";
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {
                return resultat.getDate("date_depart");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProjet.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;
    }

    @Override
    public int getDurreeByIDEtud(int IDEtud) {

        try {

            String sql = "select date_depart, duree from projet where etudiant ='" + IDEtud + "' order by date_depart desc ";
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {

                return resultat.getInt("duree");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProjet.class.getName()).log(Level.SEVERE, null, ex);
        }

        return -1;
    }

    @Override
    public void ShowIntableDoctorat(JTable tableProjetDoctorat) {
        String sql = "select id_projet,titre,duree,date_depart,Laboratoire,etudiant from projet where Type=?";
        String type = "Doctorat";
        try {
            prepared = cnx.prepareStatement(sql);
            prepared.setString(1, type);
            resultat = prepared.executeQuery();

            tableProjetDoctorat.setModel(DbUtils.resultSetToTableModel(resultat));

        } catch (SQLException ex) {
            Logger.getLogger(DaoProjet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void deleteProjetByIDetud(Integer ID_etud) {

        try {
            String sql = "delete from projet  where etudiant ='" + ID_etud + "'";
            prepared = cnx.prepareStatement(sql);
            prepared.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DaoProjet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
