
package Presentation;

import Metier.GestionLaboratoire;
import Metier.Laboratoire;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class ControlleurLab {
     // Patern pour verifie email 
    private static final String PATTERN ="^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$"; 
    GestionLaboratoire gestionLab ;
    public ControlleurLab(){
        gestionLab = new GestionLaboratoire();
    }
     public  ArrayList<Laboratoire> getAll(){
      return gestionLab.getAll();
    }
      
       public  Laboratoire getLaboratoire(Integer ID){
        return gestionLab.getLaboratoire(ID);
    }
         public  Integer getIdLaboratoireByName(String nomLab){
            return gestionLab.getIdLaboratoireByName(nomLab);
        }
         
              public void ShowIntable(JTable tableDepartement) {
      gestionLab.ShowIntable(tableDepartement);

    }

      public boolean addLaboratoire(Laboratoire Lab) {
               Pattern pattern = Pattern.compile(PATTERN);
         Matcher matcher = pattern.matcher(Lab.getEmail());
        
              if (Lab.getNom().isBlank() || Lab.getEmail().isBlank()|| !matcher.matches() ) {
               if (!matcher.matches()) {
                JOptionPane.showMessageDialog(null, "le champ e-mail est mal saisie", "Champ e-mail est invalide", JOptionPane.WARNING_MESSAGE);
               }
               else 
                  JOptionPane.showMessageDialog(null, "veuillez saisie tous les champs", "Champs invalide", JOptionPane.WARNING_MESSAGE);
            } else {
                  
                   gestionLab.addLaboratoire(Lab);
                   JOptionPane.showMessageDialog(null, "le laboratoire a ete ajoute ");
                return true ;
        }
         return false ;
    
    }

     public boolean updateLaboratoire(Laboratoire  Lab, JTable tableLab) {
         int indice = tableLab.getSelectedRow();  Pattern pattern = Pattern.compile(PATTERN);
         Matcher matcher = pattern.matcher(Lab.getEmail());
        
        if (indice != - 1) {
            
              if (Lab.getNom().isBlank() || Lab.getEmail().isBlank()|| !matcher.matches() ) {
               if (!matcher.matches()) {
                JOptionPane.showMessageDialog(null, "le champ e-mail est mal saisie", "Champ e-mail est invalide", JOptionPane.WARNING_MESSAGE);
               }
               else   JOptionPane.showMessageDialog(null, "veuillez saisie tous les champs", "Champs invalide", JOptionPane.WARNING_MESSAGE);
            } else {
                   String idLab = tableLab.getModel().getValueAt(indice, 0).toString();
                     gestionLab.updateLaboratoire(gestionLab.getLaboratoire(Integer.parseInt(idLab)), Lab);
                   JOptionPane.showMessageDialog(null, "Modification est reussite");
                   return true ;
              }
        }
         else {
             JOptionPane.showMessageDialog(null, "veuillez selectionner une ligne !! ", "aucune ligne est selectionnee", JOptionPane.WARNING_MESSAGE);
        }
      return false ;
    }

    
    public void deleteLaboratoire(JTable tableLab) {
            int indice = tableLab.getSelectedRow();
        if (indice != - 1) {
            String idLab = tableLab.getModel().getValueAt(indice, 0).toString();
            
            gestionLab.deleteLaboratoire(Integer.parseInt(idLab));
                
        }
        else {
            JOptionPane.showMessageDialog(null, "veuillez selectionner une ligne !! ", "aucune ligne est selectionnee", JOptionPane.WARNING_MESSAGE);
        }
       
    }
}
