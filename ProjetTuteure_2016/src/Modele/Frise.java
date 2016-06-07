package Modele;

import java.io.File;
import java.io.Serializable;
import java.util.*;

import Outils.Comparateur;

/**
 * 
 */
public class Frise implements Serializable {

	/**
     * 
     */
    private String titre;

    /**
     * 
     */
    private TreeSet<Evenement> evenements;

    /**
     * 
     */
    private Date dateDebut;

    /**
     * 
     */
    private Date dateFin;

    /**
     * 
     */
    private int periode;

    /**
     * 
     */
    private File adresseFichier;


    /**
     * @param parTitre 
     * @param parDateDebut 
     * @param parDateFin 
     * @param parPeriode
     */
    public Frise(String parTitre, Date parDateDebut, Date parDateFin, int parPeriode) {
    	titre=parTitre;
    	dateDebut=parDateDebut;
    	dateFin=parDateFin;
    	periode=parPeriode;
    	evenements= new TreeSet<Evenement>(new Comparateur());
    }

    /**
     * @param parTitre 
     * @param parDate 
     * @param parAddresseImage 
     * @param parTexteDescriptif 
     * @param paePoids 
     * @return
     */
    public void ajouterEvenement(String parTitre, Date parDate, String parAddresseImage, String parTexteDescriptif, int parPoids) {
        Evenement evt = new Evenement(parTitre, parDate, parAddresseImage, parTexteDescriptif, parPoids);
        evenements.add(evt);
    }

    /**
     * @return
     */
    public Evenement recupererEvenements() {
        // TODO implement here
        return null;
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
	 * @return
	 */
	public TreeSet<Evenement> getEvenements() {
		return evenements;
	}

	/**
	 * 
	 * @param evenements
	 */
	public void setEvenements(TreeSet<Evenement> evenements) {
		this.evenements = evenements;
	}

	/**
	 * 
	 * @return
	 */
	public Date getDateDebut() {
		return dateDebut;
	}

	/**
	 * 
	 * @param dateDebut
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * 
	 * @return
	 */
	public Date getDateFin() {
		return dateFin;
	}

	/**
	 * 
	 * @param dateFin
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * 
	 * @return
	 */
	public int getPeriode() {
		return periode;
	}

	/**
	 * 
	 * @param periode
	 */
	public void setPeriode(int periode) {
		this.periode = periode;
	}
	/**
	 * 
	 * @return
	 */
	public File getAdresseFichier() {
		return adresseFichier;
	}
	/**
	 * 
	 * @param adresseFichier
	 */
	public void setAdresseFichier(File adresseFichier) {
		this.adresseFichier = adresseFichier;
	} 
}