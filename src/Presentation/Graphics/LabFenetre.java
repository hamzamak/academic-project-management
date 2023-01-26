package Presentation.Graphics;

import Metier.Laboratoire;
import Presentation.ControlleurAcceuil;
import Presentation.ControlleurEtudiant;
import Presentation.ControlleurLab;
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

public class LabFenetre extends JFrame {

    int m = 0;
    int k = 0;

    private JPanel contentPane;
    private JTextField nomField;
    private JTable tableLab;
    private JTextField emailField;
    private ControlleurLab controlLab;
    private ControlleurAcceuil controlAcceuil;

    private ControlleurProfesseur controlleurProfesseur;
    private ControlleurEtudiant controlleurEtudiant;
    JButton showDoctorantBtn;
    JLabel LabelMembreDoctor;
    JButton deleteBtn;
    JButton updateBtn;
    JButton addBtn;
    JButton showProfBtn;
    JTable tableMembresDoc;
    JTable tableMembresProf;
    JScrollPane scrollDoctorantLab;
    JScrollPane scrollProfLab;
    JLabel LabelMembreProf;
    JScrollPane scrollPane;

    JPanel panelHome;
    JLabel HomeIcon;
    JLabel HomeLabel;
    JPanel panel;
    JLabel fleche_Gauche;
    JLabel fleche_Droite;
    JLabel nomLabel;
    JLabel emaliLabel;
    JLabel TitleLabel;
    JLabel SearchLabelLab;
    JLabel SearchLabelDoc;
    JLabel SearchLabelProf;
    JTextField SearchFieldProf;

    JTextField SearchFieldLab;
    JTextField SearchFieldDoctor;

    KGradientPanel gradientPanel;

   /* public static void main(String[] args) {
        LabFenetre frame = new LabFenetre(new ControlleurLab(), new ControlleurAcceuil(),
                new ControlleurProfesseur(), new ControlleurEtudiant());
    }*/

    public LabFenetre(ControlleurLab controlLab, ControlleurAcceuil controlAcceuil,
            ControlleurProfesseur controlleurProfesseur, ControlleurEtudiant controlleurEtudiant) {
        initialiser(controlLab, controlAcceuil, controlleurProfesseur, controlleurEtudiant);
        dessiner();
        executer();
    }

    private void initialiser(ControlleurLab controlLab, ControlleurAcceuil controlAcceuil,
            ControlleurProfesseur controlleurProfesseur, ControlleurEtudiant controlleurEtudiant) {
        this.controlLab = controlLab;
        this.controlAcceuil = controlAcceuil;
        this.controlleurProfesseur = controlleurProfesseur;
        this.controlleurEtudiant = controlleurEtudiant;
        contentPane = new JPanel();

        panelHome = new JPanel();

        HomeIcon = new JLabel("");
        HomeLabel = new JLabel("Home");
        panel = new JPanel();
        fleche_Gauche = new JLabel("");
        fleche_Droite = new JLabel("");
        nomLabel = new JLabel("Nom");
        emaliLabel = new JLabel("email");
        nomField = new JTextField();

        tableLab = new JTable();
        scrollPane = new JScrollPane();
        scrollProfLab = new JScrollPane();

        tableMembresProf = new JTable();
        scrollDoctorantLab = new JScrollPane();

        tableMembresDoc = new JTable();
        LabelMembreProf = new JLabel("Les professeurs  :");

        TitleLabel = new JLabel("Gestion des Laboratoires");
        showProfBtn = new JButton("Afficher les professeurs");
        addBtn = new JButton("Ajouter");
        updateBtn = new JButton("Modifier");
        deleteBtn = new JButton("Supprimer");
        emailField = new JTextField();
        LabelMembreDoctor = new JLabel("Les Doctorants:");
        showDoctorantBtn = new JButton("Afficher les Doctorants");
        SearchLabelLab = new JLabel("Filtrer : ");
        SearchFieldLab = new JTextField();
        SearchFieldDoctor = new JTextField();
        SearchLabelDoc = new JLabel("");
        SearchLabelProf = new JLabel("");
        SearchFieldProf = new JTextField();
        gradientPanel = new KGradientPanel();

    }

    private void dessiner() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1202, 626);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panelHome.setOpaque(false);
        panelHome.setBounds(0, 0, 120, 49);
        contentPane.add(panelHome);
        panelHome.setLayout(null);

        HomeIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        HomeIcon.setIcon(new ImageIcon(LabFenetre.class.getResource("/Images/home.png")));
        HomeIcon.setBounds(10, 11, 49, 27);
        panelHome.add(HomeIcon);

        HomeLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        HomeLabel.setBounds(59, 19, 50, 15);
        panelHome.add(HomeLabel);

        panel.setOpaque(false);
        panel.setBounds(57, 54, 1123, 508);
        contentPane.add(panel);
        panel.setLayout(null);

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

        tableLab.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
        tableLab.setFont(new Font("Segoe UI", 1, 12));
        tableLab.setModel(new DefaultTableModel(
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
                    "ID Lab", "Nom", "email"
                }
        ) {
            boolean[] columnEditables = new boolean[]{
                false, false, false
            };

            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        tableLab.setBounds(437, 55, 550, 262);

        scrollPane.setBounds(467, 77, 646, 174);
        scrollPane.setViewportView(tableLab);
        panel.add(scrollPane);

        scrollProfLab.setVisible(false);
        scrollProfLab.setBounds(533, 323, 580, 174);

        tableMembresProf.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
        tableMembresProf.setFont(new Font("Segoe UI", 1, 12));
        tableMembresProf.setModel(new DefaultTableModel(
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
                    "Id_prof", "nom", "prenom", "role"
                }
        ) {
            boolean[] columnEditables = new boolean[]{
                false, false, false
            };

            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        tableMembresProf.setBounds(411, 323, 646, 174);

        scrollProfLab.setViewportView(tableMembresProf);
        panel.add(scrollProfLab);

        scrollDoctorantLab.setVisible(false);
        scrollDoctorantLab.setBounds(10, 323, 477, 174);

        tableMembresDoc.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
        tableMembresDoc.setFont(new Font("Segoe UI", 1, 12));
        tableMembresDoc.setModel(new DefaultTableModel(
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
                    "id_etd", "nom", "prenom"
                }
        ) {
            boolean[] columnEditables = new boolean[]{
                false, false, false
            };

            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        tableMembresDoc.setBounds(200, 323, 646, 174);

        scrollDoctorantLab.setViewportView(tableMembresDoc);
        panel.add(scrollDoctorantLab);

        LabelMembreProf.setForeground(Color.BLACK);
        LabelMembreProf.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        LabelMembreProf.setVisible(false);
        LabelMembreProf.setBounds(533, 284, 162, 28);
        panel.add(LabelMembreProf);

        SearchFieldProf.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
        SearchFieldProf.setBounds(754, 290, 133, 22);
        panel.add(SearchFieldProf);

        SearchFieldProf.setVisible(false);
        SearchFieldProf.setColumns(10);

        SearchLabelProf.setIcon(new ImageIcon("src\\Images\\search.png"));
        SearchLabelProf.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        SearchLabelProf.setBounds(726, 290, 29, 22);

        SearchLabelProf.setVisible(false);
        panel.add(SearchLabelProf);

        SearchLabelLab.setIcon(new ImageIcon("src\\Images\\search.png"));
        SearchLabelLab.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        SearchLabelLab.setBounds(824, 47, 99, 22);
        panel.add(SearchLabelLab);

        SearchFieldLab.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
        SearchFieldLab.setColumns(10);
        SearchFieldLab.setBounds(930, 47, 183, 22);
        panel.add(SearchFieldLab);

        SearchFieldDoctor.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
        SearchFieldDoctor.setColumns(10);
        SearchFieldDoctor.setBounds(195, 290, 109, 22);
        SearchFieldDoctor.setVisible(false);
        panel.add(SearchFieldDoctor);

        SearchLabelDoc.setIcon(new ImageIcon("src\\Images\\search.png"));
        SearchLabelDoc.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        SearchLabelDoc.setBounds(163, 290, 29, 22);

        SearchLabelDoc.setVisible(false);
        panel.add(SearchLabelDoc);

        TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        TitleLabel.setBackground(new Color(240, 240, 240));
        TitleLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
        TitleLabel.setForeground(new Color(153, 51, 204));
        TitleLabel.setBounds(264, 1, 461, 40);
        panel.add(TitleLabel);

        showProfBtn.setToolTipText("veuilez selectionner une ligne dans le tableau du lab ci dessus pour affichier par la suite les membres professeurs");
        showProfBtn.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.LIGHT_GRAY, null));
        showProfBtn.setForeground(Color.BLACK);
        showProfBtn.setFont(new Font("Sitka Text", Font.PLAIN, 13));
        showProfBtn.setBounds(940, 286, 173, 26);
        panel.add(showProfBtn);

        addBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addBtn.setFont(new Font("Sitka Text", Font.PLAIN, 16));
        addBtn.setForeground(new Color(0, 0, 0));
        addBtn.setBounds(6, 229, 122, 26);
        panel.add(addBtn);

        updateBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        updateBtn.setFont(new Font("Sitka Text", Font.PLAIN, 16));
        updateBtn.setForeground(new Color(0, 0, 0));
        updateBtn.setBounds(138, 229, 124, 26);
        panel.add(updateBtn);

        deleteBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deleteBtn.setFont(new Font("Sitka Text", Font.PLAIN, 16));
        deleteBtn.setForeground(new Color(0, 0, 0));
        deleteBtn.setBounds(277, 229, 124, 26);
        panel.add(deleteBtn);

        emailField.setFont(new Font("Arial", Font.PLAIN, 16));
        emailField.setColumns(10);
        emailField.setBounds(152, 177, 217, 26);
        panel.add(emailField);

        LabelMembreDoctor.setForeground(Color.BLACK);
        LabelMembreDoctor.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        LabelMembreDoctor.setVisible(false);
        LabelMembreDoctor.setBounds(10, 284, 162, 28);
        panel.add(LabelMembreDoctor);

        showDoctorantBtn.setToolTipText("veuilez selectionner une ligne dans le tableau du lab ci dessus pour affichier par la suite les membres doctorant ");
        showDoctorantBtn.setForeground(Color.BLACK);
        showDoctorantBtn.setFont(new Font("Sitka Text", Font.PLAIN, 13));
        showDoctorantBtn.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.LIGHT_GRAY, null));
        showDoctorantBtn.setBounds(314, 286, 173, 26);
        panel.add(showDoctorantBtn);

        gradientPanel.setOpaque(false);
        gradientPanel.setkGradientFocus(200);
        gradientPanel.kGradientFocus = 300;
        gradientPanel.kStartColor = new Color(255, 255, 153);
        gradientPanel.kEndColor = new Color(204, 255, 204);
        gradientPanel.setBounds(0, 0, 1298, 716);
        contentPane.add(gradientPanel);

        controlLab.ShowIntable(tableLab);
        setLocationRelativeTo(null);
        setTitle("Gestion des Laboratoires");
        setVisible(true);
    }

    private void executer() {

        showProfBtn.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

                if (m % 2 == 0) {
                    scrollProfLab.setVisible(true);
                    LabelMembreProf.setVisible(true);
                    showProfBtn.setText("Masquer");
                    SearchFieldProf.setVisible(true);
                    SearchLabelProf.setVisible(true);
                    m++;

                } else {
                    scrollProfLab.setVisible(false);
                    LabelMembreProf.setVisible(false);
                    showProfBtn.setText("Afficher les professeurs");
                    SearchFieldProf.setVisible(false);
                    SearchLabelProf.setVisible(false);
                    m++;
                }
            }
        });

        showDoctorantBtn.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

                if (k % 2 == 0) {
                    scrollDoctorantLab.setVisible(true);
                    LabelMembreDoctor.setVisible(true);
                    SearchFieldDoctor.setVisible(true);
                    SearchLabelDoc.setVisible(true);
                    showDoctorantBtn.setText("Masquer");
                    k++;

                } else {
                    scrollDoctorantLab.setVisible(false);
                    LabelMembreDoctor.setVisible(false);
                    SearchFieldDoctor.setVisible(false);
                    SearchLabelDoc.setVisible(false);
                    showDoctorantBtn.setText("Afficher les Doctorants");
                    k++;
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
                Laboratoire lab = new Laboratoire(nom, email);
                if (controlLab.addLaboratoire(lab)) {
                    controlLab.ShowIntable(tableLab);
                    vider();
                }

            }
        });

        tableLab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getButton() == MouseEvent.BUTTON1) { // clique droite sur la souris
                    int indice = tableLab.getSelectedRow();
                    if (indice != - 1) {

                        String id = tableLab.getModel().getValueAt(indice, 0).toString();
                        Laboratoire lab = controlLab.getLaboratoire(Integer.parseInt(id));
                        nomField.setText(lab.getNom());
                        emailField.setText(lab.getEmail());
                        controlleurProfesseur.ShowIntableMembreLab(tableMembresProf, Integer.parseInt(id));
                        controlleurEtudiant.ShowIntableMembreDoctorat(tableMembresDoc, Integer.parseInt(id));

                    }
                } else if (evt.getButton() == MouseEvent.BUTTON3) { // clique gauche sur la souris
                    tableLab.clearSelection();  // Deselects all selected columns and rows.
                    vider();
                }
            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlLab.deleteLaboratoire(tableLab);
                controlLab.ShowIntable(tableLab);
                vider();

            }
        });

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nom = nomField.getText();
                String email = emailField.getText();
                Laboratoire lab = new Laboratoire(nom, email);
                if (controlLab.updateLaboratoire(lab, tableLab)) {
                    controlLab.ShowIntable(tableLab);
                    vider();
                }

            }
        });

        fleche_Gauche.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                controlAcceuil.demarreFiliere();
            }

        });
        fleche_Droite.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                controlAcceuil.demarreEntreprise();
            }

        });
        SearchFieldLab.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {

                try {
                    String filtre = SearchFieldLab.getText();

                    TableRowSorter tr = new TableRowSorter(tableLab.getModel());
                    tableLab.setRowSorter(tr);
                    tr.setRowFilter(RowFilter.regexFilter(filtre, 0, 1, 2));
                } catch (Exception ex) {

                }
            }
        });
        SearchFieldDoctor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {

                try {
                    String filtre = SearchFieldDoctor.getText();

                    TableRowSorter tr = new TableRowSorter(tableMembresDoc.getModel());
                    tableMembresDoc.setRowSorter(tr);
                    tr.setRowFilter(RowFilter.regexFilter(filtre, 0, 1, 2));
                } catch (Exception ex) {

                }
            }
        });

        SearchFieldProf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {

                try {
                    String filtre = SearchFieldProf.getText();

                    TableRowSorter tr = new TableRowSorter(tableMembresProf.getModel());
                    tableMembresProf.setRowSorter(tr);
                    tr.setRowFilter(RowFilter.regexFilter(filtre, 0, 1, 2, 3));
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
