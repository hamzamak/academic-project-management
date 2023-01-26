package Presentation.Graphics;

import Metier.Professeur;
import Presentation.ControlleurAcceuil;
import Presentation.ControlleurDepartement;
import Presentation.ControlleurLab;
import Presentation.ControlleurProfesseur;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import keeptoo.KGradientPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class ProfesseurFenetre extends JFrame {

    static int n = 0;
    private JPanel contentPane;
    private JTextField nomField;
    private JTextField prenomField;
    private JTextField emailField;
    private JTable tableProf;
    private ControlleurProfesseur controlProfesseur;
    private JComboBox departementBox;
    private ControlleurLab controlLab;
    private ControlleurDepartement controlDepartement;
    private ControlleurAcceuil controlAcceuil;
    JLabel TitleLabel;
    JPanel panelHome;
    JLabel HomeIcon;
    JLabel HomeLabel;
    JTextField SearchField;
    JLabel SearchLabel;

    JPanel panel;
    JLabel nomLabel;
    JLabel prenomLabel;
    JLabel emailLabel;
    JLabel gradeLabel;
    JLabel departementLabel;

    JScrollPane scrollPane;
    JButton addBtn;
    JButton updateBtn;
    JButton deleteBtn;
    JButton imprimerBtn;
    JLabel fleche_Gauche;
    JLabel fleche_Droite;
    JButton btnArchiver;
    JComboBox labBox;
    JComboBox roleBox;
    JCheckBox CheckMembreLab;
    JLabel laboLabel;
    JLabel roleLabel;
    KGradientPanel gradientPanel;
    JComboBox gradeBox;

     
   // pour faire un test
  /*  public static void main(String[] args) {
       ProfesseurFenetre frame = new ProfesseurFenetre(new ControlleurProfesseur(),
                            new ControlleurLab(), new ControlleurDepartement(), new ControlleurAcceuil()); }*/
    public ProfesseurFenetre(ControlleurProfesseur controlProfesseur, ControlleurLab controlLab,
            ControlleurDepartement controlDepartement, ControlleurAcceuil controlAcceuil) {
        initialiser(controlProfesseur, controlLab, controlDepartement, controlAcceuil);
        dessiner();
        executer();

    }

    private void initialiser(ControlleurProfesseur controlProfesseur, ControlleurLab controlLab,
            ControlleurDepartement controlDepartement, ControlleurAcceuil controlAcceuil) {
        this.controlProfesseur = controlProfesseur;
        this.controlLab = controlLab;
        this.controlDepartement = controlDepartement;
        this.controlAcceuil = controlAcceuil;
        contentPane = new JPanel();
        panelHome = new JPanel();
        HomeIcon = new JLabel("");
        HomeLabel = new JLabel("Home");
        panel = new JPanel();
        nomLabel = new JLabel("Nom");
        prenomLabel = new JLabel("Prenom");
        emailLabel = new JLabel("email");
        gradeLabel = new JLabel("Grade");
        departementLabel = new JLabel("Departement");
        nomField = new JTextField();
        prenomField = new JTextField();
        emailField = new JTextField();
        gradeBox = new JComboBox();
        departementBox = new JComboBox();
        tableProf = new JTable();
        scrollPane = new JScrollPane();
        TitleLabel = new JLabel("Gestion des Professeurs");
        addBtn = new JButton("Ajouter");
        updateBtn = new JButton("Modifier");
        deleteBtn = new JButton("Supprimer");
        imprimerBtn = new JButton("Imprimer");
        SearchField = new JTextField();
        SearchLabel = new JLabel("Filtrer : ");
        fleche_Gauche = new JLabel("");
        fleche_Droite = new JLabel("");
        btnArchiver = new JButton("Archiver");
        labBox = new JComboBox();
        roleBox = new JComboBox();
        CheckMembreLab = new JCheckBox("Affecte a un laboratoire");
        laboLabel = new JLabel("laboratoire");
        roleLabel = new JLabel("role");
        gradientPanel = new KGradientPanel();

    }

    private void dessiner() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1174, 640);

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panelHome.setOpaque(false);
        panelHome.setBounds(0, 0, 120, 49);
        contentPane.add(panelHome);
        panelHome.setLayout(null);

        HomeIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        HomeIcon.setIcon(new ImageIcon(ProfesseurFenetre.class.getResource("/Images/home.png")));
        HomeIcon.setBounds(10, 11, 49, 27);
        panelHome.add(HomeIcon);

        HomeLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        HomeLabel.setBounds(59, 19, 50, 15);
        panelHome.add(HomeLabel);

        panel.setOpaque(false);
        panel.setBounds(57, 54, 1083, 556);
        contentPane.add(panel);
        panel.setLayout(null);

        nomLabel.setForeground(new Color(0, 0, 0));
        nomLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        nomLabel.setBounds(35, 71, 122, 28);
        panel.add(nomLabel);

        prenomLabel.setForeground(new Color(0, 0, 0));
        prenomLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        prenomLabel.setBounds(35, 114, 122, 43);
        panel.add(prenomLabel);

        emailLabel.setForeground(new Color(0, 0, 0));
        emailLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        emailLabel.setBounds(35, 172, 122, 28);
        panel.add(emailLabel);

        gradeLabel.setForeground(new Color(0, 0, 0));
        gradeLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        gradeLabel.setBounds(409, 71, 122, 35);
        panel.add(gradeLabel);

        departementLabel.setForeground(new Color(0, 0, 0));
        departementLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        departementLabel.setBounds(409, 124, 122, 28);
        panel.add(departementLabel);

        nomField.setFont(new Font("Arial", Font.PLAIN, 15));
        nomField.setBounds(165, 71, 217, 26);
        panel.add(nomField);
        nomField.setColumns(10);

        prenomField.setFont(new Font("Arial", Font.PLAIN, 15));
        prenomField.setColumns(10);
        prenomField.setBounds(165, 121, 217, 26);
        panel.add(prenomField);

        emailField.setFont(new Font("Arial", Font.PLAIN, 15));
        emailField.setColumns(10);
        emailField.setBounds(167, 175, 217, 26);
        panel.add(emailField);

        gradeBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        gradeBox.setBounds(541, 77, 217, 24);
        panel.add(gradeBox);

        departementBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        departementBox.setBounds(541, 128, 217, 24);
        panel.add(departementBox);

        tableProf.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
        tableProf.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        tableProf.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},},
                new String[]{
                    "nom", "prenom", "email", "Grade", "Departement", "Laboratoire", "role", "Archive"
                }
        ));
        tableProf.setBounds(437, 55, 550, 262);

        scrollPane.setBounds(35, 344, 993, 174);
        scrollPane.setViewportView(tableProf);
        panel.add(scrollPane);

        TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        TitleLabel.setBackground(new Color(240, 240, 240));
        TitleLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
        TitleLabel.setForeground(new Color(153, 51, 204));
        TitleLabel.setBounds(263, 1, 438, 40);
        panel.add(TitleLabel);

        addBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        addBtn.setForeground(new Color(0, 0, 0));
        addBtn.setBounds(415, 254, 114, 26);
        panel.add(addBtn);

        updateBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        updateBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        updateBtn.setForeground(new Color(0, 0, 0));
        updateBtn.setBounds(543, 254, 114, 26);
        panel.add(updateBtn);

        deleteBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deleteBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        deleteBtn.setForeground(new Color(0, 0, 0));
        deleteBtn.setBounds(682, 254, 114, 26);
        panel.add(deleteBtn);

        imprimerBtn.setFont(new Font("Algerian", Font.PLAIN, 16));
        imprimerBtn.setForeground(new Color(0, 0, 0));
        imprimerBtn.setBounds(906, 303, 122, 26);
        panel.add(imprimerBtn);

        SearchField.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
        SearchField.setBounds(712, 306, 183, 24);
        panel.add(SearchField);
        SearchField.setColumns(10);

        SearchLabel.setIcon(new ImageIcon("src\\Images\\search.png"));
        SearchLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        SearchLabel.setBounds(606, 306, 99, 24);
        panel.add(SearchLabel);

        fleche_Gauche.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        fleche_Gauche.setToolTipText("vers page precedent");
        fleche_Gauche.setIcon(new ImageIcon("src\\Images\\fleche gauche.png"));
        fleche_Gauche.setBounds(10, 1, 58, 35);
        panel.add(fleche_Gauche);

        fleche_Droite.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        fleche_Droite.setToolTipText("vers page suivante");
        fleche_Droite.setIcon(new ImageIcon("src\\Images\\fleche droit.png"));
        fleche_Droite.setBounds(996, 1, 58, 35);
        panel.add(fleche_Droite);

        btnArchiver.setForeground(Color.BLACK);
        btnArchiver.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        btnArchiver.setBounds(822, 254, 114, 26);
        panel.add(btnArchiver);

        labBox.setBounds(157, 254, 228, 22);
        labBox.setEnabled(false);
        panel.add(labBox);

        roleBox.setBounds(157, 298, 228, 22);
        panel.add(roleBox);

        CheckMembreLab.setOpaque(false);

        CheckMembreLab.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        CheckMembreLab.setBounds(35, 224, 228, 23);
        panel.add(CheckMembreLab);

        laboLabel.setForeground(Color.BLACK);
        laboLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        laboLabel.setBounds(35, 255, 112, 28);

        panel.add(laboLabel);

        roleLabel.setForeground(Color.BLACK);
        roleLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        roleLabel.setBounds(35, 296, 112, 28);
        panel.add(roleLabel);

        gradientPanel.setOpaque(false);
        gradientPanel.setkGradientFocus(200);
        gradientPanel.kGradientFocus = 300;
        gradientPanel.kStartColor = new Color(255, 255, 153);
        gradientPanel.kEndColor = new Color(204, 255, 204);
        gradientPanel.setBounds(0, 0, 1298, 716);
        contentPane.add(gradientPanel);

        // set the models : 
        controlProfesseur.ShowIntable(tableProf);
        gradeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Master", "Doctorat"}));
        roleBox.setModel(new DefaultComboBoxModel<>(new String[]{"coordonnateur", "Chef du departement", "membre dans un laboratoire", "membre d'un departement"}));
        departementBox.setModel(controlProfesseur.initializeModelDepartement());
        labBox.setModel(controlProfesseur.initializeModelLab());

        setLocationRelativeTo(null);
        setTitle("Gestion des Professeurs");
        setVisible(true);
    }

    private void executer() {

        tableProf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                if (evt.getButton() == MouseEvent.BUTTON1) { // clique droite sur la souris
                    int indice = tableProf.getSelectedRow();
                    if (indice != - 1) {

                        String id = tableProf.getModel().getValueAt(indice, 0).toString();
                        Professeur prof = controlProfesseur.getProfesseurByID(Integer.parseInt(id));
                        nomField.setText(prof.getNom());
                        prenomField.setText(prof.getPrenom());
                        emailField.setText(prof.getEmail());
                        departementBox.setSelectedItem(controlDepartement.getDepartement(prof.getID_Departement()).getNom());

                        if (controlProfesseur.isMembreLabo(prof.getID())) {
                            CheckMembreLab.setSelected(true);
                            labBox.setEnabled(true);
                            n = 1; //impair
                            labBox.setSelectedItem(controlLab.getLaboratoire(prof.getID_Lab()).getNom());
                        } else {
                            CheckMembreLab.setSelected(false);
                            labBox.setEnabled(false);
                            n = 0;
                        }
                        gradeBox.setSelectedItem(prof.getGrade());
                        roleBox.setSelectedItem(prof.getRole());
                    }
                } else if (evt.getButton() == MouseEvent.BUTTON3) { // clique gauche sur la souris
                    tableProf.clearSelection();  // Deselects all selected columns and rows.
                    vider();
                }
            }
        });

        CheckMembreLab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (n % 2 == 0) {
                    labBox.setEnabled(true);
                    n++;
                } else {
                    labBox.setEnabled(false);
                    n++;

                }
            }
        });

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nom = nomField.getText();
                String prenom = prenomField.getText();
                String email = emailField.getText();
                String departement = departementBox.getSelectedItem().toString();
                String grade = gradeBox.getSelectedItem().toString();
                String role = roleBox.getSelectedItem().toString();
                String labNom = labBox.getSelectedItem().toString();

                Integer lab = controlLab.getIdLaboratoireByName(labNom);
                Integer idDepart = controlDepartement.getIdDepartementByName(departement);
                ChooseMembre();
                Professeur prof = new Professeur(nom, prenom, email, grade, idDepart, lab, role);

                if (controlProfesseur.addProfesseur(prof, CheckMembreLab.isSelected())) {
                    controlProfesseur.ShowIntable(tableProf);
                    vider();
                }
            }
        });
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nom = nomField.getText();
                String prenom = prenomField.getText();
                String email = emailField.getText();
                String departement = "";
                String grade = gradeBox.getSelectedItem().toString();
                String role = roleBox.getSelectedItem().toString();

                String labNom = "";

                Integer lab = -1;
                Integer idDepart = -1;
                if (labBox.getSelectedItem() != null) {
                    labNom = labBox.getSelectedItem().toString();
                    lab = controlLab.getIdLaboratoireByName(labNom);
                }
                if (departementBox.getSelectedItem() != null) {
                    departement = departementBox.getSelectedItem().toString();
                    idDepart = controlDepartement.getIdDepartementByName(departement);
                }
                Professeur prof = new Professeur(nom, prenom, email, grade, idDepart, lab, role);
                ChooseMembre();
                if (controlProfesseur.updateProfesseur(prof, tableProf, CheckMembreLab.isSelected())) {
                    controlProfesseur.ShowIntable(tableProf);
                    vider();
                }

            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlProfesseur.deleteProfesseur(tableProf);
                controlProfesseur.ShowIntable(tableProf);

                vider();

            }
        });

        btnArchiver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlProfesseur.archiverProf(tableProf);
                controlProfesseur.ShowIntable(tableProf);

                vider();

            }
        });

        imprimerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser selecteur = new JFileChooser();

                selecteur.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                selecteur.setDialogTitle("choisir l'emplacement");

                String chemin = "src\\fichierImprime\\professeur.pdf";

                int result = selecteur.showDialog(null, "choisir");
                if (result == JFileChooser.APPROVE_OPTION) {
                    File fichier = selecteur.getSelectedFile();
                    chemin = fichier.getAbsolutePath() + "\\professeur.pdf";
                    controlProfesseur.ImprimerListeProfesseur(chemin);
                }

            }
        });

        HomeIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                controlAcceuil.demarre_Acceuil();
            }

        });
        fleche_Gauche.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                controlAcceuil.demarreAdmin();
            }

        });
        fleche_Droite.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                controlAcceuil.demarreEtudiant();
            }

        });
          SearchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {

                try {
                    String filtre = SearchField.getText();

                    TableRowSorter tr = new TableRowSorter(tableProf.getModel());
                    tableProf.setRowSorter(tr);
                    tr.setRowFilter(RowFilter.regexFilter(filtre, 0, 1, 2,3,4,5,6,7,8));
                } catch (Exception ex) {

                }
            }
        });

    }

    private void vider() {
        nomField.setText("");
        prenomField.setText("");
        emailField.setText("");

    }

    private void ChooseMembre() {
        if (roleBox.getSelectedItem().toString().equalsIgnoreCase("membre dans un laboratoire")) {
            CheckMembreLab.setSelected(true);
            labBox.setEnabled(true);

        }
    }
}
