
package Presentation;

import Metier.Administration;
import Metier.GestionAdministration;
import Presentation.Graphics.AcceuilFenetre;
import Presentation.Graphics.AdminFenetre;
import Presentation.Graphics.DoctoratFenetre;
import Presentation.Graphics.EtapeFenetre;
import Presentation.Graphics.IndicationPassword;
import Presentation.Graphics.PFE_PFA_Fenetre;
import javax.swing.JOptionPane;


public class ControlleurAdministration {
    GestionAdministration gestionAdmin ;
   
    public ControlleurAdministration() {
        gestionAdmin  = new GestionAdministration();
        
    }
    public boolean ConnecterControlle(String username , String password , String metier ){
        
        if( gestionAdmin.Se_Connecter(new Administration(username, password ,metier))){
            if(metier.equals("admin")){
                 JOptionPane.showMessageDialog(null, "Bonjour "+username+"\n", "Authentification admin est reussite", JOptionPane.INFORMATION_MESSAGE);  
             AcceuilFenetre fen = new AcceuilFenetre(new ControlleurAcceuil());
             return true ;
            }
            else if(metier.equals("coordonnateur")){
                 JOptionPane.showMessageDialog(null, "Bonjour "+username+"\n", "Authentification coordonnateur est reussite", JOptionPane.INFORMATION_MESSAGE);  
                PFE_PFA_Fenetre projetFen = new PFE_PFA_Fenetre(new ControlleurProjet(), new ControlleurEtudiant(),
                        new ControlleurEntreprise(), new ControlleurLab() , new  ControlleurAcceuil());
             return true ;
            }
           
            else  if(metier.equals("professeur")) {
                 JOptionPane.showMessageDialog(null, "Bonjour "+username+"\n", "Authentification professeur est reussite", JOptionPane.INFORMATION_MESSAGE);  
                   EtapeFenetre etapeFen = new EtapeFenetre(new ControlleurEtape(), new ControlleurProfesseur()
                           , new ControlleurProjet() , new ControlleurAcceuil());
             return true ;
            }
            //else -> directur du lab
              else{
                 JOptionPane.showMessageDialog(null, "Bonjour "+username+"\n", "Authentification directeur est reussite", JOptionPane.INFORMATION_MESSAGE);  
                DoctoratFenetre docFen = new DoctoratFenetre(new ControlleurProjet(), new ControlleurLab(),
                        new ControlleurEtudiant() , new ControlleurAcceuil());
             return true ;
            }
              
        }
        else{
        JOptionPane.showMessageDialog(null, "Acces refuse\nNom ou Mot de passe est incorrecte\n\n", "Echec d'Authentification ", JOptionPane.INFORMATION_MESSAGE);     
            return  false ;
        }
         
    }
    public void demarrer(){
        AdminFenetre Fen = new  AdminFenetre(this);
    }
    public void helpPassword(){
        IndicationPassword indic = new IndicationPassword(this);
    }
    public boolean getIndication(String username){
        String Password_genere = gestionAdmin.getPassword(username) ;
        if(Password_genere.equals("")){
            JOptionPane.showMessageDialog(null, "Ce username n'existe pas", "introuvable", JOptionPane.WARNING_MESSAGE);
            return false ;
        }
        else{
            JOptionPane.showMessageDialog(null, "Votre mot de passe commence par :"+Password_genere.substring(0, 3), "Indication", JOptionPane.INFORMATION_MESSAGE);
            return true ;
        }
}
}
