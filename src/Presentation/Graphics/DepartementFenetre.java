package Presentation.Graphics;

import Metier.Departement;
import Presentation.ControlleurAcceuil;
import Presentation.ControlleurDepartement;
import Presentation.ControlleurProfesseur;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import keeptoo.KGradientPanel;

public class DepartementFenetre extends JFrame {

    int n = 0;
    private JPanel contentPane;
    private JTextField nomField;
    private JTable tableDepartement;
    private JTextField emailField;
    private ControlleurProfesseur controlleurProfesseur;
    private ControlleurDepartement controlDepartement;
    private ControlleurAcceuil controlAcceuil;
    private JTable tableMembres;
    private JButton showMembreBtn;

    private JLabel LabelMembre;

    private JScrollPane scrollMembresLab;
    private JLabel fleche_Droite;
    private JLabel fleche_Gauche;
    private JButton deleteBtn;
    private JButton updateBtn;
    private JButton addBtn;
    private JLabel TitleLabel;
    private JScrollPane scrollPane;
    private JTextField SearchFieldDepart;
    private JLabel SearchLabelDepart;
    private JLabel SearchLabel;
    private JTextField SearchField;

    private JLabel emaliLabel;
    private JLabel nomLabel;
    private JPanel panel;
    private JLabel HomeLabel;
    private JLabel HomeIcon;
    private JPanel panelHome;
    private KGradientPanel gradientPanel;

    /*  pour tester
    public static void main(String[] args) {
        DepartementFenetre frame = new DepartementFenetre(new ControlleurDepartement(),
                new ControlleurAcceuil(), new ControlleurProfesseur());
    }*/

    public DepartementFenetre(ControlleurDepartement controlDepartement,
            ControlleurAcceuil controlAcceuil, ControlleurProfesseur controlleurProfesseur) {
        initialiser(controlDepartement, controlAcceuil, controlleurProfesseur);
        dessiner();
        executer();
    }

    private void initialiser(ControlleurDepartement controlDepartement,
            ControlleurAcceuil controlAcceuil, ControlleurProfesseur controlleurProfesseur) {
        this.controlDepartement = controlDepartement;
        this.controlAcceuil = controlAcceuil;
        this.controlleurProfesseur = controlleurProfesseur;

        contentPane = new JPanel();

        panelHome = new JPanel();

        HomeIcon = new JLabel("");

        HomeLabel = new JLabel("Home");

        panel = new JPanel();

        nomLabel = new JLabel("Nom");

        emaliLabel = new JLabel("email");

        nomField = new JTextField();

        tableDepartement = new JTable();

        scrollPane = new JScrollPane();

        TitleLabel = new JLabel("Gestion des Departements");

        addBtn = new JButton("Ajouter");

        updateBtn = new JButton("Modifier");

        deleteBtn = new JButton("Supprimer");

        fleche_Gauche = new JLabel("");

        fleche_Droite = new JLabel("");

        emailField = new JTextField();

        showMembreBtn = new JButton("Afficher les membres");
        SearchFieldDepart = new JTextField();
        SearchLabelDepart = new JLabel("Filtrer : ");
        SearchLabel = new JLabel("Filtrer : ");
        SearchField = new JTextField();

        scrollMembresLab = new JScrollPane();

        tableMembres = new JTable();
        gradientPanel = new KGradientPanel();

    }

    private void dessiner() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1153, 607);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panelHome.setOpaque(false);
        panelHome.setBounds(0, 0, 120, 49);
        contentPane.add(panelHome);
        panelHome.setLayout(null);

        HomeIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        HomeIcon.setIcon(new ImageIcon(DepartementFenetre.class.getResource("/Images/home.png")));
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
        nomLabel.setBounds(22, 124, 122, 28);
        panel.add(nomLabel);

        emaliLabel.setForeground(new Color(0, 0, 0));
        emaliLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        emaliLabel.setBounds(22, 163, 122, 43);
        panel.add(emaliLabel);

        nomField.setFont(new Font("Arial", Font.PLAIN, 16));
        nomField.setBounds(152, 124, 217, 26);
        panel.add(nomField);
        nomField.setColumns(10);

        SearchField.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
        SearchField.setBounds(702, 282, 140, 22);
        panel.add(SearchField);
         SearchField.setVisible(false);
        SearchField.setColumns(10);

        SearchLabel.setIcon(new ImageIcon("src\\Images\\search.png"));
        SearchLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        SearchLabel.setBounds(596, 282, 99, 22);
        SearchLabel.setVisible(false);
        panel.add(SearchLabel);
         
                   

        SearchLabelDepart.setIcon(new ImageIcon("src\\Images\\search.png"));
        SearchLabelDepart.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        SearchLabelDepart.setBounds(768, 44, 99, 22);
        panel.add(SearchLabelDepart);

        SearchFieldDepart.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
        SearchFieldDepart.setColumns(10);
        SearchFieldDepart.setBounds(874, 44, 183, 22);
        panel.add(SearchFieldDepart);

        tableDepartement.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
        tableDepartement.setFont(new Font("Segoe UI", 1, 12));
        tableDepartement.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},},
                new String[]{
                    "ID Departement", "Nom", "email"
                }
        ) {
            boolean[] columnEditables = new boolean[]{
                false, false, false
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        tableDepartement.setBounds(437, 55, 550, 262);

        scrollPane.setBounds(411, 77, 646, 174);
        scrollPane.setViewportView(tableDepartement);
        panel.add(scrollPane);

        TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        TitleLabel.setBackground(new Color(240, 240, 240));
        TitleLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
        TitleLabel.setForeground(new Color(153, 51, 204));
        TitleLabel.setBounds(264, 1, 461, 40);
        panel.add(TitleLabel);

        //    addBtn.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, null));
        addBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addBtn.setFont(new Font("Sitka Text", Font.PLAIN, 16));
        addBtn.setForeground(new Color(0, 0, 0));
        addBtn.setBounds(22, 231, 102, 26);
        panel.add(addBtn);

        updateBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        updateBtn.setFont(new Font("Sitka Text", Font.PLAIN, 16));
        updateBtn.setForeground(new Color(0, 0, 0));
        updateBtn.setBounds(152, 231, 102, 26);
        panel.add(updateBtn);

        // deleteBtn.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, null));
        deleteBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deleteBtn.setFont(new Font("Sitka Text", Font.PLAIN, 16));
        deleteBtn.setForeground(new Color(0, 0, 0));
        deleteBtn.setBounds(274, 231, 122, 26);
        panel.add(deleteBtn);

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

        emailField.setFont(new Font("Arial", Font.PLAIN, 16));
        emailField.setColumns(10);
        emailField.setBounds(152, 177, 217, 26);
        panel.add(emailField);

        showMembreBtn.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.LIGHT_GRAY, null));
        showMembreBtn.setToolTipText("Cliquez pour afficher les membres en selectionnant une ligne dans table departement au dessus  ");
        showMembreBtn.setForeground(Color.BLACK);
        showMembreBtn.setFont(new Font("Sitka Text", Font.PLAIN, 13));
        showMembreBtn.setBounds(884, 275, 173, 26);
        panel.add(showMembreBtn);

        scrollMembresLab.setVisible(false);
        scrollMembresLab.setBounds(411, 323, 646, 174);
        LabelMembre = new JLabel("Les professeurs  :");
        LabelMembre.setForeground(Color.BLACK);
        LabelMembre.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        LabelMembre.setBounds(413, 279, 162, 28);
        LabelMembre.setVisible(false);
        panel.add(LabelMembre);

        tableMembres.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
        tableMembres.setFont(new Font("Segoe UI", 1, 12));
        tableMembres.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},},
                new String[]{
                    "id_prof", "nom", "prenom", "role"
                }
        ) {
            boolean[] columnEditables = new boolean[]{
                false, false, false
            };

            public boolean isCellEditable(int row, int column) {
                return false ;
            }
        });
        tableMembres.setBounds(411, 323, 646, 174);

        scrollMembresLab.setViewportView(tableMembres);
        panel.add(scrollMembresLab);

        gradientPanel.setOpaque(false);
        gradientPanel.setkGradientFocus(200);
        gradientPanel.kGradientFocus = 300;
        gradientPanel.kStartColor = new Color(255, 255, 153);
        gradientPanel.kEndColor = new Color(204, 255, 204);
        gradientPanel.setBounds(0, 0, 1298, 716);
        contentPane.add(gradientPanel);

        controlDepartement.ShowIntable(tableDepartement);
        setLocationRelativeTo(null);
        setTitle("Gestion des Departements");
        setVisible(true);
    }

    private void executer() {
        showMembreBtn.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

                if (n % 2 == 0) {
                    scrollMembresLab.setVisible(true);
                    LabelMembre.setVisible(true);
                    showMembreBtn.setText("Masquer");
                    SearchLabel.setVisible(true);
                    SearchField.setVisible(true);
                    n++;
                } else {
                    scrollMembresLab.setVisible(false);
                    showMembreBtn.setText("Afficher les membres");
                    LabelMembre.setVisible(false);
                     SearchField.setVisible(false);
                      SearchLabel.setVisible(false);
                    n++;
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
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nom = nomField.getText();
                String email = emailField.getText();
                Departement depart = new Departement(nom, email);
                if (controlDepartement.addDepartement(depart)) {
                    controlDepartement.ShowIntable(tableDepartement);
                    vider();
                }

            }
        });

        tableDepartement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getButton() == MouseEvent.BUTTON1) { // clique droite sur la souris
                    int indice = tableDepartement.getSelectedRow();
                    if (indice != - 1) {

                        String id = tableDepartement.getModel().getValueAt(indice, 0).toString();
                        Departement depart = controlDepartement.getDepartement(Integer.parseInt(id));
                        nomField.setText(depart.getNom());
                        emailField.setText(depart.getEmail());
                        controlleurProfesseur.ShowIntableMembreDepartement(tableMembres, Integer.parseInt(id));

                    }
                } else if (evt.getButton() == MouseEvent.BUTTON3) { // clique gauche sur la souris
                    tableDepartement.clearSelection();  // Deselects all selected columns and rows.
                    vider();
                }
            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlDepartement.deleteDepartement(tableDepartement);
                controlDepartement.ShowIntable(tableDepartement);
                vider();

            }
        });

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nom = nomField.getText();
                String email = emailField.getText();
                Departement depart = new Departement(nom, email);
                if (controlDepartement.updateDepartement(depart, tableDepartement)) {
                    controlDepartement.ShowIntable(tableDepartement);

                    vider();
                }

            }
        });

        fleche_Gauche.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                controlAcceuil.demarreEtudiant();
            }

        });
        fleche_Droite.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                controlAcceuil.demarreFiliere();
            }

        });
          SearchFieldDepart.addKeyListener(new KeyAdapter() {
	    	@Override
	    	public void keyReleased(KeyEvent e) {
                    try {
                    String filtre = SearchFieldDepart.getText();

                    TableRowSorter tr = new TableRowSorter(tableDepartement.getModel());
                    tableDepartement.setRowSorter(tr);
                    tr.setRowFilter(RowFilter.regexFilter(filtre, 0, 1, 2));
                } catch (Exception ex) {

                } 
	    	}
	    });
            SearchField.addKeyListener(new KeyAdapter() {
	    	@Override
	    	public void keyReleased(KeyEvent e) {
                     try {
                    String filtre = SearchField.getText();

                    TableRowSorter tr = new TableRowSorter(tableMembres.getModel());
                    tableMembres.setRowSorter(tr);
                    tr.setRowFilter(RowFilter.regexFilter(filtre, 0, 1, 2));
                } catch (Exception ex) {

                }
	    	}
	    });

    }

    void vider() {
        nomField.setText("");
        emailField.setText("");
    }
}
