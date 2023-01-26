/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metier;


import Persistance.DAO.DaoAdministration;
import java.util.ArrayList;
/**
 *
 * @author pc
 */
public class GestionAdministration {
    DaoAdministration daoAdmin ; 
    ArrayList<Administration> liste  ;

    public GestionAdministration() {
        daoAdmin = new DaoAdministration();
    }
    public boolean Se_Connecter(Administration admin){
        return daoAdmin.SeConnecter(admin);
    }
    public String getPassword(String username){
        return daoAdmin.getPassword( username);
    }
    
}
