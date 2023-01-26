
package Persistance.DAO;

import Metier.Professeur;
import java.util.ArrayList;
import javax.swing.JTable;


public interface InterfaceDAOProfesseur {
   
    public ArrayList<Professeur> getAll();
    public Professeur getProfesseurByID(Integer ID) ;
    public void addProfesseur(Professeur prof, boolean ismembre) ;
    public void updateProfesseur(Professeur Ancienprof, Professeur newprof , boolean isMembre) ;
    public void deleteProfesseur(Integer ID_Prof) ;

    public boolean isProfActive(int id_professeur) ;
    public void ImprimerListeProfesseur(String chemin) ;
    public void ShowIntable(JTable tableProf) ;

    public boolean isMembreLabo(int id_prof) ;
}
