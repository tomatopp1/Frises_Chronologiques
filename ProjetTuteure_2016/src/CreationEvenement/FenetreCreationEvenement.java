package CreationEvenement;

import java.awt.Color;
import java.util.*;

import javax.swing.JFrame;

import CreationFrise.PanelCreationFrise;
import CreationMenu.PanelFils;
import Modele.Frise;

/**
 * 
 */
public class FenetreCreationEvenement extends JFrame {

    /**
     * 
     */
    private PanelCreationEvenement panelCreationEvenement;
    
    /**
     * Default constructor
     * @param panelFils 
     */
    public FenetreCreationEvenement(int parAnnee, int parPoids, Frise frise, PanelFils panelFils) {
    	PanelCreationEvenement contentPane = new PanelCreationEvenement(parAnnee+frise.getDateDebut().getAnnee(), parPoids+1, this, frise, panelFils);
		setContentPane (contentPane);
		contentPane.setBackground (new Color (250,250,250)); // couleur du fond
		setDefaultCloseOperation (DISPOSE_ON_CLOSE); // ferme la fenetre quand on clic sur la croix
		setSize (520,450); // definie la taille
		setVisible (true); // rend la fenetre visible
		setLocationRelativeTo(null);
		setBackground (new Color (0,250,0));
    }

}