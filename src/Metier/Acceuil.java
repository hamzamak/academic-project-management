/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metier;

/**
 *
 * @author pc
 */
public class Acceuil {

    private Integer nb_Etudiants;
    private Integer nb_Professeurs;
    private Integer nb_Departement;
    private Integer nb_Filieres;
    private Integer nb_Entreprises;
    private Integer nb_Laboratoires;
    private Integer nb_Admin;

    public Acceuil(Integer nb_Etudiants, Integer nb_Professeurs, Integer nb_Departement,
            Integer nb_Filieres, Integer nb_Entreprises, Integer nb_Laboratoires , Integer nb_Admin) {
        this.nb_Etudiants = nb_Etudiants;
        this.nb_Professeurs = nb_Professeurs;
        this.nb_Departement = nb_Departement;
        this.nb_Filieres = nb_Filieres;
        this.nb_Entreprises = nb_Entreprises;
        this.nb_Laboratoires = nb_Laboratoires;
        this.nb_Admin =  nb_Admin ;
    }

    public Integer getNb_Etudiants() {
        return nb_Etudiants;
    }

    public void setNb_Etudiants(Integer nb_Etudiants) {
        this.nb_Etudiants = nb_Etudiants;
    }

    public Integer getNb_Professeurs() {
        return nb_Professeurs;
    }

    public void setNb_Professeurs(Integer nb_Professeurs) {
        this.nb_Professeurs = nb_Professeurs;
    }

    public Integer getNb_Departement() {
        return nb_Departement;
    }

    public void setNb_Departement(Integer nb_Departement) {
        this.nb_Departement = nb_Departement;
    }

    public Integer getNb_Filieres() {
        return nb_Filieres;
    }

    public void setNb_Filieres(Integer nb_Filieres) {
        this.nb_Filieres = nb_Filieres;
    }

    public Integer getNb_Entreprises() {
        return nb_Entreprises;
    }

    public void setNb_Entreprises(Integer nb_Entreprises) {
        this.nb_Entreprises = nb_Entreprises;
    }

    public Integer getNb_Laboratoires() {
        return nb_Laboratoires;
    }

    public void setNb_Laboratoires(Integer nb_Laboratoires) {
        this.nb_Laboratoires = nb_Laboratoires;
    }

    public Integer getNb_Admin() {
        return nb_Admin;
    }

    public void setNb_Admin(Integer nb_Admin) {
        this.nb_Admin = nb_Admin;
    }
    

}
