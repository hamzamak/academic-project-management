/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metier;

import Persistance.DAO.DaoDepartement;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author pc
 */
public class GestionDepartement {
    DaoDepartement daoDepartement ;
    public GestionDepartement(){
        daoDepartement = new DaoDepartement();
    }
      public  ArrayList<Departement> getAll(){
      return daoDepartement.getAll();
    }
      
       public  Departement getDepartement(Integer ID){
        return daoDepartement.getDepartement(ID);
    }
        public  Integer getIdDepartementByName(String nomDepartement){
            return daoDepartement.getIdDepartementByName(nomDepartement);
        }
          public void ShowIntable(JTable tableDepartement) {
       daoDepartement.ShowIntable(tableDepartement);

    }

    
    public void addDepartement(Departement depart) {
     daoDepartement.addDepartement(depart);
    }

    
    public void updateDepartement(Departement AncienDepart, Departement newDepart) {
       daoDepartement.updateDepartement(AncienDepart, newDepart);
    }

    
    public void deleteDepartement(Integer ID) {
      daoDepartement.deleteDepartement(ID);
        } 
    }
       
