/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistance.DAO;

import Metier.Etudiant;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author post21
 */
public interface InterfaceDAOEtudiant {
    ArrayList<Etudiant> getAll();
    Etudiant getEtudiantByID(Integer ID);
    void addEtudiant(Etudiant etd);
    void updateEtudiant(Etudiant AncienEtd , Etudiant newEtd);
    void deleteEtudiant(Integer ID );
    void ImprimerListeEtudiant(String chemin);
    void ShowIntable(JTable tableEtd);
}
