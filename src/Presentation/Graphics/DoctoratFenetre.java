package Presentation.Graphics;

import Metier.Etudiant;
import Metier.Laboratoire;
import Metier.Projets;
import Presentation.ControlleurAcceuil;
import Presentation.ControlleurEtudiant;
import Presentation.ControlleurLab;
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
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class DoctoratFenetre extends JFrame {

    private JPanel contentPane;
    private JTextField titreField;
    private JTable tableProjetDoctorat;
    ControlleurProjet controlProjet;

    private ControlleurAcceuil controlAcceuil;
    private ControlleurEtudiant controlEtudiant;
    private ControlleurLab controlLab;
    JDateChooser dateDepartChooser;
    JSpinner dureeSpin;
    JButton deleteBtn;
    JButton updateBtn;
    JButton addBtn;
    JComboBox etudiantBox;
    JComboBox lieuBox;
    JPanel panel;
    JLabel titreLabel;
    JLabel dureeLabel;

    JLabel dateDepartLabel;
    JLabel ChooselieuLabel;
    JLabel etudiantLabel;
    JScrollPane scrollPane;

    JLabel TitleLabel;
    JPanel panelHome;

    JLabel HomeIcon;
    JLabel HomeLabel;
     JLabel SearchLabel;
    JTextField SearchField;
    KGradientPanel gradientPanel;

   /* pour tester :
    public static void main(String[] args) {           
               DoctoratFenetre frame = new DoctoratFenetre(new ControlleurProjet(), new ControlleurLab(),
                        new ControlleurEtudiant(), new ControlleurAcceuil());  }*/

    public DoctoratFenetre(ControlleurProjet controlProjet, ControlleurLab controlLab,
            ControlleurEtudiant controlEtudiant, ControlleurAcceuil controlAcceuil) {
        initialiser(controlProjet, controlLab, controlEtudiant , controlAcceuil);
        dessiner();
        executer();
    }

    private void initialiser(ControlleurProjet controlProjet, ControlleurLab controlLab,
            ControlleurEtudiant controlEtudiant, ControlleurAcceuil controlAcceuil) {
        this.controlProjet = controlProjet;
        this.controlLab = controlLab;
        this.controlEtudiant = controlEtudiant;
        this.controlAcceuil = controlAcceuil;

        contentPane = new JPanel();

        panel = new JPanel();

        titreLabel = new JLabel("titre");

        dureeLabel = new JLabel("duree (mois)");
        dateDepartLabel = new JLabel("date de depart");

        ChooselieuLabel = new JLabel("choisir le lieu");

        etudiantLabel = new JLabel("etudiant");

        titreField = new JTextField();
        lieuBox = new JComboBox();

        etudiantBox = new JComboBox();
        tableProjetDoctorat = new JTable();
        scrollPane = new JScrollPane();
        TitleLabel = new JLabel("Gestion des Projets ");

        addBtn = new JButton("Ajouter");

        updateBtn = new JButton("Modifier");

        deleteBtn = new JButton("Supprimer");
        HomeIcon = new JLabel();
        panelHome = new JPanel();
        HomeLabel = new JLabel("Home");

        dateDepartChooser = new JDateChooser();

        dureeSpin = new JSpinner();
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
        dateDepartLabel.setBounds(130, 210, 140, 43);
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

        lieuBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lieuBox.setBounds(295, 272, 217, 24);
        panel.add(lieuBox);

        etudiantBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        etudiantBox.setBounds(295, 323, 217, 24);
        panel.add(etudiantBox);

        tableProjetDoctorat.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
        tableProjetDoctorat.setFont(new Font("Segoe UI", 1, 12));
        tableProjetDoctorat.setModel(new javax.swing.table.DefaultTableModel(
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
                    {null, null, null, null, null}
                },
                new String[]{
                    "nom", "prenom", "email", "filiere", "niveau"
                }
        ));
        tableProjetDoctorat.setBounds(437, 55, 550, 262);
       

        scrollPane.setBounds(46, 391, 1066, 174);
        scrollPane.setViewportView(tableProjetDoctorat);
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
        addBtn.setBounds(569, 113, 124, 26);
        panel.add(addBtn);

        updateBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        updateBtn.setFont(new Font("Sitka Text", Font.PLAIN, 16));
        updateBtn.setForeground(new Color(0, 0, 0));
        updateBtn.setBounds(569, 168, 124, 26);
        panel.add(updateBtn);

        deleteBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deleteBtn.setFont(new Font("Sitka Text", Font.PLAIN, 16));
        deleteBtn.setForeground(new Color(0, 0, 0));
        deleteBtn.setBounds(569, 232, 124, 26);
        panel.add(deleteBtn);

        panelHome.setBounds(0, 1, 120, 49);
        panel.add(panelHome);
        panelHome.setOpaque(false);
        panelHome.setLayout(null);

        HomeIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        HomeIcon.setIcon(new ImageIcon(DoctoratFenetre.class.getResource("/Images/home.png")));
        HomeIcon.setBounds(10, 11, 49, 27);
        panelHome.add(HomeIcon);

        HomeLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        HomeLabel.setBounds(59, 19, 50, 15);
        panelHome.add(HomeLabel);

        dateDepartChooser.setBounds(295, 215, 217, 23);
        panel.add(dateDepartChooser);

        dureeSpin.setBounds(295, 166, 215, 23);
        panel.add(dureeSpin);
        
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
        
        // set the models :
         controlProjet.ShowIntableDoctorat(tableProjetDoctorat);
        etudiantBox.setModel(controlProjet.initializeModelDoctorant());
        lieuBox.setModel(controlProjet.initializeModelLab());

        setLocationRelativeTo(null);
        setTitle("Gestion des projets Doctorants");
        setVisible(true);
    }

    private void executer() {
  
      tableProjetDoctorat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getButton() == MouseEvent.BUTTON1) { // clique droite sur la souris
                    int indice = tableProjetDoctorat.getSelectedRow();
                    if (indice != - 1) {

                        String id = tableProjetDoctorat.getModel().getValueAt(indice, 0).toString();
                        Integer idProjet = Integer.parseInt(id);
                        Projets projet = controlProjet.getProjetById(idProjet);

                        lieuBox.setModel(controlProjet.initializeModelLab());

                        Laboratoire lab = controlLab.getLaboratoire((Integer) projet.getIDLab());
                        lieuBox.setSelectedItem(lab.getNom());

                        titreField.setText(projet.getTitre());
                        dureeSpin.setValue(projet.getDuree());
                        dateDepartChooser.setDate(projet.getDate_depart());
                        Etudiant etd = controlEtudiant.getEtudiantByID(projet.getIDEtudiant());

                        etudiantBox.setSelectedItem(etd.getID() + " " + etd.getNom() + " " + etd.getPrenom());
                    }
                } else if (evt.getButton() == MouseEvent.BUTTON3) { // clique gauche sur la souris
                    tableProjetDoctorat.clearSelection();  // Deselects all selected columns and rows.
                    vider();
                }
            }
        });
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
                String date = "";
                try {
                    date = sp.format(dateDepartChooser.getDate());
                } catch (Exception exp) {
                    JOptionPane.showMessageDialog(null, "le champ date de depart doit etre rempli :  \nla date actuelle sera choisie  par defaut !!  ", "Saisie date de depart du projet", JOptionPane.INFORMATION_MESSAGE);
                    dateDepartChooser.setCalendar(new GregorianCalendar()); // si champ date dep est vide ou mal saisie set date depart c est la  date actuelle par defaut 
                    date = sp.format(dateDepartChooser.getDate());
                }

                java.sql.Date d = java.sql.Date.valueOf(date);
                Calendar c = controlProjet.getCalender(date);
                String type = "Doctorat";
                Object idLab = null;

                if (lieuBox.getSelectedItem() != null) {
                    String lab = lieuBox.getSelectedItem().toString();
                    idLab = controlLab.getIdLaboratoireByName(lab);
                }
                // si il selectionne pas les radio type projet 
                // cela cause prob car combobox est null et  ne peut pas etre convertis tostring donc :
                String id_etudiant = "";
                Integer etd = -1;

                if (etudiantBox.getSelectedItem() != null) {
                    id_etudiant = etudiantBox.getSelectedItem().toString().split("\\s+")[0];
                    etd = Integer.parseInt(id_etudiant);
                }

                Projets projet = new Projets(type, titreField.getText(), (Integer) dureeSpin.getValue(), d, idLab, null, etd);
                if (controlProjet.addProjetDoctorat(projet, c)) {
                    controlProjet.ShowIntableDoctorat(tableProjetDoctorat);
                    vider();
                }

            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlProjet.deleteProjet(tableProjetDoctorat);
                controlProjet.ShowIntableDoctorat(tableProjetDoctorat);

                vider();

            }
        });
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");

                String date = "";
                try {
                    date = sp.format(dateDepartChooser.getDate());
                } catch (Exception exp) {
                    JOptionPane.showMessageDialog(null, "le champ date de depart doit etre rempli :  \nla date actuelle sera choisie  par defaut !!  ", "Saisie date de depart du projet", JOptionPane.INFORMATION_MESSAGE);
                    dateDepartChooser.setCalendar(new GregorianCalendar()); // si champ ddate dep est vide ou mal saisie set date depart c est la  date actuelle par defaut 
                    date = sp.format(dateDepartChooser.getDate());
                }

                java.sql.Date d = java.sql.Date.valueOf(date);

                //  Appliquer cet format a la date obtenue pat jDateChooser
                //***********************************************************************
                Calendar c = controlProjet.getCalender(date);
                String type = "Doctorat";
                Object idLab = null;

                if (lieuBox.getSelectedItem() != null) {
                    String lab = lieuBox.getSelectedItem().toString();
                    idLab = controlLab.getIdLaboratoireByName(lab);
                }
                // si il selectionne pas les radio type projet 
                // cela cause prob car combobox est null et  ne peut pas etre convertis tostring donc :
                String id_etudiant = "";
                Integer etd = -1;

                if (etudiantBox.getSelectedItem() != null) {
                    id_etudiant = etudiantBox.getSelectedItem().toString().split("\\s+")[0];
                    etd = Integer.parseInt(id_etudiant);
                }
                Projets projet = new Projets(type, titreField.getText(), (Integer) dureeSpin.getValue(), d, idLab, null, etd);
                if (controlProjet.updateProjetDoctorat(projet, tableProjetDoctorat, c)) {
                    controlProjet.ShowIntableDoctorat(tableProjetDoctorat);
                    vider();
                }

            }

        });

        HomeIcon.addMouseListener(new MouseAdapter() {
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

                    TableRowSorter tr = new TableRowSorter(tableProjetDoctorat.getModel());
                    tableProjetDoctorat.setRowSorter(tr);
                    tr.setRowFilter(RowFilter.regexFilter(filtre, 0, 1, 2,3,4,5));
                } catch (Exception ex) {

                }
            }
        });
      
    }

    private void vider() {
        titreField.setText("");
        dureeSpin.setValue(0);
        dateDepartChooser.setDate(null);

    }
}
