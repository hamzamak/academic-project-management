/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistance.DAO;

import Metier.Entreprise;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author pc
 */
public interface InterfaceDAOEntreprise {

    public ArrayList<Entreprise> getAll();

    public Entreprise getEntreprise(Integer ID);
   
    public Integer getIdEntrepriseByName(String raisonEntreprise);

    public void ShowIntable(JTable tableEntreprise);

    public void addEntreprise(Entreprise entrep);

    public void updateEntreprise(Entreprise AncienEntrep, Entreprise newEntrep);

    public void deletEntreprise(Integer ID);
}
