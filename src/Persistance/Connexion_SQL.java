
package Persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Connexion_SQL {
    Connection cn = null ; 
    public static Connection ConnectDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver"); // pilote
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/backoffice","root","");
            return cn ;
        }catch(ClassNotFoundException | SQLException e ){
            System.out.println("Connexion est Echouee");
            JOptionPane.showMessageDialog(null, "Connexion est echouee avec BD mySQL");
            return null ;
        }
    }
}

