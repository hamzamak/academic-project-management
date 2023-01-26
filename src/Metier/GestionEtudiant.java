/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metier;

import Persistance.DAO.DaoEtudiant;
import java.util.ArrayList;
import javax.swing.JTable;


public class GestionEtudiant {
    DaoEtudiant  daoEtudiant  ;
    public GestionEtudiant(){
        daoEtudiant = new DaoEtudiant();
    }
    public  ArrayList<Etudiant> getAll(){
         return daoEtudiant.getAll();
     }
    //ces 3 fonctions ci-dessous sont utiles dans l'initialisation des comboBox des etudiants dans table projet
    public ArrayList<Etudiant> getEtudiantsDoctorants(){
        
        ArrayList<Etudiant> listeComplet = daoEtudiant.getAll();
        ArrayList<Etudiant> liste = new ArrayList<>();
        for(Etudiant etud : listeComplet){
           if(etud.getNiveau().equalsIgnoreCase("Doctorat")) {
               liste.add(etud);
           }
        }
        return liste ;
    }
         public ArrayList<Etudiant> getEtudiants_3emeAnnee(){
        ArrayList<Etudiant> listeComplet = daoEtudiant.getAll();
        ArrayList<Etudiant> liste = new ArrayList<>();
        for(Etudiant etud : listeComplet){
           if(etud.getNiveau().equalsIgnoreCase("Master 3eme annee")) {
               liste.add(etud);
           }
        }
        return liste ;
    }
    
     public ArrayList<Etudiant> getEtudiants_2emeAnnee(){
        ArrayList<Etudiant> listeComplet = daoEtudiant.getAll();
        ArrayList<Etudiant> liste = new ArrayList<>();
        for(Etudiant etud : listeComplet){
           if(etud.getNiveau().equalsIgnoreCase("Master 2eme annee")) {
               liste.add(etud);
           }
        }
        return liste ;
    }
    public Etudiant getEtudiantByID(Integer ID){
        return daoEtudiant.getEtudiantByID(ID);
    }
    public void addEtudiant(Etudiant etd){
          daoEtudiant.addEtudiant(etd);
    }
   public  void updateEtudiant(Etudiant AncienEtd , Etudiant newEtd ){
           daoEtudiant.updateEtudiant( AncienEtd ,  newEtd );
    }
   public  void deleteEtudiant(Integer ID ){
           daoEtudiant.deleteEtudiant(ID);
    }
    public void ImprimerListeEtudiant(String chemin){
           daoEtudiant.ImprimerListeEtudiant( chemin);
    }
   public  void ShowIntable(JTable tableEtd){
           daoEtudiant.ShowIntable(tableEtd);
    }
     public void ShowIntableMembreDoctorat(JTable table, int id_lab) {
         daoEtudiant.ShowIntableMembreDoctorat(table, id_lab);
     }
}
