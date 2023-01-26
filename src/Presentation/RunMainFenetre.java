package Presentation;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class RunMainFenetre {
    public static void main(String[] args) {
       
        LookAndFeelDesign();
        
        ControlleurAdministration control = new ControlleurAdministration();
        control.demarrer();
    }
    
    public static void LookAndFeelDesign(){
        try {
            // Look And Feel
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(RunMainFenetre.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
