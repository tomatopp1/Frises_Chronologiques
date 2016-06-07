package CreationMenu;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Data.Data;
import Modele.Evenement;
import Modele.Frise;

/**
 * 
 */
public class PanelEvenements extends JPanel implements ActionListener {

    /**
     * 
     */
	private JButton boutonSuivant=new JButton(">");

    /**
     * 
     */
    private JButton boutonPrecedent=new JButton("<");
    /**
     * 
     */
    private Frise frise;
    /**
     * 
     */
    private int rowIndex;
    /**
     * 
     */
    private int colIndex ;
    /**
     * 
     */
    private JPanel panelCard;
    /**
     * 
     */
    private CardLayout layoutAfficheEvent;
	
    /**
     * Default constructor
     * @param colIndex 
     * @param rowIndex 
     */
    public PanelEvenements(Frise parFrise, int parRowIndex, int parColIndex) {
    	frise=parFrise;
    	colIndex=parColIndex;
    	rowIndex=parRowIndex;
    	JPanel panel = new JPanel();
    	JPanel panelEvent = panelCardEvenement();
    	panelEvent.setPreferredSize(new Dimension(400, 250));
    	panel.setLayout(new GridBagLayout());
    	GridBagConstraints gbc = new GridBagConstraints();
    	
    	gbc.gridx=0;
    	gbc.gridy = 0;
    	panel.add(boutonPrecedent,gbc);
    	boutonPrecedent.addActionListener(this);
    	boutonPrecedent.setActionCommand(Data.BOUTON_PRECEDENT);
    	gbc.gridx=1;    	gbc.fill=GridBagConstraints.BOTH;
    	panel.add(panelEvent,gbc);
    	gbc.gridx=2;    	gbc.fill=GridBagConstraints.NONE;
    	panel.add(boutonSuivant,gbc);
    	boutonSuivant.addActionListener(this);
    	boutonSuivant.setActionCommand(Data.BOUTON_SUIVANT);
    	add(panel,gbc);
    } 


    /**
     * @return
     */
    public JPanel panelCardEvenement() {
    	layoutAfficheEvent = new CardLayout();
    	panelCard = new JPanel ();
    	panelCard.setLayout(layoutAfficheEvent);
    	
    	Iterator<Evenement> iterateur = frise.getEvenements().iterator();
		while(iterateur.hasNext()){
			JPanel panel = new JPanel ();
			panel.setLayout(new BorderLayout());
			Evenement evtCourant = iterateur.next();
			JLabel labelImage = new JLabel (new ImageIcon(new ImageIcon(evtCourant.getAdresseImage()).getImage().getScaledInstance(100, 125, Image.SCALE_SMOOTH)));
			labelImage.setPreferredSize(new Dimension(100, 100));
			labelImage.setMinimumSize(new Dimension(100, 100));
			labelImage.setMaximumSize(new Dimension(100, 100));
			JLabel labelContenu = new JLabel(texteHTML(evtCourant));
			panel.add(labelImage, BorderLayout.WEST);
			panel.add(labelContenu, BorderLayout.CENTER);

			panelCard.add(panel,evtCourant.getDate().getAnnee()-frise.getDateDebut().getAnnee()+"/"+(evtCourant.getPoids()-1));
		}
	layoutAfficheEvent.show(panelCard,colIndex+"/"+rowIndex);
	return panelCard;

    }
    
    /**
     * 
     * @param evenement
     * @return
     */
    public String texteHTML (Evenement evenement){
    	String html = "<html><h3>"+evenement.getTitre()+"</h3><h4>"+evenement.getDate().toString()+"</h4><p>";
    	StringTokenizer decoupe = new StringTokenizer(evenement.getTexteDescriptif(), " ");
    	int i =0;
    	while (decoupe.hasMoreTokens()){
    		if (i<12){
    			html = html+decoupe.nextToken()+" ";
    			i++;
    		}
    		else{
    			html = html+decoupe.nextToken();
    			i=0;
    		}
    	}
    	html = html+"</p></html>";
    	return html;
    }


    /**
     * 
     */
    public void actionPerformed(ActionEvent e) {
		String actionCommande = e.getActionCommand();
		if(actionCommande.equals(Data.BOUTON_PRECEDENT)) {
			layoutAfficheEvent.previous(panelCard);
		}
		else if(actionCommande.equals(Data.BOUTON_SUIVANT)) {
			layoutAfficheEvent.next(panelCard);
		}
		
	}
    

}