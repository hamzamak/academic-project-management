/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentation;

import Metier.Departement;
import Metier.GestionDepartement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author pc
 */
public class ControlleurDepartement {
     // Patern pour verifie email 
    private static final String PATTERN ="^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
   
    GestionDepartement gestionDepartement ; 
     
    public ControlleurDepartement(){
        gestionDepartement = new GestionDepartement();
    }
      public  ArrayList<Departement> getAll(){
      return gestionDepartement.getAll();
    }
      
       public  Departement getDepartement(Integer ID){
        return gestionDepartement.getDepartement(ID);
    }
         public  Integer getIdDepartementByName(String nomDepartement){
            return gestionDepartement.getIdDepartementByName(nomDepartement);
        }
         
              public void ShowIntable(JTable tableDepartement) {
       gestionDepartement.ShowIntable(tableDepartement);

    }

      public boolean addDepartement(Departement depart) {
               Pattern pattern = Pattern.compile(PATTERN);
         Matcher matcher = pattern.matcher(depart.getEmail());
        
              if (depart.getNom().isBlank() || depart.getEmail().isBlank() || !matcher.matches() ) {
                if (!matcher.matches()) {
                JOptionPane.showMessageDialog(null, "le champ e-mail est mal saisie", "Champ mot de passe est invalide", JOptionPane.WARNING_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(null, "veuillez saisie tous les champs", "Champs invalide", JOptionPane.WARNING_MESSAGE);
            } else {
                  
                   gestionDepartement.addDepartement(depart);
                   JOptionPane.showMessageDialog(null, "le departement a ete ajoute ");
              return true ;
        }
       return false ;
    
    }

     public boolean updateDepartement(Departement depart, JTable tableDepart) {
         int indice = tableDepart.getSelectedRow();
           Pattern pattern = Pattern.compile(PATTERN);
         Matcher matcher = pattern.matcher(depart.getEmail());
         
        if (indice != - 1) {
               if (depart.getNom().isBlank() || depart.getEmail().isBlank() || !matcher.matches() ) {
                if (!matcher.matches()) {
                JOptionPane.showMessageDialog(null, "le champ e-mail est mal saisie", "Champ mot de passe est invalide", JOptionPane.WARNING_MESSAGE);
            }
            else JOptionPane.showMessageDialog(null, "veuillez saisie tous les champs", "Champs invalide", JOptionPane.WARNING_MESSAGE);
            } else {
                   String id_Depart = tableDepart.getModel().getValueAt(indice, 0).toString();
                     gestionDepartement.updateDepartement(gestionDepartement.getDepartement(Integer.parseInt(id_Depart)), depart);
                   JOptionPane.showMessageDialog(null, "Modification est reussite");
                   return true ;
              }
        }
         else {
             JOptionPane.showMessageDialog(null, "veuillez selectionner une ligne !! ", "aucune ligne est selectionnee", JOptionPane.WARNING_MESSAGE);
        }
      return false ;
    }

    
    public void deleteDepartement(JTable tableDepart) {
            int indice = tableDepart.getSelectedRow();
        if (indice != - 1) {
            String id_Depart = tableDepart.getModel().getValueAt(indice, 0).toString();
            
            gestionDepartement.deleteDepartement(Integer.parseInt(id_Depart));
                
        }
        else {
            JOptionPane.showMessageDialog(null, "veuillez selectionner une ligne !! ", "aucune ligne est selectionnee", JOptionPane.WARNING_MESSAGE);
        }
       
    }
}
