package Presentation.Graphics;

import Metier.Utilisateurs;
import Presentation.ControlleurAcceuil;
import Presentation.ControlleurUtilisateurs;

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
import javax.swing.DefaultComboBoxModel;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class UsersFenetre extends JFrame {

    private JPanel contentPane;
    private JTextField nomField;
    private JTextField passwordField;
    private JTable tableUtilisateurs;
    ControlleurUtilisateurs controlleurUtilisateurs;
    ControlleurAcceuil controlleurAcceuil;
    JButton addBtn;
    JButton updateBtn;
    JButton deleteBtn;
    JComboBox MetierBox;
    JPanel panelHome;
    JLabel HomeIcon;
    JLabel HomeLabel;
    JPanel panel;
    JLabel fleche_Droite;
    JLabel usernomLabel;
    JLabel passwordLabel;
    JLabel metierLabel;
    JLabel SearchLabel;
    JTextField SearchField;

    JScrollPane scrollPane;
    JLabel TitleLabel;
    KGradientPanel gradientPanel;

    /* public static void main(String[] args) {
       UsersFenetre frame = new UsersFenetre(new ControlleurUtilisateurs(), new ControlleurAcceuil());
    }*/
    public UsersFenetre(ControlleurUtilisateurs controlleurUtilisateurs, ControlleurAcceuil controlleurAcceuil) {
        initialiser(controlleurUtilisateurs, controlleurAcceuil);
        dessiner();
        executer();
    }

    private void initialiser(ControlleurUtilisateurs controlleurUtilisateurs, ControlleurAcceuil controlleurAcceuil) {
        this.controlleurUtilisateurs = controlleurUtilisateurs;
        this.controlleurAcceuil = controlleurAcceuil;
        contentPane = new JPanel();
        panelHome = new JPanel();
        HomeIcon = new JLabel("");
        HomeLabel = new JLabel("Home");
        panel = new JPanel();
        fleche_Droite = new JLabel("");
        usernomLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        metierLabel = new JLabel("Metier ");
        nomField = new JTextField();
        passwordField = new JTextField();
        MetierBox = new JComboBox();
        tableUtilisateurs = new JTable();
        scrollPane = new JScrollPane();
        TitleLabel = new JLabel("Gestion des Utilisateurs");
        addBtn = new JButton("Ajouter");
        updateBtn = new JButton("Modifier");
        deleteBtn = new JButton("Supprimer");
        SearchField = new JTextField();
        SearchLabel = new JLabel("Filtrer : ");

        gradientPanel = new KGradientPanel();

    }

    private void dessiner() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1174, 548);

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panelHome.setOpaque(false);
        panelHome.setBounds(0, 0, 120, 49);
        contentPane.add(panelHome);
        panelHome.setLayout(null);

        HomeIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        HomeIcon.setIcon(new ImageIcon(UsersFenetre.class.getResource("/Images/home.png")));
        HomeIcon.setBounds(10, 11, 49, 27);
        panelHome.add(HomeIcon);

        HomeLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        HomeLabel.setBounds(59, 19, 50, 15);
        panelHome.add(HomeLabel);

        panel.setOpaque(false);
        panel.setBounds(57, 54, 1083, 508);
        contentPane.add(panel);
        panel.setLayout(null);

        fleche_Droite.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        fleche_Droite.setIcon(new ImageIcon("src\\Images\\fleche droit.png"));
        fleche_Droite.setToolTipText("vers page suivante");
        fleche_Droite.setBounds(996, 1, 58, 35);
        panel.add(fleche_Droite);

        usernomLabel.setForeground(new Color(0, 0, 0));
        usernomLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        usernomLabel.setBounds(35, 71, 122, 28);
        panel.add(usernomLabel);

        passwordLabel.setForeground(new Color(0, 0, 0));
        passwordLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        passwordLabel.setBounds(35, 114, 122, 43);
        panel.add(passwordLabel);

        metierLabel.setForeground(new Color(0, 0, 0));
        metierLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        metierLabel.setBounds(33, 173, 122, 43);
        panel.add(metierLabel);

        nomField.setFont(new Font("Arial", Font.PLAIN, 16));
        nomField.setBounds(165, 71, 217, 26);
        panel.add(nomField);
        nomField.setColumns(10);

        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordField.setColumns(10);
        passwordField.setBounds(165, 121, 217, 26);
        panel.add(passwordField);

        MetierBox.setModel(new DefaultComboBoxModel(new String[]{"admin", "coordonnateur", "directeur du laboratoire", "professeur"}));
        MetierBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
        MetierBox.setBounds(165, 187, 217, 24);
        panel.add(MetierBox);

        SearchField.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
        SearchField.setBounds(820, 214, 183, 22);
        panel.add(SearchField);
        SearchField.setColumns(10);

        SearchLabel.setIcon(new ImageIcon("src\\Images\\search.png"));
        SearchLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        SearchLabel.setBounds(711, 214, 99, 22);
        panel.add(SearchLabel);

        tableUtilisateurs.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
        tableUtilisateurs.setFont(new Font("Segoe UI", 1, 12));
        tableUtilisateurs.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
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
                    "ID", "username", "password", "metier"
                }
        ));
        tableUtilisateurs.setBounds(437, 55, 550, 262);

        scrollPane.setBounds(10, 247, 993, 174);
        scrollPane.setViewportView(tableUtilisateurs);
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

        gradientPanel.setOpaque(false);
        gradientPanel.setkGradientFocus(200);
        gradientPanel.kGradientFocus = 300;
        gradientPanel.kStartColor = new Color(255, 255, 153);
        gradientPanel.kEndColor = new Color(204, 255, 204);
        gradientPanel.setBounds(0, 0, 1298, 716);
        contentPane.add(gradientPanel);

        controlleurUtilisateurs.ShowIntable(tableUtilisateurs);

        setLocationRelativeTo(null);
        setTitle("Gestion des Utilisateurs");
        setVisible(true);
    }

    private void executer() {
        HomeIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                controlleurAcceuil.demarre_Acceuil();
            }

        });
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nom = nomField.getText();
                String password = passwordField.getText();
                String metier = MetierBox.getSelectedItem().toString();

                Utilisateurs user = new Utilisateurs(nom, password, metier);

                if (controlleurUtilisateurs.addUser(user)) {
                    controlleurUtilisateurs.ShowIntable(tableUtilisateurs);
                    vider();
                }

            }
        });

        tableUtilisateurs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getButton() == MouseEvent.BUTTON1) { // clique droite sur la souris
                    int indice = tableUtilisateurs.getSelectedRow();
                    if (indice != - 1) {
                        String id = tableUtilisateurs.getModel().getValueAt(indice, 0).toString();
                        Utilisateurs user = controlleurUtilisateurs.getUserByID(Integer.parseInt(id));
                        nomField.setText(user.getUserName());
                        passwordField.setText(user.getPassword());
                        MetierBox.setSelectedItem(user.getMetier());

                    }
                } else if (evt.getButton() == MouseEvent.BUTTON3) { // clique gauche sur la souris
                    tableUtilisateurs.clearSelection();  // Deselects all selected columns and rows.
                    vider();
                }
            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlleurUtilisateurs.deleteUtilisateurs(tableUtilisateurs);
                controlleurUtilisateurs.ShowIntable(tableUtilisateurs);
                vider();

            }
        });

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nom = nomField.getText();
                String password = passwordField.getText();
                String metier = MetierBox.getSelectedItem().toString();

                Utilisateurs user = new Utilisateurs(nom, password, metier);
                if (controlleurUtilisateurs.updateUser(tableUtilisateurs, user)) {
                    controlleurUtilisateurs.ShowIntable(tableUtilisateurs);
                    vider();
                }

            }
        });

        fleche_Droite.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                controlleurAcceuil.demarreProfesseur();
            }

        });
        
        SearchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {

                try {
                    String filtre = SearchField.getText();

                    TableRowSorter tr = new TableRowSorter(tableUtilisateurs.getModel());
                    tableUtilisateurs.setRowSorter(tr);
                    tr.setRowFilter(RowFilter.regexFilter(filtre, 0, 1, 2,3));
                } catch (Exception ex) {

                }
            }
        });


    }

    private void vider() {
        nomField.setText("");
        passwordField.setText("");
    }
}
