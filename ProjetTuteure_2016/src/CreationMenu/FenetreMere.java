package CreationMenu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileFilter;

import CreationFrise.FenetreCreationFrise;
import Modele.Evenement;
import Modele.Frise;
import Outils.MethodesFichiers;


/**
 * 
 */
public class FenetreMere extends JFrame implements ActionListener, WindowListener{

	/**
	 * 
	 */
    protected JButton boutonCreationFrise= new JButton("Créer");
    /**
     * 
     */
    private FenetreCreationFrise fenetreCreationFrise;
    /**
     * 
     */
    private JPanel contentPane;
    
	/**
     * Default constructor
     */
    public FenetreMere() {

		setDefaultCloseOperation (EXIT_ON_CLOSE); // ferme la fenetre quand on clic sur la croix		

		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		
		//partie menu pour création
		JMenuItem itemCreation = new JMenuItem("Créer une nouvelle frise");
		itemCreation.setActionCommand("creation");
		JMenu menuCreation = new JMenu("Création");
		menuCreation.add(itemCreation);
		menu.add(menuCreation);
		itemCreation.addActionListener(this);
		
		//partie menu pour ouvrir
		JMenuItem itemOuvrir = new JMenuItem("Ouvrir un fichier");
		itemOuvrir.setActionCommand("ouvrir");
		menuCreation.add(itemOuvrir);
		itemOuvrir.addActionListener(this);
		
		//partie menu pour quitter
		JMenuItem itemQuitter= new JMenuItem("Quitter");
		itemQuitter.setActionCommand("quitter");
		itemQuitter.setMaximumSize(new Dimension(60, 20));
		itemQuitter.setMinimumSize(new Dimension(60, 20));
		itemQuitter.setPreferredSize(new Dimension(60, 20));
		menu.add(itemQuitter);
		itemQuitter.addActionListener(this);
		
		//partie menu pour aide 
		JMenuItem itemAide= new JMenuItem("?");
		itemAide.setActionCommand("aide");
		itemAide.setMaximumSize(new Dimension(15, 20));
		itemAide.setMinimumSize(new Dimension(15, 20));
		itemAide.setPreferredSize(new Dimension(15, 20));
		menu.add(itemAide);
		itemAide.addActionListener(this);
		
		
		
		
		setSize (1200,900); // definie la taille
		setVisible (true); // rend la fenetre visible
		setLocationRelativeTo(null);
		setBackground (new Color (0,250,0));
		
		this.addWindowListener(this);
	} // FenetreMere ()

    /**
     * 
     */
    private PanelFils panelFils;




    /**
     * 
     */
    public void fenetreMere() {
        // TODO implement here
    }
    
    /**
     * 
     * @param args
     */
    public static void main(String args[]){
    	new FenetreMere();
    }

    /**
     * 
     */
	public void actionPerformed(ActionEvent parEvt) {
		
		//creation
		if(parEvt.getActionCommand().equals("creation")){
			fenetreCreationFrise = new FenetreCreationFrise(this);
		}
		
		//quittage
		if(parEvt.getActionCommand().equals("quitter")){
			System.exit(0);
		}
		
		//ouverture
		if(parEvt.getActionCommand().equals("ouvrir")){
			JFileChooser fileChooser= new JFileChooser();
			fileChooser.addChoosableFileFilter(new FiltreFichier());
			fileChooser.setFileFilter(new FiltreFichier());
			int parcours = fileChooser.showOpenDialog(null);
			
			if(parcours==JFileChooser.APPROVE_OPTION){
				fileChooser.getSelectedFile().getName();
				File retour = fileChooser.getSelectedFile();
				//System.out.println(retour.getAbsolutePath());
				try {
					Frise frise = (Frise)MethodesFichiers.lecture(retour);
					contentPane = new PanelFils(frise);
					frise.setAdresseFichier(retour);
					this.setContentPane (contentPane);
					contentPane.setBackground (new Color (250,250,250)); // couleur du fond
					contentPane.updateUI();
				}
				catch (Exception e){
					JOptionPane.showMessageDialog(null, "Probleme rencontré lors de l'affichage du contenu", null, JOptionPane.ERROR_MESSAGE);
					System.err.println(e);
				}
			}
		}
		
	}
	
	/**
	 * 
	 * @return
	 */
	public JButton getBoutonCreationFrise(){
		return boutonCreationFrise;
	}

	/**
	 * 
	 */
	public void windowActivated(WindowEvent e) {
		if (fenetreCreationFrise!= null && fenetreCreationFrise.isVisible()){
			fenetreCreationFrise.requestFocus();
		}
	}

	/**
	 * 
	 */
	public void windowClosed(WindowEvent e) {
		
	}

	/**
	 * 
	 */
	public void windowClosing(WindowEvent e) {
		
	}

	/**
	 * 
	 */
	public void windowDeactivated(WindowEvent e) {
		
	}

	/**
	 * 
	 */
	public void windowDeiconified(WindowEvent e) {
		
	}

	/**
	 * 
	 */
	public void windowIconified(WindowEvent e) {
		
	}

	/**
	 * 
	 */
	public void windowOpened(WindowEvent e) {
		
	}
    

}