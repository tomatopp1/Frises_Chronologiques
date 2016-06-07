package CreationMenu;

import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import Modele.Evenement;
import Modele.Frise;

public class ModeleTable extends DefaultTableModel{
	/**
	 * 
	 * @param frise
	 */
	public ModeleTable(Frise frise){
		setColumnCount(frise.getDateFin().getAnnee()-frise.getDateDebut().getAnnee()+1);
		setRowCount(4);
		
		Object[] nomsCols = new Object[getColumnCount()];
		int anneeCourante = frise.getDateDebut().getAnnee();
		for(int index=0; index<nomsCols.length; index++){
			if((anneeCourante-frise.getDateDebut().getAnnee())%frise.getPeriode()==0){
				nomsCols[index]=Integer.toString(anneeCourante);
			}
			else{
				nomsCols[index]="";
			}
			anneeCourante++;
		}
		setColumnIdentifiers(nomsCols);
		
		Iterator<Evenement> iterateur = frise.getEvenements().iterator();
		while(iterateur.hasNext()){
			Evenement evt = iterateur.next();
			int numCol= evt.getDate().getAnnee()-frise.getDateDebut().getAnnee();
			int numLigne= evt.getPoids()-1;
			setValueAt(evt, numLigne, numCol);
		}
	}
	
	/**
	 * 
	 */
	public boolean isCellEditable(int row, int col){
		return false;
	}
	
	/**
	 * 
	 */
	public Class getColumnClass(int indiceColumn){
		return JLabel.class;
	}
}
