
package Presentation;

import Metier.Etape;
import Metier.GestionEtape;
import Metier.GestionProfesseur;
import Metier.GestionProjets;
import Metier.Professeur;
import Metier.Projets;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ControlleurEtape {
    GestionEtape gestionEtape ;
    GestionProfesseur gestionProfesseur ;
    GestionProjets gestionProjets ;
    public ControlleurEtape(){
        gestionEtape = new GestionEtape() ;
        gestionProfesseur = new GestionProfesseur();
        gestionProjets = new GestionProjets();
    }
    
     public void deleteEtape(JTable tableEtape) {
        int indice = tableEtape.getSelectedRow();
        if (indice != - 1) {
            String id_etape = tableEtape.getModel().getValueAt(indice, 0).toString();
            gestionEtape.deleteEtape(Integer.parseInt(id_etape));
            
        } else {
            JOptionPane.showMessageDialog(null, "veuillez selectionner une ligne !! ", "aucun ligne est selectionnee", JOptionPane.INFORMATION_MESSAGE);
        }            
    }
      public void ShowIntable(JTable tableEtape) {
        gestionEtape.ShowIntable(tableEtape);
     }
      
      public DefaultComboBoxModel<String> initializeModelProjet( ){
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
         for(Projets projet : gestionProjets.getAll()){
             model.addElement(projet.getIDProjet() + " " + projet.getTitre());
         }
         
         return model ;
     }
      
      
      public DefaultComboBoxModel<String> initializeModelProfesseur( ){
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
         for(Professeur prof : gestionProfesseur.getAll()){
             if(prof.getArchive().equalsIgnoreCase("Non")){
             model.addElement(prof.getID()+" "+ prof.getNom() +" "+ prof.getPrenom());
             }
         }
         
         return model ;
     }
      
      public boolean addEtape(Etape etape, boolean isEtapeDepart){
        int id_projet = etape.getIDProjet();
       
        int duree_projet = gestionProjets.getDurree(id_projet) * 4 ; // en transforme duree (en mois ) en semaines 
        int duree_total_etapes = gestionEtape.getSomme_Duree_Etape(id_projet);
        // il faut que la duree recupere a partir de cette etape + duree_total_etapes <= duree du projet
        int id_prof_etapes = gestionEtape.getIdProfesseurFromEtape(id_projet);
        // le meme prof doit definir tous les etapes du projet 
        int id_prof = etape.getIDProfesseur();
        // on verifie si tous les champs sont remplis avec des caracteres pas espace blancs ou vide
        if (etape.getLivraison().isBlank() || etape.getDocumentation().isBlank() ||
                etape.getTitre().isBlank() || etape.getIDProfesseur() ==-1 || etape.getIDProjet()==-1) { // ICI !!!!!!
            if(etape.getIDProfesseur() ==-1 ){
                JOptionPane.showMessageDialog(null, "Aucun professeur existe \nveuillez d'abord ajouter des professeurs", "Professeurs introuvble", JOptionPane.WARNING_MESSAGE);
            }
            if(etape.getIDProjet()==-1){
               JOptionPane.showMessageDialog(null, "Aucun Projet existe \nveuillez d'abord ajouter des Projets", "Projets introuvble", JOptionPane.WARNING_MESSAGE); 
            }
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Champs invalides", JOptionPane.WARNING_MESSAGE);
        } else {
            int Spin = etape.getDuree();
            
            if (Spin <= 0 || Spin >  duree_projet - duree_total_etapes) {
                JOptionPane.showMessageDialog(null, "la duree de l'etape doit etre inferieure  ou egale a la duree du projet attribue ", "Duree de l'etape est invalide", JOptionPane.ERROR_MESSAGE);
            } else if (!gestionEtape.first_Affectation_Prof_Etape(id_prof_etapes) && id_prof != id_prof_etapes) {
                // id_prof_etapes =0 cad c'est la premiere etape qu'on va creer , donc aucun professeur existe
                JOptionPane.showMessageDialog(null, "le meme professeur doit definir tous les etapes du projet concerne ", "Affectation du professeur est invalide", JOptionPane.ERROR_MESSAGE);
            } else {
                
                if (gestionEtape.addEtape(etape, isEtapeDepart)) {
                    gestionEtape.update_List_Etape_Depart(gestionEtape.getMax_Id_etape() + " " + etape.getTitre(), id_projet);
                } else {
                    gestionEtape.update_List_Etape_Depart_Pas_Defini(id_projet);
                }
                
                JOptionPane.showMessageDialog(null, "L'etape " + etape.getTitre() + " a ete attribuee au projet " + id_projet, "Creation d'une etape", JOptionPane.INFORMATION_MESSAGE);
                
                return true ;
            }
        }
        return false ;
      }
      
          
      public boolean updateEtape(JTable tableEtape ,Etape etape, boolean isEtapeDepart){
          
        int indice = tableEtape.getSelectedRow();
        if (indice != - 1) {
        String idE = tableEtape.getModel().getValueAt(indice, 0).toString();
        int idEtape = Integer.parseInt(idE);
        int id_projet = etape.getIDProjet();
        //cette etape extrait du tableau nous aide apres a comparer si la duree  saisi (celle qui a modifie)
        // a prendre une valeur plus grande 
        Etape etape_from_table = gestionEtape.getEtapeByID(idEtape);
        Integer duree_table = etape_from_table.getDuree() ;
        int duree_projet = gestionProjets.getDurree(id_projet) * 4 ; // en transforme duree (en mois ) en semaines 
        int duree_total_etapes = gestionEtape.getSomme_Duree_Etape(id_projet);
        // il faut que la duree recupere a partir de cette etape + duree_total_etapes <= duree du projet
        int id_prof_etapes = gestionEtape.getIdProfesseurFromEtape(id_projet);
        // le meme prof doit definir tous les etapes du projet 
        int id_prof = etape.getIDProfesseur();
        // on verifie si tous les champs sont remplis avec des caracteres pas espace blancs ou vide
        if (etape.getLivraison().isBlank() || etape.getDocumentation().isBlank() ||
                etape.getTitre().isBlank() || etape.getIDProfesseur() ==-1 || etape.getIDProjet()==-1) {
            if(etape.getIDProfesseur() ==-1 ){
                JOptionPane.showMessageDialog(null, "Aucun professeur existe \nveuillez d'abord ajouter des professeurs", "Professeurs introuvble", JOptionPane.WARNING_MESSAGE);
            }
            if(etape.getIDProjet()==-1){
               JOptionPane.showMessageDialog(null, "Aucun Projet existe \nveuillez d'abord ajouter des Projets", "Projets introuvble", JOptionPane.WARNING_MESSAGE); 
            }
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Champs invalides", JOptionPane.WARNING_MESSAGE);
        } else {
            int Spin = etape.getDuree();
            
            if (Spin <= 0 || Spin > duree_table + (duree_projet - duree_total_etapes) ) {
                JOptionPane.showMessageDialog(null, "la duree de l'etape doit etre inferieure  ou egale a la duree du projet attribue ", "Duree de l'etape est invalide", JOptionPane.ERROR_MESSAGE);
            } else if (!gestionEtape.first_Affectation_Prof_Etape(id_prof_etapes) && id_prof != id_prof_etapes) {
                // id_prof_etapes =0 cad c'est la premiere etape qu'on va creer , donc aucun professeur existe
               JOptionPane.showMessageDialog(null, """
                                                   *le meme professeur doit definir tous les etapes du projet concerne
                                                   *Une fois un professeura ete ajoute , il ne saura pas modifie apres 
                                                   *Penser a ajouter cette etape par ce professeur choisi puis supprimer celle-la""", "Affectation du professeur est invalide", JOptionPane.ERROR_MESSAGE);
               } else {
            /*    if(isEtapeDepart){
                    etape.setEtape_depart(etape.getID()+" "+etape.getTitre());       
                }*/
               if (gestionEtape.updateEtape(idEtape, etape, isEtapeDepart)) {
                    gestionEtape.update_List_Etape_Depart(idEtape + " " + etape.getTitre(), id_projet);
                } else {
                    gestionEtape.update_List_Etape_Depart_Pas_Defini(id_projet);
                }
                
                JOptionPane.showMessageDialog(null, "L'etape " + etape.getTitre() + " a ete modifie  " , "Modification d'une etape", JOptionPane.INFORMATION_MESSAGE);
                
                return true ;
            }
        }
        return false ;
      }
      else {
            JOptionPane.showMessageDialog(null, "selectionner une ligne!!");
            
        }
        return false ;
      }
          public Etape getEtapeByID(Integer id_etape) {
          return gestionEtape.getEtapeByID(id_etape);
      }
      
}


