package Presentation.Graphics;

import Metier.Etudiant;
import Presentation.ControlleurAcceuil;
import Presentation.ControlleurEtudiant;
import Presentation.ControlleurFiliere;
import Presentation.ControlleurProjet;
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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableRowSorter;

public class EtudiantFenetre extends JFrame {

    private JPanel contentPane;
    private JTextField nomField;
    private JTextField prenomField;
    private JTextField emailField;
    private JTable tableEtd;
    private JComboBox niveauBox;
    private JComboBox filiereBox;
    private ControlleurEtudiant controlEtudiant;
    private ControlleurFiliere controlFiliere;
    private ControlleurAcceuil controlAcceuil;
    private ControlleurProjet controlProjet;

    JLabel prenomLabel;
    JLabel emailLabel;
    JLabel filiereLabel;
    JLabel niveauLabel;
    JPanel panelHome;
    JLabel HomeIcon;
    JLabel HomeLabel;
    JTextField SearchField;
    JLabel SearchLabel;
    JPanel panel;
    JLabel nomLabel;
    JLabel departementLabel;
    JScrollPane scrollPane;
    JLabel TitleLabel;
    JButton addBtn;
    JButton updateBtn;
    JButton deleteBtn;
    JButton addGroupEtud;
    JButton imprimerBtn;
    JLabel fleche_Gauche;
    JLabel fleche_Droite;
    KGradientPanel gradientPanel;

  /*  public static void main(String[] args) {
        EtudiantFenetre frame = new EtudiantFenetre(new ControlleurEtudiant(), new ControlleurFiliere(),
                new ControlleurAcceuil(), new ControlleurProjet());
    }*/

    public EtudiantFenetre(ControlleurEtudiant c, ControlleurFiliere controlFiliere, ControlleurAcceuil controlAcceuil,
            ControlleurProjet controlProjet) {
        initialiser(c, controlFiliere, controlAcceuil, controlProjet);
        dessiner();
        executer();
    }

    private void initialiser(ControlleurEtudiant c, ControlleurFiliere controlFiliere, ControlleurAcceuil controlAcceuil,
            ControlleurProjet controlProjet) {
        this.controlEtudiant = c;
        this.controlFiliere = controlFiliere;
        this.controlAcceuil = controlAcceuil;
        this.controlProjet = controlProjet;

        contentPane = new JPanel();
        panelHome = new JPanel();
        HomeIcon = new JLabel("");
        HomeLabel = new JLabel("Home");

        panel = new JPanel();

        nomLabel = new JLabel("Nom");
        prenomLabel = new JLabel("Prenom");

        emailLabel = new JLabel("email");

        filiereLabel = new JLabel("Filiere");
        niveauLabel = new JLabel("Niveau");
        nomField = new JTextField();
        prenomField = new JTextField();
        emailField = new JTextField();
        filiereBox = new JComboBox();
        niveauBox = new JComboBox();

        tableEtd = new JTable();

        scrollPane = new JScrollPane();

        TitleLabel = new JLabel("Gestion des Etudiants");

        addBtn = new JButton("Ajouter");

        updateBtn = new JButton("Modifier");
        deleteBtn = new JButton("Supprimer");
        addGroupEtud = new JButton("Inserer Excel");
        imprimerBtn = new JButton("Imprimer");

        fleche_Gauche = new JLabel("");
        fleche_Droite = new JLabel("");
        SearchField = new JTextField();

        SearchLabel = new JLabel("Filtrer : ");

        gradientPanel = new KGradientPanel();

    }

    private void dessiner() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1174, 621);

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        panelHome.setOpaque(false);
        panelHome.setBounds(0, 0, 120, 49);
        contentPane.add(panelHome);
        panelHome.setLayout(null);

        HomeIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        HomeIcon.setIcon(new ImageIcon(EtudiantFenetre.class.getResource("/Images/home.png")));
        HomeIcon.setBounds(10, 11, 49, 27);
        panelHome.add(HomeIcon);

        HomeLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        HomeLabel.setBounds(59, 19, 50, 15);
        panelHome.add(HomeLabel);

        panel.setOpaque(false);
        panel.setBounds(57, 54, 1083, 508);
        contentPane.add(panel);
        panel.setLayout(null);

        nomLabel.setForeground(new Color(0, 0, 0));
        nomLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        nomLabel.setBounds(35, 71, 122, 28);
        panel.add(nomLabel);

        prenomLabel.setForeground(new Color(0, 0, 0));
        prenomLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        prenomLabel.setBounds(35, 114, 122, 43);
        panel.add(prenomLabel);

        emailLabel.setForeground(new Color(0, 0, 0));
        emailLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        emailLabel.setBounds(35, 178, 122, 43);
        panel.add(emailLabel);

        filiereLabel.setForeground(new Color(0, 0, 0));
        filiereLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        filiereLabel.setBounds(35, 232, 122, 43);
        panel.add(filiereLabel);

        niveauLabel.setForeground(new Color(0, 0, 0));
        niveauLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        niveauLabel.setBounds(35, 286, 122, 40);
        panel.add(niveauLabel);

        nomField.setFont(new Font("Arial", Font.PLAIN, 16));
        nomField.setBounds(165, 71, 217, 26);
        panel.add(nomField);
        nomField.setColumns(10);

        prenomField.setFont(new Font("Arial", Font.PLAIN, 16));
        prenomField.setColumns(10);
        prenomField.setBounds(165, 121, 217, 26);
        panel.add(prenomField);

        emailField.setFont(new Font("Arial", Font.PLAIN, 16));
        emailField.setColumns(10);
        emailField.setBounds(167, 185, 217, 26);
        panel.add(emailField);

        filiereBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        filiereBox.setBounds(167, 246, 217, 24);
        panel.add(filiereBox);

        niveauBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        niveauBox.setBounds(167, 297, 217, 24);
        panel.add(niveauBox);

        SearchField.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
        SearchField.setBounds(687, 306, 183, 22);
        panel.add(SearchField);
        SearchField.setColumns(10);

        SearchLabel.setIcon(new ImageIcon("src\\Images\\search.png"));
        SearchLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        SearchLabel.setBounds(578, 305, 99, 22);
        panel.add(SearchLabel);

        tableEtd.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
        tableEtd.setFont(new Font("Segoe UI", 1, 12));
        tableEtd.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null}
                },
                new String[]{
                    "nom", "prenom", "email", "filiere", "niveau"
                }
        ));
        tableEtd.setBounds(437, 55, 550, 262);

        scrollPane.setBounds(45, 337, 993, 174);
        scrollPane.setViewportView(tableEtd);
        panel.add(scrollPane);

        TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        TitleLabel.setBackground(new Color(240, 240, 240));
        TitleLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
        TitleLabel.setForeground(new Color(153, 51, 204));
        TitleLabel.setBounds(263, 1, 424, 40);
        panel.add(TitleLabel);

        addBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addBtn.setFont(new Font("Sitka Text", Font.PLAIN, 16));
        addBtn.setForeground(new Color(0, 0, 0));
        addBtn.setBounds(429, 71, 124, 26);
        panel.add(addBtn);

        updateBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        updateBtn.setFont(new Font("Sitka Text", Font.PLAIN, 16));
        updateBtn.setForeground(new Color(0, 0, 0));
        updateBtn.setBounds(429, 126, 124, 26);
        panel.add(updateBtn);

        deleteBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deleteBtn.setFont(new Font("Sitka Text", Font.PLAIN, 16));
        deleteBtn.setForeground(new Color(0, 0, 0));
        deleteBtn.setBounds(429, 190, 124, 26);
        panel.add(deleteBtn);

        addGroupEtud.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addGroupEtud.setFont(new Font("Sitka Text", Font.PLAIN, 16));
        addGroupEtud.setForeground(new Color(0, 0, 0));
        addGroupEtud.setBounds(429, 250, 124, 26);
        panel.add(addGroupEtud);

        imprimerBtn.setFont(new Font("Sitka Text", Font.PLAIN, 16));
        imprimerBtn.setForeground(new Color(0, 0, 0));
        imprimerBtn.setBounds(898, 304, 140, 26);
        panel.add(imprimerBtn);

        fleche_Gauche.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        fleche_Gauche.setToolTipText("vers page precedent");
        fleche_Gauche.setIcon(new ImageIcon("src\\Images\\fleche gauche.png"));
        fleche_Gauche.setBounds(10, 1, 58, 35);
        panel.add(fleche_Gauche);

        fleche_Droite.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        fleche_Droite.setIcon(new ImageIcon("src\\Images\\fleche droit.png"));
        fleche_Droite.setToolTipText("vers page suivante");
        fleche_Droite.setBounds(996, 1, 58, 35);
        panel.add(fleche_Droite);

        gradientPanel.setOpaque(false);
        gradientPanel.setkGradientFocus(200);
        gradientPanel.kGradientFocus = 300;
        gradientPanel.kStartColor = new Color(255, 255, 153);
        gradientPanel.kEndColor = new Color(204, 255, 204);
        gradientPanel.setBounds(0, 0, 1298, 716);
        contentPane.add(gradientPanel);

        // set the models 
        filiereBox.setModel(controlEtudiant.initializeModelFiliere());
        controlEtudiant.ShowIntable(tableEtd);
        niveauBox.setModel(new DefaultComboBoxModel<>(new String[]{"Master 2eme annee", "Master 3eme annee", "Doctorat"}));
        setLocationRelativeTo(null);
        setTitle("Gestion des etudiants");
        setVisible(true);
    }

    private void executer() {
        tableEtd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getButton() == MouseEvent.BUTTON1) { // clique droite sur la souris
                    int indice = tableEtd.getSelectedRow();
                    if (indice != - 1) {

                        String id = tableEtd.getModel().getValueAt(indice, 0).toString();
                        Etudiant etudiant = controlEtudiant.getEtudiantByID(Integer.parseInt(id));
                        nomField.setText(etudiant.getNom());
                        prenomField.setText(etudiant.getPrenom());
                        emailField.setText(etudiant.getEmail());
                        niveauBox.setSelectedItem(etudiant.getNiveau());
                        filiereBox.setSelectedItem(controlFiliere.getFiliere(etudiant.getID_Filiere()).getNom());
                    }
                } else if (evt.getButton() == MouseEvent.BUTTON3) { // clique gauche sur la souris
                    tableEtd.clearSelection();  // Deselects all selected columns and rows.
                    vider();
                }
            }
        });

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nom = nomField.getText();
                String prenom = prenomField.getText();
                String email = emailField.getText();
                String niveau = niveauBox.getSelectedItem().toString();
                String filiere = "";
                Integer IDFiliere = -1;
                if (filiereBox.getSelectedItem() != null) {
                    filiere = filiereBox.getSelectedItem().toString();
                    IDFiliere = controlFiliere.getIdFiliereByName(filiere);
                }

                Etudiant etudiant = new Etudiant(nom, prenom, email, niveau, IDFiliere);

                if (controlEtudiant.addEtudiant(etudiant)) {
                    controlEtudiant.ShowIntable(tableEtd);
                    vider();
                }

            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlEtudiant.deleteEtudiant(tableEtd);
                controlEtudiant.ShowIntable(tableEtd);
                vider();

            }
        });

        addGroupEtud.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser selecteur = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files ", "xlsx");//"xls"
                selecteur.setFileFilter(filter);
                selecteur.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int choix = selecteur.showDialog(null, "choisir");
                if (choix == JFileChooser.APPROVE_OPTION) {
                    File fichier = selecteur.getSelectedFile();
                    String chemin = fichier.getAbsolutePath();
                    // teste if endswith
                    if (/*chemin.endsWith(".xls") ||*/chemin.endsWith(".xlsx")) {

                        int NumFeuille = 0; // la premiere feuille par defaut
                        int etat = 0;
                        String reponse = JOptionPane.showInputDialog(null, "Saise le numero de la feuille excel");
                        try {
                            NumFeuille = Integer.parseInt(reponse);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Erreur de saisie , la premiere feuille sera choisie par defaut ");
                            etat = 1;

                        }
                        if (etat == 0) {
                            // chemin de test "C:\\Users\\pc\\Desktop\\etudiant.xlsx"
                            controlEtudiant.addGroupEtudiant(chemin, NumFeuille);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Choisir un fichier excel .xlsx !! ");
                    }
                }
                controlEtudiant.ShowIntable(tableEtd);

            }
        });

        imprimerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser selecteur = new JFileChooser();

                selecteur.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                selecteur.setDialogTitle("choisir l'emplacement");
                String chemin = "src\\fichierImprime\\etudiant.pdf";
                int result = selecteur.showDialog(null, "choisir");
                if (result == JFileChooser.APPROVE_OPTION) {
                    File fichier = selecteur.getSelectedFile();
                    chemin = fichier.getAbsolutePath() + "\\etudiant.pdf";
                    controlEtudiant.ImprimerListeEtudiant(chemin);
                }

            }
        });

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nom = nomField.getText();
                String prenom = prenomField.getText();
                String email = emailField.getText();
                String niveau = niveauBox.getSelectedItem().toString();
                String filiere = "";
                Integer IDFiliere = -1;
                if (filiereBox.getSelectedItem() != null) {
                    filiere = filiereBox.getSelectedItem().toString();
                    IDFiliere = controlFiliere.getIdFiliereByName(filiere);
                }

                Etudiant etudiant = new Etudiant(nom, prenom, email, niveau, IDFiliere);
                int indice = tableEtd.getSelectedRow();
                Integer idetudiant = - 1;
                if (indice != -1) {
                    String parseId = tableEtd.getModel().getValueAt(indice, 0).toString();
                    idetudiant = Integer.parseInt(parseId);

                }
                Etudiant etudiant1 = controlEtudiant.getEtudiantByID(idetudiant);

                if (controlEtudiant.updateEtudiant(etudiant, tableEtd)) {
                    controlEtudiant.ShowIntable(tableEtd);
                    vider();
                }

                //Si user tente a modifier niveau on supprime par la suite tous les projets det etudiant
                // Car supposons qu' un etudiant de 2 eme annnee par ex  a affectue a un projet PFA ( qui concerne que  les etudiants de 2 eme annee ) 
                // apres on a modifie son niveau a un  doctorat , donc cas , dans table projet l'etudiant sera
                // affecte a projet PFA avec niveau Doctorat
                if (idetudiant != -1) {
                    if (!etudiant1.getNiveau().equals(etudiant.getNiveau())) {
                        JOptionPane.showMessageDialog(null, "Vous avez modifie le niveau de l'etudiant!!\nLes projets affectues pour cet etudiant vont etre supprimes");
                        controlProjet.deleteProjetByIDetud(etudiant1.getID());
                    }
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
                controlAcceuil.demarreProfesseur();
            }

        });
        fleche_Droite.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                controlAcceuil.demarreDepartement();
            }

        });

        SearchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {

                try {
                    String filtre = SearchField.getText();

                    TableRowSorter tr = new TableRowSorter(tableEtd.getModel());
                    tableEtd.setRowSorter(tr);
                    tr.setRowFilter(RowFilter.regexFilter(filtre, 0, 1, 2,3,4,5));
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

}
