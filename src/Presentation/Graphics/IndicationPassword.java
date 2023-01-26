
package Presentation.Graphics;

import Presentation.ControlleurAdministration;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class IndicationPassword extends JFrame {

    private JPanel contentPane;
    private JTextField nomText;
    private JLabel SasieLabel ;
    private JSeparator separator;
    private JButton genererbtn;

    private ControlleurAdministration control;

    public IndicationPassword(ControlleurAdministration control) {
        initialiser(control);
        dessiner();
        executer();
    }

    public void initialiser(ControlleurAdministration control) {
        contentPane = new JPanel();
         SasieLabel = new JLabel("Saisie votre username :");
        nomText = new JTextField();
        genererbtn = new JButton("Generer");
        separator = new JSeparator();
        this.control = control;
    }

    public void dessiner() {
               setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // pour ne pas fermer fenetre Logging aussi
            
                
		setBounds(100, 100, 558, 223);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	      
		SasieLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		SasieLabel.setBounds(27, 45, 192, 31);
		contentPane.add(SasieLabel);
		
		
		nomText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nomText.setBounds(229, 45, 294, 31);
		contentPane.add(nomText);
		nomText.setColumns(10);
		
		genererbtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		genererbtn.setToolTipText("Indication sur Mot de passe");
		genererbtn.setBounds(170, 120, 216, 31);
		contentPane.add(genererbtn);
		
		separator.setBounds(81, 98, 389, 8);
		contentPane.add(separator);
                
                setIconImage(Toolkit.getDefaultToolkit().getImage(IndicationPassword.class.getResource("/Images/help.png")));
		setResizable(false);
		
                setLocationRelativeTo(null);
                setVisible(true);
                setTitle("indication");
    }

    public void executer() {
        genererbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.getIndication(nomText.getText());
            }
        });
    }
}
