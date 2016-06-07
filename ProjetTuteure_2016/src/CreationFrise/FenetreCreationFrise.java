package CreationFrise;

import java.awt.Color;

import javax.swing.JFrame;

import CreationMenu.FenetreMere;
import CreationMenu.PanelFils;

/**
 * 
 */
public class FenetreCreationFrise extends JFrame {

    /**
     * Default constructor
     */
    public FenetreCreationFrise(FenetreMere fMere) {
    	PanelCreationFrise contentPane = new PanelCreationFrise(fMere, this);
		setContentPane (contentPane);
		contentPane.setBackground (new Color (250,250,250)); // couleur du fond
		setDefaultCloseOperation (DISPOSE_ON_CLOSE); // ferme la fenetre quand on clic sur la croix
		setSize (520,450); // definie la taille
		setVisible (true); // rend la fenetre visible
		setLocationRelativeTo(null);
		setBackground (new Color (0,250,0));
    }

    /**
     * 
     */
    private PanelCreationFrise panelCreationFrise;


}