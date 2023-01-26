/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistance.DAO;

import Metier.Etudiant;
import Persistance.Connexion_SQL;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author post21
 */
public class DaoEtudiant implements InterfaceDAOEtudiant {

    java.sql.Connection cnx = null;
    java.sql.PreparedStatement prepared = null;
    ResultSet resultat = null;

    public DaoEtudiant() {
        cnx = Connexion_SQL.ConnectDB();
    }

    @Override
    public ArrayList<Etudiant> getAll() {
        String sql = "select * from etudiant ";
        ArrayList<Etudiant> list = new ArrayList<>();
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {
                Integer id = resultat.getInt("id_etd");
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                String email = resultat.getString("email");
                String niveau = resultat.getString("niveau");
                Integer filiere = resultat.getInt("filiere");
                list.add(new Etudiant(id, nom, prenom, email, niveau, filiere));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoEtudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Etudiant getEtudiantByID(Integer ID) {
        String sql = "select * from etudiant where id_etd='" + ID + "'";
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {
                Integer id = resultat.getInt("id_etd");
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                String email = resultat.getString("email");
                String niveau = resultat.getString("niveau");
                Integer filiere = resultat.getInt("filiere");
                return new Etudiant(id, nom, prenom, email, niveau, filiere);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoEtudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void addEtudiant(Etudiant etd) {
        String sql = "insert into etudiant (nom,prenom , email,niveau,filiere) values (?,?,?,?,?) ";
        try {
            prepared = cnx.prepareStatement(sql);

            prepared.setString(1, etd.getNom());
            prepared.setString(2, etd.getPrenom());
            prepared.setString(3, etd.getEmail());
            prepared.setString(4, etd.getNiveau());
            prepared.setInt(5, etd.getID_Filiere());
            prepared.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DaoEtudiant.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    // remplacer AncienEtd (on a besoin juste son ID) par newEtd informations : nom,prenom ... ID ne sera pas modifie
    public void updateEtudiant(Etudiant AncienEtd, Etudiant newEtd) {
        String sql = "update  etudiant set nom=?,prenom=?,email=?,niveau=?,filiere=? where id_etd='" + AncienEtd.getID() + "'";

        try {
            prepared = cnx.prepareStatement(sql);

            prepared.setString(1, newEtd.getNom());
            prepared.setString(2, newEtd.getPrenom());
            prepared.setString(3, newEtd.getEmail());
            prepared.setString(4, newEtd.getNiveau());
            prepared.setInt(5, newEtd.getID_Filiere());
            prepared.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DaoEtudiant.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void deleteEtudiant(Integer ID) {
        String sql = "delete from  etudiant where id_etd='" + ID + "'";

        try {
            prepared = cnx.prepareStatement(sql);
                prepared.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DaoEtudiant.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void ImprimerListeEtudiant(String chemin) {
        Document doc = new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(chemin));
            doc.open();
            // Inserer image dans PDF
            Image img = Image.getInstance("src\\Images\\EtdImprimer.jpg");
            img.scaleAbsoluteWidth(500);
            img.scaleAbsoluteHeight(260);
            img.setAlignment(Image.ALIGN_CENTER);
            doc.add(img);
            doc.add(new Paragraph("Gestion Etudiant \n\n", FontFactory.getFont("Comic Sans MS", 24)));

            PdfPTable table = new PdfPTable(4); // contient 4 colones chaque ligne
            table.setWidthPercentage(100);

            PdfPCell cell;
            // heade table -> ligne 1 du tableau 
            cell = new PdfPCell(new Phrase("Prenom", FontFactory.getFont("Comic Sans MS", 12)));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Nom", FontFactory.getFont("Comic Sans MS", 12)));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("email", FontFactory.getFont("Comic Sans MS", 12)));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("niveau", FontFactory.getFont("Comic Sans MS", 12)));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);

            String sql = "select prenom,nom,email,niveau from etudiant";
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {
                cell = new PdfPCell(new Phrase(resultat.getString("prenom"), FontFactory.getFont("Arial", 10)));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(resultat.getString("nom"), FontFactory.getFont("Arial", 10)));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(resultat.getString("email"), FontFactory.getFont("Arial", 10)));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(resultat.getString("niveau"), FontFactory.getFont("Arial", 10)));
                table.addCell(cell);

            }
            // En fin ajouter tous les cellules a table 
            doc.add(table);
            doc.close();
            Desktop.getDesktop().open(new File(chemin));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException | DocumentException ex) {
            Logger.getLogger(DaoEtudiant.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void ShowIntable(JTable tableEtd) {
        String sql = "select* from etudiant ";
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();

            tableEtd.setModel(DbUtils.resultSetToTableModel(resultat));

        } catch (SQLException ex) {
            Logger.getLogger(DaoEtudiant.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void ShowIntableMembreDoctorat(JTable table, int id_lab) {
        String sql = """
                     select id_etd,nom,prenom  FROM (
                     SELECT *
                     FROM etudiant
                     INNER JOIN projet ON etudiant.id_etd = projet.etudiant ) as Tableau
                     WHERE niveau ='Doctorat' and laboratoire='"""+id_lab+"'";
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(resultat));

        } catch (SQLException ex) {
            Logger.getLogger(DaoProfesseur.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
