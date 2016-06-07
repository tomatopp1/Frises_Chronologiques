package CreationMenu;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import CreationEvenement.FenetreCreationEvenement;
import Data.Data;
import Modele.Frise;
import Modele.Date;
import Modele.Evenement;

/**
 * 
 */
public class PanelFils extends JPanel implements MouseListener {
	
	/**
	 * 
	 */
	private JButton boutonSuivant=new JButton();

    /**
     * 
     */
    private JButton boutonPrecedent=new JButton();
    /**
     * 
     */
    private Frise frise;

    /**
     * 
     */
    private JLabel nomFichier;

    /**
     * 
     */
    private PanelEvenements panelEvenement;
    /**
     * 
     */
    private GridBagConstraints gbc;
    /**
     * 
     */
    private FenetreCreationEvenement evt;
    
    /**
     * 
     */
	private JTable table=new JTable();

	/**
	 * 
	 * @param parFrise
	 */
    public PanelFils(Frise parFrise) {
    	
    	setLayout(new GridBagLayout());
    	gbc = new GridBagConstraints();
    	
        frise=parFrise;
        final Font gras =new Font("Arial black",Font.PLAIN,20);
        nomFichier = new JLabel(parFrise.getTitre(), JLabel.CENTER);
        nomFichier.setFont(gras);
        gbc.gridy=0;
        gbc.gridx=0;
        gbc.fill = GridBagConstraints.BOTH;
        add(nomFichier,gbc);
        JScrollPane scroll = PanelTable();
        scroll.setPreferredSize(new Dimension(1000,450));
        JPanel panelTable = new JPanel();
        panelTable.add(scroll);
        gbc.gridy=2;
        gbc.weightx=1;
        gbc.weighty=1;
        add(panelTable,gbc);
        
        panelEvenement = null;
       
       
    }

    /**
     * 
     * @return
     */
    public JScrollPane PanelTable() {
        //JTable
        table.setModel(new ModeleTable(frise));
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
        table.setRowHeight(100);

        table.setDefaultRenderer(JLabel.class, new RendererTable());
        //JScrollPane
        JScrollPane scroll = new JScrollPane(table);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		table.addMouseListener(this);
		
		return scroll;
    }

    /**
     * 
     * @param column
     * @param rows
     * @return
     */
    public boolean verifieCaseVide(int column, int rows) {
        // TODO implement here
        return false;
    }

    /**
     * 
     */
	public void mouseClicked(MouseEvent e) {
		if (e.getSource()==table){
			if (e.getClickCount()==2){
			setEvt(new FenetreCreationEvenement(table.getSelectedColumn(),table.getSelectedRow(),frise, this));
			}
			if (e.getClickCount()==1)  {
				JTable table = (JTable) e.getSource();
				int rowIndex = table.getSelectedRow();
				int colIndex = table.getSelectedColumn();
				if (table.getValueAt(rowIndex, colIndex)!=null) {
					if(panelEvenement != null) {
						remove(panelEvenement);
					}
					panelEvenement = new PanelEvenements(frise, rowIndex, colIndex);
					gbc.gridx=0;
					gbc.gridy = 1;
					add(panelEvenement, gbc);
					updateUI();
				}
			}
		}
	}

	/**
	 * 
	 */
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 */
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 */
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	/**
	 * 
	 */
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 * @param parFrise
	 */
	public void setTable(Frise parFrise) {
        table.setModel(new ModeleTable(parFrise));
	}
	
	/**
	 * 
	 * @return
	 */
	public JTable getTable() {
        return table;
	}

	/**
	 * 
	 * @return
	 */
	public FenetreCreationEvenement getEvt() {
		return evt;
	}

	/**
	 * 
	 * @param evt
	 */
	public void setEvt(FenetreCreationEvenement evt) {
		this.evt = evt;
	}
}