package Modele;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Date implements Serializable{

    /**
     * 
     */
    private int jour;

    /**
     * 
     */
    private int mois;

    /**
     * 
     */
    private int annee;

    /**
     * @param parJour 
     * @param parMois 
     * @param parAnnee
     */
    public Date(int parJour, int parMois, int parAnnee) {
        jour=parJour;
        mois=parMois;
        annee=parAnnee;
    }
    
    /**
     * 
     */
    public String toString(){
    	return jour+"/"+mois+"/"+annee;
    }

    /**
     * @param parAnnee
     */
    public void Date(int parAnnee) {
        // TODO implement here
    }

    /**
     * @param parMois 
     * @return
     */
    public String moisToString(int parMois) {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public Boolean dateValide() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public int compareTo(Date parDate) {
    	// retourne 0 si this et parDate sont égales, -1 si this précède parDate, 1 si parDate précède this
    	if (annee < parDate.annee)
    		return -1;
    	if (annee > parDate.annee)
    		return 1;
    	// les années sont =
    	if (mois < parDate.mois)
    		return -1;
    	if (mois > parDate.mois)
    		return 1;
    	// les mois sont =
    	if (jour < parDate.jour)
    		return -1;
    	if (jour > parDate.jour)
    		return 1;
    	return 0;
    }

    /**
     * @param parAnnee 
     * @return
     */
    public boolean estBissextile(int parAnnee) {
        // TODO implement here
        return false;
    }
    
    /**
     * 
     * @return
     */
    public int getAnnee(){
    	return annee;
    }
    /**
     * 
     * @return
     */
    public int getMois(){
    	return mois;
    }
    /**
     * 
     * @return
     */
    public int getJour(){
    	return jour;
    }

}