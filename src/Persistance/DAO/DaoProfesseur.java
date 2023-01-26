
package Persistance.DAO;

import Metier.Professeur;
import Persistance.Connexion_SQL;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;


public class DaoProfesseur implements InterfaceDAOProfesseur{

    java.sql.Connection cnx = null;
    java.sql.PreparedStatement prepared = null;
    ResultSet resultat = null;

    public DaoProfesseur() {
        cnx = Connexion_SQL.ConnectDB();
    }

    @Override
    public ArrayList<Professeur> getAll() {
        String sql = "select * from professeur ";
        ArrayList<Professeur> list = new ArrayList<>();
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {
                Integer id = resultat.getInt("id_prof");
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                String email = resultat.getString("email");
                Integer departement = resultat.getInt("Departement");
                String grade = resultat.getString("grade");
                Integer lab = resultat.getInt("labo");
                String role = resultat.getString("role");
                String archive = resultat.getString("archive");
                list.add(new Professeur(id, nom, prenom, email, grade, departement, lab, role, archive));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProfesseur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Professeur getProfesseurByID(Integer ID) {
        String sql = "select * from professeur where id_prof='" + ID + "'";
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {
                Integer id = resultat.getInt("id_prof");
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                String email = resultat.getString("email");
                Integer departement = resultat.getInt("Departement");
                String grade = resultat.getString("grade");
                Integer lab = resultat.getInt("labo");
                String role = resultat.getString("role");
                String archive = resultat.getString("archive");
                return new Professeur(id, nom, prenom, email, grade, departement, lab, role, archive);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProfesseur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void addProfesseur(Professeur prof, boolean ismembre) {
        String sql = "insert into professeur (nom,prenom , email,departement,grade,labo,role) values (?,?,?,?,?,?,?) ";
        try {
            prepared = cnx.prepareStatement(sql);

            prepared.setString(1, prof.getNom());
            prepared.setString(2, prof.getPrenom());
            prepared.setString(3, prof.getEmail());
            prepared.setInt(4, prof.getID_Departement());
            prepared.setString(5, prof.getGrade());
            if (ismembre) {
                prepared.setInt(6, prof.getID_Lab());
            } else {
                prepared.setObject(6, null);
            }

            prepared.setString(7, prof.getRole());
            prepared.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DaoProfesseur.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override

    public void updateProfesseur(Professeur Ancienprof, Professeur newprof , boolean isMembre) {
        String sql = "update  professeur set nom=?,prenom=? , email=?,departement=?,grade=?,labo=?,role=? where id_prof='"+Ancienprof.getID()+"'";

        try {
           prepared = cnx.prepareStatement(sql);

            prepared.setString(1, newprof.getNom());
            prepared.setString(2, newprof.getPrenom());
            prepared.setString(3, newprof.getEmail());
            prepared.setInt(4, newprof.getID_Departement());
            prepared.setString(5, newprof.getGrade());
            if (isMembre) {
                prepared.setInt(6, newprof.getID_Lab());
            } else {
                prepared.setObject(6, null);
            }

            prepared.setString(7, newprof.getRole());
            prepared.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DaoProfesseur.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void deleteProfesseur(Integer ID_Prof) {
        String sql = "delete from professeur  where id_prof ='" + ID_Prof + "'";

        try {
            prepared = cnx.prepareStatement(sql);

            prepared.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DaoProfesseur.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*int reponse =   JOptionPane.showConfirmDialog(null, "*Vous voulez Supprimer ce professeur\n*Noter que vous supprimez aussi toutes les tables qui ont une relation avec cet etudiant ", "Suppression d'un etudiant", JOptionPane.YES_NO_OPTION);
               if(reponse == JOptionPane.YES_OPTION){
                   prepared.execute();
            }*/
    }

    public boolean isProfActive(int id_professeur) {
        String sql = "select Professeur from etape where Professeur ='" + id_professeur + "'";
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {
                if (resultat.wasNull()) {
                    return false;
                } else {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProfesseur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void ImprimerListeProfesseur(String chemin) {
        Document doc = new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(chemin));
            doc.open();
            // Inserer image dans PDF
            doc.open();
            /* Image img = Image.getInstance("C:\\Users\\pc\\Pictures\\cafe book.jpeg");
            img.scaleAbsoluteWidth(400);
            img.scaleAbsoluteHeight(400);
            img.setAlignment(Image.ALIGN_CENTER);
            doc.add(img);*/
            doc.add(new Paragraph("Gestion Des Professeurs \n\n"));

            PdfPTable table = new PdfPTable(6); // contient 4 colones chaque ligne
            table.setWidthPercentage(100);

            PdfPCell cell;
            // heade table -> ligne 1 du tableau
            cell = new PdfPCell(new Phrase("Nom", FontFactory.getFont("Comic Sans MS", 12)));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Prenom", FontFactory.getFont("Comic Sans MS", 12)));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("email", FontFactory.getFont("Comic Sans MS", 12)));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Departement", FontFactory.getFont("Comic Sans MS", 12)));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Grade", FontFactory.getFont("Comic Sans MS", 12)));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Role", FontFactory.getFont("Comic Sans MS", 12)));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);

            String sql = "select nom, prenom,email,Departement,grade,role  from professeur";
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {
                cell = new PdfPCell(new Phrase(resultat.getString("nom"), FontFactory.getFont("Arial", 10)));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(resultat.getString("prenom"), FontFactory.getFont("Arial", 10)));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(resultat.getString("email"), FontFactory.getFont("Arial", 10)));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(resultat.getString("Departement"), FontFactory.getFont("Arial", 10)));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(resultat.getString("grade"), FontFactory.getFont("Arial", 10)));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(resultat.getString("role"), FontFactory.getFont("Arial", 10)));
                table.addCell(cell);

            }
            // En fin ajouter tous les cellules a table
            doc.add(table);
            doc.close();
            Desktop.getDesktop().open(new File(chemin));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DaoProfesseur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException | DocumentException ex) {
            Logger.getLogger(DaoProfesseur.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void ShowIntable(JTable tableProf) {
        String sql = "select* from professeur ";
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();

            tableProf.setModel(DbUtils.resultSetToTableModel(resultat));

        } catch (SQLException ex) {
            Logger.getLogger(DaoProfesseur.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean isMembreLabo(int id_prof) {

        String sql = "select labo from professeur where id_prof = '" + id_prof + "'";
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {
                if (resultat.getObject("labo") == null) {

                    return false;
                } else {

                    return true;
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProfesseur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void ArchiverProf(Integer idProf ){
        
        try {
            String sql = "update   professeur set archive = ?  where id_prof ='" + idProf + "'"; 
            prepared = cnx.prepareStatement(sql);
            prepared.setString(1,"Oui");
            prepared.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DaoProfesseur.class.getName()).log(Level.SEVERE, null, ex);
        }
                
               
    }
    
    public void updateProfesseurSetStateArchive( int id) {
        String sql = "update  professeur set archive=? where id_prof='"+id+"'";

        try {
           prepared = cnx.prepareStatement(sql);

            prepared.setString(1, "Non");  
            prepared.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DaoProfesseur.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     // utilise dans setmodel tableau membre dans table Departement 
    // pour afficher les profs qui sont ds membres dans cette departement ayant comme id  depart ;
    
    public void ShowIntableMembreDepartement(JTable table, int depart) {
        String sql = "select id_prof,nom ,prenom,role from professeur where Departement='"+depart+"'";
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(resultat));

        } catch (SQLException ex) {
            Logger.getLogger(DaoProfesseur.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    // utilise dans setmodel tableau membre dans table Laboratoire 
    // pour afficher les profs qui sont ds membres dans cette labo ;
     public void ShowIntableMembreLab(JTable table, int id_lab) {
        String sql = "select id_prof,nom ,prenom,role from professeur where labo ='"+id_lab+"'";
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(resultat));

        } catch (SQLException ex) {
            Logger.getLogger(DaoProfesseur.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     
  
    

}
