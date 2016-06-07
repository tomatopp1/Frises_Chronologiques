package CreationMenu;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class FiltreFichier extends FileFilter{

	/**
	 * 
	 */
	public boolean accept(File f) {
		if (f.isDirectory())
			return true;
		else 
			return f.getAbsolutePath().endsWith(".T&F");
	}

	/**
	 * 
	 */
	public String getDescription() {
		return ".T&F";
	}
	
}
