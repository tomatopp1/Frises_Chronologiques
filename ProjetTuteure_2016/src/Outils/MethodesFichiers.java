package Outils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Modele.Frise;

/**
 * 
 *
 */
public class MethodesFichiers {

    /**
     * 
     */
    private String cheminFichier;

   /**
    * 
    * @param parFichier
    * @return
    */
    public static Object lecture (File parFichier){
    	ObjectInputStream flux;
		Object objetLu = null;
		
		// ouverture fichier en lecture
		try {
			flux = new ObjectInputStream(new FileInputStream(parFichier));
			objetLu = (Object)flux.readObject();
			flux.close();
		}
		catch(ClassNotFoundException exc) {
			System.err.println(exc.toString());
			System.exit(-1);
		}
		catch(IOException exc) {
			System.err.println("Erreur lecture du fichier "+exc.toString());
			System.exit(-1);
		}
		
		return objetLu;
	}

    
   /**
    * 
    * @param parFichier
    * @param parFrise
    */
    public static void ecriture(File f, Object o) {
		ObjectOutputStream flux = null;
		
		// ouverture ficher en ecriture
		try {
			flux = new ObjectOutputStream(new FileOutputStream(f));
			flux.writeObject(o);
			flux.flush();
			flux.close();
		}
		catch(IOException exc) {
			System.err.println("Probleme a l'ecriture\n"+exc.toString());
			System.exit(-1);
		}
	}

}