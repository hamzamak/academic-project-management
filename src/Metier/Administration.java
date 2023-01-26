/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metier;

/**
 *
 * @author pc
 */
public class Administration {
    private    String nom_logging ; 
    private    String password_logging ; 
    private    String metier ;

    public Administration(String nom_logging, String password_logging , String metier) {
        this.nom_logging = nom_logging;
        this.password_logging = password_logging;
        this.metier=metier ;
    }

    public String getNom_logging() {
        return nom_logging;
    }

    public void setNom_logging(String nom_logging) {
        this.nom_logging = nom_logging;
    }

    public String getPassword_logging() {
        return password_logging;
    }

    public void setPassword_logging(String password_logging) {
        this.password_logging = password_logging;
    }

    public String getMetier() {
        return metier;
    }

    public void setMetier(String metier) {
        this.metier = metier;
    }
    
    
}
