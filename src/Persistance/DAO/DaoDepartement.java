/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistance.DAO;

import Metier.Departement;
import Persistance.Connexion_SQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class DaoDepartement implements InterfaceDAODepartement{
     java.sql.Connection cnx = null;
    java.sql.PreparedStatement prepared = null;
    ResultSet resultat = null;
    public DaoDepartement(){
        cnx =   Connexion_SQL.ConnectDB();
    }
    
     @Override
     public  ArrayList<Departement> getAll(){
        ArrayList<Departement> liste  = new ArrayList<>();
         String sql = "select * from departement";
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {
                Integer ID = resultat.getInt("id_depart");
                String nom = resultat.getString("nom");
                String email = resultat.getString("email");
                liste.add(new Departement(ID, nom, email));
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DaoDepartement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liste ;
    }
     @Override
      public  Departement getDepartement(Integer ID){
        String sql="select * from departement where id_depart='"+ID+"'";
        
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {  
                 String nom = resultat.getString("nom");
                String email = resultat.getString("email");
              return  new Departement(ID, nom, email);
              
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DaoDepartement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null ;
    }
     @Override
       public  Integer getIdDepartementByName(String nomDepartement){
        String sql="select id_depart from departement where nom='"+nomDepartement+"'";
         Integer ID = -1 ;
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {
                ID = resultat.getInt("id_depart");
              
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DaoDepartement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ID ;
    }
       
     @Override
        public void ShowIntable(JTable tableDepartement) {
        String sql = "select* from departement "; 
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();

            tableDepartement.setModel(DbUtils.resultSetToTableModel(resultat));

        } catch (SQLException ex) {
            Logger.getLogger(DaoDepartement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
     @Override
    public void addDepartement(Departement depart) {
      String sql = "insert into departement (nom,email) values (?,?) ";
        try {
            prepared =cnx.prepareStatement(sql);
                
                prepared.setString(1,depart.getNom());
                prepared.setString(2,depart.getEmail());
                prepared.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoDepartement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
     @Override
    public void updateDepartement(Departement AncienDepart, Departement newDepart) {
        String sql="update  departement set nom=?,email=? where id_depart='"+AncienDepart.getID()+"'";
      
        try {
                prepared =cnx.prepareStatement(sql);
                
                prepared.setString(1,newDepart.getNom());
                prepared.setString(2,newDepart.getEmail());
                prepared.execute();
              
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoDepartement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
     @Override
    public void deleteDepartement(Integer ID) {
       String sql="delete from  departement where id_depart='"+ID+"'";
      
        try {
               prepared =cnx.prepareStatement(sql);
               
             int reponse =   JOptionPane.showConfirmDialog(null, "*Vous voulez Supprimer cette departement\n*Noter que vous supprimez aussi toutes les tables qui ont une relation avec cette departement", "Suppression d'une departement", JOptionPane.YES_NO_OPTION);
             // Suppression par cascade  
             if(reponse == JOptionPane.YES_OPTION){
                   prepared.execute();
            }
               
                
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoDepartement.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
     
}
