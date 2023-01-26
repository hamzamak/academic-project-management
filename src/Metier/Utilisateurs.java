/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metier;

/**
 *
 * @author pc
 */
public class Utilisateurs {
    Integer ID ;
    String userName ;
    String password ;
    String metier ;

    public Utilisateurs(Integer ID, String userName, String password, String metier) {
        this.ID = ID;
        this.userName = userName;
        this.password = password;
        this.metier = metier;
    }
    public Utilisateurs( String userName, String password, String metier) {
       
        this.userName = userName;
        this.password = password;
        this.metier = metier;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMetier() {
        return metier;
    }

    public void setMetier(String metier) {
        this.metier = metier;
    }
    
    
}
