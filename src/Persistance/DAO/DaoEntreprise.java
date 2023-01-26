
package Persistance.DAO;

import Metier.Entreprise;
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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;


public class DaoEntreprise implements InterfaceDAOEntreprise{
     java.sql.Connection cnx = null;
    java.sql.PreparedStatement prepared = null;
    ResultSet resultat = null;
    
    public DaoEntreprise() {
        cnx =   Connexion_SQL.ConnectDB();
    }
    
     @Override
     public  ArrayList<Entreprise> getAll(){
        ArrayList<Entreprise> liste  = new ArrayList<>();
         String sql = "select * from entreprise";
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {
                Integer ID = resultat.getInt("id_entreprise");
                String raison = resultat.getString("raisonSociale");
                String adresse = resultat.getString("adresse");
                
                String email = resultat.getString("email");
                String tel = resultat.getString("tel");
                String responsable = resultat.getString("responsable");
                liste.add(new Entreprise(ID,raison, email, adresse, tel, responsable));
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DaoEntreprise.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liste ;
    }
     @Override
      public  Entreprise getEntreprise(Integer ID){
        String sql="select * from entreprise where id_entreprise='"+ID+"'";
        
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {
              
                String raison = resultat.getString("raisonSociale");
                String adresse = resultat.getString("adresse");
                
                String email = resultat.getString("email");
                String tel = resultat.getString("tel");
                String responsable = resultat.getString("responsable");
                
                return new Entreprise(ID,raison, email, adresse, tel, responsable);
              
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DaoEntreprise.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null ;
    }
     @Override
       public  Integer getIdEntrepriseByName(String raisonEntreprise){
        String sql="select id_entreprise from entreprise where raisonSociale='"+raisonEntreprise+"'";
         Integer ID = -1 ;
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {
                ID = resultat.getInt("id_entreprise");
              
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DaoEntreprise.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ID ;
    }
       
     @Override
        public void ShowIntable(JTable tableEntreprise) {
        String sql = "select* from entreprise "; 
        try {
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();

            tableEntreprise.setModel(DbUtils.resultSetToTableModel(resultat));

        } catch (SQLException ex) {
            Logger.getLogger(DaoEntreprise.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
     @Override
    public void addEntreprise(Entreprise entrep) {
      String sql = "insert into entreprise (raisonSociale,adresse ,tel, email,responsable) values (?,?,?,?,?) ";
        try {
            prepared =cnx.prepareStatement(sql);
                 prepared = cnx.prepareStatement(sql);
                prepared.setString(1,entrep.getRaison());
                prepared.setString(2, entrep.getAdresse());
                 prepared.setString(3, entrep.getTel());
                prepared.setString(4, entrep.getEmail()); 
                prepared.setString(5, entrep.getResponsable());
                prepared.execute();
                
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEntreprise.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
     @Override
     // remplacer AncienEntrep (on a besoin juste son ID) par newEntrep informations : raisonSociale,adresse ... ID ne sera pas modifie !!
    public void updateEntreprise(Entreprise AncienEntrep, Entreprise newEntrep) {
       
       String sql = "update entreprise set raisonSociale =?,adresse=?, email =?,tel=?,responsable=? where id_entreprise ='"+AncienEntrep.getID()+"'" ;
        try {
                prepared =cnx.prepareStatement(sql);
               prepared = cnx.prepareStatement(sql);
                prepared.setString(1,newEntrep.getRaison());
                prepared.setString(2, newEntrep.getAdresse());
                prepared.setString(3, newEntrep.getEmail());
                prepared.setString(4, newEntrep.getTel());
                prepared.setString(5, newEntrep.getResponsable());
                prepared.execute();
              
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEntreprise.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
     @Override
    public void deletEntreprise(Integer ID) {
      String sql = "delete from entreprise  where id_entreprise ='" + ID + "'";
      
        try {
               prepared =cnx.prepareStatement(sql);
               
             int reponse =   JOptionPane.showConfirmDialog(null, "*Vous voulez Supprimer cette entreprise \n*Noter que vous supprimez aussi toutes les tables qui ont une relation avec cette entreprise", "Suppression d'une entreprise", JOptionPane.YES_NO_OPTION);
             // Suppression par cascade  
             if(reponse == JOptionPane.YES_OPTION){
                   prepared.execute();
            }
               
                
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEntreprise.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void ImprimerListeEntreprise(String chemin){
          Document doc = new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(chemin));
            doc.open();
            doc.add(new Paragraph("Gestion des Entreprises : \n\n"));

            PdfPTable table = new PdfPTable(5); // contient 5 colones chaque ligne
            table.setWidthPercentage(100);

            PdfPCell cell;
            // heade table -> ligne 1 du tableau 
            cell = new PdfPCell(new Phrase("Raison Sociale", FontFactory.getFont("Comic Sans MS", 12)));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("adresse", FontFactory.getFont("Comic Sans MS", 12)));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("email", FontFactory.getFont("Comic Sans MS", 12)));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("telephone", FontFactory.getFont("Comic Sans MS", 12)));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("responsable", FontFactory.getFont("Comic Sans MS", 12)));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);// fin head table*/
            String sql = "select raisonSociale,adresse,tel,email,responsable from entreprise";
            prepared = cnx.prepareStatement(sql);
            resultat = prepared.executeQuery();
            while (resultat.next()) {
                cell = new PdfPCell(new Phrase(resultat.getString("raisonSociale"), FontFactory.getFont("Arial", 10)));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(resultat.getString("adresse"), FontFactory.getFont("Arial", 10)));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(resultat.getString("email"), FontFactory.getFont("Arial", 10)));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(resultat.getString("tel"), FontFactory.getFont("Arial", 10)));
                table.addCell(cell);
                
                 cell = new PdfPCell(new Phrase(resultat.getString("responsable"), FontFactory.getFont("Arial", 10)));
                table.addCell(cell);

            }
            // En fin ajouter tous les cellules a table 
            doc.add(table);
            doc.close();
            Desktop.getDesktop().open(new File(chemin));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Entreprise.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException | DocumentException ex) {
            Logger.getLogger(Entreprise.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     
    
}
