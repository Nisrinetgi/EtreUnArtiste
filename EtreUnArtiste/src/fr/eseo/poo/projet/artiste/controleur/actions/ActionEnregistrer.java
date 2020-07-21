package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;

import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;
import fr.eseo.poo.projet.artiste.xml.EnregistreurSVG;

public class ActionEnregistrer extends AbstractAction {

	public static final String NOM_ACTION = "Enregistrer";
	private PanneauDessin panneauDessin;

	public ActionEnregistrer(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}

	public void actionPerformed(ActionEvent event) {
		JFileChooser fichier = new JFileChooser();

		if (fichier.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			try {
				List<VueForme> dessin = new ArrayList<>();
				for (VueForme forme : this.panneauDessin.getVueFormes()) {
					dessin.add(forme);
				}
				EnregistreurSVG enregistreurSvg = new EnregistreurSVG();
				enregistreurSvg.enregistreDessin(fichier.getSelectedFile().getAbsolutePath(), dessin);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
