/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistance.DAO;

import Metier.Administration;
import java.util.ArrayList ;
/**
 *
 * @author pc
 */
public interface InterfaceDAOAdministration {
   boolean SeConnecter(Administration admin);
   //boolean Mot_Passe_oublie();
    ArrayList <Administration> getAll() ; 
    String getPassword(String username);
}
