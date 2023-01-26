/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metier;

import Persistance.DAO.DaoFiliere;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author pc
 */
public class GestionFiliere {
    DaoFiliere daoFiliere ;
    public GestionFiliere (){
        daoFiliere = new DaoFiliere();
    }
    public  ArrayList<Filiere> getAll(){
         return daoFiliere.getAll();
     }
     public  Integer getIdFiliereByName(String nomFiliere){
      return daoFiliere.getIdFiliereByName(nomFiliere);
    }
     public  Filiere getFiliere(Integer ID){
         return daoFiliere.getFiliere(ID);
     }
      public  void ShowIntable(JTable tableEtd){
           daoFiliere.ShowIntable(tableEtd);
    }
     
    public void addFiliere(Filiere filiere) {
     daoFiliere.addFiliere(filiere);
    }

    public void updateFiliere(Filiere AncienFiliere, Filiere newFiliere) {
        daoFiliere.updateFiliere(AncienFiliere, newFiliere);
    }

    
    public void deleteFiliere(Integer ID) {
       daoFiliere.deleteFiliere(ID);
    }
}
