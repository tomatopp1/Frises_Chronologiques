package CreationEvenement;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.xml.sax.helpers.ParserFactory;

import CreationMenu.ModeleTable;
import CreationMenu.PanelFils;
import Modele.Date;
import Modele.Frise;
import Outils.MethodesFichiers;

/**
 * 
 */
public class PanelCreationEvenement extends JPanel implements ActionListener{

    /**
     * 
     */
	private JLabel etiqCreationEvt = new JLabel("Création d'un évènement");
	/**
	 * 
	 */
	private JLabel etiqTitre = new JLabel("Titre");
	/**
	 * 
	 */
	private JTextField zonetitre = new JTextField(15);
	/**
	 * 
	 */
	private JLabel etiqDate= new JLabel("Date");
	/**
	 * 
	 */
	private JComboBox comboJour = new JComboBox();
	/**
	 * 
	 */
	private JComboBox comboMois = new JComboBox();
	/**
	 * 
	 */
	private JTextArea zoneDescriptif = new JTextArea(10,30);
	/**
	 * 
	 */
	private JButton boutonParcourir = new JButton("Parcourir");
	/**
	 * 
	 */
	private JButton boutonCreerEvt = new JButton("Créer");
	/**
	 * 
	 */
	final Font gras =new Font("Arial black",Font.PLAIN,15);
    /**
     * 
     */
	private JButton validation;
    /**
     * 
     */
	private Frise frise;
    /**
     * 
     */
	private int annee;
    /**
     * 
     */
	private int poids;
    /**
     * 
     */
	private PanelFils panelFils;
    /**
     * 
     */
	private JFrame fenetre;
    /**
     * 
     */
	private String retour = null;
    
    /**
     * @param parAnnee 
     * @param parPoids 
     * @param parFenetre
     */
    public PanelCreationEvenement(int parAnnee, int parPoids, JFrame parFenetre, Frise parFrise, PanelFils parPanelFils) {
    	frise=parFrise;
    	fenetre=parFenetre;
    	panelFils = parPanelFils;
    	annee=parAnnee;
    	poids=parPoids;
    	//System.out.println(parAnnee);
    	//System.out.println(parPoids);
    	
    	setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(0, 0, 15, 0);
		gbc.gridx=3;
		etiqCreationEvt.setFont(gras);
		gbc.anchor = GridBagConstraints.CENTER;
		add(etiqCreationEvt, gbc);
		gbc.gridy=1;
		gbc.gridx=2;
		gbc.anchor = GridBagConstraints.CENTER;
		add(etiqTitre,gbc);
		gbc.gridx=3;
		add(zonetitre,gbc);
		gbc.gridy=2;
		gbc.gridx=2;
		add(etiqDate,gbc);
		gbc.gridx=3;
		gbc.anchor=GridBagConstraints.CENTER;

		zoneDescriptif.setLineWrap(true);
		zoneDescriptif.setWrapStyleWord(true);

		for(int i=1; i<=31; i++){
			if(i<10)
			{
				comboJour.addItem("0"+i);
				
			}
			else{
				comboJour.addItem(Integer.toString(i));
			}
		}
		add(comboJour,gbc);
		gbc.gridx=3;
		gbc.anchor=GridBagConstraints.LINE_END;
		for(int i=1; i<=12 ; i++){
			if(i<10){
				comboMois.addItem("0"+i);
			}
			else{
				comboMois.addItem(Integer.toString(i));
			}
			
		}
		add(comboMois,gbc);
		gbc.gridy=3;
		gbc.gridx=1;
		gbc.gridwidth=3;
		add(new JScrollPane(zoneDescriptif),gbc);
		gbc.gridwidth=1;
		gbc.gridy=4;
		gbc.gridx=3;
		gbc.insets = new Insets(0, 0, 30, 0);
		add(boutonParcourir,gbc);
		gbc.gridy=5;
		add(boutonCreerEvt,gbc);
		
		boutonCreerEvt.addActionListener(this);
		boutonParcourir.addActionListener(this);
    }
    
    /**
     * 
     * @return
     */
    public JButton getBoutonCreer(){
    	return boutonCreerEvt;
    }

    /**
     * 
     */
	public void actionPerformed(ActionEvent parEvt) {
		JFileChooser fileChooser;
		if(parEvt.getSource()==boutonParcourir){
			fileChooser= new JFileChooser();
			int parcours = fileChooser.showOpenDialog(null);
			
			if(parcours==JFileChooser.APPROVE_OPTION){
				fileChooser.getSelectedFile().getName();
				retour = fileChooser.getSelectedFile().getAbsolutePath();
			}
		}
		if(parEvt.getSource()==boutonCreerEvt){
			if (zonetitre.getText().isEmpty() || zoneDescriptif.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Certains champs ne sont pas renseignés", null, JOptionPane.ERROR_MESSAGE);
			}
			try{
				Date dateEvt = new Date(Integer.parseInt(comboJour.getSelectedItem().toString()), Integer.parseInt(comboMois.getSelectedItem().toString()), annee);
				//System.out.println(zonetitre.getText()+"\n"+dateEvt.toString()+"\n"+retour+"\n"+zoneDescriptif.getText()+"\n"+poids);
				frise.ajouterEvenement(zonetitre.getText().toString(), dateEvt, retour, zoneDescriptif.getText().toString(), poids);
				MethodesFichiers.ecriture(frise.getAdresseFichier(), frise);
				fenetre.dispose();
				panelFils.setTable(frise);
			}
			catch(Exception e){
				System.err.println(e);
				JOptionPane.showMessageDialog(null, "Veuillez renseigner le chemin de l'image", null, JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
