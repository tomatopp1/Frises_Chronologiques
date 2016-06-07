package Outils;

import java.io.Serializable;
import java.util.Comparator;

import Modele.Evenement;

public class Comparateur implements Comparator<Evenement>, Serializable{

	/**
	 * 
	 */
	public int compare(Evenement o1, Evenement o2) {
		return o1.compareTo(o2);
	}
}
