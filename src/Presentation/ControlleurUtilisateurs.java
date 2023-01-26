/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentation;

import Metier.GestionUtilisateurs;
import Metier.Utilisateurs;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class ControlleurUtilisateurs {
    // Patern pour verifie la securite du mot de passe
    //Cette expression régulière fait référence à un modèle avec au moins un chiffre,
    //une lettre majuscule, une lettre minuscule et un symbole spécial ("@#$%").
    // au moins 6 caracteres maximum 15 
    private static final String PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})";
	
    GestionUtilisateurs gestionUtilisateurs;

    public ControlleurUtilisateurs() {
        gestionUtilisateurs = new GestionUtilisateurs();
    }

    public Utilisateurs getUserByID(Integer id_user) {
        return gestionUtilisateurs.getUserByID(id_user);
    }

    public ArrayList<Utilisateurs> getAll() {
        return gestionUtilisateurs.getAll();
    }

    public void ShowIntable(JTable tableUtilisateurs) {
        gestionUtilisateurs.ShowIntable(tableUtilisateurs);

    }

    public boolean verifieUserName(String userName) {
        return gestionUtilisateurs.verifieUserName(userName);
    }

    public boolean addUser(Utilisateurs user) {
        Pattern pattern = Pattern.compile(PATTERN);
         Matcher matcher = pattern.matcher(user.getPassword());
        if (user.getUserName().isBlank() || user.getPassword().isBlank()
                || verifieUserName(user.getUserName()) || !matcher.matches()) {
            if (verifieUserName(user.getUserName())) {
                JOptionPane.showMessageDialog(null, "Essayer un autre nom", "Champ nom deja pris", JOptionPane.WARNING_MESSAGE);
            }
            else if (!matcher.matches()) {
                JOptionPane.showMessageDialog(null, "la securite du Mot de passe est faible\n"
                        + "*Essayer d'inserer au moins un chiffre\n*une lettre majuscule\n*"
                        + "une lettre minuscule\n*un symbole spécial (\"@#$%\")\n*Le mot de passe doit avoir au moins 6 caracteres maximum 15", "Champ mot de passe est invalide", JOptionPane.WARNING_MESSAGE);
            }
            else
            JOptionPane.showMessageDialog(null, "veuillez saisie tous les champs", "Champs invalide", JOptionPane.WARNING_MESSAGE);
        } else {

            gestionUtilisateurs.addUser(user);
            JOptionPane.showMessageDialog(null, "user " +user.getUserName()
                    +" a ete ajoute");
            return true ;
        }
                return false ;
    }

    public boolean updateUser(JTable tableUtilisateurs, Utilisateurs user) {
         Pattern pattern = Pattern.compile(PATTERN);
         Matcher matcher = pattern.matcher(user.getPassword());
        int indice = tableUtilisateurs.getSelectedRow();
        if (indice != - 1) {
           if (user.getUserName().isBlank() || user.getPassword().isBlank()
                || verifieUserName(user.getUserName()) || !matcher.matches()) {
            if (verifieUserName(user.getUserName())) {
                JOptionPane.showMessageDialog(null, "Essayer un autre nom", "Champ nom deja pris", JOptionPane.WARNING_MESSAGE);
            }
            else if (!matcher.matches()) {
                JOptionPane.showMessageDialog(null, "la securite du Mot de passe est faible\n"
                        + "*Essayer d'inserer au moins un chiffre\n*une lettre majuscule\n*"
                        + "une lettre minuscule\n*un symbole spécial (\"@#$%\")\n*Le mot de passe doit avoir au moins 6 caracteres maximum 15", "Champ mot de passe est invalide", JOptionPane.WARNING_MESSAGE);
            }
            else
            JOptionPane.showMessageDialog(null, "veuillez saisie tous les champs", "Champs invalide", JOptionPane.WARNING_MESSAGE);
         } else {
                String idUser = tableUtilisateurs.getModel().getValueAt(indice, 0).toString();
                gestionUtilisateurs.updateUtilisateurs(gestionUtilisateurs.getUserByID(Integer.parseInt(idUser)), user);
                JOptionPane.showMessageDialog(null, "Modification est reussite");
                return true ;
            }
        } else {
            JOptionPane.showMessageDialog(null, "veuillez selectionner une ligne !! ", "aucune ligne est selectionnee", JOptionPane.WARNING_MESSAGE);
        }
            return false ;
    }

    public void deleteUtilisateurs(JTable tableUtilisateurs) {
        int indice = tableUtilisateurs.getSelectedRow();
        if (indice != -1) {
            String id = tableUtilisateurs.getModel().getValueAt(indice, 0).toString();
            int reponse = JOptionPane.showConfirmDialog(null, "Vous voulez Supprimer cet utilisateur", "Suppression d'un utilisateur", JOptionPane.YES_NO_OPTION);
            if (reponse == JOptionPane.YES_OPTION) {
                gestionUtilisateurs.deleteUtilisateurs(Integer.parseInt(id));
            }
        } else {
            JOptionPane.showMessageDialog(null, "veuillez selectionner une ligne !! ", "aucune ligne est selectionnee", JOptionPane.WARNING_MESSAGE);
        }

    }
}
