
package Metier;

import Persistance.DAO.DaoEntreprise;
import java.util.ArrayList;
import javax.swing.JTable;

public class GestionEntreprise {
    DaoEntreprise daoEntreprise ;
    public GestionEntreprise(){
        daoEntreprise = new DaoEntreprise();
    }
    
     public  ArrayList<Entreprise> getAll(){
       return daoEntreprise.getAll();
    }
     
      public  Entreprise getEntreprise(Integer ID){
        return daoEntreprise.getEntreprise(ID);
    }
    
       public  Integer getIdEntrepriseByName(String raisonEntreprise){
       return  daoEntreprise.getIdEntrepriseByName(raisonEntreprise);
    }
    
        public void ShowIntable(JTable tableEntreprise) {
       daoEntreprise.ShowIntable(tableEntreprise);
    }
    public void addEntreprise(Entreprise entrep) {
        daoEntreprise.addEntreprise(entrep);
    }

    public void updateEntreprise(Entreprise AncienEntrep, Entreprise newEntrep) {
            daoEntreprise.updateEntreprise(AncienEntrep, newEntrep);
    }

    
     
    public void deletEntreprise(Integer ID) {
       daoEntreprise.deletEntreprise(ID);
     
}
     public void ImprimerListeEntreprise(String chemin){
         daoEntreprise.ImprimerListeEntreprise(chemin);
     }
}
