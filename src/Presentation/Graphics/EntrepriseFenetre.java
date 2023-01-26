 
package Presentation.Graphics;

import Metier.Entreprise;
import Presentation.ControlleurAcceuil;
import Presentation.ControlleurEntreprise;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
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

public class EntrepriseFenetre extends JFrame {

    private JPanel contentPane;
    private JTextField raisonField;
    private JTextField adresseField;
    private JTextField emailField;
    private JTable tableEntrep;
    private JTextField telField;
    private JTextField responsableField;

    private ControlleurEntreprise controlEntrep;
    private ControlleurAcceuil controlAcceuil;
 
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
    JLabel SearchLabel ;
    JButton addBtn;
    JTextField SearchField ;
    JButton updateBtn;
    JButton deleteBtn;
    JButton addGroupEtud;
    JButton imprimerBtn;
    JLabel fleche_Gauche;
    JLabel fleche_Droite;
    KGradientPanel gradientPanel;
  /*  public static void main(String[] args) {
         EntrepriseFenetre frame = new EntrepriseFenetre(new ControlleurEntreprise(), new ControlleurAcceuil());      
    }*/


    public EntrepriseFenetre(ControlleurEntreprise controlEntrep, ControlleurAcceuil controlAcceuil) {
        initialiser(controlEntrep, controlAcceuil);
        dessiner();
        executer();
    }
    private void initialiser(ControlleurEntreprise controlEntrep,
            ControlleurAcceuil controlAcceuil) {
        this.controlEntrep = controlEntrep ;
        this.controlAcceuil =controlAcceuil ; 

        contentPane = new JPanel();
         panelHome = new JPanel();   
         HomeIcon = new JLabel("");    
         HomeLabel = new JLabel("Home");
        HomeLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        HomeLabel.setBounds(59, 19, 50, 15);
        panelHome.add(HomeLabel);
         panel = new JPanel();    
        nomLabel = new JLabel("raison sociale");
      
        prenomLabel = new JLabel("adresse");
        prenomLabel.setForeground(new Color(0, 0, 0));
        prenomLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        prenomLabel.setBounds(35, 114, 122, 43);
        panel.add(prenomLabel);

         emailLabel = new JLabel("email");
        filiereLabel = new JLabel("telephone");
      

         niveauLabel = new JLabel("responsable");
       
        raisonField = new JTextField();   
        adresseField = new JTextField();
        emailField = new JTextField();
      
        tableEntrep = new JTable();
      

        scrollPane = new JScrollPane();
       
         TitleLabel = new JLabel("Gestion des Entreprises");

        addBtn = new JButton("Ajouter");
       
         updateBtn = new JButton("Modifier");
        deleteBtn = new JButton("Supprimer");
       
         imprimerBtn = new JButton("Imprimer");
       
         fleche_Gauche = new JLabel("");
   
        telField = new JTextField();
      
        responsableField = new JTextField();
          SearchField = new JTextField();
	    
	     SearchLabel = new JLabel("Filtrer : ");
      
         gradientPanel = new KGradientPanel();
       
        
    }
    private void dessiner(){
           
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
        HomeIcon.setIcon(new ImageIcon(EntrepriseFenetre.class.getResource("/Images/home.png")));
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

        raisonField.setFont(new Font("Arial", Font.PLAIN, 16));
        raisonField.setBounds(165, 71, 217, 26);
        panel.add(raisonField);
        raisonField.setColumns(10);

        adresseField.setFont(new Font("Arial", Font.PLAIN, 16));
        adresseField.setColumns(10);
        adresseField.setBounds(165, 121, 217, 26);
        panel.add(adresseField);

        emailField.setFont(new Font("Arial", Font.PLAIN, 16));
        emailField.setColumns(10);
        emailField.setBounds(167, 185, 217, 26);
        panel.add(emailField);
        
         SearchLabel.setIcon(new ImageIcon("src\\Images\\search.png"));
	    SearchLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
	    SearchLabel.setBounds(578, 305, 99, 22);
	    panel.add(SearchLabel);
            
             SearchField.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
	    SearchField.setBounds(687, 306, 183, 22);
	    panel.add(SearchField);
	    SearchField.setColumns(10);

        tableEntrep.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
        tableEntrep.setFont(new Font("Segoe UI", 1, 12));
        tableEntrep.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},},
                new String[]{
                    "ID", "raison", "adresse", "email", "tel", "responsable"
                }
        ));
        tableEntrep.setBounds(437, 55, 550, 262);

        scrollPane.setBounds(45, 337, 993, 174);
        scrollPane.setViewportView(tableEntrep);
        panel.add(scrollPane);

        TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        TitleLabel.setBackground(new Color(240, 240, 240));
        TitleLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
        TitleLabel.setForeground(new Color(153, 51, 204));
        TitleLabel.setBounds(263, 1, 437, 40);
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

        imprimerBtn.setFont(new Font("Sitka Text", Font.PLAIN, 16));
        imprimerBtn.setForeground(new Color(0, 0, 0));
        imprimerBtn.setBounds(898, 304, 140, 26);
        panel.add(imprimerBtn);

        fleche_Gauche.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        fleche_Gauche.setToolTipText("vers page precedent");
        fleche_Gauche.setIcon(new ImageIcon("src\\Images\\fleche gauche.png"));
        fleche_Gauche.setBounds(10, 1, 58, 35);
        panel.add(fleche_Gauche);

        telField.setFont(new Font("Arial", Font.PLAIN, 16));
        telField.setColumns(10);
        telField.setBounds(165, 237, 217, 26);
        panel.add(telField);

        responsableField.setFont(new Font("Arial", Font.PLAIN, 16));
        responsableField.setColumns(10);
        responsableField.setBounds(165, 290, 217, 26);
        panel.add(responsableField);
    
        gradientPanel.setOpaque(false);
        gradientPanel.setkGradientFocus(200);
        gradientPanel.kGradientFocus = 300;
        gradientPanel.kStartColor = new Color(255, 255, 153);
        gradientPanel.kEndColor = new Color(204, 255, 204);
        gradientPanel.setBounds(0, 0, 1298, 716);
        contentPane.add(gradientPanel);

        controlEntrep.ShowIntable(tableEntrep);

        setLocationRelativeTo(null);
        setTitle("Gestion des Entreprises");
        setVisible(true);
    }
    private void executer(){
  tableEntrep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getButton() == MouseEvent.BUTTON1) { // clique droite sur la souris
                    int indice = tableEntrep.getSelectedRow();
                    if (indice != - 1) {

                        String id = tableEntrep.getModel().getValueAt(indice, 0).toString();

                        Entreprise entreprise = controlEntrep.getEntreprise(Integer.parseInt(id));
                        raisonField.setText(entreprise.getRaison());
                        adresseField.setText(entreprise.getAdresse());
                        emailField.setText(entreprise.getEmail());
                        responsableField.setText(entreprise.getResponsable());
                        telField.setText(entreprise.getTel());

                    }
                } else if (evt.getButton() == MouseEvent.BUTTON3) { // clique gauche sur la souris
                    tableEntrep.clearSelection();  // Deselects all selected columns and rows.
                    vider();
                }
            }
        });

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String raison = raisonField.getText();
                String adresse = adresseField.getText();
                String email = emailField.getText();
                String responsable = responsableField.getText();
                String tele = telField.getText();

                Entreprise entreprise = new Entreprise(raison, email, adresse, tele, responsable);
                if(controlEntrep.addEntreprise(entreprise)){
                    controlEntrep.ShowIntable(tableEntrep);
                vider();
                }
                
            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlEntrep.deleteEntreprise(tableEntrep);
                controlEntrep.ShowIntable(tableEntrep);
                vider();

            }
        });

        imprimerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser selecteur = new JFileChooser();

                selecteur.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                selecteur.setDialogTitle("choisir l'emplacement");
                String chemin = "src\\fichierImprime\\Entreprises.pdf";
                int result = selecteur.showDialog(null, "choisir");
                if (result == JFileChooser.APPROVE_OPTION) {
                    File fichier = selecteur.getSelectedFile();
                    chemin = fichier.getAbsolutePath() + "\\Entreprises.pdf";
                    controlEntrep.ImprimerListeEntreprise(chemin);
                }

            }
        });

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String raison = raisonField.getText();
                String adresse = adresseField.getText();
                String email = emailField.getText();
                String responsable = responsableField.getText();
                String tele = telField.getText();
              
                Entreprise entreprise = new Entreprise(raison, email ,adresse, tele, responsable);
                if( controlEntrep.updateEntreprise(entreprise, tableEntrep)){
                controlEntrep.ShowIntable(tableEntrep);
                vider();
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
                controlAcceuil.demarreLabo();
            }

        });
          
           SearchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {

                try {
                    String filtre = SearchField.getText();

                    TableRowSorter tr = new TableRowSorter(tableEntrep.getModel());
                    tableEntrep.setRowSorter(tr);
                    tr.setRowFilter(RowFilter.regexFilter(filtre, 0, 1, 2,3,4,5));
                } catch (Exception ex) {

                }
            }
        });
      
    }
    void vider() {
        raisonField.setText("");
        adresseField.setText("");
        emailField.setText("");
        responsableField.setText("");
        telField.setText("");
    }
}
