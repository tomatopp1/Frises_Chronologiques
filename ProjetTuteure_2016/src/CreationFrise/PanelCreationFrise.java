package CreationFrise;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.zone.ZoneRulesException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import CreationMenu.FenetreMere;
import CreationMenu.PanelFils;
import Modele.Date;
import Modele.Frise;
import Outils.MethodesFichiers;

/**
 * 
 */
public class PanelCreationFrise extends JPanel implements ActionListener{
	/**
	 * 
	 */
	 private JLabel etiqCreationFrise = new JLabel("Création Frise");
	 /**
	  * 
	  */
     private JLabel titre = new JLabel("Titre");
     /**
      * 
      */
     private JTextField zoneTexteTitre = new JTextField(10);
     /**
      * 
      */
     private JLabel etiqDates = new JLabel("Début-Fin     ");
     /**
      * 
      */
     private JTextField zoneTexteDebut = new JTextField(4);
     /**
      * 
      */
     private JTextField zoneTexteFin = new JTextField(4);
     /**
      * 
      */
     private JLabel periode = new JLabel("Période");
     /**
      * 
      */
     private JComboBox comboPeriode = new JComboBox();
     /**
      * 
      */
     private JButton boutonCreer;
     /**
      * 
      */
     private FenetreMere fenetreMere;
     /**
      * 
      */
     private FenetreCreationFrise fenetreCreation;
     /**
      * 
      */
     final Font gras =new Font("Arial black",Font.PLAIN,15);
    /**
     * Default constructor
     */
    public PanelCreationFrise(FenetreMere fMere, FenetreCreationFrise fCreation) {
    	fenetreMere = fMere;
    	fenetreCreation = fCreation;
    	boutonCreer=fMere.getBoutonCreationFrise();
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
       
        gbc.insets= new Insets(0, 0, 10, 0);
        gbc.gridx=2;
        etiqCreationFrise.setFont(gras);
        add(etiqCreationFrise,gbc);
        gbc.gridy=1;
        gbc.gridx=1;
        gbc.anchor=GridBagConstraints.LINE_START;
        add(titre,gbc);
        gbc.gridx=2;
        add(zoneTexteTitre,gbc);
        gbc.gridy=2;
        gbc.gridx=1;
        add(etiqDates,gbc);
        gbc.gridx=2;
        add(zoneTexteDebut,gbc);
        gbc.gridx=2;
        gbc.anchor=GridBagConstraints.LINE_END;
        add(zoneTexteFin,gbc);
        gbc.gridy=3;
        gbc.gridx=1;
        gbc.anchor=GridBagConstraints.LINE_START;
        add(periode,gbc);
        for(int i=1; i<=10; i++){
              if(i<10){
                    comboPeriode.addItem("0"+i);
              }
              else{
                    comboPeriode.addItem(10);
              }
              gbc.anchor=GridBagConstraints.LINE_END;
              gbc.gridx=2;
              add(comboPeriode,gbc);
        }
        gbc.gridy=4;
        gbc.gridx=3;
        add(boutonCreer,gbc);
        
        boutonCreer.addActionListener(this);
       
    }
    	

    /**
     * 
     */
    private JButton validation;

    /**
     * 
     */
    private String chemin;


    /**
     * 
     */
    public void panelCreationFrise() {
        // TODO implement here
    }
    
    /**
     * 
     * @return
     */
    public JButton getBouton (){
    	return boutonCreer;
    }

    /**
     * 
     */
	public void actionPerformed(ActionEvent parEvt) {
		if(parEvt.getSource()==boutonCreer){
			if (zoneTexteDebut.getText().isEmpty() || zoneTexteFin.getText().isEmpty() || zoneTexteTitre.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Certains champs ne sont pas renseignés", null, JOptionPane.ERROR_MESSAGE);
			}
			try {
				Date anneeDeb=new Date(1,1,Integer.parseInt(zoneTexteDebut.getText()));
				Date anneeFin=new Date(1,1,Integer.parseInt(zoneTexteFin.getText()));
				try {
					String titre = zoneTexteTitre.getText();
					int periode = Integer.parseInt(comboPeriode.getSelectedItem().toString());
					
					if (anneeDeb.getAnnee() < anneeFin.getAnnee()){
						
						JFileChooser fileChooser= new JFileChooser();
						int parcours = fileChooser.showSaveDialog(null);
						
						if(parcours==JFileChooser.APPROVE_OPTION){
							File fichierSelectionne = fileChooser.getSelectedFile();
							//System.out.println(fichierSelectionne.getAbsolutePath());
							File fichierSelected=new File (fichierSelectionne.getAbsolutePath()+".T&F");
							Frise frise = new Frise(titre, anneeDeb, anneeFin, periode);
							MethodesFichiers.ecriture(fichierSelected, frise);
							frise.setAdresseFichier(fichierSelected);
							try{
								PanelFils contentPane = new PanelFils(frise);
								fenetreMere.setContentPane (contentPane);
								contentPane.setBackground (new Color (250,250,250)); // couleur du fond
								fenetreCreation.dispose();
								contentPane.updateUI();
							}
							catch (Exception e){
								JOptionPane.showMessageDialog(null, "Erreur : Probleme rencontré pendant l'affichage du contenu", null, JOptionPane.ERROR_MESSAGE);
							}
						}
					}
					else
						JOptionPane.showMessageDialog(null, "La frise se termine avant de commencer", null, JOptionPane.ERROR_MESSAGE);	
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, "Probleme lors de l'enregistrement du fichier", null, JOptionPane.ERROR_MESSAGE);
				}
			}
			catch (Exception e){
				JOptionPane.showMessageDialog(null, "Date(s) non valide(s)", null, JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}