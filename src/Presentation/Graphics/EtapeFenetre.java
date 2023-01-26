package Presentation.Graphics;

import Metier.Etape;
import Metier.Professeur;
import Metier.Projets;
import Presentation.ControlleurAcceuil;
import Presentation.ControlleurEtape;
import Presentation.ControlleurProfesseur;
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
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JSpinner;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class EtapeFenetre extends JFrame {

    private JPanel contentPane;
    private JTextField titreField;
    private JTable tableEtape;

    private JTextField DocField;
    private JTextField livraisonField;

    JButton chooseFileBtn;
    JLabel DeconnexionLabel;
    JButton deleteBtn;
    JButton updateBtn;
    JButton addBtn;
    JComboBox projetBox;
    JComboBox professeurBox;
    JSpinner dureeSpin;
    JButton chooseFileBtn1;
    JCheckBox Check_isEtape_Depart;
    JLabel prenomLabel;
    JLabel emailLabel;
    JLabel filiereLabel;
    JLabel niveauLabel;
    JPanel panelHome;
    JLabel HomeIcon;
    JLabel HomeLabel;
    JPanel panel;
    JLabel nomLabel;
    JLabel departementLabel;
    JScrollPane scrollPane;
    JLabel TitleLabel;
    JButton addGroupEtud;
    JButton imprimerBtn;
    JLabel fleche_Gauche;
    JLabel fleche_Droite;
    KGradientPanel gradientPanel;
    JLabel titreLabel;
    JLabel dureeLabel;
    JLabel dateDepartLabel;
    JLabel ChooselieuLabel;
    JLabel etudiantLabel;
    JPanel panelDeconnexion;
    JLabel logOutIcon;
    JLabel livraisonLabel;
    JLabel SearchLabel;
    JTextField SearchField;

    private ControlleurEtape controlleurEtape;
    private ControlleurProfesseur controlleurProfesseur;
    private ControlleurProjet controlleurProjets;
    private ControlleurAcceuil controlAcceuil;

    /*  public static void main(String[] args) {
         EtapeFenetre frame = new EtapeFenetre(new ControlleurEtape(), new ControlleurProfesseur(),
                            new ControlleurProjet(), new ControlleurAcceuil());
    }*/
    public EtapeFenetre(ControlleurEtape controlleurEtape, ControlleurProfesseur controlleurProfesseur,
            ControlleurProjet controlleurProjets, ControlleurAcceuil controlAcceuil) {
        initialiser(controlleurEtape, controlleurProfesseur, controlleurProjets, controlAcceuil);
        dessiner();
        executer();

    }

    private void initialiser(ControlleurEtape controlleurEtape, ControlleurProfesseur controlleurProfesseur,
            ControlleurProjet controlleurProjets, ControlleurAcceuil controlAcceuil) {
        this.controlleurEtape = controlleurEtape;
        this.controlleurProfesseur = controlleurProfesseur;
        this.controlleurProjets = controlleurProjets;
        this.controlAcceuil = controlAcceuil;

        contentPane = new JPanel();

        panel = new JPanel();
        dureeLabel = new JLabel("duree (sem)");

        dateDepartLabel = new JLabel("Documentation");

        ChooselieuLabel = new JLabel("professeur");

        etudiantLabel = new JLabel("projet");

        titreField = new JTextField();
        professeurBox = new JComboBox();

        projetBox = new JComboBox();

        tableEtape = new JTable();

        scrollPane = new JScrollPane();
        scrollPane.setBounds(46, 391, 1066, 174);
        scrollPane.setViewportView(tableEtape);
        panel.add(scrollPane);

        TitleLabel = new JLabel("Gestion des Etapes");
        titreLabel = new JLabel("titre");

        addBtn = new JButton("Ajouter");
        updateBtn = new JButton("Modifier");

        deleteBtn = new JButton("Supprimer");
        panelDeconnexion = new JPanel();

        logOutIcon = new JLabel("");

        DeconnexionLabel = new JLabel("Log out");

        dureeSpin = new JSpinner();

        DocField = new JTextField();

        chooseFileBtn = new JButton("");
        livraisonField = new JTextField();

        livraisonLabel = new JLabel("Livraison");
         SearchField = new JTextField();
        SearchLabel = new JLabel("Filtrer : ");
        chooseFileBtn1 = new JButton("");

        Check_isEtape_Depart = new JCheckBox("Definir comme etape de depart");

        gradientPanel = new KGradientPanel();

    }

    private void dessiner() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1174, 621);

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panel.setOpaque(false);
        panel.setBounds(0, 0, 1140, 576);
        contentPane.add(panel);
        panel.setLayout(null);

        titreLabel.setForeground(new Color(0, 0, 0));
        titreLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        titreLabel.setBounds(130, 119, 122, 28);
        panel.add(titreLabel);

        dureeLabel.setForeground(new Color(0, 0, 0));
        dureeLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        dureeLabel.setBounds(130, 158, 122, 43);
        panel.add(dureeLabel);

        dateDepartLabel.setForeground(new Color(0, 0, 0));
        dateDepartLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        dateDepartLabel.setBounds(130, 224, 140, 29);
        panel.add(dateDepartLabel);

        ChooselieuLabel.setForeground(new Color(0, 0, 0));
        ChooselieuLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        ChooselieuLabel.setBounds(130, 272, 122, 26);
        panel.add(ChooselieuLabel);

        etudiantLabel.setForeground(new Color(0, 0, 0));
        etudiantLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        etudiantLabel.setBounds(130, 320, 122, 28);
        panel.add(etudiantLabel);

        titreField.setFont(new Font("Arial", Font.PLAIN, 16));
        titreField.setBounds(293, 113, 217, 26);
        panel.add(titreField);
        titreField.setColumns(10);

        professeurBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        professeurBox.setBounds(295, 272, 217, 24);
        panel.add(professeurBox);

        projetBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        projetBox.setBounds(295, 323, 217, 24);
        panel.add(projetBox);

        tableEtape.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
        tableEtape.setFont(new Font("Segoe UI", 1, 12));
        tableEtape.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null},
                    {null, null, null, null, null}
                },
                new String[]{
                    "ID", "tutre", "professeur", "projet", "etape de depart"
                }
        ));
        tableEtape.setBounds(437, 55, 550, 262);

        scrollPane.setBounds(46, 391, 1066, 174);
        scrollPane.setViewportView(tableEtape);
        panel.add(scrollPane);

        TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        TitleLabel.setBackground(new Color(240, 240, 240));
        TitleLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
        TitleLabel.setForeground(new Color(153, 51, 204));
        TitleLabel.setBounds(353, 22, 424, 50);
        panel.add(TitleLabel);

        addBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addBtn.setFont(new Font("Sitka Text", Font.PLAIN, 16));
        addBtn.setForeground(new Color(0, 0, 0));
        addBtn.setBounds(579, 229, 124, 26);
        panel.add(addBtn);

        updateBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        updateBtn.setFont(new Font("Sitka Text", Font.PLAIN, 16));
        updateBtn.setForeground(new Color(0, 0, 0));

        updateBtn.setBounds(579, 276, 124, 26);
        panel.add(updateBtn);

        deleteBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deleteBtn.setFont(new Font("Sitka Text", Font.PLAIN, 16));
        deleteBtn.setForeground(new Color(0, 0, 0));

        deleteBtn.setBounds(579, 322, 124, 26);

        panel.add(deleteBtn);

        panelDeconnexion.setBounds(0, 1, 146, 49);
        panel.add(panelDeconnexion);
        panelDeconnexion.setOpaque(false);
        panelDeconnexion.setLayout(null);

        logOutIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logOutIcon.setIcon(new ImageIcon(EtapeFenetre.class.getResource("/Images/home.png")));
        logOutIcon.setBounds(10, 11, 49, 27);
        panelDeconnexion.add(logOutIcon);

        DeconnexionLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        DeconnexionLabel.setBounds(59, 19, 77, 20);
        panelDeconnexion.add(DeconnexionLabel);

        dureeSpin.setBounds(295, 166, 215, 23);
        panel.add(dureeSpin);

        DocField.setFont(new Font("Arial", Font.PLAIN, 11));
        DocField.setColumns(10);
        DocField.setBounds(293, 224, 163, 26);
        panel.add(DocField);

        chooseFileBtn.setIcon(new ImageIcon("src\\Images\\dossier.png"));
        chooseFileBtn.setBounds(466, 223, 42, 26);
        panel.add(chooseFileBtn);

        livraisonField.setFont(new Font("Arial", Font.PLAIN, 11));
        livraisonField.setColumns(10);
        livraisonField.setBounds(729, 118, 163, 26);
        panel.add(livraisonField);

        livraisonLabel.setForeground(Color.BLACK);
        livraisonLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        livraisonLabel.setBounds(579, 119, 140, 28);
        panel.add(livraisonLabel);

        chooseFileBtn1.setIcon(new ImageIcon("src\\Images\\dossier.png"));
        chooseFileBtn1.setBounds(902, 117, 42, 26);
        panel.add(chooseFileBtn1);

        Check_isEtape_Depart.setOpaque(false);
        Check_isEtape_Depart.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        Check_isEtape_Depart.setBounds(579, 166, 241, 28);
        panel.add(Check_isEtape_Depart);
        
         SearchField.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
        SearchField.setBounds(929, 358, 183, 22);
        panel.add(SearchField);
        SearchField.setColumns(10);

        SearchLabel.setIcon(new ImageIcon("src\\Images\\search.png"));
        SearchLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        SearchLabel.setBounds(823, 358, 99, 22);
        panel.add(SearchLabel);

        gradientPanel.setOpaque(false);
        gradientPanel.setkGradientFocus(200);
        gradientPanel.kGradientFocus = 300;
        gradientPanel.kStartColor = new Color(255, 255, 153);
        gradientPanel.kEndColor = new Color(204, 255, 204);
        gradientPanel.setBounds(0, 0, 1298, 716);
        contentPane.add(gradientPanel);

        //set the models :
        controlleurEtape.ShowIntable(tableEtape);
        professeurBox.setModel(controlleurEtape.initializeModelProfesseur());
        projetBox.setModel(controlleurEtape.initializeModelProjet());

        setLocationRelativeTo(null);
        setTitle("Gestion des Etapes");
        setVisible(true);
    }

    private void executer() {

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlleurEtape.deleteEtape(tableEtape);
                controlleurEtape.ShowIntable(tableEtape);

                vider();

            }
        });

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titre = titreField.getText();
                Integer duree = (Integer) dureeSpin.getValue();
                boolean isetape_depart = Check_isEtape_Depart.isSelected();
                String documentation = DocField.getText();
                String livraison = livraisonField.getText();
                Integer IDProfesseur = -1;
                Integer IDProjet = -1;
                String projet = "";
                if (professeurBox.getSelectedItem() != null) {
                    String prof = professeurBox.getSelectedItem().toString().split("\\s+")[0];
                    IDProfesseur = Integer.parseInt(prof);
                }
                if (projetBox.getSelectedItem() != null) {
                    projet = projetBox.getSelectedItem().toString().split("\\s+")[0];
                    IDProjet = Integer.parseInt(projet);
                }
                Etape etape = new Etape(titre, duree, documentation, livraison, IDProfesseur, IDProjet);
                if (controlleurEtape.addEtape(etape, isetape_depart)) {
                    controlleurEtape.ShowIntable(tableEtape);
                    //  archive sera mis a jour a par non  
                    controlleurProfesseur.updateProfesseurSetStateArchive(etape.getIDProfesseur());
                    vider();
                }

            }
        });

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titre = titreField.getText();
                Integer duree = (Integer) dureeSpin.getValue();
                boolean isetape_depart = Check_isEtape_Depart.isSelected();

                String documentation = DocField.getText();
                String livraison = livraisonField.getText();
                Integer IDProfesseur = -1;
                Integer IDProjet = -1;
                String projet = "";
                if (professeurBox.getSelectedItem() != null) {
                    String prof = professeurBox.getSelectedItem().toString().split("\\s+")[0];
                    IDProfesseur = Integer.parseInt(prof);
                }
                if (projetBox.getSelectedItem() != null) {
                    projet = projetBox.getSelectedItem().toString().split("\\s+")[0];
                    IDProjet = Integer.parseInt(projet);
                }
                Etape etape = new Etape(titre, duree, documentation, livraison, IDProfesseur, IDProjet);
                if (controlleurEtape.updateEtape(tableEtape, etape, isetape_depart)) {
                    //  archive sera mis a jour a par non  
                    controlleurProfesseur.updateProfesseurSetStateArchive(etape.getIDProfesseur());
                    controlleurEtape.ShowIntable(tableEtape);
                    vider();
                }

            }
        });

        tableEtape.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getButton() == MouseEvent.BUTTON1) { // clique droite sur la souris
                    int indice = tableEtape.getSelectedRow();
                    if (indice != - 1) {
                        int id_prof = -1;
                        String id = tableEtape.getModel().getValueAt(indice, 0).toString();
                        Etape etape = controlleurEtape.getEtapeByID(Integer.parseInt(id));

                        if (etape.getEtape_depart().equals("Pas definie")) {
                            Check_isEtape_Depart.setSelected(false);
                        } else {
                            int idEtapeFromTable = Integer.parseInt(etape.getEtape_depart().split("\\s+")[0]);

                            if (idEtapeFromTable == Integer.parseInt(id)) {
                                Check_isEtape_Depart.setSelected(true);
                            } else {
                                Check_isEtape_Depart.setSelected(false);
                            }
                        }
                        titreField.setText(etape.getTitre());
                        dureeSpin.setValue(etape.getDuree());
                        DocField.setText(etape.getDocumentation());
                        livraisonField.setText(etape.getLivraison());
                        id_prof = etape.getIDProfesseur();
                        Projets projet = controlleurProjets.getProjetById(etape.getIDProjet());

                        projetBox.setSelectedItem(projet.getIDProjet() + " " + projet.getTitre());

                        Professeur professeur = controlleurProfesseur.getProfesseurByID(id_prof);
                        professeurBox.setSelectedItem(professeur.getID() + " " + professeur.getNom() + " " + professeur.getPrenom());

                    } else if (evt.getButton() == MouseEvent.BUTTON3) { // clique gauche sur la souris
                        tableEtape.clearSelection();  // Deselects all selected columns and rows.
                        vider();
                    }
                }
            }
        });

        chooseFileBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser selecteur = new JFileChooser();

                selecteur.setFileSelectionMode(JFileChooser.FILES_ONLY);
                selecteur.setDialogTitle("choisir un fichier");
                String chemin = "";
                int result = selecteur.showDialog(null, "choisir");
                if (result == JFileChooser.APPROVE_OPTION) {
                    File fichier = selecteur.getSelectedFile();
                    chemin = fichier.getAbsolutePath();
                    livraisonField.setText(chemin);
                }

            }
        });

        chooseFileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser selecteur = new JFileChooser();

                selecteur.setFileSelectionMode(JFileChooser.FILES_ONLY);
                selecteur.setDialogTitle("choisir un fichier");
                String chemin = "";
                int result = selecteur.showDialog(null, "choisir");
                if (result == JFileChooser.APPROVE_OPTION) {
                    File fichier = selecteur.getSelectedFile();
                    chemin = fichier.getAbsolutePath();
                    DocField.setText(chemin);
                }

            }
        });

        logOutIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                controlAcceuil.exit_Acceuil();
            }

        });
        
           SearchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {

                try {
                    String filtre = SearchField.getText();

                    TableRowSorter tr = new TableRowSorter(tableEtape.getModel());
                    tableEtape.setRowSorter(tr);
                    tr.setRowFilter(RowFilter.regexFilter(filtre, 0, 1, 2,3,4,5));
                } catch (Exception ex) {

                }
            }
        });
    }

    private void vider() {
        titreField.setText("");
        dureeSpin.setValue(0);
        DocField.setText("");
        livraisonField.setText("");

    }
}
