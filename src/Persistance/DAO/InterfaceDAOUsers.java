
package Persistance.DAO;

import Metier.Utilisateurs;
import java.util.ArrayList;
import javax.swing.JTable;

public interface InterfaceDAOUsers {
    public ArrayList<Utilisateurs> getAll() ;
    
     public Utilisateurs getUserByID(Integer id_user) ;
     
    

    public void ShowIntable(JTable tableUtilisateurs) ;
    public void addUser(Utilisateurs user) ;

    public void updateUtilisateurs(Utilisateurs ancienUser, Utilisateurs newUser) ;
    public void deleteUtilisateurs(Integer ID) ;
}
