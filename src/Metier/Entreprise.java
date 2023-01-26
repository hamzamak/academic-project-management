/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metier;

/**
 *
 * @author pc
 */
public class Entreprise {
    private Integer ID ;
    private String raison;
    private String email;
    private String adresse;
    private String tel;
    private String responsable;

    public Entreprise(String raison, String email, String adresse, String tel, String responsable) {
        this.raison = raison;
        this.email = email;
        this.adresse = adresse;
        this.tel = tel;
        this.responsable = responsable;
    }

    public Entreprise(Integer ID, String raison, String email, String adresse, String tel, String responsable) {
        this.ID = ID;
        this.raison = raison;
        this.email = email;
        this.adresse = adresse;
        this.tel = tel;
        this.responsable = responsable;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
    
    
}
