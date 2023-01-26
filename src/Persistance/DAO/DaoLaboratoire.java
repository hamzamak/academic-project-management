
package Persistance.DAO;

import Metier.Laboratoire;
import Persistance.Connexion_SQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;


public class DaoLaboratoire implements InterfaceDAOLab{
     java.sql.Connection cnx = null;
    java.sql.PreparedStatement prepared = null;
    ResultSet resultat = null;
    
    public DaoLaboratoire(){
         cnx =   Connexion_SQL.ConnectDB();       
    }
    
    
     @Override
     public  ArrayList<Laboratoire> getAll(){
        ArrayList<Laboratoire> liste  = new ArrayList<>();
         String sql = "select * from laboratoire";
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {
                Integer ID = resultat.getInt("id_lab");
                String nom = resultat.getString("nom");
                String email = resultat.getString("email");
                liste.add(new Laboratoire(ID, nom, email));
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DaoLaboratoire.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liste ;
    }
     
     @Override
      public  Laboratoire getLaboratoiret(Integer ID){
        String sql="select * from laboratoire where id_lab='"+ID+"'";
        
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {
                ID = resultat.getInt("id_lab");
                 String nomFiliere = resultat.getString("nom");
                String email = resultat.getString("email");
              return  new Laboratoire(ID, nomFiliere, email);
              
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DaoLaboratoire.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null ;
    }
   
     @Override
       public  Integer getIdLaboratoireByName(String nomLaboratoire){
        String sql="select id_lab from laboratoire where nom='"+nomLaboratoire+"'";
         Integer ID = -1 ;
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {
                ID = resultat.getInt("id_lab");
              
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DaoLaboratoire.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ID ;
    }
       
     
     @Override
        public void ShowIntable(JTable tableLaboratoire) {
        String sql = "select* from laboratoire "; 
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();

            tableLaboratoire.setModel(DbUtils.resultSetToTableModel(resultat));

        } catch (SQLException ex) {
            Logger.getLogger(DaoLaboratoire.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    
     @Override
    public void addLaboratoire(Laboratoire lab) {
      String sql = "insert into laboratoire (nom,email) values (?,?) ";
        try {
            prepared =cnx.prepareStatement(sql);
                
                prepared.setString(1,lab.getNom());
                prepared.setString(2,lab.getEmail());
                prepared.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoLaboratoire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
     @Override
    public void updateLaboratoire(Laboratoire AncienLab, Laboratoire newLab) {
        String sql="update  laboratoire set nom=?,email=? where id_lab='"+AncienLab.getID()+"'";
      
        try {
                prepared =cnx.prepareStatement(sql);
                
                prepared.setString(1,newLab.getNom());
                prepared.setString(2,newLab.getEmail());
                prepared.execute();
              
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoLaboratoire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
     
     @Override
    public void deleteLaboratoire(Integer ID) {
       String sql="delete from  laboratoire where id_lab='"+ID+"'";
      
        try {
               prepared =cnx.prepareStatement(sql);
               
             int reponse =   JOptionPane.showConfirmDialog(null, "*Vous voulez Supprimer ce laboratoire\n*Noter que vous supprimez aussi toutes les tables qui ont une relation avec ce lab", "Suppression d'une departement", JOptionPane.YES_NO_OPTION);
             // Suppression par cascade  
             if(reponse == JOptionPane.YES_OPTION){
                   prepared.execute();
            }
               
                
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoLaboratoire.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
}
