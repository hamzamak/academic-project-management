
package Presentation;

import Metier.Departement;
import Metier.GestionDepartement;
import Metier.GestionLaboratoire;
import Metier.GestionProfesseur;
import Metier.Laboratoire;
import Metier.Professeur;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class ControlleurProfesseur {
     // Patern pour verifie email 
    private static final String PATTERN = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
  
    GestionProfesseur gestionProf ; 
    GestionDepartement gestionDepartement ;
    GestionLaboratoire gestionLab ;
    public ControlleurProfesseur(){
        gestionProf = new GestionProfesseur() ;
        gestionDepartement = new GestionDepartement();
        gestionLab = new GestionLaboratoire();
    }
      public DefaultComboBoxModel<String> initializeModelDepartement( ){
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
         for(Departement depart : gestionDepartement.getAll()){
             model.addElement(depart.getNom());
         }
         
         return model ;
     }
      
        public DefaultComboBoxModel<String> initializeModelLab( ){
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
         for(Laboratoire lab : gestionLab.getAll()){
             model.addElement(lab.getNom());
         }
         
         return model ;
     }
        
          public boolean addProfesseur(Professeur prof , boolean ismembre) {
                 Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(prof.getEmail());
              
               if(prof.getPrenom().isBlank() || prof.getNom().isBlank()|| prof.getEmail().isBlank()
                        || prof.getID_Departement() == -1 || prof.getID_Lab() ==-1 || !matcher.matches()){
                   
                 if(prof.getID_Departement() == -1 ){
                       JOptionPane.showMessageDialog(null, "Aucun departement a ete trouve\nveuillez d'abord ajouter les departements \n", "departement introuvble", JOptionPane.WARNING_MESSAGE);
                  }
                 else if (prof.getID_Lab() ==-1){
                      JOptionPane.showMessageDialog(null, "Aucun lieu a ete detecte\nveuillez d'abord ajouter des laboratoires", "Lieu introuvble", JOptionPane.WARNING_MESSAGE); 
                  }
                  else if (!matcher.matches()) {
                JOptionPane.showMessageDialog(null, "le champ e-mail est mal saisie", "Champ e-mail est invalide", JOptionPane.WARNING_MESSAGE);
            }
                 else
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Champs invalides", JOptionPane.WARNING_MESSAGE);
            }
            else{
                gestionProf.addProfesseur(prof, ismembre);
                JOptionPane.showMessageDialog(null, "Le professeur "+prof.getPrenom()+" "+prof.getNom()+" est ajoute ", "Ajout d'un professeur", JOptionPane.INFORMATION_MESSAGE);
                return true ;
            }
                return false ;
          }
          public boolean updateProfesseur(Professeur prof, JTable tableProf , boolean isMembre) {
               int indice = tableProf.getSelectedRow();
                    Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(prof.getEmail());
        if (indice != - 1) {
              if (prof.getNom().isBlank() || prof.getPrenom().isBlank() || prof.getEmail().isBlank()
                      || prof.getID_Departement() == -1 || prof.getID_Lab() ==-1 || !matcher.matches()) {
                 if(prof.getID_Departement() == -1 ){
                       JOptionPane.showMessageDialog(null, "Aucun departement a ete trouve\nveuillez d'abord ajouter les departements \n", "departement introuvble", JOptionPane.WARNING_MESSAGE);
                  }
                 else if (prof.getID_Lab() ==-1){
                      JOptionPane.showMessageDialog(null, "Aucun lieu a ete detecte\nveuillez d'abord ajouter des laboratoires", "Lieu introuvble", JOptionPane.WARNING_MESSAGE); 
                  }
                  else if (!matcher.matches()) {
                JOptionPane.showMessageDialog(null, "le champ e-mail est mal saisie", "Champ e-mail est invalide", JOptionPane.WARNING_MESSAGE);
            }
                 else
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Champs invalides", JOptionPane.WARNING_MESSAGE);
          } else {
                   String idProf = tableProf.getModel().getValueAt(indice, 0).toString();
                   gestionProf.updateProfesseur(gestionProf.getProfesseurByID(Integer.parseInt(idProf)),prof,isMembre );
                   JOptionPane.showMessageDialog(null, "Modification est reussite");
                    return true ;
              }
        }
         else {
             JOptionPane.showMessageDialog(null, "veuillez selectionner une ligne !! ", "aucune ligne est selectionnee", JOptionPane.WARNING_MESSAGE);
        }
        return false ;
          }
          
           public void ShowIntable(JTable tableProf) {
                 gestionProf.ShowIntable(tableProf);
     } 
           
              public Professeur getProfesseurByID(Integer ID) {
          return gestionProf.getProfesseurByID(ID);
              }
           public  boolean isMembreLabo (int id_prof){
            return gestionProf.isMembreLabo(id_prof);
        }
            public void deleteProfesseur(JTable tableProf){
                  int indice = tableProf.getSelectedRow();
        if (indice != - 1) {
            String idProf = tableProf.getModel().getValueAt(indice, 0).toString();
            
              gestionProf.deleteProfesseur(Integer.parseInt(idProf));
                
        }
        else {
            JOptionPane.showMessageDialog(null, "veuillez selectionner une ligne !! ", "aucune ligne est selectionnee", JOptionPane.WARNING_MESSAGE);
        }
              
            }
      public void ImprimerListeProfesseur(String chemin) {
          gestionProf.ImprimerListeProfesseur(chemin);
      }
      public void archiverProf(JTable tableProf){
               int indice = tableProf.getSelectedRow();
        if (indice != - 1) {
           String idProf = tableProf.getModel().getValueAt(indice, 0).toString();
           gestionProf.ArchiverProf(Integer.parseInt(idProf));
        }
        else{
             JOptionPane.showMessageDialog(null, "veuillez selectionner une ligne !! ","aucun ligne est selectionnee", JOptionPane.INFORMATION_MESSAGE);
        }
      }
       public void updateProfesseurSetStateArchive( int id) {
              gestionProf.updateProfesseurSetStateArchive(id);
          }
       
        public void ShowIntableMembreDepartement(JTable tableProf, int depart) {
                gestionProf.ShowIntableMembreDepartement(tableProf, depart);
            }
         public void ShowIntableMembreLab(JTable table, int id_lab) {
             gestionProf.ShowIntableMembreLab(table, id_lab);
         }
}
