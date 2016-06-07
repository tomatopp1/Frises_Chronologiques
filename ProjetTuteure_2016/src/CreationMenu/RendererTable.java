package CreationMenu;

import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import Modele.Evenement;

public class RendererTable extends JLabel implements TableCellRenderer {

	/**
	 * 
	 */
	public RendererTable(){
		
	}

	/**
	 * 
	 */
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		if (value!=null){
			Evenement valeur = (Evenement)value;
			if (valeur.getAdresseImage()!=null){
				this.setIcon(new ImageIcon(new ImageIcon(valeur.getAdresseImage()).getImage().getScaledInstance(75, 100, Image.SCALE_SMOOTH)));
			}
			else {
				setText(valeur.getTitre());
			}
			return this;
		}
		return null;
	}
}
