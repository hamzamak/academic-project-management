/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metier;

import Persistance.DAO.DaoUtilisateurs;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author pc
 */
public class GestionUtilisateurs {
    DaoUtilisateurs daoUtilisateurs ;
    public GestionUtilisateurs (){
        daoUtilisateurs = new DaoUtilisateurs();
    }
    
    public ArrayList<Utilisateurs> getAll() {
        return  daoUtilisateurs.getAll();
    }
     public Utilisateurs getUserByID(Integer id_user) {
       return  daoUtilisateurs.getUserByID(id_user);
     }
    public void ShowIntable(JTable tableUtilisateurs) {
        daoUtilisateurs.ShowIntable(tableUtilisateurs);

    }

    public void addUser(Utilisateurs user) {
         daoUtilisateurs.addUser(user);
    }
    
      public boolean verifieUserName(String userName) {
       
          for (Utilisateurs user  : getAll()){
              if(user.getUserName().equals(userName)){
                  return true ;
              }
          }
          return false ;
    }

    public void updateUtilisateurs(Utilisateurs ancienUser, Utilisateurs newUser) {
        daoUtilisateurs.updateUtilisateurs(ancienUser, newUser);
    }

    public void deleteUtilisateurs(Integer ID) {
     daoUtilisateurs.deleteUtilisateurs(ID);
    }
    
}
