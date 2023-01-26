/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metier;

/**
 *
 * @author pc
 */
public class Filiere {
    Integer ID_Filiere ;
    String nom ;
    Integer departement ;
    public Filiere() {    
    }
    public Filiere(Integer ID_Filiere, String nom, Integer departement) {
        this.ID_Filiere = ID_Filiere;
        this.nom = nom;
        this.departement = departement;
    }
    public Filiere( String nom, Integer departement) {  
        this.nom = nom;
        this.departement = departement;
    }

    public Integer getID_Filiere() {
        return ID_Filiere;
    }

    public void setID_Filiere(Integer ID_Filiere) {
        this.ID_Filiere = ID_Filiere;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getDepartement() {
        return departement;
    }

    public void setDepartement(Integer departement) {
        this.departement = departement;
    }
    
}
