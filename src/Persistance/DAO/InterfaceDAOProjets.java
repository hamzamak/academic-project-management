/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistance.DAO;

import Metier.Projets;
import java.util.Calendar;
import javax.swing.JTable;

/**
 *
 * @author pc
 */
public interface InterfaceDAOProjets {

    public Projets getProjetById(Integer ID);

    public void addProjet(Projets projet);

    public void updateProjet(Projets oldprojet, Projets newProjet);

    public int getDurree(int idProjet);

    public java.sql.Date getDateDepart(int id);

    public Calendar getCalenderDateFin(java.sql.Date date_depart, int duree);

    public boolean rechercheEtdById(int idEtudiant);

    public void deleteProjet(int id);

    public void ShowIntablePFE_PFA(JTable tableProjet);

    public java.sql.Date getDateDepartByIDEtud(int idEtudiant);

    public int getDurreeByIDEtud(int IDEtud);

    public void ShowIntableDoctorat(JTable tableProjetDoctorat);

    public void deleteProjetByIDetud(Integer ID_etud);
}
