/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metier;

import Persistance.DAO.DaoProjet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JTable;

/**
 *
 * @author pc
 */
public class GestionProjets {

    DaoProjet daoProjet;

    public GestionProjets() {
        daoProjet = new DaoProjet();
    }
    
    public ArrayList<Projets> getAll() {
        return daoProjet.getAll();
    }

    public int getDurree(int idProjet) {
        return daoProjet.getDurree(idProjet);
    }

    public java.sql.Date getDateDepart(int id) {

        return daoProjet.getDateDepart(id);
    }

    public Calendar getCalenderDateFin(java.sql.Date date_depart, int duree) {
        return daoProjet.getCalenderDateFin(date_depart, duree);
    }

    public void deleteProjet(int id) {
        daoProjet.deleteProjet(id);
    }

    public void ShowIntablePFE_PFA(JTable tableProjet) {
        daoProjet.ShowIntablePFE_PFA(tableProjet);
    }

    public Projets getProjetById(Integer ID) {
        return daoProjet.getProjetById(ID);
    }

    public Calendar getCalender(String date) {
        String yyyy = date.substring(0, 4);
        int year = Integer.parseInt(yyyy);
        // System.out.println(year + "  y");
        String mm = date.substring(5, 7);
        int mois = Integer.parseInt(mm);
        // System.out.println(mois + "   m");

        String j = date.substring(8);
        int jour = Integer.parseInt(j);
        // System.out.println(jour + "  j");
        return new GregorianCalendar(year, mois, jour);
    }

    public boolean rechercheEtdById(int idEtudiant) {
        return daoProjet.rechercheEtdById(idEtudiant);
    }

    public void addProjet(Projets projet) {
            daoProjet.addProjet(projet);
    }

    public void updateProjet(Projets oldprojet, Projets newProjet) {
            daoProjet.updateProjet(oldprojet, newProjet);
    }

    public java.sql.Date getDateDepartByIDEtud(int idEtudiant) {
        if (rechercheEtdById(idEtudiant)) {
            return daoProjet.getDateDepartByIDEtud(idEtudiant);
        }
        return null;
    }

    public int getDurreeByIDEtud(int IDEtud) {
        if (rechercheEtdById(IDEtud)) {
            return daoProjet.getDurreeByIDEtud(IDEtud);
        }
        return -1;
    }
    
     public void ShowIntableDoctorat(JTable tableProjetDoctorat) {
         daoProjet.ShowIntableDoctorat(tableProjetDoctorat);
     }
     
       public void deleteProjetByIDetud(int ID_etud) {
           daoProjet.deleteProjetByIDetud(ID_etud);
       }
}
