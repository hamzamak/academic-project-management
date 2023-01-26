package Presentation.Graphics;


import Presentation.ControlleurAcceuil;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class AcceuilFenetre extends JFrame {

    JPanel panel;
    JLabel HomeLabel;
    JLabel WelcomLabel;
    JLabel iconeDeconnexion;
    JLabel DeconnexionLabel;
    JSeparator separator;
    JPanel panelEtd;
    JLabel Nb_Etudiant;
    JLabel iconEtudiant;
    JLabel LabelEtud;
    JPanel panelProf;
    JLabel Nb_Prof;
    JLabel iconProfesseur;
    JLabel LabelProfesseur;
    JPanel panelEntreprise;
    JLabel Nb_Entrep;
    JLabel iconEntreprise;
    JLabel LabelEntreprise;
    JPanel panelDepartement;
    JLabel Nb_Departement;
    JLabel iconDepartement;
    JLabel LabelDepart;
    JPanel panellFiliere;
    JLabel Nb_Filiere;
    JLabel iconFiliere;
    JLabel LabelFiliere;
    JPanel panelLabo;
    JLabel Nb_Lab;
    JLabel iconeLab;
    JLabel LabelLab;
    JPanel panelAdmin;
    JLabel Nb_GestionAdmin;
    JLabel iconGestionAdmin;
    JLabel LabelAdmin;
    ControlleurAcceuil control ;
    public AcceuilFenetre(ControlleurAcceuil control) {
        initialise(control);
        dessiner();
        updateStatistique();
        executer();
    }
    
    public void initialise(ControlleurAcceuil control) {
        this.control =control ;
        panel = new JPanel();

        HomeLabel = new JLabel("Home Page");

        WelcomLabel = new JLabel("Welcome Admnistrateur");

        iconeDeconnexion = new JLabel("");

        DeconnexionLabel = new JLabel("Deconnexon");

        separator = new JSeparator();

        panelEtd = new JPanel();

        Nb_Etudiant = new JLabel("0");

        iconEtudiant = new JLabel("");

        LabelEtud = new JLabel("Students");

        panelProf = new JPanel();

        Nb_Prof = new JLabel("0");

        iconProfesseur = new JLabel("");

        LabelProfesseur = new JLabel("Professeurs");

        panelEntreprise = new JPanel();

        Nb_Entrep = new JLabel("0");

        iconEntreprise = new JLabel("");

        LabelEntreprise = new JLabel("Entreprise");

        panelDepartement = new JPanel();

        Nb_Departement = new JLabel("0");

        iconDepartement = new JLabel("");

        LabelDepart = new JLabel("Departement");

        panellFiliere = new JPanel();

        Nb_Filiere = new JLabel("0");

        iconFiliere = new JLabel("");

        LabelFiliere = new JLabel("Filiere");

        panelLabo = new JPanel();

        Nb_Lab = new JLabel("0");

        iconeLab = new JLabel("");

        LabelLab = new JLabel("Laboratoire");

        panelAdmin = new JPanel();

        Nb_GestionAdmin = new JLabel("0");

        iconGestionAdmin = new JLabel("");

        LabelAdmin = new JLabel("Gestion des administrateurs");

    }

    public void dessiner() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1164, 642);
        getContentPane().setLayout(null);

        panel.setBackground(new Color(119, 136, 153));
        panel.setBounds(0, 0, 1500, 152);
        getContentPane().add(panel);
        panel.setLayout(null);

        HomeLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
        HomeLabel.setForeground(new Color(250, 240, 230));
        HomeLabel.setBackground(new Color(240, 240, 240));
        HomeLabel.setBounds(21, 74, 305, 44);
        panel.add(HomeLabel);

        WelcomLabel.setForeground(new Color(250, 240, 230));
        WelcomLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
        WelcomLabel.setBackground(SystemColor.menu);
        WelcomLabel.setBounds(774, 11, 368, 56);
        panel.add(WelcomLabel);

        iconeDeconnexion.setIcon(new ImageIcon("src\\Images\\exit.png"));
        iconeDeconnexion.setBounds(22, 7, 57, 56);
        panel.add(iconeDeconnexion);
        iconeDeconnexion.setCursor(new Cursor(Cursor.HAND_CURSOR) );

        DeconnexionLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
        DeconnexionLabel.setBounds(77, 29, 130, 24);
        panel.add(DeconnexionLabel);
        DeconnexionLabel.setCursor(new Cursor(Cursor.HAND_CURSOR) );

        separator.setBounds(21, 61, 186, 2);
        panel.add(separator);

        panelEtd.setBackground(new Color(245, 245, 220));
        panelEtd.setBounds(575, 163, 199, 152);
        getContentPane().add(panelEtd);
        panelEtd.setLayout(null);

        Nb_Etudiant.setHorizontalAlignment(SwingConstants.CENTER);
        Nb_Etudiant.setBounds(78, 127, 47, 14);
        panelEtd.add(Nb_Etudiant);

        iconEtudiant.setHorizontalAlignment(SwingConstants.CENTER);
        iconEtudiant.setHorizontalTextPosition(SwingConstants.CENTER);
        iconEtudiant.setIcon(new ImageIcon("src\\Images\\etudiant.png"));
        iconEtudiant.setBounds(10, 11, 177, 85);
        panelEtd.add(iconEtudiant);
        iconEtudiant.setCursor(new Cursor(Cursor.HAND_CURSOR) );

        LabelEtud.setFont(new Font("Tahoma", Font.ITALIC, 13));
        LabelEtud.setHorizontalAlignment(SwingConstants.CENTER);
        LabelEtud.setBounds(53, 102, 91, 14);
        panelEtd.add(LabelEtud);

        panelProf.setLayout(null);
        panelProf.setBackground(new Color(245, 245, 220));
        panelProf.setBounds(292, 163, 199, 152);
        getContentPane().add(panelProf);

        Nb_Prof.setHorizontalAlignment(SwingConstants.CENTER);
        Nb_Prof.setBounds(78, 127, 47, 14);
        panelProf.add(Nb_Prof);

        iconProfesseur.setIcon(new ImageIcon("src\\Images\\prof.png"));
        iconProfesseur.setHorizontalTextPosition(SwingConstants.CENTER);
        iconProfesseur.setHorizontalAlignment(SwingConstants.CENTER);
        iconProfesseur.setBounds(10, 11, 177, 85);
        panelProf.add(iconProfesseur);
        iconProfesseur.setCursor(new Cursor(Cursor.HAND_CURSOR) );
         
        LabelProfesseur.setHorizontalAlignment(SwingConstants.CENTER);
        LabelProfesseur.setFont(new Font("Tahoma", Font.ITALIC, 13));
        LabelProfesseur.setBounds(53, 102, 91, 14);
        panelProf.add(LabelProfesseur);

        panelEntreprise.setLayout(null);
        panelEntreprise.setBackground(new Color(245, 245, 220));
        panelEntreprise.setBounds(575, 396, 199, 152);
        getContentPane().add(panelEntreprise);

        Nb_Entrep.setHorizontalAlignment(SwingConstants.CENTER);
        Nb_Entrep.setBounds(78, 127, 47, 14);
        panelEntreprise.add(Nb_Entrep);

        iconEntreprise.setIcon(new ImageIcon("src\\Images\\entreprise.png"));
        iconEntreprise.setHorizontalTextPosition(SwingConstants.CENTER);
        iconEntreprise.setHorizontalAlignment(SwingConstants.CENTER);
        iconEntreprise.setBounds(10, 11, 177, 85);
        panelEntreprise.add(iconEntreprise);
        iconEntreprise.setCursor(new Cursor(Cursor.HAND_CURSOR) );
         
        LabelEntreprise.setHorizontalAlignment(SwingConstants.CENTER);
        LabelEntreprise.setFont(new Font("Tahoma", Font.ITALIC, 13));
        LabelEntreprise.setBounds(53, 102, 91, 14);
        panelEntreprise.add(LabelEntreprise);

        panelDepartement.setLayout(null);
        panelDepartement.setBackground(new Color(245, 245, 220));
        panelDepartement.setBounds(871, 163, 199, 152);
        getContentPane().add(panelDepartement);

        Nb_Departement.setHorizontalAlignment(SwingConstants.CENTER);
        Nb_Departement.setBounds(78, 127, 47, 14);
        panelDepartement.add(Nb_Departement);

        iconDepartement.setIcon(new ImageIcon("src\\Images\\departement.png"));
        iconDepartement.setHorizontalTextPosition(SwingConstants.CENTER);
        iconDepartement.setHorizontalAlignment(SwingConstants.CENTER);
        iconDepartement.setBounds(10, 11, 177, 85);
        panelDepartement.add(iconDepartement);
        iconDepartement.setCursor(new Cursor(Cursor.HAND_CURSOR) );
         
        LabelDepart.setHorizontalAlignment(SwingConstants.CENTER);
        LabelDepart.setFont(new Font("Tahoma", Font.ITALIC, 13));
        LabelDepart.setBounds(53, 102, 91, 14);
        panelDepartement.add(LabelDepart);

        panellFiliere.setLayout(null);
        panellFiliere.setBackground(new Color(245, 245, 220));
        panellFiliere.setBounds(40, 396, 199, 152);
        getContentPane().add(panellFiliere);

        Nb_Filiere.setHorizontalAlignment(SwingConstants.CENTER);
        Nb_Filiere.setBounds(78, 127, 47, 14);
        panellFiliere.add(Nb_Filiere);

        iconFiliere.setIcon(new ImageIcon("src\\Images\\filiere.png"));
        iconFiliere.setHorizontalTextPosition(SwingConstants.CENTER);
        iconFiliere.setHorizontalAlignment(SwingConstants.CENTER);
        iconFiliere.setBounds(10, 11, 177, 85);
        panellFiliere.add(iconFiliere);
        iconFiliere.setCursor(new Cursor(Cursor.HAND_CURSOR) );
         
        LabelFiliere.setHorizontalAlignment(SwingConstants.CENTER);
        LabelFiliere.setFont(new Font("Tahoma", Font.ITALIC, 13));
        LabelFiliere.setBounds(53, 102, 91, 14);
        panellFiliere.add(LabelFiliere);

        panelLabo.setLayout(null);
        panelLabo.setBackground(new Color(245, 245, 220));
        panelLabo.setBounds(292, 396, 199, 152);
        getContentPane().add(panelLabo);

        Nb_Lab.setHorizontalAlignment(SwingConstants.CENTER);
        Nb_Lab.setBounds(78, 127, 47, 14);
        panelLabo.add(Nb_Lab);

        iconeLab.setIcon(new ImageIcon("src\\Images\\lab.png"));
        iconeLab.setHorizontalTextPosition(SwingConstants.CENTER);
        iconeLab.setHorizontalAlignment(SwingConstants.CENTER);
        iconeLab.setBounds(10, 11, 177, 85);
        panelLabo.add(iconeLab);
        iconeLab.setCursor(new Cursor(Cursor.HAND_CURSOR) );
        
        LabelLab.setHorizontalAlignment(SwingConstants.CENTER);
        LabelLab.setFont(new Font("Tahoma", Font.ITALIC, 13));
        LabelLab.setBounds(53, 102, 91, 14);
        panelLabo.add(LabelLab);

        panelAdmin.setLayout(null);
        panelAdmin.setBackground(new Color(245, 245, 220));
        panelAdmin.setBounds(40, 163, 199, 152);
        getContentPane().add(panelAdmin);

        Nb_GestionAdmin.setHorizontalAlignment(SwingConstants.CENTER);
        Nb_GestionAdmin.setBounds(78, 127, 47, 14);
        panelAdmin.add(Nb_GestionAdmin);

        iconGestionAdmin.setIcon(new ImageIcon("src\\Images\\adminGestion.png"));
        iconGestionAdmin.setHorizontalTextPosition(SwingConstants.CENTER);
        iconGestionAdmin.setHorizontalAlignment(SwingConstants.CENTER);
        iconGestionAdmin.setBounds(10, 11, 177, 85);
        panelAdmin.add(iconGestionAdmin);
        iconGestionAdmin.setCursor(new Cursor(Cursor.HAND_CURSOR) );
        
        LabelAdmin.setHorizontalAlignment(SwingConstants.CENTER);
        LabelAdmin.setFont(new Font("Tahoma", Font.ITALIC, 13));
        LabelAdmin.setBounds(20, 102, 167, 14);
        panelAdmin.add(LabelAdmin);
        setLocationRelativeTo(null);
        setTitle("Acceuil");
        setVisible(true);
    }

    public void executer() {
        DeconnexionLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                control.exit_Acceuil();
            }
            
        });
         iconeDeconnexion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                control.exit_Acceuil();
            }
            
        });
         iconEtudiant.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                control.demarreEtudiant();
            }
            
        });
         
          iconFiliere.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                control.demarreFiliere();
            }
            
        });
          
           iconDepartement.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                control.demarreDepartement();
            }
            
        });
           
             iconEntreprise.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                control.demarreEntreprise();
            }
            
        });
             
               iconeLab.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                control.demarreLabo();
            }
            
        });
            iconProfesseur.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                control.demarreProfesseur();
            }
            
        });
            
            iconGestionAdmin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                control.demarreAdmin();
            }
            
        });
    }
    
    public void updateStatistique(){
        Nb_GestionAdmin.setText(control.Count_admin()+"");
        Nb_Etudiant.setText(control.Count_Etudiant()+"");
        Nb_Etudiant.setText(control.Count_Etudiant()+"");
        Nb_Prof.setText(control.Count_Professeur()+"");
        Nb_Filiere.setText(control.Count_Filiere()+"");
        Nb_Departement.setText(control.Count_Departement()+"");
        Nb_Entrep.setText(control.Count_Entreprise()+"");
        Nb_Lab.setText(control.Count_Laboratoire()+"");
    }

}
