package Presentation;

import Metier.GestionAcceuil;
import Presentation.Graphics.AcceuilFenetre;
import Presentation.Graphics.AdminFenetre;
import Presentation.Graphics.DepartementFenetre;
import Presentation.Graphics.EntrepriseFenetre;
import Presentation.Graphics.EtudiantFenetre;
import Presentation.Graphics.FiliereFenetre;
import Presentation.Graphics.LabFenetre;
import Presentation.Graphics.ProfesseurFenetre;
import Presentation.Graphics.UsersFenetre;

/**
 *
 * @author pc
 */
public class ControlleurAcceuil {

    GestionAcceuil gestionAcceuil; 
    public ControlleurAcceuil() {
        gestionAcceuil = new GestionAcceuil();
       
    }
    public void  exit_Acceuil(){
        AdminFenetre Fen = new  AdminFenetre(new ControlleurAdministration());
    }
     public void  demarre_Acceuil(){
         AcceuilFenetre fen = new AcceuilFenetre(this);
    }
    
    public void demarreEtudiant() {
        // DISPOSE() dans event Acceuil ors du clique sue image ou button 
        // new Fenetre ETudiant
       
        EtudiantFenetre etdFen = new EtudiantFenetre(new ControlleurEtudiant(), new ControlleurFiliere(), this, new ControlleurProjet());
       // etdFen.setVisible(true);
    }

    public void demarreProfesseur() {
       ProfesseurFenetre profFen = new ProfesseurFenetre(new ControlleurProfesseur(),new ControlleurLab(),new ControlleurDepartement()
       ,this);
    }

    public void demarreEntreprise() {
        EntrepriseFenetre EntrepFen = new EntrepriseFenetre(new ControlleurEntreprise(), this);
    }

    public void demarreLabo() {
        LabFenetre labFen = new LabFenetre(new ControlleurLab(), this, new ControlleurProfesseur(),new ControlleurEtudiant());
    }

    public void demarreAdmin() {
        UsersFenetre userFen = new UsersFenetre(new ControlleurUtilisateurs(), this);
    }

    public void demarreFiliere() {
        FiliereFenetre filiereFen = new FiliereFenetre(new ControlleurFiliere(), new ControlleurDepartement(), this);
    }

    public void demarreDepartement() {
        DepartementFenetre departFen = new DepartementFenetre(new ControlleurDepartement(),this,new ControlleurProfesseur());
    }

    public Integer Count_Etudiant() {
        return gestionAcceuil.getCount().getNb_Etudiants();
    }

    public Integer Count_Professeur() {
        return gestionAcceuil.getCount().getNb_Professeurs();
    }

    public Integer Count_Entreprise() {
        return gestionAcceuil.getCount().getNb_Entreprises();
    }

    public Integer Count_Filiere() {
        return gestionAcceuil.getCount().getNb_Filieres();
    }

    public Integer Count_Departement() {
        return gestionAcceuil.getCount().getNb_Departement();
    }

    public Integer Count_Laboratoire() {
        return gestionAcceuil.getCount().getNb_Laboratoires();
    }

    public Integer Count_admin() {
        return gestionAcceuil.getCount().getNb_Admin();
    }

}
