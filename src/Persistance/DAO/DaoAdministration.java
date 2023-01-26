
package Persistance.DAO;

import Metier.Administration;
import Persistance.Connexion_SQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DaoAdministration implements InterfaceDAOAdministration{
      Connection cnx = null;
    PreparedStatement prepared = null;
    ResultSet resultat = null;

    public DaoAdministration() {
        cnx = Connexion_SQL.ConnectDB();
    }
    
    @Override
    public boolean SeConnecter(Administration admin) {
          try {
              String sql ="select * from administateurs";
              prepared = cnx.prepareStatement(sql);
              resultat = prepared.executeQuery();
              while(resultat.next()){
                  String nom= resultat.getString("nom");
                  String password = resultat.getString("password");
                  String metier = resultat.getString("metier");
                  if(admin.getNom_logging().equals(nom) && admin.getPassword_logging().equals(password)
                          && admin.getMetier().equals(metier)){
                     
                      return true;
                  }
              }
              
          } catch (SQLException ex) {
              Logger.getLogger(DaoAdministration.class.getName()).log(Level.SEVERE, null, ex);
          }
         
          return false ;
    }

    @Override
    public ArrayList<Administration> getAll() {
        ArrayList<Administration> liste = new ArrayList<>();
       try {
              String sql ="select * from administateurs";
              prepared = cnx.prepareStatement(sql);
              resultat = prepared.executeQuery();
              while(resultat.next()){
                  String nom= resultat.getString("nom");
                  String password = resultat.getString("password");
                   String metier = resultat.getString("metier");
                  liste.add(new Administration(nom, password,metier));
              }
              
          } catch (SQLException ex) {
              Logger.getLogger(DaoAdministration.class.getName()).log(Level.SEVERE, null, ex);
          } 
          return liste ;
    }

    @Override
    public String getPassword(String username) {
        String sql ="select password from administateurs where nom='"+username+"'" ;
          try {
              prepared = cnx.prepareStatement(sql);
              resultat = prepared.executeQuery();
              if(resultat.next()){
                  return resultat.getString("password");
                
          }
          } catch (SQLException ex) {
              Logger.getLogger(DaoAdministration.class.getName()).log(Level.SEVERE, null, ex);
          }
        return "" ;
    }
    
    
    
}
