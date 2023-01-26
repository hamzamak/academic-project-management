/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistance.DAO;

import Metier.Filiere;
import Persistance.Connexion_SQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author pc
 */
public class DaoFiliere implements InterfaceDAOFiliere{
    java.sql.Connection cnx = null;
    java.sql.PreparedStatement prepared = null;
    ResultSet resultat = null;
    
    public DaoFiliere(){
         cnx =   Connexion_SQL.ConnectDB();
         
    }
    
    @Override
   public  ArrayList<Filiere> getAll(){
        ArrayList<Filiere> liste  = new ArrayList<>();
         String sql = "select * from filiere";
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {
                Integer ID = resultat.getInt("id_filiere");
                String nomFiliere = resultat.getString("nomFiliere");
                Integer ID_Departement = resultat.getInt("Departement");
                liste.add(new Filiere(ID, nomFiliere, ID_Departement));
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DaoFiliere.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liste ;
    }
   
   
    @Override
   public  Integer getIdFiliereByName(String nomFiliere){
        String sql="select id_filiere from filiere where nomFiliere='"+nomFiliere+"'";
         Integer ID = -1 ;
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {
                ID = resultat.getInt("id_filiere");
              
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DaoFiliere.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ID ;
    }
   
    @Override
   public  Filiere getFiliere(Integer ID){
        String sql="select * from filiere where id_filiere='"+ID+"'";
        
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {
                ID = resultat.getInt("id_filiere");
                 String nomFiliere = resultat.getString("nomFiliere");
                Integer ID_Departement = resultat.getInt("Departement");
              return  new Filiere(ID, nomFiliere, ID_Departement);
              
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DaoFiliere.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null ;
    }
    @Override
    public void ShowIntable(JTable tableFiliere) {
        String sql = "select* from filiere "; 
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();

            tableFiliere.setModel(DbUtils.resultSetToTableModel(resultat));

        } catch (SQLException ex) {
            Logger.getLogger(DaoFiliere.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void addFiliere(Filiere filiere) {
      String sql = "insert into filiere (nomFiliere,Departement) values (?,?) ";
        try {
            prepared =cnx.prepareStatement(sql);
               
                prepared.setString(1,filiere.getNom());
                prepared.setInt(2,filiere.getDepartement());
               
                prepared.execute();
               
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoFiliere.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateFiliere(Filiere AncienFiliere, Filiere newFiliere) {
        String sql="update  filiere set nomFiliere=?,Departement=? where id_filiere='"+AncienFiliere.getID_Filiere()+"'";
      
        try {
                prepared =cnx.prepareStatement(sql);
                
                prepared.setString(1,newFiliere.getNom());
                prepared.setInt(2,newFiliere.getDepartement());
                prepared.execute();
              
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoFiliere.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteFiliere(Integer ID) {
       String sql="delete from  filiere where id_filiere='"+ID+"'";
      
        try {
               prepared =cnx.prepareStatement(sql);
               
             int reponse =   JOptionPane.showConfirmDialog(null, "*Vous voulez Supprimer cette filiere\n*Noter que vous supprimez aussi toutes les tables qui ont une relation avec cette filiere", "Suppression d'une filiere", JOptionPane.YES_NO_OPTION);
             // Suppression par cascade  
             if(reponse == JOptionPane.YES_OPTION){
                   prepared.execute();
            }
               
                
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoFiliere.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
   
}
