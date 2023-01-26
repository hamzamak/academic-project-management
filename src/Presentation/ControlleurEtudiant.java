package Presentation;

import Metier.Etudiant;
import Metier.Filiere;
import Metier.GestionEtudiant;
import Metier.GestionFiliere;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ControlleurEtudiant {
    // Patern pour verifie email 

    private static final String PATTERN = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    GestionEtudiant gestionEtd;
    GestionFiliere gestionFiliere;

    public ControlleurEtudiant() {
        gestionEtd = new GestionEtudiant();
        gestionFiliere = new GestionFiliere();
    }

    public boolean addEtudiant(Etudiant etudiant) {
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(etudiant.getEmail());
        if (etudiant.getNom().isBlank() || etudiant.getPrenom().isBlank() || etudiant.getEmail().isBlank()
                || etudiant.getID_Filiere() == -1 || !matcher.matches()) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Champs invalides", JOptionPane.WARNING_MESSAGE);
            if (etudiant.getID_Filiere() == -1) {
                JOptionPane.showMessageDialog(null, "Aucune filiere a ete trouvee\nveuillez d'abord ajouter des filieres", "filieres introuvables", JOptionPane.WARNING_MESSAGE);

            } else if (!matcher.matches()) {
                JOptionPane.showMessageDialog(null, "le champ e-mail est mal saisie", "Champ e-mail est invalide", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "veuillez saisie tous les champs", "Champs invalide", JOptionPane.WARNING_MESSAGE);
            }

        } else {
            gestionEtd.addEtudiant(etudiant);
            JOptionPane.showMessageDialog(null, "L'etudiant " + etudiant.getNom() + " " + etudiant.getPrenom() + " est ajoute(e)", "Ajout d'un etudiant", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        return false;
    }

    public boolean updateEtudiant(Etudiant etudiant, JTable tableEtd) {
        int indice = tableEtd.getSelectedRow();
        if (indice != - 1) {
            Pattern pattern = Pattern.compile(PATTERN);
            Matcher matcher = pattern.matcher(etudiant.getEmail());
            if (etudiant.getNom().isBlank() || etudiant.getPrenom().isBlank() || etudiant.getEmail().isBlank()
                    || etudiant.getID_Filiere() == -1 || !matcher.matches()) {
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Champs invalides", JOptionPane.WARNING_MESSAGE);
                if (etudiant.getID_Filiere() == -1) {
                    JOptionPane.showMessageDialog(null, "Aucune filiere a ete trouvee\nveuillez d'abord ajouter des filieres", "filieres introuvables", JOptionPane.WARNING_MESSAGE);

                } else if (!matcher.matches()) {
                    JOptionPane.showMessageDialog(null, "le champ e-mail est mal saisie", "Champ e-mail est invalide", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "veuillez saisie tous les champs", "Champs invalide", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                String idE = tableEtd.getModel().getValueAt(indice, 0).toString();
                gestionEtd.updateEtudiant(gestionEtd.getEtudiantByID(Integer.parseInt(idE)), etudiant);
                JOptionPane.showMessageDialog(null, "Modification est reussite");
                return true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "veuillez selectionner une ligne !! ", "aucune ligne est selectionnee", JOptionPane.WARNING_MESSAGE);
        }

        return false;

    }

    public void deleteEtudiant(JTable tableEtd) {
        // Suppression par groupe  ou par personne
        int indices[]= tableEtd.getSelectedRows();
        int longueur = indices.length ;
        
        if(longueur != 0){
          int reponse = JOptionPane.showConfirmDialog(null, "*Vous voulez Supprimer le(s) etudiant(es)\n*Noter que vous supprimez aussi toutes les tables qui ont une relation avec cet etudiant ", "Suppression d'un etudiant", JOptionPane.YES_NO_OPTION);
            if (reponse == JOptionPane.YES_OPTION) {
            for(int i=0 ; i < longueur ; i++ ){
            String idE = tableEtd.getModel().getValueAt(indices[i], 0).toString();
            gestionEtd.deleteEtudiant(Integer.parseInt(idE));
            }
          }
        }
        else
        {
             JOptionPane.showMessageDialog(null, "veuillez selectionner une ligne !! ", "aucune ligne est selectionnee", JOptionPane.WARNING_MESSAGE);
        }
    /*    int indice = tableEtd.getSelectedRow();
        if (indice != - 1) {
            String idE = tableEtd.getModel().getValueAt(indice, 0).toString();

            gestionEtd.deleteEtudiant(Integer.parseInt(idE));

        } else {
            JOptionPane.showMessageDialog(null, "veuillez selectionner une ligne !! ", "aucune ligne est selectionnee", JOptionPane.WARNING_MESSAGE);
        }*/

    }

    public DefaultComboBoxModel<String> initializeModelFiliere() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Filiere filiere : gestionFiliere.getAll()) {
            model.addElement(filiere.getNom());
        }

        return model;
    }

    public void ShowIntable(JTable tableEtd) {
        gestionEtd.ShowIntable(tableEtd);
    }

    public Etudiant getEtudiantByID(Integer ID) {
        return gestionEtd.getEtudiantByID(ID);
    }

    public void ImprimerListeEtudiant(String chemin) {
        gestionEtd.ImprimerListeEtudiant(chemin);
    }

    public void ShowIntableMembreDoctorat(JTable table, int id_lab) {
        gestionEtd.ShowIntableMembreDoctorat(table, id_lab);
    }

    public boolean isNiveauValide(String niveau) {
        String tabNiveau[] = {"Master 2eme annee", "Master 3eme annee", "Doctorat"};
        
        for (String nv : tabNiveau) {
            if (nv.equals(niveau.trim())) {
                return true;
            }
        }
        return false;
    }

    public boolean isIDFiliereExiste(Integer id_filiere) {
        for (Filiere filiere : gestionFiliere.getAll()) {
            if (filiere.getID_Filiere() == id_filiere) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Etudiant> ListeValideExcel(ArrayList<Etudiant> liste) {
        Pattern pattern = Pattern.compile(PATTERN);
        ArrayList<Etudiant> listeModifie = new ArrayList<>(liste);
        int position = 0;
        for (Etudiant etudiant : liste) {
            position++;
            Matcher matcher = pattern.matcher(etudiant.getEmail());
            if (!matcher.matches() || !isIDFiliereExiste(etudiant.getID_Filiere())
                    || !isNiveauValide(etudiant.getNiveau())) {
                listeModifie.remove(etudiant);
                System.out.println("Input invalide At ligne " + position + " du fichier excel !!");
            }

        }
        return listeModifie;
    }

    public ArrayList<Etudiant> ExcelReading(String excelPath, Integer NumeroFeuille) {
        ArrayList<Etudiant> liste = new ArrayList<>();
        String nom = "";
        String prenom = "";
        String email = "";
        String niveau = "";
        Integer IDfiliere = -1;
        ArrayList<String> cellstring = new ArrayList<>();
        ArrayList<Integer> cellnumeric = new ArrayList<>();

        try {
            FileInputStream fichier = new FileInputStream(new File(excelPath));
            //créer une instance workbook qui fait référence au fichier xlsx 
            XSSFWorkbook wb = new XSSFWorkbook(fichier);
            // XSSFSheet sheet = wb.getSheetAt(0);
            Sheet sheet = wb.getSheetAt(0);
            int etat = 0;
            try {
                sheet = wb.getSheetAt(NumeroFeuille);
            } catch (java.lang.IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Sheet index " + NumeroFeuille + " is out of range ");
                etat = 1;
            }

            FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
            sheet.getLastRowNum();
            int nombreLigne = sheet.getLastRowNum(); // commence par 0 
            // ligne 0 pour nom des colones
            //     int nombreCol =  sheet.getRow(0).getLastCellNum() ; // 5
            if (nombreLigne > 0 && etat == 0 ) {
                for (int i = 1; i <= nombreLigne; i++) {
                    try {
                        Cell c = sheet.getRow(i).getCell(0);
                        nom = c.getStringCellValue();
                        Cell c1 = sheet.getRow(i).getCell(1);
                        prenom = c1.getStringCellValue();
                        Cell c2 = sheet.getRow(i).getCell(2);
                        email = c2.getStringCellValue();
                        Cell c3 = sheet.getRow(i).getCell(3);
                        niveau = c3.getStringCellValue().trim();

                        Cell c4 = sheet.getRow(i).getCell(4);

                        if (formulaEvaluator.evaluateInCell(c4).getCellType() == Cell.CELL_TYPE_NUMERIC) {
                            Double a = c4.getNumericCellValue();
                            IDfiliere = a.intValue();
                        }
                    } catch (Exception e) {
                        IDfiliere = -1;
                    }
                    liste.add(new Etudiant(nom, prenom, email, niveau, IDfiliere));
                      }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControlleurEtudiant.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControlleurEtudiant.class.getName()).log(Level.SEVERE, null, ex);
        }

        return liste;
    }

    public void addGroupEtudiant(String excelPah, Integer NumerFeuille) {
        ArrayList<Etudiant> liste = ListeValideExcel(ExcelReading(excelPah, NumerFeuille));
        if (liste != null) {
            for (Etudiant etudiant : liste) {
                gestionEtd.addEtudiant(etudiant);
            }
        }
    }
}
