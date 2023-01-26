
package Metier;

import Persistance.DAO.DaoEtape;
import Persistance.DAO.DaoProfesseur;
import Persistance.DAO.DaoProjet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author pc
 */
public class GestionProfesseur {
    DaoProfesseur daoProf ;
    DaoProjet daoProjets ;
    DaoEtape daoEtape ;
    public GestionProfesseur(){
        daoProf = new DaoProfesseur();
        daoProjets = new DaoProjet();
        daoEtape = new DaoEtape();
    }
       public ArrayList<Professeur> getAll() {
           return daoProf.getAll();
       }
    public void deleteProfesseur(Integer idProf){
          
            String sql = "delete from professeur  where id_prof ='" + idProf + "'";
            int a = JOptionPane.showConfirmDialog(null, "Vous Voulez Vraiment Supprimer le professeur "+ daoProf.getProfesseurByID(idProf).getPrenom()
                    +" " +daoProf.getProfesseurByID(idProf).getNom(), "Suppression d'un professeur", JOptionPane.YES_NO_OPTION);
            if (a == JOptionPane.YES_OPTION) { // ou a == 0
                if(daoProf.isProfActive(idProf)){
                    JOptionPane.showMessageDialog(null, "Un professeur peut être supprimé si seulement n’as aucun projet", "Echec Suppression d'un professeur", JOptionPane.WARNING_MESSAGE);
                }
                else{
                    daoProf.deleteProfesseur(idProf);
                    JOptionPane.showMessageDialog(null, "Suppression est reussite");
                }
            }
        }
     public void addProfesseur(Professeur prof , boolean ismembre) {
         daoProf.addProfesseur(prof, ismembre);
     }
     
     public void updateProfesseur(Professeur Ancienprof, Professeur newprof , boolean isMembre) {
         daoProf.updateProfesseur(Ancienprof, newprof, isMembre);
     }
     
     public void ShowIntable(JTable tableProf) {
         daoProf.ShowIntable(tableProf);
     } 
     
      public Professeur getProfesseurByID(Integer ID) {
          return daoProf.getProfesseurByID(ID);
      }
      
        public  boolean isMembreLabo(int id_prof){
            return daoProf.isMembreLabo(id_prof);
        }
        /* public boolean isProfActive(int id_professeur) {
        return daoProf.isProfActive(id_professeur);
        }*/
        public void ImprimerListeProfesseur(String chemin) {
            daoProf.ImprimerListeProfesseur(chemin);
        }
        
         public void ArchiverProf(Integer idProf ){
            boolean estArchive = true ; 
           // int id_projet = daoEtape.getIdProjet(idProf); //from etape table
            ArrayList<Integer> IDProjets = daoEtape.getIDProjets(idProf);
            Calendar c = new GregorianCalendar(); // date actuelle 
            // on comapre date fin du projet a cette date actuelle si la date fin de projet >  la date actuelle 
            // donc projet n'a pas fini , il est en cours donc il ne faut pas archive le professeur qui a en charge de ce projet
            int a = JOptionPane.showConfirmDialog(null, "Vous Voulez Vraiment archiver le professeur ", "Archivage d'un professeur", JOptionPane.YES_NO_OPTION);
            if (a == JOptionPane.YES_OPTION) {
                if(daoProf.isProfActive(idProf)){
                    // si il y a un projet en cours , le prof ne doit pas etre archive
                    for(int i=0 ; i< IDProjets.size() ;i ++){
                        if(c.before(daoProjets.getCalenderDateFin(daoProjets.getDateDepart(IDProjets.get(i)), daoProjets.getDurree(IDProjets.get(i))))){
                        JOptionPane.showMessageDialog(null, "Un professeur peut être archivé que si n’as aucun projet en cours, un professeur archivé n’ encadré  plus de projet.", "Echec archivage du professeur", JOptionPane.WARNING_MESSAGE); 
                        estArchive = false; 
                        break ;}
                    }
                  
                    if(estArchive){
                        daoProf.ArchiverProf(idProf);
                        JOptionPane.showMessageDialog(null, "Archivage est reussite");
                    } }
                else{
                  //  JOptionPane.showMessageDialog(null, "Le professeur n'a  aucun projet !!\nMieux le Supprimer ", "Suggestion de la suppression", JOptionPane.WARNING_MESSAGE);
                    int reponse =JOptionPane.showConfirmDialog(null, "Le professeur n'a  aucun projet !!Mieux le Supprimer\n Vous voulez quand meme l'archiver? ", "Suggestion de la suppression",JOptionPane.YES_NO_OPTION);
                  if(reponse == JOptionPane.OK_OPTION){
                       daoProf.ArchiverProf(idProf);
                        JOptionPane.showMessageDialog(null, "Archivage est reussite");
                  }
                    
                    
                    
                }
            }
        }
         
          public void updateProfesseurSetStateArchive( int id) {
              daoProf.updateProfesseurSetStateArchive(id);
          }
          
            public void ShowIntableMembreDepartement(JTable tableProf, int depart) {
                daoProf.ShowIntableMembreDepartement(tableProf, depart);
            }
            
            
           
     public void ShowIntableMembreLab(JTable table, int id_lab) {
         daoProf.ShowIntableMembreLab(table, id_lab);
     }
}
        
         
    

