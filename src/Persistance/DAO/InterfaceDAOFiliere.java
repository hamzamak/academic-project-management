/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistance.DAO;

import Metier.Etudiant;
import Metier.Filiere;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author pc
 */
public interface InterfaceDAOFiliere {

    public ArrayList<Filiere> getAll();

    public Integer getIdFiliereByName(String nomFiliere);

    public Filiere getFiliere(Integer ID);

    public void ShowIntable(JTable tableFiliere);
    
    public void addFiliere(Filiere filiere);
    
    public void updateFiliere(Filiere AncienFiliere , Filiere newFiliere  ) ;    
    

    public void deleteFiliere(Integer ID) ;
}
