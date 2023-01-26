/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metier;

/**
 *
 * @author pc
 */
public class Etape {

    private Integer ID;
    private String titre;
    private Integer duree;
    private String etape_depart ="Pas definie";
    private String documentation;
    private String livraison;
    private Integer IDProfesseur;
    private Integer IDProjet;

    public Etape(Integer ID, String titre, Integer duree, String etape_depart, String documentation, String livraison, Integer IDProfesseur, Integer IDProjet) {
        this.ID = ID;
        this.titre = titre;
        this.duree = duree;
        this.etape_depart = etape_depart;
        this.documentation = documentation;
        this.livraison = livraison;
        this.IDProfesseur = IDProfesseur;
        this.IDProjet = IDProjet;
    }
    
     public Etape(String titre, Integer duree, String etape_depart, String documentation, String livraison, Integer IDProfesseur, Integer IDProjet) {
       
        this.titre = titre;
        this.duree = duree;
        this.etape_depart = etape_depart;
        this.documentation = documentation;
        this.livraison = livraison;
        this.IDProfesseur = IDProfesseur;
        this.IDProjet = IDProjet;
    }
    
   
    public Etape( String titre, Integer duree, String documentation, String livraison, Integer IDProfesseur, Integer IDProjet) {
        this.titre = titre;
        this.duree = duree;
        this.documentation = documentation;
        this.livraison = livraison;
        this.IDProfesseur = IDProfesseur;
        this.IDProjet = IDProjet;
    }
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
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

    public String getEtape_depart() {
        return etape_depart;
    }

    public void setEtape_depart(String etape_depart) {
        this.etape_depart = etape_depart;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public String getLivraison() {
        return livraison;
    }

    public void setLivraison(String livraison) {
        this.livraison = livraison;
    }

    public Integer getIDProfesseur() {
        return IDProfesseur;
    }

    public void setIDProfesseur(Integer IDProfesseur) {
        this.IDProfesseur = IDProfesseur;
    }

    public Integer getIDProjet() {
        return IDProjet;
    }

    public void setIDProjet(Integer IDProjet) {
        this.IDProjet = IDProjet;
    }
    

}
