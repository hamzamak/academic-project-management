/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistance.DAO;

import Metier.Laboratoire;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author pc
 */
public interface InterfaceDAOLab {

    public ArrayList<Laboratoire> getAll();

    public Laboratoire getLaboratoiret(Integer ID);

    public Integer getIdLaboratoireByName(String nomLaboratoire);

    public void ShowIntable(JTable tableLaboratoire);

    public void addLaboratoire(Laboratoire lab);

    public void updateLaboratoire(Laboratoire AncienLab, Laboratoire newLab);

    public void deleteLaboratoire(Integer ID);
}
