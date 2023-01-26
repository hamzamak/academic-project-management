/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metier;

import java.sql.Date;

/**
 *
 * @author pc
 */
public class Projets {

    private Integer IDProjet;
    private String type_projet;
    private String titre;
    private Integer duree;
    private java.sql.Date date_depart;

   
    private Object IDLab; // car il peut etre null 
    private Object IDEntrep;
    private Integer IDEtudiant;

    public Projets(Integer IDProjet, String type_projet, String titre, Integer duree, Date date_depart, Object IDLab, Object IDEntrep, Integer IDEtudiant) {
        this.IDProjet = IDProjet;
        this.type_projet = type_projet;
        this.titre = titre;
        this.duree = duree;
        this.date_depart = date_depart;
        this.IDLab = IDLab;
        this.IDEntrep = IDEntrep;
        this.IDEtudiant = IDEtudiant;
    }
    
    public Projets( String type_projet, String titre, Integer duree, Date date_depart, Object IDLab, Object IDEntrep, Integer IDEtudiant) {
       
        this.type_projet = type_projet;
        this.titre = titre;
        this.duree = duree;
        this.date_depart = date_depart;
        this.IDLab = IDLab;
        this.IDEntrep = IDEntrep;
        this.IDEtudiant = IDEtudiant;
    }

    public Integer getIDProjet() {
        return IDProjet;
    }

    public void setIDProjet(Integer IDProjet) {
        this.IDProjet = IDProjet;
    }

    public String getType_projet() {
        return type_projet;
    }

    public void setType_projet(String type_projet) {
        this.type_projet = type_projet;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public Date getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(Date date_depart) {
        this.date_depart = date_depart;
    }

    public Object getIDLab() {
        return IDLab;
    }

    public void setIDLab(Object IDLab) {
        this.IDLab = IDLab;
    }

    public Object getIDEntrep() {
        return IDEntrep;
    }

    public void setIDEntrep(Object IDEntrep) {
        this.IDEntrep = IDEntrep;
    }

    public Integer getIDEtudiant() {
        return IDEtudiant;
    }

    public void setIDEtudiant(Integer IDEtudiant) {
        this.IDEtudiant = IDEtudiant;
    }


 
}
