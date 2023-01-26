/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentation;

import Metier.Departement;
import Metier.Filiere;
import Metier.GestionDepartement;
import Metier.GestionFiliere;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author pc
 */
public class ControlleurFiliere {
    GestionFiliere gestionFiliere ;
    GestionDepartement gestionDepartement ;
    public ControlleurFiliere(){
        gestionFiliere= new GestionFiliere();
        gestionDepartement = new GestionDepartement();
    }
    public Integer getIdFiliereByName(String nomFiliere){
        return gestionFiliere.getIdFiliereByName(nomFiliere);
    }
    public  Filiere getFiliere(Integer ID){
        return gestionFiliere.getFiliere(ID);
    }
     public DefaultComboBoxModel<String> initializeModelDepartement( ){
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
         for(Departement departement : gestionDepartement.getAll()){
             model.addElement(departement.getNom());
         }
         
         return model ;
     }
     public  void ShowIntable(JTable tableEtd){
           gestionFiliere.ShowIntable(tableEtd);
    }
       public void addFiliere(Filiere filiere) {
              
        
              if (filiere.getNom().isBlank()|| filiere.getDepartement() ==- 1 ) {
                  if(filiere.getDepartement() ==- 1){
                    JOptionPane.showMessageDialog(null, "Aucun departement a ete trouve\nveuillez d'abord ajouter les departements \n", "departement introuvble", JOptionPane.WARNING_MESSAGE);  
                  }
                JOptionPane.showMessageDialog(null, "veuillez saisie tous les champs", "Champs invalide", JOptionPane.WARNING_MESSAGE);
            } else {
                  
                   gestionFiliere.addFiliere(filiere);
                   JOptionPane.showMessageDialog(null, "la filiere a ete ajoutee ");
              
        }
       
    
    }

    public void updateFiliere(Filiere filiere, JTable tableFiliere) {
         int indice = tableFiliere.getSelectedRow();
        if (indice != - 1) {
              if (filiere.getNom().isBlank() || filiere.getDepartement() ==- 1 ) {
                  if(filiere.getDepartement() ==- 1){
                    JOptionPane.showMessageDialog(null, "Aucun departement a ete trouve\nveuillez d'abord ajouter les departements \n", "departement introuvble", JOptionPane.WARNING_MESSAGE);  
                  }
                JOptionPane.showMessageDialog(null, "veuillez saisie tous les champs", "Champs invalide", JOptionPane.WARNING_MESSAGE);
            } else {
                   String idF = tableFiliere.getModel().getValueAt(indice, 0).toString();
                     gestionFiliere.updateFiliere(gestionFiliere.getFiliere(Integer.parseInt(idF)), filiere);
                   JOptionPane.showMessageDialog(null, "Modification est reussite");
              }
        }
         else {
             JOptionPane.showMessageDialog(null, "veuillez selectionner une ligne !! ", "aucune ligne est selectionnee", JOptionPane.WARNING_MESSAGE);
        }
      
    }

    
    public void deleteFiliere(JTable tableFiliere) {
            int indice = tableFiliere.getSelectedRow();
        if (indice != - 1) {
            String idE = tableFiliere.getModel().getValueAt(indice, 0).toString();
            
            gestionFiliere.deleteFiliere(Integer.parseInt(idE));
                
        }
        else {
            JOptionPane.showMessageDialog(null, "veuillez selectionner une ligne !! ", "aucune ligne est selectionnee", JOptionPane.WARNING_MESSAGE);
        }
       
    }
}
