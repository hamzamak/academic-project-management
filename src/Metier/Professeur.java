/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metier;

/**
 *
 * @author pc
 */
public class Professeur {
      private Integer  ID ;
   private String nom ;
   private String prenom ;
   private String email ;
   private String grade ; // Mieux la declarer enumeration
   private Integer ID_Departement ;
   private Integer ID_Lab ;
   private String role ;
   private String  archive ; 

    public Professeur(Integer ID, String nom, String prenom, String email, String grade, 
            Integer ID_Departement, Integer ID_Lab, String role , String  archive ) {
        this.ID = ID;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.grade = grade;
        this.ID_Departement = ID_Departement;
        this.ID_Lab = ID_Lab;
        this.role = role;
        this.archive = archive ;
    }
   
    public Professeur(String nom, String prenom, String email, String grade, Integer ID_Departement,
            Integer ID_Lab, String role , String  archive ) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.grade = grade;
        this.ID_Departement = ID_Departement;
        this.ID_Lab = ID_Lab;
        this.role = role;
        this.archive = archive ;
    }
    
    public Professeur(String nom, String prenom, String email, String grade, Integer ID_Departement,
            Integer ID_Lab, String role  ) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.grade = grade;
        this.ID_Departement = ID_Departement;
        this.ID_Lab = ID_Lab;
        this.role = role;
       // this.archive = "Pas defini" ;
    }

    public String isArchive() {
        return archive;
    }

    public void setArchive(String archive) {
        this.archive = archive;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getID_Departement() {
        return ID_Departement;
    }

    public void setID_Departement(Integer ID_Departement) {
        this.ID_Departement = ID_Departement;
    }

    public Integer getID_Lab() {
        return ID_Lab;
    }

    public void setID_Lab(Integer ID_Lab) {
        this.ID_Lab = ID_Lab;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getArchive() {
        return archive;
    }
    
  
}
