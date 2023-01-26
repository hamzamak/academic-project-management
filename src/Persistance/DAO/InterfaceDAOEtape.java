/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistance.DAO;

import Metier.Etape;
import javax.swing.JTable;

/**
 *
 * @author pc
 */
public interface InterfaceDAOEtape {
    

    public int getIdProjet(int professeur) ;

    public boolean addEtape(Etape etape, boolean isEtapeDepart) ;

    public void deleteEtape(Integer id_etape) ;

    public boolean updateEtape(Integer id_etape, Etape etape, boolean isEtapeDepart) ;

    public void updateEtapeDepart(Integer id_projet, String etape_departe) ;

    public String getEtapeDepart(Integer id_projet) ;
    public void update_List_Etape_Depart_Pas_Defini(int id_projet) ;

    public void update_List_Etape_Depart(String etape_departe, int id_projet) ;

    public int getMax_Id_etape();

    public int getIdProfesseurFromEtape(int id_projet) ;

    public void ShowIntable(JTable tableEtape) ;
    public int getSomme_Duree_Etape(int id_projet) ;

    public Etape getEtapeByID(Integer id_etape) ;

}
