package Presentation.Graphics;

import Metier.Filiere;
import Presentation.ControlleurAcceuil;
import Presentation.ControlleurDepartement;
import Presentation.ControlleurFiliere;
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import keeptoo.KGradientPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class FiliereFenetre extends JFrame {

    private JPanel contentPane;
    private JTextField nomField;
    private JTable tableFiliere;
    private ControlleurFiliere controlFiliere;
    private JComboBox departementBox;
    private ControlleurDepartement controlDepartement;
    private ControlleurAcceuil controlAcceuil;
    JPanel panelHome;
    JLabel HomeIcon;
    JLabel HomeLabel;
    JPanel panel;
    JLabel nomLabel;
    JLabel departementLabel;
    JScrollPane scrollPane;
    JLabel TitleLabel;
    JButton addBtn;
    JButton updateBtn;
    JButton deleteBtn;
    JLabel SearchLabel;
    JTextField SearchField;
    JLabel fleche_Gauche;
    JLabel fleche_Droite;
    KGradientPanel gradientPanel;

   /*   public static void main(String[] args) {
        FiliereFenetre frame = new FiliereFenetre(new ControlleurFiliere(),
                            new ControlleurDepartement(), new ControlleurAcceuil());
    }*/
    public FiliereFenetre(ControlleurFiliere controlFiliere, ControlleurDepartement controlDepartement,
            ControlleurAcceuil controlAcceuil) {
        initialiser(controlFiliere, controlDepartement, controlAcceuil);
        dessiner();
        executer();

    }

    private void initialiser(ControlleurFiliere controlFiliere, ControlleurDepartement controlDepartement,
            ControlleurAcceuil controlAcceuil) {
        this.controlFiliere = controlFiliere;
        this.controlAcceuil = controlAcceuil;
        this.controlDepartement = controlDepartement;
        contentPane = new JPanel();
        panelHome = new JPanel();
        HomeIcon = new JLabel("");
        HomeLabel = new JLabel("Home");

        panel = new JPanel();
        nomLabel = new JLabel("Nom");
        departementLabel = new JLabel("Departement");
        nomField = new JTextField();

        departementBox = new JComboBox();
        tableFiliere = new JTable();

        scrollPane = new JScrollPane();

        TitleLabel = new JLabel("Gestion des Filieres");

        addBtn = new JButton("Ajouter");
        updateBtn = new JButton("Modifier");
        deleteBtn = new JButton("Supprimer");
        SearchField = new JTextField();
        SearchLabel = new JLabel("Filtrer : ");

        fleche_Gauche = new JLabel("");
        fleche_Droite = new JLabel("");
        gradientPanel = new KGradientPanel();

    }

    private void dessiner() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1153, 507);

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panelHome.setOpaque(false);
        panelHome.setBounds(0, 0, 120, 49);
        contentPane.add(panelHome);
        panelHome.setLayout(null);

        HomeIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        HomeIcon.setIcon(new ImageIcon(FiliereFenetre.class.getResource("/Images/home.png")));
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

        departementLabel.setForeground(new Color(0, 0, 0));
        departementLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        departementLabel.setBounds(22, 163, 122, 43);
        panel.add(departementLabel);

        nomField.setFont(new Font("Arial", Font.PLAIN, 13));
        nomField.setBounds(152, 124, 217, 26);
        panel.add(nomField);
        nomField.setColumns(10);

        departementBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        departementBox.setBounds(154, 177, 217, 24);
        panel.add(departementBox);

        SearchField.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
        SearchField.setBounds(874, 47, 183, 22);
        panel.add(SearchField);
        SearchField.setColumns(10);

        SearchLabel.setIcon(new ImageIcon("src\\Images\\search.png"));
        SearchLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        SearchLabel.setBounds(768, 47, 99, 22);
        panel.add(SearchLabel);

        tableFiliere.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
        tableFiliere.setFont(new Font("Segoe UI", 1, 12));
        tableFiliere.setModel(new DefaultTableModel(
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
                    "ID Filiere", "Nom", "Departement"
                }
        ) {
            boolean[] columnEditables = new boolean[]{
                false, false, false
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        tableFiliere.setBounds(437, 55, 550, 262);

        scrollPane.setBounds(411, 77, 646, 174);
        scrollPane.setViewportView(tableFiliere);
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
        addBtn.setBounds(22, 262, 124, 26);
        panel.add(addBtn);

        updateBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        updateBtn.setFont(new Font("Sitka Text", Font.PLAIN, 16));
        updateBtn.setForeground(new Color(0, 0, 0));
        updateBtn.setBounds(179, 262, 124, 26);
        panel.add(updateBtn);

        deleteBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deleteBtn.setFont(new Font("Sitka Text", Font.PLAIN, 16));
        deleteBtn.setForeground(new Color(0, 0, 0));
        deleteBtn.setBounds(328, 262, 124, 26);
        panel.add(deleteBtn);

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

        // set the models :
        departementBox.setModel(controlFiliere.initializeModelDepartement());
        controlFiliere.ShowIntable(tableFiliere);
        setLocationRelativeTo(null);
        setTitle("Gestion des Filieres");
        setVisible(true);

    }

    private void executer() {

        tableFiliere.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getButton() == MouseEvent.BUTTON1) { // clique droite sur la souris
                    int indice = tableFiliere.getSelectedRow();
                    if (indice != - 1) {

                        String id = tableFiliere.getModel().getValueAt(indice, 0).toString();
                        Filiere filiere = controlFiliere.getFiliere(Integer.parseInt(id));
                        nomField.setText(filiere.getNom());
                        departementBox.setSelectedItem(controlDepartement.getDepartement(filiere.getDepartement()).getNom());
                    }
                } else if (evt.getButton() == MouseEvent.BUTTON3) { // clique gauche sur la souris
                    tableFiliere.clearSelection();  // Deselects all selected columns and rows.
                    vider();
                }
            }
        });

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nom = nomField.getText();
                String departement = "";
                Integer ID_Departement = -1;
                if (departementBox.getSelectedItem() != null) {
                    departement = departementBox.getSelectedItem().toString();
                    ID_Departement = controlDepartement.getIdDepartementByName(departement);
                }

                Filiere filiere = new Filiere(nom, ID_Departement);
                controlFiliere.addFiliere(filiere);
                controlFiliere.ShowIntable(tableFiliere);
                vider();
            }
        });
        HomeIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                controlAcceuil.demarre_Acceuil();
            }

        });

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlFiliere.deleteFiliere(tableFiliere);
                controlFiliere.ShowIntable(tableFiliere);
                vider();

            }
        });

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nom = nomField.getText();
                String departement = departementBox.getSelectedItem().toString();
                Integer ID_Departement = controlDepartement.getIdDepartementByName(departement);
                Filiere filiere = new Filiere(nom, ID_Departement);
                controlFiliere.updateFiliere(filiere, tableFiliere);
                controlFiliere.ShowIntable(tableFiliere);

                vider();
            }
        });
        fleche_Gauche.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                controlAcceuil.demarreDepartement();
            }

        });
        fleche_Droite.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                controlAcceuil.demarreLabo();
            }

        });
            SearchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {

                try {
                    String filtre = SearchField.getText();

                    TableRowSorter tr = new TableRowSorter(tableFiliere.getModel());
                    tableFiliere.setRowSorter(tr);
                    tr.setRowFilter(RowFilter.regexFilter(filtre, 0, 1, 2));
                } catch (Exception ex) {

                }
            }
        });

    }

    void vider() {
        nomField.setText("");
    }
}
