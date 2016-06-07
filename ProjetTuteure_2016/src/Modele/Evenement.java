package Modele;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Evenement implements Serializable, Comparable<Evenement> {


    /**
     * 
     */
    private String titre;

    /**
     * 
     */
    private Date date;

    /**
     * 
     */
    private String adresseImage;

    /**
     * 
     */
    private String texteDescriptif;

    /**
     * 
     */
    private int poids;


    /**
     * @param parTitre 
     * @param parDate 
     * @param parAdresseImage 
     * @param parTexteDesciptif 
     * @param parPoids
     */
    public Evenement(String parTitre, Date parDate, String parAddresseImage, String parTexteDescriptif, int parPoids) {
        titre=parTitre;
        date=parDate;
        setAdresseImage(parAddresseImage);
        setTexteDescriptif(parTexteDescriptif);
        poids=parPoids;
    }

    /**
     * 
     * @return
     */
	public Date getDate() {
		return date;
	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * 
	 * @return
	 */
	public int getPoids() {
		return poids;
	}

	/**
	 * 
	 * @param poids
	 */
	public void setPoids(int poids) {
		this.poids = poids;
	}

	/**
	 * 
	 * @return
	 */
	public String getTitre() {
		return titre;
	}
	
	/**
	 * 
	 * @param titre
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}
	/**
	 * 
	 */
	public int compareTo (Evenement evt){
		int comparaison = (evt.getDate().compareTo(this.getDate()));
		if (comparaison ==0){
				comparaison = Integer.compare(evt.getPoids(), this.getPoids());
			}
		return comparaison;
	}

	/**
	 * 
	 * @return
	 */
	public String getAdresseImage() {
		return adresseImage;
	}

	/**
	 * 
	 * @param adresseImage
	 */
	public void setAdresseImage(String adresseImage) {
		this.adresseImage = adresseImage;
	}

	/**
	 * 
	 * @return
	 */
	public String getTexteDescriptif() {
		return texteDescriptif;
	}

	/**
	 * 
	 * @param texteDescriptif
	 */
	public void setTexteDescriptif(String texteDescriptif) {
		this.texteDescriptif = texteDescriptif;
	}
}