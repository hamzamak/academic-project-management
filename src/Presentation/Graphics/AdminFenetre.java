package Presentation.Graphics;

import Presentation.ControlleurAdministration;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import keeptoo.KGradientPanel;

public class AdminFenetre extends JFrame {

    ControlleurAdministration controlleur;
    private JTextField nomText;
    private JPasswordField passwordField;
    private JLabel NomLabel;
    private JLabel PassLabel;
    private JLabel BTnConnecter;
    private KGradientPanel gradientPrincipale;
    private KGradientPanel Gradient_SeConnecter;
    private JLabel MotPasseOublir;
    private JLabel AuthentLabel;
    private JLabel ImgLabel;
    private JLabel logo_ensa_label;
    private JSeparator separator;
    JLabel GestionLabelTitle;
    private JLabel Sous_titre;
    private JPanel panel;
    private JPanel panel_Saise;
    private  JComboBox typeBox ;
        JLabel metierLabel ;

    public AdminFenetre(ControlleurAdministration controlleur) {

        initialiser(controlleur);
        dessiner();
        executer();
    }

    public void initialiser(ControlleurAdministration controlleur) {
        this.controlleur = controlleur;
        panel = new JPanel();
        gradientPrincipale = new KGradientPanel();
        panel_Saise = new JPanel();
        NomLabel = new JLabel("Nom");
        nomText = new JTextField();
        PassLabel = new JLabel("Password");
        Gradient_SeConnecter = new KGradientPanel();
        BTnConnecter = new JLabel("Se Connecter");
        MotPasseOublir = new JLabel("Mot de passe Oublie ?");
        AuthentLabel = new JLabel("Authentification");
        passwordField = new JPasswordField();
        ImgLabel = new JLabel("");
        logo_ensa_label = new JLabel("Ensa  Khouribga");
        separator = new JSeparator();
        GestionLabelTitle = new JLabel("Gestions des Utilisateurs");
        Sous_titre = new JLabel("BackOffice");
    }

    public void dessiner() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout(0, 0));

        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        gradientPrincipale.setkEndColor(new Color(0, 0, 255));
        gradientPrincipale.kEndColor = new Color(0, 206, 209);
        gradientPrincipale.setkStartColor(new Color(255, 0, 255));
        gradientPrincipale.setBounds(0, 0, 1387, 791);
        panel.add(gradientPrincipale);
        gradientPrincipale.setLayout(null);

        panel_Saise.setBackground(new Color(224, 255, 255));
        panel_Saise.setBounds(676, 69, 446, 492);
        gradientPrincipale.add(panel_Saise);
        panel_Saise.setLayout(null);

        NomLabel.setForeground(new Color(0, 206, 209));
        NomLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        NomLabel.setBounds(42, 97, 101, 35);
        panel_Saise.add(NomLabel);

        nomText.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(30, 144, 255)));
        nomText.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        nomText.setBounds(42, 150, 361, 26);
        panel_Saise.add(nomText);
        nomText.setColumns(10);

        PassLabel.setForeground(new Color(0, 206, 209));
        PassLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        PassLabel.setBounds(42, 199, 101, 35);
        panel_Saise.add(PassLabel);

        Gradient_SeConnecter.setBounds(101, 382, 255, 35);
        panel_Saise.add(Gradient_SeConnecter);
        BTnConnecter.setForeground(new Color(230, 230, 250));
        BTnConnecter.setFont(new Font("Comic Sans MS", Font.ITALIC, 19));
        BTnConnecter.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Gradient_SeConnecter.add(BTnConnecter);

        MotPasseOublir.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        MotPasseOublir.setBounds(280, 431, 156, 29);
        MotPasseOublir.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panel_Saise.add(MotPasseOublir);
         typeBox = new JComboBox();
        typeBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        typeBox.setModel(new DefaultComboBoxModel(new String[]{"admin", "coordonnateur", "directeur du laboratoire", "professeur"}));
        typeBox.setBounds(199, 304, 204, 22);
        panel_Saise.add(typeBox);
       
        metierLabel = new JLabel("Type");
		metierLabel.setForeground(new Color(0, 206, 209));
		metierLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		metierLabel.setBounds(42, 304, 101, 22);
		panel_Saise.add(metierLabel);

        AuthentLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        AuthentLabel.setForeground(new Color(0, 206, 209));
        AuthentLabel.setHorizontalAlignment(SwingConstants.CENTER);
        AuthentLabel.setBounds(96, 34, 260, 44);
        panel_Saise.add(AuthentLabel);

        passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(30, 144, 255)));
        passwordField.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        passwordField.setBounds(42, 245, 361, 29);  
        panel_Saise.add(passwordField);

        ImgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LOGicone.png")));  // Image relative
        ImgLabel.setBounds(53, 293, 564, 268);
        gradientPrincipale.add(ImgLabel);

        logo_ensa_label.setForeground(new Color(128, 0, 128));
        logo_ensa_label.setFont(new Font("Comic Sans MS", Font.PLAIN, 37));
        logo_ensa_label.setBounds(53, 50, 387, 58);
        gradientPrincipale.add(logo_ensa_label);

        separator.setBounds(53, 119, 430, 2);
        gradientPrincipale.add(separator);

        GestionLabelTitle.setForeground(new Color(0, 206, 209));
        GestionLabelTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 37));
        GestionLabelTitle.setLabelFor(this);
        GestionLabelTitle.setBounds(53, 193, 440, 43);
        gradientPrincipale.add(GestionLabelTitle);

        Sous_titre.setFont(new Font("Tahoma", Font.PLAIN, 23));
        Sous_titre.setForeground(new Color(230, 230, 250));
        Sous_titre.setBounds(53, 247, 221, 32);
        gradientPrincipale.add(Sous_titre);

        setSize(1164, 642);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Authentification");
    }

    public void executer() {
        MotPasseOublir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                MotPasseOublir.setForeground(Color.BLUE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                MotPasseOublir.setForeground(Color.BLACK);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                controlleur.helpPassword();
            }
        });
        BTnConnecter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (controlleur.ConnecterControlle(nomText.getText(), passwordField.getText(),typeBox.getSelectedItem()
                .toString())) {
                    dispose();
                }

            }
        });

    }
}
