/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metier;

import Persistance.DAO.DaoLaboratoire;
import java.util.ArrayList;
import javax.swing.JTable;

public class GestionLaboratoire {

    DaoLaboratoire daoLab;

    public GestionLaboratoire() {
        daoLab = new DaoLaboratoire();
    }

    public ArrayList<Laboratoire> getAll() {

        return daoLab.getAll();
    }

    public Laboratoire getLaboratoire(Integer ID) {
        return daoLab.getLaboratoiret(ID);
    }

    public Integer getIdLaboratoireByName(String nomLaboratoire) {
        return daoLab.getIdLaboratoireByName(nomLaboratoire);
    }

    public void ShowIntable(JTable tableLaboratoire) {
        daoLab.ShowIntable(tableLaboratoire);

    }

    public void addLaboratoire(Laboratoire lab) {
        daoLab.addLaboratoire(lab);
    }

    public void updateLaboratoire(Laboratoire AncienLab, Laboratoire newLab) {
        daoLab.updateLaboratoire(AncienLab, newLab);
    }

    public void deleteLaboratoire(Integer ID) {
        daoLab.deleteLaboratoire(ID);
    }
}
