
package Persistance.DAO;

import Metier.Acceuil;


public interface InterfaceDAOAcceuil {

    Integer getCountAdmin();

    Integer getCountEntreprise();

    Integer getCountDepartement();

    Integer getCountFiliere();

    Integer getCountProfesseur();

    Integer getCountEtudiant();

    Integer getCountLabo();
    
    Acceuil getCount();

}
