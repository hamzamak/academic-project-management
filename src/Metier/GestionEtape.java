/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metier;

import Persistance.DAO.DaoEtape;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author pc
 */
public class GestionEtape {

    DaoEtape daoEtape;

    public GestionEtape() {
        daoEtape = new DaoEtape();
    }

    public void deleteEtape(Integer id_etape) {
        int a = JOptionPane.showConfirmDialog(null, "Vous Voulez Vraiment Supprimer cette etape ", "Suppression d'une etape", JOptionPane.YES_NO_OPTION);
        
        if (a == JOptionPane.YES_OPTION) { // ou a == 0
            daoEtape.deleteEtape(id_etape);
            JOptionPane.showMessageDialog(null, "Suppression est reussite");
        }        
    }
    
    public void ShowIntable(JTable tableEtape) {
        daoEtape.ShowIntable(tableEtape);
    }
    
    public int getIdProjet(int professeur) { // car un seul prof qui definit tous les etapes d'un projet
        
        return daoEtape.getIdProjet(professeur);
    }
    
    public boolean addEtape(Etape etape, boolean isEtapeDepart) {
        
        return daoEtape.addEtape(etape, isEtapeDepart);
    }
    
    public void updateEtapeDepart(Integer id_projet, String etape_departe) {
        
        daoEtape.updateEtapeDepart(id_projet, etape_departe);
    }
    
    public String getEtapeDepart(Integer id_projet) {
        return daoEtape.getEtapeDepart(id_projet);
    }
    
    public void update_List_Etape_Depart_Pas_Defini(int id_projet) {
        daoEtape.update_List_Etape_Depart_Pas_Defini(id_projet);
    }
    
    public void update_List_Etape_Depart(String etape_departe, int id_projet) {
        daoEtape.update_List_Etape_Depart(etape_departe, id_projet);
        
    }
    
    public int getMax_Id_etape() {
        return daoEtape.getMax_Id_etape();
    }
    
    public int getIdProfesseurFromEtape(int id_projet) {
        return daoEtape.getIdProfesseurFromEtape(id_projet);
    }
    
    public boolean first_Affectation_Prof_Etape(int id_prof) {
        return daoEtape.first_Affectation_Prof_Etape(id_prof);
    }
    
     public int getSomme_Duree_Etape(int id_projet) {
         return daoEtape.getSomme_Duree_Etape(id_projet);
     }
      public boolean updateEtape(Integer id_etape, Etape etape, boolean isEtapeDepart) {
          return daoEtape.updateEtape(id_etape, etape, isEtapeDepart);
      }
      public Etape getEtapeByID(Integer id_etape) {
          return daoEtape.getEtapeByID(id_etape);
      }
    
}
