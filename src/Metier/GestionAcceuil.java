
package Metier;

import Persistance.DAO.DaoAcceuil;

/**
 *
 * @author pc
 */
public class GestionAcceuil {
    private  DaoAcceuil  daoAcceuil ; 
    public GestionAcceuil(){
        daoAcceuil = new DaoAcceuil();
    }
    
    
    public Integer getCountAdmin(){
       return  daoAcceuil.getCountAdmin();
    }

    public Integer getCountEntreprise(){
          return  daoAcceuil.getCountEntreprise();
    }

    public Integer getCountDepartement(){
        return  daoAcceuil.getCountDepartement();
    }

    public Integer getCountFiliere(){
        return  daoAcceuil.getCountFiliere();
    }

    public Integer getCountProfesseur(){
        return  daoAcceuil.getCountProfesseur();
    }

    public Integer getCountEtudiant(){
        return  daoAcceuil.getCountEtudiant();
    }

    public Integer getCountLabo(){
        return  daoAcceuil.getCountLabo();
    }
    
    public Acceuil getCount(){
        return  daoAcceuil.getCount();
    }
}
