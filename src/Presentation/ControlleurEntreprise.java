
package Presentation;

import Metier.Entreprise;
import Metier.GestionEntreprise;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author pc
 */
public class ControlleurEntreprise {

    // pour verifier e-mail
    private static final String PATTERN = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

    GestionEntreprise gestionEntreprise;

    public ControlleurEntreprise() {
        gestionEntreprise = new GestionEntreprise();
    }

    public boolean addEntreprise(Entreprise entrep) {
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(entrep.getEmail());

        if (entrep.getRaison().isBlank() || entrep.getAdresse().isBlank() || entrep.getEmail().isBlank()
                || entrep.getTel().isBlank() || entrep.getResponsable().isBlank() || !matcher.matches()) {
            if (!matcher.matches()) {
                JOptionPane.showMessageDialog(null, "le champ e-mail est mal saisie", "Champ e-mail est invalide", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Champs invalides", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            gestionEntreprise.addEntreprise(entrep);
            JOptionPane.showMessageDialog(null, "L'entreprise a ete  ajoutee ", "Ajout d'une entreprise", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        return false;
    }

    public boolean updateEntreprise(Entreprise entrep, JTable tableEntreprise) {
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(entrep.getEmail());
        int indice = tableEntreprise.getSelectedRow();
        if (indice != - 1) {
           if (entrep.getRaison().isBlank() || entrep.getAdresse().isBlank() || entrep.getEmail().isBlank()
                || entrep.getTel().isBlank() || entrep.getResponsable().isBlank() || !matcher.matches()) {
            if (!matcher.matches()) 
                JOptionPane.showMessageDialog(null, "le champ e-mail est mal saisie", "Champ e-mail est invalide", JOptionPane.WARNING_MESSAGE);
             else 
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Champs invalides", JOptionPane.WARNING_MESSAGE);
            
            } else {
                String idE = tableEntreprise.getModel().getValueAt(indice, 0).toString();
                gestionEntreprise.updateEntreprise(gestionEntreprise.getEntreprise(Integer.parseInt(idE)), entrep);
                JOptionPane.showMessageDialog(null, "Modification est reussite");
                return true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "veuillez selectionner une ligne !! ", "aucune ligne est selectionnee", JOptionPane.WARNING_MESSAGE);
        }
        return false;

    }

    public void deleteEntreprise(JTable tableEntreprise) {
        int indice = tableEntreprise.getSelectedRow();
        if (indice != - 1) {
            String idE = tableEntreprise.getModel().getValueAt(indice, 0).toString();

            gestionEntreprise.deletEntreprise(Integer.parseInt(idE));

        } else {
            JOptionPane.showMessageDialog(null, "veuillez selectionner une ligne !! ", "aucune ligne est selectionnee", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void ShowIntable(JTable tableEntreprise) {
        gestionEntreprise.ShowIntable(tableEntreprise);
    }

    public Entreprise getEntreprise(Integer ID) {
        return gestionEntreprise.getEntreprise(ID);
    }

    public void ImprimerListeEntreprise(String chemin) {
        gestionEntreprise.ImprimerListeEntreprise(chemin);
    }

    public Integer getIdEntrepriseByName(String raisonEntreprise) {
        return gestionEntreprise.getIdEntrepriseByName(raisonEntreprise);
    }
}
