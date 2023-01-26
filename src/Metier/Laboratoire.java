/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metier;

/**
 *
 * @author pc
 */
public class Laboratoire {
    private Integer ID ;
    private String nom ;
    private  String email; 

    public Laboratoire(Integer ID, String nom, String email) {
        this.ID = ID;
        this.nom = nom;
        this.email = email;
    }
     public Laboratoire(String nom, String email) {
       
        this.nom = nom;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
