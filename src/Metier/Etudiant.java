/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metier;

/**
 *
 * @author post21
 */
public class Etudiant {
   private Integer  ID ;
   private String nom ; private String prenom ;
   private String email ;private String niveau ;
   private Integer ID_Filiere ;

    public Etudiant(Integer ID, String nom, String prenom, String email, String niveau, Integer ID_Filiere) {
        this.ID = ID;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.niveau = niveau;
        this.ID_Filiere = ID_Filiere;
    }
    // ID auto incremente dans BD , on pourra utiliser ::
     public Etudiant( String nom, String prenom, String email, String niveau, Integer ID_Filiere) {
       
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.niveau = niveau;
        this.ID_Filiere = ID_Filiere;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

  

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public Integer getID_Filiere() {
        return ID_Filiere;
    }

    public void setID_Filiere(Integer ID_Filiere) {
        this.ID_Filiere = ID_Filiere;
    }
   
}
