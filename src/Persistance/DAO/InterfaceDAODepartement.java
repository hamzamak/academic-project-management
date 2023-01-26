/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistance.DAO;

import Metier.Departement;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author pc
 */
public interface InterfaceDAODepartement {

    public ArrayList<Departement> getAll();

    public Departement getDepartement(Integer ID);

    public Integer getIdDepartementByName(String nomDepartement);

    public void ShowIntable(JTable tableDepartement);

    public void addDepartement(Departement depart);

    public void updateDepartement(Departement AncienDepart, Departement newDepart);

    public void deleteDepartement(Integer ID);
}
