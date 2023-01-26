
package Metier;

public class Departement {
    private Integer ID ;
    private String nom ;
    private  String email; 

    public Departement(Integer ID, String nom, String email) {
        this.ID = ID;
        this.nom = nom;
        this.email = email;
    }
     public Departement( String nom, String email) {
        
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
