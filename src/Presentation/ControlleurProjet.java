
package Presentation;

import Metier.Entreprise;
import Metier.Etudiant;
import Metier.GestionEntreprise;
import Metier.GestionEtudiant;
import Metier.GestionLaboratoire;
import Metier.GestionProjets;
import Metier.Laboratoire;
import Metier.Projets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author pc
 */
public class ControlleurProjet {

    GestionProjets gestionProjet;
    GestionEtudiant gestionEtudiant;
    GestionLaboratoire gestionlab;
    GestionEntreprise gestionEntreprise;

    public ControlleurProjet() {
        gestionProjet = new GestionProjets();
        gestionEtudiant = new GestionEtudiant();
        gestionlab = new GestionLaboratoire();
        gestionEntreprise = new GestionEntreprise();
    }

    public int getDurree(int idProjet) {
        return gestionProjet.getDurree(idProjet);
    }

    public java.sql.Date getDateDepart(int id) {

        return gestionProjet.getDateDepart(id);
    }

    public Calendar getCalenderDateFin(java.sql.Date date_depart, int duree) {
        return gestionProjet.getCalenderDateFin(date_depart, duree);
    }

    public void deleteProjet(JTable tableProjet) {
        int indice = tableProjet.getSelectedRow();
        if (indice != - 1) {
            String idPrj = tableProjet.getModel().getValueAt(indice, 0).toString();
            int id = Integer.parseInt(idPrj);

            int a = JOptionPane.showConfirmDialog(null, "Vous Voulez Vraiment Supprimer ce projet ", "Suppression d'un projet", JOptionPane.YES_NO_OPTION);
            if (a == JOptionPane.YES_OPTION) { // ou a == 0
                gestionProjet.deleteProjet(id);
                JOptionPane.showMessageDialog(null, "Suppression est reussite");

            }
        } else {
            JOptionPane.showMessageDialog(null, "veuillez selectionner une ligne !! ", "aucun ligne est selectionnee", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void ShowIntablePFE_PFA(JTable tableProjet) {
        gestionProjet.ShowIntablePFE_PFA(tableProjet);
    }

    public DefaultComboBoxModel<String> initializeModelEtud_2emeAnnee() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Etudiant etudiant : gestionEtudiant.getEtudiants_2emeAnnee()) {
            String FullName = etudiant.getID() + " " + etudiant.getNom() + " " + etudiant.getPrenom();
            model.addElement(FullName);
        }
        return model;
    }

    public DefaultComboBoxModel<String> initializeModelEtud_3emeAnnee() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Etudiant etudiant : gestionEtudiant.getEtudiants_3emeAnnee()) {
            String FullName = etudiant.getID() + " " + etudiant.getNom() + " " + etudiant.getPrenom();
            model.addElement(FullName);
        }
        return model;
    }

    public DefaultComboBoxModel<String> initializeModelDoctorant() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Etudiant etudiant : gestionEtudiant.getEtudiantsDoctorants()) {
            String FullName = etudiant.getID() + " " + etudiant.getNom() + " " + etudiant.getPrenom();
            model.addElement(FullName);
        }
        return model;
    }

    public void ShowIntableDoctorat(JTable tableProjetDoctorat) {
        gestionProjet.ShowIntableDoctorat(tableProjetDoctorat);
    }

    public DefaultComboBoxModel<String> initializeModelLab() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Laboratoire lab : gestionlab.getAll()) {
            String labName = lab.getNom();
            model.addElement(labName);
        }
        return model;
    }

    public DefaultComboBoxModel<String> initializeModelEntreprise() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Entreprise entrep : gestionEntreprise.getAll()) {
            String raison = entrep.getRaison();
            model.addElement(raison);
        }
        return model;
    }

    public Projets getProjetById(Integer ID) {
        return gestionProjet.getProjetById(ID);
    }

    public Calendar getCalender(String date) {
        return gestionProjet.getCalender(date);
    }

    public boolean rechercheEtdById(int idEtudiant) {
        return gestionProjet.rechercheEtdById(idEtudiant);
    }

    public boolean addProjetPFA_PFE(Projets projet, Calendar c) {

        int mois = c.get(Calendar.MONTH);
        // on verifie si tous les champs sont remplis avec des caracteres pas espace blancs ou vide
        if (projet.getTitre().isBlank() || (projet.getIDEntrep() == null && projet.getIDLab() == null)
                || (projet.getType_projet() == null) || projet.getIDEtudiant() == -1) {

            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Champs invalides", JOptionPane.WARNING_MESSAGE);
            if (projet.getIDEtudiant() == -1) {
                JOptionPane.showMessageDialog(null, "Aucun etudiant existe \nveuillez d'abord ajouter les etudiants", "Etudiants introuvables", JOptionPane.WARNING_MESSAGE);
            }
            if ((projet.getIDEntrep() == null && projet.getIDLab() == null)) {
                JOptionPane.showMessageDialog(null, "Aucun lieu a ete detecte\nveuillez d'abord ajouter les lieux de stage\nou veuillez choisir un lieu", "Lieux introuvbles", JOptionPane.WARNING_MESSAGE);
            }
            return false;
        } else {
            int Spin = projet.getDuree();

            if (Spin != 2 && projet.getType_projet().equalsIgnoreCase("PFA")) {
                JOptionPane.showMessageDialog(null, "les projets PFA durent 2mois ", "Duree du projet est invalide", JOptionPane.ERROR_MESSAGE);
            } else if ((Spin > 6 || Spin < 5) && projet.getType_projet().equalsIgnoreCase("PFE")) {
                JOptionPane.showMessageDialog(null, " les projets PFE durent 5 a 6 mois", "Duree du projet est invalide", JOptionPane.ERROR_MESSAGE);

            } else if (mois != 6 && projet.getType_projet().equalsIgnoreCase("PFA")) {
                JOptionPane.showMessageDialog(null, " les projets PFA  commence le Juin au plus tot", "Date de depart du projet est invalide", JOptionPane.ERROR_MESSAGE);
            } else if (mois != 2 && projet.getType_projet().equalsIgnoreCase("PFE")) {
                JOptionPane.showMessageDialog(null, " les projets PFE  commence le Fevrier", "Date de depart du projet est invalide", JOptionPane.ERROR_MESSAGE);
            } else if (rechercheEtdById(projet.getIDEtudiant())) {
                java.sql.Date DateDepEtdRecent = getDateDepartByIDEtud(projet.getIDEtudiant());
                int DureeEtdRecent = getDurreeByIDEtud(projet.getIDEtudiant());

                if (!c.after(getCalenderDateFin(DateDepEtdRecent, DureeEtdRecent))) {
                    Etudiant etud = gestionEtudiant.getEtudiantByID(projet.getIDEtudiant());
                    String nomCompletEtudiant = etud.getNom() + " " + etud.getPrenom();
                    JOptionPane.showMessageDialog(null, "L'Etudiant " + nomCompletEtudiant + " ne peut pas avoir deux projets en meme temps", "Erreur Affectation du projet", JOptionPane.ERROR_MESSAGE);
                    return false;
                } else {
                    gestionProjet.addProjet(projet);
                    JOptionPane.showMessageDialog(null, "Le projet " + projet.getType_projet() + " " + " est ajoute ", "Creation d'un projet", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }
            } else {
                gestionProjet.addProjet(projet);
                JOptionPane.showMessageDialog(null, "Le projet " + projet.getType_projet() + " " + " est ajoute ", "Creation d'un projet", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
            return false;
        }

    }

    public boolean updateProjet(Projets projet, JTable tableProjet, Calendar c) {
        int indice = tableProjet.getSelectedRow();
        if (indice != - 1) {
            SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
            int mois = c.get(Calendar.MONTH);
            int year_c = c.get(Calendar.YEAR);

            String idprojet = tableProjet.getModel().getValueAt(indice, 0).toString();
            java.sql.Date date_from_table = getDateDepart(Integer.parseInt(idprojet));
            String date = sp.format(date_from_table);

            //on utilise Calender pour faciliter la comparaison entre les dates  apres 
            Calendar c_from_table = getCalender(date);
            int year_c_from_table = c_from_table.get(Calendar.YEAR);

            // on verifie si tous les champs sont remplis avec des caracteres pas espace blancs ou vide
            if (projet.getTitre().isBlank() || (projet.getIDEntrep() == null && projet.getIDLab() == null)
                    || (projet.getType_projet() == null) || projet.getIDEtudiant() == -1) {

                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Champs invalides", JOptionPane.WARNING_MESSAGE);
                 if (projet.getIDEtudiant() == -1) {
                JOptionPane.showMessageDialog(null, "Aucun etudiant existe \nveuillez d'abord ajouter les etudiants", "Etudiants introuvble", JOptionPane.WARNING_MESSAGE);
            }
            if ((projet.getIDEntrep() == null && projet.getIDLab() == null)) {
                JOptionPane.showMessageDialog(null, "Aucun lieu a ete detecte\nveuillez d'abord ajouter les lieux de stage\nou veuillez choisir un lieu", "Lieu introuvable", JOptionPane.WARNING_MESSAGE);
            }
                return false;
            } else {
                int Spin = projet.getDuree();

                if (Spin != 2 && projet.getType_projet().equalsIgnoreCase("PFA")) {
                    JOptionPane.showMessageDialog(null, "les projets PFA durent 2mois ", "Duree du projet est invalide", JOptionPane.ERROR_MESSAGE);
                } else if ((Spin > 6 || Spin < 5) && projet.getType_projet().equalsIgnoreCase("PFE")) {
                    JOptionPane.showMessageDialog(null, " les projets PFE durent 5 a 6 mois", "Duree du projet est invalide", JOptionPane.ERROR_MESSAGE);

                } else if (mois != 6 && projet.getType_projet().equalsIgnoreCase("PFA")) {
                    JOptionPane.showMessageDialog(null, " les projets PFA  commence le Juin au plus tot", "Date de depart du projet est invalide", JOptionPane.ERROR_MESSAGE);
                } else if (mois != 2 && projet.getType_projet().equalsIgnoreCase("PFE")) {
                    JOptionPane.showMessageDialog(null, " les projets PFE  commence le Fevrier", "Date de depart du projet est invalide", JOptionPane.ERROR_MESSAGE);
                } else if (c.before(c_from_table) || year_c != year_c_from_table) {

                    Etudiant etud = gestionEtudiant.getEtudiantByID(projet.getIDEtudiant());
                    String nomCompletEtudiant = etud.getNom() + " " + etud.getPrenom();

                    JOptionPane.showMessageDialog(null, "*L'etudiant " + nomCompletEtudiant + " ne peut pas avoir deux projets en meme temps \n"
                            + "* il ne faut pas modifier la date de depart a une date inferiure\n"
                            + "* La modification de la date ne doit pas toucher l'annee du date de depart", "Erreur Affectation du projet", JOptionPane.ERROR_MESSAGE);

                    return false;
                } else {

                    JOptionPane.showMessageDialog(null, "Le projet " + projet.getType_projet() + " est modifie ", "Modification d'un projet", JOptionPane.INFORMATION_MESSAGE);
                    gestionProjet.updateProjet(getProjetById(Integer.parseInt(idprojet)), projet);
                    return true;
                }

                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "selectionner une ligne!!");
            return false;
        }

    }

    public java.sql.Date getDateDepartByIDEtud(int idEtudiant) {
        return gestionProjet.getDateDepartByIDEtud(idEtudiant);
    }

    public int getDurreeByIDEtud(int IDEtud) {
        return gestionProjet.getDurreeByIDEtud(IDEtud);
    }

    public boolean addProjetDoctorat(Projets projet, Calendar c) {

        int mois = c.get(Calendar.MONTH);
        // on verifie si tous les champs sont remplis avec des caracteres pas espace blancs ou vide
        if (projet.getTitre().isBlank()
                || (projet.getIDLab() == null) || projet.getIDEtudiant() == -1) {

            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Champs invalides", JOptionPane.WARNING_MESSAGE);
            if (projet.getIDEtudiant() == -1) {
                JOptionPane.showMessageDialog(null, "Aucun etudiant existe \nveuillez d'abord ajouter les etudiants", "Etudiants introuvble", JOptionPane.WARNING_MESSAGE);
            }
            if ((projet.getIDLab() == null)) {
                JOptionPane.showMessageDialog(null, "Aucun lieu a ete detecte\nveuillez d'abord ajouter les lieux de stage\nou veuillez choisir un lieu", "Lieu introuvble", JOptionPane.WARNING_MESSAGE);
            }
            return false;
        } else {
            int Spin = projet.getDuree();

            if (Spin > 6 * 12 || Spin < 3 * 12) {
                JOptionPane.showMessageDialog(null, "les projets Doctorats durent 3 a 6 ans ", "Duree du projet est invalide", JOptionPane.ERROR_MESSAGE);
            } else if (mois != 10) {
                JOptionPane.showMessageDialog(null, " le projets Doctorats demarrent en October ", "Date de depart du projet est invalide", JOptionPane.ERROR_MESSAGE);

            } else if (rechercheEtdById(projet.getIDEtudiant())) {
                java.sql.Date DateDepEtdRecent = getDateDepartByIDEtud(projet.getIDEtudiant());
                int DureeEtdRecent = getDurreeByIDEtud(projet.getIDEtudiant());

                if (!c.after(getCalenderDateFin(DateDepEtdRecent, DureeEtdRecent))) {
                    Etudiant etud = gestionEtudiant.getEtudiantByID(projet.getIDEtudiant());
                    String nomCompletEtudiant = etud.getNom() + " " + etud.getPrenom();
                    JOptionPane.showMessageDialog(null, "L'Etudiant " + nomCompletEtudiant + " ne peut pas avoir deux projets en meme temps", "Erreur Affectation du projet", JOptionPane.ERROR_MESSAGE);
                    return false;
                } else {
                    gestionProjet.addProjet(projet);
                    JOptionPane.showMessageDialog(null, "Le projet " + projet.getType_projet() + " " + " est ajoute ", "Creation d'un projet", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }
            } else {
                gestionProjet.addProjet(projet);
                JOptionPane.showMessageDialog(null, "Le projet " + projet.getType_projet() + " " + " est ajoute ", "Creation d'un projet", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
            return false;
        }

    }

    public boolean updateProjetDoctorat(Projets projet, JTable tableProjet, Calendar c) {
        int indice = tableProjet.getSelectedRow();
        if (indice != - 1) {
            SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
            int mois = c.get(Calendar.MONTH);
            int year_c = c.get(Calendar.YEAR);

            String idprojet = tableProjet.getModel().getValueAt(indice, 0).toString();
            
            java.sql.Date date_from_table = getDateDepart(Integer.parseInt(idprojet));
            String date = sp.format(date_from_table);

            //on utilise Calender pour faciliter la comparaison entre les dates  apres 
            Calendar c_from_table = getCalender(date);
         
            int year_c_from_table = c_from_table.get(Calendar.YEAR);

            // on verifie si tous les champs sont remplis avec des caracteres pas espace blancs ou vide
            if (projet.getTitre().isBlank()
                    || (projet.getIDLab() == null) || projet.getIDEtudiant() == -1) {

                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Champs invalides", JOptionPane.WARNING_MESSAGE);
                if (projet.getIDEtudiant() == -1) {
                    JOptionPane.showMessageDialog(null, "Aucun etudiant existe \nveuillez d'abord ajouter les etudiants", "Etudiants introuvble", JOptionPane.WARNING_MESSAGE);
                }
                if ((projet.getIDLab() == null)) {
                    JOptionPane.showMessageDialog(null, "Aucun lieu a ete detecte\nveuillez d'abord ajouter les lieux de stage\nou veuillez choisir un lieu", "Lieu introuvble", JOptionPane.WARNING_MESSAGE);
                }
                return false;
            } else {
                int Spin = projet.getDuree();

                if (Spin > 6 * 12 || Spin < 3 * 12) {
                    JOptionPane.showMessageDialog(null, "les projets Doctorats durent 3 a 6 ans ", "Duree du projet est invalide", JOptionPane.ERROR_MESSAGE);
                } else if (mois != 10) {
                    JOptionPane.showMessageDialog(null, " le projets Doctorats demarrent en October ", "Date de depart du projet est invalide", JOptionPane.ERROR_MESSAGE);

                } else if (c.before(c_from_table) || year_c != year_c_from_table) {

                    Etudiant etud = gestionEtudiant.getEtudiantByID(projet.getIDEtudiant());
                    String nomCompletEtudiant = etud.getNom() + " " + etud.getPrenom();

                    JOptionPane.showMessageDialog(null, "*L'etudiant " + nomCompletEtudiant + " ne peut pas avoir deux projets en meme temps \n"
                            + "* il ne faut pas modifier la date de depart a une date inferiure\n"
                            + "* La modification de la date ne doit pas toucher l'annee du date de depart", "Erreur Affectation du projet", JOptionPane.ERROR_MESSAGE);

                    return false;
                } else {

                    
                    JOptionPane.showMessageDialog(null, "Le projet Doctorat est modifie ", "Modification d'un projet", JOptionPane.INFORMATION_MESSAGE);
                    gestionProjet.updateProjet(getProjetById(Integer.parseInt(idprojet)), projet);
                    return true;
                }

                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "selectionner une ligne!!");
            return false;
        }

    }
      public void deleteProjetByIDetud(int ID_etud) {
          gestionProjet.deleteProjetByIDetud(ID_etud);
       }
      
       public ArrayList<Projets> getAll() {
        return gestionProjet.getAll();
    }
}
